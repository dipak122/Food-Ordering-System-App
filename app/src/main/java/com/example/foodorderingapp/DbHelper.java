package com.example.foodorderingapp;

        import android.content.ContentValues;
        import android.content.Context;
        import android.database.Cursor;
        import android.database.sqlite.SQLiteDatabase;
        import android.database.sqlite.SQLiteOpenHelper;

        import androidx.annotation.Nullable;

        import com.example.foodorderingapp.Models.OrdersModel;

        import java.util.ArrayList;

public class DbHelper extends SQLiteOpenHelper {

    final static String DBNAME = "mydatabase1.db";
    final static  int DIVERSIONS = 1;


    public DbHelper(@Nullable Context context) {
        super(context, DBNAME, null, DIVERSIONS);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {

        db.execSQL(
                "create table orders " +
                        "(id integer primary key autoincrement," +
                        "name text," +
                        "phone text," +
                        "price int," +
                        "image int," +
                        "quantity int," +
                        "foodname text,"+
                        "description text)"
        );
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

        db.execSQL("DROP table if exists orders");
        onCreate(db);
    }

    public boolean insertOrder(String name,String phone, int price,int image, String desc,String foodName,int quantity){
        SQLiteDatabase database =getReadableDatabase();
        ContentValues values =new ContentValues();
        values.put("name",name);
        values.put("phone",phone);
        values.put("price",price);
        values.put("image",image);
        values.put("description",desc);
        values.put("foodname",foodName);
        values.put("quantity",quantity);

        long id = database.insert("orders",null,values);

        if(id<=0){
            return false;
        }else{
            return true;
        }

    }

    public ArrayList<OrdersModel> getOrders(){
        ArrayList<OrdersModel> orders =new ArrayList<>();
        SQLiteDatabase database =this.getWritableDatabase();
        Cursor cursor =database.rawQuery("Select id,foodname,image,price from orders",null);
        if(cursor.moveToFirst()){
            while(cursor.moveToNext()){
                OrdersModel model = new OrdersModel();
                model.setOrderNumber(cursor.getInt(0)+"");
                model.setSoldItemName(cursor.getString(1));
                model.setOrderImage(cursor.getInt(2));
                model.setPrice(cursor.getInt(3)+"");
                orders.add(model);

            }
        }
        cursor.close();
        database.close();
        return orders;
    }
}
