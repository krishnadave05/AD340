package com.example.helloworld.Fragments;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.helloworld.Adapters.MatchesDataAdapter;
import com.example.helloworld.ModelClass.MatchesModel;
import com.example.helloworld.R;

import java.util.ArrayList;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link MatchesFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class MatchesFragment extends Fragment {

    private RecyclerView recycler_view;

    public ArrayList<MatchesModel> matchesModelArrayList;






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


        recycler_view = (RecyclerView) view.findViewById(R.id.recycler_view);

        matchesModelArrayList = new ArrayList<>();

        matchesModelArrayList.add(new MatchesModel(R.drawable.profile_8, "Krishna Dave", "artist", R.drawable.banner_8, "So many of my smiles are because of you."));
        matchesModelArrayList.add(new MatchesModel(R.drawable.profile_9, "Pratik D", "astronaut", R.drawable.banner_9, "So grateful to be sharing my world with you."));
        matchesModelArrayList.add(new MatchesModel(R.drawable.profile_10, "Dharmesh G", "chef", R.drawable.banner_10, "No description is required at all."));
        matchesModelArrayList.add(new MatchesModel(R.drawable.profile_1, "Dhara P", "construction ", R.drawable.banner_1, "All your dreams can come true and I'll make sure of it."));
        matchesModelArrayList.add(new MatchesModel(R.drawable.profile_2, "Pranchi D", "firefighter", R.drawable.banner_2, "Live in the sunshine where you belong."));
        matchesModelArrayList.add(new MatchesModel(R.drawable.profile_3, "Kajal R", "doctor ", R.drawable.banner_3, "My life is better than my daydreams."));
        matchesModelArrayList.add(new MatchesModel(R.drawable.profile_4, "Masti Pande", "police", R.drawable.banner_4, "Sprinkling kindness everywhere I go."));
        matchesModelArrayList.add(new MatchesModel(R.drawable.profile_5, "Pink K", "firefighter", R.drawable.banner_5, "I love my followers more than life itself."));
        matchesModelArrayList.add(new MatchesModel(R.drawable.profile_6, "Minal G", "police", R.drawable.banner_6, "I am cool. As usual you know..."));
        matchesModelArrayList.add(new MatchesModel(R.drawable.profile_7, "Hasti H", "teacher", R.drawable.banner_7, "My life is better than my daydreams."));

        recycler_view.setLayoutManager(new GridLayoutManager(getActivity(), 2));

        MatchesDataAdapter adp =
                new MatchesDataAdapter(getActivity(), matchesModelArrayList);
        recycler_view.setAdapter(adp);


        return view;
    }
}