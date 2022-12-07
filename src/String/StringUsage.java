package String;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Scanner;

public class StringUsage {
    public static void operation() throws IOException {
        //Reading from file
        String data ="";
        //This method allows me to keep the initial text in several lines
        data = new String(Files.readAllBytes(Paths.get("input.txt")));
        /*try {
            File myObject = new File("input.txt");
            Scanner readerFromFile = new Scanner(myObject);
            while (readerFromFile.hasNextLine()) {
                data = data + readerFromFile.nextLine();
            }
            readerFromFile.close();
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }*/
        int vowels = 0;
        int consonats = 0;
        int numbers = 0;
        int words = 0;
        String str = data;

        String strUpper = str.toUpperCase();//Uppercase letters
        String strLower = str.toLowerCase();//Lower letters
        String strLength = String.valueOf(str.length());//Leght
        str = str.toLowerCase();
        for (int i = 0; i < str.length(); ++i) {
            char ch = str.charAt(i);
            //We check if there are vowels in our text a, â, ă, e, i, î, o, u
            if (ch == 'a' || ch == 'ă' || ch == 'â' || ch == 'e' || ch == 'i' || ch == 'î' || ch == 'o' || ch == 'u') {
                ++vowels;
            }
            // We check if they are included in the alphabet
            else if ((ch >= 'a' && ch <= 'z')) {
                ++consonats;
            //We check if there are numbers
            } else if (ch >= '0' && ch <= '9') {
                ++numbers;
            //We check if there are words
            } else if (ch == ' ') {
                ++words;
            }
        }
        //We check if they are long or short words
        String string = str;
        String word = "", small = "", large = "";
        String[] wordsSL = new String[100];
        int length = 0;
        string = string + " ";

        for (int i = 0; i < string.length(); i++) {
            if (string.charAt(i) != ' ') {
                word = word + string.charAt(i);
            } else {
                wordsSL[length] = word;
                length++;
                word = "";
            }
        }
        small = large = wordsSL[0];
        for (int k = 1; k < length; k++) {
            if (small.length() > wordsSL[k].length())
                small = wordsSL[k];
            if (large.length() < wordsSL[k].length())
                large = wordsSL[k];
        }
        String strWords = str;
        int count;
        String dublicat = "";

        strWords = strWords.toLowerCase();
        String newWorsd[] = strWords.split(" ");

        for (int i = 0; i < newWorsd.length; i++) {
            count = 1;
            for (int j = i + 1; j < newWorsd.length; j++) {
                if (newWorsd[i].equals(newWorsd[j])) {
                    count++;
                    newWorsd[j] = "0";
                }
            }
            if (count > 1 && newWorsd[i] != "0")
                dublicat = dublicat + ", " + newWorsd[i];
        }

        System.out.println("Initial text\n" + str + "\n");
        System.out.println("Upper text: \n" + strUpper + "\n");
        System.out.println("Lower text: \n" + strLower + "\n");
        System.out.println("The length of the text: " + strLength + " characters");
        System.out.println("Number of vowels: " + vowels);
        System.out.println("Number of consonats: " + consonats);
        System.out.println("Numbers: " + numbers);
        System.out.println("Number of words: " + words);
        System.out.println("Largest word: " + large);
        System.out.println("Smallest word: " + small);
        System.out.println("Duplicated words: " + dublicat);

        //Writing to file
            FileWriter writeToFile = new FileWriter("output.txt");
            writeToFile.write("\nInitial text \n");
            writeToFile.write("\n" + str + "\n");
            writeToFile.write("\nUpper text\n" + strUpper + "\n");
            writeToFile.write("\nLower text\n"+ strLower + "\n");
            writeToFile.write("\nThe length of the text: " + strLength + " characters" + "\n");
            writeToFile.write("\nNumber of vowels: " + vowels + "\n");
            writeToFile.write("Number of consonats: " + consonats + "\n");
            writeToFile.write("Numbers: " + numbers + "\n");
            writeToFile.write("Number of words: " + words + "\n");
            writeToFile.write("Largest word: " + large + "\n");
            writeToFile.write("Smallest word: " + small + "\n");
            writeToFile.write("Duplicated words: " + dublicat + "\n");
            writeToFile.close();
            System.out.println("\nAll operations completed successfully");
    }
}


