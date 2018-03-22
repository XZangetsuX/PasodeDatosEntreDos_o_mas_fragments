package organizador.com.joven.ejem13fragmentos;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

public class Shower extends AppCompatActivity {

    private TextView msg1, msg2,msg3;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_2);

        msg1 = (TextView) findViewById(R.id.TextView1);
        msg2 = (TextView) findViewById(R.id.TextView2);
        msg3 = (TextView) findViewById(R.id.TextView3);


        Intent i = getIntent();
        msg1.setText(i.getStringExtra("msg1"));
        msg2.setText(i.getStringExtra("msg2"));
        msg3.setText(i.getStringExtra("msg3"));
    }
}
