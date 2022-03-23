package com.kmeans;
public class Datapoint {
    private float[] vector;
    private int id;
    public Datapoint(float[] vec){
        this.vector = vec;
    }
    public void setId(int id) {
        this.id = id;
    }
    public int getId() {
        return id;
    }
    public void set(float[] vec){
        this.vector = vec;
    }
    public float[] get(){
        return this.vector;
    }
}
