package w_kaung.splitthebill;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;

import java.text.DecimalFormat;

public class MainActivity extends AppCompatActivity {
    int totalPeople;
    double totalBill;
    double tipPerBill;
    String serviceChoice;
    double payPerPerson;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        final EditText people = (EditText)findViewById(R.id.txtPeople);
        final EditText bill = (EditText)findViewById(R.id.txtBill);
        final Spinner service =(Spinner)findViewById(R.id.txtService);
        Button cost = (Button)findViewById(R.id.btnCalculate);
        cost.setOnClickListener(new View.OnClickListener() {
            final TextView result = ((TextView) findViewById(R.id.txtResult));

            @Override
            public void onClick(View v) {
                totalPeople = Integer.parseInt(people.getText().toString());
                totalBill = Integer.parseInt(bill.getText().toString());
                tipPerBill = (totalBill / 100.00) * 18.00;
                payPerPerson = (totalBill + tipPerBill) / totalPeople;
                serviceChoice = service.getSelectedItem().toString();
                DecimalFormat currency = new DecimalFormat("###,###.##");
                result.setText("Service was " + serviceChoice + " and your total per person is $" + currency.format(payPerPerson));
            }
        });
    }
}



