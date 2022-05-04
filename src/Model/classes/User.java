package Model.classes;

import java.util.ArrayList;
import java.util.Date;

public class User implements java.io.Serializable {
    private static final long serialVersionUID = 1L;
	private String userName;
    private String masterPassword;
    private String securityQuestion;
    private String securityAnswer;
    private ArrayList<Account> accounts;

    public User(String userName, String masterPassword, String securityQuestion, String securityAnswer) 
    {
        this.userName = userName;
        this.masterPassword = masterPassword;
        this.securityQuestion = securityQuestion;
        this.securityAnswer = securityAnswer;
        this.accounts = new ArrayList<>();
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getMasterPassword() {
        return masterPassword;
    }

    public void setMasterPassword(String masterPassword) {
        this.masterPassword = masterPassword;
    }

    public String getSecurityQuestion() {
        return securityQuestion;
    }

    public void setSecurityQuestion(String securityQuestion) {
        this.securityQuestion = securityQuestion;
    }
    
    public String getSecurityAnswer() {
        return securityAnswer;
    }

    public void setSecurityAnswer(String securityAnswer) {
        this.securityAnswer = securityAnswer;
    }

    public ArrayList<Account> accounts() {
        return accounts;
    }

    public void setAccountArrayList(ArrayList<Account> accounts) {
        this.accounts = accounts;
    }
    
    public Account searchAccount( String inPut) {
    	for (Account account : accounts)
    	{
    		if (inPut == account.getAccountName() || inPut == account.getUserName())
    			return account;
    	}
		return null;  	
    }

    /**
     * This method supports addAccount feature
     * @param
     */
    public boolean addAccount (Account newItem) {
        for (Account account : accounts) {
            if (account.getAccountName() == newItem.getAccountName()) {
                System.out.println("Item already exists.");
                return false;
            }
        }
        accounts.add(newItem);
        System.out.println("New item added.");
        return true;
    }

    public int getNumberOfExpiredAcc() {
        int counter = 0;
        for (Account account : accounts) {
            if (account.isExpired()) {
                counter++;
            }
        }
        System.out.println("Number of expired accounts: " + counter);
        return counter;
    }
}
