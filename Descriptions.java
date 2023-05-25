/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author natalienicole
 */
import java.io.*;
import java.util.*;

public class Descriptions {
    private Map<String, String> map = new HashMap<>();
    //          id,     term
    
    public Descriptions(String file) throws FileNotFoundException {
        Scanner input = new Scanner(new File(file));
        
        while (input.hasNext()) {
            String[] columns = input.nextLine().split("\t");
            // active [2], concept id [4], type id [6], term [7]
            
            if (columns[2].equals("1") && columns[6].equals("900000000000003001")) {
                map.put(columns[4], columns[7]);
            }
        }
    }
    
    public String getTerm(String id) {
        if (map.containsKey(id))
            return map.get(id);
        
        return null;
    }
}
