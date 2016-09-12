package com.evoldig.registro;

import android.app.Dialog;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.design.widget.TextInputEditText;
import android.support.design.widget.TextInputLayout;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.app.DatePickerDialog;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.support.v4.app.DialogFragment;


import java.text.DateFormat;
import java.util.Calendar;
import java.util.GregorianCalendar;

public class datosUsuario extends AppCompatActivity implements DatePickerDialog.OnDateSetListener, View.OnClickListener {


    Button boton;
    //EditText texty;
    EditText txt_name;
    TextView showDate;
    EditText txt_phone;
    EditText txt_email;
    EditText txt_description;







    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_datos_usuario);

        boton = (Button) findViewById(R.id.boton);
        boton.setOnClickListener(this);
        txt_name = (EditText) findViewById(R.id.txt_name);
        showDate = (TextView) findViewById(R.id.showDate);
        txt_phone = (EditText) findViewById(R.id.txt_phone);
        txt_email = (EditText) findViewById(R.id.txt_email);
        txt_description = (EditText) findViewById(R.id.txt_description);



        Intent intent = getIntent();
        Bundle extras = intent.getExtras();

        //Retorno de datos

        if (extras!=null) {
            //String dato = extras.getString("DATO");
            //textView.setText(dato);

            String nombre = extras.getString("NOMBRE");
            String date = extras.getString("DATE");
            String phone = extras.getString("PHONE");
            String email = extras.getString("EMAIL");
            String description = extras.getString("DESCRIPTION");


            //textView.setText(nombre);

            txt_name.setText(nombre);
            showDate.setText(date);
            txt_phone.setText(phone);
            txt_email.setText(email);
            txt_description.setText(description);


        }



    }



    public void datePicker (View view) {

        DatePickerFragment fragment = new DatePickerFragment ();
        fragment.show (getSupportFragmentManager(),"date");
    }

    public void setDate (final Calendar calendar) {
        final DateFormat dateFormat = DateFormat.getDateInstance(DateFormat.MEDIUM);
        ((TextView) findViewById(R.id.showDate)).setText(dateFormat.format(calendar.getTime()));

    }

    public void onDateSet (DatePicker view, int year, int month, int day) {
        Calendar cal = new GregorianCalendar(year, month, day);
        setDate(cal);

    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {

            case R.id.boton:
                //String dato = texty.getText().toString();
                String nombre = txt_name.getText().toString();
                String date = showDate.getText().toString();
                String phone = txt_phone.getText().toString();
                String email = txt_email.getText().toString();
                String description = txt_description.getText().toString();

                //Instens
                Intent intent = new Intent(datosUsuario.this, confirmaDatos.class);
                intent.putExtra("NOMBRE",nombre);
                intent.putExtra("DATE",date);
                intent.putExtra("PHONE",phone);
                intent.putExtra("EMAIL",email);
                intent.putExtra("DESCRIPTION",description);

                startActivity(intent);
                break;



        }

    }

    public static class DatePickerFragment extends DialogFragment {

        @NonNull
        @Override
        public Dialog onCreateDialog(Bundle savedInstanceState) {
            final Calendar c = Calendar.getInstance();
            int year = c.get(Calendar.YEAR);
            int month = c.get(Calendar.MONTH);
            int day = c.get(Calendar.DAY_OF_MONTH);

            return new DatePickerDialog(getActivity(),
                    (DatePickerDialog.OnDateSetListener)
                        getActivity(), year, month, day);
        }
    }




}
