package com.example.kidcomic.Adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.github.chrisbanes.photoview.PhotoView;
import com.example.kidcomic.R;
import com.squareup.picasso.Picasso;

import java.util.List;

public class MyViewPagerAdapter_test extends RecyclerView.Adapter<MyViewPagerAdapter_test.MyViewHolder> {

    Context context;
    List<String> imageLinks;
    LayoutInflater inflater;

    public MyViewPagerAdapter_test(Context context, List<String> imageLinks) {
        this.context = context;
        this.imageLinks = imageLinks;
        inflater = LayoutInflater.from(context);
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View image_layout = inflater.inflate(R.layout.view_pager_item,parent,false);
        return new MyViewHolder(image_layout);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {
        Picasso.get().load(imageLinks.get(position)).into((holder.page_image));
    }

    @Override
    public int getItemCount() {
        return imageLinks.size();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder {

        PhotoView page_image;

        public MyViewHolder(View image_layout) {
            super(image_layout);

            page_image = (PhotoView) image_layout.findViewById(R.id.page_image);
        }
    }
}
