package com.example.jasper.manageexpense;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;


public class Register extends Activity {
    EditText et1,et2;
    TextView tv;
    Button b;
    String name,pass;
    SQLiteDatabase sqLiteDatabase;
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.register);
        et1=(EditText)findViewById(R.id.editText7);
        et2=(EditText)findViewById(R.id.editText9);
        tv=(TextView) findViewById(R.id.textView21);
        name=et1.getText().toString();
        pass=et2.getText().toString();
        b=(Button)findViewById(R.id.button);
        sqLiteDatabase=openOrCreateDatabase("database1", Context.MODE_PRIVATE,null);
        b.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                try {
                    sqLiteDatabase.execSQL("insert into register values('"+et1.getText()+"','"+et2.getText()+"')");
                    Intent i1=new Intent(Register.this,Login.class);
                    startActivity(i1);

                }
                catch (Exception e)
                {
                    Toast.makeText(Register.this, e.toString(), Toast.LENGTH_LONG).show();
                }
            }
        });
    }
}
