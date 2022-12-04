package com.example.proyectoahorromovil;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.Menu;

import com.example.proyectoahorromovil.databinding.ActivityMainBinding;
import com.google.android.material.navigation.NavigationView;

import androidx.navigation.NavController;
import androidx.navigation.Navigation;
import androidx.navigation.ui.AppBarConfiguration;
import androidx.navigation.ui.NavigationUI;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    private AppBarConfiguration mAppBarConfiguration;
    private ActivityMainBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        binding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        setSupportActionBar(binding.appBarMain.toolbar);

        DrawerLayout drawer = binding.drawerLayout;
        NavigationView navigationView = binding.navView;
        mAppBarConfiguration = new AppBarConfiguration.Builder(
                R.id.nav_pagos, R.id.nav_ahorros, R.id.nav_inversiones, R.id.nav_gastos, R.id.nav_ingresos)
                .setOpenableLayout(drawer)
                .build();
        NavController navController = Navigation.findNavController(this, R.id.nav_host_fragment_content_main);
        NavigationUI.setupActionBarWithNavController(this, navController, mAppBarConfiguration);
        NavigationUI.setupWithNavController(navigationView, navController);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        Intent intent;

        switch (item.getItemId()){

            case R.id.mi_add_pagos:
                intent = new Intent(this, PagosActivity.class);
                startActivity(intent);
                break;

            case R.id.mi_add_ahorros:
                intent = new Intent(this, AhorrosActivity.class);
                startActivity(intent);
                break;

            case R.id.mi_add_inversiones:
                intent = new Intent(this, InversionesActivity.class);
                startActivity(intent);
                break;

            case R.id.mi_add_gastos:
                intent = new Intent(this, GastosActivity.class);
                startActivity(intent);
                break;

            case R.id.mi_add_ingresos:
                intent = new Intent(this, IngresosActivity.class);
                startActivity(intent);
                break;
        }
        return super.onOptionsItemSelected(item);
    }

    @Override
    public boolean onSupportNavigateUp() {
        NavController navController = Navigation.findNavController(this, R.id.nav_host_fragment_content_main);
        return NavigationUI.navigateUp(navController, mAppBarConfiguration)
                || super.onSupportNavigateUp();
    }
}