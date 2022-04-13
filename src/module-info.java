module ProjectX {

		requires javafx.controls;
		requires javafx.web;
		requires java.sql;
		requires json.simple;
		
		opens application to javafx.graphics, javafx.fxml,javafx.base;
		opens IHM to javafx.graphics, javafx.fxml,javafx.base;
		opens oo to javafx.graphics, javafx.fxml,javafx.base;
	}

