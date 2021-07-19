package com.example.bookingfilght.SearchFlight;

import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

public interface FlightCallBack {

    void onFlightItemClick(int pos, ImageView hangBay, TextView gioDi,
                           TextView gioDen, TextView maDi, TextView maDen,
                           TextView tenHang, TextView slogan, TextView gia, long idChuyenBay);
}
