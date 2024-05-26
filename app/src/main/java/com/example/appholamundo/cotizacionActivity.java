package com.example.appholamundo;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class cotizacionActivity extends AppCompatActivity {
    private EditText editValorAuto, editPagoInicial;
    private RadioGroup radioGroupPlazo;
    private TextView txtResultado, txtPregunta;
    private Button btnCalcular, btnLimpiar, btnCerrar;

    private RadioButton radio12, radio16, radio24, radio36;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_cotizacion);

        String pregunta = getIntent().getStringExtra("PREGUNTA");

        iniciarComponentes();
        txtPregunta.setText(pregunta);

        btnCalcular.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                try {
                    // Obtener los valores ingresados por el usuario
                    double valorAuto = Double.parseDouble(editValorAuto.getText().toString());
                    double pagoInicial = Double.parseDouble(editPagoInicial.getText().toString());
                    int plazoSeleccionadoId = radioGroupPlazo.getCheckedRadioButtonId();

                    // Obtener el valor del plazo seleccionado
                    int plazo = 0;
                    if (plazoSeleccionadoId == R.id.radio12) {
                        plazo = 12;
                    } else if (plazoSeleccionadoId == R.id.radio16) {
                        plazo = 16;
                    } else if (plazoSeleccionadoId == R.id.radio24) {
                        plazo = 24;
                    } else if (plazoSeleccionadoId == R.id.radio36) {
                        plazo = 36;
                    }

                    double enganche = valorAuto * (pagoInicial / 100);

                    // Calcular el saldo pendiente después del enganche
                    double saldoPendiente = valorAuto - enganche;

                    // Calcular la cotización mensual dividiendo el saldo pendiente por el plazo
                    double cotizacionMensual = saldoPendiente / plazo;

                    // Mostrar la cotización en el TextView de resultado
                    txtResultado.setText(String.format("Resultado de la cotización:\nEnganche: %.2f\nPago Mensual: %.2f\nTotal a Pagar: %.2f", enganche, cotizacionMensual, saldoPendiente));
                } catch (NumberFormatException e) {
                    txtResultado.setText("Por favor, ingrese valores válidos.");
                }
            }
        });

        btnLimpiar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                limpiarCampos();
            }
        });

        btnCerrar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                cerrarApp();
            }
        });

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
    }

    private void limpiarCampos() {
        editValorAuto.setText("");
        editPagoInicial.setText("");
        radioGroupPlazo.clearCheck();
        txtResultado.setText("");
    }

    private void cerrarApp() {
        finish();
    }

    public void iniciarComponentes() {
        editValorAuto = findViewById(R.id.editValorAuto);
        editPagoInicial = findViewById(R.id.editPagoInicial);
        radioGroupPlazo = findViewById(R.id.radioGroupPlazo);
        btnCalcular = findViewById(R.id.btnCalcular);
        btnLimpiar = findViewById(R.id.btnLimpiar);
        btnCerrar = findViewById(R.id.btnCerrar);
        txtResultado = findViewById(R.id.txtResultado);
        txtPregunta = findViewById(R.id.txtPregunta);

    }
}
}