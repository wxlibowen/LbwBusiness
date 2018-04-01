package view.fragment.home;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;

import com.android.mybusiness.R;

import view.fragment.BaseFragment;

/**
 * Created by Administrator on 2018/3/30.
 *
 */

public class HomeFragment extends BaseFragment  {
    private  View mContentView;



    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {
        mContentView=inflater.inflate(R.layout.fragment_home_layout,null);



        return mContentView;
    }
}
