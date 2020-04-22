package adapter;

import android.app.ActionBar;
import android.app.AlertDialog;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.c0768706_w2020_mad3125_fp.R;

import java.text.BreakIterator;
import java.util.ArrayList;

import models.Bill;
import models.Hydro;
import models.Internet;
import models.Mobile;

public class BillAdapter  extends RecyclerView.Adapter<BillAdapter.BillViewHolder>{
    private ArrayList<Bill>arrayList;

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
     holder.bill_id.setText("Bill ID:" +aBill.getBillId());
     holder.billType.setText("Bill Type :" + aBill.getBillType());
     holder.billAmount.setText("Bill Amount : $" +aBill.getTotalBillAmount().toString());
    holder.textView4.setText("Bill Date  :"+aBill.getBillDate());
//        if (aBill.getBillType().equals("HYDRO")){
//            Hydro h = (Hydro)aBill;
//            holder. textView4.setText("Agency Nmae :" + h.getAgencyName());
//            holder. textView5.setText("Units Consumed :" +h.getUnitConsumed());
//        }
//        else if(aBill.getBillType().equals("INTERNET")){
//            Internet i = (Internet)aBill;
//            holder.  textView4.setText("Provider Name:" +i.getProviderName());
//            holder. textView5.setText("Internet Usage:" +i.getInternetGbUsed());
//        }
//        else if(aBill.getBillType().equals("MOBILE")){
//            Mobile m = (Mobile)aBill;
//            holder.textView4.setText("Manufacturer Name:"+ m.getMobileManufacturerName());
//            holder.textView5.setText("Plan Name:" +m.getPlanName());
//            holder. textView6.setText("Mobile Number:" +m.getMobileNumber());
//            holder.textView7.setText("Internet Used:" +m.getInternetGbUsed());
//            holder.textView8.setText("Minures Used:"+m.getMinuteUsed());
//        }
     holder.itemView.setOnClickListener(new View.OnClickListener() {
         @Override
         public void onClick(View v) {
             Bill bill = arrayList.get(position);
             Intent pIntent = new Intent(String.valueOf(holder.itemView.getContext()));
             holder.itemView.getContext().startActivity(pIntent);

         }
     });
    }

    @Override
    public int getItemCount() {
        return this.arrayList.size();
    }
    public class BillViewHolder extends RecyclerView.ViewHolder{
        TextView billType;
        TextView billAmount;
        TextView bill_id;
        TextView textView4;

        public BillViewHolder(@NonNull View itemView) {
            super(itemView);
            billType = itemView.findViewById(R.id.textView2);
            billAmount = itemView.findViewById(R.id.textView3);
            bill_id = itemView.findViewById(R.id.textView1);
            textView4 = itemView.findViewById(R.id.textView4);

        }
    }
}
