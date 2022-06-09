package com.example.helloworld.Fragments;

import android.app.ProgressDialog;
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

import com.example.helloworld.Adapters.MatchesDataAdapter;
import com.example.helloworld.MainActivity;
import com.example.helloworld.ModelClass.MatchesModel;
import com.example.helloworld.R;
import com.google.firebase.FirebaseApp;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;
import java.util.HashMap;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link MatchesFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class MatchesFragment extends Fragment {

    private RecyclerView recycler_view;

    public ArrayList<MatchesModel> matchesModelArrayList;
    MatchesDataAdapter adp;

    private ProgressDialog progressDialog;






    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

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


        progressDialog = new ProgressDialog(getActivity());
        progressDialog.setTitle("Please wait...");
        progressDialog.setMessage("Your data is being loaded.");
        progressDialog.setCanceledOnTouchOutside(false);


        StrictMode.ThreadPolicy policy = new StrictMode.ThreadPolicy.Builder().permitAll().build();
        StrictMode.setThreadPolicy(policy);


        FirebaseApp.initializeApp(getActivity());


        recycler_view = (RecyclerView) view.findViewById(R.id.recycler_view);

        matchesModelArrayList = new ArrayList<>();

        recycler_view.setLayoutManager(new GridLayoutManager(getActivity(), 2));

        adp = new MatchesDataAdapter(getActivity(), matchesModelArrayList);
        recycler_view.setAdapter(adp);

        getUsersFromDb();

        return view;
    }

    private void getUsersFromDb() {

        progressDialog.show();

        FirebaseDatabase.getInstance().getReference("matches").addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                try {
                    HashMap<String, HashMap<String, String>> hashMap = (HashMap<String, HashMap<String, String>>) snapshot.getValue();
                    HashMap<String, String> child;
                    for (int i = 0; i < hashMap.size(); i++) {
                        child = hashMap.get(hashMap.keySet().toArray()[i]);

                        matchesModelArrayList.add(new MatchesModel(child.get("name"), child.get("imageUrl"),
                                child.get("uid"), String.valueOf(child.get("liked"))));

                        adp.notifyDataSetChanged();

                        progressDialog.cancel();

                    }
                } catch (Exception exception) {
                    Toast.makeText(getContext(), "Error 1: "+exception.getMessage(), Toast.LENGTH_SHORT).show();
                    progressDialog.cancel();
                }
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {
                Toast.makeText(getContext(), "Error 2: "+error.getMessage(), Toast.LENGTH_SHORT).show();
                progressDialog.cancel();
            }
        });
    }

}