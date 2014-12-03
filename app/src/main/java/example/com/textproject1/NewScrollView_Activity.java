package example.com.textproject1;

import android.app.Activity;
import android.os.Bundle;
import android.util.DisplayMetrics;
import android.widget.ScrollView;

public class NewScrollView_Activity extends Activity {

    public static DisplayMetrics displayMetrics_Scroll;
    @Override
    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        displayMetrics_Scroll = new DisplayMetrics();
        getWindowManager().getDefaultDisplay().getMetrics(displayMetrics_Scroll);
//        ScrollView scroll_view = (ScrollView)findViewById(R.id.DPFDV1);
//        scroll_view.setFillViewport(true);
        setContentView(R.layout.scroll_view);
    }

    @Override
    protected void onResume() {
        super.onResume();
    }


}