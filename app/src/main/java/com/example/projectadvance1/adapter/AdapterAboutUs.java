package com.example.projectadvance1.adapter;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.ViewFlipper;

import com.example.projectadvance1.AboutUs;
import com.example.projectadvance1.MainActivity;
import com.example.projectadvance1.R;
import com.example.projectadvance1.object.ContactAS;
import com.example.projectadvance1.object.ItemNotification;

import java.util.List;

public class AdapterAboutUs extends BaseAdapter {
    private AboutUs mContext;
    private int layout;
    private List<ContactAS> mContactAS;

    public AdapterAboutUs(AboutUs mContext, int layout, List<ContactAS> mContactAS) {
        this.mContext = mContext;
        this.layout = layout;
        this.mContactAS = mContactAS;
    }

    @Override
    public int getCount() {
        return mContactAS.size();
    }

    @Override
    public Object getItem(int i) {
        return null;
    }

    @Override
    public long getItemId(int i) {
        return 0;
    }

    public class ViewHolder{
        private TextView tvId, tvPhone, tvEmail, tvAboutUs;
        private ImageView imgBack;
        private ViewFlipper viewFlipper;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        ViewHolder holder;
        if (view == null) {
            holder = new ViewHolder();
            LayoutInflater inflater = (LayoutInflater) mContext.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            view = inflater.inflate(layout, null);

//            holder.tvId = view.findViewById(R.id.tv_Id_Notification);
            holder.tvPhone = view.findViewById(R.id.tv_phoneAboutUs);
            holder.tvEmail = view.findViewById(R.id.tv_emailAboutUs);
            holder.tvAboutUs = view.findViewById(R.id.tv_AboutUs);

            holder.imgBack = view.findViewById(R.id.img_backAU);
            holder.viewFlipper = view.findViewById(R.id.viewPlipperAboutUs);


            view.setTag(holder);
        } else {
            holder = (ViewHolder) view.getTag();
        }

        ContactAS contactAS = mContactAS.get(i);
//        holder.tvId.setText("ID" + notification.getIdNotification());
        holder.tvPhone.setText(contactAS.getPhoneAS());
        holder.tvEmail.setText(contactAS.getEmailAS());
        holder.tvAboutUs.setText(contactAS.getAboutUs());

        holder.imgBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(mContext, MainActivity.class);
                mContext.startActivity(intent);
            }
        });

        holder.viewFlipper.setFlipInterval(3000);
        holder.viewFlipper.setAutoStart(true);
        Animation animation_slide_in = AnimationUtils.loadAnimation(mContext,R.anim.slide_in_right);
        Animation animation_slide_out = AnimationUtils.loadAnimation(mContext,R.anim.slide_out_right);
        holder.viewFlipper.setInAnimation(animation_slide_in);
        holder.viewFlipper.setOutAnimation(animation_slide_out);

        return view;
    }
}
