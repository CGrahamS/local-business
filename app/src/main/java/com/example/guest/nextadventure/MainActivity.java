package com.example.guest.nextadventure;

import android.content.Intent;
import android.graphics.Color;
import android.graphics.Typeface;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.GridView;
import android.widget.TextView;
import android.widget.Toast;

import butterknife.Bind;
import butterknife.ButterKnife;

public class MainActivity extends AppCompatActivity {
    public static final String TAG = MainActivity.class.getSimpleName();
    @Bind(R.id.gridView) GridView mGridView;
    @Bind(R.id.textView2) TextView mTextView;
    @Bind(R.id.button) Button mButton;
    @Bind(R.id.button2) Button mButton2;
    private String[] mCategories;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);
        final Typeface adelleBold = Typeface.createFromAsset(getAssets(), "fonts/adelle-bold.ttf");
        mTextView.setTypeface(adelleBold);
        mCategories = getResources().getStringArray(R.array.categories);
        ArrayAdapter adapter = new ArrayAdapter(this, android.R.layout.simple_list_item_1, mCategories) {
            @Override
            public View getView(int position, View convertView, ViewGroup parent) {
                TextView textView = (TextView) super.getView(position, convertView, parent);
                textView.setTextSize(11.0f);
                textView.setGravity(0x11);
                textView.setTypeface(adelleBold);
                return textView;
            }
        };
        mGridView.setAdapter(adapter);

        mButton.setTypeface(adelleBold);
        mButton2.setTypeface(adelleBold);

        mGridView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                String category = ((TextView)view).getText().toString();
                Intent intent = new Intent(MainActivity.this, CategoryActivity.class);
                intent.putExtra("category", category);
                startActivity(intent);
            }
        });

    }
}
