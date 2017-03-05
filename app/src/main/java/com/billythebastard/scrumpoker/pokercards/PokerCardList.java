package com.billythebastard.scrumpoker.pokercards;

import com.billythebastard.scrumpoker.R;

public class PokerCardList {

    private PokerCard[] _pokerCards = {
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

    public PokerCard[] getPokerCards() {
        return _pokerCards;
    }

    public PokerCard getPokerCard(int position) {
        return _pokerCards[position];
    }
}
