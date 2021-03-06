package com.kmeans;
import java.util.Random;
import java.io.File;
import java.util.Scanner;
import java.util.ArrayList;
public class Kmeans {
    private Centroid[] centroid;
    private Datapoint[] data;
    public Kmeans(int centroids){
        
        setData(10,4);
        setCentroids(centroids, 4);
        
    }
    private void setCentroids(int centroids,int datasize){
        Random rand = new Random();
        centroid = new Centroid[centroids];
        for(int i=0; i < centroids; i++){
            float[] tmp = new float[datasize];
            for(int u=0; u< datasize; u++){
                tmp[u] = rand.nextFloat();
            }
            centroid[i] = new Centroid(tmp);
        }
    }
    private void setData(int size,int datasize){
        try{
            ArrayList<float[]> array = new ArrayList<float[]>();
            File myObj = new File("data.csv");
            Scanner myReader = new Scanner(myObj);
            while (myReader.hasNextLine()){
                String tmp = myReader.nextLine();
                String[] tmp2 = tmp.split(",");
                float[] tmp3 = new float[tmp2.length];
                for(int i=0; i < tmp2.length; i++){
                    tmp3[i]=Float.valueOf(tmp2[i]);
                }
                array.add(tmp3);
            }
            myReader.close();
            data = new Datapoint[array.size()];
            for (int i=0; i< array.size(); i++){
                data[i] = new Datapoint(array.get(i));
            }
        }catch(Exception e){}
        
        /*
        //from csv
        Random rand = new Random();
        data = new Datapoint[size];
        for(int u=0; u< size; u++){
            float[] tmp = new float[datasize];
            for(int i=0; i<tmp.length; i++){
                tmp[i] = rand.nextFloat();
            }
            
            data[u] = new Datapoint(tmp);
        }*/
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
        //System.out.println(tmp2.length);
        for(int i=0; i < tmp1.length-1; i ++){
            avg += sq(tmp1[i]-tmp2[i]);
            //System.out.println(tmp2[i]);
            
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
        for(Centroid i : centroid){
            for( float u : i.get()){
                System.out.print(u);
                System.out.print(" ");
            }System.out.println();
            

        }
    }
}
