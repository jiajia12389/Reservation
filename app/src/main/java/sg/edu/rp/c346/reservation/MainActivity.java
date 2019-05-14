package sg.edu.rp.c346.reservation;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.TimePicker;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    DatePicker dp;
    TimePicker tp;
    EditText etname, etmb, etno;
    CheckBox cbEnabled;
    Button btnSubmit,btnReset;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        dp = findViewById(R.id.datePicker);
        tp = findViewById(R.id.timePicker);

        dp.updateDate(2019, 5, 1);

        tp.setCurrentHour(19);
        tp.setCurrentMinute(30);

        etname = findViewById(R.id.etname);
        etmb = findViewById(R.id.etmb);
        etno = findViewById(R.id.etno);

        btnSubmit = findViewById(R.id.button);
        cbEnabled = findViewById(R.id.checkBox);
        btnReset = findViewById(R.id.btnReset);

        cbEnabled.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if(cbEnabled.isChecked()){
                    cbEnabled.setText("Smoking table");
                }
                else{
                    cbEnabled.setText("Non-smoking table");
                }

            }

        });

        btnReset.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                etname.setText(null);
                etmb.setText(null);
                etno.setText(null);

                cbEnabled.setChecked(false);

                dp.updateDate(2019, 5, 1);
                tp.setCurrentHour(19);
                tp.setCurrentMinute(30);
            }

        });

        if((etname.getText().length() > 0) && (etmb.getText().length() > 0) && (etno.getText().length() > 0)) {


        }
        btnSubmit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                String name = etname.getText().toString().trim();
                String mobile = etmb.getText().toString().trim();
                String pax = etno.getText().toString().trim();

                String smokeArea ="";
                int day = dp.getDayOfMonth();
                int mth = dp.getMonth();
                int year = dp.getYear();

                int hour = tp.getCurrentHour();
                int min = tp.getCurrentMinute();

                String date = day + "/" + mth +"/" + year;
                String time = hour + ":" + min;

                if(cbEnabled.isChecked()){
                    smokeArea = "Yes";
                    Toast.makeText(MainActivity.this, "Customer Info: \nName: " + name + "\n Mobile: " + mobile + "\n Pax: " + pax + "\n Smoking Area: " + smokeArea + "\n Date: " + date + "\n Time: " + time, Toast.LENGTH_SHORT).show();

                }
                else{
                    smokeArea = "No";
                    Toast.makeText(MainActivity.this, "Customer Info: \nName: " + name + "\n Mobile: " + mobile + "\n Pax: " + pax + "\n Smoking Area: " + smokeArea + "\n Date: " + date + "\n Time: " + time, Toast.LENGTH_SHORT).show();

                }

            }
        });



    }
}
