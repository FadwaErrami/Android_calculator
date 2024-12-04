package com.example.calculator;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {
     Button login_btn,web_btn,call_btn;
     EditText password, username;
     Intent intent1,intent2,intent3;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
        login_btn = findViewById(R.id.login_btn);
        web_btn = findViewById(R.id.web_btn);
        call_btn= findViewById(R.id.call_btn);
        password= findViewById(R.id.password);
        username=findViewById(R.id.username);

        login_btn.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
               String login=username.getText().toString();
               if ((username.length()!= 0) && (password.equals("rami") )){
                    Toast.makeText(MainActivity.this, "Bonjour "+ login,Toast.LENGTH_LONG).show();
                     intent3 = new Intent(MainActivity.this,MainActivity2.class);
                     startActivity(intent3);
                }
                else{
                    Toast.makeText(MainActivity.this, "Empty login !!!", Toast.LENGTH_LONG).show();
                }
            }
        });
            web_btn.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    String url = "https://www.ensaf.ac.ma";
                    intent1 = new Intent(Intent.ACTION_VIEW, Uri.parse(url));
                    startActivity(intent1);
                }
            });
        call_btn.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                Uri uri = Uri.parse("tel:5554");
                intent2 = new Intent(Intent.ACTION_CALL, uri);
                startActivity(intent2);
            }
        });
    }
}