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

import com.example.daycare.Adapter.NewsAda;
import com.example.daycare.Adapter.StuInfoAda;
import com.example.daycare.Model.NewsModel;
import com.example.daycare.Model.StuModel;
import com.example.daycare.R;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.firestore.CollectionReference;
import com.google.firebase.firestore.DocumentSnapshot;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.firestore.QuerySnapshot;

import java.util.ArrayList;
import java.util.List;

public class ShowNewsAct extends AppCompatActivity {
    Toolbar toolbar;
    RecyclerView NewsRecy;
    NewsAda NewsAdapObj;
    List<NewsModel> NewsList = new ArrayList<>();
    FirebaseFirestore objectFrestre = FirebaseFirestore.getInstance();
    CollectionReference NewsCol = objectFrestre.collection("News");
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_show_news);
        //For toolbar
        toolbar = (Toolbar) findViewById(R.id.toolbar);
        toolbar.setTitle("");
        setSupportActionBar(toolbar);
        getSupportActionBar().setHomeAsUpIndicator(R.drawable.ic_arrow_back);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setDisplayShowHomeEnabled(true);
        //For Recycler
        NewsRecy = findViewById(R.id.NewsRecy);
        NewsRecy.setHasFixedSize(true);
        NewsRecy.setLayoutManager(new LinearLayoutManager(this));

        LoadStudentList();

        //For Adapter
        NewsAdapObj = new NewsAda(this, NewsList);
        NewsRecy.setAdapter(NewsAdapObj);
    }

    private void LoadStudentList(){
        NewsCol.get().addOnSuccessListener(new OnSuccessListener<QuerySnapshot>() {
            @Override
            public void onSuccess(QuerySnapshot queryDocumentSnapshots) {
                //Toast.makeText(NewsAct.this, "Data Loaded", Toast.LENGTH_SHORT).show();
                List<DocumentSnapshot> list = queryDocumentSnapshots.getDocuments();
                for(DocumentSnapshot d:list){
                    NewsModel model = new NewsModel(d.get("Accost").toString(), d.get("Date").toString(), d.get("Details").toString());
                    NewsList.add(model);
                }
                /*Collections.sort(CourseList, new Comparator<CourseModel>() {
                    @Override
                    public int compare(CourseModel obj1, CourseModel obj2) {
                        return obj1.getPriority().compareTo(obj2.getPriority());
                    }
                });*/
                NewsAdapObj.notifyDataSetChanged();
            }
        }).addOnFailureListener(new OnFailureListener() {
            @Override
            public void onFailure(@NonNull Exception e) {
                Toast.makeText(ShowNewsAct.this, "Failed to load data", Toast.LENGTH_SHORT).show();
            }
        });
    }
    //For Backpress
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