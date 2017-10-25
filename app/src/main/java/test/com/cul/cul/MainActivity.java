package test.com.cul.cul;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    private static boolean nextCharMustUp=true;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button btnC = (Button) findViewById(R.id.btnCurrectit);
        final EditText edtInput = (EditText) findViewById(R.id.edtInput);
        final TextView txtOutput = (TextView) findViewById(R.id.txtvOutput);

        btnC.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                String sentence = edtInput.getText().toString();
                StringBuilder s = new StringBuilder(sentence);

                for(int i=0 ; i<sentence.length() ; i++){
                    char c = s.charAt(i);

                    if(nextCharMustUp){
                        s.setCharAt(i,Character.toUpperCase(c));
                    }else{
                        s.setCharAt(i, Character.toLowerCase(c));
                    }

                    if(c=='.'){
                        nextCharMustUp=true;
                    }else if(nextCharMustUp && c==' '){
                        nextCharMustUp=true;
                    }else{
                        nextCharMustUp=false;
                    }
                }
                txtOutput.setText(s.toString());
            }
        });
    }
}
