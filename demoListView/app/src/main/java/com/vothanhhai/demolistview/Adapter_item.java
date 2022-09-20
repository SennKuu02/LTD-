package com.vothanhhai.demolistview;

import android.content.Context;
import android.content.Intent;
import android.media.Image;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import org.w3c.dom.Text;

import java.util.List;

public class Adapter_item extends RecyclerView.Adapter<Adapter_item.UserViewHolder>{

    private Context mContext;
    private List<User> mListUser;


    public Adapter_item(Context context, List<User> mListUser) {
        this.mContext = context;
        this.mListUser = mListUser;
    }

    @NonNull
    @Override
    public UserViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.layoutitem, parent, false);
        return new UserViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull UserViewHolder holder, int position) {
        User user = mListUser.get(position);
        if (user == null) {
            return;
        }

        holder.imgAvatar.setImageResource(user.getResourceId());
        holder.tvten.setText(user.getTen());
        holder.tvmota.setText(user.getMota());

        holder.layoutItem.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                onClickGoToDetail(user);
            }


        });
    }
    private void onClickGoToDetail(User user) {
        Intent intent = new Intent(mContext, DetailActivity.class);
        Bundle bundle = new Bundle();
        bundle.putSerializable("object_user", user);
        intent.putExtras(bundle);
        mContext.startActivity(intent);
    }


    @Override
    public int getItemCount() {
        if (mListUser != null){
            return mListUser.size();
        }
        return 0;
    }

    public class UserViewHolder extends RecyclerView.ViewHolder {

        private RelativeLayout layoutItem;
        private ImageView   imgAvatar;
        private TextView    tvten;
        private TextView    tvmota;

        public UserViewHolder(@NonNull View itemView) {
            super(itemView);
            layoutItem = itemView.findViewById(R.id.layout_item);
            imgAvatar = itemView.findViewById(R.id.img_avatar);
            tvten = itemView.findViewById(R.id.tv_ten);
            tvmota = itemView.findViewById(R.id.tv_mota);
        }
    }
}
