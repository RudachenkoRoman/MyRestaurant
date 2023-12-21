package rudachenko.roman.myrestaurant.fragment;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;
import java.util.List;

import rudachenko.roman.myrestaurant.R;
import rudachenko.roman.myrestaurant.adapter.FeaturedAdapter;
import rudachenko.roman.myrestaurant.adapter.FeaturedVerAdapter;
import rudachenko.roman.myrestaurant.model.FeaturedModel;
import rudachenko.roman.myrestaurant.model.FeaturedVerModel;

public class OneFragment extends Fragment {

    RecyclerView recyclerViewHor, recyclerViewVer;

    //Horizontal
    List<FeaturedModel> featuredModelsList;
    FeaturedAdapter featuredAdapter;

    //Vertical
    List<FeaturedVerModel> featuredVerModelList;
    FeaturedVerAdapter featuredVerAdapter;



    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_one, container, false);

        //Horizontal

        recyclerViewHor = view.findViewById(R.id.featured_hor_rec);
        recyclerViewHor.setLayoutManager(new LinearLayoutManager(getContext(),RecyclerView.HORIZONTAL,false));
        featuredModelsList = new ArrayList<>();

        featuredModelsList.add(new FeaturedModel(R.drawable.fav1, "Featured", "Description"));
        featuredModelsList.add(new FeaturedModel(R.drawable.fav2, "Featured", "Description"));
        featuredModelsList.add(new FeaturedModel(R.drawable.fav3, "Featured", "Description"));

        featuredAdapter = new FeaturedAdapter(featuredModelsList);
        recyclerViewHor.setAdapter(featuredAdapter);

        //Vertical

        recyclerViewVer = view.findViewById(R.id.featured_ver_rec);
        recyclerViewVer.setLayoutManager(new LinearLayoutManager(getContext(),RecyclerView.VERTICAL,false));
        featuredVerModelList = new ArrayList<>();

        featuredVerModelList.add(new FeaturedVerModel(R.drawable.fav1, "Featured", "Description", "4.9","10-15"));
        featuredVerModelList.add(new FeaturedVerModel(R.drawable.fav2, "Featured", "Description", "4.9","10-15"));
        featuredVerModelList.add(new FeaturedVerModel(R.drawable.fav3, "Featured", "Description", "4.9","10-15"));


        featuredVerAdapter = new FeaturedVerAdapter(featuredVerModelList);
        recyclerViewVer.setAdapter(featuredVerAdapter);


        return view;

    }
}