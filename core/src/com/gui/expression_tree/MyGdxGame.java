package com.gui.expression_tree;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

public class MyGdxGame extends ApplicationAdapter {
	SpriteBatch batch;
	Texture img;
        UserInterface menu;
        ExpressionTree tree;
	
	@Override
	public void create () {
		batch = new SpriteBatch();
		img = new Texture("badlogic.jpg");
                menu = new UserInterface();
                
                Gdx.graphics.setWindowedMode(1100, 900);
                //Gdx.graphics.setResizable(false);
                tree = new ExpressionTree();
                
                tree.read("3 * 5 / 4 + 5");
                tree.inOrder();
                //System.out.println(tree.calculate());
	}

	@Override
	public void render () {
		Gdx.gl.glClearColor(1, 0, 0, 1);
		Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
                handleInput();
		batch.begin();
		//batch.draw(img, 0, 0);
                menu.render(batch);
                menu.renderTree(tree, batch);
		batch.end();
	}
	
	@Override
	public void dispose () {
		batch.dispose();
		img.dispose();
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
               }else if(Gdx.input.isKeyJustPressed( 8 ) ){
                   input.addCharacter(')');
               }
           }else{

                if(Gdx.input.isKeyJustPressed( 29 )){
                    input.addCharacter('A');
               }else if(Gdx.input.isKeyJustPressed( 30 )){
                    input.addCharacter('B');
               }else if(Gdx.input.isKeyJustPressed( 31 )){
                    input.addCharacter('C');
               }else if(Gdx.input.isKeyJustPressed( 32 )){
                   input.addCharacter('D');
               }else if(Gdx.input.isKeyJustPressed( 33 )){
                   input.addCharacter('E');
               }else if(Gdx.input.isKeyJustPressed( 34 )){
                   input.addCharacter('F');
               }else if(Gdx.input.isKeyJustPressed( 35 )){
                   input.addCharacter('G');
               }else if(Gdx.input.isKeyJustPressed( 36 )){
                   input.addCharacter('H');
               }else if(Gdx.input.isKeyJustPressed( 37 )){
                   input.addCharacter('I');
               }else if(Gdx.input.isKeyJustPressed( 38 )){
                   input.addCharacter('J');
               }else if(Gdx.input.isKeyJustPressed( 39 )){
                   input.addCharacter('K');
               }else if(Gdx.input.isKeyJustPressed( 40 )){
                   input.addCharacter('L');
               }else if(Gdx.input.isKeyJustPressed( 41 )){
                   input.addCharacter('M');
               }else if(Gdx.input.isKeyJustPressed( 42 )){
                   input.addCharacter('N');
               }else if(Gdx.input.isKeyJustPressed( 43 )){
                   input.addCharacter('O');
               }else if(Gdx.input.isKeyJustPressed( 44 )){
                   input.addCharacter('P');
               }else if(Gdx.input.isKeyJustPressed( 45 )){
                   input.addCharacter('Q');
               }else if(Gdx.input.isKeyJustPressed( 46 )){
                   input.addCharacter('R');
               }else if(Gdx.input.isKeyJustPressed( 47 )){
                   input.addCharacter('S');
               }else if(Gdx.input.isKeyJustPressed( 48 )){
                   input.addCharacter('T');
               }else if(Gdx.input.isKeyJustPressed( 49 )){
                   input.addCharacter('U');
               }else if(Gdx.input.isKeyJustPressed( 50 )){
                   input.addCharacter('V');
               }else if(Gdx.input.isKeyJustPressed( 51 )){
                   input.addCharacter('W');
               }else if(Gdx.input.isKeyJustPressed( 52 )){
                   input.addCharacter('X');
               }else if(Gdx.input.isKeyJustPressed( 53 )){
                   input.addCharacter('Y');
               }else if(Gdx.input.isKeyJustPressed( 54 )){
                   input.addCharacter('Z');
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
               }
            }

        }
}
