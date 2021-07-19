package com.example.bookingfilght.Fragment;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.example.bookingfilght.Activity.LoginActivity;
import com.example.bookingfilght.Models.CovidDTO;
import com.example.bookingfilght.Models.WeatherMainDTO;
import com.example.bookingfilght.R;
import com.example.bookingfilght.api.CovidCallAPI;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class DashboardFragment extends Fragment {

    TextView confirmed, recovered, active, recoveredDay, casesDay, cases;
    TextView troi, nhietdo, maxmin, weather;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        ViewGroup root = (ViewGroup) inflater.inflate(R.layout.dashoard_fragment, container, false);
        return root;
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        mapping(view);
        loadCovid();
        loadWeather();
    }

    private void mapping(View view) {
        confirmed = view.findViewById(R.id.confirmedCV);
        recovered = view.findViewById(R.id.recoveredCV);
        active = view.findViewById(R.id.activeCV);
        recoveredDay = view.findViewById(R.id.recoveredDay);
        casesDay = view.findViewById(R.id.casesDay);
        cases = view.findViewById(R.id.cases);
        troi = view.findViewById(R.id.troi);
        nhietdo = view.findViewById(R.id.nhietdo);
        maxmin = view.findViewById(R.id.maxmin);
        weather = view.findViewById(R.id.weather);
    }

    private void loadWeather() {
        WeatherMainDTO weatherMainDTO = LoginActivity.weatherMainDTO;
        troi.setText(weatherMainDTO.getWeather().get(0).getDescription());
        Double a = (weatherMainDTO.getMain().getTemp() - 273.15 );
        nhietdo.setText(a.intValue() + "");
        Double max = (weatherMainDTO.getMain().getTemp_max() - 273.15 );
        Double min = (weatherMainDTO.getMain().getTemp_min() - 273.15 );
        maxmin.setText(max.intValue() + "C   --->   " + min.intValue() + "C");
        weather.setText(weatherMainDTO.getWeather().get(0).getMain());
    }

    private void loadCovid() {
        CovidDTO covidDTO = LoginActivity.listCV;

        confirmed.setText(covidDTO.getDeaths() + "");
        active.setText(covidDTO.getActive() + "");
        recovered.setText(covidDTO.getRecovered() + "");
        recoveredDay.setText("Recovered today: " + covidDTO.getTodayRecovered());
        casesDay.setText("Cases today: " + covidDTO.getTodayCases());
        cases.setText("Cases: " + covidDTO.getCases());

    }
}
