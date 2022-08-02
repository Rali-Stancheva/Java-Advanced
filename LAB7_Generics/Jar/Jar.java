package ADVANCED.LAB7_Generics.Jar;

import java.util.ArrayDeque;

public class Jar<E> {
    private ArrayDeque<E> stack;

    public Jar(){
        this.stack = new ArrayDeque<>();
    }

    public void add(E element){
        this.stack.push(element);
    }

    public E remove(){
        return this.stack.pop();
    }
}
