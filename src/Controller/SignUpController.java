package Controller;

import java.io.IOException;
import java.util.Arrays;
import java.util.HashSet;

import Model.classes.Database;
import Model.classes.User;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

public class SignUpController extends ControllerAbs {
	
	final int MIN_Uppercase = 1;
	final int Special = 1;
	int uppercaseCounter = 0;
	int specialCounter = 0;
	
	ObservableList<String> questionList = FXCollections.
			observableArrayList("What was your favorite food as a child?","What was the name of your first school?"
					,"What car brands do you like?","Who is your famous actor/actress?");
	
	@FXML
    private ComboBox questionBox;
	
	@FXML
	private TextField answerID;
	
    @FXML
    private TextField passwordID;

    @FXML
    private TextField userID;
    
    @FXML
    private Label errorLabel;
    
    
    private String username = "";
	private String password = "";
	private String answer = "";
	private String question= "";
	
	// This method sets items to the combobox
	@FXML
	private void initialize() 
	{
		questionBox.setItems(questionList);
	}
	
	/* This method will first check if the isLegal returns true or false,
	 * then it creates an user by calling addUser method from database
	 */
    @FXML
    public void createButton(ActionEvent event) throws IOException
	{
    	if(!isLegal()) {
    		return;
    	}

    	if (!Database.getInstance().addUser(new User(username, password, question, answer))) {
    		return;
    	}
		getLoginPage();
	}
    
    //This method will record the question chosen in the menu.
    
    @FXML
    public void getSelectedQuestion() 
    {   	
    	question = questionBox.getSelectionModel().getSelectedItem().toString();
    }

    //This method will record the user name entered in the text field.
    
    public void getUsername()
	{
		username = userID.getText();
	}
	
	//This method will record the password entered in the text field.
    
	public void getPassword()
	{
		password = passwordID.getText();
	}
	
	//This method will record the answer entered in the text field.
	
	public void getAnswer() 
	{
		answer = answerID.getText();
	}
	
	/* This method is to check if username and password are greater than 0 characters,
	 * check if the password meets the criteria.
	 * Pops up an error message if the password doesn't meet the requirements
	 */
	public boolean isLegal()
	{
		getUsername();
		getPassword();
		getSelectedQuestion();
		getAnswer();
		
		 for (int i = 0; i < password.length(); i++ ) {
             char c = password.charAt(i);
             if(Character.isUpperCase(c)) 
                   uppercaseCounter++;
             if ((c >=32 && c <= 44) || (c >= 58 && c <= 64) || (c >=91 && c <= 96) || (c >= 123 && c <= 126))
             {
            	 specialCounter++;
             }
		 }
		 if(username.length() >1 && password.length() >= 8 && answer.length() >1 && question.length() != 0
				 && uppercaseCounter >= MIN_Uppercase && specialCounter >= Special) 
		 {
			 hideErrorMessage();
			 return true;
		 }else 
			 {
			 	displayErrorMessage();
			 	return false;
			 }
	}
}

