package application;
import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.control.Label;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import javafx.stage.Modality;


public class Main2 extends Application  {
	Stage app;
	TableView<Songs> table;
	TextField titleInput, artistInput, lengthmInput, lengthsInput, ratingInput;
	
	
	public static void main(String[] args) {
		launch(args);
	}
	
	
	
	@Override
	 public void start(Stage primaryStage) throws Exception {
		
		app = primaryStage;
		Stage popup = new Stage();
		
		popup.initModality(Modality.APPLICATION_MODAL);
		popup.setTitle("LOGIN SCREEN");
		popup.setMinWidth(500);
		popup.setMinHeight(400);
		
		Label hint = new Label();
		Label label = new Label();
		label.setText("Welcometo the music list app!");
		Button loginButton = new Button("Login");
		Button exitButton = new Button("Shut Down");
		exitButton.setOnAction(e -> System.exit(1));
		loginButton.setOnAction(e -> popup.close());
		
		
		VBox layout = new VBox(10);
		layout.getChildren().addAll(label, hint, loginButton, exitButton );
		layout.setAlignment(Pos.CENTER);
		
		Scene scen = new Scene(layout);
		popup.setScene(scen);
		popup.showAndWait();
		
		
		
	
		
	
		
	
		
		
		app.setTitle("Song List App!");
		
		TableColumn<Songs, String> titleColumn = new TableColumn<Songs, String>("Song Name");
		titleColumn.setMinWidth(250);
		titleColumn.setCellValueFactory(new PropertyValueFactory<Songs, String>("title"));
		
		TableColumn<Songs, String> artistColumn = new TableColumn<Songs, String>("Song Artist");
		artistColumn.setMinWidth(225);
		artistColumn.setCellValueFactory(new PropertyValueFactory<Songs, String>("artist"));
		
		TableColumn<Songs, Integer> lengthmColumn = new TableColumn<Songs, Integer>("Minutes");
		lengthmColumn.setMinWidth(25);
		lengthmColumn.setCellValueFactory(new PropertyValueFactory<Songs, Integer>("lengthm"));
		
		TableColumn<Songs, Integer> lengthsColumn = new TableColumn<Songs, Integer>("Seconds");
		lengthsColumn.setMinWidth(25);
		lengthsColumn.setCellValueFactory(new PropertyValueFactory<Songs, Integer>("lengths"));
		
		TableColumn<Songs, Integer> ratingColumn = new TableColumn<Songs, Integer>("Personal Rating");
		ratingColumn.setMinWidth(25);
		ratingColumn.setCellValueFactory(new PropertyValueFactory<Songs, Integer>("rating"));
		
		table = new TableView<>();
		table.setItems(getSongs());
		table.getColumns().addAll(titleColumn, artistColumn, lengthmColumn, lengthsColumn, ratingColumn);
		
		table.setColumnResizePolicy(TableView.CONSTRAINED_RESIZE_POLICY);
		
		
		
		
		titleInput = new TextField();
		titleInput.setPromptText("Song Name");
		titleInput.setMinWidth(100);
		
		artistInput = new TextField();
		artistInput.setPromptText("Artist Name");
		
		
		lengthmInput = new TextField();
		lengthmInput.setPromptText("Minutes");
		
		lengthsInput = new TextField();
		lengthsInput.setPromptText("Seconds");
		
		ratingInput = new TextField();
		ratingInput.setPromptText("Personal rating out of /5");
		
		
		Button addButton = new Button();
		addButton.setOnAction(e -> addButtonClicked());
		Button deleteButton = new Button();
		deleteButton.setOnAction(e -> deleteButtonClicked());
		Button closeButton = new Button();
		closeButton.setOnAction(e -> closeButtonClicked());
	
		addButton.setText("Add a Song!");
		deleteButton.setText("Delete a Song!");
		closeButton.setText("Shut Down");
	
		HBox hBox = new HBox();
		hBox.setPadding(new Insets(10,10,10,10));
		hBox.setSpacing(10);
		hBox.getChildren().addAll(titleInput, artistInput, lengthmInput, lengthsInput, ratingInput, addButton, deleteButton, closeButton);
		
		
		
		
		
		VBox vBox = new VBox();
		vBox.getChildren().addAll(table, hBox);
		
		
		Scene scene = new Scene(vBox);
		app.setScene(scene);
		app.show();
		
	}
	
	public void addButtonClicked() {
		
		Songs songs = new Songs();
		songs.setTitle(titleInput.getText());
		songs.setArtist(artistInput.getText());
		songs.setLengthm(Integer.parseInt(lengthmInput.getText()));
		songs.setLengths(Integer.parseInt(lengthsInput.getText()));
		songs.setRating(Integer.parseInt(ratingInput.getText()));
		table.getItems().add(songs);
		titleInput.clear();
		artistInput.clear();
		lengthmInput.clear();
		lengthsInput.clear();
		ratingInput.clear();
			
	}
	
	public void deleteButtonClicked() {
		
		ObservableList<Songs> songSelected, allSongs;
		allSongs = table.getItems();
		songSelected = table.getSelectionModel().getSelectedItems();
		songSelected.forEach(allSongs:: remove);
	}
	
	public void closeButtonClicked() {
        app.close();
	}
	public ObservableList<Songs> getSongs(){
		
		ObservableList<Songs> songs = FXCollections.observableArrayList();
		return songs;
	}	

}
