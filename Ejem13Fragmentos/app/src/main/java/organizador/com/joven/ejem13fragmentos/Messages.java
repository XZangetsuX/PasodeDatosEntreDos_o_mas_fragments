package organizador.com.joven.ejem13fragmentos;


import android.content.Intent;
import android.os.Bundle;
import android.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;


public class Messages extends Fragment {


    private Button button;
    private TextView msg2, msg1, msg3;


    public Messages() {
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.fragment_message, container, false);
        msg1 =(TextView)v.findViewById(R.id.msg1);
        msg2 =(TextView)v.findViewById(R.id.msg2);
        msg3 =(TextView)v.findViewById(R.id.msg3);

        Bundle bundle=getArguments();
        msg2.setText(String.valueOf(bundle.getString("msg1")));
        msg1.setText(String.valueOf(bundle.getString("msg2")));
        msg3.setText(String.valueOf(bundle.getString("msg3")));
        button = (Button) v.findViewById(R.id.button);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                enviar();
            }
        });
        return v;
    }
    private void enviar() {
        Intent i = new Intent(getActivity().getBaseContext(),Shower.class);
        i.putExtra("msg1", msg2.getText().toString());
        i.putExtra("msg2", msg1.getText().toString());
        i.putExtra("msg3", msg3.getText().toString());
        getActivity().startActivity(i);
    }


}
