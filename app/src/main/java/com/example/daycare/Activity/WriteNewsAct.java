package com.example.daycare.Activity;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.daycare.R;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.firestore.CollectionReference;
import com.google.firebase.firestore.FirebaseFirestore;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.Locale;
import java.util.Map;

public class WriteNewsAct extends AppCompatActivity {
    Toolbar toolbar;
    EditText WriteAccost, WriteDetails;
    Button PostNews;
    FirebaseFirestore objectFrestre = FirebaseFirestore.getInstance();
    CollectionReference NewsCol = objectFrestre.collection("News");
    //For Date
    private Calendar calendar;
    private SimpleDateFormat dateFormat;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_write);
        //For toolbar
        //For toolbar
        toolbar = (Toolbar) findViewById(R.id.toolbar);
        toolbar.setTitle("");
        setSupportActionBar(toolbar);
        getSupportActionBar().setHomeAsUpIndicator(R.drawable.ic_arrow_back);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setDisplayShowHomeEnabled(true);

        WriteAccost = findViewById(R.id.WriteAccost);
        WriteDetails = findViewById(R.id.WriteDetails);
        PostNews = findViewById(R.id.PostNews);

        //For the Date
        //dateFormat = new SimpleDateFormat("MM/dd/yyyy");
        //date = dateFormat.format(calendar.getTime());

        PostNews.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //Posting News
                PostingNews();
            }
        });
        //PostingNews();
    }

    private void PostingNews() {
        // Add a new document with a generated id.
        Map<String, Object>PostInfo = new HashMap<>();
        //Checking the accost and message is empty or not
        if(WriteAccost.getText().toString() != "" && WriteDetails.getText().toString() != "")
        {
            PostInfo.put("Accost", WriteAccost.getText().toString());
            PostInfo.put("Details", WriteDetails.getText().toString());
        }else{
            if(WriteAccost.getText().toString() == ""){
                PostInfo.put("Accost", "Hello Everyone");
                PostInfo.put("Details", WriteDetails.getText().toString());
            }else{
                Toast.makeText(this, "Please write the message!!!", Toast.LENGTH_SHORT).show();
                return;
            }
        }
        //For Date
        String date = new SimpleDateFormat("dd/MM/yyyy", Locale.getDefault()).format(new Date());
        PostInfo.put("Date", date);
        NewsCol.document().set(PostInfo).addOnSuccessListener(new OnSuccessListener<Void>() {
            @Override
            public void onSuccess(Void aVoid) {
                Toast.makeText(WriteNewsAct.this, "Successfully Posted!!!", Toast.LENGTH_SHORT).show();
                WriteAccost.setText("");
                WriteDetails.setText("");
            }
        }).addOnFailureListener(new OnFailureListener() {
            @Override
            public void onFailure(@NonNull Exception e) {
                Toast.makeText(WriteNewsAct.this, "Sorry! Something Went Wrong", Toast.LENGTH_SHORT).show();
                WriteAccost.setText("");
                WriteDetails.setText("");
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