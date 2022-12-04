package com.example.proyectoahorromovil.Fragments.Awards;

import android.os.Bundle;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.proyectoahorromovil.R;

import java.util.ArrayList;
import java.util.List;

public class LogrosFragment extends Fragment {

    View view;
    List<CardAward> listCard;
    private RecyclerView recyclerView;

    public LogrosFragment() { /* Constructor vacío */ }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        listCard = new ArrayList<>();
        listCard.add(new CardAward("Paga tus deudas del mes", "1", R.drawable.ic_23_pago));
        listCard.add(new CardAward("Cumple todos los logros de la aplicación", "2", R.drawable.ic_32_objetivos));
        listCard.add(new CardAward("Ahorra $10.00 al día por una semana", "3", R.drawable.ic_21_ahorro));
        listCard.add(new CardAward("Usa Ahorromóvil toda la semana", "4", R.drawable.ic_29_like));
        listCard.add(new CardAward("Duplica tu ahorro de la semana pasada", "5", R.drawable.ic_08_cohete));
        listCard.add(new CardAward("Mejora tu balance 4 semanas seguidas", "6", R.drawable.ic_12_balance));
        listCard.add(new CardAward("Aumenta tus ahorros una semana seguida", "7", R.drawable.ic_02_grafica_arriba));
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.fragment_logros, container, false);
        recyclerView = view.findViewById(R.id.idRecyclerAward);
        RecyclerViewAdapter adapter = new RecyclerViewAdapter(getContext(), listCard);
        recyclerView.setLayoutManager(new GridLayoutManager(getContext(), 1));
        recyclerView.setAdapter(adapter);
        return view;
    }
}