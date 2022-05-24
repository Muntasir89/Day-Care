package com.example.daycare.Adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.daycare.Model.StuModel;
import com.example.daycare.R;

import java.util.List;

public class ContactAda extends RecyclerView.Adapter<ContactAda.ContactViewHolder> {
    Context context;
    List<StuModel> ContactList;
    public ContactAda(Context cntxt, List<StuModel>list){
        context = cntxt;
        ContactList = list;
    }
    @NonNull
    @Override
    public ContactViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.contact_item, parent, false);
        return new ContactViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ContactViewHolder holder, int position) {
        holder.IdStu.setText("ID: "+ContactList.get(position).getIdStu());
        holder.ContactStu.setText("Contact: "+ContactList.get(position).getContactStu());
    }

    @Override
    public int getItemCount() {
        return ContactList.size();
    }

    public class ContactViewHolder extends RecyclerView.ViewHolder{
        TextView IdStu, ContactStu;
        public ContactViewHolder(@NonNull View itemView) {
            super(itemView);
            IdStu = itemView.findViewById(R.id.IdStu);
            ContactStu = itemView.findViewById(R.id.ContactStu);
        }
    }
}
