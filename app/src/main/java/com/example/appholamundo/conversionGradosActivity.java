package com.example.appholamundo;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.TextView;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class conversionGradosActivity extends AppCompatActivity {
    private EditText txtGrados;
    private RadioButton rdbCel, rdbFa;
    private TextView lblResultado;
    private Button btnCalcular, btnCerrar, btnLimpiar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_conversion_grados);
        iniciarComponentes();

        // Eventos Click
        // Calcular
        btnCalcular.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                float grados = 0.0f;
                if (txtGrados.getText().toString().matches("")) {
                    Toast.makeText(conversionGradosActivity.this, "Capturar la Cantidad", Toast.LENGTH_SHORT).show();
                } else {
                    grados = Float.parseFloat(txtGrados.getText().toString());
                    double conversion = 0;
                    if (rdbFa.isChecked()) {
                        conversion = (grados - 32) * 5 / 9;
                    } else {
                        conversion = (grados * 9 / 5) + 32;
                    }
                    lblResultado.setText(String.format("Resultado: %.2f", conversion));
                }
            }
        });

        // Limpiar
        btnLimpiar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                txtGrados.setText("");
                lblResultado.setText("");
                rdbCel.setChecked(false);
                rdbFa.setChecked(false);
            }
        });

        // Cerrar
        btnCerrar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
    }

    public void iniciarComponentes() {
        btnCalcular = findViewById(R.id.btnCalcular);
        btnLimpiar = findViewById(R.id.btnLimpiar);
        btnCerrar = findViewById(R.id.btnCerrar);
        rdbCel = findViewById(R.id.rdbCel);
        rdbFa = findViewById(R.id.rdbFa);
        lblResultado = findViewById(R.id.lblResultado);
        txtGrados = findViewById(R.id.txtCantidad);
    }
}
