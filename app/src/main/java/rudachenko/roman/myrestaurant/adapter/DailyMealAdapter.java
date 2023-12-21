package rudachenko.roman.myrestaurant.adapter;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.google.android.material.imageview.ShapeableImageView;

import java.util.List;

import rudachenko.roman.myrestaurant.R;
import rudachenko.roman.myrestaurant.activity.DetailedDailyMealActivity;
import rudachenko.roman.myrestaurant.model.DailyMealModel;

public class DailyMealAdapter extends RecyclerView.Adapter<DailyMealAdapter.ViewHolder>{

    Context context;
    List<DailyMealModel> list;

    public DailyMealAdapter(Context context, List<DailyMealModel> list) {
        this.context = context;
        this.list = list;
    }

    @NonNull
    @Override
    public DailyMealAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new ViewHolder(LayoutInflater.from(parent.getContext()).inflate(R.layout.item_daily_meal, parent, false));
    }

    @Override
    public void onBindViewHolder(@NonNull DailyMealAdapter.ViewHolder holder, @SuppressLint("RecyclerView") int position) {

        holder.shapeableImageView.setImageResource(list.get(position).getImage());
        holder.name.setText(list.get(position).getName());
        holder.description.setText(list.get(position).getDescription());
        holder.discount.setText(list.get(position).getDiscount());

        holder.itemView.setOnClickListener(v -> {
            Intent intent = new Intent(context, DetailedDailyMealActivity.class);
            intent.putExtra("type", list.get(position).getType());
            context.startActivity(intent);
        });
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        ShapeableImageView shapeableImageView;

        TextView name,description, discount;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);

            shapeableImageView = itemView.findViewById(R.id.imageViewDaily);
            name = itemView.findViewById(R.id.textName);
            description = itemView.findViewById(R.id.textDescription);
            discount = itemView.findViewById(R.id.textDiscount);
        }
    }
}
