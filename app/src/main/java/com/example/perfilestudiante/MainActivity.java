package com.example.perfilestudiante;

import android.os.Bundle;
import android.view.View;
import androidx.appcompat.app.AppCompatActivity;
import com.example.perfilestudiante.databinding.ActivityMainBinding;

public class MainActivity extends AppCompatActivity {

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

        }
    }

    private boolean validarCampos() {
        boolean esValido = true;

        String nombre = binding.etName.getText().toString().trim();
        String matricula = binding.etMatricula.getText().toString().trim();
        int carreraSeleccionada = binding.spinnerCarrera.getSelectedItemPosition();

        // Validar nombre
        if (nombre.isEmpty()) {
            binding.tvNameError.setVisibility(View.VISIBLE);
            esValido = false;
        } else {
            binding.tvNameError.setVisibility(View.GONE);
        }

        // Validar matrícula
        if (matricula.isEmpty()) {
            binding.tvMatriculaError.setVisibility(View.VISIBLE);
            esValido = false;
        } else {
            binding.tvMatriculaError.setVisibility(View.GONE);
        }

        // Validar carrera (posición 0 = "Selecciona tu carrera", cuenta como vacío)
        if (carreraSeleccionada == 0) {
            binding.tvCarreraError.setVisibility(View.VISIBLE);
            esValido = false;
        } else {
            binding.tvCarreraError.setVisibility(View.GONE);
        }

        return esValido;
    }
}