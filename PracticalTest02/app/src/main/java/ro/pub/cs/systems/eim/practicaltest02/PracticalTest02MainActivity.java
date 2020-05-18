package ro.pub.cs.systems.eim.practicaltest02;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class PracticalTest02MainActivity extends AppCompatActivity {
    private Button startServer;
    private Button run;
    private TextView result;
    private EditText addrClient;
    private EditText portClient;
    private EditText portServer;
    private ServerThread serverThread = null;
    private ConnectButtonClickListener connectButtonClickListener = new ConnectButtonClickListener();

    private class ConnectButtonClickListener implements Button.OnClickListener {

        @Override
        public void onClick(View view) {
            String portS = portServer.getText().toString();
            if (portS == null || portS.isEmpty()) {
                Toast.makeText(getApplicationContext(), "Fill Server Port!", Toast.LENGTH_SHORT).show();
                return;
            }
            serverThread = new ServerThread(Integer.parseInt(portS));
            if (serverThread.getServerSocket() == null) {
                Log.e(Constants.TAG, "Server thread failed!");
                return;
            }
            serverThread.start();
        }

    }
    
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
        startServer.setOnClickListener(connectButtonClickListener);

    }



    @Override
    protected void onDestroy() {
        if (serverThread != null) {
            serverThread.stopThread();
        }
        super.onDestroy();
    }
}
