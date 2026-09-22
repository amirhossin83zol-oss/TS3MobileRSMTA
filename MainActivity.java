package ir.rsmta.ts3mobile;

import android.app.Activity;
import android.os.Bundle;
import android.graphics.Color;
import android.view.Gravity;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;

public class MainActivity extends Activity {
    private int dp(float v) {
        return (int)(v * getResources().getDisplayMetrics().density + 0.5f);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        LinearLayout root = new LinearLayout(this);
        root.setOrientation(LinearLayout.VERTICAL);
        root.setPadding(dp(20), dp(28), dp(20), dp(20));
        root.setGravity(Gravity.CENTER_HORIZONTAL);
        root.setBackgroundColor(Color.WHITE);

        TextView title = new TextView(this);
        title.setText("TS3 Mobile RSMTA");
        title.setTextSize(26);
        title.setTextColor(Color.BLACK);
        title.setGravity(Gravity.CENTER);
        root.addView(title, new LinearLayout.LayoutParams(-1, -2));

        TextView subtitle = new TextView(this);
        subtitle.setText("TeamSpeak 3 mobile client — v0.1");
        subtitle.setTextSize(15);
        subtitle.setGravity(Gravity.CENTER);
        LinearLayout.LayoutParams sp = new LinearLayout.LayoutParams(-1, -2);
        sp.setMargins(0, dp(8), 0, dp(24));
        root.addView(subtitle, sp);

        EditText server = new EditText(this);
        server.setHint("Server");
        server.setText("ts.rsmta.ir");
        server.setSingleLine(true);
        root.addView(server, new LinearLayout.LayoutParams(-1, -2));

        EditText port = new EditText(this);
        port.setHint("Port");
        port.setText("9987");
        port.setInputType(2);
        port.setSingleLine(true);
        root.addView(port, new LinearLayout.LayoutParams(-1, -2));

        EditText nickname = new EditText(this);
        nickname.setHint("Nickname");
        nickname.setSingleLine(true);
        root.addView(nickname, new LinearLayout.LayoutParams(-1, -2));

        Button connect = new Button(this);
        connect.setText("CONNECT");
        LinearLayout.LayoutParams bp = new LinearLayout.LayoutParams(-1, -2);
        bp.setMargins(0, dp(20), 0, 0);
        root.addView(connect, bp);

        TextView status = new TextView(this);
        status.setText("Status: Not connected");
        status.setTextSize(16);
        status.setPadding(0, dp(24), 0, 0);
        root.addView(status, new LinearLayout.LayoutParams(-1, -2));

        connect.setOnClickListener(v ->
            status.setText("Status: UI test successful. TS3 connection comes next.")
        );

        setContentView(root);
    }
}
