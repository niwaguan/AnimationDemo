package com.mindto.animationdemo;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.animation.AlphaAnimation;
import android.view.animation.Animation;
import android.view.animation.AnimationSet;
import android.view.animation.RotateAnimation;
import android.view.animation.ScaleAnimation;
import android.view.animation.TranslateAnimation;
import android.widget.ImageView;

/**
 * 使用代码的方式实现动画效果
 */
public class CodeAnimationActivity extends AppCompatActivity {
    private ImageView imageView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_codeanimation);
        imageView = (ImageView) findViewById(R.id.pic);
    }
    public void onClick(View view){
        //创建AnimationSet对象
        AnimationSet animationSet = new AnimationSet(true);

        //创建translate动画对象
        /*构造函数签名
        public TranslateAnimation(int fromXType（开始位置X轴值的选取参考对象）, float fromXValue（值）,下同
         int toXType, float toXValue, int fromYType, float fromYValue, int toYType, float toYValue) {}
        */
        TranslateAnimation translateAnimation = new TranslateAnimation(
                Animation.RELATIVE_TO_SELF,0,
                Animation.RELATIVE_TO_PARENT,0.5f,
                Animation.RELATIVE_TO_SELF,0,
                Animation.RELATIVE_TO_PARENT,0);
        //动画持续时长
        translateAnimation.setDuration(2000);

        //创建alphaAnimation对象
        /*构造函数签名
        public AlphaAnimation(float fromAlpha, 开始透明度
        float toAlpha 结束透明度
        ) {}
        */
        AlphaAnimation alphaAnimation = new AlphaAnimation(1,0);
        //设置动画的持续时长
        alphaAnimation.setDuration(2000);

        //创建具体的动画对象
        /*
         public RotateAnimation(float fromDegrees, float toDegrees, int pivotXType, float pivotXValue,
            int pivotYType, float pivotYValue) {}
        */
        RotateAnimation rotateAnimation = new RotateAnimation(0,360,
                Animation.RELATIVE_TO_SELF,1f,
                Animation.RELATIVE_TO_SELF,1f);
        //设置执行时间
        rotateAnimation.setDuration(2000);

        //创建scale动画对象
        /*
         public ScaleAnimation(float fromX, float toX, float fromY, float toY,
            int pivotXType, float pivotXValue, int pivotYType, float pivotYValue) {}
       */
        ScaleAnimation scaleAnimation = new ScaleAnimation(1, 0.1f, 1, 0.1f,
                Animation.RELATIVE_TO_SELF,0.9f,
                Animation.RELATIVE_TO_SELF,0.5f);
        scaleAnimation.setDuration(2000);
        switch (view.getId()){
            //平移动画
            case R.id.translate:
                imageView.startAnimation(translateAnimation);
                break;
            //渐变动画
            case R.id.alpha:
                //开始执行动画
                imageView.startAnimation(alphaAnimation);
                break;
            //旋转动画
            case R.id.rotate:
                animationSet.addAnimation(rotateAnimation);
                //执行动画
                imageView.startAnimation(animationSet);
                break;
            //缩放动画
            case R.id.scale:
                imageView.startAnimation(scaleAnimation);
                break;
            //跳转到下一个演示活动
            case R.id.toXml:
                Intent intent = new Intent(CodeAnimationActivity.this, XMLAnimationActivity.class);
                startActivity(intent);
            default:
                break;
        }
    }
}
