package com.aof.vng.demo.view;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.text.TextPaint;
import android.util.AttributeSet;
import android.widget.TextView;

import androidx.annotation.ColorInt;
import androidx.annotation.Nullable;
import androidx.appcompat.widget.AppCompatTextView;

import java.lang.reflect.Field;

/**
 * TextView 文字描边
 * 是利用TextView在onDraw的时候，获取到画笔，先进行一次比默认大小的文字内容稍微大一点的绘制，然后再进行一次默认大小的文字内容的绘制，这样就产生出了描边效果
 * Created by slack
 * on 17/9/6 下午3:43
 */

public class StrokeTextView extends AppCompatTextView {

    private @ColorInt
    int mBorderColor = Color.RED;
    private @ColorInt
    int mInnerColor = Color.RED;
    private boolean mBorderText = true;
    private TextPaint mTextPaint;

    public StrokeTextView(Context context) {
        this(context, null);
    }

    public StrokeTextView(Context context, @Nullable AttributeSet attrs) {
        this(context, attrs, android.R.attr.textViewStyle);
    }

    public StrokeTextView(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        mTextPaint = this.getPaint();
        mInnerColor = getCurrentTextColor();
    }

    /**
     * onDraw  draw border first
     */
    @Override
    protected void onDraw(Canvas canvas) {
        if (mBorderText) {
            // 描外层
            setTextColorUseReflection(mBorderColor);
            mTextPaint.setStrokeWidth(2); // 描边宽度
            mTextPaint.setStyle(Paint.Style.FILL); // 画笔空心
            super.onDraw(canvas);

            // 描内层，恢复原先的画笔
            setTextColorUseReflection(mInnerColor);
            mTextPaint.setStrokeWidth(0);
            mTextPaint.setStyle(Paint.Style.FILL);
            mTextPaint.setFakeBoldText(false);
        }
        super.onDraw(canvas);
    }

    /**
     * 使用反射的方法进行字体颜色的设置
     * 其实就是 this.setTextColor(); 但是这个系统方法里会调用invalidate(); 最终的效果导致这段代码无限循环
     * 反射部分：
     * 1. Class.getDeclaredField(String name); 返回一个 Field 对象，该对象反映此 Class 对象所表示的类或接口的指定已声明字段（包括私有成员）
     * 2. 获取私有属性的时候必须先设置Accessible为true，然后才能获取
     * 3. 通过Field.get(Object obj)获取属性的值，通过Field.set（Object obj,value）重新设置新的属性值
     */
    private void setTextColorUseReflection(int color) {
        Field textColorField;
        try {
            textColorField = TextView.class.getDeclaredField("mCurTextColor");
            textColorField.setAccessible(true);
            textColorField.set(this, color);
            textColorField.setAccessible(false);
        } catch (NoSuchFieldException e) {
            e.printStackTrace();
        } catch (IllegalArgumentException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        }
        mTextPaint.setColor(color);
    }
}
