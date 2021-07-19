package com.example.bookingfilght.Adapter;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.bookingfilght.Activity.AnimationBookingActivity;
import com.example.bookingfilght.Activity.TicketActivity;
import com.example.bookingfilght.Models.DataOuputHistory;
import com.example.bookingfilght.Models.PhieuDatVeDTO;
import com.example.bookingfilght.R;

import java.util.List;

public class AdapterHistoryTick extends BaseAdapter {

    List<PhieuDatVeDTO> datas;
    private Context context;
    private int layout;

    public AdapterHistoryTick(Context context, int layout, List<PhieuDatVeDTO> datas) {
        this.context = context;
        this.layout = layout;
        this.datas = datas;
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
        TextView ngayBayHistory, lotrinhHistory, giaHistory;
        Button btn_Booking;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        AdapterHistoryTick.ViewHoldel viewHoldel;

        if(convertView == null) {
            LayoutInflater layoutInflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            convertView = layoutInflater.inflate(layout, null);

            viewHoldel = new AdapterHistoryTick.ViewHoldel();

            //Mapping view
            viewHoldel.ngayBayHistory = (TextView) convertView.findViewById(R.id.ngaybayHistory);
            viewHoldel.lotrinhHistory = (TextView) convertView.findViewById(R.id.lotrinhHistory);
            viewHoldel.giaHistory = (TextView) convertView.findViewById(R.id.giaVeHistory);
            viewHoldel.btn_Booking = (Button) convertView.findViewById(R.id.btn_giaHistory);
            convertView.setTag(viewHoldel);
        } else {
            viewHoldel = (AdapterHistoryTick.ViewHoldel) convertView.getTag();
        }
        // Gan gia tri
        PhieuDatVeDTO phieuDatVeDTO = datas.get(position);

        viewHoldel.ngayBayHistory.setText(phieuDatVeDTO.getNgayDat());
        viewHoldel.lotrinhHistory.setText(phieuDatVeDTO.getTuyenBay());
        viewHoldel.giaHistory.setText(xuLyGia(phieuDatVeDTO.getThanhTien().intValue() + ""));
        viewHoldel.btn_Booking.setTag(1);


        View finalConvertView = convertView;
        viewHoldel.btn_Booking.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(finalConvertView.getContext(), TicketActivity.class);
                intent.putExtra("idChuyenBay", phieuDatVeDTO.getIdChuyenBay());
                context.startActivity(intent);
            }
        });
        return convertView;
    }

    public String xuLyGia(String gia)
    {
        int lenght = gia.length();
        int sl = lenght / 3;
        sl = 0 < lenght%3 ? sl:sl-1;
        int index = 3;
        for (int i = 1; i <= sl; i++)
        {
            gia = gia.substring(0, lenght - index) + "." + gia.substring(lenght - index);
            index = 3 + 3;
        }
        return gia;
    }
}
