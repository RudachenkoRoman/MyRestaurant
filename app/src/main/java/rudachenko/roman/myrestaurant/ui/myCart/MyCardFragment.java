package rudachenko.roman.myrestaurant.ui.myCart;

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
import rudachenko.roman.myrestaurant.adapter.MyCartAdapter;
import rudachenko.roman.myrestaurant.model.MyCartModel;

public class MyCardFragment extends Fragment {

    List<MyCartModel> list;
    MyCartAdapter myCartAdapter;
    RecyclerView recyclerView;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_my_card, container, false);

        recyclerView = view.findViewById(R.id.my_card_rec);
        recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));
        list = new ArrayList<>();
        list.add(new MyCartModel(R.drawable.s1, "Order", "4.3", "20$"));
        list.add(new MyCartModel(R.drawable.s2, "Order", "4.5", "45$"));
        list.add(new MyCartModel(R.drawable.fav2, "Order", "4.7", "30$"));
        list.add(new MyCartModel(R.drawable.s3, "Order", "4.8", "27$"));
        list.add(new MyCartModel(R.drawable.fav1, "Order", "4.9", "23$"));
        myCartAdapter = new MyCartAdapter(list);

        recyclerView.setAdapter(myCartAdapter);

        return view;
    }
}