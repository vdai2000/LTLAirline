package com.example.bookingfilght.Activity;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.os.Handler;
import android.widget.TextView;

import com.airbnb.lottie.LottieAnimationView;
import com.example.bookingfilght.Models.KhachHangDTO;
import com.example.bookingfilght.Models.PhieuDatVeDTO;
import com.example.bookingfilght.R;
import com.example.bookingfilght.api.KhachHangCallAPI;
import com.example.bookingfilght.api.PhieuDatVeAPI;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

import static com.example.bookingfilght.Activity.LoginActivity.MyUSER;

public class AnimationBookingActivity extends AppCompatActivity {

    TextView txtBooking;
    LottieAnimationView lottie;
    PhieuDatVeDTO result = new PhieuDatVeDTO();
    PhieuDatVeDTO itemBooking = new PhieuDatVeDTO();

    long idChuyenBay;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_animation_booking);

        txtBooking = findViewById(R.id.txtBooking);
        lottie = findViewById(R.id.lottie);

        txtBooking.animate().translationY(-1400).setDuration(2700).setStartDelay(0);
        lottie.animate().translationX(2000).setDuration(2000).setStartDelay(2900);

        itemBooking = getData();
        postAPIPhieuDatVe(itemBooking);

        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                if(itemBooking != null) {
                    Intent intent = new Intent(AnimationBookingActivity.this, TicketActivity.class);
                    intent.putExtra("idChuyenBay", idChuyenBay);
                    startActivity(intent);
                }
            }
        }, 5000);
    }

    private  PhieuDatVeDTO getData() {
        Intent intent = getIntent();
        long idVe = intent.getLongExtra("idVe", -1l);
        Double thanhTien = intent.getDoubleExtra("thanhTien", -1l);
        idChuyenBay = intent.getLongExtra("idChuyenBay", -1l);
        //        Get id cua khach hang tu session
        SharedPreferences sharedPreferences = getSharedPreferences(MyUSER, Context.MODE_PRIVATE);
        String name = sharedPreferences.getString("FullName", "null");
        Long id = sharedPreferences.getLong("id", -1);
        String phone = sharedPreferences.getString("PhoneNumber", "null");
        String cmnds = sharedPreferences.getString("CMND", "null");
        String email = sharedPreferences.getString("Email", "null");

        PhieuDatVeDTO dto = new PhieuDatVeDTO();

        dto.setCMND(cmnds);
        dto.setEmail(email);
        dto.setHoTen(name);
        dto.setSoDienThoai(phone);
        dto.setNguoiDatVe_id(id);
        dto.setRoleDatVe(2);
        dto.setVechuyenbayID(idVe);
        dto.setThanhTien(thanhTien);

        return dto;

    }

    private void postAPIPhieuDatVe(PhieuDatVeDTO phieuDatVeDTO) {
        PhieuDatVeAPI.callapi.postPhieuDatVeDto(phieuDatVeDTO).enqueue(new Callback<PhieuDatVeDTO>() {
            @Override
            public void onResponse(Call<PhieuDatVeDTO> call, Response<PhieuDatVeDTO> response) {
                result = response.body();
            }

            @Override
            public void onFailure(Call<PhieuDatVeDTO> call, Throwable t) {

            }
        });
    }
}