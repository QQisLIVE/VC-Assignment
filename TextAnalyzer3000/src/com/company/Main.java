package com.company;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;

public class Main {

    public static void main(String[] args) throws FileNotFoundException {
        //Finding the file and grabbing it
	File file = new File("c:/users/mike1/desktop/poem.txt");
	//Reading the file
	Scanner scan = new Scanner(file);
        Map<String, Integer> map = new HashMap<>();
        //While loop to continue scanning next line
        while(scan.hasNext()) {
            String val = scan.next();

            if(!map.containsKey(val)) {
                map.put(val, 1); //If the word isn't counted yet, it'll place its count at 1

            }
            else {
                int count = map.get(val); // Find the count of the word
                //map.remove(val); //removes the entry from the map
                map.put(val, count+1); //gets the current count and increases it by 1
            }

        }
        Set<Map.Entry<String, Integer>> set =  map.entrySet(); // retrieves the map contents
        List<Map.Entry<String, Integer>> sortedList = new ArrayList<>(set); //This is creating an array
        //Comparing the function for sorting
        sortedList.sort((a, b) -> {
            return (b.getValue()).compareTo(a.getValue()); //descending
            //return (a.getValue()).compareTo(b.getValue()); //ascending
        });
        for(Map.Entry<String, Integer> i:sortedList){
            System.out.println("Word: " + "'"+ i.getKey() + "'" + " - how many times used: " +i.getValue());
        }

    }
}
