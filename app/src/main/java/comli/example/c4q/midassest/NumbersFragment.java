package comli.example.c4q.midassest;

import android.app.Fragment;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListAdapter;
import android.widget.TextView;

import java.util.ArrayList;







/**
 * Created by c4q on 1/16/18.
 */

public class NumbersFragment extends Fragment {

    private TextView textView;
    private RecyclerView recyclerView;
    public android.widget.ListAdapter listAdapter;
    private ArrayList<Number> numbers;


    public NumbersFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_numbers, container, false);
        Bundle bundle = getArguments();
        String string = bundle.getString("email");
        textView = view.findViewById(R.id.emails);
        textView.setText(string);
        listAdapter = new ListAdapter(getFragmentManager());
        numbers = new ArrayList<>();
        numbers.add(new Number(0));
        numbers.add(new Number(1));
        numbers.add(new Number(2));
        numbers.add(new Number(3));
        numbers.add(new Number(4));
        numbers.add(new Number(5));
        numbers.add(new Number(6));
        numbers.add(new Number(7));
        numbers.add(new Number(8));
        numbers.add(new Number(9));
        numbers.add(new Number(10));
        listAdapter.areAllItemsEnabled();
        recyclerView = view.findViewById(R.id.recyclerView);
        LinearLayoutManager layoutManager = new LinearLayoutManager(view.getContext());
        recyclerView.setAdapter((RecyclerView.Adapter) listAdapter);
        recyclerView.setLayoutManager(layoutManager);


        return view;
    }
}


