package cultoftheunicorn.marvel;

import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import org.opencv.cultoftheunicorn.marvel.R;

public class PaymentActivity extends AppCompatActivity {

    EditText address,name,note,ammount;
    String payaddress ;
    String payname ;
    String transactionNote ;
    String payammount;
    Integer intammount;
    String currencyunit = "INR";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_payment);

        address = (EditText) findViewById(R.id.payeaddress);
        name = (EditText) findViewById(R.id.payename);
        note  = (EditText) findViewById(R.id.transaction_note);
        ammount = (EditText) findViewById(R.id.payammount);
    }

    public void pay(View view) {
        payaddress = address.getText().toString();
        payname = name.getText().toString();
        transactionNote = note.getText().toString();
        payammount = ammount.getText().toString();
        intammount = Integer.valueOf(payammount);

        if (payname.equals("")) {
            Toast.makeText(getApplicationContext(), "Please enter Payname", Toast.LENGTH_SHORT).show();
        }
        else if (payaddress.equals("")) {
            Toast.makeText(getApplicationContext(), "Please enter Payaddress", Toast.LENGTH_SHORT).show();
        }
        else if (transactionNote.equals("")) {
            Toast.makeText(getApplicationContext(), "Please enter transaction Note", Toast.LENGTH_SHORT).show();
        }
        else if (payammount.equals("")) {
            Toast.makeText(getApplicationContext(), "Please Fill the Details", Toast.LENGTH_SHORT).show();
        }
       if (intammount >5000 ) {
            Toast.makeText(getApplicationContext(), "Amount should be less than 5000", Toast.LENGTH_SHORT).show();
      }
        else if(!payaddress.equals("") || !payname.equals("") || !transactionNote.equals("") ){
            Uri uri = Uri.parse("upi://pay?pa=" + payaddress +
                    "&pn=" + payname
                    + "&tn=" + transactionNote
                    + "&am" + ammount
                    + "&cu" + currencyunit);
            Intent intent = new Intent(Intent.ACTION_VIEW, uri);
            startActivityForResult(intent, 1);
        }
    }

    public void onActivityResult(int requestCode , int resultCode, Intent data){
        if(data != null){
            String res = data.getStringExtra("response");
            String search = "SUCCESS";
            if (res != null) {
                if(res.toLowerCase().contains(search.toLowerCase())){
                    Toast.makeText(getApplicationContext(),"Successful",Toast.LENGTH_SHORT).show();
                }
                else {
                    Toast.makeText(getApplicationContext(),"Payment Failed",Toast.LENGTH_SHORT).show();
                }
            }
        }
    }
}