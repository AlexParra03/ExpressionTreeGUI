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
    private final int X = 10;
    private final int Y = 400;
    private final int WIDTH = 350;
    private final int HEIGHT = 70;
    
    private final int T_WIDTH = 600;
    private final int T_HEIGHT = 350;
    
    public String expression = "";
    public String inOrder = "";
    public String postOrder = "";
    public String preOrder = "";
    public String result = "";
    
    
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
            font.draw(batch, "Press ENTER to evaluate.", X + 14, Y+HEIGHT - 50);
            font.draw(batch, "IN-Order: "+inOrder, X+WIDTH+10, Y+HEIGHT);
            font.draw(batch, "PRE-Order: "+preOrder, X+WIDTH+10, Y+HEIGHT-20);
            font.draw(batch, "POST-Order: "+postOrder, X+WIDTH+10, Y+HEIGHT-40);
            font.draw(batch, "Result : "+result, X+WIDTH+10, Y+HEIGHT-60);
            

    }
    
    public void addCharacter(char c){
        if(this.expression.length() < 30){
            this.expression += c;
        }
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
        int circleSize = 15;
        int dy = 55;
        for(int i=0; i<nodesInfo.size(); i++){
            ArrayList<Node> list = nodesInfo.get(i);
            for(int j=0; j<list.size(); j++){
                boxes.begin(ShapeType.Filled);
                if(!list.get(j).data.equals("")){
                    boxes.circle( nodeXPos(j, i, circleSize),nodeYPos(i, dy),circleSize) ;
                    if(i > 0){
                        boxes.line(nodeXPos(j, i, circleSize), nodeYPos(i, dy)+circleSize, nodeXPos(j/2, i-1, circleSize), nodeYPos(i-1, dy)-circleSize);
                    }
                }
                boxes.end();
                batch.begin();
                if(!list.get(j).data.equals("")){
                    font.draw(batch, list.get(j).data, nodeXPos(j, i, circleSize)-5, nodeYPos(i, dy)+5);
                }
                
                batch.end();
            }
        }
        
        
        
        batch.begin();
    }
    
    private int nodeXPos(int number, int height, int circleSize){
        int x = number*(int)(T_WIDTH/ Math.pow(2, height));
        int offset = (int)(T_WIDTH/ (2*Math.pow(2, height)));
        x += offset + circleSize;
        return x;
    }
    
    private int nodeYPos(int height, int dy){
        return T_HEIGHT - (dy*height);
    }
    
    private void recursiveRender(Node node, int height, ArrayList<ArrayList<Node>> nodesInfo){
        if(height == 6){
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
