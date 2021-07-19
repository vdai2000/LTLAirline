package com.example.bookingfilght.Activity;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.bookingfilght.Models.ChuyenBayDTO;
import com.example.bookingfilght.R;
import com.google.android.material.textfield.TextInputEditText;

import static com.example.bookingfilght.Activity.LoginActivity.MyUSER;

public class InfoBookingActivity extends AppCompatActivity {

    Button btnBuy;
    TextView gioden, madi, giodi, maden, tv_hang, tv_slogan, ngay, tv_gia;
    TextInputEditText fullnameIF, emailIF, phoneIF, cmndIF;
    ChuyenBayDTO chuyenBayDTO;
    ImageView imageView2;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_info_booking);
        getData();
        mapping();
        loadData ();
        event();
        Toast.makeText(this, "Success", Toast.LENGTH_SHORT).show();
    }

    private void event(){
        btnBuy.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(InfoBookingActivity.this, AnimationBookingActivity.class);
                intent.putExtra("idVe", chuyenBayDTO.getIdVe());
                intent.putExtra("thanhTien", chuyenBayDTO.getThanhTien());
                intent.putExtra("idChuyenBay", chuyenBayDTO.getId());

                startActivity(intent);
            }
        });
    }

    private void getData() {
        Intent intent = getIntent();
        long idChuyenBay = intent.getLongExtra("idChuyenBay", -1l);
        for (ChuyenBayDTO item : ResultSearchActivity.arrayListCB) {
            long id = item.getId();
            if (id == idChuyenBay) {
                chuyenBayDTO = item;
                return;
            }
        }
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

    private void loadData () {
        //        Get id cua khach hang tu session
        SharedPreferences sharedPreferences = getSharedPreferences(MyUSER, Context.MODE_PRIVATE);
        String name = sharedPreferences.getString("FullName", "null");
        Long id = sharedPreferences.getLong("id", -1);
        String phone = sharedPreferences.getString("PhoneNumber", "null");
        String cmnds = sharedPreferences.getString("CMND", "null");
        String email = sharedPreferences.getString("Email", "null");

        fullnameIF.setText(name);
        emailIF.setText(email);
        phoneIF.setText(phone);
        cmndIF.setText(cmnds);

        gioden.setText(xuLyGio(chuyenBayDTO.getGio(), chuyenBayDTO.getThoiGianBay().intValue()));
        giodi.setText(chuyenBayDTO.getGio());
        maden.setText(chuyenBayDTO.getCodeSanDen());
        madi.setText(chuyenBayDTO.getCodeSanDi());
        ngay.setText(chuyenBayDTO.getNgay());
        imageView2.setImageResource(chuyenBayDTO.getImage());
        tv_gia.setText(chuyenBayDTO.getDonGia());
        tv_hang.setText(chuyenBayDTO.getHangVe());
        tv_slogan.setText("Happy");

    }

    private void mapping(){
        gioden = findViewById(R.id.gioden);
        madi = findViewById(R.id.madi);
        giodi = findViewById(R.id.giodi);
        maden = findViewById(R.id.maden);
        tv_hang = findViewById(R.id.tv_hang);
        tv_slogan = findViewById(R.id.tv_slogan);
        ngay = findViewById(R.id.ngay);
        tv_gia = findViewById(R.id.tv_gia);
        fullnameIF = findViewById(R.id.fullnameIF);
        emailIF = findViewById(R.id.emailIF);
        phoneIF = findViewById(R.id.phoneIF);
        cmndIF = findViewById(R.id.cmndIF);
        imageView2 = findViewById(R.id.imageView2);
        btnBuy = findViewById(R.id.btnbuy);
    }
}



















