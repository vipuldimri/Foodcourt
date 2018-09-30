/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package foodcourt;

/**
 *
 * @author dimri
 */
public class UpdateInfo {

    public UpdateInfo(){}
    
    public UpdateInfo(String SGST, String CGST, String Email, String Time) {
        this.SGST = SGST;
        this.CGST = CGST;
        this.Email = Email;
        this.Time = Time;
    }
    public String SGST;
    public String CGST;
    public String Email;
    public String Time;
    public String ColdDrink;
    public String Water;
    
    public String getSGST() {
        return SGST;
    }

    public void setSGST(String SGST) {
        this.SGST = SGST;
    }

    public String getCGST() {
        return CGST;
    }

    public void setCGST(String CGST) {
        this.CGST = CGST;
    }

    public String getEmail() {
        return Email;
    }

    public void setEmail(String Email) {
        this.Email = Email;
    }

    public String getTime() {
        return Time;
    }

    public void setTime(String Time) {
        this.Time = Time;
    }
    
    
}
