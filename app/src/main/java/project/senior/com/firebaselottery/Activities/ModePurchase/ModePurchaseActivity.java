package project.senior.com.firebaselottery.Activities.ModePurchase;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.RecyclerView;
import android.view.View;

import project.senior.com.firebaselottery.R;

public class ModePurchaseActivity extends AppCompatActivity {

    private RecyclerView recyclerviewPurchase;
    private FloatingActionButton fabAddLotteryPurchase;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mode_purchase);

        initObjects();

        fabAddLotteryPurchase.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent a = new Intent(ModePurchaseActivity.this, AddLotteryPurchaseActivity.class);
                startActivity(a);
            }
        });
    }

    /**
     * This method is to initialize objects to be used
     */
    private void initObjects(){
        recyclerviewPurchase = (RecyclerView) findViewById(R.id.recyclerviewPurchase);
        fabAddLotteryPurchase = (FloatingActionButton) findViewById(R.id.fabAddLotteryPurchase);
    }


}
