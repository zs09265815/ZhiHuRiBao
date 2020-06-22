package com.example.zuoye1;
//张媛媛 1809A

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Toast;

import com.miguelcatalan.materialsearchview.MaterialSearchView;

public class Main2Activity extends AppCompatActivity {

    private Toolbar mToolbar;
    private MaterialSearchView mSrach;
    private MenuItem item;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        initView();
    }

    private void initView() {
        mToolbar = (Toolbar) findViewById(R.id.toolbar);
        mSrach = (MaterialSearchView) findViewById(R.id.srach);
        mToolbar.setTitle("toolbar");
        setSupportActionBar(mToolbar);

        mSrach.setOnSearchViewListener(new MaterialSearchView.SearchViewListener() {
            @Override
            public void onSearchViewShown() {
                Toast.makeText(Main2Activity.this, "onSearchViewShown", Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onSearchViewClosed() {
                Toast.makeText(Main2Activity.this, "onSearchViewClosed", Toast.LENGTH_SHORT).show();

            }
        });
        mSrach.setOnQueryTextListener(new MaterialSearchView.OnQueryTextListener() {
            @Override
            public boolean onQueryTextSubmit(String query) {
                Toast.makeText(Main2Activity.this, "onQueryTextSubmit"+query, Toast.LENGTH_SHORT).show();
                return true;
            }

            @Override
            public boolean onQueryTextChange(String newText) {
                return false;
            }
        });
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_item,menu);
        item = menu.findItem(R.id.select_search);
        mSrach.setMenuItem(item);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public void onBackPressed() {
        if (mSrach.isSearchOpen()){
            mSrach.closeSearch();
        }else {
            super.onBackPressed();
        }

    }
}
