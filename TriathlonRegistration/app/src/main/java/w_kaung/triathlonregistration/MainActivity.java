package w_kaung.triathlonregistration;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;

import java.text.DecimalFormat;

public class MainActivity extends AppCompatActivity {
    double costPerPerson=725.00;
    int numberOfPeople;
    double totalCost;
    String locationChoice;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        final EditText tickets = (EditText)findViewById(R.id.txtPeople);
        final Spinner group =(Spinner)findViewById(R.id.txtLocation);
        Button cost = (Button)findViewById(R.id.btnCost);
        cost.setOnClickListener(new View.OnClickListener() {
            final TextView result = ((TextView) findViewById(R.id.txtResult));

            @Override
            public void onClick(View v) {
                numberOfPeople = Integer.parseInt(tickets.getText().toString());
                totalCost = costPerPerson * numberOfPeople;
                DecimalFormat currency = new DecimalFormat("###,###.##");
                locationChoice = group.getSelectedItem().toString();
                result.setText(locationChoice + " fee is $" + currency.format(totalCost));
            }
        });
    }
}
