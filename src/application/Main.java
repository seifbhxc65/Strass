package application;


import IHM.*;

import org.json.simple.parser.JSONParser;

import DAO.RestaurantBD;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Hyperlink;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextField;
import javafx.scene.control.TitledPane;
import javafx.scene.control.ToggleGroup;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.*;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;


public class Main  extends Application implements EventHandler<ActionEvent> {
	Button btnLogin;
	Hyperlink linkRegister;
	Stage primaryStage;
	TextField name;
	PasswordField password;
	@Override
	public void start(Stage primaryStage) {
		JSONParser jsonP=new JSONParser();

		
		//ObjectMapper mapper = new ObjectMapper();
		VBox  root = new VBox(10);
			
			Scene scene = new Scene(root,1000,600);
		try {
		
		
		
			Label title=new Label("Login");
			title.getStyleClass().add("title");
			
			title.setFont(Font.font("System",FontWeight.EXTRA_BOLD,30));
			
//			----------Form---------------
			VBox Form = new VBox(10);
			
			VBox namee=new VBox(10);
			Label nm=new Label("Name :");
			nm.getStyleClass().add("title");
			nm.setFont(Font.font("System",FontWeight.BOLD,13));
			 name = new TextField();
			namee.getChildren().addAll(nm,name);
			VBox passe=new VBox(10);
			Label ps=new Label("Password :");
			ps.getStyleClass().add("title");
			ps.setFont(Font.font("System",FontWeight.BOLD,13));
			 password = new PasswordField();
			passe.getChildren().addAll(ps,password);

			 btnLogin=new Button("Login");
			btnLogin.addEventHandler(ActionEvent.ACTION,this);
			
			
			
			btnLogin.getStyleClass().add("button");
			linkRegister = new Hyperlink();
			linkRegister.setText("Try To Register !");
			linkRegister.getStyleClass().add("link");
			linkRegister.addEventHandler(ActionEvent.ACTION,this);

			
			
			Form.setPadding(new Insets(20, 350, 20, 350));
			Form.setAlignment(Pos.CENTER);
			Form.getChildren().addAll(namee,passe,btnLogin ,linkRegister);
			
//			-----------------------------------
			
			root.getChildren().addAll(title,Form);
			root.setAlignment(Pos.CENTER);


			Image img = new Image("roadmap.jpg");
			BackgroundImage bImg = new BackgroundImage(img,
					BackgroundRepeat.NO_REPEAT,
					BackgroundRepeat.NO_REPEAT,
					BackgroundPosition.CENTER,
					new BackgroundSize(1000,800,false,false,false,false));
			Background bGround = new Background(bImg);
			root.setBackground(bGround);
			
			scene.getStylesheets().add(getClass().getResource("application.css").toExternalForm());
		    primaryStage.setScene(scene);
			primaryStage.show();
			this.primaryStage=primaryStage;
			scene.getStylesheets().addAll(getClass().getResource("application.css").toExternalForm());

		} catch(Exception e) {
			e.printStackTrace();
		}
		
	}
	
	public static void main(String[] args) {
		launch(args);
	}

	@Override
	public void handle(ActionEvent e) {
		// TODO Auto-generated method stub
		Object source = e.getSource();
		if (source == linkRegister) {
			IHMRegister fRegister = new IHMRegister();
			primaryStage.close();	
		}else 	if (source == btnLogin) {
			if(name.getText().equals("admin")) {
			IHMAdmin fAdmin = new IHMAdmin();
			primaryStage.close();	
			}else if(name.getText().equals("user")) {
				IHMUser fUser = new IHMUser();
				primaryStage.close();	
				
			}else if(name.getText().equals("rest")) {
				IHMRest fRest = new IHMRest();
				primaryStage.close();	
				
			}
		}
		
		
	}
}
