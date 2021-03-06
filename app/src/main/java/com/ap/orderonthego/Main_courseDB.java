package com.ap.orderonthego;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;
import android.util.StringBuilderPrinter;

import java.util.ArrayList;
import java.util.List;

public class Main_courseDB extends SQLiteOpenHelper {
    int n;


	String q[]=new String[100];
	public static String DATABASE_NAME="Menu";

    //  VEG-TABLE
	public static String VTABLE_NAME="vmain_course";
	public static String VMAIN_COURSE_NAME="vmain_course_name";
	public static String VAMOUNT="vprice";
	public static String VSR_NO="vserial";

    //DESSERT TABLE
	public static String DTABLE_NAME="desserts";
	public static String DESSERT_NAME="dessert_name";
	public static String DAMOUNT="dprice";
	public static String DSR_NO="dserial";
	
	//NON-VEG TABLE
	public static String NTABLE_NAME="nonveg_main_course";
	public static String NMAIN_COURSE_NAME="nmain_course_name";
	public static String NAMOUNT="nprice";
	public static String NSR_NO="nserial";

    //VEG-STARTER TABLE
    public static String STABLE_NAME="Veg_Starter";
    public static String SNAME="s_name";
    public static String SPRICE="s_price";
    public static String CODE="s_serial";

    //NONVEG-STARTER TABLE
    public static String NSTABLE_NAME="NonVeg_Starter";
    public static String NSNAME="ns_name";
    public static String NSPRICE="ns_price";
    public static String NCODE="ns_serial";

    //OTHER TABLE
    public static String OTABLE_NAME="Other";
    public static String ONAME="o_name";
    public static String OPRICE="o_price";
    public static String OCODE="o_serial";

    //Admin Table

    public static String ATABLE_NAME="Admin";
    public static String ANAME="Name";
    public static String ANUMBER="Mnumber";

    //ALL TABLES
    public static String CAT_TABLE_NAME="main_category";
    public static String SERIAL="serial_no";
    public static String CAT_TABLE="Menu_Cat";

    SQLiteDatabase sdb;
	SQLiteOpenHelper sh;


	public Main_courseDB(Context context) {
		super(context, DATABASE_NAME, null, 1);
		sdb=this.getWritableDatabase();
		Log.d("database", "created");
	}

	@Override
	public void onCreate(SQLiteDatabase db) {

		//VEG-TABLE
		db.execSQL("create table "+VTABLE_NAME+"("+VSR_NO+" integer primary key autoincrement,"+VMAIN_COURSE_NAME+" text,"+VAMOUNT+" integer)");
		Log.d("vegtable", "created");
		
		
		//NON-VEG TABLE
		db.execSQL("create table nonveg_main_course(nserial integer primary key autoincrement,nmain_course_name text,nprice integer)");
		Log.d("non-vegtable", "created");
		
		//DESSERT TABLE
		    db.execSQL("create table "+DTABLE_NAME+"("+DSR_NO+" integer primary key autoincrement,"+DESSERT_NAME+" text,"+DAMOUNT+" integer)");
			Log.d("desserttable", "created");


		//VEG-STARTER TABLE
		db.execSQL("create table " + STABLE_NAME + " (s_serial  INTEGER PRIMARY KEY AUTOINCREMENT,s_name TEXT,s_price INTEGER)");
		Log.d("database operations", "veg_startertable created");


        //NONVEG-STARTER TABLE
        db.execSQL("create table " + NSTABLE_NAME + " (ns_serial  INTEGER PRIMARY KEY AUTOINCREMENT,ns_name TEXT,ns_price INTEGER)");
        Log.d("database operations", "nonveg_startertable created");

        //OTHER TABLE
		db.execSQL("create table " + OTABLE_NAME + " (o_serial  INTEGER PRIMARY KEY AUTOINCREMENT,o_name TEXT,o_price INTEGER)");
		Log.d("database operations", "other_table created");

        //Admin Table
        db.execSQL("create table " + ATABLE_NAME + " ("+ANUMBER+" INTEGER ,"+ANAME+" TEXT)");
        Log.d("database operations", "Admin_Table created");




        //TABLE FOR ALL TABLES
        db.execSQL("CREATE TABLE main_category(serial_no  INTEGER PRIMARY KEY AUTOINCREMENT,Menu_Cat TEXT)");
        Log.d("category table","created");


	}

	@Override
	public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS vmain_course");
        db.execSQL("DROP TABLE IF EXISTS desserts");
        db.execSQL("DROP TABLE IF EXISTS nonveg_main_course");
        db.execSQL("DROP TABLE IF EXISTS Veg_Starter");
        db.execSQL("DROP TABLE IF EXISTS NonVeg_Starter");
        db.execSQL("DROP TABLE IF EXISTS Other");
        db.execSQL("DROP TABLE IF EXISTS Admin");
        db.execSQL("DROP TABLE IF EXISTS main_category");
        onCreate(db);

	}

    public int cheak()
    {
        String sql = "select * from vmain_course";
        Cursor data = sdb.rawQuery(sql, null);

        data.moveToFirst();
        if (data.getCount() != 0)
        {
            data.moveToNext();


            return 0;
        }
        else
        {
            return 1;
        }
    }



	public void vinsertDB(){
		sdb=this.getWritableDatabase();
		ContentValues cv=new ContentValues();

		/*cv.put(VMAIN_COURSE_NAME, vegmainname);
		cv.put(VAMOUNT, vegprice);
        sdb.insert(VTABLE_NAME, null, cv);
        Log.d("insertion", "done");*/

		cv.put(VMAIN_COURSE_NAME, "Palak Paneer");
		cv.put(VAMOUNT, 50);
        sdb.insert(VTABLE_NAME, null, cv);
        Log.d("insertion", "done");

		cv.put(VMAIN_COURSE_NAME, "Veg Bhoona");
		cv.put(VAMOUNT, 100);
        sdb.insert(VTABLE_NAME, null, cv);
        Log.d("insertion", "done");

		cv.put(VMAIN_COURSE_NAME, "Veg Makhanwala");
		cv.put(VAMOUNT, 90);
        sdb.insert(VTABLE_NAME, null, cv);
        Log.d("insertion", "done");

		cv.put(VMAIN_COURSE_NAME, "Veg Kolhapuri");
		cv.put(VAMOUNT, 110);
        Log.d("insertion", "done");

	}
	public void ninsertDB(){
		sdb=this.getWritableDatabase();
		ContentValues cv=new ContentValues();

	/*	cv.put(NMAIN_COURSE_NAME, nonvegmain);
		cv.put(NAMOUNT, nonvegmainprice);
        sdb.insert(NTABLE_NAME, null, cv);
        Log.d("Ninsertion", "done");*/

		cv.put(NMAIN_COURSE_NAME, "Mutton Biryani");
		cv.put(NAMOUNT, 50);
        sdb.insert(NTABLE_NAME, null, cv);
        Log.d("Ninsertion", "done");

		cv.put(NMAIN_COURSE_NAME, "Chicken Handi");
		cv.put(NAMOUNT, 100);
        sdb.insert(NTABLE_NAME, null, cv);
        Log.d("Ninsertion", "done");

		cv.put(NMAIN_COURSE_NAME, "Fish fry");
		cv.put(NAMOUNT, 90);
        sdb.insert(NTABLE_NAME, null, cv);
        Log.d("Ninsertion", "done");

		cv.put(NMAIN_COURSE_NAME, "Egg Curry");
		cv.put(NAMOUNT, 110);

		
	}
	
	public void dinsertDB(){
		
		sdb=this.getWritableDatabase();
		ContentValues cv=new ContentValues();

		/*cv.put(DESSERT_NAME, dessertname);
		cv.put(DAMOUNT, dessertprice);
        sdb.insert(DTABLE_NAME, null, cv);
        Log.d("dinsertion", "done");*/

		cv.put(DESSERT_NAME, "Vanilla Milk Shake");
		cv.put(DAMOUNT, 50);
        sdb.insert(DTABLE_NAME, null, cv);
        Log.d("dinsertion", "done");

		cv.put(DESSERT_NAME, "Fruit Salad");
		cv.put(DAMOUNT, 70);
        sdb.insert(DTABLE_NAME, null, cv);
        Log.d("dinsertion", "done");

		cv.put(DESSERT_NAME, "Matka Kulfi");
		cv.put(DAMOUNT, 30);
        sdb.insert(DTABLE_NAME, null, cv);
        Log.d("dinsertion", "done");

		cv.put(DESSERT_NAME, "Triple Sunday");
		cv.put(DAMOUNT, 120);

		
	}

    public void sinsertDB(){
        sdb=this.getWritableDatabase();
        ContentValues cv=new ContentValues();

      /*  cv.put(SNAME, startername);
        cv.put(SPRICE, starterprice);
        sdb.insert(STABLE_NAME, null, cv);
        Log.d("sinsertion", "done");*/

        cv.put(SNAME, "Paneer Pakoda");
        cv.put(SPRICE, 50);
        sdb.insert(STABLE_NAME, null, cv);
        Log.d("sinsertion", "done");

        cv.put(SNAME, "Veg-manchurian dry");
        cv.put(SPRICE, 70);
        sdb.insert(STABLE_NAME, null, cv);
        Log.d("sinsertion", "done");

        cv.put(SNAME, "Tomato soup");
        cv.put(SPRICE, 30);
        sdb.insert(STABLE_NAME, null, cv);
        Log.d("sinsertion", "done");

        cv.put(SNAME, "Veg-sandwich");
        cv.put(SPRICE, 20);
        sdb.insert(STABLE_NAME, null, cv);
        Log.d("sinsertion", "done");

    }


    public void nsinsertDB(){
        sdb=this.getWritableDatabase();
        ContentValues cv=new ContentValues();

      /*  cv.put(NSNAME, nonvegstarter);
        cv.put(NSPRICE, nonvegstarterprice);
        sdb.insert(NSTABLE_NAME, null, cv);
        Log.d("Nsinsertion", "done");*/

        cv.put(NSNAME, "Chicken Tawa");
        cv.put(NSPRICE, 70);
        sdb.insert(NSTABLE_NAME, null, cv);
        Log.d("Nsinsertion", "done");

        cv.put(NSNAME, "Chicken nuggets");
        cv.put(NSPRICE, 70);
        sdb.insert(NSTABLE_NAME, null, cv);
        Log.d("Nsinsertion", "done");

        cv.put(NSNAME, "Chicken Soup");
        cv.put(NSPRICE, 30);
        sdb.insert(NSTABLE_NAME, null, cv);
        Log.d("Nsinsertion", "done");

        cv.put(NSNAME, "Chicken Hariyali Kabab");
        cv.put(NSPRICE, 20);
        sdb.insert(NSTABLE_NAME, null, cv);
        Log.d("Nsinsertion", "done");

    }
    public void oinsertDB(){
        sdb=this.getWritableDatabase();
        ContentValues cv=new ContentValues();

      /*  cv.put(ONAME, othername);
        cv.put(OPRICE, otherprice);
        sdb.insert(OTABLE_NAME, null, cv);
        Log.d("oinsertion", "done");*/

        cv.put(ONAME, "Jeera Rice");
        cv.put(OPRICE, 40);
        sdb.insert(OTABLE_NAME, null, cv);
        Log.d("oinsertion", "done");

        cv.put(ONAME, "Fried Rice");
        cv.put(OPRICE, 80);
        sdb.insert(OTABLE_NAME, null, cv);
        Log.d("oinsertion", "done");

        cv.put(ONAME, "Steam Rice");
        cv.put(OPRICE, 35);
        sdb.insert(OTABLE_NAME, null, cv);
        Log.d("oinsertion", "done");

        cv.put(ONAME, "Veg Biryani");
        cv.put(OPRICE, 90);
        sdb.insert(OTABLE_NAME, null, cv);
        Log.d("oinsertion", "done");

    }

    public void AadminDB() {
        sdb = this.getWritableDatabase();
        ContentValues cv = new ContentValues();

        cv.put(ANAME, "Anupam Shembekar");
        cv.put(ANUMBER, "9922269793");
        sdb.insert(ATABLE_NAME, null, cv);
        Log.d("ainsertion", "done");
    }

    public void tinsert(){
        sdb = this.getWritableDatabase();
        ContentValues cv = new ContentValues();

        cv.put(CAT_TABLE, VTABLE_NAME);
        sdb.insert(CAT_TABLE_NAME, null, cv);
        Log.d("tinsertion", "done");

        cv.put(CAT_TABLE, DTABLE_NAME);
        sdb.insert(CAT_TABLE_NAME, null, cv);
        Log.d("tinsertion", "done");

        cv.put(CAT_TABLE, STABLE_NAME);
        sdb.insert(CAT_TABLE_NAME, null, cv);
        Log.d("tinsertion", "done");

        cv.put(CAT_TABLE, OTABLE_NAME);
        sdb.insert(CAT_TABLE_NAME, null, cv);
        Log.d("tinsertion", "done");

        cv.put(CAT_TABLE, NSTABLE_NAME);
        sdb.insert(CAT_TABLE_NAME, null, cv);
        Log.d("tinsertion", "done");

        cv.put(CAT_TABLE, NTABLE_NAME);
        sdb.insert(CAT_TABLE_NAME, null, cv);
        Log.d("tinsertion", "done");
    }

    public void showDB(){
		sdb=this.getReadableDatabase();
		Cursor c=sdb.rawQuery("Select * from vmain_course",new String[]{"vmain_course_name","vprice"});
		c.moveToFirst();
		c.getString(1);

	}
    public int rox(String num)
    {
            String sql = "SELECT * FROM Admin WHERE Mnumber = '" + num + "'";
            Cursor data = sdb.rawQuery(sql, null);

            if (data.moveToFirst()){
                return 0;

            }
        else
            {
                return 1;
            }

    }
    public String[] showcategories()
    {

        String x;
        Cursor c;
        int i=0;

        c= sdb.rawQuery("select Menu_Cat from main_category",null);
        String p[]= new String[c.getCount()];

         while (c.moveToNext()){

         x=c.getString(c.getColumnIndex("Menu_Cat"));
             p[i]=x;

       i++;
    }
        return p;
    }


    public String[] showVStarters()
    {
        Cursor c;
        int j=0;

        c= sdb.rawQuery("select * from Veg_Starters",null);
        c.moveToFirst();
        do{
            q[j] = c.getString(1);
            // c.moveToNext();
            j++;
        }
        while (c.moveToNext());

        return q;
    }

    public String[] showVmainc()
    {
        Cursor c1;
        int k=0;

        c1= sdb.rawQuery("select * from vmain_course",null);
        c1.moveToFirst();
        do{
            q[k] = c1.getString(1);
            // c.moveToNext();
            k++;
        }
        while (c1.moveToNext());

        return q;
    }

    public void dynamicAdd(String tabname,String col1,String col2){
            sdb=this.getWritableDatabase();
        sdb.execSQL("create table if not exists " + tabname + " (sr_no  INTEGER PRIMARY KEY AUTOINCREMENT,"+col1+"  TEXT,"+col2+" INTEGER)");
        Log.d("database operations", "table created");

    }

    public void xyz(String tablename){

        sdb = this.getWritableDatabase();
        ContentValues cv = new ContentValues();

        cv.put(CAT_TABLE, tablename);
        sdb.insert(CAT_TABLE_NAME, null, cv);
        Log.d("tinsertion", "done");


    }



}
