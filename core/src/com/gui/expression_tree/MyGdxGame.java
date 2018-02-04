package com.gui.expression_tree;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

public class MyGdxGame extends ApplicationAdapter {
	SpriteBatch batch;
        UserInterface menu;
        ExpressionTree tree;
        boolean treeReady = false;
	
	@Override
	public void create () {
		batch = new SpriteBatch();
                menu = new UserInterface();
                tree = new ExpressionTree();
                Gdx.graphics.setWindowedMode(1100, 900);
                Gdx.graphics.setResizable(false);
	}

	@Override
	public void render () {
		Gdx.gl.glClearColor(0, 0, 200, 50);
		Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
                handleInput();
		batch.begin();
		//batch.draw(img, 0, 0);
                menu.render(batch);
                if(treeReady){
                    menu.renderTree(tree, batch);
                }
                batch.end();
	}
	
	@Override
	public void dispose () {
		batch.dispose();
	}
        
        private void handleInput(){
            UserInterface input = this.menu;
            
            if(Gdx.input.isKeyPressed(59) || Gdx.input.isKeyPressed(60)){
               if(Gdx.input.isKeyJustPressed( 13)){
                   input.addCharacter('^');
               }else if(Gdx.input.isKeyJustPressed(15 )){
                   input.addCharacter('*');
               }else if(Gdx.input.isKeyJustPressed(70 )){
                   input.addCharacter('+');
               }else if(Gdx.input.isKeyJustPressed( 16 ) ){
                   input.addCharacter('(');
               }else if(Gdx.input.isKeyJustPressed( 7 ) ){
                   input.addCharacter(')');
               }
           }else{

                if(Gdx.input.isKeyJustPressed( 29 )){
                    input.addCharacter('a');
               }else if(Gdx.input.isKeyJustPressed( 30 )){
                    input.addCharacter('b');
               }else if(Gdx.input.isKeyJustPressed( 31 )){
                    input.addCharacter('c');
               }else if(Gdx.input.isKeyJustPressed( 32 )){
                   input.addCharacter('d');
               }else if(Gdx.input.isKeyJustPressed( 33 )){
                   input.addCharacter('e');
               }else if(Gdx.input.isKeyJustPressed( 34 )){
                   input.addCharacter('f');
               }else if(Gdx.input.isKeyJustPressed( 35 )){
                   input.addCharacter('g');
               }else if(Gdx.input.isKeyJustPressed( 36 )){
                   input.addCharacter('h');
               }else if(Gdx.input.isKeyJustPressed( 37 )){
                   input.addCharacter('i');
               }else if(Gdx.input.isKeyJustPressed( 38 )){
                   input.addCharacter('j');
               }else if(Gdx.input.isKeyJustPressed( 39 )){
                   input.addCharacter('k');
               }else if(Gdx.input.isKeyJustPressed( 40 )){
                   input.addCharacter('l');
               }else if(Gdx.input.isKeyJustPressed( 41 )){
                   input.addCharacter('m');
               }else if(Gdx.input.isKeyJustPressed( 42 )){
                   input.addCharacter('n');
               }else if(Gdx.input.isKeyJustPressed( 43 )){
                   input.addCharacter('o');
               }else if(Gdx.input.isKeyJustPressed( 44 )){
                   input.addCharacter('p');
               }else if(Gdx.input.isKeyJustPressed( 45 )){
                   input.addCharacter('q');
               }else if(Gdx.input.isKeyJustPressed( 46 )){
                   input.addCharacter('r');
               }else if(Gdx.input.isKeyJustPressed( 47 )){
                   input.addCharacter('s');
               }else if(Gdx.input.isKeyJustPressed( 48 )){
                   input.addCharacter('t');
               }else if(Gdx.input.isKeyJustPressed( 49 )){
                   input.addCharacter('u');
               }else if(Gdx.input.isKeyJustPressed( 50 )){
                   input.addCharacter('v');
               }else if(Gdx.input.isKeyJustPressed( 51 )){
                   input.addCharacter('w');
               }else if(Gdx.input.isKeyJustPressed( 52 )){
                   input.addCharacter('x');
               }else if(Gdx.input.isKeyJustPressed( 53 )){
                   input.addCharacter('y');
               }else if(Gdx.input.isKeyJustPressed( 54 )){
                   input.addCharacter('x');
               }else if(Gdx.input.isKeyJustPressed( 7 ) || Gdx.input.isKeyJustPressed( 144 )){
                   input.addCharacter('0');
               }else if(Gdx.input.isKeyJustPressed( 8 ) || Gdx.input.isKeyJustPressed( 145 )){
                   input.addCharacter('1');
               }else if(Gdx.input.isKeyJustPressed( 9 ) || Gdx.input.isKeyJustPressed( 146 )){
                   input.addCharacter('2');
               }else if(Gdx.input.isKeyJustPressed( 10 ) || Gdx.input.isKeyJustPressed( 147 )){
                   input.addCharacter('3');
               }else if(Gdx.input.isKeyJustPressed( 11 ) || Gdx.input.isKeyJustPressed( 148 )){
                   input.addCharacter('4');
               }else if(Gdx.input.isKeyJustPressed( 12 ) || Gdx.input.isKeyJustPressed( 149 )){
                   input.addCharacter('5');
               }else if(Gdx.input.isKeyJustPressed( 13 ) || Gdx.input.isKeyJustPressed( 150 )){
                   input.addCharacter('6');
               }else if(Gdx.input.isKeyJustPressed( 14 ) || Gdx.input.isKeyJustPressed( 151 )){
                  input.addCharacter('7');
               }else if(Gdx.input.isKeyJustPressed( 15 ) || Gdx.input.isKeyJustPressed( 152 )){
                   input.addCharacter('8');
               }else if(Gdx.input.isKeyJustPressed( 16 ) || Gdx.input.isKeyJustPressed( 153 )){
                   input.addCharacter('9');
               }else if(Gdx.input.isKeyJustPressed( 62 )){
                   input.addCharacter(' ');
               }else if(Gdx.input.isKeyJustPressed(56)){
                   input.addCharacter('.');
               }else if(Gdx.input.isKeyJustPressed( 76 ) ){
                   input.addCharacter('/');
               }else if(Gdx.input.isKeyJustPressed( 69 )){
                   input.addCharacter('-');
               }else if(Gdx.input.isKeyJustPressed(67)){
                   input.backspace();
               }else if(Gdx.input.isKeyJustPressed(66)){
                    compute();
                }
            }

        }
        
        private void compute(){
            this.tree.read(this.menu.expression);
            this.tree.inOrder();
            this.menu.inOrder =this.tree.inOrder ;
            this.tree.postOrder();
            this.menu.postOrder = this.tree.postOrder;
            this.tree.preOrder();
            this.menu.preOrder = this.tree.preOrder;
            this.treeReady = true;
            
            try{
                double result = this.tree.calculate();
                this.menu.result = ""+result;
            }catch(NumberFormatException e){
                this.menu.result = "N/A";
            }
        }
}
