package rudachenko.roman.myrestaurant.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.google.android.material.bottomsheet.BottomSheetDialog;

import java.util.ArrayList;

import rudachenko.roman.myrestaurant.R;
import rudachenko.roman.myrestaurant.model.HomeVerModel;

public class HomeVerAdapter extends RecyclerView.Adapter<HomeVerAdapter.ViewHolder> {


    private BottomSheetDialog bottomSheetLayoutBinding;
    Context context;
    ArrayList<HomeVerModel> list;

    public HomeVerAdapter(Context context, ArrayList<HomeVerModel> list) {
        this.context = context;
        this.list = list;
    }

    @NonNull
    @Override
    public HomeVerAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new ViewHolder(LayoutInflater.from(parent.getContext()).inflate(R.layout.item_home_vertical, parent, false));
    }

    @Override
    public void onBindViewHolder(@NonNull HomeVerAdapter.ViewHolder holder, int position) {

        final int mImage = list.get(position).getImage();
        final String mName = list.get(position).getName();
        final String mTiming = list.get(position).getTiming();
        final String mRating = list.get(position).getRating();
        final String mPrice = list.get(position).getPrice();

        holder.imageView.setImageResource(list.get(position).getImage());
        holder.name.setText(list.get(position).getName());
        holder.timing.setText(list.get(position).getTiming());
        holder.rating.setText(list.get(position).getRating());
        holder.price.setText(list.get(position).getPrice());

        holder.itemView.setOnClickListener(v -> {
            bottomSheetLayoutBinding = new BottomSheetDialog(context,R.style.BottomSheetTheme);

            View sheetView = LayoutInflater.from(context).inflate(R.layout.bottom_sheet_layout,null);
            sheetView.findViewById(R.id.add_to_cart).setOnClickListener(v1 -> {
                Toast.makeText(context,"Added to a Cart", Toast.LENGTH_SHORT).show();
                bottomSheetLayoutBinding.dismiss();
            });

            ImageView bottomImg = sheetView.findViewById(R.id.sheet_image);
            TextView bottomName = sheetView.findViewById(R.id.sheet_name);
            TextView bottomPrice = sheetView.findViewById(R.id.sheet_price);
            TextView bottomRating = sheetView.findViewById(R.id.sheet_rating);
            TextView bottomTiming = sheetView.findViewById(R.id.sheet_timing);

            bottomImg.setImageResource(mImage);
            bottomName.setText(mName);
            bottomPrice.setText(mPrice);
            bottomRating.setText(mRating);
            bottomTiming.setText(mTiming);

            bottomSheetLayoutBinding.setContentView(sheetView);
            bottomSheetLayoutBinding.show();

        });



    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {

        ImageView imageView;
        TextView name, timing, rating, price;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);

            imageView = itemView.findViewById(R.id.ver_img);
            name = itemView.findViewById(R.id.ver_text);
            timing = itemView.findViewById(R.id.timing);
            rating = itemView.findViewById(R.id.rating);
            price = itemView.findViewById(R.id.price);

        }
    }
}
