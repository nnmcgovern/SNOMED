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

public class Concepts {
    private Map<String, String> map = new HashMap<>();
    //          id,     active
    
    public Concepts(String file) throws FileNotFoundException {
        Scanner input = new Scanner(new File(file));
        
        while (input.hasNext()) {
            String[] columns = input.nextLine().split("\t");
            // id [0], active [2]
            
            map.put(columns[0], columns[2]);
        }
    }
    
    public String getActive(String id) {
        if (map.containsKey(id))
            return map.get(id);
        
        return "0";
    }
}
