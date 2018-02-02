
package com.gui.expression_tree;


public class ExpressionTree {
    
    
    
    
    class Node {
        Node left;
        String data;
        Node right;
        
        private Node(String data){
            this.left = null;
            this.right = null;
            this.data = data;
        }
        
    }
    
    
    public void read(String input){
        
        int[] precedence = new int[input.length()];
        int currentPrecedence = 1;
        for(int i=input.length()-1; i>= 0; i++){
            if(input.charAt(i) == '^'){
                precedence[i] = currentPrecedence++;
            }
        }
        
        for(int i=0; i<precedence.length; i++){
            if(input.charAt(i) == '*' || input.charAt(i) == '/'){
                precedence[i] = currentPrecedence++;
            }
        }
        
        for(int i=0; i<precedence.length; i++){
            if((input.charAt(i) == '-' || input.charAt(i) == '+') &&(i>0 && input.charAt(i-1) != '(')){
                precedence[i] = currentPrecedence;
            }
        }
    }

    private void recursiveAdd(String input, int[] precedence, Node node){
        int iRoot = 0;
        for(int i=0; i<precedence.length; i++){
            if(precedence[iRoot] < precedence[i]){
                iRoot = i;
            }
        }
        
        
    }
    
}



