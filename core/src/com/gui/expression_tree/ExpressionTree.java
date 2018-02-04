
package com.gui.expression_tree;

import java.util.Arrays;
import java.util.Stack;


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
    
    public void readT(String input){
        int[] precedence = new int[input.length()];
        int currentPrecedence = 1;
        recursiveRead(precedence, input, currentPrecedence, 0, input.length()-1);
        int i=0;
        while(i<input.length()){
            if(i != input.length()-1 && input.charAt(i) == '(' && input.charAt(i+1) != '+' && input.charAt(i+1) != '-'){
                precedence = cutTwoIndex(precedence, i, findClosingIndex(input, i));
                input = cutTwoIndex(input, i, findClosingIndex(input, i) );
                i = -1;
            }
            i++;
        }
        recursiveAdd(input, precedence, this.root);
    }
    
    private void recursiveRead(int[] precedence, String input, int currentPrecedence, int start, int end){
        for(int i=start; i<=end; i++){
            if(input.charAt(i) == '(' && i != input.length()-1 && input.charAt(i+1) != '+' && input.charAt(i+1) != '-'){
                recursiveRead(precedence, input, currentPrecedence, i+1, findClosingIndex(input, i)-1);
            }
        }
        
        for(int i=end; i>= start; i--){
            if(input.charAt(i) == '^'){
                if(precedence[i] == 0){
                    precedence[i] = currentPrecedence++;
                }
            }
        }
        
        for(int i=start; i<=end; i++){
            if(input.charAt(i) == '*' || input.charAt(i) == '/'){
                if(precedence[i] == 0){
                    precedence[i] = currentPrecedence++;
                }
            }
        }
        
        for(int i=start; i<=end; i++){
            if((input.charAt(i) == '-' || input.charAt(i) == '+') &&(i>0 && input.charAt(i-1) != '(')){
                if(precedence[i] == 0){
                    precedence[i] = currentPrecedence++;
                }
            }
        }
        
       
        
    }
    
    private int findClosingIndex(String input, int index){
        if(input.charAt(index) != '('){
            return -1;
        }
        Stack<Character> stack = new Stack<Character>();
        int wantedSize = 0;
        boolean openingReached = false;
        for(int i=0; i<input.length(); i++){
            char c = input.charAt(i);
            if(c == '('){
                stack.push(c);
            }
            if(i == index){
                wantedSize = stack.size()-1;
                openingReached = true;
            }
            
            if(c == ')'){
                stack.pop();
            }
            
            if(i > index && stack.size() == wantedSize){
                return i;
            }
        }
        
        //Unreacheable if valid
        return -1;
       
    }
    
    private int[] cutTwoIndex(int[] A, int i, int j){
        int[] output = new int[A.length-2];
        int currentIndex = 0;
        for(int i2=0; i2<A.length; i2++ ){
            if(i2 != i && i2 != j){
                output[currentIndex++] = A[i2];
            }
        }
        return output;
    }
    
    private String cutTwoIndex(String str, int i, int j){
        String output = "";
        for(int i2=0; i2<str.length(); i2++){
            if(i2 != i && i2 != j){
                output += str.charAt(i2);
            }
        }
        return output;
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





