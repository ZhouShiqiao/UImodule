package edu.fjnu.com.uimodule;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.ActionMode;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.AbsListView;
import android.widget.AdapterView;
import android.widget.ImageButton;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.RelativeLayout;
import android.widget.SimpleAdapter;
import android.widget.TextView;
import android.widget.Toast;

import org.w3c.dom.Text;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ActionModectivity extends AppCompatActivity {
    private ListView listview;
    private ActionMode mActionMode = null;
    private TextView textview;
    private ImageButton imageButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_action_modectivity);
        findview();
        initview();
    }

    private void findview() {
        listview = (ListView) findViewById(R.id.listview);
    }

    private void initview() {
        this.initlistview();
        /**
         * 设置listview长按响应事件,长按开启actionmode
         */
        listview.setOnItemLongClickListener(new AdapterView.OnItemLongClickListener() {
            @Override
            public boolean onItemLongClick(AdapterView<?> parent, View view, int position, long id) {
                if (mActionMode != null) {
                    return false;
                }
                mActionMode = startActionMode(mCallback);
                view.setSelected(true);//表示用户可以选中它
                int p =position+1;
                textview.setText(p+" selected");
                return true;
            }
        });
        listview.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                if (mActionMode != null) {
                    int p = position +1 ;
                    textview.setText(p+" selected");
                }
            }
        });
    }

    /**
     * 初始化ListView
     */
    private void initlistview() {
        String[] name = {"one", "two", "three", "four", "five", "six"};
        List<Map<String, Object>> listems = new ArrayList<Map<String, Object>>();
        for (int i = 0; i < name.length; i++) {
            Map<String, Object> listem = new HashMap<String, Object>();
            listem.put("name", name[i]);
            listems.add(listem);
        }
        SimpleAdapter simplead = new SimpleAdapter(this, listems,
                R.layout.listview_litem, new String[]{"name"},
                new int[]{R.id.listview_text});
        listview.setAdapter(simplead);
    }

    private ActionMode.Callback mCallback = new ActionMode.Callback() {

        @Override
        public boolean onPrepareActionMode(ActionMode mode, Menu menu) {
            return false;
        }

        @Override
        public void onDestroyActionMode(ActionMode mode) {
            // TODO Auto-generated method stub
            mActionMode = null;
        }

        @Override
        public boolean onCreateActionMode(ActionMode mode, Menu menu) {
            MenuInflater inflater = mode.getMenuInflater();
            inflater.inflate(R.menu.action_mode_item, menu);
            RelativeLayout layout= (RelativeLayout) menu.findItem(R.id.action_layout).getActionView();
            textview = (TextView)layout.findViewById(R.id.action_select);
            imageButton=(ImageButton)layout.findViewById(R.id.action_delete);
            imageButton.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Toast.makeText(ActionModectivity.this,"delete",Toast.LENGTH_SHORT).show();
                }
            });
            return true;
        }

        @Override
        public boolean onActionItemClicked(ActionMode mode, MenuItem item) {
            return false;
        }
    };
}
