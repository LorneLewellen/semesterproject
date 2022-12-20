package application;
import javafx.stage.*;
import javafx.scene.*;
import javafx.scene.layout.*;
import javafx.scene.control.*;
import javafx.geometry.*;
public class login {
	public static void display(String title, String message) {
		Stage popup = new Stage();
		
		popup.initModality(Modality.APPLICATION_MODAL);
		popup.setTitle("LOGIN SCREEN");
		popup.setMinWidth(250);
		
		Label label = new Label();
		label.setText(message);
		Button loginButton = new Button("Login");
		Button closeButton = new Button("Shut Down");
		closeButton.setOnAction(e -> popup.close());
		
		VBox layout = new VBox(10);
		layout.getChildren().addAll(label, closeButton);
		layout.setAlignment(Pos.BOTTOM_CENTER);
		
		Scene scene = new Scene(layout);
		popup.setScene(scene);
		popup.showAndWait();
		
	}

}
