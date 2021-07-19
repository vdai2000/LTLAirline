package com.example.bookingfilght.Fragment;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.example.bookingfilght.Activity.DashBoard;
import com.example.bookingfilght.Activity.LoginActivity;
import com.example.bookingfilght.Adapter.AdapterHistoryTick;
import com.example.bookingfilght.Models.ChuyenBayDTO;
import com.example.bookingfilght.Models.DataOuputHistory;
import com.example.bookingfilght.Models.PhieuDatVeDTO;
import com.example.bookingfilght.Models.VeChuyenBayDTO;
import com.example.bookingfilght.R;
import com.example.bookingfilght.SearchFlight.AdapterFlight;

import java.util.ArrayList;
import java.util.List;

import static com.example.bookingfilght.Activity.LoginActivity.MyUSER;

public class AboutFragment extends Fragment{


    ListView listView;
    TextView toalVe, monny, nameUser;
    AdapterHistoryTick adapter;
    List<PhieuDatVeDTO> arrayListHistory = new ArrayList<>();
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        ViewGroup root = (ViewGroup) inflater.inflate(R.layout.about_fragment, container, false);

        return root;
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        mapping(view);
        getDataPhieuDatVe(view);


        adapter = new AdapterHistoryTick(requireContext(), R.layout.item_historylist, arrayListHistory);
        listView.setAdapter(adapter);
    }

    private void mapping(View view) {
        listView = (ListView) view.findViewById(R.id.listFlightHistory);
        toalVe = (TextView) view.findViewById(R.id.toalVe);
        monny = (TextView) view.findViewById(R.id.monny);
        nameUser = (TextView) view.findViewById(R.id.nameUser);
    }

    private List<PhieuDatVeDTO> getDataPhieuDatVe(View view) {
        List<PhieuDatVeDTO> listPDV = DashBoard.listPDV;
        int toalV = 0;
        int toalgia = 0;
        //        Get id cua khach hang tu session
        SharedPreferences sharedPreferences = view.getContext().getSharedPreferences(MyUSER, Context.MODE_PRIVATE);
        String name = sharedPreferences.getString("FullName", "null");
        nameUser.setText(name);
        Long id = sharedPreferences.getLong("id", -1);
        for (PhieuDatVeDTO item:listPDV) {
            if (id == item.getNguoiDatVe_id() && item.getHoTenNhanVien().equals("Khách hàng đặt !!")) {
                for (VeChuyenBayDTO veItem: LoginActivity.listVCB){
                    long a = item.getVechuyenbayID();
                    long a1 = veItem.getId();
                    if (a == a1)
                    {
                        item.setIdChuyenBay(veItem.getChuyenBayID());
                        arrayListHistory.add(item);
                        toalV ++;
                        toalgia += item.getThanhTien().intValue();
                        break;
                    }
                }
            }
        }
        monny.setText(xuLyGia(toalgia + ""));
        toalVe.setText(toalV + "");

        return arrayListHistory;
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
