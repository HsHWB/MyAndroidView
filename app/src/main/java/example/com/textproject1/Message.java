package example.com.textproject1;

import android.app.Activity;
import android.os.Bundle;
import android.util.DisplayMetrics;
import android.view.ViewGroup;
import android.widget.LinearLayout;

public class Message extends Activity {

    public static DisplayMetrics displayMetrics;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        displayMetrics = new DisplayMetrics();
        getWindowManager().getDefaultDisplay().getMetrics(displayMetrics);
//        float density = displayMetrics.density;//获取屏幕密度（像素比例）
//        int densityDPI = displayMetrics.densityDpi;//屏幕密度（每寸像素）
//        float xdpi = displayMetrics.xdpi;
//        float ydpi = displayMetrics.ydpi;
//        System.out.println("xdpi"+xdpi+"    ydpi"+ydpi);
//        int screenWidthDip = (int)(displayMetrics.widthPixels);//屏幕宽
//        int screenHeightDip = (int)(displayMetrics.heightPixels);//屏幕长
//        System.out.println("屏幕长："+screenHeightDip+"     屏幕宽："+screenWidthDip);
//        setContentView(R.layout.newview);

//        LayoutInflater inflater = LayoutInflater.from(this);
//        View view = inflater.inflate(R.layout.newview,null);//也可以从XML中加载布局

//        int i = 3;
//        while(i-- > 0){
//            LinearLayout.LayoutParams lp = new LinearLayout.LayoutParams(ViewGroup.LayoutParams.WRAP_CONTENT,
//                    ViewGroup.LayoutParams.WRAP_CONTENT);//也可以从XML中加载布局
//            /**即是<LinearLayout
//             android:layout_width="WRAP_CONTENT"
//             android:layout_height="wrap_content"
//             android:text=""/>*/
//
//            DrawPictureFromDrawable_View viewll = new DrawPictureFromDrawable_View(this);
//            viewll.setLayoutParams(lp);
//        }
        setContentView(R.layout.draw_picture_from_drawable);
    }
}