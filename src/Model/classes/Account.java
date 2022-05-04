package Model.classes;

import java.util.Calendar;
import java.util.Date;

public class Account implements java.io.Serializable {
    private static final long serialVersionUID = 1L;
	private String accountName;
    private String urlName;
    private String userName;
    private String password;
    private String email;
    private Date expirationDate;

    public Account (String accountName, String urlName, String userName, String password, String email) {
        this.accountName = accountName;
        this.urlName = urlName;
        this.userName = userName;
        this.password = password;
        this.email = email;

        // set expirationDate once object is instantiated
        Date date = new Date(); //current date
        Calendar cal = Calendar.getInstance();
        cal.setTime(date);
        cal.add(Calendar.MONTH, 6);
        this.expirationDate = cal.getTime();
        System.err.println(expirationDate);
    }

    public String getAccountName() {
        return accountName;
    }

    public void setAccountName(String accountName) {
        this.accountName = accountName;
    }

    public String getUrlName() {
        return urlName;
    }

    public void setUrlName(String urlName) {
        this.urlName = urlName;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

	public Date getExpirationDate() {
		return expirationDate;
	}

	public void setExpirationDate(Date expirationDate) { this.expirationDate = expirationDate; }

    public boolean isExpired() {
        if (expirationDate.before(new Date())) {
            return true;
        }
        return false;
    }
}
