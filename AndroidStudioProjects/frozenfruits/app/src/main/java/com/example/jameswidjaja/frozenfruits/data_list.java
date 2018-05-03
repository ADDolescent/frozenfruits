package com.example.jameswidjaja.frozenfruits;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;
import java.util.List;

public class data_list extends AppCompatActivity {
    private List<record> data_list = new ArrayList<>();
    private RecyclerView recyclerView;
    public data_Adapter mAdapter;

    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.data_list_view);
        recyclerView = findViewById(R.id.recycler_view);
        final FirebaseDatabase database=FirebaseDatabase.getInstance();
        DatabaseReference ref=database.getReference("frozenfruit/log");
        mAdapter=new data_Adapter(data_list);
        ref.orderByChild("barang").addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                for(DataSnapshot childsnapshot:dataSnapshot.getChildren()){
                    String nama=childsnapshot.child("nama").getValue(String.class);
                    String barang=childsnapshot.child("barang").getValue(String.class);
                    String kuantitas=childsnapshot.child("kuantitas").getValue(String.class);
                    String harga_satu=childsnapshot.child("harga_satu").getValue(String.class);
                    record r2=new record(""+nama,""+barang,""+harga_satu,""+kuantitas);
                    data_list.add(r2);
                    //TODO: add functionality for time maybe replace kuantitas and harga with int not string
                }
                mAdapter.notifyDataSetChanged();
                //TODO:replace with notifyItemInserted
            }

            @Override
            public void onCancelled(DatabaseError databaseError) {

            }
        });
        RecyclerView.LayoutManager mLayoutManager = new LinearLayoutManager(getApplicationContext());
        recyclerView.setLayoutManager(mLayoutManager);
        recyclerView.setItemAnimator(new DefaultItemAnimator());
        recyclerView.setAdapter(mAdapter);
        //TODO: find a way to put the toolbar on this activity
    }
}