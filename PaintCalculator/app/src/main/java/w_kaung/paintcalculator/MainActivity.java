package w_kaung.paintcalculator;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;

import java.text.DecimalFormat;

public class MainActivity extends AppCompatActivity {
    double gallon;
    int heightOfRoom;
    int circumferenceOfRoom;
    double totalFeet;
    int gallonTotal;
    String colorChoice;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        final EditText height = (EditText)findViewById(R.id.txtHeight);
        final EditText circumference = (EditText)findViewById(R.id.txtCircumference);
        final Spinner color =(Spinner)findViewById(R.id.txtColor);
        Button cost = (Button)findViewById(R.id.btnGallon);
        cost.setOnClickListener(new View.OnClickListener() {
            final TextView result = ((TextView) findViewById(R.id.txtResult));

            @Override
            public void onClick(View v) {
                heightOfRoom = Integer.parseInt(height.getText().toString());
                circumferenceOfRoom = Integer.parseInt(circumference.getText().toString());
                totalFeet = heightOfRoom * circumferenceOfRoom;
                gallon = totalFeet / 250;
                gallonTotal = (int) Math.ceil(gallon);
                colorChoice = color.getSelectedItem().toString();
                result.setText("Gallons needed for color " + colorChoice + " is " + gallonTotal);
            }
        });
    }
}
