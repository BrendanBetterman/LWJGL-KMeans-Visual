package com.kmeans;
import java.util.Random;
public class Kmeans {
    private Centroid[] centroid;
    private Datapoint[] data;
    public Kmeans(int centroids){
        
        setData(10);
        setCentroids(centroids, 10);
        
    }
    private void setCentroids(int centroids,int datasize){
        Random rand = new Random();
        centroid = new Centroid[centroids];
        for(int i=0; i < centroids; i++){
            float[] tmp = new float[datasize];
            for(int u=0; u< datasize; u++){
                tmp[u] = rand.nextFloat()*10;
            }
            centroid[i] = new Centroid(tmp);
        }
    }
    private void setData(int size){
        //from csv
        Random rand = new Random();
        data = new Datapoint[size];
        for(int u=0; u< size; u++){
            float[] tmp = new float[4];
            for(int i=0; i<tmp.length; i++){
                tmp[i] = rand.nextFloat()*10;
            }
            
            data[u] = new Datapoint(tmp);
        }
    }
    private float sq(float num){
        return num*num;
    }
    public Datapoint[] getData(){
        return this.data;
    }
    public Centroid[] getCentroids(){
        return this.centroid;
    }
    public float relDist(Centroid cent ,Datapoint data){
        float avg =0;
        float[] tmp1 = cent.get();
        float[] tmp2 = data.get();
        for(int i=0; i < cent.getSize()-1; i ++){
            avg += sq(tmp1[i]-tmp2[i]);
        }
        return avg;
    }
    
    public void classifyPoints(){
        for(int i=0; i< data.length; i++){
            int centId =0;
            float best = relDist(centroid[0],data[i]);
            for (int u=1; u<this.centroid.length; u++){
                float tmp = relDist(centroid[u], data[i]);
                if(tmp<=best){
                    best=tmp;
                    centId=u;
                }
            }
            data[i].setId(centId);
            centroid[centId].addAvg(data[i].get());
        }
    }
    public void moveCentroids(){
        for(int i=0; i<this.centroid.length; i++){
            if(!centroid[i].move()){
                //random centroid set to avoid divison by zero
                Random rand = new Random();
                int tmp = rand.nextInt(this.data.length);
                data[tmp].setId(tmp);
                centroid[i].addAvg(data[tmp].get());
                centroid[i].move();
            }
        }
    }
    public void run(){
        classifyPoints();
        moveCentroids();
    }
}
/*
function createCentroids(centroids,width,height){
    let Cents = [];
    for(let i=0; i< centroids; i++){
        Cents.push(new Centroid(getRandomInt(width),getRandomInt(height)));
    }
    return Cents;
}
function createData(dataSize,width,height){
    let data = [];
    for(let i=0; i<dataSize; i++){
        data.push(new DataPoint(getRandomInt(width),getRandomInt(height)));
    }
    return data;
}
function getRandomInt(max) {
    return Math.floor(Math.random() * max);
}
function sq(num){
    return num*num;
}
function relDist(cent,dataPoint){
    return sq(cent.getX()-dataPoint.getX())+sq(cent.getY()-dataPoint.getY());
}
function classifyPoints(Data,Cents,centroids,dataSize){
    for(let i=0; i< dataSize; i++){
        let centId =0;
        let best = relDist(Cents[0],Data[i]);
        for(let u=1; u<centroids; u++){
            let tmp = relDist(Cents[u],Data[i]);
            if(tmp <= best){
                best = tmp;
                centId = u;
            }
        }
        Data[i].setCentroid(centId);
        Cents[centId].addAVG(Data[i].getX(),Data[i].getY());
    }
}
function moveCentroids(Cents,centroids){
    for(let i=0; i<centroids; i++){
        if(!Cents[i].move()){
            Cents[i].set(getRandomInt(width),getRandomInt(height));
        }
    }
}

function kmean(ctx,centroids,dataSize,width,height){
    let scale = 4;
    let Cents = createCentroids(centroids,width,height);
    let Data = createData(dataSize,width,height);
    for(let runs =0; runs <4; runs++){
        classifyPoints(Data,Cents,centroids,dataSize);
        moveCentroids(Cents,centroids);
    }
        for(let i=0; i< dataSize; i++){
            drawLine(ctx,[Data[i].getX()*scale,Data[i].getY()*scale],[Cents[Data[i].getCentroid()].getX()*scale,Cents[Data[i].getCentroid()].getY()*scale]);
            drawDot(ctx,Data[i].getX()*scale,Data[i].getY()*scale,'red');
        }
        for(let i=0; i< centroids; i++){
            drawDot(ctx,Cents[i].getX()*scale,Cents[i].getY()*scale,'blue');
        }
}
*/