package comli.example.c4q.midassest.numberViewHolder;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.TextView;

import comli.example.c4q.midassest.R;

/**
 * Created by c4q on 1/16/18.
 */

public class NumberViewHolder extends RecyclerView.ViewHolder {

    private TextView number;

    public NumberViewHolder(View itemView) {
        super(itemView);
        number = (TextView) itemView.findViewById(R.id.number);
    }

    public void onBind( Number numberModel){
        number.setText(numberModel.getClass() + "");
    }
}
