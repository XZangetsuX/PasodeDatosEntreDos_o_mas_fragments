package organizador.com.joven.ejem13fragmentos;

import android.app.Fragment;
import android.app.FragmentTransaction;
import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;

public class Agregar extends Fragment {

    private EditText name,lastname,pass;
    private Button button;
    private  CallBackActivity callBackActivity;
    private String n,l,p;

    public Agregar(){

    }

    //Este se ejecuta automaticamente cuando se ejecuta el contructor
    //es importante por que aqui inflamos el layout y manipulamos los widgets.
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {
        View root = inflater.inflate(R.layout.layout_agregar,container,false);

        name =(EditText) root.findViewById(R.id.edtNombre);
        lastname =(EditText) root.findViewById(R.id.edtApellido);
        pass =(EditText) root.findViewById(R.id.edtcontraseña);
        button = (Button) root.findViewById(R.id.btnaceptar);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //eliminamos el fragmento
                getActivity().getFragmentManager().beginTransaction().remove(Agregar.this).commit();

                n = name.getText().toString();
                l = lastname.getText().toString();
                p = pass.getText().toString();


                FragmentTransaction transection = getFragmentManager().beginTransaction();
                Fragment fragment = new Messages();
                Bundle bundle=new Bundle();
                bundle.putString("msg1",n);
                bundle.putString("msg2",l);
                bundle.putString("msg3",p);
                fragment.setArguments(bundle); //data being send to SecondFragment
                transection.replace(R.id.contenedor, fragment);
                transection.commit();
            }
        });


        //return super.onCreateView(, container, savedInstanceState);
        return root;
    }

    //Se ejecuta cuando cargamos el layout
    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
    }


    public interface CallBackActivity{
        public void getData(String name, String lastname, String password);
        public void msgError(int i);

    }
    //Genera el proceso de callback que es impecindible si queremos regresar un valor a ala actividad que lo esta llamando
    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        try{
            //Upcasting
            callBackActivity = (CallBackActivity)getActivity();
        }catch (ClassCastException e){
            e.printStackTrace();
        }
    }
    //Regresa un valor a la actividad que lo esta llamado.


    @Override
    public void onResume() {
        super.onResume();
        name.setText("");
        lastname.setText("");
        pass.setText("");
    }
}
