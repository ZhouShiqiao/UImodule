package edu.fjnu.com.uimodule;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

public class AlertDialogActivity extends AppCompatActivity {
    private Button button;
    private LayoutInflater mLayoutInflater;
    private View view;

    private AlertDialog myDialog = null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_alert_dialog);
        findview();
        initview();
    }

    private void findview() {
        button = (Button) findViewById(R.id.alertdialog);
    }

    private void initview() {
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                AlertDialogActivity.this.builddialog();
            }
        });
    }

    private void builddialog() {
        view = (LinearLayout) getLayoutInflater().inflate(R.layout.alert_dialog_item, null);
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setView(view);
        builder.create().show();

    }
}
