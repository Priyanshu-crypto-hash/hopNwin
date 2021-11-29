package com.company;

import java.util.ArrayList;
import java.util.concurrent.ThreadLocalRandom;

class Player {
    private ArrayList<Toy> bucket = new ArrayList<>();
    private int chancesLeft = 5;
    public int getChancesLeft() {
        return chancesLeft;
    }
    public void setChancesLeft(int chancesLeft) {
        this.chancesLeft = chancesLeft;
    }

    public void setBucket(Toy t) {
        this.bucket.add(t);

    }

    public ArrayList<Toy> getBucket() {
        return bucket;
    }

    protected int hop(){
        int rand = ThreadLocalRandom.current().nextInt(0, 25);
        return rand;
    }

}
