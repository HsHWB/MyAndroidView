package example.com.textproject1;

import android.app.Activity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;

import java.util.ArrayList;

public class NewViewPager_Activity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        LayoutInflater lf = getLayoutInflater().from(this);
        View view1 = lf.inflate(R.layout.newviewpager1, null);
        View view2 = lf.inflate(R.layout.newviewpager2, null);
        View view3 = lf.inflate(R.layout.newviewpager3, null);

        ArrayList<View> arrayList = new ArrayList<View>();
        arrayList.add(view1);
        arrayList.add(view2);
        arrayList.add(view3);
    }
}