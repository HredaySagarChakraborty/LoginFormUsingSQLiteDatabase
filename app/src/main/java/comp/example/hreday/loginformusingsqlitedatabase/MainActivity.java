package comp.example.hreday.loginformusingsqlitedatabase;

import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity  implements View.OnClickListener{

    private MyDatabaseHelper myDatabaseHelper;
    private EditText user,pass;
    private Button sign1,sign2;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        user=findViewById(R.id.usernameEditIdId);
        pass=findViewById(R.id.passwordEditIdId);
        sign1=findViewById(R.id.signInButton);
        sign2=findViewById(R.id.signUpButton);


        sign1.setOnClickListener(this);
        sign2.setOnClickListener(this);



        myDatabaseHelper=new MyDatabaseHelper(this);
        SQLiteDatabase sqLiteDatabase=myDatabaseHelper.getWritableDatabase();

    }

    @Override
    public void onClick(View v) {

        String user1=user.getText().toString();
        String pass1=pass.getText().toString();

        if(v.getId()==R.id.signInButton){

           Boolean result=myDatabaseHelper.insertPass(user1,pass1);
               if(result==true){


                   Intent intent=new Intent(MainActivity.this,Main2Activity.class);
                   startActivity(intent);
               }
               
               else{


                   Toast.makeText(getApplicationContext(), "UserName and password did not miss", Toast.LENGTH_SHORT).show();
               }

            }





        else if(v.getId()==R.id.signUpButton){
            Intent intent =new Intent(MainActivity.this,SignUpActivity.class);
            startActivity(intent);


        }

    }




}
