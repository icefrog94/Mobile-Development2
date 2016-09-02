package w_kaung.chicagocabfare;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    double price = 3.25;
    double fee = 3.00;
    int distanceOfTrip;
    double tripPrice;
    String carChoice;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        final EditText distance = (EditText)findViewById(R.id.txtDistance);
        final Spinner car =(Spinner)findViewById(R.id.txtCar);
        Button cost = (Button)findViewById(R.id.btnCalculate);
        cost.setOnClickListener(new View.OnClickListener() {
            final TextView result = ((TextView) findViewById(R.id.txtResult));

            @Override
            public void onClick(View v) {
                distanceOfTrip = Integer.parseInt(distance.getText().toString());
                tripPrice = (distanceOfTrip * price) + fee;
                carChoice = car.getSelectedItem().toString();
                result.setText("Price for car " + carChoice + " is $" + tripPrice);
            }
        });
    }
}
