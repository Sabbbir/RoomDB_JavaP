package com.sabbir.roomdb_javap;

import android.app.Application;

import androidx.annotation.NonNull;
import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;
import androidx.sqlite.db.SupportSQLiteDatabase;

//As only one table that's why Word.class
@Database(entities = {Word.class}, version = 1)
public abstract class WordDataBase extends RoomDatabase {

    public abstract WordDao getWordDao();

    public static WordDataBase buildDatabase(Application app){
        return Room.databaseBuilder(app, WordDataBase.class,"word_database")
                .addCallback(callback)
                .allowMainThreadQueries()
                .build();

    }

private static final Callback callback =
        new Callback(){
            @Override
            public void onOpen(@NonNull SupportSQLiteDatabase db) {
                super.onOpen(db);
                db.execSQL("DELETE FROM word_table;");
                db.execSQL("INSERT INTO word_table (word) VALUES ('LOL'),('LOL2'),('LOL3');");

            }
        };

}
