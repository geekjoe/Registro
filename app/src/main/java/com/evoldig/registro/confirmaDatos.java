package com.evoldig.registro;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class confirmaDatos extends AppCompatActivity implements View.OnClickListener {

    //TextView textView;
    TextView tv_name;
    TextView tv_date;
    TextView tv_phone;
    TextView tv_email;
    TextView tv_description;

    Button boton2;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.confirma_datos);

        boton2 = (Button) findViewById(R.id.boton2);
        boton2.setOnClickListener(this);
        //textView = (TextView) findViewById(R.id.textView);

        tv_name = (TextView) findViewById(R.id.tv_name);
        tv_date = (TextView) findViewById(R.id.tv_date);
        tv_phone = (TextView) findViewById(R.id.tv_phone);
        tv_email = (TextView) findViewById(R.id.tv_email);
        tv_description = (TextView) findViewById(R.id.tv_description);

        Intent intent = getIntent();
        Bundle extras = intent.getExtras();

        if (extras!=null) {
            //String dato = extras.getString("DATO");
            //textView.setText(dato);

            String nombre = extras.getString("NOMBRE");
            String date = extras.getString("DATE");
            String phone = extras.getString("PHONE");
            String email = extras.getString("EMAIL");
            String description = extras.getString("DESCRIPTION");


            //textView.setText(nombre);

            tv_name.setText(nombre);
            tv_date.setText(date);
            tv_phone.setText(phone);
            tv_email.setText(email);
            tv_description.setText(description);


        }




    }

   /* @Override
    public boolean onKeyDown(int keyCode, KeyEvent event) {

        if (keyCode == KeyEvent.KEYCODE_BACK) {
            Intent intent = new Intent(confirmaDatos.this, datosUsuario.class);
            startActivity(intent);
        }
        return super.onKeyDown(keyCode, event);
    } */

    @Override
    public void onClick(View view) {

        switch (view.getId()) {
            case R.id.boton2 :

               //Intent intent = new Intent(Intent.CATEGORY_HOME);
               // startActivity(intent);
               // finish();

                //Segundo paso de datos
                //String dato = texty.getText().toString();
                String nombre = tv_name.getText().toString();
                String date = tv_date.getText().toString();
                String phone = tv_phone.getText().toString();
                String email = tv_email.getText().toString();
                String description = tv_description.getText().toString();


                Intent intent = new Intent(confirmaDatos.this, datosUsuario.class);
                //publicacion de datos
                intent.putExtra("NOMBRE",nombre);
                intent.putExtra("DATE",date);
                intent.putExtra("PHONE",phone);
                intent.putExtra("EMAIL",email);
                intent.putExtra("DESCRIPTION",description);
                startActivity(intent);
                break;



        }
    }


}
