package Collection;

import java.io.*;
import java.nio.file.Paths;
import java.util.*;


public class Product {
    public static void main(String[] args) throws IOException {
        HashMap<String, String> listOfProduct = new HashMap<>();
        String line;
        BufferedReader reader = new BufferedReader(new FileReader(Paths.get("product-input.txt").toFile()));
        while ((line = reader.readLine()) != null)
        {
            String[] parts = line.split("[ ]");
            if (parts.length >= 2)
            {
                String key = parts[0];
                String value = parts[1];
                listOfProduct.put(key, value);

            } else {
                System.out.println("ignoring line: " + line);
            }
        }
        listOfProduct.put(String.valueOf(4), "Booza");
        listOfProduct.put(String.valueOf(5), "Borhani");
        listOfProduct.put(String.valueOf(6), "Butter");
        listOfProduct.put(String.valueOf(7), "Camel milk");
        listOfProduct.put(String.valueOf(8), "Chaas");

        for (String key : listOfProduct.keySet())
        {
            System.out.println(key + " | " + listOfProduct.get(key));
        }
        reader.close();
        System.out.println("SORT =============");
        listOfProduct.keySet().forEach(key -> System.out.println(key + " | " + listOfProduct.get(key)));

        listOfProduct.put(String.valueOf(8), "Milk");
        System.out.println("Update ===========");
        listOfProduct.keySet().forEach(key -> System.out.println(key + " | " + listOfProduct.get(key)));

        //Wirting from file
        BufferedWriter bf = null;
        try {
            // create new BufferedWriter for the output file
            bf = new BufferedWriter(new FileWriter("product-output.txt"));
            // iterate map entries
            for (Map.Entry<String, String> entry : listOfProduct.entrySet()) {
                // put key and value separated by a colon
                bf.write(entry.getKey() + " | " + entry.getValue());
                // new line
                bf.newLine();
            }
            bf.flush();
        }
        catch (IOException e) {
            e.printStackTrace();
            bf.close();
        }
    }
}
