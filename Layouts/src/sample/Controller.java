package sample;


import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.text.Text;

import java.io.IOException;
import java.net.URL;
import java.util.*;

public class Controller {
    @FXML
    private TextField nameField;
    @FXML
    private Button initiateButton;
    @FXML
    private Button endButton;


    @FXML
    public void onButtonClicked(ActionEvent e) throws IOException {

        if(e.getSource().equals(initiateButton)) {
            System.out.println("TestAnalyzer3000 Initiated");

            URL url = new URL("https://www.gutenberg.org/files/1065/1065-h/1065-h.htm");
            //Reading the file
            Scanner scan = new Scanner(url.openStream());
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
                if(i.getValue() > 30) {
                    System.out.println("Word: " + "'" + i.getKey() + "'" + " - how many times used: " + i.getValue());
                } else {
                    return;
                }
            }
        } else if(e.getSource().equals(endButton)){
            System.out.println("Ending program \n Thank you for choosing TextAnalyzer3000");
            Platform.exit();
        }








    }
}
