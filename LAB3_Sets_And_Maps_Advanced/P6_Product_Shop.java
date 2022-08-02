package ADVANCED.LAB3_Sets_And_Maps_Advanced;

import java.util.*;

public class P6_Product_Shop {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        Map<String, Map<String,Double>> shopList = new TreeMap<>();


        String input = scan.nextLine();
        while (!input.equals("Revision")){
            String[] data = input.split(", ");
            String shop = data[0];
            String product = data[1];
            double price = Double.parseDouble(data[2]);

            if (!shopList.containsKey(shop)){
                shopList.put(shop,new LinkedHashMap<>());
            }
            shopList.get(shop).put(product,price);

            input = scan.nextLine();
        }


        for (Map.Entry<String,Map<String,Double>> entry : shopList.entrySet()) {
            System.out.printf("%s->\n",entry.getKey());
            for (Map.Entry<String,Double> entry2 : entry.getValue().entrySet()) {
                System.out.printf("Product: %s, Price: %.1f\n",entry2.getKey(),entry2.getValue());
            }

        }
    }
}
