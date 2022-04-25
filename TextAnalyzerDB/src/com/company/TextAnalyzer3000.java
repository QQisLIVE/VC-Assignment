package com.company;

import org.w3c.dom.Text;

import java.io.IOException;
import java.net.URL;
import java.util.*;
/** *@author Michael Howell */
public class TextAnalyzer3000 {
    /** *This is TextAnalyzer3000 a program for calculating word occurrences */
    public static void TextAnalyzer() throws IOException{
        /**
         * @code execution
         * @throws IOException
         */

        URL url = new URL("https://www.gutenberg.org/files/1065/1065-h/1065-h.htm");
        Scanner scan = new Scanner(url.openStream());
        Map<String, Integer> map = new HashMap<>();


        while (scan.hasNext()) {
            String val = scan.next();


            if (!map.containsKey(val)) {
                map.put(val, 1); //If the word isn't counted yet, it'll place its count at 1

            } else {
                int count = map.get(val); // Find the count of the word
                //map.remove(val); //removes the entry from the map
                map.put(val, count + 1); //gets the current count and increases it by 1
            }
        }

        Set<Map.Entry<String, Integer>> set = map.entrySet(); // retrieves the map contents
        List<Map.Entry<String, Integer>> sortedList = new ArrayList<>(set); //This is creating an array
        //Comparing the function for sorting
        sortedList.sort((a, b) -> {
            return (b.getValue()).compareTo(a.getValue()); //descending
            //return (a.getValue()).compareTo(b.getValue()); //ascending

        });
        for (Map.Entry<String, Integer> i : sortedList) {
            if (i.getValue() > 30) {
//                System.out.println(sortedList);
//                System.out.println("Word: " + "'" + i.getKey() + "'" + " - how many times used: " + i.getValue());
            } else {
                return;
            }
        }
    }

    public static void main(String[] args) throws IOException {
        TextAnalyzer();
    }
}
