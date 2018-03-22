package organizador.com.joven.ejem13fragmentos;

import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements View.OnClickListener, Agregar.CallBackActivity {


    private Button add,delete,show;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        add = (Button) findViewById(R.id.btnAgregar);
        delete = (Button) findViewById(R.id.btnBorrar);
        show = (Button) findViewById(R.id.btnMostrar);
        add.setOnClickListener(this);
        delete.setOnClickListener(this);
        show.setOnClickListener(this);


    }

    @Override
    public void onClick(View v) {
        FragmentManager fm = getFragmentManager();//no sea la version v4
        //FragmentManager fm = getSupportFragmentManager();//Para la version v4
        FragmentTransaction fragmentTransaction = fm.beginTransaction();//comensamos unatrasaccion de fragmentos
        switch (v.getId()){
            case R.id.btnAgregar:
                fragmentTransaction.replace(R.id.contenedor,new Agregar()).commit();
                getSupportActionBar().setTitle("Add");
                break;
        }
    }

    @Override
    public void getData(String name, String lastname, String password) {
        Toast.makeText(this, "name: " +name, Toast.LENGTH_SHORT).show();

    }

    @Override
    public void msgError(int i) {

    }
}