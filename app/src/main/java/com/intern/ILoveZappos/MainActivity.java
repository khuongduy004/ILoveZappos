package com.intern.ILoveZappos;

import android.content.Intent;
import android.databinding.DataBindingUtil;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.inputmethod.EditorInfo;
import android.widget.TextView;
import android.view.KeyEvent;

import com.intern.ILoveZappos.databinding.ActivityMainBinding;

public class MainActivity extends AppCompatActivity {

    //extra message to pass search query
    public final static String EXTRA_MESSAGE = "com.intern.zapposapp.MESSAGE";

    //binding
    ActivityMainBinding mainBinding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        mainBinding = DataBindingUtil.setContentView(
                this, R.layout.activity_main);

        //when search button is clicked, start product activity to look for items
        mainBinding.searchButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startSearch();
            }
        });

        mainBinding.searchEditText.setOnEditorActionListener(enterKeyListener);

    }

    private TextView.OnEditorActionListener enterKeyListener = new TextView.OnEditorActionListener() {
        public boolean onEditorAction(TextView searchEditText, int actionId, KeyEvent event) {
            if ((actionId == EditorInfo.IME_NULL && event.getAction() == KeyEvent.ACTION_UP)
                    || actionId == EditorInfo.IME_ACTION_GO) {
                startSearch();
            }
            return true;
        }
    };

    private void startSearch() {
        String searchQuery = mainBinding.searchEditText.getText().toString();
        Intent intent = new Intent(MainActivity.this, ProductActivity.class);
        intent.putExtra(EXTRA_MESSAGE, searchQuery);
        startActivity(intent);
    }
}