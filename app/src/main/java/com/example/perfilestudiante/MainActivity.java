package com.example.perfilestudiante;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import androidx.appcompat.app.AppCompatActivity;
import com.example.perfilestudiante.databinding.ActivityMainBinding;

public class MainActivity extends AppCompatActivity {

    public static final String EXTRA_NOMBRE = "extra_nombre";
    public static final String EXTRA_MATRICULA = "extra_matricula";
    public static final String EXTRA_CARRERA = "extra_carrera";

    private ActivityMainBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        binding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        binding.btnSave.setOnClickListener(v -> guardarPerfil());
    }

    private void guardarPerfil() {
        if (validarCampos()) {
            String nombre = binding.etName.getText().toString().trim();
            String matricula = binding.etMatricula.getText().toString().trim();
            String carrera = binding.spinnerCarrera.getSelectedItem().toString();

            Intent intent = new Intent(MainActivity.this, PerfilGuardadoActivity.class);
            intent.putExtra(EXTRA_NOMBRE, nombre);
            intent.putExtra(EXTRA_MATRICULA, matricula);
            intent.putExtra(EXTRA_CARRERA, carrera);
            startActivity(intent);
        }
    }

    private boolean validarCampos() {
        boolean esValido = true;

        String nombre = binding.etName.getText().toString().trim();
        String matricula = binding.etMatricula.getText().toString().trim();
        int carreraSeleccionada = binding.spinnerCarrera.getSelectedItemPosition();

        if (nombre.isEmpty()) {
            binding.tvNameError.setVisibility(View.VISIBLE);
            esValido = false;
        } else {
            binding.tvNameError.setVisibility(View.GONE);
        }

        if (matricula.isEmpty()) {
            binding.tvMatriculaError.setVisibility(View.VISIBLE);
            esValido = false;
        } else {
            binding.tvMatriculaError.setVisibility(View.GONE);
        }

        if (carreraSeleccionada == 0) {
            binding.tvCarreraError.setVisibility(View.VISIBLE);
            esValido = false;
        } else {
            binding.tvCarreraError.setVisibility(View.GONE);
        }

        return esValido;
    }
}