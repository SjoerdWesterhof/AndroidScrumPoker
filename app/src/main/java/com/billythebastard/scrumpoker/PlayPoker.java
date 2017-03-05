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

public class PlayPoker extends AppCompatActivity {

    private PokerCard[] mPokerCards =
            {
                    new PokerCard("0", R.drawable.pokercard_0),
                    new PokerCard("0.5", R.drawable.pokercard_half),
                    new PokerCard("1", R.drawable.pokercard_1),
                    new PokerCard("2", R.drawable.pokercard_2),
                    new PokerCard("3", R.drawable.pokercard_3),
                    new PokerCard("5", R.drawable.pokercard_5),
                    new PokerCard("8", R.drawable.pokercard_8),
                    new PokerCard("13", R.drawable.pokercard_13),
                    new PokerCard("20", R.drawable.pokercard_20),
                    new PokerCard("40", R.drawable.pokercard_40),
                    new PokerCard("100", R.drawable.pokercard_100),
                    new PokerCard("?", R.drawable.pokercard_questionmark),
                    new PokerCard("coffee", R.drawable.pokercard_coffee)
            };

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

        PokerCardRecyclerAdapter adapter = new PokerCardRecyclerAdapter(mPokerCards);
        recyclerView.setAdapter(adapter);

        recyclerView.addOnItemTouchListener(
                new RecyclerItemClickListener(this, recyclerView ,new RecyclerItemClickListener.OnItemClickListener() {
                    @Override public void onItemClick(View view, int position) {
                        PokerCard pokerCard = mPokerCards[position];
                        UpdateScore(pokerCard);
                    }

                    @Override public void onLongItemClick(View view, int position) {
                        PokerCard pokerCard = mPokerCards[position];
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
