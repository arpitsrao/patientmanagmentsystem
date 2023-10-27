package com.example.patientmanagmentsystem;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ListView;
import android.widget.SimpleAdapter;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.HashMap;

public class DoctorDetailsActivity extends AppCompatActivity {
    private String [][] doctor_details1 =
            {
                    {"Doctor Name : Joe Biden", "Hospital Address : CBD", "Exp : 11 yrs", "$50"},
                    {"Doctor Name : Chris Luxon", "Hospital Address : Mount Roskill", "Exp : 5 yrs", "$70"},
                    {"Doctor Name : Narendra Modi", "Hospital Address : Sandringham", "Exp : 20 yrs", "$60"},
                    {"Doctor Name : Xi Jingping", "Hospital Address : Mount Eden", "Exp : 5 yrs", "$70"},
                    {"Doctor Name : Benjamin Netanyahu", "Hospital Address : Mount Zion", "Exp : 9 yrs", "$100"}
            };
    private String [][] doctor_details2 =
            {
                    {"Doctor Name : Joe Biden", "Hospital Address : CBD", "Exp : 11 yrs", "$50"},
                    {"Doctor Name : Chris Luxon", "Hospital Address : Mount Roskill", "Exp : 5 yrs", "$70"},
                    {"Doctor Name : Narendra Modi", "Hospital Address : Sandringham", "Exp : 20 yrs", "$60"},
                    {"Doctor Name : Xi Jingping", "Hospital Address : Mount Eden", "Exp : 5 yrs", "$70"},
                    {"Doctor Name : Benjamin Netanyahu", "Hospital Address : Mount Zion", "Exp : 9 yrs", "$100"}
            };

    private String [][] doctor_details3 =
            {
                    {"Doctor Name : Joe Biden", "Hospital Address : CBD", "Exp : 11 yrs", "$50"},
                    {"Doctor Name : Chris Luxon", "Hospital Address : Mount Roskill", "Exp : 5 yrs", "$70"},
                    {"Doctor Name : Narendra Modi", "Hospital Address : Sandringham", "Exp : 20 yrs", "$60"},
                    {"Doctor Name : Xi Jingping", "Hospital Address : Mount Eden", "Exp : 5 yrs", "$70"},
                    {"Doctor Name : Benjamin Netanyahu", "Hospital Address : Mount Zion", "Exp : 9 yrs", "$100"}
            };

    private String [][] doctor_details4 =
            {
                    {"Doctor Name : Joe Biden", "Hospital Address : CBD", "Exp : 11 yrs", "$50"},
                    {"Doctor Name : Chris Luxon", "Hospital Address : Mount Roskill", "Exp : 5 yrs", "$70"},
                    {"Doctor Name : Narendra Modi", "Hospital Address : Sandringham", "Exp : 20 yrs", "$60"},
                    {"Doctor Name : Xi Jingping", "Hospital Address : Mount Eden", "Exp : 5 yrs", "$70"},
                    {"Doctor Name : Benjamin Netanyahu", "Hospital Address : Mount Zion", "Exp : 9 yrs", "$100"}
            };

    private String [][] doctor_details5 =
            {
                    {"Doctor Name : Joe Biden", "Hospital Address : CBD", "Exp : 11 yrs", "$50"},
                    {"Doctor Name : Chris Luxon", "Hospital Address : Mount Roskill", "Exp : 5 yrs", "$70"},
                    {"Doctor Name : Narendra Modi", "Hospital Address : Sandringham", "Exp : 20 yrs", "$60"},
                    {"Doctor Name : Xi Jingping", "Hospital Address : Mount Eden", "Exp : 5 yrs", "$70"},
                    {"Doctor Name : Benjamin Netanyahu", "Hospital Address : Mount Zion", "Exp : 9 yrs", "$100"}
            };


    TextView tv;
    Button btn;
    String [][] doctor_details= {};
    HashMap<String,String> item;
    ArrayList list;
    SimpleAdapter sa;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_doctor_details);

        tv = findViewById(R.id.textViewDDTitle);
        btn = findViewById(R.id.buttonDDBack);

        Intent it = getIntent();
        String title = it.getStringExtra("title");
        tv.setText(title);

        if(title.compareTo("Family Physician")==0)
            doctor_details=doctor_details1;
        else
        if(title.compareTo("Dietcian")==0)
            doctor_details=doctor_details2;
        else
        if(title.compareTo("Dentist")==0)
            doctor_details=doctor_details3;
        else
        if(title.compareTo("Surgeon")==0)
            doctor_details=doctor_details4;
        else
            doctor_details=doctor_details5;



        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(DoctorDetailsActivity.this, FindDoctorActivity.class));
            }
        });

        list = new ArrayList();
        for (int i=0;i<doctor_details.length;i++)
        {
            item = new HashMap<String, String>();
            item.put( "line1", doctor_details[i][0]);
            item.put( "line2", doctor_details[i][1]);
            item.put( "line3", doctor_details[i][2]);
            item.put( "line4", "Consultation Fees:"+doctor_details[i][3]);
            list.add(item);
        }

        sa =new SimpleAdapter(this, list,
        R.layout.multi_lines,
        new String[]{"line1","line2","line3","line4"},
        new int[]{R.id.line_a,R.id.line_b,R.id.line_c,R.id.line_d}
        );

        ListView lst = findViewById(R.id.listViewDD);
        lst.setAdapter(sa);

    }
}