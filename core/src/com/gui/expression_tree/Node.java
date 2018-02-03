/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.gui.expression_tree;

/**
 *
 * @author alexu
 */
public class Node {
    Node left;
    String data;
    Node right;

    public Node(String data){
        this.left = null;
        this.right = null;
        this.data = data;
    }

    public Node(){
        this.left = null;
        this.right = null;
        this.data = null; 
    }

}

