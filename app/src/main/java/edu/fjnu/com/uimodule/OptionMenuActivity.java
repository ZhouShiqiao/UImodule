package edu.fjnu.com.uimodule;

import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import org.w3c.dom.Text;

public class OptionMenuActivity extends AppCompatActivity {
    private TextView textview;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_option_menu);
        findview();
        initview();
    }

    private void findview() {
        this.textview = (TextView) findViewById(R.id.testtextview);
    }

    private void initview() {

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.option_menu, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            // action with ID action_refresh was selected
            case R.id.action_normal:
                Toast.makeText(this, "普通选项", Toast.LENGTH_SHORT).show();
                break;
            case R.id.action_textszie10:
                textview.setTextSize(10);
                break;
            case R.id.action_textszie16:
                textview.setTextSize(16);
                break;
            case R.id.action_textszie20:
                textview.setTextSize(20);
                break;
            case R.id.action_textcolorred:
                textview.setTextColor(Color.parseColor("#CC0000"));
                break;
            case R.id.action_textcolorblack:
                textview.setTextColor(Color.parseColor("#000000"));
            default:
                break;
        }
        return true;
    }
}
