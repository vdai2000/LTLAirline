package com.example.bookingfilght.Activity;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityOptionsCompat;

import android.app.ActivityOptions;
import android.app.Dialog;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import com.airbnb.lottie.LottieAnimationView;
import com.example.bookingfilght.MainActivity;
import com.example.bookingfilght.Models.ChuyenBayDTO;
import com.example.bookingfilght.Models.VeChuyenBayDTO;
import com.example.bookingfilght.R;
import com.example.bookingfilght.SearchFlight.AdapterFlight;
import com.example.bookingfilght.SearchFlight.FlightCallBack;

import java.util.ArrayList;
import java.util.List;

import androidx.core.util.Pair;

public class ResultSearchActivity extends AppCompatActivity implements FlightCallBack {

    ListView listView;
    LottieAnimationView lottie;
    public static ArrayList<ChuyenBayDTO> arrayListCB = new ArrayList<>();
    AdapterFlight adapter;
    ImageView back;
    TextView info_flight, ngay_di_r;
    Dialog dialog;

    //Data
    //List<ChuyenBayDTO> listCB = LoginActivity.listCB;
    List<VeChuyenBayDTO> listVCB = LoginActivity.listVCB;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_result_search);
        mapping();
        Intent intent = getIntent();
        String ngay_di = intent.getStringExtra("ngay_di");
        String noi_di = intent.getStringExtra("noi_di");
        String noi_den = intent.getStringExtra("noi_den");
        String chuoi = noi_di + "->" + noi_den;
        String loai_ve = intent.getStringExtra("loaive");
        arrayListCB = getData(ngay_di, noi_di, noi_den, loai_ve);
        info_flight.setText(chuoi);
        ngay_di_r.setText(ngay_di);
        dialog = new Dialog(this);

        if (arrayListCB.size() == 0) {
            dialog.setContentView(R.layout.dialog_error_notflight);

            Button btnoke = dialog.findViewById(R.id.btnoke);
            btnoke.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    dialog.dismiss();
                }
            });

            dialog.show();
        }
        else {
            adapter = new AdapterFlight(this, R.layout.item_flight, arrayListCB, this);
            listView.setAdapter(adapter);
        }

        back.setOnClickListener(v -> {
            finish();
        });
    }

    private ArrayList<ChuyenBayDTO> getData(String ngayDi, String noiDi, String noiDen, String loaiVe){
        ArrayList<ChuyenBayDTO> result = new ArrayList<>();
        for(ChuyenBayDTO item: LoginActivity.listCB) {
            if (item.getNgay().equals(ngayDi) && item.getTenSanBayDi().equals(noiDi) && item.getTenSanBayDen().equals(noiDen)) {
                for (VeChuyenBayDTO veItem : listVCB) {
//                    Boolean a1 = veItem.getChuyenBayID().toString().equals(item.getId().toString());
                    Boolean a1 = false;

                    long s1 = veItem.getChuyenBayID();
                    long s2 = item.getId();

                    if (s1 == s2) {
                        a1 = true;
                    }

                    Boolean a2 = a1;
                    Boolean b2 = veItem.getCodeHangVe().equals(loaiVe);
                    if (a1 && b2) {
//                        su ly gia
                        item.setDonGia(xuLyGia(veItem.getDonGia().intValue() + "") + " VNĐ");
//                        Check hang ve
                        if(item.getHangVe().equals("VietNamAirline")) {
                            item.setImage(R.drawable.vnairline);
                        }
                        else if(item.getHangVe().equals("BambooAirline")) {
                            item.setImage(R.drawable.bamboo);
                        } else {
                            item.setImage(R.drawable.vietjet);
                        }
                        item.setThanhTien(veItem.getDonGia());
                        item.setIdVe(veItem.getId());
                        result.add(item);
                    }
                }
            }
        }


        return result;
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


    private void mapping() {
        info_flight = findViewById(R.id.info_flight);
        ngay_di_r = findViewById(R.id.sbDi);
        listView = findViewById(R.id.listFlight);
        back =  findViewById(R.id.back);
        lottie = findViewById(R.id.lottie);
    }

    @Override
    public void onFlightItemClick(int pos,
                                  ImageView hangBay,
                                  TextView gioDi,
                                  TextView gioDen,
                                  TextView maDi,
                                  TextView maDen,
                                  TextView tenHang,
                                  TextView slogan,
                                  TextView gia, long idChuyenBay) {

        Intent intent = new Intent(ResultSearchActivity.this, InfoBookingActivity.class);
        intent.putExtra("idChuyenBay", idChuyenBay);

        Pair<View, String> a2 = Pair.create(hangBay, "ImgHangTN");
        Pair<View, String> a3 = Pair.create(gioDi, "GioDiTN");
        Pair<View, String> a4 = Pair.create(gioDen, "GioDenTN");
        Pair<View, String> a5 = Pair.create(maDi, "MaDiTN");
        Pair<View, String> a6 = Pair.create(maDen, "MaDenTN");
        Pair<View, String> a7 = Pair.create(tenHang, "HangTN");
        Pair<View, String> a8 = Pair.create(slogan, "sloganTN");
        Pair<View, String> a9 = Pair.create(gia, "giaTN");

        ActivityOptionsCompat optionsCompat = ActivityOptionsCompat.makeSceneTransitionAnimation(this, a2, a3, a4, a5, a6, a7, a8, a9);

        if (android.os.Build.VERSION.SDK_INT >= Build.VERSION_CODES.JELLY_BEAN) {
            startActivity(intent, optionsCompat.toBundle());
        } else
        {
            startActivity(intent);
        }

    }
}