package com.example.zhihuribao;

import android.support.annotation.NonNull;
import android.support.design.widget.NavigationView;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.widget.Toolbar;
import android.view.Gravity;
import android.view.MenuItem;
import android.widget.FrameLayout;
import com.example.zhihuribao.app.AppConstants;
import com.example.zhihuribao.base.BaseActivity;
import com.example.zhihuribao.frangment.Aboutfragmnet;
import com.example.zhihuribao.frangment.CollectFramgment;
import com.example.zhihuribao.frangment.Gankfrangment;
import com.example.zhihuribao.frangment.Goldfrangment;
import com.example.zhihuribao.frangment.Settingsfrangment;
import com.example.zhihuribao.frangment.VtexFrangment;
import com.example.zhihuribao.frangment.WechatFrangment;
import com.example.zhihuribao.frangment.ZhihuFrangment;
//张媛媛  1809A
import java.util.ArrayList;

import butterknife.BindView;
import butterknife.ButterKnife;

public class MainActivity extends BaseActivity {
    @BindView(R.id.myToolbar)
    Toolbar myToolbar;
    @BindView(R.id.fr)
    FrameLayout fr;
    @BindView(R.id.na)
    NavigationView na;
    @BindView(R.id.dl)
    DrawerLayout dl;
    private ArrayList<Integer> list;
    private ArrayList<Fragment> list1;
    private FragmentManager manager;

    @Override
    protected int getLayoutId() {
        return R.layout.activity_main;
    }

    @Override
    protected void initView() {
        super.initView();
        myToolbar.setTitle(R.string.zhihu);
        na.setItemIconTintList(null);
        setSupportActionBar(myToolbar);
         ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(this, dl, myToolbar, 0, 0 );
        dl.addDrawerListener(toggle);
        toggle.syncState();
        //初始化title
        initTiltle();
        //初始化页面
        initFrangment();
        //初始化页面管理
        manager = getSupportFragmentManager();
        addZhihuFrangment();
    }
    private int mLastType=0;
    public void SwichFrangment(int type){
         FragmentTransaction transaction = manager.beginTransaction();
         Fragment fragment = list1.get(type);
        if (!fragment.isAdded()){
        transaction.add(R.id.fr,fragment);
        }
         Fragment mLastFrangmen = list1.get(mLastType);
        transaction.hide(mLastFrangmen);
        transaction.show(fragment);
        transaction.commit();
        mLastType=type;
        myToolbar.setTitle(list.get(type));

    }
    private void addZhihuFrangment() {
        FragmentTransaction transaction = manager.beginTransaction();
        transaction.add(R.id.fr,list1.get(0));
        transaction.commit();
    }

    private void initFrangment() {
        list1 = new ArrayList<>();
        list1.add(new ZhihuFrangment());
        list1.add(new WechatFrangment());
        list1.add(new Gankfrangment());
        list1.add(new Goldfrangment());
        list1.add(new VtexFrangment());
        list1.add(new CollectFramgment());
        list1.add(new Settingsfrangment());
        list1.add(new Aboutfragmnet());
    }

    private void initTiltle() {
        list = new ArrayList<>();
        list.add(R.string.zhihu);
        list.add(R.string.wechat);
        list.add(R.string.gank);
        list.add(R.string.gold);
        list.add(R.string.vtex);
        list.add(R.string.collect);
        list.add(R.string.settings);
        list.add(R.string.about);
    }

    @Override
    protected void initListener() {
        na.setNavigationItemSelectedListener(new NavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                item.setChecked(true);
                switch (item.getItemId()){
                    case R.id.zhihu:
                        SwichFrangment(AppConstants.Type_Zhihu);
                        break;
                    case R.id.wechat:
                        SwichFrangment(AppConstants.Type_Wechat);
                        break;
                    case R.id.gank:
                        SwichFrangment(AppConstants.Type_Gank);
                        break;
                    case R.id.gold:
                        SwichFrangment(AppConstants.Type_Gold);
                        break;
                    case R.id.vtex:
                        SwichFrangment(AppConstants.Type_Vtex);
                        break;
                    case R.id.collect:
                        SwichFrangment(AppConstants.Type_Collect);
                        break;
                    case R.id.settings:
                        SwichFrangment(AppConstants.Type_Setting);
                        break; case
                            R.id.about:
                        SwichFrangment(AppConstants.Type_About);
                        break;

                }
                dl.closeDrawer(Gravity.LEFT);
                return false;
            }
        });

    }
}
