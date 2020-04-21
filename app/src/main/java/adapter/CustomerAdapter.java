package adapter;

import android.content.Intent;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import models.Customers;

import com.example.c0768706_w2020_mad3125_fp.R;
import ui.ShowBillDetailsActivity;

import java.util.ArrayList;

public class CustomerAdapter extends RecyclerView .Adapter<CustomerAdapter.CustomerViewHolder>{
    ArrayList<Customers> customerArrayList;


    public CustomerAdapter(ArrayList<Customers> customerArrayList) {
        this.customerArrayList = customerArrayList;
    }

    @NonNull
    @Override
    public CustomerViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View mview = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.customer
                        ,parent
                        ,false);
        CustomerViewHolder c =new CustomerViewHolder(mview);


        return c;

    }

    @Override
    public void onBindViewHolder(@NonNull final CustomerViewHolder holder, final int position) {
        Customers mCountry=this.customerArrayList.get(position);
        holder.txtName.setText(mCountry.getFullName());
        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                final Customers ab = customerArrayList.get(position);
                Toast.makeText(holder.itemView.getContext(),"Customer :  "+ab.getFirstName(),Toast.LENGTH_LONG).show();
                Log.d("CLICK","HELLO");

//            if(position ==0) {
             Intent intent = new Intent(holder.itemView.getContext(), ShowBillDetailsActivity.class);
               intent.putExtra("customer selected",position);
              holder.itemView.getContext().startActivity(intent);
//            }
            }
        });
    }

    @Override
    public int getItemCount() {

        return this.customerArrayList.size();
    }

    public static class CustomerViewHolder extends RecyclerView.ViewHolder {
        TextView txtName;


        public CustomerViewHolder(@NonNull View itemView) {
            super(itemView);
            txtName=itemView.findViewById(R.id.text_customer_name);

        }


    }
}
