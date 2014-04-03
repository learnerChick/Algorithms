package Stacks;

import java.util.Arrays;

/**
 * Created by Dhana on 4/2/2014.
 */
public class ArrayStack {
    private char[] stack;
    private int total;

    public ArrayStack(int size){
        stack = new char[size];
        total = 0;
    }

    public void push(char item){
        stack[total] = item;
        total++;
    }

    public boolean isEmpty(){
        return total == 0;
    }

    public char pop(){
        char temp = stack[total-1];
        total--;
        return temp;
    }

    public char peek(){
        return stack[total-1];
    }

    public static void main(String[] args){
        ArrayStack stack = new ArrayStack('a');
        stack.push('b');
        stack.push('c');
        stack.push('d');
        stack.push('e');

        System.out.println(stack.pop());
        System.out.println(stack.pop());
    }
}
