import javafx.application.Application;
import javafx.application.Application;
import javafx.beans.property.SimpleStringProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.*;
import javafx.scene.text.Font;
import javafx.stage.Stage;

import javax.swing.*;

public class Demo extends Application {

    public static void main(String[] args){
        launch(args);
    }

    private GridPane g1 = new GridPane();
    private GridPane g2 = new GridPane();
    private VBox vb1= new VBox();
    private VBox vb2= new VBox();
    private VBox vb3= new VBox();
    private FlowPane fp = new FlowPane();
    private BorderPane bp = new BorderPane();
    private ObservableList<Item> data;
    ListView<String> listView;
    Alert alerts = new Alert(Alert.AlertType.INFORMATION); //success message
    Alert alerte = new Alert(Alert.AlertType.ERROR); //Error messag

    public void start(Stage s){
        Stage window = s;
        //Table View
        TableView<Item> tbl; //table view to store objects
        tbl = new TableView<>();
        data = FXCollections.observableArrayList();
        tbl.setEditable(true);
        tbl.setItems(data);
        //Column1
        TableColumn namecol = new TableColumn("Name");
        namecol.setMinWidth(100);
        namecol.setCellValueFactory(new PropertyValueFactory<Item, String>("name"));
        //Column2
        TableColumn codecol = new TableColumn("ItemCode");
        codecol.setMinWidth(10);
        codecol.setCellValueFactory(new PropertyValueFactory<Item, Integer>("ItemCode"));
        //Column3
        TableColumn brandcol = new TableColumn("Brand");
        brandcol.setMinWidth(40);
        brandcol.setCellValueFactory(new PropertyValueFactory<Item,String>("Brand"));
        //Column4
        TableColumn priceCol = new TableColumn("Price");
        priceCol.setMinWidth(50);
        priceCol.setCellValueFactory(new PropertyValueFactory<Item, Double>("Price"));
        //Column5
        TableColumn unitsCol = new TableColumn("Units");
        unitsCol.setMinWidth(10);
        unitsCol.setCellValueFactory(new PropertyValueFactory<Item, Integer>("Units"));
        //Column6
        TableColumn discCol = new TableColumn("Discount");
        discCol.setMinWidth(10);
        discCol.setCellValueFactory(new PropertyValueFactory<Item, Double>("Discount"));
        //Column7
        TableColumn totalcol = new TableColumn("Total Price");
        totalcol.setMinWidth(50);
        totalcol.setCellValueFactory(new PropertyValueFactory<Item, Double>("Total"));

        tbl.getColumns().addAll(codecol, namecol, brandcol, priceCol,unitsCol,discCol,totalcol);

        //Top
        Button ab = new Button("Add");
        Button ub = new Button("Update");
        Button rb = new Button("Remove");
        Button pb = new Button("Print");
        fp.getChildren().addAll(ab, ub, rb, pb);
        EventHandler<ActionEvent> event1 = new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                vb1.setVisible(true);

            }
        };
        ab.setOnAction(event1);

        //Left side
        s.setHeight(600);
        s.setWidth(800);
        Scene sc1, sc2, sc3, sc4;
        sc1 = new Scene(new Group());

        Label ln = new Label();
        ln.setText("Name");
        Label lc = new Label();
        lc.setText("Code");
        Label lb = new Label();
        lb.setText("Brand");
        Label lp = new Label();
        lp.setText("Price");
        Label lu = new Label();
        lu.setText("Units");
        Label ld = new Label();
        ld.setText("Discount");

        TextField tn = new TextField();
        TextField tc = new TextField();
        TextField tb = new TextField();
        TextField tp = new TextField();
        TextField tu = new TextField();
        TextField td = new TextField();
        Button addb = new Button("Add");

        g1.add(ln, 0, 0);
        g1.add(tn, 1, 0);
        g1.add(lc, 0, 1);
        g1.add(tc, 1, 1);
        g1.add(lb, 0, 2);
        g1.add(tb, 1, 2);
        g1.add(lp, 0, 3);
        g1.add(tp, 1, 3);
        g1.add(lu, 0, 4);
        g1.add(tu, 1, 4);
        g1.add(ld,0,5);
        g1.add(td,1,5);

        g1.setPadding(new Insets(10, 10, 10, 10));
        g1.setHgap(10);
        g1.setVgap(10);
        vb1.getChildren().addAll(g1, addb);
        vb1.setSpacing(10);
        vb1.setPadding(new Insets(10,10,10,10));
        vb1.setVisible(false);

        //Right side of scene1

        Label tl = new Label("Items Purchased");
        bp.setTop(fp);
        bp.setLeft(vb1);
        bp.setRight(vb2);
        bp.setPadding(new Insets(10,10,10,10));
        vb2.getChildren().addAll(tl, tbl);
        vb2.setPadding(new Insets(10,10,10,10));
        vb2.setSpacing(10);

        EventHandler<ActionEvent> event2 = new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                String name = tn.getText();
                int icode = Integer.parseInt(tc.getText());
                String brand = tb.getText();
                double price = Double.parseDouble(tp.getText());
                int units = Integer.parseInt(tu.getText());
                double discount = Double.parseDouble(td.getText());
                double total = price*units;
                double tax = total*8.25/100;
                //System.out.print(total);
                Item item = new Item(name,icode,brand,price,units,discount,total);
                grocery g = new grocery(name,icode,brand,price,units,discount,total);
                clothing c = new clothing(name,icode,brand,price,units,discount,total,tax);
                accessories a = new accessories(name,icode,brand,price,units,discount,total,tax);
                electronics e = new electronics(name,icode,brand,price,units,discount,total,tax);
                furniture fur = new furniture(name,icode,brand,price,units,discount,total,tax);
                kitchenutensils ku = new kitchenutensils(name,icode,brand,price,units,discount,total,tax);
                //System.out.print("Item: "+item.getItemCode()+" Qty: "+item.getUnits()+" Price: "+item.getTotal()+"\n");
                //Person p = new Person(tn.getText(), Integer.parseInt(ta.getText()));
                data.add(item); //to make the data available on table;
                tn.clear();
                tc.clear();
                tb.clear();
                tp.clear();
                tu.clear();
                td.clear();
            }
        };
        addb.setOnAction(event2);
        //Scene2
        Label ul2 = new Label("Enter the item details to update");
        ul2.setFont(new Font("Courier", 14));
        Label ln2 = new Label("Name");
        Label lc2 = new Label("Code");
        Label lb2 = new Label("Brand");
        Label lp2 = new Label("Price");
        Label lu2 = new Label("Units");
        Label ld2 = new Label("Discount");
        TextField tn2 = new TextField();
        TextField tc2 = new TextField();
        TextField tb2 = new TextField();
        TextField tp2 = new TextField();
        TextField tu2 = new TextField();
        TextField td2 = new TextField();
        Button back = new Button("Back");
        back.setOnAction(e -> window.setScene(sc1));
        Button bmod = new Button("Modify");
        g2.add(ln2, 0, 0);
        g2.add(tn2, 1, 0);
        g2.add(lc2, 0, 1);
        g2.add(tc2, 1, 1);
        g2.add(lb2, 0, 2);
        g2.add(tb2, 1, 2);
        g2.add(lp2, 0, 3);
        g2.add(tp2, 1, 3);
        g2.add(lu2, 0, 4);
        g2.add(tu2, 1, 4);
        g2.add(ld2,0,5);
        g2.add(td2,1,5);

        Label l2= new Label();
        g2.setPadding(new Insets(10, 10, 10, 10));
        g2.setHgap(10);
        g2.setVgap(10);
        vb3.getChildren().addAll(ul2, g2, back, bmod, l2);
        vb3.setSpacing(10);
        vb3.setPadding(new Insets(10, 10, 10, 10));
        EventHandler<ActionEvent> event3 = new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                String sname = tn2.getText();          // causes fields of the given record to be modified
                int scode = Integer.parseInt(tc2.getText());
                String sbrand = tb2.getText();
                double price = Double.parseDouble(tp2.getText());
                int units = Integer.parseInt(tu2.getText());
                double discount = Double.parseDouble(td2.getText());
                double total = price*units;
                double tax = total*8.25/100;

                boolean f = false;
                for (int i = 0; i < tbl.getItems().size(); i++) {
                    if (((String) tbl.getItems().get(i).getName()).equals(sname) && (int) tbl.getItems().get(i).getItemCode()==scode && tbl.getItems().get(i).getBrand().equals(sbrand)) {
                        Item item = new Item(tn2.getText(),Integer.parseInt(tc2.getText()),tb2.getText(),Double.parseDouble(tp2.getText()),Integer.parseInt(tu2.getText()),Double.parseDouble(td2.getText()),total);
                        grocery g = new grocery(tn2.getText(),Integer.parseInt(tc2.getText()),tb2.getText(),Double.parseDouble(tp2.getText()),Integer.parseInt(tu2.getText()),Double.parseDouble(td2.getText()),total);
                        clothing c = new clothing(tn2.getText(),Integer.parseInt(tc2.getText()),tb2.getText(),Double.parseDouble(tp2.getText()),Integer.parseInt(tu2.getText()),Double.parseDouble(td2.getText()),total,tax);
                        accessories a = new accessories(tn2.getText(),Integer.parseInt(tc2.getText()),tb2.getText(),Double.parseDouble(tp2.getText()),Integer.parseInt(tu2.getText()),Double.parseDouble(td2.getText()),total,tax);
                        electronics e = new electronics(tn2.getText(),Integer.parseInt(tc2.getText()),tb2.getText(),Double.parseDouble(tp2.getText()),Integer.parseInt(tu2.getText()),Double.parseDouble(td2.getText()),total,tax);
                        furniture fur = new furniture(tn2.getText(),Integer.parseInt(tc2.getText()),tb2.getText(),Double.parseDouble(tp2.getText()),Integer.parseInt(tu2.getText()),Double.parseDouble(td2.getText()),total,tax);
                        kitchenutensils ku = new kitchenutensils(tn2.getText(),Integer.parseInt(tc2.getText()),tb2.getText(),Double.parseDouble(tp2.getText()),Integer.parseInt(tu2.getText()),Double.parseDouble(td2.getText()),total,tax);
                        tbl.getItems().set(i, item);
                        f = true;
                        if (f) {
                            alerts.setTitle("Success");
                            alerts.setHeaderText(null);
                            alerts.setContentText("Update Successful!");
                            alerts.showAndWait();
                        } else {
                            alerte.setTitle("Error");
                            alerte.setHeaderText(null);
                            alerte.setContentText("Entered item not found..");
                            alerte.showAndWait();
                        }
                        tn2.clear();
                        tc2.clear();
                        tb2.clear();
                        tp2.clear();
                        tu2.clear();
                        td2.clear();
                        s.setScene(sc1);
                    }
                }
            }
        };
        bmod.setOnAction(event3);

        sc2 = new Scene(vb3,400,200);
        EventHandler<ActionEvent> event5 = new EventHandler<ActionEvent>(){
            public void handle(ActionEvent event) {
                s.setScene(sc2);
            }
        };
        ub.setOnAction(event5);



        //Scene3--Delete a row in the table
        GridPane gp = new GridPane();
        VBox vb4 = new VBox();
        Label dl = new Label("Enter the Item Code to remove");
        Label dell = new Label("Code");
        TextField delt = new TextField();
        Button back2 = new Button("Back");
        back2.setOnAction(e -> window.setScene(sc1));
        Button db = new Button("Delete");
        vb4.getChildren().addAll(dl,gp,back2,db);
        vb4.setPadding(new Insets(10,10,10,10));
        vb4.setSpacing(10);
        sc3 = new Scene(vb4, 100,50);
        gp.add(dell,0,1);
        gp.add(delt,1,1);
        gp.setHgap(10);
        gp.setVgap(10);

        EventHandler<ActionEvent> event4 = new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                int scode = Integer.parseInt(delt.getText());
                boolean df = false;
                for (int i = 0; i < tbl.getItems().size(); i++){
                    if (((int)tbl.getItems().get(i).getItemCode())==scode){
                        tbl.getItems().remove(i);
                        df=true;
                    }
                }
                if (df){
                    alerts.setTitle("Success");
                    alerts.setHeaderText(null);
                    alerts.setContentText("Deletion Successful");
                    alerts.showAndWait();
                }
                else {
                    alerte.setTitle("Error");
                    alerte.setHeaderText(null);
                    alerte.setContentText("Entered item not found");
                    alerte.showAndWait();
                }
                delt.clear();
                s.setScene(sc1);
            }
        };
        db.setOnAction(event4);

        EventHandler<ActionEvent> event6 = new EventHandler<ActionEvent>() {
                    @Override
                    public void handle(ActionEvent event) {
                        s.setScene(sc3);

                    }
                };
                rb.setOnAction(event6);

        //Scene4 Print Bill
         GridPane gp2 = new GridPane();
         VBox vb5 = new VBox();
         Label l1 = new Label("Your Shopping Summary");
         l1.setFont(new Font("Courier", 14));
         Button back3 = new Button("Back");
         back3.setOnAction(e -> window.setScene(sc1));
         Button compute = new Button("Compute Total");
         Label output = new Label();
         TableView<Item> tbl1 = new TableView<>();
         final ObservableList<Item> data= FXCollections.observableArrayList();
         tbl1.setEditable(true);
         tbl1.setItems(data);

         vb5.getChildren().addAll(l1,gp2,back3,compute);
         vb5.setPadding(new Insets(10,10,10,10));
         vb5.setSpacing(10);
         sc4 = new Scene(vb5, 100,50);
         gp2.setHgap(10);
         gp2.setVgap(10);
         gp2.add(output,3,2);
         



         EventHandler<ActionEvent> event7 = new EventHandler<ActionEvent>() {
             @Override
             public void handle(ActionEvent event) {


                 output.setText(tp.getText());
             }
         };
         compute.setOnAction(event7);

        EventHandler<ActionEvent> event8 = new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                System.out.println("Your Receipt ");
                double total = 0;
                for (int i = 0; i < tbl.getItems().size(); i++){
                  System.out.println("Item code: "+(int)tbl.getItems().get(i).getItemCode()+", "+"Name: "+tbl.getItems().get(i).getName()+", "+"Price: "+tbl.getItems().get(i).getPrice()+", "+"Qty: "+tbl.getItems().get(i).getUnits()+", "+"Subtotal: "+tbl.getItems().get(i).getTotal());

                }
                for (int i = 0; i < tbl.getItems().size(); i++){
                    total += tbl.getItems().get(i).getTotal();
                }
                System.out.println("Item Total: "+total);
                double tax = total*8.25/100;
                double totalprice = total+tax;
                System.out.println("Tax: "+tax);
                System.out.println("Total Price: "+totalprice);
                
                //System.out.print(g.getTotal());
                //data.addAll(Double.parseDouble(tp.getText())*=Integer.parseInt(tu.getText()));
                /*s.setScene(sc4);
                s.show();*/

            }
        };
        pb.setOnAction(event8);












        ((Group) sc1.getRoot()).getChildren().add(bp);
        s.setScene(sc1);
        s.show();


    }//end of start

}//end of class
