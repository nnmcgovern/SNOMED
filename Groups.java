/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author natalienicole
 */
import java.util.*;

public class Groups {
    private Map<String, List<Attribute>> groups;
    //          number
    
    public Groups() {
        groups = new HashMap<>();
    }
    
    public void addAttribute(String group, Attribute a) {
        List<Attribute> list;
        
        if (groups.containsKey(group))
            list = groups.get(group);
        
        else
            list = new ArrayList<>();
        
        list.add(a);
        groups.put(group, list);
    }
    
    public Set<String> getGroupNumbers() {
        return groups.keySet();
    }
    
    public List<Attribute> getGroup(String group) {
        if (groups.containsKey(group))
            return groups.get(group);
        
        return null;
    }
}
