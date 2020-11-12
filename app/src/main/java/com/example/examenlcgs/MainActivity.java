package com.example.examenlcgs;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    TextView jtvTransporte,jtvComida,jtvCostoTotal;
    RadioButton jrbAvion,jrbBus,jrbTaxi,jrbLassagna,jrbPizza,jrbHamburguesa;
    CheckBox jcbConPropina,jcbSinpropina;
    EditText jetpasajeros;
    Button jbtnCalcular;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

       getSupportActionBar().hide();
       jtvTransporte=findViewById(R.id.tvTransporte);
        jtvComida=findViewById(R.id.tvComida);

        jetpasajeros=findViewById(R.id.etpasajeros);
        jtvCostoTotal=findViewById(R.id.tvCostoTotal);
        jrbAvion=findViewById(R.id.rbAvion);
        jrbBus=findViewById(R.id.rbBus);
        jrbTaxi=findViewById(R.id.rbTaxi);
        jrbLassagna=findViewById(R.id.rbLassagna);
        jrbPizza=findViewById(R.id.rbPizza);
        jrbHamburguesa=findViewById(R.id.rbHamburguesa);
        jcbConPropina=findViewById(R.id.cbConPropina);
        jcbSinpropina=findViewById(R.id.cbSinpropina);
        jbtnCalcular=findViewById(R.id.btnCalcular);

    }

    public void HallarValorTransporte (View view)
    {
        if(jrbAvion.isChecked())
            jtvTransporte.setText("350000");
        else
        if(jrbBus.isChecked())
            jtvTransporte.setText("200000");
        else
         jtvTransporte.setText("250000");

    }

    public void HallarValorComida (View view)
    {
        if(jrbLassagna.isChecked())
            jtvComida.setText("18000");
        else
        if(jrbPizza.isChecked())
            jtvComida.setText("15000");
        else
            jtvComida.setText("10000");

    }

   /* public void HallarPropina (View view)
    { double =
        if(jcbConPropina.isChecked())

            jtvPropina.setText("18000");
        else
            jtvPropina.setText("10000");

    }*/

    public void CalcularTotalViaje (View view)
    {
        //totalViaje= costoTransporte + CostoComida + Popina
        double costoTransporte,costoComida,costoTotal, totalPersonas, costoconPropina, propina;
        costoTransporte=Double.parseDouble((jtvTransporte.getText().toString()));
        costoComida=Double.parseDouble((jtvComida.getText().toString()));
        totalPersonas=Double.parseDouble((jetpasajeros.getText().toString()));

        costoTotal= (costoComida + costoTransporte)*totalPersonas ;
        costoconPropina = costoTotal * 1.10;

        if(jcbConPropina.isChecked())
            jtvCostoTotal.setText(String.valueOf(costoconPropina));
        else
            if(jcbSinpropina.isChecked())
             jtvCostoTotal.setText(String.valueOf(costoTotal));

    }

}