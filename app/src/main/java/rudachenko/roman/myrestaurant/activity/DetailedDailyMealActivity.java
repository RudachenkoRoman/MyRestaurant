package rudachenko.roman.myrestaurant.activity;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.widget.ImageView;

import com.makeramen.roundedimageview.RoundedImageView;

import java.util.ArrayList;
import java.util.List;

import rudachenko.roman.myrestaurant.R;
import rudachenko.roman.myrestaurant.adapter.DetailedDailyAdapter;
import rudachenko.roman.myrestaurant.model.DailyMealModel;
import rudachenko.roman.myrestaurant.model.DetailedDailyModel;

public class DetailedDailyMealActivity extends AppCompatActivity {

    RecyclerView recyclerView;
    List<DetailedDailyModel> detailedDailyModelList;
    DetailedDailyAdapter detailedDailyAdapter;
    RoundedImageView imageView;


    @SuppressLint("NotifyDataSetChanged")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detailed_daily_meal);

        String type = getIntent().getStringExtra("type");

        recyclerView = findViewById(R.id.detailed_rec);
        imageView = findViewById(R.id.detailed_daily);

        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        detailedDailyModelList = new ArrayList<>();
        detailedDailyAdapter = new DetailedDailyAdapter(detailedDailyModelList);
        recyclerView.setAdapter(detailedDailyAdapter);

        if (type != null && type.equalsIgnoreCase("breakfast")) {
            detailedDailyModelList.add(new DetailedDailyModel(R.drawable.fav1, "Breakfast", "description", "4.9", "25$", "10-15"));
            detailedDailyModelList.add(new DetailedDailyModel(R.drawable.fav2, "Breakfast", "description", "4.9", "25$", "10-15"));
            detailedDailyModelList.add(new DetailedDailyModel(R.drawable.fav3, "Breakfast", "description", "4.9", "25$", "10-15"));
        }

        if (type != null && type.equalsIgnoreCase("lunch")) {
            imageView.setImageResource(R.drawable.lunch);
        }

        if (type != null && type.equalsIgnoreCase("dinner")) {
            imageView.setImageResource(R.drawable.dinner);
        }

        if (type != null && type.equalsIgnoreCase("sweets")) {
            imageView.setImageResource(R.drawable.sweets);
            detailedDailyModelList.add(new DetailedDailyModel(R.drawable.s1, "Sweets", "description", "4.9", "25$", "10-15"));
            detailedDailyModelList.add(new DetailedDailyModel(R.drawable.s2, "Sweets", "description", "4.9", "25$", "10-15"));
            detailedDailyModelList.add(new DetailedDailyModel(R.drawable.s3, "Sweets", "description", "4.9", "25$", "10-15"));
        }

        if (type != null && type.equalsIgnoreCase("coffee")) {
            imageView.setImageResource(R.drawable.coffe);
        }



        detailedDailyAdapter.notifyDataSetChanged();
    }
}