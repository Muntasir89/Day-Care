package com.example.daycare.Activity;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.view.MenuItem;
import android.widget.Toast;

import com.example.daycare.Adapter.StuInfoAda;
import com.example.daycare.Model.StuModel;
import com.example.daycare.R;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.firestore.CollectionReference;
import com.google.firebase.firestore.DocumentSnapshot;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.firestore.QuerySnapshot;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class StudentAct extends AppCompatActivity {
    Toolbar toolbar;
    RecyclerView Student_Recy;
    StuInfoAda StuAdapObj;
    List<StuModel>StuList = new ArrayList<>();
    FirebaseFirestore objectFrestre = FirebaseFirestore.getInstance();
    CollectionReference StudentCol = objectFrestre.collection("Student");
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_stu);

        toolbar = (Toolbar) findViewById(R.id.toolbar);
        toolbar.setTitle("");
        setSupportActionBar(toolbar);

        getSupportActionBar().setHomeAsUpIndicator(R.drawable.ic_arrow_back);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setDisplayShowHomeEnabled(true);

        //For Recycler
        Student_Recy = findViewById(R.id.Student_Recy);
        Student_Recy.setHasFixedSize(true);
        Student_Recy.setLayoutManager(new LinearLayoutManager(this));

        LoadStudentList();

        //For Adapter
        StuAdapObj = new StuInfoAda(this, StuList);
        Student_Recy.setAdapter(StuAdapObj);
    }
    private void LoadStudentList(){
        StudentCol.get().addOnSuccessListener(new OnSuccessListener<QuerySnapshot>() {
            @Override
            public void onSuccess(QuerySnapshot queryDocumentSnapshots) {
                //Toast.makeText(StudentAct.this, "Data Loaded", Toast.LENGTH_SHORT).show();
                List<DocumentSnapshot> list = queryDocumentSnapshots.getDocuments();
                for(DocumentSnapshot d:list){
                    StuModel model = new StuModel(d.get("ImgLink").toString(),d.get("Name").toString(), d.get("Id").toString(), d.get("Contact").toString(), d.get("Class").toString());
                    StuList.add(model);
                }
                /*Collections.sort(CourseList, new Comparator<CourseModel>() {
                    @Override
                    public int compare(CourseModel obj1, CourseModel obj2) {
                        return obj1.getPriority().compareTo(obj2.getPriority());
                    }
                });*/
                StuAdapObj.notifyDataSetChanged();
            }
        }).addOnFailureListener(new OnFailureListener() {
            @Override
            public void onFailure(@NonNull Exception e) {
                Toast.makeText(StudentAct.this, "Failed to load data", Toast.LENGTH_SHORT).show();
            }
        });
    }
    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item){
        switch (item.getItemId()){
            case android.R.id.home://Previous Activity
                this.finish();
                return true;
        }
        return super.onOptionsItemSelected(item);
    }
}