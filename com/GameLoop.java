package com;


import com.Engine.Input;
import org.lwjgl.glfw.GLFW;

public class GameLoop implements Runnable{
    
    private Input input;
    public int xOff;
    public int yOff;


    public int type;
 



    public GameLoop(){
        

    
        input = Input.getInstance();
        xOff =64;

        type = 1;
 

    }
  
   
    public void controls(int WIDTH,int HEIGHT){
        
        if(input.isButtonDown(GLFW.GLFW_MOUSE_BUTTON_LEFT)) {
           
        }
        if(input.isKeyDown(GLFW.GLFW_KEY_LEFT_SHIFT)){
        
        }

        if(input.isButtonDown(GLFW.GLFW_MOUSE_BUTTON_RIGHT)) {
     
        }
        

        for(int keys = 49; keys<58; keys++){
        
        }

        //Movement
        if(input.isKeyDown(GLFW.GLFW_KEY_A)){
            
        }
        if(input.isKeyDown(GLFW.GLFW_KEY_D)){
           
      
        }
        if(input.isKeyDown(GLFW.GLFW_KEY_SPACE)){
            //player.move(new Vector2f(1, 1));
           // player.setMomentium(new Vector2f(0, 1));
        }
        if(input.isKeyDown(GLFW.GLFW_KEY_S)){
        
        }
        if(input.isKeyDown(GLFW.GLFW_KEY_W)){
        
        }
        

        //Pause
        if(input.isKeyDown(GLFW.GLFW_KEY_SPACE)){
     
        }
       
    }
    public void update(int width,int height){
        
           
    }
    @Override
    public void run(){
        while(!input.isKeyDown(GLFW.GLFW_KEY_ESCAPE)){
            //for(int i=0; i<2; i++){
            update(1024, 512);
            
         System.out.println("running");
            }
       // }
        
            
           
        
    }
}
