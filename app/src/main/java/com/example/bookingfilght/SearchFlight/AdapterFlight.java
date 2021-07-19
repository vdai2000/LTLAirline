package com.example.bookingfilght.SearchFlight;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.bookingfilght.Models.ChuyenBayDTO;
import com.example.bookingfilght.Models.DataOuputHistory;
import com.example.bookingfilght.R;

import java.util.ArrayList;
import java.util.List;

public class AdapterFlight extends BaseAdapter {

    List<ChuyenBayDTO> datas;
    private Context context;
    private int layout;
    FlightCallBack flightCallBack;

    public AdapterFlight(Context context, int layout, List<ChuyenBayDTO> datas, FlightCallBack flightCallBack) {
        this.context = context;
        this.layout = layout;
        this.datas = datas;
        this.flightCallBack = flightCallBack;
    }

    @Override
    public int getCount() {
        return datas.size();
    }

    @Override
    public Object getItem(int position) {
        return null;
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    // tránh render lại row trong view
    private class ViewHoldel {
        ImageView img, container;
        TextView tv_gioDi, tv_gioDen, tv_maDi, tv_maDen, tv_hang, tv_slogan, tv_gia;
        Button btn_Booking;
    }

    public String xuLyGio(String gio, int thoiGianBay) {
        String[] parts = gio.split(":");
        String hour = parts[0];
        int a = Integer.parseInt(hour) + thoiGianBay + 12;
        if(a >= 24) {
            a -= 24;
        }
        return a + ":" +  parts[1];
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        ViewHoldel viewHoldel;

        if(convertView == null) {
            LayoutInflater layoutInflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            convertView = layoutInflater.inflate(layout, null);

            viewHoldel = new ViewHoldel();

            //Mapping view
            viewHoldel.tv_gioDi = (TextView) convertView.findViewById(R.id.giodi);
            viewHoldel.tv_gioDen = (TextView) convertView.findViewById(R.id.gioden);
            viewHoldel.tv_maDi = (TextView) convertView.findViewById(R.id.madi);
            viewHoldel.tv_maDen = (TextView) convertView.findViewById(R.id.maden);
            viewHoldel.tv_hang = (TextView) convertView.findViewById(R.id.tv_hang);
            viewHoldel.tv_slogan = (TextView) convertView.findViewById(R.id.tv_slogan);
            viewHoldel.tv_gia = (TextView) convertView.findViewById(R.id.tv_gia);
            viewHoldel.btn_Booking = (Button) convertView.findViewById(R.id.btn_gia);
            viewHoldel.img = (ImageView) convertView.findViewById(R.id.imageView2);
            viewHoldel.container = (ImageView) convertView.findViewById(R.id.container);
            convertView.setTag(viewHoldel);
        } else {
            viewHoldel = (ViewHoldel) convertView.getTag();
        }
        // Gan gia tri
        ChuyenBayDTO chuyenBayDTO = datas.get(position);

        viewHoldel.tv_gioDi.setText(chuyenBayDTO.getGio());
        viewHoldel.tv_gioDen.setText(xuLyGio(chuyenBayDTO.getGio(), chuyenBayDTO.getThoiGianBay().intValue()));
        viewHoldel.tv_maDi.setText(chuyenBayDTO.getCodeSanDi());
        viewHoldel.tv_maDen.setText(chuyenBayDTO.getCodeSanDen());
        viewHoldel.tv_hang.setText(chuyenBayDTO.getHangVe());
        viewHoldel.tv_gia.setText(chuyenBayDTO.getDonGia());
        viewHoldel.btn_Booking.setTag(1);
        viewHoldel.img.setImageResource(chuyenBayDTO.getImage());



        viewHoldel.btn_Booking.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(viewHoldel.container != null || chuyenBayDTO.getCodeSanDi() == null ||
                        chuyenBayDTO.getCodeSanDen() == null ||chuyenBayDTO.getHangVe() == null ||
                        chuyenBayDTO.getDonGia() == null  || chuyenBayDTO.getImage() == null) {
                } else {
                    flightCallBack.onFlightItemClick(position, viewHoldel.img, viewHoldel.tv_gioDi,
                            viewHoldel.tv_gioDen, viewHoldel.tv_maDi, viewHoldel.tv_maDen,
                            viewHoldel.tv_hang, viewHoldel.tv_slogan, viewHoldel.tv_gia, chuyenBayDTO.getId());
                }
            }
        });
        Animation animation = AnimationUtils.loadAnimation(context, R.anim.list_animation);
        convertView.startAnimation(animation);
        return convertView;
    }
}
