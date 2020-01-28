package com.example.inventario;

import androidx.appcompat.app.AppCompatActivity;

import android.app.AlertDialog;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.*;

import com.android.volley.*;
import com.android.volley.toolbox.Volley;

import org.json.JSONException;
import org.json.JSONObject;

public class RegisterActivity extends AppCompatActivity {

    EditText etEmpresa,etRubro,etUsuario,etPass,etPass2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

        etEmpresa=findViewById(R.id.etregEmpres);
        etRubro=findViewById(R.id.etregRubro);
        etUsuario=findViewById(R.id.etregUser);
        etPass=findViewById(R.id.etregPass);
        etPass2=findViewById(R.id.etregPass2);


        Button registro =findViewById(R.id.btnregRegistrar);

        registro.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                String emp= etEmpresa.getText().toString();
                String rub= etRubro.getText().toString();
                String user= etUsuario.getText().toString();
                String pass=etPass.getText().toString();
                String pass2 = etPass2.getText().toString();

                Response.Listener<String> respuesta = new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {
                        try{
                            JSONObject jsonRespuesta = new JSONObject(response);
                            boolean ok = jsonRespuesta.getBoolean("success");
                            if(ok == true){
                                Intent i = new Intent(RegisterActivity.this,LoginActivity.class);
                                startActivity(i);
                                finish();
                            }
                            else{
                                AlertDialog.Builder alert = new AlertDialog.Builder(RegisterActivity.this);
                                alert.setMessage("Fallo en el registro").
                                        setNegativeButton("Reintentar",null)
                                .create()
                                .show();

                            }
                        }catch (JSONException e){
                            e.getMessage();

                        }

                    }
                };
                RegistroRequest r = new RegistroRequest(emp,rub,user,pass,pass2,respuesta);
                RequestQueue cola = Volley.newRequestQueue(RegisterActivity.this);
                 cola.add(r);
            }
        });



    }
}
