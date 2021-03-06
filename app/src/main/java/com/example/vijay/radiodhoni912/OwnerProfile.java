package com.example.vijay.radiodhoni912;

import android.os.Bundle;
import android.support.v4.content.ContextCompat;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import java.util.Timer;
import java.util.TimerTask;

public class OwnerProfile extends AppCompatActivity {

    ViewPager viewPager;
    LinearLayout sliderDots;
    private  int dotscount;
    private ImageView[] dots;
    TextView textView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_owner_profile);

        textView = (TextView)findViewById(R.id.about_owner);
        textView.setText("Rashadul Hossain Chowdhury ,the Assistant Secretary, Central Sub-Committee, Bangladesh Awami League presently hails from Chandpur. He was born to Mr. Mofazzol Hossain Chowdhury Maya on 28th August, 1976  and completed his BA (Hons) from Mohammadpur Central College and HSC from Adamjee Cantonment College. Mr Chowdhury has been professionally affiliated to many organizations till date. He was the Founder of Wega Zone Limited as well as the Founder & Chairman of Radio Dhoni 91.2 FM. In his professional tenure he has also been the Founde rof Maya Corporation. His expresses liberal political views and takes interest in Singing, Guitar, Driving, Scuba Diving, Music and Politics. Mr. Chowdhury takes special liking towards travelling and exploring different places and learning different cultures. He has travelled to a lot of countries till the present time and wishes to continue learning more in the future.");


        viewPager = (ViewPager)findViewById(R.id.viewPager);
        sliderDots = (LinearLayout)findViewById(R.id.SliderDots);

        ViewPagerAdapter viewPagerAdapter = new ViewPagerAdapter(this);
        viewPager.setAdapter(viewPagerAdapter);
        dotscount = viewPagerAdapter.getCount();
        dots = new ImageView[dotscount];

        for(int i=0 ; i<dotscount; i++){
            dots[i] = new ImageView(this);
            dots[i].setImageDrawable(ContextCompat.getDrawable(getApplicationContext(),R.drawable.nonactive_dot));
            LinearLayout.LayoutParams params = new LinearLayout.LayoutParams(LinearLayout.LayoutParams.WRAP_CONTENT,LinearLayout.LayoutParams.WRAP_CONTENT);
            params.setMargins(8,0,8,0);
            sliderDots.addView(dots[i],params);
        }

        dots[0].setImageDrawable(ContextCompat.getDrawable(getApplicationContext(),R.drawable.active_dot));

        viewPager.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

            }

            @Override
            public void onPageSelected(int position) {

                for(int i=0; i<dotscount;i++){

                    dots[i].setImageDrawable(ContextCompat.getDrawable(getApplicationContext(),R.drawable.nonactive_dot));
                }

                dots[position].setImageDrawable(ContextCompat.getDrawable(getApplicationContext(),R.drawable.active_dot));

            }

            @Override
            public void onPageScrollStateChanged(int state) {

            }
        });


        Timer timer = new Timer();
        timer.scheduleAtFixedRate(new MyTimerTask(),2000,4000);


    }
    public class MyTimerTask extends TimerTask{


        @Override
        public void run() {
            OwnerProfile.this.runOnUiThread(new Runnable() {
                @Override
                public void run() {

                    if(viewPager.getCurrentItem() == 0){
                        viewPager.setCurrentItem(1);
                    }else if(viewPager.getCurrentItem() == 1){
                        viewPager.setCurrentItem(2);
                    }else if(viewPager.getCurrentItem() == 2){
                        viewPager.setCurrentItem(3);
                    }else {
                        viewPager.setCurrentItem(0);
                    }

                }
            });
        }
    }
}
