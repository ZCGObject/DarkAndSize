package com.ikang.mydark;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.Locale;

import static java.util.Calendar.DATE;
import static java.util.Calendar.DAY_OF_MONTH;
import static java.util.Calendar.DAY_OF_WEEK;
import static java.util.Calendar.MONTH;
import static java.util.Calendar.YEAR;

public class DateActivity extends AppCompatActivity implements View.OnClickListener {

    private Button btn1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_date);
        btn1 = findViewById(R.id.btn1);








        btn1.setOnClickListener(this);

//        strToDate("2020-07-08");
//        Log.e("strToDate-->>" , strToDate("2020-07-08").toString());

        Log.e("strToDate-->>" , Locale.getDefault().toString());
    }

    /**
     * 将用户预约的字符串格式的时间转化成Date格式的时间值
     * @param selectTime
     * @return
     */
    private Date strToDate(String selectTime){
            try {
                DateFormat df = new SimpleDateFormat("yyyy-MM-dd");
                if(selectTime.length() == 10){
                    return df.parse(selectTime);
                }
                else if (selectTime.length() > 10) {
                    return df.parse(selectTime.substring(0, 10));
                }

            } catch (ParseException e) {
                Log.e("Exception:error" , e.toString());
                e.printStackTrace();
            }


        return null;
    }

    /**
     * Called when a view has been clicked.
     *
     * @param v The view that was clicked.
     */
    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.btn1:
                Calendar calendar = Calendar.getInstance(Locale.getDefault());
                Calendar calendar1 = Calendar.getInstance(Locale.getDefault());
                int year = calendar.get(Calendar.YEAR);
                Log.e("year--->>", year+"");
                int dayY = calendar.get(Calendar.DAY_OF_YEAR);
                int dayM = calendar.get(Calendar.DAY_OF_MONTH);
                int dayW = calendar.get(Calendar.DAY_OF_WEEK);
                Log.e("year--->>", dayY + "--" + dayM);

                calendar.set(Calendar.DAY_OF_MONTH, 1);

                int dayY1 = calendar.get(Calendar.DAY_OF_YEAR);
                int dayM1 = calendar.get(Calendar.DAY_OF_MONTH);
                int dayW1 = calendar.get(Calendar.DAY_OF_WEEK);
                int d0 = calendar.getFirstDayOfWeek();

                Calendar calendar11 = Calendar.getInstance(Locale.getDefault());
                Calendar calendar22 = Calendar.getInstance(Locale.getDefault());
                int dayW11 = calendar11.getFirstDayOfWeek();
//                int dayW22 = calendar22.getFirstDayOfWeek();
//
                calendar11.set(Calendar.DAY_OF_MONTH, 1);
                int dayY111 = calendar11.get(Calendar.DAY_OF_YEAR);
                int firstDayOfWeek = calendar11.get(DAY_OF_WEEK);
                int offset = calendar11.getFirstDayOfWeek() - firstDayOfWeek;
                calendar11.add(Calendar.DATE, offset);
                int dayY1111 = calendar11.get(Calendar.DAY_OF_YEAR);
                List<Integer> list = new ArrayList<>();
                while ((calendar11.get(MONTH) < calendar1.get(MONTH) + 1 || calendar11.get(YEAR) < calendar1.get(YEAR))
                        && calendar11.get(YEAR) <= calendar1.get(YEAR)){

                    calendar11.add(DATE, 1);
                    list.add(1);

                }
                Log.e("list.size--->>", list.size()+"");

//                DateFormat weekdayNameFormat = new SimpleDateFormat("EEE");
//
//                String weekDayStr = weekdayNameFormat.format(calendar.getTime());
//
//                String weekDay = weekDayStr.substring(weekDayStr.length() - 1);


//                int d1 = calendar1.get(Calendar.DAY_OF_MONTH);
//                calendar1.set(Calendar.DAY_OF_MONTH, dayM+60);
//                int d2 = calendar1.get(Calendar.DAY_OF_MONTH);
//                int d3 = calendar1.get(Calendar.DAY_OF_YEAR);






//                Log.e("year--->>d2", d2+"");
//                calendar.add(Calendar.DAY_OF_YEAR, -2);
//                dayY = calendar.get(Calendar.DAY_OF_YEAR);
//                Log.e("year--->>", dayY + "--" + dayM);
//
//                calendar.add(Calendar.YEAR, 1);
//                year = calendar.get(Calendar.YEAR);
//                Log.e("year--->>", year+"");
                break;
        }
    }
}