/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author natalienicole
 */
public class Attribute {
    private String typeID;
    private String attributeID;
    
    public Attribute(String typeID, String attributeID) {
        this.typeID = typeID;
        this.attributeID = attributeID;
    }
    
    public String getTypeID() {
        return typeID;
    }
    
    public String getAttributeID() {
        return attributeID;
    }
}
