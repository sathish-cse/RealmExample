package tech42.sathish.realmexample.recyclerview;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.TextView;

import tech42.sathish.realmexample.R;

/**
 * Created by lenovo on 7/2/17.
 */

public class RecyclerViewHolder extends RecyclerView.ViewHolder {

    TextView titleTextView;
    TextView authorTextView;

    public RecyclerViewHolder(View itemView) {
        super(itemView);

        titleTextView = (TextView) itemView.findViewById(R.id.nameTxt);
        authorTextView = (TextView) itemView.findViewById(R.id.authorTxt);
    }
}
