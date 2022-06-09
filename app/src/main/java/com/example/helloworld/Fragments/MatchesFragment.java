package com.example.helloworld.Fragments;

import static android.content.Context.MODE_PRIVATE;

import android.annotation.SuppressLint;
import android.app.ProgressDialog;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.os.StrictMode;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.swiperefreshlayout.widget.SwipeRefreshLayout;

import com.example.helloworld.Adapters.MatchesDataAdapter;
import com.example.helloworld.LocationClass.GpsTracker;
import com.example.helloworld.ModelClass.MatchesModel;
import com.example.helloworld.R;
import com.example.helloworld.RoomData.database.AppDatabase;
import com.example.helloworld.RoomData.database.AppExecutors;
import com.example.helloworld.RoomData.model.Person;
import com.google.firebase.FirebaseApp;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Objects;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link MatchesFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class MatchesFragment extends Fragment {

    public RecyclerView recycler_view;

    public ArrayList<MatchesModel> matchesModelArrayList;
    MatchesDataAdapter adp;

    public ProgressDialog progressDialog;

    SwipeRefreshLayout refreshLayout;

    public GpsTracker gpsTracker;

    public AppDatabase mDb;

    public double current_lat = 0;
    public double current_long = 0;
    public String maximum_distance;







    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    SharedPreferences prefs;

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    public MatchesFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment MatchesFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static MatchesFragment newInstance(String param1, String param2) {
        MatchesFragment fragment = new MatchesFragment();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_PARAM1);
            mParam2 = getArguments().getString(ARG_PARAM2);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_matches, container, false);


        mDb = AppDatabase.getInstance(getActivity());


        progressDialog = new ProgressDialog(getActivity());
        progressDialog.setTitle("Please wait...");
        progressDialog.setMessage("Your data is being loaded.");
        progressDialog.setCanceledOnTouchOutside(false);


        StrictMode.ThreadPolicy policy = new StrictMode.ThreadPolicy.Builder().permitAll().build();
        StrictMode.setThreadPolicy(policy);


        FirebaseApp.initializeApp(getActivity());


        recycler_view = (RecyclerView) view.findViewById(R.id.recycler_view);
        refreshLayout = (SwipeRefreshLayout) view.findViewById(R.id.refreshLayout);


        refreshLayout.setOnRefreshListener(new SwipeRefreshLayout.OnRefreshListener() {
            @Override
            public void onRefresh() {

                getDataFromRoom();
            }
        });


        matchesModelArrayList = new ArrayList<>();

        prefs = getActivity().getSharedPreferences("FIRST_TIME", MODE_PRIVATE);

        recycler_view.setLayoutManager(new GridLayoutManager(getActivity(), 2));

        adp = new MatchesDataAdapter(getActivity(), matchesModelArrayList);
        recycler_view.setAdapter(adp);

        getDataFromRoom();

        return view;
    }

    private void getUsersFromDb() {

//        progressDialog.show();

        gpsTracker = new GpsTracker(getActivity());
        if (gpsTracker.canGetLocation()) {
            final double[] latitude = {gpsTracker.getLatitude()};
            final double[] longitude = {gpsTracker.getLongitude()};

//            Toast.makeText(getActivity(), "Lat: " + latitude[0] + "\nLong: " + longitude[0],
//                    Toast.LENGTH_SHORT).show();



            matchesModelArrayList.clear();

            FirebaseDatabase.getInstance().getReference("matches").addListenerForSingleValueEvent(new ValueEventListener() {
                @SuppressLint("NotifyDataSetChanged")
                @Override
                public void onDataChange(@NonNull DataSnapshot snapshot) {
                    try {
                        HashMap<String, HashMap<String, String>> hashMap = (HashMap<String, HashMap<String, String>>) snapshot.getValue();
                        HashMap<String, String> child;
                        for (int i = 0; i < hashMap.size(); i++) {

                            child = hashMap.get(hashMap.keySet().toArray()[i]);


                            assert child != null;
                            double firebase_lat = Double.parseDouble(Objects.requireNonNull(child.get("lat")));
                            double firebase_long = Double.parseDouble(Objects.requireNonNull(child.get("longitude")));

                            double final_distance_between = getDistanceBetweenInMiles(latitude[0], longitude[0], firebase_lat, firebase_long);


                            if (maximum_distance.equalsIgnoreCase("0 - 5 miles"))
                            {
                                if (final_distance_between >= 0 && final_distance_between <= 5)
                                {
                                    matchesModelArrayList.add(new MatchesModel(child.get("name"), child.get("imageUrl"),
                                            child.get("uid"), String.valueOf(child.get("liked")),
                                            String.valueOf(child.get("lat")), String.valueOf(child.get("longitude"))));
                                }
                            }
                            else if (maximum_distance.equalsIgnoreCase("5 - 20 miles"))
                            {
                                if (final_distance_between > 5 && final_distance_between <= 20)
                                {
                                    matchesModelArrayList.add(new MatchesModel(child.get("name"), child.get("imageUrl"),
                                            child.get("uid"), String.valueOf(child.get("liked")),
                                            String.valueOf(child.get("lat")), String.valueOf(child.get("longitude"))));
                                }
                            }
                            else if (maximum_distance.equalsIgnoreCase("20 + miles"))
                            {
                                if (final_distance_between > 20)
                                {
                                    matchesModelArrayList.add(new MatchesModel(child.get("name"), child.get("imageUrl"),
                                            child.get("uid"), String.valueOf(child.get("liked")),
                                            String.valueOf(child.get("lat")), String.valueOf(child.get("longitude"))));
                                }
                            }
                            else {
                                matchesModelArrayList.add(new MatchesModel(child.get("name"), child.get("imageUrl"),
                                        child.get("uid"), String.valueOf(child.get("liked")),
                                        String.valueOf(child.get("lat")), String.valueOf(child.get("longitude"))));
                            }

                            adp.notifyDataSetChanged();

                            progressDialog.cancel();
                            refreshLayout.setRefreshing(false);

                        }
                    } catch (Exception exception) {
                        Toast.makeText(getContext(), "Error 1: "+exception.getMessage(), Toast.LENGTH_SHORT).show();
                        progressDialog.cancel();
                        refreshLayout.setRefreshing(false);
                    }
                }

                @Override
                public void onCancelled(@NonNull DatabaseError error) {
                    Toast.makeText(getContext(), "Error 2: "+error.getMessage(), Toast.LENGTH_SHORT).show();
                    progressDialog.cancel();
                    refreshLayout.setRefreshing(false);
                }
            });

        } else {
            progressDialog.cancel();
            gpsTracker.showSettingsAlert();
            refreshLayout.setRefreshing(false);
        }

    }

    public void getDataFromRoom()
    {

        progressDialog.show();

        if (!prefs.getBoolean("first_time", true)) {
            AppExecutors.getInstance().diskIO().execute(new Runnable() {
                @Override
                public void run() {
                    final Person persons_data = mDb.personDao().loadPersonById(1);

                    getActivity().runOnUiThread(new Runnable() {

                        @Override
                        public void run() {

//                            txt_reminder_time.setText(persons_data.getReminder_time());
//                            txt_dist_val.setText(persons_data.getMax_distance());
//                            txt_gender_val.setText(persons_data.getGender());
//                            txt_privacy_val.setText(persons_data.getAcc_privacy());
//                            txt_age_val.setText(persons_data.getAge_range());

                            maximum_distance = persons_data.getMax_distance();

                            getUsersFromDb();

                        }
                    });

                }
            });
        }
        else {
            maximum_distance = "0 - 5 miles";

            getUsersFromDb();
        }
    }

    public double getDistanceBetweenInMiles(double lat1, double lon1, double lat2, double lon2) {
        double theta = lon1 - lon2;
        double dist = Math.sin(deg2rad(lat1))
                * Math.sin(deg2rad(lat2))
                + Math.cos(deg2rad(lat1))
                * Math.cos(deg2rad(lat2))
                * Math.cos(deg2rad(theta));
        dist = Math.acos(dist);
        dist = rad2deg(dist);
        dist = dist * 60 * 1.1515;
        return (dist);
    }

    private double deg2rad(double deg) {
        return (deg * Math.PI / 180.0);
    }

    private double rad2deg(double rad) {
        return (rad * 180.0 / Math.PI);
    }

}