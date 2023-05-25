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

public class Relationships {
    private Map<String, List<String>> parents = new HashMap<>();
    //          source, destination(s)
    
    private Map<String, List<String>> children = new HashMap<>();
    //          dest.,  source(s)
    
    private Map<String, Groups> attributes = new HashMap<>();
    //          source
    
    public Relationships(String file) throws FileNotFoundException {
        Scanner input = new Scanner(new File(file));
        
        while (input.hasNext()) {
            String[] columns = input.nextLine().split("\t");
            // active [2], source [4], destination [5], group [6], type [7]
            
            if (columns[2].equals("1")) {
                
                /* hierarchical relationships */
                
                if (columns[7].equals("116680003")) {
                    List<String> list;
                
                    /* parents */
                
                    if (parents.containsKey(columns[4]))
                        list = parents.get(columns[4]);
                
                    else
                        list = new ArrayList<>();
                
                    list.add(columns[5]);
                    parents.put(columns[4], list);
                
                    /* children */
                
                    if (children.containsKey(columns[5]))
                        list = children.get(columns[5]);
                
                    else
                        list = new ArrayList<>();
                
                    list.add(columns[4]);
                    children.put(columns[5], list);
                }
                
                /* attribute relationships */
                
                else {
                    // addAtribute(String [group], new Attribute([type], [destination]))
                    if (attributes.containsKey(columns[4]))
                        attributes.get(columns[4]).addAttribute(columns[6], new Attribute(columns[7], columns[5]));
                    
                    else {
                        Groups g = new Groups();
                        g.addAttribute(columns[6], new Attribute(columns[7], columns[5]));
                        attributes.put(columns[4], g);
                    }
                }
            }
        }
    }
    
    public List<String> getParentIDs(String sourceID) {
        if (parents.containsKey(sourceID))
            return parents.get(sourceID);
        
        return null;
    }
    
    public List<String> getChildIDs(String destinationID) {
        if (children.containsKey(destinationID))
            return children.get(destinationID);
        
        return null;
    }
    
    public Groups getAttributeGroups(String sourceID) {
        if (attributes.containsKey(sourceID))
            return attributes.get(sourceID);
        
        return null;
    }
}
