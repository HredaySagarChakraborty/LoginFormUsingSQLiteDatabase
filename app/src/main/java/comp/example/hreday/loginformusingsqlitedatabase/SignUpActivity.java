package comp.example.hreday.loginformusingsqlitedatabase;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class SignUpActivity extends AppCompatActivity implements View.OnClickListener {
    private EditText editText1,editText2,editText3,editText4;
    private Button signUp;

    UserDetails userDetails;
 MyDatabaseHelper myDatabaseHelper;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_up);


        editText1=findViewById(R.id.nameId);
        editText2=findViewById(R.id.emailId);
        editText3=findViewById(R.id.userId);
        editText4=findViewById(R.id.passId);
        myDatabaseHelper=new MyDatabaseHelper(this);


        signUp=findViewById(R.id.singUpId);
        signUp.setOnClickListener(this);


        userDetails=new UserDetails();






    }

    @Override
    public void onClick(View v) {

        String name=editText1.getText().toString();
        String email=editText2.getText().toString();
        String username=editText3.getText().toString();
        String password=editText4.getText().toString();


        userDetails.setName(name);
        userDetails.setEmail(email);
        userDetails.setUsername(username);

        userDetails.setPassword(password);



        long rowId=myDatabaseHelper.insertData(userDetails);

        if(rowId>0){

            Toast.makeText(this, "Row"+rowId+"is inserted", Toast.LENGTH_SHORT).show();
        }

        else{
            Toast.makeText(this, "Row is not inserted yet", Toast.LENGTH_SHORT).show();

        }




    }
}
