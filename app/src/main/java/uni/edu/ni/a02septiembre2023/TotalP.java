package uni.edu.ni.a02septiembre2023;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class TotalP extends AppCompatActivity {
    TextView tvBruto, tvIVA, tvTotal,tvProducto;
    Button BtnRegresar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_total_p);
        tvProducto = findViewById(R.id.tvProducto);
        tvBruto = findViewById(R.id.tvBruto);
        tvIVA = findViewById(R.id.tvIVA);
        tvTotal = findViewById(R.id.tvTotal);
        BtnRegresar=findViewById(R.id.btnRegresar);
        //Recoger los datos enviado desde la activdad principal

        Intent i=getIntent();

        tvProducto.setText("Producto  "+i.getStringExtra("Producto"));
        tvBruto.setText("Bruto:"+i.getDoubleExtra("Bruto",0));
        double Iva=i.getDoubleExtra("Iva",0);
        tvIVA.setText("Iva :"+Iva);
        tvTotal.setText("Neto "+i.getDoubleExtra( "Total",0));

        BtnRegresar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent  intent= new Intent(getApplicationContext(),MainActivity.class);
                startActivity(intent);
            }
        });
    }

}