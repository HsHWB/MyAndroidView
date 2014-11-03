package example.com.textproject1;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Toast;

public class Message extends Activity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
//        NewListView nLv = new NewListView(this,this);
//        setContentView(R.layout.newlistviewxml);
//        setContentView(nLv);
//        nLv.setOnItemClickListener(new AdapterView.OnItemClickListener() {
//            @Override
//            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
//                Toast.makeText(Message.this,"击中"+String.valueOf(position),Toast.LENGTH_SHORT).show();
//            }
//        });
        NewListView2 nLv = new NewListView2(this,null);
        setContentView(nLv);
    }
}