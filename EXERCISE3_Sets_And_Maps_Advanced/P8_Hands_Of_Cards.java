package ADVANCED.EXERCISE3_Sets_And_Maps_Advanced;

import java.util.*;

public class P8_Hands_Of_Cards {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        Map<String, Set<String>> map = new LinkedHashMap<>();

        String input = scan.nextLine();
        while (!input.equals("JOKER")) {
            String[] data = input.split(": ");  //Peter: 2C, 4H, 9H, AS, QS
            String person = data[0]; //Peter:
            String cards = input.split(":\\s+")[1]; //"2C, 4H, 9H, AS, QS"
            String[] cardsArr = cards.split(", ");// "2C", "4H", "9H", "AS", "QS"

            Set<String> cardSet = new HashSet<>(); //картите на играча
            cardSet.addAll(Arrays.asList(cardsArr));


            if (!map.containsKey(person)){
                map.put(person,cardSet);
            }else{
                Set<String> currCards = map.get(person);
                currCards.addAll(cardSet);
                map.put(person,currCards);
            }
            input = scan.nextLine();
        }
        map.entrySet().forEach(entry ->{
                String name = entry.getKey();
                Set<String> cards = entry.getValue();
                int points = getCardsPoint(cards);
            System.out.printf("%s: %d\n",name,points);
        });

    }

    private static int getCardsPoint(Set<String> cards) {
        Map<Character, Integer> map = getSymbolsValues();
        int sumPoints = 0;

        for (String card : cards) {
            int points = 0;
            if (card.startsWith("10")) {
                //10C
                char type = card.charAt(2);
                points = 10 * map.get(type);
            } else {
                char power = card.charAt(0);  //4
                char type = card.charAt(1); //H
                points = map.get(power) * map.get(type);
            }
            sumPoints += points;
        }
        return sumPoints;
    }

    private static Map<Character, Integer> getSymbolsValues() {
        Map<Character, Integer> mapValues = new HashMap<>();
        mapValues.put('2', 2);
        mapValues.put('3', 3);
        mapValues.put('4', 4);
        mapValues.put('5', 5);
        mapValues.put('6', 6);
        mapValues.put('7', 7);
        mapValues.put('8', 8);
        mapValues.put('9', 9);
        mapValues.put('J', 11);
        mapValues.put('Q', 12);
        mapValues.put('K', 13);
        mapValues.put('A', 14);
        mapValues.put('S', 4);
        mapValues.put('H', 3);
        mapValues.put('D', 2);
        mapValues.put('C', 1);
        return mapValues;
    }
}
