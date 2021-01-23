package com.example.calculates;

import android.app.DatePickerDialog;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import org.joda.time.DateTime;
import org.joda.time.DateTimeZone;
import org.joda.time.Days;
import org.joda.time.Hours;
import org.joda.time.LocalDate;
import org.joda.time.Minutes;
import org.joda.time.Months;
import org.joda.time.Period;
import org.joda.time.PeriodType;
import org.joda.time.Weeks;
import org.joda.time.Years;
import org.joda.time.format.PeriodFormatter;
import org.joda.time.format.PeriodFormatterBuilder;

import java.io.Serializable;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.temporal.ChronoUnit;
import java.util.Calendar;
import java.util.Date;
import java.util.Locale;
import java.util.Objects;
import java.util.TimeZone;

public class AgeActivity extends AppCompatActivity {
    private static final String TAG = "AgeActivity";
    //private TextView show_date_tv1, show_date_tv2;
    private TextView current_year_tv, current_month_tv, current_days_tv;
    private TextView coming_week_day_tv, coming_month_tv, coming_day_tv;
    private TextView total_year_tv, total_days_tv;
    private TextView total_month_tv, total_hour_tv;
    private TextView total_week_tv, total_minutes_tv;

    private Button s_bt, data_picker_button, data_picker_button2;

    private DatePickerDialog.OnDateSetListener date_picker_listener1;
    private DatePickerDialog.OnDateSetListener date_picker_listener2;

    SimpleDateFormat sdf;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_age);
        findViewByIds();


        Calendar calendar = Calendar.getInstance();
        final int cYear = calendar.get(Calendar.YEAR);
        final int cMonth = calendar.get(Calendar.MONTH);
        final int cDay = calendar.get(Calendar.DAY_OF_MONTH);

        sdf = new SimpleDateFormat("dd/MM/yyyy");
        String data = sdf.format(Calendar.getInstance().getTime());
        data_picker_button2.setText(data); //? Display today's date

        data_picker_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                DatePickerDialog dialog = new DatePickerDialog(AgeActivity.this,
                        android.R.style.Theme_Holo_Light_Dialog_MinWidth, date_picker_listener1, cYear, cMonth, cDay);
                Objects.requireNonNull(dialog.getWindow()).setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
                dialog.show();
            }
        });

        date_picker_listener1 = new DatePickerDialog.OnDateSetListener() {
            @Override
            public void onDateSet(DatePicker view, int year, int month, int dayOfMonth) {
                month += 1;
                String date = addZero(dayOfMonth) + "/" + addZero(month) + "/" + year;
                data_picker_button.setText(date);
                getCurrentCalculation();
                //currentAge();
            }

        };

        data_picker_button2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                DatePickerDialog dialog = new DatePickerDialog(AgeActivity.this,
                        android.R.style.Theme_Holo_Light_Dialog_MinWidth, date_picker_listener2, cYear, cMonth, cDay);
                Objects.requireNonNull(dialog.getWindow()).setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
                dialog.show();
            }
        });


        date_picker_listener2 = new DatePickerDialog.OnDateSetListener() {
            @Override
            public void onDateSet(DatePicker view, int year, int month, int dayOfMonth) {
                month += 1;
                String date = addZero(dayOfMonth) + "/" + addZero(month) + "/" + year;
                data_picker_button2.setText(date);
                getCurrentCalculation();
                //currentAge();
            }
        };
    }

    public void findViewByIds() {

        current_year_tv = findViewById(R.id.current_year_tv);
        current_month_tv = findViewById(R.id.current_month_tv);
        current_days_tv = findViewById(R.id.current_days_tv);

        coming_week_day_tv = findViewById(R.id.coming_week_day_tv);
        coming_day_tv = findViewById(R.id.coming_day_tv);
        coming_month_tv = findViewById(R.id.coming_month_tv);

        total_year_tv = findViewById(R.id.total_year_tv);
        total_days_tv = findViewById(R.id.total_days_tv);

        total_month_tv = findViewById(R.id.total_month_tv);
        total_hour_tv = findViewById(R.id.total_hour_tv);

        total_week_tv = findViewById(R.id.total_week_tv);
        total_minutes_tv = findViewById(R.id.total_minutes_tv);

        data_picker_button = findViewById(R.id.data_picker_button);
        data_picker_button2 = findViewById(R.id.data_picker_button2);

    }

    // Add zero before <-- if date/month is less than 10
    public Serializable addZero(int dateOrMonth) {
        return dateOrMonth < 10 ? "0" + dateOrMonth : dateOrMonth;
    }

    public void getCurrentCalculation() {
        String bDay = data_picker_button.getText().toString();
        String tDay = data_picker_button2.getText().toString();

        try {

            Date d1 = sdf.parse(bDay);
            Date d2 = sdf.parse(tDay);


            long firstDate = Objects.requireNonNull(d1).getTime();
            long secondDate = Objects.requireNonNull(d2).getTime();

            DateTime startDate = new DateTime(d1.getTime());
            DateTime endDate = new DateTime(d2.getTime());

            //if birthday is more than today's date return


            Period period = new Period(firstDate, secondDate, PeriodType.yearMonthDay());
            int years = period.getYears();
            int months = period.getMonths();
            int days = period.getDays();

            Log.d(TAG, "getCurrentCalculation: " + years + "/" + months + "/" + days);
            current_year_tv.setText(String.valueOf(years));
            current_month_tv.setText(months + " Months");
            current_days_tv.setText(days + " Days");


            //Summery between two dates
            getHours(startDate, endDate);
            getMinutes(startDate, endDate);
            getMonths(startDate, endDate);
            getDays(startDate, endDate);
            getWeeks(startDate, endDate);
            getYears(startDate, endDate);

        } catch (Exception e) {
            e.printStackTrace();
        }
        nextBirthday();
    }

    public void nextBirthday() {

    }

    public void getHours(DateTime startDate, DateTime endDate) {
        Hours hours = Hours.hoursBetween(startDate, endDate);
        int hour = hours.getHours();
        total_hour_tv.setText(String.valueOf(hour));
    }

    public void getMonths(DateTime startDate, DateTime endDate) {
        Months m = Months.monthsBetween(startDate, endDate);
        int mon = m.getMonths();
        total_month_tv.setText(String.valueOf(mon));
    }

    public void getMinutes(DateTime startDate, DateTime endDate) {
        Minutes minutes = Minutes.minutesBetween(startDate, endDate);
        int min = minutes.getMinutes();
        total_minutes_tv.setText(String.valueOf(min));
    }

    public void getDays(DateTime startDate, DateTime endDate) {
        Days days = Days.daysBetween(startDate, endDate);
        int d = days.getDays();
        total_days_tv.setText(String.valueOf(d));
    }

    public void getWeeks(DateTime startDate, DateTime endDate) {
        Weeks weeks = Weeks.weeksBetween(startDate, endDate);
        int w = weeks.getWeeks();
        total_week_tv.setText(String.valueOf(w));
    }

    public void getYears(DateTime startDate, DateTime endDate) {
        Years years = Years.yearsBetween(startDate, endDate);
        int y = years.getYears();
        total_year_tv.setText(String.valueOf(y));
    }
}