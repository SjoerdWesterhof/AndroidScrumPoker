package com.billythebastard.scrumpoker;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.ImageView;

import com.billythebastard.scrumpoker.pokercards.PokerCard;
import com.billythebastard.scrumpoker.pokercards.PokerCardList;
import com.billythebastard.scrumpoker.pokercards.recyclerlistview.PokerCardRecyclerAdapter;
import com.billythebastard.scrumpoker.pokercards.recyclerlistview.RecyclerItemClickListener;

public class PlayPoker extends AppCompatActivity {

    private PokerCardList _pokerCards = new PokerCardList();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_play_poker);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        initializePokerList();
    }

    private void initializePokerList() {
        RecyclerView recyclerView = (RecyclerView) findViewById(R.id.pokercards_recyclerView);
        recyclerView.setHasFixedSize(true);

        LinearLayoutManager layoutManager = new LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false);
        recyclerView.setLayoutManager(layoutManager);

        PokerCardRecyclerAdapter adapter = new PokerCardRecyclerAdapter(_pokerCards.getPokerCards());
        recyclerView.setAdapter(adapter);

        recyclerView.addOnItemTouchListener(
                new RecyclerItemClickListener(this, recyclerView ,new RecyclerItemClickListener.OnItemClickListener() {
                    @Override public void onItemClick(View view, int position) {
                        PokerCard pokerCard = _pokerCards.getPokerCard(position);
                        UpdateScore(pokerCard);
                    }

                    @Override public void onLongItemClick(View view, int position) {
                        PokerCard pokerCard = _pokerCards.getPokerCard(position);
                        UpdateScore(pokerCard);
                    }
                })
        );
    }

    private void UpdateScore(PokerCard pokerCard) {
        ImageView score = (ImageView) findViewById(R.id.imageViewScore);
        score.setImageResource(pokerCard.GetImageResourceId());
    }

}
