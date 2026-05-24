package com.uvraju.schoolservices;

import android.os.Bundle;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;
import android.graphics.Color;

public class OrdersActivity extends AppCompatActivity {

    String[][] orders = {
        {"ORD-001", "Sri Vidya High School", "Textbooks x200, Diaries x300", "₹3,60,000", "Delivered"},
        {"ORD-002", "Krishnaveni Girls School", "Uniform Sets x150", "₹1,32,000", "In Transit"},
        {"ORD-003", "New Light Public School", "CCTV Kit x2", "₹37,000", "Processing"},
        {"ORD-004", "Sai Baba English Medium", "Notebooks x300", "₹47,100", "Delivered"},
        {"ORD-005", "Sunrise International", "Smart Panel x1", "₹57,000", "Delivered"},
        {"ORD-006", "Sri Vidya High School", "ID Card+Belt+Tie x250", "₹55,000", "Pending"},
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        LinearLayout root = new LinearLayout(this);
        root.setOrientation(LinearLayout.VERTICAL);
        root.setBackgroundColor(Color.parseColor("#F0F4F8"));
        root.setPadding(16, 16, 16, 16);

        TextView title = new TextView(this);
        title.setText("📦 Orders");
        title.setTextSize(18);
        title.setTextColor(Color.parseColor("#1A2744"));
        title.setTypeface(null, android.graphics.Typeface.BOLD);
        title.setPadding(0, 0, 0, 16);
        root.addView(title);

        // Alert banner
        TextView alert = new TextView(this);
        alert.setText("⚠️  1 order In Transit — confirm delivery with school");
        alert.setTextSize(12);
        alert.setTextColor(Color.parseColor("#92400E"));
        alert.setBackgroundColor(Color.parseColor("#FEF3C7"));
        alert.setPadding(24, 16, 24, 16);
        LinearLayout.LayoutParams alertParams = new LinearLayout.LayoutParams(
            LinearLayout.LayoutParams.MATCH_PARENT,
            LinearLayout.LayoutParams.WRAP_CONTENT
        );
        alertParams.setMargins(0, 0, 0, 16);
        alert.setLayoutParams(alertParams);
        root.addView(alert);

        for (String[] order : orders) {
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

            // Order ID row
            LinearLayout topRow = new LinearLayout(this);
            topRow.setOrientation(LinearLayout.HORIZONTAL);

            TextView orderId = new TextView(this);
            orderId.setText(order[0]);
            orderId.setTextSize(13);
            orderId.setTypeface(null, android.graphics.Typeface.BOLD);
            orderId.setTextColor(Color.parseColor
