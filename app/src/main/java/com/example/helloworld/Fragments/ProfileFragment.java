package com.example.helloworld.Fragments;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.fragment.app.Fragment;

import com.example.helloworld.R;

import java.util.Objects;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link ProfileFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class ProfileFragment extends Fragment {

    TextView tv_name, tv_bio;
    TextView tv_username, tv_email, tv_mobile, tv_occupation, tv_age;




    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    public ProfileFragment() {
        // Required empty public constructor
    }

//    public ProfileFragment(String full_name, String email_addr, String bio,
//                           String user_name, String age, String occupation, String mobile) {
//        tv_name.setText(full_name);
//        tv_email.setText(email_addr);
//        tv_bio.setText(bio);
//        tv_username.setText(user_name);
//        tv_age.setText(age+" Years");
//        tv_occupation.setText(occupation);
//        tv_mobile.setText(mobile);
//    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment ProfileFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static ProfileFragment newInstance(String param1, String param2) {
        ProfileFragment fragment = new ProfileFragment();
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

//        tv_name = this.getView().findViewById(R.id.tv_name);
//        tv_bio = this.getView().findViewById(R.id.tv_bio);
//        tv_username = this.getView().findViewById(R.id.tv_username);
//        tv_email = this.getView().findViewById(R.id.tv_email);
//        tv_mobile = this.getView().findViewById(R.id.tv_mobile);
//        tv_occupation = this.getView().findViewById(R.id.tv_occupation);
//        tv_age = this.getView().findViewById(R.id.tv_age);
//        iv_back = this.getView().findViewById(R.id.iv_back);
//        iv_back = this.getView().findViewById(R.id.iv_back);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_profile, container, false);

        tv_name = view.findViewById(R.id.tv_name);
        tv_bio = view.findViewById(R.id.tv_bio);
        tv_username = view.findViewById(R.id.tv_username);
        tv_email = view.findViewById(R.id.tv_email);
        tv_mobile = view.findViewById(R.id.tv_mobile);
        tv_occupation = view.findViewById(R.id.tv_occupation);
        tv_age = view.findViewById(R.id.tv_age);

        Bundle data = getArguments();
        if (data != null)
        {
            tv_name.setText(data.getString("full_name"));
            tv_bio.setText(data.getString("email_addr"));
            tv_username.setText(data.getString("bio"));
            tv_email.setText(data.getString("user_name"));
            tv_mobile.setText(data.getString("age")+" Years");
            tv_occupation.setText(data.getString("occupation"));
            tv_age.setText(data.getString("mobile"));
        }

        return view;
    }





//    public void updateData(String full_name, String email_addr, String bio,
//                           String user_name, String age, String occupation, String mobile) {
//        tv_name.setText(full_name);
//        tv_email.setText(email_addr);
//        tv_bio.setText(bio);
//        tv_username.setText(user_name);
//        tv_age.setText(age+" Years");
//        tv_occupation.setText(occupation);
//        tv_mobile.setText(mobile);
//    }

}