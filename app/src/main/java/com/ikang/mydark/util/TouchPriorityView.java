package com.ikang.mydark.util;

import android.content.Context;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.widget.LinearLayout;

/**
 * @author changliang.yu   & E-mail: changliang.yu-ext@ikang.com
 * @create_time 创建时间：2020/5/29 09:49
 * @version:
 * @类说明: 如果发生ACTION_DOWN事件，回调给用户处理
 */
public class TouchPriorityView extends LinearLayout {


    public TouchPriorityView(Context context) {
        super(context);
    }

    public TouchPriorityView(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    public TouchPriorityView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }


    private boolean isDoubleDown;

    @Override
    public boolean dispatchTouchEvent(MotionEvent event) {
        switch (event.getAction()) {
            case MotionEvent.ACTION_DOWN:
                isDoubleDown = true;
                break;
            case MotionEvent.ACTION_MOVE:
                break;
            case MotionEvent.ACTION_UP:
                break;
        }

        return super.dispatchTouchEvent(event);
    }


    @Override
    public boolean onTouchEvent(MotionEvent event) {
        switch (event.getAction()) {
            case MotionEvent.ACTION_DOWN:
                if (isDoubleDown) {
                    first.doMyFirstDown();
                }
                break;
            case MotionEvent.ACTION_MOVE:
                break;
            case MotionEvent.ACTION_UP:
                break;
        }
        return super.onTouchEvent(event);
    }

    public interface MyFirstPriority {
        void doMyFirstDown();
    }

    private MyFirstPriority first;

    public void setMyFirstPriority(MyFirstPriority myFirst) {
        this.first = myFirst;
    }
}
