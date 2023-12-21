package rudachenko.roman.myrestaurant.ui.dailyMeal;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

import rudachenko.roman.myrestaurant.MainActivity;
import rudachenko.roman.myrestaurant.R;
import rudachenko.roman.myrestaurant.activity.DetailedDailyMealActivity;
import rudachenko.roman.myrestaurant.activity.LoginActivity;
import rudachenko.roman.myrestaurant.adapter.DailyMealAdapter;
import rudachenko.roman.myrestaurant.model.DailyMealModel;


public class DailyMealFragment extends Fragment {

    RecyclerView recyclerView;
    List<DailyMealModel> dailyMealModels;
    DailyMealAdapter dailyMealAdapter;


    @SuppressLint("NotifyDataSetChanged")
    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {

        View root = inflater.inflate(R.layout.fragment_daily_meal, container,false);

        recyclerView = root.findViewById(R.id.daily_meal_rec);
        recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));

        dailyMealModels = new ArrayList<>();

        dailyMealModels.add(new DailyMealModel(R.drawable.breakfast,"Breakfast","30% OFF","Description", "breakfast"));
        dailyMealModels.add(new DailyMealModel(R.drawable.lunch,"Lunch","30% OFF","Description", "lunch"));
        dailyMealModels.add(new DailyMealModel(R.drawable.dinner,"Dinner","30% OFF","Description", "dinner"));
        dailyMealModels.add(new DailyMealModel(R.drawable.sweets,"Sweets","30% OFF","Description", "sweets"));
        dailyMealModels.add(new DailyMealModel(R.drawable.coffe,"Coffee","30% OFF","Description", "coffee"));

        dailyMealAdapter =new DailyMealAdapter(getContext(),dailyMealModels);
        recyclerView.setAdapter(dailyMealAdapter);
        dailyMealAdapter.notifyDataSetChanged();

        return root;
    }
}