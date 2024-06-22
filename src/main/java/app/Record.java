package app;

public class Record 
{
    String designation;
    int quantity;
    double unitP;
    double total;  

    public void setDesignation(String designation) {
        this.designation = designation;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public void setUnitP(double unitP) {
        this.unitP = unitP;
    }

    public void setTotal(double total) {
        this.total = total;
    }
    
    public String getDesignation() {
        return designation;
    }

    public int getQuantity() {
        return quantity;
    }

    public double getUnitP() {
        return unitP;
    }

    public double getTotal() {
        return total;
    }
}
