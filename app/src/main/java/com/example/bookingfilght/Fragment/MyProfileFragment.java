package com.example.bookingfilght.Fragment;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.example.bookingfilght.Activity.DashBoard;
import com.example.bookingfilght.Activity.LoginActivity;
import com.example.bookingfilght.Models.KhachHangDTO;
import com.example.bookingfilght.Models.PhieuDatVeDTO;
import com.example.bookingfilght.R;
import com.example.bookingfilght.api.KhachHangCallAPI;
import com.example.bookingfilght.api.PhieuDatVeAPI;
import com.google.android.material.textfield.TextInputEditText;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

import static com.example.bookingfilght.Activity.LoginActivity.MyUSER;

public class MyProfileFragment extends Fragment {


    TextView full_name, lastname, payment_total, booking_total;
    TextInputEditText full_name2, cmnd, mail, sdt;
    Button btnUpdate;
    List<PhieuDatVeDTO> listPDV = DashBoard.listPDV;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        ViewGroup root = (ViewGroup) inflater.inflate(R.layout.myprofile_fragment, container, false);
        return root;
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        mapping(view);
        //      Get data phieuDatVe
//        callAPIPhieuDatVe();
        loadScreen(view);
    }

    private void mapping(View view) {
        payment_total = view.findViewById(R.id.payment_label);
        booking_total = view.findViewById(R.id.booking_label);
        btnUpdate = view.findViewById(R.id.btnUpdate);
        full_name = view.findViewById(R.id.full_name);
        lastname = view.findViewById(R.id.lastname);
        full_name2 = view.findViewById(R.id.full_name2);
        cmnd = view.findViewById(R.id.cmnd);
        mail = view.findViewById(R.id.mail);
        sdt = view.findViewById(R.id.sdt);
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

    private void loadScreen(View view) {
//        Get id cua khach hang tu session
        SharedPreferences sharedPreferences = view.getContext().getSharedPreferences(MyUSER, Context.MODE_PRIVATE);
        String name = sharedPreferences.getString("FullName", "null");
        Long id = sharedPreferences.getLong("id", -1);
        String phone = sharedPreferences.getString("PhoneNumber", "null");
        String cmnds = sharedPreferences.getString("CMND", "null");
        String email = sharedPreferences.getString("Email", "null");


        int totalMoney = 0;
        int totalTicket = 0;

        for (PhieuDatVeDTO item : listPDV) {
            if (item.getRoleDatVe() == 2 && item.getNguoiDatVe_id() == id) {
                totalMoney += item.getThanhTien();
                totalTicket ++;
            }
        }
        full_name.setText(name + " ");
        payment_total.setText(xuLyGia(totalMoney + ""));
        booking_total.setText(totalTicket + "");
        full_name2.setText(name);
        cmnd.setText(cmnds);
        sdt.setText(phone);
        mail.setText(email);
    }
}































