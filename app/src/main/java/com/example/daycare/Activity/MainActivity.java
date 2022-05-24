package com.example.daycare.Activity;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;

import android.content.ActivityNotFoundException;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.MenuItem;
import android.widget.Toast;

import com.example.daycare.Fragment.ParentFrag;
import com.example.daycare.Fragment.TeacherFrag;
import com.example.daycare.R;
import com.google.android.material.navigation.NavigationView;

public class MainActivity extends AppCompatActivity {
    DrawerLayout drawerLayout;
    NavigationView navigationView;
    Toolbar toolbar;
    ActionBarDrawerToggle Toggle;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        toolbar = (Toolbar) findViewById(R.id.toolbar);
        toolbar.setTitle("Teacher");

        drawerLayout = (DrawerLayout) findViewById(R.id.drawer);
        navigationView = (NavigationView) findViewById(R.id.navigationView);


        Toggle = new ActionBarDrawerToggle(this, drawerLayout, toolbar, R.string.open, R.string.close);
        Toggle.setDrawerIndicatorEnabled(true);
        Toggle.syncState();
        drawerLayout.addDrawerListener(Toggle);

        //For Drawer Icon
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setHomeButtonEnabled(true);
        getSupportActionBar().setHomeAsUpIndicator(R.drawable.ic_menu);

        navigationView.setCheckedItem(R.id.Teacher);
        //Default Fragment As
        getSupportFragmentManager().beginTransaction().replace(R.id.content_main, new TeacherFrag()).commit();

        navigationView.setNavigationItemSelectedListener(new NavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                switch (item.getItemId()){
                    case R.id.Teacher:
                        if(!navigationView.getMenu().findItem(R.id.Teacher).isChecked()){
                            getSupportFragmentManager().beginTransaction().replace(R.id.content_main, new TeacherFrag()).commit();
                            toolbar.setTitle("Teacher");
                        }
                        navigationView.setCheckedItem(R.id.Teacher);
                        drawerLayout.closeDrawer(GravityCompat.START);
                        break;
                    case R.id.Parent:
                        if(!navigationView.getMenu().findItem(R.id.Parent).isChecked()){
                            getSupportFragmentManager().beginTransaction().replace(R.id.content_main, new ParentFrag()).commit();
                            toolbar.setTitle("Parent");
                        }
                        navigationView.setCheckedItem(R.id.Parent);
                        drawerLayout.closeDrawer(GravityCompat.START);
                        break;
                    case R.id.Email:
                        EmailMe();
                        drawerLayout.closeDrawer(GravityCompat.START);
                        break;
                    case R.id.RateApp:
                        RateApp();
                        drawerLayout.closeDrawer(GravityCompat.START);
                        break;
                    case R.id.ShareApp:
                        ShareApp();
                        drawerLayout.closeDrawer(GravityCompat.START);
                        break;
                }
                return true;
            }
        });
    }
    public void EmailMe(){
        Intent intent = new Intent(Intent.ACTION_SENDTO, Uri.fromParts(
                "mailto","u1604031@email.com", null));
        intent.putExtra(Intent.EXTRA_SUBJECT, "subject");
        intent.putExtra(Intent.EXTRA_TEXT, "message");
        startActivity(Intent.createChooser(intent, "Choose an Email client :"));
    }
    public void RateApp(){
        try{
            startActivity(new Intent(Intent.ACTION_VIEW, Uri.parse("market://details?id="+getPackageName())));
        }
        catch (ActivityNotFoundException e){
            startActivity(new Intent(Intent.ACTION_VIEW, Uri.parse("https://play.google.com/store/apps/details?id="+getPackageName())));
        }
    }
    public void ShareApp() {

    }
}