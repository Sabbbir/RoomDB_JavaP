package com.sabbir.roomdb_javap;

import android.app.Application;
import android.os.AsyncTask;
import android.os.Bundle;

import com.google.android.material.snackbar.Snackbar;

import androidx.appcompat.app.AppCompatActivity;

import android.util.Log;
import android.view.View;

import androidx.navigation.NavController;
import androidx.navigation.Navigation;
import androidx.navigation.ui.AppBarConfiguration;
import androidx.navigation.ui.NavigationUI;

import com.sabbir.roomdb_javap.databinding.ActivityMainBinding;

import android.view.Menu;
import android.view.MenuItem;
import android.widget.Button;
import android.widget.TextView;

import java.util.List;

public class MainActivity extends AppCompatActivity {

    private WordDataBase mDataBase;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Button button=findViewById(R.id.button);
        TextView tv=findViewById(R.id.textView);

        mDataBase = WordDataBase.buildDatabase(getApplication());
  List<Word> words = mDataBase.getWordDao().getAllWords();
  String w="";
  for (Word word:words){
      String s=word.getWord();
      w=w+s+"\n";
      tv.setText(w);
  }
//        Log.i("MAMUUUUUUUUU", words.toString());





    }

}