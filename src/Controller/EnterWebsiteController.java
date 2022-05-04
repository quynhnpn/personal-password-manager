package Controller;

import java.io.IOException;

import Controller.SearchResultsController;
import Model.classes.User;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;

public class EnterWebsiteController extends ControllerAbs{
	
	public Stage primaryStage = application.Main.window;
	
	private User user;
	@FXML
    private TextField WebsiteName;
	
	@FXML
	private Label expiredAccountsWarning;
	
	// This method sets text for the warning sign label
	@FXML
	public void initialize() {
		expiredAccountsWarning.setText("Number of expired accounts: " + user.getNumberOfExpiredAcc());
	}
	
	// This method is to get the current user object
	public EnterWebsiteController(User user) {
		this.user = user;
		System.out.println("User: " + user);
	}
	// This method switch scene to AddWebsitePage
	@FXML
    public void SwitchSceneToAddWebsitePage(ActionEvent event) throws IOException {
		getAddWebsitePage(user);
    }
	// This method switch scene to EnterWebsitePage
	@FXML
    public void SwitchSceneToEnterWebsitePage(MouseEvent event) throws IOException {
		getEnterWebsitePage(user);
    }

}
