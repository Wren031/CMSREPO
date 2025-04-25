package com.example.communitymanangementsystem.ui.dashboard.components;

import android.content.Context;
import android.os.Handler;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.example.communitymanangementsystem.R;

public class LoadingAnimationController {

    private Context context;
    private LinearLayout loadingContainer;
    private TextView loading1, loading2, loading3, loading4;
    private Handler handler;
    private int currentDotIndex = 0; // Track the current active dot
    private Runnable animationRunnable;

    public LoadingAnimationController(Context context, View parentView) {
        this.context = context;
        loadingContainer = parentView.findViewById(R.id.loading_container);
        loading1 = parentView.findViewById(R.id.loading1);
        loading2 = parentView.findViewById(R.id.loading2);
        loading3 = parentView.findViewById(R.id.loading3);
        loading4 = parentView.findViewById(R.id.loading4);

        handler = new Handler();
    }

    // Start the loading animation
    public void startLoadingAnimation() {
        updateDots(); // Immediately update UI (no waiting at start)

        animationRunnable = new Runnable() {
            @Override
            public void run() {
                updateDots();
                handler.postDelayed(this, 5000); // Schedule next after 10 seconds
            }
        };

        handler.postDelayed(animationRunnable, 5000); // First wait 10 seconds after first move
    }

    // Stop the loading animation (optional but important)
    public void stopLoadingAnimation() {
        if (handler != null && animationRunnable != null) {
            handler.removeCallbacks(animationRunnable);
        }
    }

    // Update the dots' background color
    private void updateDots() {
        resetDots(); // Reset all dots to light grey

        // Highlight the current dot
        switch (currentDotIndex) {
            case 0:
                loading1.setBackgroundResource(R.drawable.grey_circle);
                break;
            case 1:
                loading2.setBackgroundResource(R.drawable.grey_circle);
                break;
            case 2:
                loading3.setBackgroundResource(R.drawable.grey_circle);
                break;
            case 3:
                loading4.setBackgroundResource(R.drawable.grey_circle);
                break;
        }

        // Move to the next dot (loop back after 4)
        currentDotIndex = (currentDotIndex + 1) % 4;
    }

    // Reset all dots to light grey
    private void resetDots() {
        loading1.setBackgroundResource(R.drawable.light_grey_circle);
        loading2.setBackgroundResource(R.drawable.light_grey_circle);
        loading3.setBackgroundResource(R.drawable.light_grey_circle);
        loading4.setBackgroundResource(R.drawable.light_grey_circle);
    }
}
