package com.geekykel.cryptostats.recyclerview;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.geekykel.cryptostats.R;
import com.geekykel.data.models.CoinModel;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Geeky Kelvin on 6/22/2019.
 * Email: Kelvinator4leo@gmail.com
 */
public class MyCryptoAdapter extends RecyclerView.Adapter<MyCryptoAdapter.CoinViewHolder> {

    private static final String TAG = MyCryptoAdapter.class.getSimpleName();
    List<CoinModel> mItems = new ArrayList<>();
    public final String STR_TEMPLATE_NAME = "%s\t\t\t\t\t\t%s";
    public final String STR_TEMPLATE_PRICE = "%s$\t\t\t\t\t\t24H Volume:\t\t\t%s$";

    @Override
    public void onBindViewHolder(MyCryptoAdapter.CoinViewHolder holder, int position) {
        final CoinModel model = mItems.get(position);
        holder.tvNameAndSymbol.setText(String.format(STR_TEMPLATE_NAME, model.name, model.symbol));
        holder.tvPriceAndVolume.setText(String.format(STR_TEMPLATE_PRICE, model.priceUsd, model.volume24H));
        Glide.with(holder.ivIcon).load(model.imageUrl).into(holder.ivIcon);
    }

    @Override
    public MyCryptoAdapter.CoinViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        return new MyCryptoAdapter.CoinViewHolder(LayoutInflater.from(parent.getContext())
                .inflate(R.layout.list_item, parent, false));
    }

    @Override
    public int getItemCount() {
        return mItems.size();
    }

    public void setItems(List<CoinModel> items) {
        this.mItems.clear();
        this.mItems.addAll(items);
    }


    class CoinViewHolder extends RecyclerView.ViewHolder {

        TextView tvNameAndSymbol;
        TextView tvPriceAndVolume;
        ImageView ivIcon;

        public CoinViewHolder(View itemView) {
            super(itemView);
            tvNameAndSymbol = itemView.findViewById(R.id.tvNameAndSymbol);
            tvPriceAndVolume = itemView.findViewById(R.id.tvPriceAndVolume);
            ivIcon = itemView.findViewById(R.id.ivIcon);
        }
    }
}
