package com.example.banglayoutube.adapters;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.banglayoutube.R;
import com.example.banglayoutube.models.YoutubeDataModel;

import java.util.ArrayList;

public class VideoPostAdapter extends RecyclerView.Adapter<VideoPostAdapter.YoutubePostHolder> {
    private ArrayList<YoutubeDataModel> dataSet;
    private Context mContext=null;

    public VideoPostAdapter(ArrayList<YoutubeDataModel> dataSet, Context mContext) {
        this.dataSet = dataSet;
        this.mContext = mContext;
    }

    @NonNull
    @Override
    public YoutubePostHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view= LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.youtube_post_layout,viewGroup,false);
        YoutubePostHolder postHolder=new YoutubePostHolder(view);
        return postHolder;
    }

    @Override
    public int getItemCount() {
        return 0;
    }

    @Override
    public void onBindViewHolder(@NonNull YoutubePostHolder holder, int position) {
        TextView textViewTitle=holder.textViewTitle;
        TextView textViewDes=holder.textViewDes;
        TextView  textViewDate=holder.textViewDate;
        ImageView imageViewThumb=holder.imageViewThumb;
        YoutubeDataModel obj=dataSet.get(position);
        textViewTitle.setText(obj.getTitle());
        textViewDes.setText(obj.getDescription());
        textViewDate.setText(obj.getPublishAt());


        //TODO : image will be download from URL


    }

    public static class YoutubePostHolder extends RecyclerView.ViewHolder{
        TextView textViewTitle;
        TextView textViewDes;
        TextView  textViewDate;
        ImageView imageViewThumb;

        public YoutubePostHolder(@NonNull View itemView) {
            super(itemView);
            this.textViewTitle=itemView.findViewById(R.id.titleTextView);
            this.textViewDes=itemView.findViewById(R.id.desTextView);
            this.textViewDate=itemView.findViewById(R.id.dateTextView);
            this.imageViewThumb=itemView.findViewById(R.id.thumbImageView);
        }
    }
}
