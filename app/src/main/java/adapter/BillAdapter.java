package adapter;

import android.app.ActionBar;
import android.app.AlertDialog;
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
    private Bill mBill;
    TextView textView4;
    TextView textView5;
    TextView textView6;
    TextView textView7;
    TextView textView8;
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
     holder.billAmount.setText("Bill Amount :" +aBill.getBillDate().toString());
     holder.itemView.setOnClickListener(new View.OnClickListener() {
         @Override
         public void onClick(View v) {
             Bill bill = arrayList.get(position);
             if (bill.getBillType().equals("HYDRO")){
                 Hydro h = (Hydro)mBill;
                 textView4.setText("Agency Nmae :" +((Hydro) mBill).getAgencyName());
                 textView5.setText("Units Consumed :" +((Hydro) mBill).getUnitConsumed());
             }
             else if(bill.getBillType().equals("INTERNET")){
                 Internet i = (Internet)mBill;
                 textView4.setText("Provider Name:" +((Internet) mBill).getProviderName());
                 textView5.setText("Internet Usage:" +((Internet) mBill).getInternetGbUsed());
             }
             else if(bill.getBillType().equals("MOBILE")){
                 Mobile m = (Mobile)mBill;
                 textView4.setText("Manufacturer Name:"+ ((Mobile) mBill).getMobileManufacturerName());
                 textView5.setText("Plan Name:" +((Mobile) mBill).getPlanName());
                 textView6.setText("Mobile Number:" +((Mobile) mBill).getMobileNumber());
                 textView7.setText("Internet Used:" +((Mobile) mBill).getInternetGbUsed());
                 textView8.setText("Minures Used:"+((Mobile) mBill).getMinuteUsed());
             }
         }
     });
    }

    @Override
    public int getItemCount() {
        return 0;
    }
    public class BillViewHolder extends RecyclerView.ViewHolder{
        TextView billType;
        TextView billAmount;
        TextView bill_id;
        TextView textView4;
        TextView textView5;
        TextView textView6;
        TextView textView7;
        TextView textView8;
        public BillViewHolder(@NonNull View itemView) {
            super(itemView);
            billType = itemView.findViewById(R.id.textView1);
            billAmount = itemView.findViewById(R.id.textView2);
            bill_id = itemView.findViewById(R.id.textView3);
            textView4 = itemView.findViewById(R.id.textView4);
            textView5 = itemView.findViewById(R.id.textView5);
            textView6 = itemView.findViewById(R.id.textView6);
            textView7 = itemView.findViewById(R.id.textView7);
            textView8 = itemView.findViewById(R.id.textView8);

        }
    }
}
