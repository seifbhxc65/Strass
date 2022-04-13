package IHM;

import application.*;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Hyperlink;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.stage.Stage;

public class IHMRegister implements EventHandler<ActionEvent> {

	// Variables à utiliser par plusieurs méthodes de la classe
	Stage stageRegister;
	Hyperlink link;
	TextField name,adresse;
	PasswordField rpPassword;
	Button btnRegister;
	
	//Constructeur qui va faire la conception de l'interface d'ajout d'une formation
	public IHMRegister() {
		stageRegister = new Stage();
		stageRegister.setTitle("Register");
		stageRegister.addEventHandler(ActionEvent.ACTION,this);
	
		
		VBox  root = new VBox(10);
		

		Label title=new Label("Register");
		title.setStyle(" -fx-text-fill: white;");

		
		title.setFont(Font.font("System",FontWeight.EXTRA_BOLD,30));
		
//		----------Form---------------
		VBox Form = new VBox(10);
		
		VBox namee=new VBox(10);
		Label nm=new Label("Name :");
		nm.setFont(Font.font("System",FontWeight.BOLD,13));
		nm.setStyle(" -fx-text-fill: white;");
		name = new TextField();
		namee.getChildren().addAll(nm,name);
		
		VBox adressee=new VBox(10);
		Label adr=new Label("Adresse :");
		adr.setStyle(" -fx-text-fill: white;");
		adr.setFont(Font.font("System",FontWeight.BOLD,13));
		 adresse = new TextField();
		namee.getChildren().addAll(adr,adresse);
		
		VBox passe=new VBox(10);
		Label ps=new Label("Password :");
		ps.setStyle(" -fx-text-fill: white;");
		ps.setFont(Font.font("System",FontWeight.BOLD,13));
		PasswordField password = new PasswordField();
		passe.getChildren().addAll(ps,password);
		VBox rpPasse=new VBox(10);
		Label rpPs=new Label("Repeat Password :");
		rpPs.setStyle(" -fx-text-fill: white;");
		rpPs.setFont(Font.font("System",FontWeight.BOLD,13));
		 rpPassword = new PasswordField();
		passe.getChildren().addAll(rpPs,rpPassword);
		

		 btnRegister=new Button("Register");
		btnRegister.setOnMouseEntered(e -> btnRegister.setStyle("-fx-background-color: #05F29B;-fx-background-insets: 0 0 -1 0, 0, 1, 2;-fx-background-radius: 3px, 3px, 2px, 1px;-fx-padding: 0.333333em 0.666667em 0.333333em 0.666667em;-fx-text-fill: white; -fx-alignment: CENTER;  -fx-content-display: LEFT;"));
		btnRegister.setOnMouseExited(e -> btnRegister.setStyle("-fx-background-color:white;"));
		link = new Hyperlink();
		link.setText("Try To Login !");
		link.setStyle("-fx-text-fill:#05F29B;");
		link.addEventHandler(ActionEvent.ACTION,this);


		Form.setPadding(new Insets(20, 350, 20, 350));
		Form.setAlignment(Pos.CENTER);
		Form.getChildren().addAll(namee,adressee,passe,rpPasse,btnRegister ,link);
		root.getChildren().addAll(title,Form);
		root.setAlignment(Pos.CENTER);
		
	    root.setStyle("-fx-background-image:url('roadmap.jpg'); -fx-background-repeat: no-repeat; -fx-background-size: 1000 800; -fx-background-position: center center;");


		// params de la fenete
		Scene sceneRegister = new Scene(root,1000,600);
		stageRegister.setScene(sceneRegister);
		stageRegister.show();
		
	}
	@Override
	public void handle(ActionEvent e) {
		// TODO Auto-generated method stub
		Object source = e.getSource();
		if (source == link) {
			Main login = new Main();
			login.start(stageRegister);
			
			
			
		}
		
	}

}
