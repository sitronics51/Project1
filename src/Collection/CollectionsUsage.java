package Collection;

import java.io.*;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;


public class CollectionsUsage {
    public static void main(String[] args) throws IOException, ParseException {
        //Read from file
        BufferedReader bufReader = new BufferedReader(new FileReader("employee-input.txt"));
        ArrayList<String> listOfLines = new ArrayList<>();

        String line = bufReader.readLine();
        while (line != null) {
            listOfLines.add(line);
            line = bufReader.readLine();
        }
        //Subtracting the first name from the Array
        for (int i = 0; i < listOfLines.size(); i++) {
            String firsName = listOfLines.get(i).substring(0, listOfLines.get(i).indexOf(" "));
            System.out.println(firsName);

            //this code sequence is predestined for HasSet ================
            System.out.println("Original ArrayList is : " + listOfLines);
            HashSet<String> hset = new HashSet<String>(listOfLines);
            System.out.println("ArrayList Unique Values is : "+ hset);
        }
        //this code sequence is predestined for contains() ================
        ArrayList<String>distictListOfLines = new ArrayList<>();
        for (int j = 0; j < listOfLines.size(); j++){
            String fullName = listOfLines.get(j).substring(0, listOfLines.get(j).lastIndexOf(" "));
            if (!distictListOfLines.contains(fullName))
            {
                distictListOfLines.add(fullName);
            }
        }

            //Write into file
            BufferedWriter bf = null;
            try {
                // create new BufferedWriter for the output file
                bf = new BufferedWriter(new FileWriter("employee-final.txt"));

                for (int k = 0; k < listOfLines.size(); k++){
                    String dateOfBirth = listOfLines.get(k).substring(listOfLines.get(k).lastIndexOf(" ") +1, listOfLines.get(k).length());
                    Date dob = new SimpleDateFormat("dd/MM/yyyy").parse(dateOfBirth);

                    //We create a new BufferedWriter for the output file
                    long currentTime = System.currentTimeMillis();
                    Calendar now = Calendar.getInstance();
                    now.setTimeInMillis(currentTime);

                    Calendar cal = Calendar.getInstance();
                    cal.setTime(dob);
                    int age = now.get(Calendar.YEAR) - cal.get(Calendar.YEAR);
                    bf.write(listOfLines.get(k) + " | " + age);
                    bf.newLine();
                }
                bf.flush();
            }
            catch (IOException e) {
                e.printStackTrace();
                bf.close();
            }

        System.out.println("\nThis is distinct list: ");
        distictListOfLines.forEach(System.out::println);

        bufReader.close();
        System.out.println("Content of ArrayLiList:");
        //System.out.println(listOfLines);

        System.out.println("\nBefore Sorting:\n"+ listOfLines);
         //Sorting ArrayList in ascending Order
        Collections.sort(listOfLines);
        // printing the sorted ArrayList
        System.out.println("\nAfter Sorting:\n"+ listOfLines);

    }
}
