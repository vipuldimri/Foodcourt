package foodcourt;
public class Settings {
    
    private double GGST;
    private double CGST;
    private String Time;
    private String ColddrinkQTY;
    private String WaterQTY;
    private String Email;

    public Settings(double GGST, double CGST, String Time, String ColddrinkQTY, String WaterQTY, String Email) {
        this.GGST = GGST;
        this.CGST = CGST;
        this.Time = Time;
        this.ColddrinkQTY = ColddrinkQTY;
        this.WaterQTY = WaterQTY;
        this.Email = Email;
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
    public String getTime() {
        return Time;
    }
    public void setTime(String Time) {
        this.Time = Time;
    }
    public String getColddrinkQTY() {
        return ColddrinkQTY;
    }

    public void setColddrinkQTY(String ColddrinkQTY) {
        this.ColddrinkQTY = ColddrinkQTY;
    }

    public String getWaterQTY() {
        return WaterQTY;
    }

    public void setWaterQTY(String WaterQTY) {
        this.WaterQTY = WaterQTY;
    }

    public String getEmail() {
        return Email;
    }

    public void setEmail(String Email) {
        this.Email = Email;
    }
    
    
    
    
}
