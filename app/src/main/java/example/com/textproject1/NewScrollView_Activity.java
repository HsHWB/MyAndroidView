package example.com.textproject1;

import android.app.Activity;
import android.os.Bundle;
import android.util.DisplayMetrics;
import android.view.View;
import android.widget.Button;
import android.widget.ScrollView;

public class NewScrollView_Activity extends Activity {

    public static DisplayMetrics displayMetrics_Scroll;
    @Override
    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        displayMetrics_Scroll = new DisplayMetrics();
        getWindowManager().getDefaultDisplay().getMetrics(displayMetrics_Scroll);
//        ScrollView scroll_view = (ScrollView)findViewById(R.id.scroll_view_DPFDV1);
//        scroll_view.setFillViewport(true);
        setContentView(R.layout.scroll_view);
//        scroll_view.setVisibility(View.VISIBLE);
//        System.out.println("R.id.scroll_view_DPFDV1  == "+R.id.scroll_view_DPFDV1);
//        System.out.println("scroll_view == "+scroll_view);

    }

    @Override
    protected void onResume() {
        super.onResume();
    }


}