package com.uvraju.schoolservices;

import android.os.Bundle;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;
import android.graphics.Color;
import android.view.Gravity;

public class SchoolsActivity extends AppCompatActivity {

    String[][] schools = {
        {"Sri Vidya High School", "Kurnool", "CBSE", "₹1,28,000", "Active"},
        {"Sai Baba English Medium", "Nandyal", "State Board", "₹86,400", "Active"},
        {"New Light Public School", "Kurnool", "CBSE", "₹61,500", "Active"},
        {"Sunrise International", "Adoni", "ICSE", "₹33,200", "Follow-up"},
        {"Krishnaveni Girls School", "Kurnool", "State Board", "₹97,000", "Active"},
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        LinearLayout root = new LinearLayout(this);
        root.setOrientation(LinearLayout.VERTICAL);
        root.setBackgroundColor(Color.parseColor("#F0F4F8"));
        root.setPadding(16, 16, 16, 16);

        TextView title = new TextView(this);
        title.setText("🏫 Schools / Clients");
        title.setTextSize(18);
        title.setTextColor(Color.parseColor("#1A2744"));
        title.setTypeface(null, android.graphics.Typeface.BOLD);
        title.setPadding(0, 0, 0, 16);
        root.addView(title);

        for (String[] school : schools) {
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

            TextView name = new TextView(this);
            name.setText(school[0]);
            name.setTextSize(14);
            name.setTypeface(null, android.graphics.Typeface.BOLD);
            name.setTextColor(Color.parseColor("#1E293B"));

            TextView city = new TextView(this);
            city.setText("📍 " + school[1] + "  •  " + school[2]);
            city.setTextSize(12);
            city.setTextColor(Color.parseColor("#64748B"));
            city.setPadding(0, 4, 0, 4);

            TextView spend = new TextView(this);
            spend.setText("Total Spend: " + school[3]);
            spend.setTextSize(13);
            spend.setTextColor(Color.parseColor("#2563EB"));
            spend.setTypeface(null, android.graphics.Typeface.BOLD);

            TextView status = new TextView(this);
            status.setText(school[4]);
            status.setTextSize(11);
            status.setPadding(16, 4, 16, 4);
            if (school[4].equals("Active")) {
                status.setTextColor(Color.parseColor("#16A34A"));
                status.setBackgroundColor(Color.parseColor("#DCFCE7"));
            } else {
                status.setTextColor(Color.parseColor("#92400E"));
                status.setBackgroundColor(Color.parseColor("#FEF3C7"));
            }

            inner.addView(name);
            inner.addView(city);
            inner.addView(spend);
            inner.addView(status);
            card.addView(inner);
            root.addView(card);
        }

        android.widget.ScrollView scroll = new android.widget.ScrollView(this);
        scroll.addView(root);
        setContentView(scroll);
    }
}
