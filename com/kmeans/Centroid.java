package com.kmeans;

public class Centroid {
    private float[] vectors;
    private float[] avgVec;

    private int size;
    public Centroid(float[] Vec){
        set(Vec);
    }
    public float[] get(){
        return vectors;
    }
    public void set(float[] Vec){
        this.vectors = Vec;
        this.size =Vec.length;
        this.avgVec = new float[Vec.length];
        for(int i =0; i < Vec.length; i++){
            this.avgVec[i] = 0;
        } 
        
    }
    public void addAvg(float[] Vec){
        for(int i =0; i<Vec.length; i++){
            this.avgVec[i] = Vec[i];
        }
        this.size++;
    }
    public int getSize(){
        return size;
    }
    public boolean move(){
        if(this.size == 0){
            //move random
            return false;
        }
        float[] tmp = new float[this.avgVec.length];
        for(int i=0; i < this.avgVec.length; i++){
            tmp[i] = this.avgVec[i]/this.size;
        }
        set(tmp);
        return true;
    }
}
