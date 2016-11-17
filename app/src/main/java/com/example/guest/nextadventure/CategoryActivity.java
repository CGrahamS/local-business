package com.example.guest.nextadventure;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import butterknife.Bind;
import butterknife.ButterKnife;

public class CategoryActivity extends AppCompatActivity {
    public static final String TAG = CategoryActivity.class.getSimpleName();
    private String mCategory;
    private String [] mCategoryName;
    private String [] mItems;
    @Bind(R.id.listView) ListView mistView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_category);
        ButterKnife.bind(this);
        mCategoryName = getResources().getStringArray(R.array.categories);
        Log.i(TAG, mCategoryName[1]);
        mCategory = getString(R.string.app_name);
        Intent intent = getIntent();
        mCategory = intent.getStringExtra("category");
        setTitle(mCategory);
        if (mCategory.equals("Men") || mCategory.equals("Women")) {
            mItems = getResources().getStringArray(R.array.clothing);
        } else if (mCategory.equals("Camp")) {
            mItems = getResources().getStringArray(R.array.camping);
        } else if (mCategory.equals("Climb")) {
            mItems = getResources().getStringArray(R.array.climbing);
        } else if (mCategory.equals("Downhill Ski") || mCategory.equals("XC Ski")) {
            mItems = getResources().getStringArray(R.array.skiing);
        } else if (mCategory.equals("Paddle")) {
            mItems = getResources().getStringArray(R.array.paddle);
        } else if (mCategory.equals("Snowboard")) {
            mItems = getResources().getStringArray(R.array.snowboard);
        } else if (mCategory.equals("Snowshoe")) {
            mItems = getResources().getStringArray(R.array.snowshoe);
        }

        ArrayAdapter adapter = new ArrayAdapter(this, android.R.layout.simple_list_item_1, mItems);
        mistView.setAdapter(adapter);
    }
}
