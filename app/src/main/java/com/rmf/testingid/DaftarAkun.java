package com.rmf.testingid;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.material.textfield.TextInputEditText;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class DaftarAkun extends AppCompatActivity {


    private EditText etUsername,etEmail;
    private TextInputEditText et_Password;
    private Button btnkregister;
    private ApiInterface apiInterface;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_daftar_akun);
    }

    private void initialUI(){
        etUsername = findViewById(R.id.editTextTextPersonName);
        et_Password = findViewById(R.id.input_edit_password);
        btnkregister = findViewById(R.id.button);


        apiInterface = ApiClient.getClient().create(ApiInterface.class);
        btnkregister.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Call<LoginResult> loginCall = apiInterface.register(new Register(etUsername.getText().toString(),et_Password.getText().toString(),etEmail.getText().toString()));
                loginCall.enqueue(new Callback<LoginResult>() {
                    @Override
                    public void onResponse(Call<LoginResult> call, Response<LoginResult> response) {
                        int StatusCode = 0;
                        if(response.isSuccessful()){

                            StatusCode = response.body().getStatusCode();
                            if(StatusCode == 2000){

                                Toast.makeText(DaftarAkun.this, response.body().getMessage(), Toast.LENGTH_SHORT).show();
                            }
                            else{
                                Toast.makeText(DaftarAkun.this, "Username atau Password Salah", Toast.LENGTH_SHORT).show();
                            }
                        }
                        else{
                            Toast.makeText(DaftarAkun.this, "Gagal Daftar", Toast.LENGTH_SHORT).show();
                        }
                    }

                    @Override
                    public void onFailure(Call<LoginResult> call, Throwable t) {
                        Toast.makeText(DaftarAkun.this, "ERR : "+t.getMessage(), Toast.LENGTH_SHORT).show();
                    }
                });
            }
        });


    }
}