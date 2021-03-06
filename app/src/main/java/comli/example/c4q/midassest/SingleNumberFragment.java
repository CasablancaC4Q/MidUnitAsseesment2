package comli.example.c4q.midassest;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import comli.example.c4q.midassest.R;

/**
 * Created by c4q on 1/16/18.
 */

public class SingleNumberFragment extends Fragment {

    private TextView textView;


    public SingleNumberFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_single_number, container, false);
        Bundle bundle = getArguments();
        textView = view.findViewById(R.id.final_number);
        String s = bundle.getString("number");
        int i = Integer.valueOf(s)*10;
        textView.setText(String.valueOf(i));
        return view;
    }
}
