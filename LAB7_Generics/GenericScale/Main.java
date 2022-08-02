package ADVANCED.LAB7_Generics.GenericScale;

public class Main {
    public static void main(String[] args) {
        Scale<String> scaleString = new Scale<>("a", "c");
        System.out.println(scaleString.getHeavier());

        Scale<Integer> scaleInteger = new Scale<>(1,12);
        System.out.println(scaleInteger.getHeavier());
    }
}
