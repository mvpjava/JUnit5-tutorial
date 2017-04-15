package com.mvpjava.electricity;

class Mass {

    private long weight;
    private String unit;


    public Mass(long weight, String unit) {
        this.weight = weight;
        this.unit = unit;
    }

    long getWeight() {
        return this.weight;
    }
    
}
