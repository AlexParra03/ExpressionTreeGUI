/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.gui.expression_tree;

import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;


public class UserInterface {
    
    BitmapFont font = new BitmapFont();
    ShapeRenderer boxes = new ShapeRenderer();
    
    // Coordinates of the input box
    private final int X = 50;
    private final int Y = 400;
    private final int WIDTH = 400;
    private final int HEIGHT = 70;
    
    public String expression = "OO";
    
    
    public UserInterface(){
        font.setColor(0,0,0,1);
    }
    
    public void render(SpriteBatch batch){
            batch.end();
            
            boxes.begin(ShapeRenderer.ShapeType.Filled);
            //Drawing background with black border
            boxes.setColor(0, 0, 0, 1);
            boxes.rect(X, Y, WIDTH, HEIGHT);
            boxes.setColor(200,200,200,1);
            boxes.rect(X+4, Y+4, WIDTH-8, HEIGHT-8);
            
            boxes.end();
            batch.begin();
            font.draw(batch, "Input:", X+ 14, Y+HEIGHT-10);
            font.draw(batch, this.expression, X + 14, Y+HEIGHT - 30);
            font.draw(batch, "Press ENTER to close.", X + 14, Y+HEIGHT - 50);

    }
    
    public void addCharacter(char c){
        this.expression += c;
    }
    
    public void backspace(){
        if(this.expression.length() > 0){
            this.expression = this.expression.substring(0,this.expression.length()-1);
        }
    }
    
}
