package example.com.textproject1;

import android.app.Activity;
import android.os.Bundle;
import android.util.DisplayMetrics;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Toast;

public class Message extends Activity {

    public static DisplayMetrics displayMetrics;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
//        NewListView nLv = new NewListView(this,this);
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
        setContentView(R.layout.newlistviewxml);
    }
}