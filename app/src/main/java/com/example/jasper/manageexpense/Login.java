package com.example.jasper.manageexpense;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;


public class Login extends Activity {
    Button b1,b2;
    TextView tv;
    EditText et1,et2;
    SQLiteDatabase sqLiteDatabase;
    String password;
    String password1;
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        b1=(Button)findViewById(R.id.button3);
        b2=(Button)findViewById(R.id.button2);
        et1=(EditText)findViewById(R.id.editText3);
        et2=(EditText)findViewById(R.id.editText6);
        tv=(TextView) findViewById(R.id.textView8);

        sqLiteDatabase=openOrCreateDatabase("database1", Context.MODE_PRIVATE,null);
        b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i1=new Intent(Login.this,Register.class);
                startActivity(i1);
            }
        });
        b2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                try {
                    Cursor c = sqLiteDatabase.rawQuery("SELECT * FROM register where name='"+et1.getText()+"'", null);
                    if (c.moveToFirst()) {
                        password=c.getString(1);
                        password1=et2.getText().toString();
                        if(password.equals(password1))
                        {
                            Intent i2=new Intent(Login.this,MainActivity.class);
                            startActivity(i2);
                        }
                        else
                        {
                            Toast.makeText(Login.this, "Incorrect username or password", Toast.LENGTH_LONG).show();
                        }
                    }
                    else
                    {
                        Toast.makeText(Login.this, "Incorrect username or password", Toast.LENGTH_LONG).show();
                    }

                }
                catch (Exception e)
                {
                    Toast.makeText(Login.this, e.toString(), Toast.LENGTH_LONG).show();
                }

            }
        });
    }
}
