package com.example.helloworld.Adapters;

import android.annotation.SuppressLint;
import android.app.ProgressDialog;
import android.content.ActivityNotFoundException;
import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
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
import com.google.firebase.database.FirebaseDatabase;

import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.HashMap;
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

        TextView tv_name;
        ImageView iv_banner;
        ImageView iv_like;

        RecyclerViewHolder(View v) {
            super(v);

            tv_name = v.findViewById(R.id.tv_name);
            iv_banner = v.findViewById(R.id.iv_banner);
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

        holder.tv_name.setText(mArrayList.get(position).getTitle());


        URL url = null;
        try {
            url = new URL(mArrayList.get(position).getBanner_image_url());
        } catch (MalformedURLException e) {
            e.printStackTrace();
        }
        Bitmap bmp = null;
        try {
            bmp = BitmapFactory.decodeStream(url.openConnection().getInputStream());
        } catch (IOException e) {
            e.printStackTrace();
        }
        holder.iv_banner.setImageBitmap(bmp);


        if (mArrayList.get(position).getLiked().equalsIgnoreCase("true"))
        {
            holder.iv_like.setColorFilter(Color.argb(255, 255, 0, 0));
        }


        holder.iv_like.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(mContext, "You liked "+mArrayList.get(position).getTitle(), Toast.LENGTH_LONG).show();

                holder.iv_like.setColorFilter(Color.argb(255, 255, 0, 0));

                FirebaseDatabase.getInstance().getReference("matches").child(mArrayList.get(position).getUid()).child("liked")
                        .setValue(true).addOnSuccessListener(aVoid -> {
                    Toast.makeText(mContext.getApplicationContext(), "Updated Successfully", Toast.LENGTH_SHORT).show();
                });

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
