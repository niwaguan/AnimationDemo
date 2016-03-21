package com.mindto.animationdemo;

import android.content.Context;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;

/**
 * 使用XML文件配置动画
 */
public class XMLAnimationActivity extends AppCompatActivity {
    private ImageView imageView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_xmlanimation);
        imageView = (ImageView) findViewById(R.id.pic);
    }
    public void onClick(View view){
        Context context = XMLAnimationActivity.this;
        switch (view.getId()){
            case R.id.translate:
                //使用AnimationUtils工具类，从XML文件创建动画
                Animation translateAnimation = AnimationUtils.loadAnimation(context, R.anim.translate_anim);
                //执行动画
                imageView.startAnimation(translateAnimation);
                System.out.println("点击translate");
                break;
            case R.id.alpha:
                Animation alphaAnimation = AnimationUtils.loadAnimation(context, R.anim.alpha_anim);
                imageView.startAnimation(alphaAnimation);
                System.out.println("点击alpha");
                break;
            case R.id.rotate:
                Animation rotateAnimation = AnimationUtils.loadAnimation(context, R.anim.rotate_anim);
                imageView.startAnimation(rotateAnimation);
                System.out.println("点击rotate");
                break;
            case R.id.scale:
                Animation scaleAnimation = AnimationUtils.loadAnimation(context, R.anim.scale_anim);
                imageView.startAnimation(scaleAnimation);
                System.out.println("点击scale");
                break;
            default:
                break;
        }
    }
}
