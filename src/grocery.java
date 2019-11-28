import javafx.beans.property.SimpleDoubleProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;

public class grocery extends Item implements Discount{

    public grocery(String n,int ic,String B,double p,int u,double d,double t){ //Constructor
        super(n,ic,B,p,u,d,t);

    }

}