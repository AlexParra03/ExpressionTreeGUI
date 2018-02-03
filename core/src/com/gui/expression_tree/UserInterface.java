/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.gui.expression_tree;

import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer.ShapeType;
import java.util.ArrayList;


public class UserInterface {
    
    BitmapFont font = new BitmapFont();
    ShapeRenderer boxes = new ShapeRenderer();
    
    // Coordinates of the input box
    private final int X = 50;
    private final int Y = 400;
    private final int WIDTH = 400;
    private final int HEIGHT = 70;
    
    private final int T_WIDTH = 550;
    private final int T_HEIGHT = 300;
    
    public String expression = "";
    
    
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
    
    public void renderTree(ExpressionTree tree, SpriteBatch batch){
        //boxes.setColor(Color.BLACK);
        batch.end();
        //boxes.begin(ShapeType.Filled);
        ArrayList<ArrayList<Node>> nodesInfo = new ArrayList<ArrayList<Node>>();
        recursiveRender(tree.root, 0, nodesInfo);
        //boxes.end();
        int circleSize = 20;
        int dy = 50;
        for(int i=0; i<nodesInfo.size(); i++){
            ArrayList<Node> list = nodesInfo.get(i);
            for(int j=0; j<list.size(); j++){
                int x = (j+1)*(int)(T_WIDTH/ Math.pow(2, i));
                int y = T_HEIGHT - (dy*i);
                boxes.begin(ShapeType.Filled);
                //if(list.get(i).data.length() > 0){
                    boxes.circle( x,y,circleSize) ;
                //}
                boxes.end();
                batch.begin();
                if(list.get(i).data.length() > 0){
                    font.draw(batch, list.get(j).data, x, y);
                }
                
                batch.end();
            }
        }
        
        
        
        batch.begin();
    }
    
    private void recursiveRender(Node node, int height, ArrayList<ArrayList<Node>> nodesInfo){
        if(height == 4){
            return;
        }
        
        if(nodesInfo.size() == height){
            nodesInfo.add(new ArrayList<Node>());
        }
        if(node == null){
            Node placeholder = new Node("");
            nodesInfo.get(height).add(placeholder);
            recursiveRender(placeholder.left, height+1, nodesInfo);
            recursiveRender(placeholder.right, height+1, nodesInfo);       
        }else{
            nodesInfo.get(height).add(node);
            recursiveRender(node.left, height+1, nodesInfo);
            recursiveRender(node.right, height+1, nodesInfo);
        }
        
        /*
        boxes.begin();
        boxes.circle( (int)(T_WIDTH/ Math.pow(2, height)), T_HEIGHT - (50* height), 32);
        boxes.end();
        batch.begin();
        font.draw(batch, node.data, (int)(T_WIDTH/ Math.pow(2, height)), T_HEIGHT - (50* height));
        batch.end();
        recursiveRender(node.left, height+1, batch);
        recursiveRender(node.right, height+1, batch);
        */
        
    }
    
}
