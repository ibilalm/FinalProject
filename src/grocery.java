import javafx.beans.property.SimpleDoubleProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;

public class grocery extends Item {
   /* private SimpleIntegerProperty itemcode;
    private SimpleStringProperty name;
    private SimpleStringProperty brand;
    private SimpleDoubleProperty price;
    private SimpleIntegerProperty units;
    private SimpleDoubleProperty discount;
    private SimpleDoubleProperty total;
    private SimpleDoubleProperty tax;*/
    public grocery(String n,int ic,String B,double p,int u,double d,double t){ //Constructor
        super(n,ic,B,p,u,d,t);
        /*itemcode=new SimpleIntegerProperty(ic);
        name=new SimpleStringProperty(n);
        brand = new SimpleStringProperty(B);
        price = new SimpleDoubleProperty(p);
        units = new SimpleIntegerProperty(u);
        discount = new SimpleDoubleProperty(d);
        total = new SimpleDoubleProperty(t);*/
    }
    /*public String getName(){
        return name.get();
    }//getter
    public int getItemCode(){
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
    public double getTotal(){
        return getPrice()*getUnits();
    }

    public void setName(String n){  //setter
        name.set(n);
    }
    public void setItemCode(int i){
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
        discount.set(d);
    }
    public void setTotal(double p, int u){
        price.set(p);
        units.set(u);
    }

    public double computeSubTotal(){
        double subTotal;
        subTotal = ((price.get()*units.get())-computeDiscount());
        return  subTotal;
    }
    public double computeDiscount() {
        return (price.get()*discount.get())*units.get();
    }
    public double computeTotalPrice(){
        double TotalPrice;
        double tax = computeTax();
        TotalPrice = computeSubTotal()-computeDiscount()+tax;
        return TotalPrice;
    }*/






}