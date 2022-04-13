package IHM;

import java.util.ArrayList;
import java.util.concurrent.atomic.AtomicReference;

import DAO.RestaurantBD;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.Hyperlink;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableRow;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.ToggleGroup;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.image.Image;
import javafx.scene.layout.*;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.web.WebEngine;
import javafx.scene.web.WebView;
import javafx.stage.Stage;
import oo.*;

public class IHMUser implements EventHandler<ActionEvent>{
 
	// Variables à utiliser par plusieurs méthodes de la classe
	Stage stageUser;
    RestaurantBD resto0=new RestaurantBD();
	 ObservableList<Restaurant> resto = resto0.getResto();
	


	    TableView table = new TableView();
	   TableColumn firstNameCol = new TableColumn("Restaurent Name");
	   TableColumn lastNameCol = new TableColumn("Avis");
	   TableColumn emailCol = new TableColumn("Distance (km)");
	   TableColumn phone = new TableColumn("Phone");
		Hyperlink link;
		TextField name,adresse;
		PasswordField rpPassword;
		Button btnRegister;



	   public ArrayList<Restaurant> getResto(String lon, String lat,String max_dis) {
		   System.out.print("eee");
	       ArrayList<Restaurant> near_resto=new ArrayList<>();
	       for(Restaurant value : resto) {
	           if (value.CalculationByDistance(Double.parseDouble(lat),Double.parseDouble(lon),value.getLatitude(),value.getLongitude() ) <= Double.parseDouble(max_dis)){
	               near_resto.add(value);

	           }

	       }
	       return near_resto;
	   }
	//Constructeur qui va faire la conception de l'interface d'ajout d'une formation
	public IHMUser() {
		stageUser = new Stage();
		stageUser.setTitle("User");
		stageUser.addEventHandler(ActionEvent.ACTION,this);
	
		
		   WebView myweb = new WebView();
           WebEngine engine=myweb.getEngine();
           engine.load("https://www.google.com/maps");
           
           //resto.add(new Restaurant("arena","fff@gmail.com", (float) 4.2,35.82190078093802, 10.625290072520984,"53681223"));
           //resto.add(new Restaurant("sami","fff@gmail.com", (float) 4.7,35.82009129113957, 10.62580505663544,"96249208"));
           //resto.add(new Restaurant("yassin","fff@gmail.com", (float) 4.8,35.752033793294395 , 10.812101038425297,"26920359"));

           myweb.setMaxSize(575,600);
           HBox root = new HBox();
          
           VBox form = new VBox(15);
           Label title = new Label("Welcome Our Client!");
           title.setStyle(" -fx-text-fill: white;");
           title.setFont(Font.font("System",FontWeight.EXTRA_BOLD,30));
           title.setPadding(new Insets(0,0,10,0));
           Label lon = new Label("Longitude");
           lon.setFont(Font.font("System",FontWeight.BOLD,9));
   		   lon.setStyle(" -fx-text-fill: white;");
           TextField lon_name= new TextField();
           Label lat = new Label("Latitude");
           lat.setFont(Font.font("System",FontWeight.BOLD,9));
   		   lat.setStyle(" -fx-text-fill: white;");
           TextField lat_name= new TextField();
           Label max_dis = new Label("Max-Distance");
           max_dis.setFont(Font.font("System",FontWeight.BOLD,13));
           max_dis.setStyle(" -fx-text-fill: white;");
           TextField dis_val= new TextField();
           Label trie = new Label("Sort By : ");
           trie.setFont(Font.font("System",FontWeight.BOLD,13));
           trie.setStyle(" -fx-text-fill: white;");
           firstNameCol.setMinWidth(120);
           emailCol.setMinWidth(100);
           lastNameCol.setMinWidth(80);
           phone.setMinWidth(108);
           table.getColumns().addAll(firstNameCol, lastNameCol, emailCol,phone);
            AtomicReference<ArrayList<Restaurant>> super_resto= new AtomicReference<>(new ArrayList<>());
           final ToggleGroup group=new ToggleGroup();
           RadioButton klm = new RadioButton("Kilometer");
           klm.setStyle(" -fx-text-fill: white;");
           klm.setToggleGroup(group);
           RadioButton avis = new RadioButton("Avis");
           avis.setStyle(" -fx-text-fill: white;");
           avis.setToggleGroup(group);
           HBox hb1 = new HBox(10);
           hb1.getChildren().addAll(lon,lon_name);
           hb1.setAlignment(Pos.CENTER);
           HBox hb2 = new HBox(10);
           hb2.getChildren().addAll(lat,lat_name);
           hb2.setAlignment(Pos.CENTER);
           HBox hb3 = new HBox(10);
           hb3.getChildren().addAll(max_dis,dis_val);
           hb3.setAlignment(Pos.CENTER);
           HBox hb4 = new HBox(10);
           hb4.getChildren().addAll(klm,avis);
           hb4.setAlignment(Pos.CENTER);
           Button btSend = new Button("Send");
           btSend.setOnMouseEntered(e -> btSend.setStyle("-fx-background-color: #05F29B;-fx-background-insets: 0 0 -1 0, 0, 1, 2;-fx-background-radius: 3px, 3px, 2px, 1px;-fx-padding: 0.333333em 0.666667em 0.333333em 0.666667em;-fx-text-fill: white; -fx-alignment: CENTER;  -fx-content-display: LEFT;"));
           btSend.setOnMouseExited(e -> btSend.setStyle("-fx-background-color:white;"));
           HBox latlon=new HBox(10);
           VBox liste=new VBox(5);
           Alert a1=new Alert(Alert.AlertType.WARNING);
           a1.setTitle("fill the form");
           Label hb5=new Label("");
           btSend.setOnAction(e -> {

               String[] parts1=lon_name.getText().split("[.]");
               String[] parts2=lat_name.getText().split("[.]");
               if(!klm.isSelected() && !avis.isSelected() ){


                   a1.setHeaderText("You should choose the type of sort!");
                   a1.showAndWait();

               }

               else if( dis_val.getText().length()==0 || lon_name.getText().length()==0 || lat_name.getText().length()==0){
                   a1.setHeaderText("You should fill all the form!");
                   a1.showAndWait();
               }
               else if(  Integer.valueOf(dis_val.getText())<=0){
                   a1.setHeaderText("Distance must be positive!");
                   a1.showAndWait();
               }
               else if(parts1.length!=2 || parts2.length!=2){
                   a1.setHeaderText("You should fill the location correctly! ");
                   a1.showAndWait();
               }
               else{
                   table.getItems().clear();
                   engine.load("https://www.google.tn/maps/@"+lat_name.getText()+","+lon_name.getText()+",15z");
                   super_resto.set(getResto(lon_name.getText(), lat_name.getText(), dis_val.getText()));

                   for (Restaurant a : super_resto.get()) {
                      // hb5.setText("Resto N1 : " + a.getNom() + " Avis : " + a.getAvis() + " , " + a.CalculationByDistance(Double.parseDouble(lat_name.getText()), Double.parseDouble(lon_name.getText()), a.getLatitude(), a.getLongitude()) + " km far from you ");
                       a.setDistance(a.CalculationByDistance(Double.parseDouble(lat_name.getText()), Double.parseDouble(lon_name.getText()), a.getLatitude(), a.getLongitude()));

                   }

                   firstNameCol.setCellValueFactory(
                           new PropertyValueFactory<>("Nom"));

                   lastNameCol.setCellValueFactory(
                           new PropertyValueFactory<>("avis"));

                       emailCol.setCellValueFactory(
                               new PropertyValueFactory<>("distance"));
                       phone.setCellValueFactory(
                           new PropertyValueFactory<>("phone"));
                   table.setEditable(true);
                   //table.getColumns().addAll(firstNameCol, lastNameCol, emailCol);
                   for (Restaurant emp : super_resto.get()){
                       table.getItems().add(emp);
                   }
                   if(klm.isSelected()){
                       emailCol.setSortType(TableColumn.SortType.ASCENDING);
                       table.getSortOrder().add(emailCol);
                       table.sort();
                       klm.setSelected(false);
                   }
                   else if(avis.isSelected()){
                       lastNameCol.setSortType(TableColumn.SortType.DESCENDING);
                       table.getSortOrder().add(lastNameCol);
                       table.sort();
                       avis.setSelected(false);
                   }

               }
           });
           // HTMLIFrameElement
           latlon.getChildren().addAll(hb2,hb1);
           form.setAlignment(Pos.CENTER);

           form.getChildren().addAll(title,latlon,hb3,trie,hb4,hb5,btSend);
           //root.setAlignment(Pos.CENTER);
           table.setRowFactory(tv -> {
               TableRow row = new TableRow<>();
               row.setOnMouseClicked(event -> {
                   if (! row.isEmpty()
                           && event.getClickCount() == 1) {
                       int index = table.getSelectionModel().selectedIndexProperty().get();
                       System.out.println(index);
                       
                       System.out.println(super_resto.get().get(index).getLink());
                       if(super_resto.get().get(index).getLink()==null)
                       {engine.load("https://www.google.tn/maps/@"+ super_resto.get().get(index).getLatitude()+","+ super_resto.get().get(index).getLongitude()+",15z");}
                       else {
                    	   engine.load(super_resto.get().get(index).getLink());
                       }
                   }
                   
               });
               return row ;
           });



           VBox gauche=new VBox(20);
           gauche.getChildren().addAll(form,table);
           gauche.setPadding(new Insets(35,10,20,10));
           root.getChildren().addAll(gauche,myweb);


        Image img = new Image("roadmap.jpg");
        BackgroundImage bImg = new BackgroundImage(img,
                BackgroundRepeat.NO_REPEAT,
                BackgroundRepeat.NO_REPEAT,
                BackgroundPosition.CENTER,
                new BackgroundSize(1000,800,false,false,false,false));
        Background bGround = new Background(bImg);
        root.setBackground(bGround);


		// params de la fenete
		Scene sceneUser = new Scene(root,1000,600);
		stageUser.setScene(sceneUser);
		stageUser.show();
		
		
	}

	@Override
	public void handle(ActionEvent e) {
		// TODO Auto-generated method stub
		
	}

}
