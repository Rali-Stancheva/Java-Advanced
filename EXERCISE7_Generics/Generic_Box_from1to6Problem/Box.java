package ADVANCED.EXERCISE7_Generics.Generic_Box_from1to6Problem;

import java.util.ArrayList;
import java.util.List;

public class Box<T extends  Comparable<T>> {
    private List<T> list;


    public Box() {
        this.list = new ArrayList<>();
    }

    public void add(T element) {
        this.list.add(element);
    }

    @Override
    public String toString() {
        StringBuilder builder = new StringBuilder();
        for (T element : list) {
            builder.append(String.format("%s: %s\n", element.getClass().getName(), element));
        }
        return builder.toString();
    }


    //swap
    public void swap(int firstIndex, int secondIndex){
        T firstIndexElement = this.list.get(firstIndex);
        T secondIndexElement = this.list.get(secondIndex);

        this.list.set(firstIndex,secondIndexElement);
        this.list.set(secondIndex,firstIndexElement);
    }

    //count
    public int countGreaterThat(T element){
        int count = 0;
        for (T elementInList : list) {
            if (elementInList.compareTo(element) > 0){
                count++;
            }
        }
        return count;
    }
}
