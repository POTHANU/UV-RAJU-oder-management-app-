package com.uvraju.schoolservices;

import android.content.Intent;
import android.os.Bundle;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Dashboard cards
        CardView cardSchools = findViewById(R.id.card_schools);
        CardView cardOrders = findViewById(R.id.card_orders);
        CardView cardInventory = findViewById(R.id.card_inventory);
        CardView cardFollowups = findViewById(R.id.card_followups);

        // Stats
        TextView tvSchools = findViewById(R.id.tv_school_count);
        TextView tvOrders = findViewById(R.id.tv_order_count);
        TextView tvRevenue = findViewById(R.id.tv_revenue);
        TextView tvFollowups = findViewById(R.id.tv_followup_count);

        tvSchools.setText("5");
        tvOrders.setText("6");
        tvRevenue.setText("₹6,89,100");
        tvFollowups.setText("2 High Priority");

        cardSchools.setOnClickListener(v -> {
            startActivity(new Intent(this, SchoolsActivity.class));
        });

        cardOrders.setOnClickListener(v -> {
            startActivity(new Intent(this, OrdersActivity.class));
        });

        cardInventory.setOnClickListener(v -> {
            startActivity(new Intent(this, InventoryActivity.class));
        });

        cardFollowups.setOnClickListener(v -> {
            startActivity(new Intent(this, FollowupsActivity.class));
        });
    }
}
