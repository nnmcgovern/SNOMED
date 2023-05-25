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

public class SNOMED {
    public static void main(String[] args) throws FileNotFoundException {
        Concepts c = new Concepts("/Users/natalienicole/Downloads/concepts.txt");
        Relationships r = new Relationships("/Users/natalienicole/Downloads/relationships.txt");
        Descriptions d = new Descriptions("/Users/natalienicole/Downloads/descriptions.txt");
        Scanner input = new Scanner(System.in);
        
        System.out.print("Concept ID: ");
        String cID = input.next();
        String active = c.getActive(cID);
        
        if (active.equals("1")) {
            System.out.println("Fully specified name: " + d.getTerm(cID) + "\n");
            
            /* * * */
            
            List<String> parents = r.getParentIDs(cID);
            System.out.println("List of Parents");
            
            if (parents != null) {
                for (String s: parents)
                    System.out.println(d.getTerm(s));
            }
            
            System.out.println();
            
            /* * * */
            
            List<String> children = r.getChildIDs(cID);
            System.out.println("List of Children");
            
            if (children != null) {
                for (String s: children)
                    System.out.println(d.getTerm(s));
            }
            
            System.out.println();
            
            /* * * */
            
            Groups groups = r.getAttributeGroups(cID);
            System.out.println("List of Attributes");
            
            if (groups != null) {
                int g = 1;
                
                for (String s: groups.getGroupNumbers()) {
                    List<Attribute> attributes = groups.getGroup(s);
                    
                    System.out.println("Group " + g++);
                    
                    for (Attribute a: attributes)
                        System.out.println(d.getTerm(a.getTypeID()) + " -> " + d.getTerm(a.getAttributeID()));
                }
            }
        }
        
        else
            System.out.println("Concept is not active or does not exist.");
    }
}
