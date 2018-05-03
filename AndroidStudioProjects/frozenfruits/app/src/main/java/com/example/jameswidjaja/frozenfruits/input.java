package com.example.jameswidjaja.frozenfruits;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.EditText;

import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class input extends AppCompatActivity {
    private EditText barang, kuantitas,harga_satu;
    String data_barang, data_kuantitas, data_harga,data_nama;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_input);
        barang= findViewById(R.id.Barang);
        kuantitas = findViewById(R.id.Kuantitas);
        harga_satu= findViewById(R.id.Harga_satu);
    }

    public void enter(View view){
        SharedPreferences pref = getApplicationContext().getSharedPreferences("MyPref", 0);
        data_nama="james";
        /*
        TODO: This is placeholder pls replace with actual name
        TODO: Make settings activity to keep name, maybe tie data to email so cannot be changed or else confusing if change name
        */
        data_barang=barang.getText().toString();
        data_harga=harga_satu.getText().toString();
        data_kuantitas = kuantitas.getText().toString();
        final FirebaseDatabase database=FirebaseDatabase.getInstance();
        DatabaseReference logref=database.getReference("frozenfruit/log");
        String id=logref.push().getKey();
        record r=new record(data_nama,data_barang,data_harga, data_kuantitas);
        logref.child(id).setValue(r, new DatabaseReference.CompletionListener(){
            @Override
            public void onComplete(DatabaseError databaseError, DatabaseReference databaseReference) {
                if (databaseError != null) {
                    System.out.println("Data could not be saved " + databaseError.getMessage());
                } else {
                    System.out.println("Data saved successfully.");
                    Intent intent = new Intent(input.this, MainActivity.class);
                    startActivity(intent);
                }
            }
        });
    }
}
