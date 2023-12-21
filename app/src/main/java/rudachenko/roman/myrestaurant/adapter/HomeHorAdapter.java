package rudachenko.roman.myrestaurant.adapter;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;
import java.util.ArrayList;
import rudachenko.roman.myrestaurant.R;
import rudachenko.roman.myrestaurant.model.HomeHorModel;
import rudachenko.roman.myrestaurant.model.HomeVerModel;

public class HomeHorAdapter extends RecyclerView.Adapter<HomeHorAdapter.ViewHolder> {

    UpdateVerticalRec updateVerticalRec;
    Activity activity;
    ArrayList<HomeHorModel> list;
    int rowIndex = -1;
    boolean select = true;

    boolean check = true;

    public HomeHorAdapter(UpdateVerticalRec updateVerticalRec, Activity activity, ArrayList<HomeHorModel> list) {
        this.updateVerticalRec = updateVerticalRec;
        this.activity = activity;
        this.list = list;
    }

    @NonNull
    @Override
    public HomeHorAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new ViewHolder(LayoutInflater.from(parent.getContext()).inflate(R.layout.item_home_horizontal, parent, false));
    }

    @SuppressLint("NotifyDataSetChanged")
    @Override
    public void onBindViewHolder(ViewHolder holder, @SuppressLint("RecyclerView") int position) {

        holder.imageView.setImageResource(list.get(position).getImage());
        holder.name.setText(list.get(position).getName());

        holder.cardView.setOnClickListener(v -> {

            rowIndex = position;

            notifyDataSetChanged();

            ArrayList<HomeVerModel> homeVerModels = new ArrayList<>();

            if (position == 0) {

                homeVerModels.add(new HomeVerModel(R.drawable.pizza1, "Pizza", "5-10", "4.8", "30$"));
                homeVerModels.add(new HomeVerModel(R.drawable.pizza2, "Pizza", "5-11", "4.9", "35$"));
                homeVerModels.add(new HomeVerModel(R.drawable.pizza3, "Pizza", "5-12", "4.7", "32$"));
                homeVerModels.add(new HomeVerModel(R.drawable.pizza4, "Pizza", "5-13", "4.6", "32$"));

            } else if (position == 1) {

                homeVerModels.add(new HomeVerModel(R.drawable.burger1, "Burger", "6-13", "4.8", "30$"));
                homeVerModels.add(new HomeVerModel(R.drawable.burger2, "Burger", "3-13", "4.9", "35$"));
                homeVerModels.add(new HomeVerModel(R.drawable.burger4, "Burger", "4-13", "4.6", "32$"));

            } else if (position == 2) {

                homeVerModels.add(new HomeVerModel(R.drawable.fries1, "Fries", "4-13", "4.8", "30$"));
                homeVerModels.add(new HomeVerModel(R.drawable.fries2, "Fries", "4-13", "4.9", "35$"));
                homeVerModels.add(new HomeVerModel(R.drawable.fries3, "Fries", "14-17", "4.7", "32$"));
                homeVerModels.add(new HomeVerModel(R.drawable.fries4, "Fries", "4-13", "4.7", "32$"));

            } else if (position == 3) {

                homeVerModels.add(new HomeVerModel(R.drawable.icecream1, "Ice Cream", "4-13", "4.8", "30$"));
                homeVerModels.add(new HomeVerModel(R.drawable.icecream2, "Ice Cream", "4-13", "4.9", "35$"));
                homeVerModels.add(new HomeVerModel(R.drawable.icecream3, "Ice Cream", "4-13", "4.7", "32$"));
                homeVerModels.add(new HomeVerModel(R.drawable.icecream4, "Ice Cream", "4-13", "4.7", "32$"));

            } else if (position == 4) {

                homeVerModels.add(new HomeVerModel(R.drawable.sandwich1, "Sandwich", "4-13", "4.8", "30$"));
                homeVerModels.add(new HomeVerModel(R.drawable.sandwich2, "Sandwich", "4-13", "4.9", "35$"));
                homeVerModels.add(new HomeVerModel(R.drawable.sandwich3, "Sandwich", "4-13", "4.7", "32$"));
                homeVerModels.add(new HomeVerModel(R.drawable.sandwich4, "Sandwich", "4-13", "4.7", "32$"));

            }
            updateVerticalRec.callback(position, homeVerModels);
        });

        if (select) {
            if (position == 0) {
                holder.cardView.setBackgroundResource(R.drawable.design_change);
                select = false;
            }
        } else if (rowIndex == position) {
                holder.cardView.setBackgroundResource(R.drawable.design_change);
            } else {
                holder.cardView.setBackgroundResource(R.drawable.design_default);
            }
        }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        ImageView imageView;
        TextView name;
        CardView cardView;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);

            imageView = itemView.findViewById(R.id.hor_img);
            name = itemView.findViewById(R.id.hor_text);
            cardView = itemView.findViewById(R.id.cardHorView);

        }
    }
}
