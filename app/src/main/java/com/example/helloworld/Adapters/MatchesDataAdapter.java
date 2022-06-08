package com.example.helloworld.Adapters;

import android.annotation.SuppressLint;
import android.content.ActivityNotFoundException;
import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.net.Uri;
import android.os.Build;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.RequiresApi;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;
import com.example.helloworld.ModelClass.MatchesModel;
import com.example.helloworld.R;

import java.util.List;

import de.hdodenhof.circleimageview.CircleImageView;


public class MatchesDataAdapter extends RecyclerView.Adapter<MatchesDataAdapter.RecyclerViewHolder> {

    private List<MatchesModel> mArrayList;
    private Context mContext;


    public MatchesDataAdapter(Context mContext, List<MatchesModel> ArrayList) {
        this.mArrayList = ArrayList;
        this.mContext = mContext;
    }


    public class RecyclerViewHolder extends RecyclerView.ViewHolder {

        CircleImageView civ_profile;
        TextView tv_name, tv_Sec_title;
        ImageView iv_banner;
        TextView tv_desc;
        ImageView iv_like;

        RecyclerViewHolder(View v) {
            super(v);

            civ_profile = v.findViewById(R.id.civ_profile);
            tv_name = v.findViewById(R.id.tv_name);
            tv_Sec_title = v.findViewById(R.id.tv_Sec_title);
            iv_banner = v.findViewById(R.id.iv_banner);
            tv_desc = v.findViewById(R.id.tv_desc);
            iv_like = v.findViewById(R.id.iv_like);

        }
    }

    @NonNull
    @Override
    public RecyclerViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.layout_item, parent, false);
        return new RecyclerViewHolder(view);
    }

    @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
    @Override
    public void onBindViewHolder(@NonNull final RecyclerViewHolder holder, @SuppressLint("RecyclerView") final int position) {

        holder.civ_profile.setImageResource(mArrayList.get(position).getProfile_image());
        holder.tv_name.setText(mArrayList.get(position).getTitle());
        holder.tv_Sec_title.setText(mArrayList.get(position).getSec_title());
        holder.iv_banner.setImageResource(mArrayList.get(position).getBanner_image());
        holder.tv_desc.setText(mArrayList.get(position).getDesc());

        holder.iv_like.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(mContext, "You liked "+mArrayList.get(position).getTitle(), Toast.LENGTH_LONG).show();

                holder.iv_like.setColorFilter(Color.argb(255, 255, 0, 0));
            }
        });
    }


    @Override
    public int getItemCount() {
        if (mArrayList != null)
            return mArrayList.size();
        return 0;
    }
}
