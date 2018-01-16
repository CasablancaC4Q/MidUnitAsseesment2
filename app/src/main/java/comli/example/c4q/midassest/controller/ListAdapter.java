package comli.example.c4q.midassest.controller;

import android.os.Bundle;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;


import java.util.ArrayList;

import comli.example.c4q.midassest.R;
import comli.example.c4q.midassest.SingleNumberFragment;

/**
 * Created by c4q on 1/16/18.
 */

public class ListAdapter extends RecyclerView.Adapter<ListAdapter.ViewHolder>  {

    private ArrayList<Number> numbers;
    private FragmentManager fragmentManager;

    public ListAdapter(FragmentManager fragmentManager) {
        this.fragmentManager = fragmentManager;
    }

    public FragmentManager getFragmentManager() {
        return fragmentManager;
    }

    public void setNumbers(ArrayList<Number> numbers) {
        this.numbers = numbers;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.fragment_numbers, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(final ViewHolder holder, int position) {
        Number number = numbers.get(position);
        holder.onBind(number);
        holder.textView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                SingleNumberFragment fragment = new SingleNumberFragment();
                FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
                Bundle bundle = new Bundle();
                bundle.putString("number",holder.textView.getText().toString());
                fragment.setArguments(bundle);
                fragmentTransaction.replace(R.id.fragment_container,fragment);
                fragmentTransaction.addToBackStack(null);
                fragmentTransaction.commit();

            }
        });
    }

    @Override
    public int getItemCount() {
        return numbers.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder{

        private TextView textView;

        public ViewHolder(View itemView) {
            super(itemView);
            textView = itemView.findViewById(R.id.number);
        }

        public void onBind(Number number){
            textView.setText(String.valueOf(number.getNumber()));
        }
    }
}
