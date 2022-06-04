package com.example.projectadvance1.adapter;

import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.projectadvance1.Notification;
import com.example.projectadvance1.object.ItemNotification;
import com.example.projectadvance1.R;
import com.squareup.picasso.Picasso;

import java.util.List;

public class AdapterNotification extends BaseAdapter {

    private Notification context;
    private int layout;
    private List<ItemNotification> notificationList;

    public AdapterNotification(Notification context, int layout, List<ItemNotification> notificationList) {
        this.context = context;
        this.layout = layout;
        this.notificationList = notificationList;
    }

    @Override
    public int getCount() {
        return notificationList.size();
    }

    @Override
    public Object getItem(int i) {
        return null;
    }

    @Override
    public long getItemId(int i) {
        return 0;
    }

    public class ViewHolder {
        private TextView tvId, tvTitle, tvDes, tvGio;
        private ImageView imgDelete, imgNotifi;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        ViewHolder holder;
        if (view == null) {
            holder = new ViewHolder();
            LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            view = inflater.inflate(layout, null);

//            holder.tvId = view.findViewById(R.id.tv_notifiID);
            holder.tvTitle = view.findViewById(R.id.tv_Title_Notification);
            holder.tvDes = view.findViewById(R.id.tv_Description_Notification);
            holder.tvGio = view.findViewById(R.id.tv_Date_Notification);
            holder.imgNotifi = view.findViewById(R.id.img_notification);

            holder.imgDelete = view.findViewById(R.id.img_delete_Notification);

            view.setTag(holder);
        } else {
            holder = (ViewHolder) view.getTag();
        }

        ItemNotification notification = notificationList.get(i);
//        holder.tvId.setText("ID" + notification.getIdNotification());
        holder.tvTitle.setText(notification.getTitleNotification());
        holder.tvDes.setText(notification.getDescriptionNotification());
        holder.tvGio.setText(notification.getDateNotification());
        Picasso.with(context).load(notification.getImgNotification()).into(holder.imgNotifi);


        // Delete
        holder.imgDelete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                delete(notification.getDescriptionNotification(), notification.getTitleNotification());
            }
        });

        return view;
    }

    private void delete (String name, String title) {
        AlertDialog.Builder builder = new AlertDialog.Builder(context);
        builder.setMessage("Ban co muon xoa thong bao " + name + " khong?");
        builder.setPositiveButton("Co", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                context.deleteNotification(title);
            }
        });
        builder.setNegativeButton("Khong", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {

            }
        });
        builder.show();
    }
}
