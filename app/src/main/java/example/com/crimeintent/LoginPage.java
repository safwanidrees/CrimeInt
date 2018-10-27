package example.com.crimeintent;

import android.app.Notification;
import android.app.NotificationManager;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class  LoginPage extends AppCompatActivity {

    private EditText Name;
    private EditText Password;
    private TextView Info;
    private Button Login;
    private int counter = 5;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login_page);



        Name = (EditText)findViewById(R.id.etName);
        Password = (EditText)findViewById(R.id.etPassword);
        Info = (TextView)findViewById(R.id.tvInfo);
        Login = (Button)findViewById(R.id.btnLogin);

        Info.setText("No of attempts remaining: 5");

        Login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                validate(Name.getText().toString(), Password.getText().toString());


            }
        });


    }

    private void validate(String userName, String userPassword){
        if((userName.equals("Safwan"))||(userName.equals("safwan"))||(userName.equals("Abdullah"))||(userName.equals("abdullah")) && (userPassword.equals("1234"))){
            Intent intent = new Intent(LoginPage.this, CrimeListActivity.class);
            startActivity(intent);

            NotificationManager notif=(NotificationManager)getSystemService(Context.NOTIFICATION_SERVICE);
            String tittle="hello";
            String body="You Successfully Login";
            String subject="CrimeIntent";

            Notification notify=new Notification.Builder
                    (getApplicationContext())
                    .setContentTitle(tittle)
                    .setContentText(body)
                    .setContentTitle(subject)
                    .setSmallIcon(R.mipmap.ic_solved).build();

            notify.flags |= Notification.FLAG_AUTO_CANCEL;
            notif.notify(0, notify);


        }else{
            counter--;

            Info.setText("No of attempts remaining: " + String.valueOf(counter));

            if(counter == 0){
                Login.setEnabled(false);
            }
        }
    }

}