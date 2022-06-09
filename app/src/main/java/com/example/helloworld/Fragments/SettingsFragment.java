package com.example.helloworld.Fragments;

import static android.content.Context.MODE_PRIVATE;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import androidx.fragment.app.Fragment;

import com.example.helloworld.R;
import com.example.helloworld.RoomData.database.AppDatabase;
import com.example.helloworld.RoomData.database.AppExecutors;
import com.example.helloworld.RoomData.model.Person;
import com.google.android.material.bottomsheet.BottomSheetDialog;
import com.shawnlin.numberpicker.NumberPicker;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link SettingsFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class SettingsFragment extends Fragment {


    LinearLayout ll_reminder, ll_distance, ll_gender, ll_privacy, ll_age_range;

    TextView txt_reminder_time;
    TextView txt_dist_val;
    TextView txt_gender_val;
    TextView txt_privacy_val;
    TextView txt_age_val;

    public AppDatabase mDb;





    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // boolean first_or_not;
    SharedPreferences prefs;

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    public SettingsFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment SettingsFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static SettingsFragment newInstance(String param1, String param2) {
        SettingsFragment fragment = new SettingsFragment();
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
        View view = inflater.inflate(R.layout.fragment_settings, container, false);


        mDb = AppDatabase.getInstance(getActivity());


        BottomSheetDialog bottomSheetDialogReminder = new BottomSheetDialog(getActivity());
        View customLayoutreminder = LayoutInflater.from(getActivity()).inflate(R.layout.layout_reminder_dialog, null);
        bottomSheetDialogReminder.setContentView(customLayoutreminder);

        BottomSheetDialog bottomSheetDialogDistance = new BottomSheetDialog(getActivity());
        View customLayoutdistance = LayoutInflater.from(getActivity()).inflate(R.layout.layout_distance_dialog, null);
        bottomSheetDialogDistance.setContentView(customLayoutdistance);

        BottomSheetDialog bottomSheetDialogGender = new BottomSheetDialog(getActivity());
        View customLayoutgender = LayoutInflater.from(getActivity()).inflate(R.layout.layout_gender_dialog, null);
        bottomSheetDialogGender.setContentView(customLayoutgender);

        BottomSheetDialog bottomSheetDialogAccountPrivacy = new BottomSheetDialog(getActivity());
        View customLayoutaccountprivacy = LayoutInflater.from(getActivity()).inflate(R.layout.layout_account_privacy_dialog, null);
        bottomSheetDialogAccountPrivacy.setContentView(customLayoutaccountprivacy);

        BottomSheetDialog bottomSheetDialogAgeRange = new BottomSheetDialog(getActivity());
        View customLayoutagerange = LayoutInflater.from(getActivity()).inflate(R.layout.layout_age_select_dialog, null);
        bottomSheetDialogAgeRange.setContentView(customLayoutagerange);

        ll_reminder = view.findViewById(R.id.ll_reminder);
        ll_distance = view.findViewById(R.id.ll_distance);
        ll_gender = view.findViewById(R.id.ll_gender);
        ll_privacy = view.findViewById(R.id.ll_privacy);
        ll_age_range = view.findViewById(R.id.ll_age_range);

        txt_reminder_time = view.findViewById(R.id.txt_reminder_time);
        txt_dist_val = view.findViewById(R.id.txt_dist_val);
        txt_gender_val = view.findViewById(R.id.txt_gender_val);
        txt_privacy_val = view.findViewById(R.id.txt_privacy_val);
        txt_age_val = view.findViewById(R.id.txt_age_val);



        Button btn_submit_reminder_time = bottomSheetDialogReminder.findViewById(R.id.btn_submit_reminder_time);
        NumberPicker numberPicker = bottomSheetDialogReminder.findViewById(R.id.time_picker);

        Button btn_public = bottomSheetDialogAccountPrivacy.findViewById(R.id.btn_public);
        Button btn_private = bottomSheetDialogAccountPrivacy.findViewById(R.id.btn_private);

        Button btn_male = bottomSheetDialogGender.findViewById(R.id.btn_male);
        Button btn_female = bottomSheetDialogGender.findViewById(R.id.btn_female);

        Button btn_age_18_25 = bottomSheetDialogAgeRange.findViewById(R.id.btn_age_18_25);
        Button btn_age_25_35 = bottomSheetDialogAgeRange.findViewById(R.id.btn_age_25_35);
        Button btn_age_35_64 = bottomSheetDialogAgeRange.findViewById(R.id.btn_age_35_64);
        Button btn_age_64_plus = bottomSheetDialogAgeRange.findViewById(R.id.btn_age_64_plus);

        Button btn_dist_0_5 = bottomSheetDialogDistance.findViewById(R.id.btn_dist_0_5);
        Button btn_dist_5_20 = bottomSheetDialogDistance.findViewById(R.id.btn_dist_5_20);
        Button btn_dist_20_plus = bottomSheetDialogDistance.findViewById(R.id.btn_dist_20_plus);

        prefs = getActivity().getSharedPreferences("FIRST_TIME", MODE_PRIVATE);

        numberPicker.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(getActivity(), "cLICKED", Toast.LENGTH_LONG).show();
            }
        });

        btn_submit_reminder_time.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Toast.makeText(getActivity(), "Selected : "+numberPicker.getValue(), Toast.LENGTH_SHORT).show();

                txt_reminder_time.setText(numberPicker.getValue()+":00 Hrs.");
                bottomSheetDialogReminder.dismiss();

                updateDataToRoom();
            }
        });

        btn_public.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                txt_privacy_val.setText("Public");
                bottomSheetDialogAccountPrivacy.dismiss();

                updateDataToRoom();
            }
        });

        btn_private.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                txt_privacy_val.setText("Private");
                bottomSheetDialogAccountPrivacy.dismiss();

                updateDataToRoom();
            }
        });

        btn_male.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                txt_gender_val.setText("Male");
                bottomSheetDialogGender.dismiss();

                updateDataToRoom();
            }
        });

        btn_female.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                txt_gender_val.setText("Female");
                bottomSheetDialogGender.dismiss();

                updateDataToRoom();
            }
        });

        btn_age_18_25.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                txt_age_val.setText("18 - 25");
                bottomSheetDialogAgeRange.dismiss();

                updateDataToRoom();
            }
        });

        btn_age_25_35.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                txt_age_val.setText("25 - 35");
                bottomSheetDialogAgeRange.dismiss();

                updateDataToRoom();
            }
        });

        btn_age_35_64.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                txt_age_val.setText("35 - 64");
                bottomSheetDialogAgeRange.dismiss();

                updateDataToRoom();
            }
        });

        btn_age_64_plus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                txt_age_val.setText("64 +");
                bottomSheetDialogAgeRange.dismiss();

                updateDataToRoom();
            }
        });

        btn_dist_0_5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                txt_dist_val.setText("0 - 5 miles");
                bottomSheetDialogDistance.dismiss();

                updateDataToRoom();
            }
        });

        btn_dist_5_20.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                txt_dist_val.setText("5 - 20 miles");
                bottomSheetDialogDistance.dismiss();

                updateDataToRoom();
            }
        });

        btn_dist_20_plus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                txt_dist_val.setText("20 + miles");
                bottomSheetDialogDistance.dismiss();

                updateDataToRoom();
            }
        });




        ll_reminder.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                bottomSheetDialogReminder.show();
            }
        });

        ll_distance.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                bottomSheetDialogDistance.show();
            }
        });

        ll_gender.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                bottomSheetDialogGender.show();
            }
        });

        ll_privacy.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                bottomSheetDialogAccountPrivacy.show();
            }
        });

        ll_age_range.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                bottomSheetDialogAgeRange.show();
            }
        });



        getDataFromRoom();




        return view;
    }

    public void getDataFromRoom()
    {
        if (!prefs.getBoolean("first_time", true)) {
            AppExecutors.getInstance().diskIO().execute(new Runnable() {
                @Override
                public void run() {
                    final Person persons_data = mDb.personDao().loadPersonById(1);

                    getActivity().runOnUiThread(new Runnable() {

                        @Override
                        public void run() {

                            txt_reminder_time.setText(persons_data.getReminder_time());
                            txt_dist_val.setText(persons_data.getMax_distance());
                            txt_gender_val.setText(persons_data.getGender());
                            txt_privacy_val.setText(persons_data.getAcc_privacy());
                            txt_age_val.setText(persons_data.getAge_range());

                        }
                    });

                }
            });
        }
    }

    public void updateDataToRoom()
    {

        final Person person = new Person(
                txt_reminder_time.getText().toString(),
                txt_dist_val.getText().toString(),
                txt_gender_val.getText().toString(),
                txt_privacy_val.getText().toString(),
                txt_age_val.getText().toString());

        AppExecutors.getInstance().diskIO().execute(new Runnable() {
            @Override
            public void run() {

                if (prefs.getBoolean("first_time", true)) {
                    mDb.personDao().insertPerson(person);
                    SharedPreferences.Editor editor = getActivity().getSharedPreferences("FIRST_TIME", MODE_PRIVATE).edit();
                    editor.putBoolean("first_time", false);
                    editor.apply();
                }
                else {
                    person.setId(1);
                    mDb.personDao().updatePerson(person);
                }
            }
        });

    }

}