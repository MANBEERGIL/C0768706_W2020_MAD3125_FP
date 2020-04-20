package adapter;

import android.app.AlertDialog;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.c0768706_w2020_mad3125_fp.R;

import java.util.ArrayList;

import models.Bill;
import models.Hydro;

public class BillAdapter  extends RecyclerView.Adapter<BillAdapter.BillViewHolder>{
    private ArrayList<Bill>arrayList;
    private Bill mBill;
    public BillAdapter(ArrayList<Bill> arrayList) {
        this.arrayList = arrayList;
    }

    @NonNull
    @Override
    public BillViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.bill_list,parent,false);
        BillViewHolder billViewHolder = new BillViewHolder(view);
        return billViewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull final BillAdapter.BillViewHolder holder, final int position) {
     Bill aBill = this.arrayList.get(position);
     holder.txt_billType.setText("Bill Type :" + aBill.getBillType());
     holder.bill_amount.setText("Bill Amount :" +aBill.getBillDate().toString());
     holder.itemView.setOnClickListener(new View.OnClickListener() {
         @Override
         public void onClick(View v) {
             Bill bill = arrayList.get(position);
             if (bill.getBillType().equals("Hydro")){
                 Hydro h = (Hydro)bill;
//               text

             }
         }
     });
    }

    @Override
    public int getItemCount() {
        return 0;
    }
    public class BillViewHolder extends RecyclerView.ViewHolder{
        TextView txt_billType;
        TextView bill_amount;

        public BillViewHolder(@NonNull View itemView) {
            super(itemView);
        }
    }
}
