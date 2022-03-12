package com;


// import com.Console.Commands;
//https://www.youtube.com/watch?v=1F9shq6KubY&ab_channel=CodingAP
import com.Engine.*;
import com.Engine.Graphics.Canvas;
import com.Engine.Graphics.UI;
import com.Engine.Graphics.colorRGB;
import org.lwjgl.glfw.GLFW;


public class Main implements Runnable {
    public Thread game;
    
    public Window window;
    public Input input;
    public final int WIDTH = 1280, HEIGHT = 720;
    private int gridSize = 5;
    private Canvas canvas;
    private GameLoop gameLoop;

    //private Commands console;

    public void start(){
        game = new Thread(this,"game");
        
        
        game.run();
        
    }
    public void init(){
        System.out.println("Init Game");
        window = new Window(WIDTH,HEIGHT)
        .title("Sand!")
        .fullScreen(false)
        .frameCap(false);
        
        try{
            window.create();
            input = Input.getInstance();
        }catch(Exception e){System.out.println(e);}
        canvas = Canvas.getInstance();
        //player = new Player(100,100);
        gameLoop = new GameLoop();
        
        //console = new Commands(gameLoop,window);
        canvas.setBackGroundColor(new colorRGB(15,177,210));
        //try{
           //console.start();
       // }catch(Exception e){}
        
    }
    
    public void run(){
        init();
        
        while (!window.shouldClose() && !input.isKeyDown(GLFW.GLFW_KEY_ESCAPE)){
            
            update();
            render();
            
            if(input.isKeyDown(GLFW.GLFW_KEY_F11)) window.toggleFullScreen();
        }
       // console.stopRunning();
        window.destroy();
    }
    private void update(){
         
        window.update();
        
        //GameLoop
        gameLoop.update(WIDTH/gridSize,HEIGHT/gridSize<=512 ? HEIGHT/gridSize : 512);
        gameLoop.controls(WIDTH,HEIGHT);
        
        
    }
    private void render(){
        
        
        canvas.drawOutLine(input.getMouseX(),HEIGHT-input.getMouseY(),gridSize);
        
       
        canvas.flush();
        //Reset Window
        window.swapBuffers();
    }
    public static void main(String[] args){
        new Main().start();
    }
}