package com.example.um_planner_java;

import android.annotation.SuppressLint;
import android.os.Build;
import android.os.Bundle;
import android.os.Environment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.ScrollView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;

import com.example.um_planner_java.ICS4J.ADECalendar;
import com.example.um_planner_java.ICS4J.ADEDay;
import com.example.um_planner_java.ICS4J.ADEEvent;
import com.example.um_planner_java.ICS4J.ICSparser;
import com.example.um_planner_java.databinding.FragmentSecondBinding;

import java.io.File;

public class SecondFragment extends Fragment {

    private FragmentSecondBinding binding;
    private int i = 0;
    private ADECalendar cal;

    @Override
    public View onCreateView(
            @NonNull LayoutInflater inflater, ViewGroup container,
            Bundle savedInstanceState) {

        loadADECalendar();
        binding = FragmentSecondBinding.inflate(inflater, container, false);
        return binding.getRoot();
    }

    private void addDayInScrollView(int i){

        @SuppressLint("InflateParams") View ADEDayView = getLayoutInflater().inflate(R.layout.ade_day, null, false);
        TextView textViewDayDate = ADEDayView.findViewById(R.id.textViewDayDate);
        LinearLayout layoutEvents =  ADEDayView.findViewById(R.id.LinearLayoutEvents);

        ADEDay day = cal.getDay(i);
        textViewDayDate.setText(day.getStringDate());


        for(ADEEvent e : day.getAllEvents()){
            @SuppressLint("InflateParams") View ADEEventView = getLayoutInflater().inflate(R.layout.ade_event, null, false);

            TextView textViewHourStart = ADEEventView.findViewById(R.id.textViewHourStart);
            TextView textViewHourEnd = ADEEventView.findViewById(R.id.textViewHourEnd);
            TextView textViewLocation = ADEEventView.findViewById(R.id.textViewLocation);
            TextView textViewSummary = ADEEventView.findViewById(R.id.textViewSummary);
            TextView textViewDescription = ADEEventView.findViewById(R.id.textViewDescription);

            textViewHourStart.setText(e.getDTSTART().getStringHour());
            textViewHourEnd.setText(e.getDTEND().getStringHour());
            textViewLocation.setText(e.getLocation());
            textViewSummary.setText(e.getSummary());
            textViewDescription.setText(e.getDescription());

            //Ajouter ADEEventView à ADEDayView
            layoutEvents.addView(ADEEventView);

            }

        binding.layoutEventList.addView(ADEDayView);
        Toast.makeText(getContext(), "Add" + Integer.toString(i), Toast.LENGTH_LONG);
    }

    private void loadADECalendar(){
        String title = "direct_cal.jsp";
        File file = new File(Environment.getExternalStoragePublicDirectory(Environment.DIRECTORY_DOWNLOADS), title);

        if(file.exists()) {
            if (cal == null) {
                cal = ICSparser.getADECalendar(file);
                i = cal.getIndexOfCurentDay();
            }
        }
    }

    public void onViewCreated(@NonNull View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        // TODO : Utiliser une méthode de ICS4J pour avoir le jours courant


        for(int j = i+6; i<j; i++){
            addDayInScrollView(i);
        }


        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
            binding.scrollViewEventList.setOnScrollChangeListener(new View.OnScrollChangeListener() {
                @Override
                public void onScrollChange(View v, int scrollX, int scrollY, int oldScrollX, int oldScrollY) {
                    ScrollView scrollView = binding.scrollViewEventList;
                    View view = (View) scrollView.getChildAt(scrollView.getChildCount() - 1);
                    int diffDown = (view.getBottom() - (scrollView.getHeight() + scrollView.getScrollY()));
                    int diffUp = scrollView.getScrollY();

                    // if diff is zero, then the bottom has been reached

                    //Log.d("SCROLTEST", "Event Scroll : " + diffUp);

                    if (diffDown <= 10) {
                        // do stuff
                        addDayInScrollView(i);
                    } else if(diffUp <= 0){
                        Toast.makeText(getContext(), "Event Up: " + diffUp, Toast.LENGTH_SHORT).show();
                    }

                }
            });
        }
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }

}