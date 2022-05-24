package com.example.daycare.Fragment;

import android.content.Intent;
import android.os.Bundle;

import androidx.cardview.widget.CardView;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.daycare.Activity.ContactAct;
import com.example.daycare.Activity.StudentAct;
import com.example.daycare.Activity.WriteNewsAct;
import com.example.daycare.R;
public class TeacherFrag extends Fragment {
    static Intent intent;
    CardView Student, Announcement, Contact, Note, Move;

    public TeacherFrag() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState){
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.teacher_frag, container, false);
        Student = view.findViewById(R.id.Student);
        Announcement = view.findViewById(R.id.Announcement);
        Contact = view.findViewById(R.id.Contact);
        Note = view.findViewById(R.id.Note);
        Move = view.findViewById(R.id.Move);

        Student.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view){
                intent = new Intent(getContext(), StudentAct.class);
                getContext().startActivity(intent);
            }
        });
        Announcement.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view){
                intent = new Intent(getContext(), WriteNewsAct.class);
                getContext().startActivity(intent);
            }
        });
        Contact.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view){
                intent = new Intent(getContext(), ContactAct.class);
                getContext().startActivity(intent);
            }
        });
        return view;
    }
}