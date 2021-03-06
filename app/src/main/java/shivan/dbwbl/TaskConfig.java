package shivan.dbwbl;

import android.content.Context;
import android.widget.ProgressBar;
import android.widget.TextView;

/**
 * Created by Shivan on 13.12.2015.
 */
public class TaskConfig {
    private Context mContext;
    private String mServerIP;
    private int mLatency;

    private TextView mStatusTextView;
    private TextView mClientsTextView;
    private ProgressBar mProgressBar;

    public TaskConfig(Context context, String serverIP, int latency) {
        mContext = context;
        mServerIP = serverIP;
        mLatency = latency;

        mStatusTextView = (TextView) ((MainActivity) getContext()).findViewById(R.id.statusTextView);
        mClientsTextView = (TextView) ((MainActivity) getContext()).findViewById(R.id.clientsTextView);
        mProgressBar = (ProgressBar) ((MainActivity) getContext()).findViewById(R.id.progressBar);
    }

    public Context getContext() { return mContext; }
    public String getServerIP() { return mServerIP; }
    public int getLatency() { return mLatency; }

    public void setClientsText(final String clientsText) {
        ((MainActivity) getContext()).runOnUiThread(new Runnable() {
            @Override
            public void run() {
                mClientsTextView.setText(clientsText);
            }
        });
    }

    public void setStatus(final String status) {
        ((MainActivity) getContext()).runOnUiThread(new Runnable() {
            @Override
            public void run() {
                mStatusTextView.setText(status);
            }
        });
    }

    public void setProgress(int progress, int max) {
        mProgressBar.setMax(max);
        mProgressBar.setProgress(progress);
    }
}
