package comp.example.hreday.loginformusingsqlitedatabase;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.os.Build;
import android.widget.Toast;

public class MyDatabaseHelper extends SQLiteOpenHelper {


    private static final String DATABASE_NAME = "student.db";
    private static final String TABLE_NAME = "student_table";
    private static final int VERSION_NUMBER = 5;
    private static final String ID = "_id";
    private static final String NAME = "Name";
    private static final String EMAIL = "Email";
    private static final String USERNAME = "Username";
    private static final String PASSWORD = "password";
    private static final String CREATE_TABLE = "CREATE TABLE " + TABLE_NAME + "(" + ID + " INTEGER  PRIMARY KEY AUTOINCREMENT," + NAME + " VARCHAR(255)," + EMAIL + "  TEXT NOT NULL ," + USERNAME + " TEXT NOT NULL," + PASSWORD + " TEXT NOT NULL)";
    private static final String DROP_TABLE = "DROP TABLE IF EXISTS " + TABLE_NAME;
    private Context context;

    public MyDatabaseHelper(Context context) {
        super(context, DATABASE_NAME, null, VERSION_NUMBER);

        this.context = context;
    }

    @Override
    public void onCreate(SQLiteDatabase db) {

        try {

            Toast.makeText(context, "OnCreate is called", Toast.LENGTH_SHORT).show();

            db.execSQL(CREATE_TABLE);


        } catch (Exception e) {
            Toast.makeText(context, "Exception" + e, Toast.LENGTH_SHORT).show();
        }


    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {


        try {

            Toast.makeText(context, "Onupgrade is called", Toast.LENGTH_SHORT).show();

            db.execSQL(DROP_TABLE);
            onCreate(db);
        } catch (Exception e) {
            Toast.makeText(context, "Exception" + e, Toast.LENGTH_SHORT).show();

        }


    }


    public long insertData(UserDetails userDetails) {

        SQLiteDatabase sqLiteDatabase = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put("NAME", userDetails.getName());
        contentValues.put("EMAIL", userDetails.getEmail());
        contentValues.put("USERNAME", userDetails.getUsername());
        contentValues.put("PASSWORD", userDetails.getPassword());

        long rowId = sqLiteDatabase.insert(TABLE_NAME, null, contentValues);

        return rowId;


    }

    public Boolean insertPass(String uname, String passs) {

        SQLiteDatabase sqLiteDatabase = this.getWritableDatabase();
        Cursor cursor = sqLiteDatabase.rawQuery("SELECT * FROM " + TABLE_NAME, null);

        Boolean result = false;
        if (cursor.getCount() == 0) {


            Toast.makeText(context, "No data is founded", Toast.LENGTH_SHORT).show();
        }
        else {


            while (cursor.moveToNext()) {

                String user1 = cursor.getString(3);
                String pass1 = cursor.getString(4);


                if (user1.equals(uname) && pass1.equals(passs)) {
                    result = true;
                    break;

                }

            }
        }
        return result;
    }

}
