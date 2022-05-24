package com.example.daycare.Fragment;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;

import androidx.cardview.widget.CardView;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.daycare.Activity.ShowNewsAct;
import com.example.daycare.R;

public class ParentFrag extends Fragment {
    static Intent intent;
    CardView ShowNews,SendEmail;

    public ParentFrag() {
        // Required empty public constructor
    }
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.parent_frag, container, false);

        ShowNews = view.findViewById(R.id.ShowNews);
        SendEmail = view.findViewById(R.id.SendEmail);

        ShowNews.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                intent = new Intent(getContext(), ShowNewsAct.class);
                getContext().startActivity(intent);
            }
        });
        SendEmail.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view){
                Intent intent = new Intent(Intent.ACTION_SENDTO, Uri.fromParts(
                        "mailto","iottraining16@gmail.com", null));
                intent.putExtra(Intent.EXTRA_SUBJECT, "subject");
                intent.putExtra(Intent.EXTRA_TEXT, "message");
                startActivity(Intent.createChooser(intent, "Choose an Email client :"));
            }
        });
        return view;
    }

}