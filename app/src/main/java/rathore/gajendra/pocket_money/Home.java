package rathore.gajendra.pocket_money;

import android.app.Dialog;
import android.app.Notification;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.app.NotificationCompat;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import java.util.zip.Inflater;

import static android.widget.Toast.LENGTH_SHORT;

public class Home extends AppCompatActivity {
    Button AddBtn;
    TextView walletBal;
    EditText edtAdd;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
        TextView addMoney=(TextView)findViewById(R.id.addmoney);
        TextView toSaving=(TextView)findViewById(R.id.tosavings);
        walletBal=(TextView)findViewById(R.id.walletbalance);
        AddBtn=(Button)findViewById(R.id.btnAdd);
        edtAdd=(EditText)findViewById(R.id.edittextAdd);
        addMoney.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                addNotification();
            }
        });
    }
    private void addNotification() {
        NotificationCompat.Builder builder =
                (NotificationCompat.Builder) new NotificationCompat.Builder(this)
                        .setSmallIcon(R.drawable.ic_morning_notif)
                        .setContentTitle("Good Morning")
                        .setContentText("You've got ₹150 to spend today");
        builder.setAutoCancel(true);
        Intent notificationIntent = new Intent(this, LoginActivity.class);
        PendingIntent contentIntent = PendingIntent.getActivity(this, 0, notificationIntent,
                PendingIntent.FLAG_UPDATE_CURRENT);
        builder.setContentIntent(contentIntent);

        // Add as notification
        NotificationManager manager = (NotificationManager) getSystemService(Context.NOTIFICATION_SERVICE);
        manager.notify(0, builder.build());
        //--------------toast----------------------
        AlertDialog.Builder builders = new AlertDialog.Builder(this);
        LayoutInflater inflater = getLayoutInflater();
        builders.setView(inflater.inflate(R.layout.add_money,null));
        builders.setIcon(R.drawable.ic_wallet);
        builders.show();
    }
}

