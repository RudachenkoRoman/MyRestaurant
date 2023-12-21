package rudachenko.roman.myrestaurant.ui.home;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import java.util.ArrayList;
import rudachenko.roman.myrestaurant.R;
import rudachenko.roman.myrestaurant.adapter.HomeHorAdapter;
import rudachenko.roman.myrestaurant.adapter.HomeVerAdapter;
import rudachenko.roman.myrestaurant.adapter.UpdateVerticalRec;
import rudachenko.roman.myrestaurant.model.HomeHorModel;
import rudachenko.roman.myrestaurant.model.HomeVerModel;

public class HomeFragment extends Fragment  implements UpdateVerticalRec {

    // Horizontal
    ArrayList<HomeHorModel> homeHorModelList;
    HomeHorAdapter homeHorAdapter;

    RecyclerView homeHorizontalRec, homeVerticalRec;

    //Vertical
    ArrayList<HomeVerModel> homeVerModelList;
    HomeVerAdapter homeVerAdapter;


    @SuppressLint("MissingInflatedId")
    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {

        View root = inflater.inflate(R.layout.fragment_home, container,false);

        homeHorizontalRec = root.findViewById(R.id.home_hor_rec);
        homeVerticalRec = root.findViewById(R.id.home_ver_rec);

        // Horizontal RecyclerView

        homeHorModelList = new ArrayList<>();

        homeHorModelList.add(new HomeHorModel(R.drawable.pizza, "Pizza"));
        homeHorModelList.add(new HomeHorModel(R.drawable.hamburger, "Hamburger"));
        homeHorModelList.add(new HomeHorModel(R.drawable.fried_potatoes, "Fries"));
        homeHorModelList.add(new HomeHorModel(R.drawable.ice_cream, "Ice cream"));
        homeHorModelList.add(new HomeHorModel(R.drawable.sandwich, "Sandwich"));

        homeHorAdapter = new HomeHorAdapter(this,getActivity(),homeHorModelList);

        homeHorizontalRec.setAdapter(homeHorAdapter);
        homeHorizontalRec.setLayoutManager(new LinearLayoutManager(getActivity(), RecyclerView.HORIZONTAL, false));
        homeHorizontalRec.setHasFixedSize(true);
        homeHorizontalRec.setNestedScrollingEnabled(false);

        //Vertical RecyclerView

        homeVerModelList = new ArrayList<>();
        homeVerModelList.add(new HomeVerModel(R.drawable.pizza1, "Pizza", "5-10", "4.8", "30$"));
        homeVerModelList.add(new HomeVerModel(R.drawable.pizza2, "Pizza", "5-11", "4.9", "35$"));
        homeVerModelList.add(new HomeVerModel(R.drawable.pizza3, "Pizza", "5-12", "4.7", "32$"));
        homeVerModelList.add(new HomeVerModel(R.drawable.pizza4, "Pizza", "5-13", "4.6", "32$"));

        homeVerAdapter = new HomeVerAdapter(getActivity(), homeVerModelList);

        homeVerticalRec.setAdapter(homeVerAdapter);
        homeVerticalRec.setLayoutManager(new LinearLayoutManager(getActivity(), RecyclerView.VERTICAL, false));
        homeHorizontalRec.setHasFixedSize(true);
        homeHorizontalRec.setNestedScrollingEnabled(false);

        return root;
    }

    @SuppressLint("NotifyDataSetChanged")
    @Override
    public void callback(int position, ArrayList<HomeVerModel> list) {
        homeVerAdapter = new HomeVerAdapter(getContext(),list);
        homeVerAdapter.notifyDataSetChanged();
        homeVerticalRec.setAdapter(homeVerAdapter);

    }
}