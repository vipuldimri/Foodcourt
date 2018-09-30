/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package foodcourt;

/**
 *
 * @author u20o90
 */
public class Menu_Items 
{
   private int Id ;
   private String Name;
   private String Price;
   private String Category;
   private String QTY;
    public Menu_Items(int Id, String Name, String Price, String Category,String QTY) {
        this.Id = Id;
        this.Name = Name;
        this.Price = Price;
        this.Category = Category;
        this.QTY = QTY;
    }

    public String getQTY() {
        return QTY;
    }

    public void setQTY(String QTY) {
        this.QTY = QTY;
    }

    public int getId() {
        return Id;
    }

    public void setId(int Id) {
        this.Id = Id;
    }

    public String getName() {
        return Name;
    }

    public void setName(String Name) {
        this.Name = Name;
    }

    public String getPrice() {
        return Price;
    }

    public void setPrice(String Price) {
        this.Price = Price;
    }

    public String getCategory() {
        return Category;
    }

    public void setCategory(String Category) {
        this.Category = Category;
    }
   
    
}
