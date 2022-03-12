package com.Engine.Graphics;



import com.SandObj.SandType.SandTypeController;

public class UI {
    private int type;
    private int x;
    private int y;
    private int size;
    
    public void setType(int type){
        this.type = type;
    }
    public void setX(int x){
        this.x = x;
    }
    public void setY(int y){
        this.y = y;
    }
    public void setSize(int size){
        this.size = size;
    }
    public void render(){
        Canvas tmp = Canvas.getInstance();
        int scale = 10;
        for(int i=-2; i< 3; i++){
            if(type+i >0 && type+i<=15){
                
                tmp.drawQuad(y-size/2-5+(Math.abs(i)*scale/2)-scale, x-size/2-5+(i*(size+50))+(Math.abs(i)*scale), size+10-(Math.abs(i)*scale), size+10-(Math.abs(i)*scale),new colorRGB(0, 0, 0));
                try{
                    tmp.drawQuad(y-size/2+(Math.abs(i)*scale/2)-scale, x-size/2+(i*(size+50))+(Math.abs(i)*scale), size-(Math.abs(i)*scale), size-(Math.abs(i)*scale), SandTypeController.getSandById(type+i).getColorRGB());
                }catch(Exception e){}
                
            }
        }
        
    }
}
