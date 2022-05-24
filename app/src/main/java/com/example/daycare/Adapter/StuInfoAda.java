package com.example.daycare.Adapter;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.daycare.Model.StuModel;
import com.example.daycare.R;
import com.example.daycare.Util.ImageLoadUtil;

import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.List;

public class StuInfoAda extends RecyclerView.Adapter<StuInfoAda.StuViewHolder>{
    Context context;
    List<StuModel> StuList;
    int[] img_stu = {R.drawable.pic1, R.drawable.pic2, R.drawable.pic3, R.drawable.pic4, R.drawable.pic5,R.drawable.pic6, R.drawable.pic7, R.drawable.pic8, R.drawable.pic9, R.drawable.pic10,R.drawable.pic11, R.drawable.pic12, R.drawable.pic13, R.drawable.pic14,R.drawable.pic15,R.drawable.pic16,R.drawable.pic17,R.drawable.pic18,R.drawable.pic19,R.drawable.pic20,R.drawable.pic21,R.drawable.pic22,R.drawable.pic23};
    public StuInfoAda(Context cntxt, List<StuModel>list){
        context = cntxt;
        StuList = list;
    }

    @NonNull
    @Override
    public StuViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.student_item, parent, false);
        return new StuViewHolder(view);
    }
    @Override
    public void onBindViewHolder(@NonNull StuViewHolder holder, int position){
        holder.ImgStu.setImageResource(img_stu[position]);
        holder.NameStu.setText("Name: "+StuList.get(position).getNameStu());
        holder.IdStu.setText("ID: "+StuList.get(position).getIdStu());
        holder.ContactStu.setText("Contact: "+StuList.get(position).getContactStu());
        holder.ClassStu.setText("Class: "+StuList.get(position).getClassStu());
    }

    @Override
    public int getItemCount() {
        return StuList.size();
    }

    public class StuViewHolder extends RecyclerView.ViewHolder{
        ImageView ImgStu;
        TextView NameStu, IdStu, ContactStu, ClassStu;
        public StuViewHolder(@NonNull View itemView) {
            super(itemView);
            ImgStu = itemView.findViewById(R.id.ImgStu);
            NameStu = itemView.findViewById(R.id.NameStu);
            IdStu = itemView.findViewById(R.id.IdStu);
            ContactStu = itemView.findViewById(R.id.ContactStu);
            ClassStu = itemView.findViewById(R.id.ClassStu);
        }
    }
}
