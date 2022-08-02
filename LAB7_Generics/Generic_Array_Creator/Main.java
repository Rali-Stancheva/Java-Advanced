package ADVANCED.LAB7_Generics.Generic_Array_Creator;

public class Main {
    public static void main(String[] args) {
        String[] stringArray = ArrayCreator.create(10,"Rali");
        Integer[] integerArray = ArrayCreator.create(Integer.class,10,0);
    }
}
