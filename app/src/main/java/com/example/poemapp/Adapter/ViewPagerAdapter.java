package com.example.poemapp.Adapter;

import androidx.viewpager.widget.PagerAdapter;

import android.view.View;
import android.view.ViewGroup;

import java.util.List;

/**
 * Created by dell on 2019/3/17.
 */

public class ViewPagerAdapter extends PagerAdapter {
    private List<View> mviewList;
    private List<String> mtitleList;

    public ViewPagerAdapter(List<View> mviewList,List<String> mtitleList){
        this.mviewList = mviewList;
        this.mtitleList = mtitleList;
    }
    @Override
    public int getCount() {
        return mviewList.size();
    }
    @Override
    public boolean isViewFromObject(View view, Object object) {
        return view == object;
    }
    @Override
    public void destroyItem(ViewGroup container, int position, Object object) {
        container.removeView(mviewList.get(position));
    }
    @Override
    public Object instantiateItem(ViewGroup container, int position) {

        container.addView(mviewList.get(position));
        return mviewList.get(position);
    }
    @Override
    public CharSequence getPageTitle(int position){
        return mtitleList.get(position);
    }
}
