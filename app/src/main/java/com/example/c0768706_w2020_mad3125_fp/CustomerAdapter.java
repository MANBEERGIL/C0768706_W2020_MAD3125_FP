package com.example.c0768706_w2020_mad3125_fp;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class CustomerAdapter extends RecyclerView .Adapter<CustomerAdapter.CustomerViewHolder>{
    ArrayList<Customer> customerArrayList;
    public CustomerAdapter(ArrayList<Customer> customerArrayList) {
        this.customerArrayList = customerArrayList;
    }

    @NonNull
    @Override
    public CustomerViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View mview = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.customer
                        ,parent
                        ,false);
        CustomerViewHolder c=new CustomerViewHolder(mview);


        return c;

    }

    @Override
    public void onBindViewHolder(@NonNull CustomerViewHolder holder, int position) {
        Customer mCountry=this.customerArrayList.get(position);
        holder.txtName.setText(mCountry.getCustomerName());

    }



    @Override
    public int getItemCount() {

        return this.customerArrayList.size();
    }

    public class CustomerViewHolder extends RecyclerView.ViewHolder {
        TextView txtName;


        public CustomerViewHolder(@NonNull View itemView) {
            super(itemView);
            txtName=itemView.findViewById(R.id.text_customer_name);

        }

    }
}
