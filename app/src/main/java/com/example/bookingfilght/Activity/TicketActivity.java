package com.example.bookingfilght.Activity;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.example.bookingfilght.Models.ChuyenBayDTO;
import com.example.bookingfilght.Models.PhieuDatVeDTO;
import com.example.bookingfilght.R;
import com.example.bookingfilght.api.PhieuDatVeAPI;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

import static com.example.bookingfilght.Activity.LoginActivity.MyUSER;

public class TicketActivity extends AppCompatActivity {

    Button btnReturn;
    TextView gioDiVe, HangVe, ngayDiVe, KhanhHangVe, gioDenVe, GioDiVeDuoi, maDenVe, maDiVe, SanDenVe, SanDiVE;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ticket);
        mapping();
        event();
        loadData();
    }

    private void event(){
        btnReturn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(TicketActivity.this, DashBoard.class);
                startActivity(intent);
            }
        });
    }

    private ChuyenBayDTO getData() {
        Intent intent = getIntent();
        long idChuyenBay = intent.getLongExtra("idChuyenBay", -1l);

        for (ChuyenBayDTO item : LoginActivity.listCB) {
            if (item.getId() == idChuyenBay) {
                return item;
            }
        }
        return null;
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

    private void loadData() {
        //        Get id cua khach hang tu session
        SharedPreferences sharedPreferences = getSharedPreferences(MyUSER, Context.MODE_PRIVATE);
        String name = sharedPreferences.getString("FullName", "null");

        ChuyenBayDTO dto = getData();

        SanDiVE.setText(dto.getTenSanBayDi());
        SanDenVe.setText(dto.getTenSanBayDen());
        maDiVe.setText(dto.getCodeSanDi());
        maDenVe.setText(dto.getCodeSanDen());
        gioDiVe.setText(dto.getGio());
        gioDenVe.setText(xuLyGio(dto.getGio(), dto.getThoiGianBay().intValue()));
        KhanhHangVe.setText(name);
        ngayDiVe.setText(dto.getNgay());
        HangVe.setText(dto.getHangVe());
        GioDiVeDuoi.setText(dto.getGio());

    }

    private void mapping(){
        btnReturn = findViewById(R.id.btn_return);
        gioDiVe = findViewById(R.id.gioDiVe);
        HangVe = findViewById(R.id.HangVe);
        ngayDiVe = findViewById(R.id.ngayDiVe);
        KhanhHangVe = findViewById(R.id.KhanhHangVe);
        gioDenVe = findViewById(R.id.gioDenVe);
        maDenVe = findViewById(R.id.maDenVe);
        maDiVe = findViewById(R.id.maDiVe);
        SanDenVe = findViewById(R.id.SanDenVe);
        SanDiVE = findViewById(R.id.SanDiVE);
        GioDiVeDuoi = findViewById(R.id.GioDiVeDuoi);
    }
}