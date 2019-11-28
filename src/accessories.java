import javafx.beans.property.SimpleDoubleProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;

public class accessories extends Item {
    /*private SimpleIntegerProperty itemcode;
    private SimpleStringProperty name;
    private SimpleStringProperty brand;
    private SimpleDoubleProperty price;
    private SimpleIntegerProperty units;
    private SimpleDoubleProperty discount;*/
    private SimpleDoubleProperty tax;
    public accessories(String n,int ic,String B,double p,int u,double d,double t, double tx){ //Constructor
        super(n,ic,B,p,u,d,t);
        tax = new SimpleDoubleProperty(tx);
        /*itemcode=new SimpleIntegerProperty(ic);
        name=new SimpleStringProperty(n);
        brand = new SimpleStringProperty(B);
        price = new SimpleDoubleProperty(p);
        units = new SimpleIntegerProperty(u);
        discount = new SimpleDoubleProperty(d);
    }
    public String getName(){
        return name.get();
    }//getter
    public int getCode(){
        return itemcode.get();
    }
    public String getBrand(){
        return brand.get();
    }
    public double getPrice(){
        return price.get();
    }
    public int getUnits(){
        return units.get();
    }
    public double getDiscount(){
        return discount.get();
    }

    public void setName(String n){  //setter
        name.set(n);
    }
    public void setCode(int i){
        itemcode.set(i);
    }
    public void setAge(String b){
        brand.set(b);
    }
    public void setPrice(double p){
        price.set(p);
    }
    public void setUnits(int u){
        units.set(u);
    }
    public void setDiscount(double d){
        discount.set(d);*/
    }
    public double computeTax() {
        return computeSubTotal()*8.25/100;
    }

}
