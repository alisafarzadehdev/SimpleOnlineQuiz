package com.alisafarzadeh.rejimghazaei.Fragment;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;

import androidx.cardview.widget.CardView;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.alisafarzadeh.rejimghazaei.QuizAndAwnserActivity;
import com.alisafarzadeh.rejimghazaei.R;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link ProfileUserFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class ProfileUserFragment extends Fragment implements View.OnClickListener {

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    public ProfileUserFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment ProfileUserFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static ProfileUserFragment newInstance(String param1, String param2) {
        ProfileUserFragment fragment = new ProfileUserFragment();
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
    CardView home_card,info_card,bmi_card,quiz_card;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view  = inflater.inflate(R.layout.fragment_profile_user, container, false);


        setfragment(new AboutFragment());
        home_card= view.findViewById(R.id.cardhome);
        info_card = view.findViewById(R.id.cardinfo);
        quiz_card= view.findViewById(R.id.cardsoal);
        bmi_card = view.findViewById(R.id.cardbmi);

        home_card.setOnClickListener(this);
        info_card.setOnClickListener(this);
        bmi_card.setOnClickListener(this);
        quiz_card.setOnClickListener(this);


        return view;

    }

    public void setfragment(Fragment fragment)
    {
        FragmentManager fff2 = getActivity().getSupportFragmentManager();
        FragmentTransaction tr2 = fff2.beginTransaction();
        tr2.hide(new SiteFragment());
        tr2.replace(R.id.frame_fragmentProfile,fragment);
        tr2.commit();
    }

    private void setclick(int id)
    {
        String colorclick="#bbffbb";
        String colornotclick="#ffffff";

        switch (id)
        {
            case R.id.cardhome:

                home_card.setBackgroundColor(Color.parseColor(colorclick));
                quiz_card.setBackgroundColor(Color.parseColor(colornotclick));
                bmi_card.setBackgroundColor(Color.parseColor(colornotclick));
                info_card.setBackgroundColor(Color.parseColor(colornotclick));

                break;

            case R.id.cardinfo:

                home_card.setBackgroundColor(Color.parseColor(colornotclick));
                quiz_card.setBackgroundColor(Color.parseColor(colornotclick));
                bmi_card.setBackgroundColor(Color.parseColor(colornotclick));
                info_card.setBackgroundColor(Color.parseColor(colorclick));

                break;

            case R.id.cardbmi:
                home_card.setBackgroundColor(Color.parseColor(colornotclick));
                quiz_card.setBackgroundColor(Color.parseColor(colornotclick));
                bmi_card.setBackgroundColor(Color.parseColor(colorclick));
                info_card.setBackgroundColor(Color.parseColor(colornotclick));

             break;

            case R.id.cardsoal:

                home_card.setBackgroundColor(Color.parseColor(colornotclick));
                quiz_card.setBackgroundColor(Color.parseColor(colorclick));
                bmi_card.setBackgroundColor(Color.parseColor(colornotclick));
                info_card.setBackgroundColor(Color.parseColor(colornotclick));

             break;
        }
    }

    @Override
    public void onClick(View v) {
        switch (v.getId())
        {
            case R.id.cardhome:
                setclick(R.id.cardhome);
                setfragment(new HomeFragment());

                break;
            case R.id.cardinfo:
                setclick(R.id.cardinfo);

                setfragment(new AboutFragment());

                break;
            case R.id.cardsoal:
                setclick(R.id.cardsoal);
                Intent i = new Intent(getActivity(), QuizAndAwnserActivity.class);
                startActivity(i);

                break;
            case R.id.cardbmi:

                setclick(R.id.cardbmi);
                setfragment(new BmiFragment());

                break;
        }
    }
}