package IHM;
import DAO.RestaurantBD;
import application.Main;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Hyperlink;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.control.TitledPane;
import javafx.scene.control.ToggleGroup;
import javafx.scene.control.Tooltip;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.stage.Stage;
import oo.*;
public class IHMRest implements EventHandler<ActionEvent> {

	// Variables à utiliser par plusieurs méthodes de la classe
	Stage stageRest;
	TextField inNm,inAd,inEmail,inPh,inLat,inLong;
	Button btnSubmit;
	ComboBox<Integer> cBx1;
	
	//Constructeur qui va faire la conception de l'interface d'ajout d'une formation
	public IHMRest() {
		stageRest = new Stage();
		stageRest.setTitle("Rest");
		stageRest.addEventHandler(ActionEvent.ACTION,this);
	
		
		TitledPane TP1 = new TitledPane();
		TP1.setText("Informations");
		TP1.setAlignment(Pos.CENTER);
		TitledPane TP2 = new TitledPane();
		Label title=new Label("Restaurent");
	    title.setStyle(" -fx-text-fill: white;");
		title.setFont(Font.font("System",FontWeight.EXTRA_BOLD,30));
	
		VBox  root = new VBox(10); 
		root.setStyle("-fx-background-color: #05F29B;");
		
	
		
		
		
		
		root.getChildren().addAll(title,TP1,TP2);
		root.setAlignment(Pos.CENTER);
		
		
		
		
		
		
		
		
		HBox Hb1 =new HBox(10);
		HBox Hb2 =new HBox(10);
		HBox Hb3 =new HBox(10);
		HBox Hb6 =new HBox(10);
		Label Nm=new Label("Name: ");
		 inNm=new TextField();
		Hb1.getChildren().addAll(Nm,inNm);
		Hb1.setAlignment(Pos.CENTER);
		
		Label Ad=new Label("Adress:");
		 inAd=new TextField();
		Hb2.getChildren().addAll(Ad,inAd);
		Hb2.setAlignment(Pos.CENTER);
		
		
		Label Email=new Label("Email  :");
		 inEmail=new TextField();
		 
		Hb3.getChildren().addAll(Email,inEmail);
		Hb3.setAlignment(Pos.CENTER);
		
		Label Dn=new Label("Avis:");
		cBx1=new ComboBox<>();

		
	
		for(int i=1;i<6;i++) {
			cBx1.getItems().add(i);
			
			
		}
		cBx1.getSelectionModel().select(0);
	
		
		HBox Hb4=new HBox(10);
		Hb4.getChildren().addAll(Dn,cBx1);
		Hb4.setAlignment(Pos.CENTER);
	
		Label Ph=new Label("Phone:");
		 inPh=new TextField();
		HBox hb5=new HBox(10);
		hb5.getChildren().addAll(Ph,inPh);
		hb5.setAlignment(Pos.CENTER);
		Label location=new Label("Location:");
		inLat=new TextField();
		inLat.setPromptText("latitude");
		inLong=new TextField();
		inLong.setPromptText("longitude");
		inLat.setPrefWidth(75);
		inLong.setPrefWidth(75);
		Hb6.getChildren().addAll(location,inLat,inLong);
		Hb6.setAlignment(Pos.CENTER);
		
		btnSubmit=new Button("Submit");
		btnSubmit.setMinWidth(150);
		btnSubmit.setOnMouseEntered(e ->{ 
			
			
			btnSubmit.setStyle("-fx-background-color: #05F29B;-fx-background-radius: 3px, 3px, 2px, 1px;-fx-text-fill: white; -fx-alignment: CENTER;  -fx-content-display: LEFT;");
			
		});
		btnSubmit.setOnMouseExited(e -> btnSubmit.setStyle("-fx-background-color:white;"));
		
	    btnSubmit.setOnAction(e->{
	    	//inNm,inAd,inEmail,inPh
	    	System.out.println(cBx1.getValue());
	    	Restaurant r=new Restaurant(0,inNm.getText(), inEmail.getText(),cBx1.getValue(), 
	    			Double.parseDouble(inLat.getText()), Double.parseDouble(inLong.getText()), inPh.getText(),null);
	    	System.out.println("nom : "+r.getNom());
	    	System.out.println("Email : "+r.getEmail());
	    	System.out.println("Phone : "+r.getPhone());
	    	System.out.println("avis : "+r.getAvis());
	       RestaurantBD bd=new RestaurantBD();
	       bd.ajout(r.getNom(),r.getEmail(),r.getAvis(),r.getPhone(),r.getLatitude(),r.getLongitude(),null);
	    }
	    );
		
	
		
		VBox VB=new VBox(10);
	
		
		VB.getChildren().addAll(Hb1,Hb2,Hb3,hb5,Hb6,Hb4,btnSubmit);
		VB.setAlignment(Pos.CENTER);
		TP1.setContent(VB);
		
		
		
		//*************************************
		TP2.setText("Details");
		
		
		
		
		//	-------------------------
		
		
	    root.setStyle("-fx-background-image:url('roadmap.jpg'); -fx-background-repeat: no-repeat; -fx-background-size: 1000 800; -fx-background-position: center center;");


		// params de la fenete
		Scene sceneRest = new Scene(root,1000,600);
		stageRest.setScene(sceneRest);
		stageRest.show();
		
	}
	@Override
	public void handle(ActionEvent e) {
		// TODO Auto-generated method stub
		Object source = e.getSource();
	
		
	}


}
