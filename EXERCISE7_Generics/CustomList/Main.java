package ADVANCED.EXERCISE7_Generics.CustomList;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        CustomList<String> list = new CustomList<String>();

        String commands = scanner.nextLine();
        while (!commands.equals("END")) {
            String[] command = commands.split(" ");
            String commandData = command[0];

            switch (commandData){
                case "Add":
                    String elementToAdd = command[1];
                    list.add(elementToAdd);
                    break;
                case "Remove":
                    int indexToRemove = Integer.parseInt(command[1]);
                    list.remove(indexToRemove);
                    break;
                case "Contains":
                    String searchedElement = command[1];
                    System.out.println(list.contains(searchedElement));
                    break;
                case "Swap":
                    int firstIndex = Integer.parseInt(command[1]);
                    int secondIndex = Integer.parseInt(command[2]);
                    list.swap(firstIndex, secondIndex);
                    break;
                case "Greater":
                    String elementForCheck = command[1];
                    System.out.println(list.countElementsGreaterThan(elementForCheck));
                    break;
                case "Max":
                    System.out.println(list.getMax());
                    break;
                case "Min":
                    System.out.println(list.getMin());
                    break;
                case "Print":
                    list.print();
                    break;
                case "Sort":
                    list.sort();
                    break;
            }
            commands = scanner.nextLine();
        }
    }
}

