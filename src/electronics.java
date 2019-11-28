import javafx.beans.property.SimpleDoubleProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;

public class electronics extends Item implements Tax, Discount{

    private SimpleDoubleProperty tax;

    public electronics(String n,int ic,String B,double p,int u,double d,double t, double tx){ //Constructor
        super(n,ic,B,p,u,d,t);
        tax = new SimpleDoubleProperty(tx);
    }

    public double computeTax() {
        return computeSubTotal()*8.25/100;
    }

}
