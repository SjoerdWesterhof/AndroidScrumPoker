package com.billythebastard.scrumpoker.pokercards;

public class PokerCard {
    private String _score;
    private int _imageResourceId;

    public PokerCard(String score, int imageResourceId) {
        _score = score;
        _imageResourceId = imageResourceId;
    }

    public String GetSCore() {
        return _score;
    }

    public int GetImageResourceId() {
        return _imageResourceId;
    }
}
