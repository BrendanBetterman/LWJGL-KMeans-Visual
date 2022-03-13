package com.kmeans;
import com.kmeans.Centroid;
public class Datapoint {
    private float x;
    private float y;
    private Centroid id;
    public Datapoint(float x,float y){
        this.x = x;
        this.y = y;
    }
    public void setId(Centroid id) {
        this.id = id;
    }
    public Centroid getId() {
        return id;
    }
    public float getX() {
        return x;
    }
    public float getY() {
        return y;
    }
    public void setX(float x) {
        this.x = x;
    }
    public void setY(float y) {
        this.y = y;
    }
}
