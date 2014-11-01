package example.com.textproject1;

import android.app.Activity;
import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Adapter;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListView;

public class NewListView extends ListView {
    public Activity parent_activity = null;
    public NewListView(Context context, Activity app){
        super(context);//没有涉及到属性的添加 haven't add attribute
        this.parent_activity = app;
        this.setAdapter(ba);
    }

    public NewListView(Context context, Activity app, AttributeSet attrs){
        super(context,attrs);//could have attribute
        this.parent_activity = app;
        this.setAdapter(ba);
    }

    BaseAdapter ba = new BaseAdapter() {
        @Override
        public int getCount() {
            return 1;
        }

        @Override
        public Object getItem(int position) {
            return null;
        }

        @Override
        public long getItemId(int position) {
            return position;
        }

        @Override
        public View getView(int position, View convertView, ViewGroup parent) {
            LinearLayout line = new LinearLayout(parent_activity);
            line.setOrientation(LinearLayout.VERTICAL);
            ImageView image = new ImageView(parent_activity);
            image.setImageResource(R.drawable.ic_launcher);
            line.addView(image);
            return line;
        }
    };
    
}