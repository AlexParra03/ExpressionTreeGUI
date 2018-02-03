
package com.gui.expression_tree;

import java.util.Arrays;


public class ExpressionTree {
    
    public Node root;
    public boolean isValid = false;

    ExpressionTree(){
        this.root = new Node();
    }
    
    public void read(String input){
        isValid = true;
        int[] precedence = new int[input.length()];
        int currentPrecedence = 1;
        for(int i=input.length()-1; i>= 0; i--){
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
        
        recursiveAdd(input, precedence, this.root);
    }

    private void recursiveAdd(String input, int[] precedence, Node node){
        int iRoot = 0;
        for(int i=0; i<precedence.length; i++){
            if(precedence[iRoot] < precedence[i]){
                iRoot = i;
            }
        }
        
        int[] leftPrecedence = Arrays.copyOfRange(precedence, 0, iRoot);
        String left = input.substring(0, iRoot);
        boolean leftLeaf = true;
        for(int x : leftPrecedence){
            if(x > 0){
                leftLeaf = false;
            }
        }
        
        int[] rightPrecedence = Arrays.copyOfRange(precedence, iRoot+1, precedence.length);
        String right = input.substring(iRoot+1, input.length());
        boolean rightLeaf = true;
        for(int x : rightPrecedence){
            if(x > 0){
                rightLeaf = false;
            }
        }
        
        
        node.data = ""+input.charAt(iRoot);
        if(leftLeaf){
            node.left = new Node(left);
        }else{
            node.left = new Node();
            recursiveAdd(left, leftPrecedence, node.left);
        }
        
        if(rightLeaf){
            node.right = new Node(right);
        }else{
            node.right = new Node();
            recursiveAdd(right, rightPrecedence, node.right);
        }
          
    }
    
    public double calculate(){
        return recursiveCalculate(this.root);
    }
    
    private double recursiveCalculate(Node node){
        if(!isOperation(node)){
            if(node.data.charAt(0) == '('){
                return Double.parseDouble( node.data.substring(1, node.data.length()-1) );
            }else{
                return Double.parseDouble(node.data);
            }
        }else{
            char c = node.data.charAt(0);
            if(c == '^'){
                return Math.pow(recursiveCalculate(node.left), recursiveCalculate(node.right));
            }else if(c == '*'){
                return recursiveCalculate(node.left) * recursiveCalculate(node.right);
            }else if(c == '/'){
                return recursiveCalculate(node.left) / recursiveCalculate(node.right);
            }else if(c == '+'){
                return recursiveCalculate(node.left) + recursiveCalculate(node.right);
            }else if(c == '-'){
                return recursiveCalculate(node.left) - recursiveCalculate(node.right);
            }else{
                System.out.println("Operation not recognized");
                isValid = false;
                return 0;
            }
        }
    }
    
    
    public void inOrder(){
        System.out.print("In-Order traversal: ");
        inOrder(this.root);
        System.out.println();
    }
    
    private void inOrder(Node node){
        if(node == null){
            return;
        }
        
        if(isOperation(node)){
            System.out.print('(');
        }
        inOrder(node.left);
        System.out.print(node.data);
        inOrder(node.right);
        if(isOperation(node)){
            System.out.print(')');
        }
    }
    
    private boolean isOperation(Node node){
        if(node == null){
            return false;
        }
        
        char c = node.data.charAt(0);
        return c == '^' || c == '*' || c == '/' || c == '+' || c == '-';
    }
    
    

    
}





