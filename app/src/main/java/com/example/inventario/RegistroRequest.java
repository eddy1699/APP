package com.example.inventario;


import com.android.volley.Request;
import com.android.volley.Response;
import com.android.volley.toolbox.StringRequest;

import java.util.HashMap;
import java.util.Map;

public class RegistroRequest  extends StringRequest {

    private static  final String ruta="http://apptests2020.000webhostapp.com/registro.php";
    private Map<String,String> parametros;
    public  RegistroRequest(String emp, String rub, String user, String pass, String pass2, Response.Listener<String> listener){
        super(Request.Method.POST,ruta,listener,null);
        parametros= new HashMap<>();
        parametros.put("empresa",emp+"");
        parametros.put("rubro",rub+"");
        parametros.put("user",user);
        parametros.put("pass",pass);
        parametros.put("pass2",pass2);


    };





}
