package example.com.textproject1;

import android.content.Context;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.widget.HorizontalScrollView;

/**
 * Created by Hs on 2014/12/6.
 */
public class NewHorizontalScrollView_View extends HorizontalScrollView{

    public NewHorizontalScrollView_View(Context context){
        super(context, null);
    }

    public NewHorizontalScrollView_View(Context context, AttributeSet attr){
        super(context, attr);
    }

    @Override
    public void fling(int velocityX) {
        super.fling(velocityX);
        System.out.println("fling fling X = "+velocityX);
    }

    @Override
    public void scrollTo(int x, int y) {
        super.scrollTo(x, y);
        System.out.println("scrollTo scrollTo x= "+x+"   y ="+y);
    }

    @Override
    public boolean onTouchEvent(MotionEvent ev) {
        System.out.println("onTouchEvent onTouchEvent");
        return super.onTouchEvent(ev);
    }

    @Override
    public boolean arrowScroll(int direction) {//响应点击左右箭头时对滚动条的处理。
        System.out.println("arrowScroll dirction = "+direction);
        return super.arrowScroll(direction);
    }
}
