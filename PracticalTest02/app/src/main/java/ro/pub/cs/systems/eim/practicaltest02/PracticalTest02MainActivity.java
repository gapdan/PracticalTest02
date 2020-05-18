package ro.pub.cs.systems.eim.practicaltest02;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class PracticalTest02MainActivity extends AppCompatActivity {
    private Button startServer;
    private Button run;
    private TextView result;
    private EditText addrClient;
    private EditText portClient;
    private EditText portServer;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_practical_test02_main);
        startServer = (Button) findViewById(R.id.button2);
        run = (Button) findViewById(R.id.button);
        result = (TextView) findViewById(R.id.textView3);
        addrClient = (EditText)findViewById(R.id.editText4);
        portClient = (EditText)findViewById(R.id.editText3);
        portServer = (EditText)findViewById(R.id.editText2);
        
    }
}
