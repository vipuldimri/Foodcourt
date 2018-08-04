/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package foodcourt;

import java.util.Date;

/**
 *
 * @author dimri
 */
public class FoodCourtModel {
    private int Id;
    private  String Name;
    private String Contact;
    private String Address;
    private String Owner;
    private double  GGST;
    private double CGST;
    private Date   SubEnd;
    private String Email;

    public FoodCourtModel(int Id, String Name, String Contact, String Address, String Owner, double GGST, double CGST, Date SubEnd, String Email) {
        this.Id = Id;
        this.Name = Name;
        this.Contact = Contact;
        this.Address = Address;
        this.Owner = Owner;
        this.GGST = GGST;
        this.CGST = CGST;
        this.SubEnd = SubEnd;
        this.Email = Email;
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

    public String getContact() {
        return Contact;
    }

    public void setContact(String Contact) {
        this.Contact = Contact;
    }

    public String getAddress() {
        return Address;
    }

    public void setAddress(String Address) {
        this.Address = Address;
    }

    public String getOwner() {
        return Owner;
    }

    public void setOwner(String Owner) {
        this.Owner = Owner;
    }

    public double getGGST() {
        return GGST;
    }

    public void setGGST(double GGST) {
        this.GGST = GGST;
    }

    public double getCGST() {
        return CGST;
    }

    public void setCGST(double CGST) {
        this.CGST = CGST;
    }

    public Date getSubEnd() {
        return SubEnd;
    }

    public void setSubEnd(Date SubEnd) {
        this.SubEnd = SubEnd;
    }

    public String getEmail() {
        return Email;
    }

    public void setEmail(String Email) {
        this.Email = Email;
    }
    
    
}
