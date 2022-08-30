package com.winshelosl.instaapp.Adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.parse.ParseFile;
import com.winshelosl.instaapp.Post;
import com.winshelosl.instaapp.R;

import java.util.List;

public class PostsAdapterGrid extends RecyclerView.Adapter<PostsAdapterGrid.ViewHolder> {

    Context context;
    List<Post> posts;

    public PostsAdapterGrid(Context context, List<Post> posts) {
        this.context = context;
        this.posts = posts;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        View view = LayoutInflater.from(context).inflate(R.layout.postsgrid, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        Post post = posts.get(position);
        holder.bind(post);
    }


    @Override
    public int getItemCount() {
        return posts.size();
    }

    public void clear() {
        posts.clear();
        notifyDataSetChanged();
    }

    // Add a list of items -- change to type used
    public void addAll(List<Post> list) {
        posts.addAll(list);
        notifyDataSetChanged();
    }

    class ViewHolder extends RecyclerView.ViewHolder {
//
//        private TextView tvUserName;
//        private TextView tvDescription;
//        private ImageView imProfilePicture;
        private ImageView ivPost;

        public ViewHolder(@NonNull View itemView){
            super(itemView);

//            tvUserName = itemView.findViewById(R.id.tvUsername);
//            tvDescription = itemView.findViewById(R.id.tvDescription);
//            imProfilePicture = itemView.findViewById(R.id.imProfilePicture);
            ivPost = itemView.findViewById(R.id.ivPost);
        }

        public void bind(Post post) {

//            tvDescription.setText(post.getDescription());
//            tvUserName.setText(post.getUser().getUsername());
            ParseFile image = post.getImage();
            if (image != null) {
                Glide.with(context).load(image.getUrl()).fitCenter().into(ivPost);
            }
//3

            //Glide.with(context).load(pos).fitCenter().into(imProfilePicture);

        }
    }



}
