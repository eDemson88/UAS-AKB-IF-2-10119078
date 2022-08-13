package com.example.uas_10119078_akb.ui.profile;
//NIM : 10119078
//Nama : Adam Firdaus Darmawan
//Kelas : IF-2
import android.app.Dialog;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import com.example.uas_10119078_akb.R;
import com.example.uas_10119078_akb.ui.home.CategoryActivity;
import com.google.android.material.bottomnavigation.BottomNavigationView;

public class ProfileActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile);

        //Initialize And Assign Variable
        BottomNavigationView bottomNavigationView = findViewById(R.id.bottom_navigation);

        //Set Home Selected
        bottomNavigationView.setSelectedItemId(R.id.profile);

        //Perform ItemSelectedListener
        bottomNavigationView.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                switch (item.getItemId()){
                    case R.id.profile:
                        startActivity(new Intent(getApplicationContext(), ProfileActivity.class));
                        overridePendingTransition(0,0);
                        return true;
                    case R.id.notes:
                        startActivity(new Intent(getApplicationContext(), CategoryActivity.class));
                        overridePendingTransition(0,0);
                        return true;

                    case R.id.about:
                        final Dialog dialog = new Dialog(ProfileActivity.this);

                        //Memasang Title / Judul pada Custom Dialog
                        dialog.setTitle("About");

                        //Memasang Desain Layout untuk Custom Dialog
                        dialog.setContentView(R.layout.custom_design_dialog);

                        //Memasang Listener / Aksi saat tombol OK di Klik
                        Button DialogButton = dialog.findViewById(R.id.ok);
                        DialogButton.setOnClickListener(new View.OnClickListener() {
                            @Override
                            public void onClick(View v) {
                                dialog.dismiss();
                            }
                        });

                        dialog.show();
                        return true;
                }

                return false;
            }
        });
    }
}