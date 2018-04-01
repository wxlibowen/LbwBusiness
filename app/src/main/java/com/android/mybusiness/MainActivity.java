package com.android.mybusiness;

import android.app.Fragment;
import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.os.Bundle;
import android.text.Layout;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;

import com.android.mybusiness.activity.BaseActivity;

import view.fragment.home.HomeFragment;
import view.fragment.home.MessageFragment;
import view.fragment.home.MineFragment;

public class MainActivity extends BaseActivity implements View.OnClickListener {
    private FragmentManager fm;
    private HomeFragment mHomeFragment;
    private MessageFragment mMessageFragment;
    private MineFragment mMineFragment;
    private Fragment mCurrent;
    //如果报错删除此处
//    private FragmentTransaction transaction;
    private LinearLayout mHomeLayout;
    private LinearLayout mMessageLayout;
    private LinearLayout mMineLayout;
    private ImageView mHomeImage;
    private ImageView mMessageImage;
    private ImageView mMineImage;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //初始化页面中的控件
        initView();
        //添加默认显示的Fragment
        mHomeFragment=new HomeFragment();
        fm=getFragmentManager();
        FragmentTransaction transaction=fm.beginTransaction();
        transaction.replace(R.id.content_layout,mHomeFragment);
        transaction.commit();



    }

    private void initView() {
        mHomeLayout=findViewById(R.id.home_layout_view);
        mMessageLayout=findViewById(R.id.message_layout_view);
        mMineLayout=findViewById(R.id.mine_layout_view);
        mHomeImage=findViewById(R.id.home_image_view);
        mMessageImage=findViewById(R.id.message_image_view);
        mMineImage=findViewById(R.id.mine_image_view);
        mHomeLayout.setOnClickListener(this);
        mMineLayout.setOnClickListener(this);
        mMessageLayout.setOnClickListener(this);
    }
    //隐藏Fragment
private void hideFragment(Fragment fragment,FragmentTransaction ft){


        if (fragment!=null){
            ft.hide(fragment);
        }

}
    @Override
    public void onClick(View view) {
    FragmentTransaction mTransaction=fm.beginTransaction();
        switch (view.getId()){
            //点击主页按钮
            case R.id.home_layout_view:
                mHomeImage.setImageResource(R.drawable.homechecked);
                mMessageImage.setImageResource(R.drawable.message);
                mMineImage.setImageResource(R.drawable.home);
                //将home显示在用户面前
                hideFragment(mMessageFragment,mTransaction);
                hideFragment(mMineFragment,mTransaction);
                if (mHomeFragment==null){
                    mHomeFragment=new HomeFragment();
                    mTransaction.add(R.id.content_layout,mHomeFragment);
                }else {
                    mTransaction.show(mHomeFragment);
                }

                break;
            //点击消息按钮
            case R.id.message_layout_view:
                mHomeImage.setImageResource(R.drawable.home);
                mMessageImage.setImageResource(R.drawable.messagechecked);
                mMineImage.setImageResource(R.drawable.home);
                //将message显示在用户面前
                hideFragment(mMineFragment,mTransaction);
                hideFragment(mHomeFragment,mTransaction);
                if (mMessageFragment==null){
                    mMessageFragment=new MessageFragment();
                    mTransaction.add(R.id.content_layout,mMessageFragment);
                }else {
                    mTransaction.show(mMessageFragment);
                }

                break;
            //点击我的按钮
            case R.id.mine_layout_view:
                mHomeImage.setImageResource(R.drawable.home);
                mMessageImage.setImageResource(R.drawable.message);
                mMineImage.setImageResource(R.drawable.homechecked);
                //将mine显示在用户面前
                hideFragment(mMessageFragment,mTransaction);
                hideFragment(mHomeFragment,mTransaction);
                if (mMineFragment==null){
                    mMineFragment=new MineFragment();
                    mTransaction.add(R.id.content_layout,mMineFragment);
                }else {
                    mTransaction.show(mMineFragment);
                }

                break;
            default:
                break;



        }
        mTransaction.commit();
    }
}
