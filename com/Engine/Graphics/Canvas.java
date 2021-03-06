package com.Engine.Graphics;

import com.Engine.Math.Vector2f;
import com.kmeans.Centroid;
import com.kmeans.Datapoint;

/*
import org.lwjgl.*;
import org.lwjgl.glfw.*;
import org.lwjgl.opengl.*;
import org.lwjgl.system.*;
import org.lwjgl.system.CallbackI.I;

import java.nio.*;
import static org.lwjgl.glfw.GLFW.*;
*/




import static org.lwjgl.opengl.GL11.*;



/**
 * Design Pattern: Singleton
 */
public class Canvas {
    private static Canvas INSTANCE;
    private colorRGB background;
    public static Canvas getInstance(){
        if (INSTANCE == null){ 
            
            INSTANCE = new Canvas();
           
           
        } 
        return INSTANCE;
    }
    public void setBackGroundColor(colorRGB color){
        background = color;
    }
    public colorRGB getBackGroundColor(){
        return background;
    }
    public void drawBackground(){

    }
 
    public void drawOutLine(double x,double y,int gridSize){
        
        //glColor4f(1.0f,0.0f,0.0f,0.05f);
        
        drawQuad((float)x-gridSize/2, (float)y-gridSize/2, gridSize*2,gridSize);   
        //drawQuad((float)y-gridSize+()*gridSize+(gridSize/1.5f), (float)x-gridSize+(i)*gridSize+(gridSize/1.5f), gridSize/1.5f, gridSize/1.5f);
                
                
            
        
    }
    public void drawColorArray(colorRGB[][] a, float gridSize,Vector2f offset ){
        for(int i =0; i<a.length; i++){
            for(int u = 0; u<a[0].length; u++){
                float[] color;
                try{
                    color = a[i][u].colorf();
                    glColor4f(color[0],color[1],color[2],1.0f);
                    drawQuad((float)(i+offset.getY())*gridSize,(float)(u+offset.getX())*gridSize, gridSize, gridSize);
                }catch(Exception e){
                    
                }
                //Random rand = new Random();
                //glColor4f(color[0],color[1]+(rand.nextFloat()/10),color[2],1.0f);
                
            }
        }
    }
    public void drawCentroid(Centroid[] cents,float gridSize,int offset){
        glColor4f(1.0f,0.5f,1.0f,1.0f);
        for(int i=0; i<cents.length; i++){
            float[] tmp = cents[i].get();
            drawQuad(tmp[0]*gridSize*offset, tmp[1]*gridSize*offset, gridSize, gridSize);
        }
    }
    public void drawData(Datapoint[] data,float gridSize,int offset){
        glColor4f(1.0f,1.0f,1.0f,1.0f);
        for(int i=0; i<data.length; i++){
            float[] tmp = data[i].get();
            drawQuad(tmp[0]*gridSize*offset, tmp[1]*gridSize*offset, gridSize, gridSize);
        }
    }
    public void drawLine(float[] tmp1,float[] tmp2,float gridSize,int offset){
        glColor4f(1.0f,0.0f,1.0f,1.0f);
        glBegin(GL_LINE);
		glVertex2f(1.0f,0.0f);
		glVertex2f(0.0f,1.0f);
		
		glEnd();
    }
    public void drawMatrix(int[][] a,float gridSize){
        
        glColor4f(1.0f,1.0f,1.0f,1.0f);
        for(int i =0; i< a.length; i++){
            for(int u =0; u<a[0].length; u++){
                if(a[i][u]!=0){
                    //float[] color = SandType.typeColor(a[i][u]).colorf();
                   // glColor4f(color[0],color[1],color[2],1.0f);
                    drawQuad((u)*gridSize, (i)*gridSize, gridSize, gridSize);
                }
            }
        }
    }/*
    public void drawCluster(int[][] c,float gridSize){
        glColor4f(1.0f,1.0f,1.0f,1.0f);
            try{
               
                for(int i=0; i<c.length; i++){
                    try{
                        float[] color = SandType.typeColor(c[i][3]).colorf();
                        glColor4f(color[0],color[1],color[2],1.0f);
                        drawQuad((float)(c[i][0])*gridSize,(float)(c[i][2])*gridSize,(float)(c[i][1]+1)*gridSize,gridSize);
                    }catch(Exception e){}
                }
            }catch(Exception e){
                //drawMatrix(c, gridSize);
            }
    }*/
    

    public void drawQuad(float x,float y, float width,float height,colorRGB color){
        //glColor4f(1.0f,1.0f,1.0f,1.0f);
        float[] colors = color.colorf();
        glColor4f(colors[0],colors[1],colors[2],colors[3]);
		glBegin(GL_POLYGON);
		
		glVertex2f(x,y);
		glVertex2f(width+x,y);
		glVertex2f(width+x,height+y);
		glVertex2f(x,height+y);
		glEnd();
    }
    public void drawQuad(float x,float y, float width,float height){
        //glColor4f(1.0f,1.0f,1.0f,1.0f);
		glBegin(GL_POLYGON);
		
		glVertex2f(x,y);
		glVertex2f(width+x,y);
		glVertex2f(width+x,height+y);
		glVertex2f(x,height+y);
		glEnd();
    }
    public void flush(){
        glFlush();
    }
    public void changeString(String str){
        
    }
}
