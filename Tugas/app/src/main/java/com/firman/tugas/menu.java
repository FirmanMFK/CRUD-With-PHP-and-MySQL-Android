package com.firman.tugas;

/**
 * Created by Firmanz on 8/6/2016.
 */
import android.app.ProgressDialog;
import android.content.Intent;
import android.os.AsyncTask;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.util.HashMap;

public class menu extends AppCompatActivity implements View.OnClickListener {

    //Mendefinisikan Views
    private EditText editTextName;
    private EditText editTextDesg;
    private EditText editTextSal;

    private Button buttonAdd;
    private Button buttonView;
    private Button buttonLogout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.menu);

        //Init Views
        editTextName = (EditText) findViewById(R.id.editTextName);
        editTextDesg = (EditText) findViewById(R.id.editTextDesg);
        editTextSal = (EditText) findViewById(R.id.editTextSalary);

        buttonAdd = (Button) findViewById(R.id.buttonAdd);
        buttonView = (Button) findViewById(R.id.buttonView);
        buttonLogout = (Button) findViewById(R.id.buttonlogout);

        //Setting
        buttonAdd.setOnClickListener(this);
        buttonView.setOnClickListener(this);
        buttonLogout.setOnClickListener(this);
    }

    //Adding an Employee
    private void addEmployee() {
        final String nama_barang = editTextName.getText().toString().trim();
        final String harga_barang = editTextDesg.getText().toString().trim();
        final String jenis_barang = editTextSal.getText().toString().trim();

        class AddEmployee extends AsyncTask<Void,Void,String>{

            ProgressDialog loading = ProgressDialog.show(menu.this,"Adding...","Wait...",false,false);

            @Override
            protected void onPreExecute() {
                super.onPreExecute();
            }

            @Override
            protected void onPostExecute(String s) {
                super.onPostExecute(s);
                loading.dismiss();
                Toast.makeText(menu.this,s, Toast.LENGTH_LONG).show();
            }

            @Override
            protected String doInBackground(Void... v) {
                HashMap<String,String> params = new HashMap<>();
                params.put(Config.KEY_EMP_NAME,nama_barang);
                params.put(Config.KEY_EMP_DESG,harga_barang);
                params.put(Config.KEY_EMP_SAL,jenis_barang);

                RequestHandler rh = new RequestHandler();
                String res = rh.sendPostRequest(Config.URL_ADD, params);
                return res;
            }
        }

        AddEmployee ae = new AddEmployee();
        ae.execute();
    }

    @Override
    public void onClick(View v) {
        if(v == buttonAdd){
            addEmployee();
        }

        if(v == buttonView){
            startActivity(new Intent(this, ViewAllEmployee.class));
        }
        if(v == buttonLogout) {
            startActivity(new Intent(this,MainActivity.class));
        }
    }
}
