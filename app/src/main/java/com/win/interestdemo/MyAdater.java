package com.win.interestdemo;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import java.util.List;

/**
 * author：WangShuang
 * Date: 2015/12/28 11:26
 * email：m15046658245_1@163.com
 */
public class MyAdater extends FragmentPagerAdapter {

    private List<String>  list;

    public MyAdater(FragmentManager fm, List<String> list) {
        super(fm);
        this.list = list;
    }

    //区别点  fragment  类似工程模式
    @Override
    public Fragment getItem(int position) {
        return  BlankFragment.newInstance(list.get(position));
    }

    @Override
    public int getCount() {
        return list.size();
    }

    @Override
    public CharSequence getPageTitle(int position) {
        return list.get(position);
    }
}
