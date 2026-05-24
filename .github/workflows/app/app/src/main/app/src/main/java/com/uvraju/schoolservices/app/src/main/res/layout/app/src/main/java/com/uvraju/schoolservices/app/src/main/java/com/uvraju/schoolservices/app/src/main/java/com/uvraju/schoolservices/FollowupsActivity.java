package com.uvraju.schoolservices;

import android.os.Bundle;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;
import android.graphics.Color;

public class FollowupsActivity extends AppCompatActivity {

    String[][] followups = {
        {"Sai Baba English Medium", "2025-26 textbook order confirmation", "High"},
        {"Sunrise International", "Smart Classroom proposal pending", "High"},
        {"New Light Public School", "CCTV upgrade quote sent, awaiting approval", "Medium"},
        {"Krishnaveni Girls School", "Winter uniform delivery feedback", "Low"},
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        LinearLayout root = new LinearLayout(this);
        root.setOrientation(LinearLayout.VERTICAL);
        root.setBackgroundColor(Color.parseColor("#F0F4F8"));
        root.setPadding(16, 16, 16, 16);

        TextView title = new TextView(this);
        title.setText("🔔 Follow-ups");
        title.setTextSize(18);
        title.setTextColor(Color.parseColor("#1A2744"));
        title.setTypeface(null, android.graphics.Typeface.BOLD);
        title.setPadding(0, 0, 0, 16);
        root.addView(title);

        // Alert
        TextView alert = new TextView(this);
        alert.setText("🔴  2 high priority follow-ups need attention today!");
        alert.setTextSize(12);
        alert.setTextColor(Color.parseColor("#991B1B"));
        alert.setBackgroundColor(Color.parseColor("#FEE2E2"));
        alert.setPadding(24, 16, 24, 16);
        LinearLayout.LayoutParams alertParams = new LinearLayout.LayoutParams(
            LinearLayout.LayoutParams.MATCH_PARENT,
            LinearLayout.LayoutParams.WRAP_CONTENT
        );
        alertParams.setMargins(0, 0, 0, 16);
        alert.setLayoutParams(alertParams);
        root.addView(alert);

        for (String[] f : followups) {
            CardView card = new CardView(this);
            LinearLayout.LayoutParams cardParams = new LinearLayout.LayoutParams(
                LinearLayout.LayoutParams.MATCH_PARENT,
                LinearLayout.LayoutParams.WRAP_CONTENT
            );
            cardParams.setMargins(0, 0, 0, 12);
            card.setLayoutParams(cardParams);
            card.setRadius(24f);
            card.setCardElevation(4f);

            LinearLayout inner = new LinearLayout(this);
            inner.setOrientation(LinearLayout.VERTICAL);
            inner.setPadding(32, 24, 32, 24);
            inner.setBackgroundColor(Color.WHITE);

            // Top row: school + priority badge
            LinearLayout topRow = new LinearLayout(this);
            topRow.setOrientation(LinearLayout.HORIZONTAL);

            TextView school = new TextView(this);
            school.setText(f[0]);
            school.setTextSize(13);
            school.setTypeface(null, android.graphics.Typeface.BOLD);
            school.setTextColor(Color.parseColor("#1E293B"));
            LinearLayout.LayoutParams schoolParams = new LinearLayout.LayoutParams(
                0, LinearLayout.LayoutParams.WRAP_CONTENT, 1f);
            school.setLayoutParams(schoolParams);

            TextView priority = new TextView(this);
            priority.setText(f[2]);
            priority.setTextSize(11);
            priority.setPadding(16, 6, 16, 6);
            String pColor, pBg;
            switch (f[2]) {
                case "High":
                    pColor = "#991B1B"; pBg = "#FEE2E2"; break;
                case "Medium":
                    pColor = "#92400E"; pBg = "#FEF3C7"; break;
                default:
                    pColor = "#1E40AF"; pBg = "#DBEAFE"; break;
            }
            priority.setTextColor(Color.parseColor(pColor));
            priority.setBackgroundColor(Color.parseColor(pBg));

            topRow.addView(school);
            topRow.addView(priority);

            TextView topic = new TextView(this);
            topic.setText(f[1]);
            topic.setTextSize(12);
            topic.setTextColor(Color.parseColor("#64748B"));
            topic.setPadding(0, 8, 0, 0);

            inner.addView(topRow);
            inner.addView(topic);
            card.addView(inner);
            root.addView(card);
        }

        android.widget.ScrollView scroll = new android.widget.ScrollView(this);
        scroll.addView(root);
        setContentView(scroll);
    }
}
