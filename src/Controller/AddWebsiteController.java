package Controller;

import java.io.IOException;

import Model.classes.Account;
import Model.classes.User;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;

public class AddWebsiteController extends ControllerAbs {

	private User user;

	final int MIN_Uppercase = 1;
	final int Special = 1;
	int uppercaseCounter = 0;
	int specialCounter = 0;
  
    @FXML
    private TextField nameID;
    
    @FXML
    private TextField urlID;
    
    @FXML
    private TextField usernameID;

    @FXML
    private TextField passwordID;
    
    @FXML
    private TextField emailID;
    
    @FXML
    private TextField retypePasswordID;

    
	private String name = "";
	private String url = "";
    private String username = "";
	private String password = "";
	private String email = "";
	private String retypePassword = "";

	// This method is to get the current user object
	public AddWebsiteController(User user) {
		this.user = user;
		System.out.println("User: " + user);
	}

	
	/* This method will first check if the isLegal returns true or false,
	 * then it creates an account in the user object by calling addAccount method from User class
	 */
    @FXML
    void AddButton(ActionEvent event) throws IOException 
    {
    	if(!isLegal()) {
    		return;
    	}
    	System.out.println("Adding account...");
    	user.addAccount(new Account(name, url, username, password, email));
    	
    	getEnterWebsitePage(user);
    }
    
    // This methods switches the scene to EnterWebsitePage
    @FXML
    void SwitchSceneToEnterWebsitePage(MouseEvent event) throws IOException {
    	getEnterWebsitePage(user);
    }
    
    //This method will record the website name entered in the text field.

    public void getWebsiteName() 
    {
    	name = nameID.getText();
    }
    
    //This method will record the url entered in the text field.
    
    public void getUrl() 
    {
    	url = urlID.getText();
    }
    
    //This method will record the user name entered in the text field.
    
    public void getUsername()
    {
    	username = usernameID.getText();
    }
    
    //This method will record the password entered in the text field.
    
    public void getPassword()
    {
    	password = passwordID.getText();
    }
    
    //This method will record the email entered in the text field.
    
    public void getEmail()
    {
    	email = emailID.getText();
    }
    
    //This method will record the retype password entered in the text field.
    
    public void getRetypePassword()
    {
    	retypePassword = retypePasswordID.getText();
    }
    
    /* This method is to check if username and password are greater than 0 characters,
	 * check if all the information text field in entered and the password meets the criteria.
	 * Pop up error message if the requirements doesn't meet.
	 */
    
    public boolean isLegal()
	{
		getUsername();
		getPassword();
		getRetypePassword();
		getWebsiteName();
		getUrl();
		getEmail();
		
		for (int i=0; i < password.length(); i++ ) {
            char c = password.charAt(i);
            if(Character.isUpperCase(c)) 
                  uppercaseCounter++;
            if ((c >=32 && c <= 44) || (c >= 58 && c <= 64) || (c >=91 && c <= 96) || (c >= 123 && c <= 126))
            {
           	 specialCounter++;
            }
		 }
		 if(username.length() >1 && password.length() >= 8 && url.length() >=1 && email.length() >= 1 && name.length() >= 1 &&
				 retypePassword.equals(password) && uppercaseCounter >= MIN_Uppercase && specialCounter >= Special) 
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
