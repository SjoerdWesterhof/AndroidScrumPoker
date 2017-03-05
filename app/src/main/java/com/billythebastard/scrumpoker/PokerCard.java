package com.billythebastard.scrumpoker;

/**
 * Created by v.keizer on 5-3-2017.
 */

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
