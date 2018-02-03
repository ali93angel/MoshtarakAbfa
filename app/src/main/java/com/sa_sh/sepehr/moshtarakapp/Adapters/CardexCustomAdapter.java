package com.sa_sh.sepehr.moshtarakapp.Adapters;

import android.content.Context;
import android.content.Intent;
import android.graphics.Typeface;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.sa_sh.sepehr.moshtarakapp.Activities.LastBillActivity;
import com.sa_sh.sepehr.moshtarakapp.R;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Leon on 12/4/2017.
 */

public class CardexCustomAdapter extends BaseAdapter {
    public List<CardexList> cardexList = null;
    Context context;
    LayoutInflater layoutInflater;
    private ArrayList<CardexList> arrayList;

    public CardexCustomAdapter(Context context, List<CardexList> cardexList) {
        this.context = context;
        this.layoutInflater = LayoutInflater.from(context);
        this.cardexList = cardexList;
        this.arrayList = new ArrayList<CardexList>();
        this.arrayList.addAll(cardexList);
    }

    @Override
    public int getCount() {
        return cardexList.size();
    }

    @Override
    public CardexList getItem(int position) {
        return cardexList.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    public View getView(final int position, View view, ViewGroup parent) {
        final ViewHolder holder;
        view = null;
        holder = new ViewHolder();
        if (position % 2 == 0)
            view = layoutInflater.inflate(R.layout.item_cardex, null);
        else
            view = layoutInflater.inflate(R.layout.item_cardex_, null);
        holder.textViewDate = (TextView) view.findViewById(R.id.textViewDate);
        holder.textViewCost = (TextView) view.findViewById(R.id.textViewCost);
        holder.textViewUse = (TextView) view.findViewById(R.id.textViewUse);
        holder.textViewNote = (TextView) view.findViewById(R.id.textViewNote);

        Typeface typeface = Typeface.createFromAsset(context.getAssets(), "fonts/BYekan_3.ttf");
        holder.textViewNote.setTypeface(typeface);
        holder.textViewDate.setTypeface(typeface);
        holder.textViewCost.setTypeface(typeface);
        holder.textViewUse.setTypeface(typeface);

        holder.imageViewInfo = (ImageView) view.findViewById(R.id.imageViewInfo);

        final CardexList row_pos = cardexList.get(position);
        holder.textViewDate.setText(row_pos.getDate());
        holder.textViewCost.setText(row_pos.getCost());
        holder.textViewNote.setText(row_pos.getNote());
        holder.textViewUse.setText(row_pos.getUse());
        holder.imageViewInfo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
//                new goTo(context,LastBillActivity.class);
                Intent intent = new Intent(context, LastBillActivity.class);
                context.startActivity(intent);
            }
        });

        view.setTag(holder);
        return view;
    }

    //    public void filter(String charText) {
//        charText = charText.toLowerCase(Locale.getDefault());
//        cardexList.clear();
//        if (charText.length() == 0) {
//            cardexList.addAll(arrayList);
//        } else {
//            for (CardexList cl : arrayList) {
//                if (cl.getNote().toLowerCase(Locale.getDefault()).contains(charText)) {
//                    cardexList.add(cl);
//                }
//            }
//        }
//        notifyDataSetChanged();
//    }

//    public class goTo extends Activity {
//        public goTo(final Context context, final Class activity) {
//            runOnUiThread(new Runnable() {
//                @Override
//                public void run() {
//                    Intent intent = new Intent(context, activity);
//                    context.startActivity(intent);
//                    overridePendingTransition(R.anim.slide_up_info, R.anim.no_change);
//                }
//            });
//        }
//    }

    public static class CardexList {
        private String date, cost, use, note;

        public String getCost() {
            return cost;
        }

        public String getDate() {
            return date;
        }

        public String getNote() {
            return note;
        }

        public String getUse() {
            return use;
        }

        public CardexList(String cost, String date, String note, String use) {

            this.cost = cost;
            this.date = date;
            this.note = note;
            this.use = use;
        }
    }

    public class ViewHolder {
        TextView textViewDate;
        TextView textViewCost;
        TextView textViewUse;
        TextView textViewNote;
        ImageView imageViewInfo;
    }
}
