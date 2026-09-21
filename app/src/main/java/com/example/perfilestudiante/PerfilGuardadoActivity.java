package com.example.perfilestudiante;

import android.os.Bundle;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;
import com.example.perfilestudiante.databinding.ActivityPerfilGuardadoBinding;

public class PerfilGuardadoActivity extends AppCompatActivity {

    private ActivityPerfilGuardadoBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        binding = ActivityPerfilGuardadoBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        String nombre = getIntent().getStringExtra(MainActivity.EXTRA_NOMBRE);
        String matricula = getIntent().getStringExtra(MainActivity.EXTRA_MATRICULA);
        String carrera = getIntent().getStringExtra(MainActivity.EXTRA_CARRERA);

        binding.tvSaludo.setText(getString(R.string.saludo_formato, nombre));
        binding.tvResumen.setText(getString(R.string.resumen_formato, nombre, matricula, carrera));

        Toast.makeText(this, R.string.toast_guardado, Toast.LENGTH_SHORT).show();

        binding.btnEditar.setOnClickListener(v -> finish());
    }
}