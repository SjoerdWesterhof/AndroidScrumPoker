package com.billythebastard.scrumpoker.pokercards.recyclerlistview;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;

import com.billythebastard.scrumpoker.R;
import com.billythebastard.scrumpoker.pokercards.PokerCard;


public class PokerCardRecyclerAdapter  extends RecyclerView.Adapter<PokerCardRecyclerAdapter.ViewHolder> {
    private PokerCard[] _pokerCards;

    // Provide a reference to the views for each data item
    // Complex data items may need more than one view per item, and
    // you provide access to all the views for a data item in a view holder
    public static class ViewHolder extends RecyclerView.ViewHolder {
        // each data item is just a string in this case
        public View mView;
        public ViewHolder(View v) {
            super(v);
            mView = v;
        }
    }

    // Provide a suitable constructor (depends on the kind of dataset)
    public PokerCardRecyclerAdapter(PokerCard[] pokerCards) {
        _pokerCards = pokerCards;
    }

    // Create new views (invoked by the layout manager)
    @Override
    public PokerCardRecyclerAdapter.ViewHolder onCreateViewHolder(ViewGroup parent,
                                                   int viewType) {
        // create a new view
        LinearLayout view = (LinearLayout) LayoutInflater.from(parent.getContext())
                .inflate(R.layout.pokercard_item, parent, false);
        // set the view's size, margins, paddings and layout parameters

        ViewHolder vh = new ViewHolder(view);
        return vh;
    }

    // Replace the contents of a view (invoked by the layout manager)
    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        // - get element from your dataset at this position
        // - replace the contents of the view with that element
        // holder.m.setText(mDataset[position]);

        PokerCard pokerCard = _pokerCards[position];
        ImageView pokerCardImageView = (ImageView) holder.mView.findViewById(R.id.pokercard_imageview);
        pokerCardImageView.setImageResource(pokerCard.GetImageResourceId());

    }

    // Return the size of your dataset (invoked by the layout manager)
    @Override
    public int getItemCount() {
        return _pokerCards.length;
    }
}
