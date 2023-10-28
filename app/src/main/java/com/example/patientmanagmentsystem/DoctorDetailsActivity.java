package com.example.patientmanagmentsystem;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.ListView;
import android.widget.SimpleAdapter;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.HashMap;

public class DoctorDetailsActivity extends AppCompatActivity {
    private String [][] doctor_details1 =
            {
                    {"Dr. Joe Biden", "Location: CBD","Clinic: 021021021", "Exp : 11 yrs", "$50"},
                    {"Dr. Chris Luxon", "Location: Papatoetoe","Clinic: 021022023", "Exp : 5 yrs", "$70"},
                    {"Dr. Chris Hipkins", "Location: Mt. Roskill","Clinic: 021201021","Exp : 20 yrs", "$60"},
                    {"Dr. Xi Jao", "Location : Mt. Eden", "Clinic: 127213123","Exp : 5 yrs", "$70"},
                    {"Dr. Benjamin", "Hospital Address : Mt. Zion", "Clinic: 231123122","Exp : 9 yrs", "$100"}
            };
    private String [][] doctor_details2 =
            {
                    {"Dr. Joe Biden", "Location: CBD","Clinic: 021021021", "Exp : 11 yrs", "$50"},
                    {"Dr. Chris Luxon", "Location: Papatoetoe","Clinic: 021022023", "Exp : 5 yrs", "$70"},
                    {"Dr. Chris Hipkins", "Location: Mt. Roskill","Clinic: 021201021","Exp : 20 yrs", "$60"},
                    {"Dr. Xi Jao", "Location : Mt. Eden", "Clinic: 127213123","Exp : 5 yrs", "$70"},
                    {"Dr. Benjamin", "Hospital Address : Mt. Zion", "Clinic: 231123122","Exp : 9 yrs", "$100"}
            };

    private String [][] doctor_details3 =
            {
                    {"Dr. Joe Biden", "Location: CBD","Clinic: 021021021", "Exp : 11 yrs", "$50"},
                    {"Dr. Chris Luxon", "Location: Papatoetoe","Clinic: 021022023", "Exp : 5 yrs", "$70"},
                    {"Dr. Chris Hipkins", "Location: Mt. Roskill","Clinic: 021201021","Exp : 20 yrs", "$60"},
                    {"Dr. Xi Jao", "Location : Mt. Eden", "Clinic: 127213123","Exp : 5 yrs", "$70"},
                    {"Dr. Benjamin", "Hospital Address : Mt. Zion", "Clinic: 231123122","Exp : 9 yrs", "$100"}
            };

    private String [][] doctor_details4 =
            {
                    {"Dr. Joe Biden", "Location: CBD","Clinic: 021021021", "Exp : 11 yrs", "$50"},
                    {"Dr. Chris Luxon", "Location: Papatoetoe","Clinic: 021022023", "Exp : 5 yrs", "$70"},
                    {"Dr. Chris Hipkins", "Location: Mt. Roskill","Clinic: 021201021","Exp : 20 yrs", "$60"},
                    {"Dr. Xi Jao", "Location : Mt. Eden", "Clinic: 127213123","Exp : 5 yrs", "$70"},
                    {"Dr. Benjamin", "Hospital Address : Mt. Zion", "Clinic: 231123122","Exp : 9 yrs", "$100"}
            };

    private String [][] doctor_details5 =
            {
                    {"Dr. Joe Biden", "Location: CBD","Clinic: 021021021", "Exp : 11 yrs", "$50"},
                    {"Dr. Chris Luxon", "Location: Papatoetoe","Clinic: 021022023", "Exp : 5 yrs", "$70"},
                    {"Dr. Chris Hipkins", "Location: Mt. Roskill","Clinic: 021201021","Exp : 20 yrs", "$60"},
                    {"Dr. Xi Jao", "Location : Mt. Eden", "Clinic: 127213123","Exp : 5 yrs", "$70"},
                    {"Dr. Benjamin", "Hospital Address : Mt. Zion", "Clinic: 231123122","Exp : 9 yrs", "$100"}
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
            item.put( "line4", doctor_details[i][3]);
            item.put( "line5", "Consultation Fees:"+doctor_details[i][4]);
            list.add(item);
        }

        sa = new SimpleAdapter(this, list,
        R.layout.multi_lines,
        new String[]{"line1","line2","line3","line4", "line5"},
        new int[]{R.id.line_a,R.id.line_b,R.id.line_c,R.id.line_d,R.id.line_e}
        );

        ListView lst = findViewById(R.id.listViewDD);
        lst.setAdapter(sa);

        lst.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                Intent it = new Intent(DoctorDetailsActivity.this,BookAppointmentActivity.class);
                it.putExtra("text1",title);
                it.putExtra("text2",doctor_details[i][0]);
                it.putExtra("text3",doctor_details[i][1]);
                it.putExtra("text4",doctor_details[i][2]);
                it.putExtra("text5",doctor_details[i][4]);
                startActivity(it);
            }
        });
    }
}