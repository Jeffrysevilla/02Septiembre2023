package uni.edu.ni.a02septiembre2023;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ActionMenuView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    EditText etProducto, etPrecio, etCantidad;
    Button btnTotal;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        etProducto = findViewById(R.id.etProducto);
        etPrecio = findViewById(R.id.etPrecio);
        etCantidad = findViewById(R.id.etCantidad);
        btnTotal = findViewById(R.id.btnTotal);

    }

    public void Total(View V) {

        if (etProducto.getText().toString().isEmpty()
                || etPrecio.getText().toString().isEmpty()
                || etCantidad.getText().toString().isEmpty())
            Toast.makeText(this, "Rellene los ddatos", Toast.LENGTH_SHORT).show();
else {

    double Bruto = Double.parseDouble(String.valueOf(etCantidad.getText()))
            * Double.parseDouble(String.valueOf(etPrecio.getText()));
    double Iva = Bruto * 0.15;
    double Total = Bruto + Iva;
    String Producto = etProducto.getText().toString();
    Intent intent = new Intent(getApplicationContext(), TotalP.class);
                intent.putExtra("Producto",Producto);
                intent.putExtra("Bruto",Bruto);
                intent.putExtra("Iva",Iva);
                intent.putExtra("Total",Total);

    startActivity(intent);
}

  }
    }