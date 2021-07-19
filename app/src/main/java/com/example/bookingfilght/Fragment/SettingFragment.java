package com.example.bookingfilght.Fragment;

import android.app.DatePickerDialog;
import android.app.Dialog;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.DatePicker;
import android.widget.ImageView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.example.bookingfilght.Activity.AnimationSearchFlightActivity;
import com.example.bookingfilght.Activity.LoginActivity;
import com.example.bookingfilght.Activity.ResultSearchActivity;
import com.example.bookingfilght.Models.ChuyenBayDTO;
import com.example.bookingfilght.Models.SanBayDTO;
import com.example.bookingfilght.R;
import com.example.bookingfilght.api.ChuyenBayCallAPI;
import com.google.android.material.textfield.TextInputEditText;
import com.google.android.material.textfield.TextInputLayout;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;
import java.util.Locale;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class SettingFragment extends Fragment {

    AutoCompleteTextView autoCompleteTextViewSBDi, autoCompleteTextViewSBDen, autoCompleteTextViewLoaiVe;
    TextInputEditText txtNgayDi, txtNgayVe;
    TextInputLayout layoutNgayVe;
    Calendar calendar;
    CheckBox checkBox;
    Button btnSearch;
    ImageView change;
    Dialog dialog;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        ViewGroup root = (ViewGroup) inflater.inflate(R.layout.setting_fragment, container, false);

        return root;
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        autoCompleteTextViewSBDi = view.findViewById(R.id.drop_SB);
        autoCompleteTextViewSBDen = view.findViewById(R.id.drop_SBDen);
        autoCompleteTextViewLoaiVe = view.findViewById(R.id.drop_loaive);
        layoutNgayVe = view.findViewById(R.id.ngayve);
        txtNgayVe = view.findViewById(R.id.txtngayve);
        checkBox = view.findViewById(R.id.checkedKhuHoi);
        txtNgayDi = view.findViewById(R.id.txtngaydi);
        btnSearch = view.findViewById(R.id.btnSearch);
        change = view.findViewById(R.id.change);

        dialog = new Dialog(view.getContext());


        checkBox.setChecked(false);

        List<String> listNameSB = new ArrayList<>();
        for (SanBayDTO item : LoginActivity.listSB) {
            listNameSB.add(item.getTenSanBay());
        }
        ArrayAdapter<String> adapters = new ArrayAdapter<String>(requireContext(), R.layout.dropdown_item, listNameSB);

        autoCompleteTextViewSBDi.setAdapter(adapters);
        autoCompleteTextViewSBDen.setAdapter(adapters);

        String[] arrTyleTickers = {"Phổ thông", "Thương gia"};
        ArrayAdapter<String> adapterTyleTickers = new ArrayAdapter<String>(requireContext(), R.layout.dropdown_item, arrTyleTickers);
        autoCompleteTextViewLoaiVe.setAdapter(adapterTyleTickers);

        //dat ngay textview ngaydi and ngayve
        calendar = Calendar.getInstance();
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd", Locale.getDefault());
        txtNgayDi.setText(simpleDateFormat.format(calendar.getTime()));
        txtNgayVe.setText(simpleDateFormat.format(calendar.getTime()));

        //chon ngay di
        txtNgayDi.setOnClickListener(v -> {
            DatePickerDialog.OnDateSetListener chonngaydi = new DatePickerDialog.OnDateSetListener() {
                @Override
                public void onDateSet(DatePicker view1, int year, int month, int dayOfMonth) {
                    if (month < 10)
                    {
                        txtNgayVe.setText(year + "-" + "0" +(month + 1) + "-" + dayOfMonth);
                    }
                    else {
                        txtNgayVe.setText(year + "-" + (month + 1) + "-" + dayOfMonth);
                    }
                }
            };
            String[] mang = txtNgayDi.getText().toString().split("-");
            int day = Integer.parseInt(mang[0]);
            int month = Integer.parseInt(mang[1]);
            int year = Integer.parseInt(mang[2]);
            DatePickerDialog datePickerDialog = new DatePickerDialog(view.getContext(), chonngaydi, year, month, day);
            datePickerDialog.show();
        });

        //chon ngay ve
        txtNgayVe.setOnClickListener(v -> {
            DatePickerDialog.OnDateSetListener chonngaydi = new DatePickerDialog.OnDateSetListener() {
                @Override
                public void onDateSet(DatePicker view12, int year, int month, int dayOfMonth) {
                    if (month < 10)
                    {
                        txtNgayVe.setText(year + "-" + "0" +(month + 1) + "-" + dayOfMonth);
                    }
                    else {
                        txtNgayVe.setText(year + "-" + (month + 1) + "-" + dayOfMonth);
                    }
                }
            };
            String[] mang = txtNgayVe.getText().toString().split("-");
            int day = Integer.parseInt(mang[0]);
            int month = Integer.parseInt(mang[1]);
            int year = Integer.parseInt(mang[2]);
            DatePickerDialog datePickerDialog = new DatePickerDialog(view.getContext(), chonngaydi, year, month, day);
            datePickerDialog.show();
        });

        // Khu Hoi
        checkBox.setOnCheckedChangeListener((buttonView, isChecked) -> {
            if (isChecked) {
                layoutNgayVe.setVisibility(View.VISIBLE);
            } else {
                layoutNgayVe.setVisibility(View.INVISIBLE);
            }
        });

//      Search chuyen bay
        btnSearch.setOnClickListener(v -> {
            String ngay_di = txtNgayDi.getText().toString();
            String noi_di = autoCompleteTextViewSBDi.getText().toString();
            String noi_den = autoCompleteTextViewSBDen.getText().toString();
            String loai_ve = autoCompleteTextViewLoaiVe.getText().toString().equals("Phổ thông") ? "PT" : "TG";

            if (noi_di.equals(noi_den)) {
                dialog.setContentView(R.layout.dialog_error_searchflight);

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
                Intent intent = new Intent(view.getContext(), AnimationSearchFlightActivity.class);
                intent.putExtra("ngay_di", ngay_di);
                intent.putExtra("noi_di", noi_di);
                intent.putExtra("noi_den", noi_den);
                intent.putExtra("loaive", loai_ve);
                startActivity(intent);
            }
        });

//        doi vi tri san bay
        change.setOnClickListener(v -> {
            String noi_di = autoCompleteTextViewSBDi.getText().toString();
            String noi_den = autoCompleteTextViewSBDen.getText().toString();

            autoCompleteTextViewSBDen.setText(noi_di);
            autoCompleteTextViewSBDi.setText(noi_den);
        });
    }
}
