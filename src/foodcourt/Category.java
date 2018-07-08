/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package foodcourt;

import java.awt.Image;

/**
 *
 * @author u20o90
 */
public class Category 
{
    
   private int ID;
   private String Name;
   private Image image;

    public int getID() {
        return ID;
    }

    public void setID(int ID) {
        this.ID = ID;
    }

    public String getName() {
        return Name;
    }

    public void setName(String Name) {
        this.Name = Name;
    }

    public Image getImage() {
        return image;
    }

    public void setImage(Image image) {
        this.image = image;
    }

    public Category(int ID, String Name, Image image) {
        this.ID = ID;
        this.Name = Name;
        this.image = image;
    }
    
}
