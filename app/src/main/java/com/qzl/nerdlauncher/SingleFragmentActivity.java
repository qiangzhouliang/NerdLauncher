package com.qzl.nerdlauncher;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v7.app.AppCompatActivity;

/**
 * 这是一个activity抽象类
 * Created by Qzl on 2016-09-04.
 */
public abstract class SingleFragmentActivity extends AppCompatActivity {
    //创建fragment的抽象方法
    protected abstract Fragment createFragment();
    /**
     * LayoutRes : 返回值必须有效
     * @return
     */
    /*@LayoutRes
    protected int getLayoutResId(){
        return R.layout.activity_masterdetail;
    }*/
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_fragment);
        //setContentView(getLayoutResId());

        FragmentManager fm = getSupportFragmentManager();
        Fragment fragment = fm.findFragmentById(R.id.fragment_container);
        if (fragment == null){
            fragment = createFragment();
            //创建一个事务，将fragment添加给事务，并且提交事务
            fm.beginTransaction().add(R.id.fragment_container,fragment).commit();
        }
    }
}
