package ro.ase.eu.aslapplication.clase;

/**
 * Created by Ileana Gheorghe on 3/20/2018.
 */

public class User {
    //int userId;
    String userName;
    String userEmail;
    String userPassword;

    public User(){

    }

    public User(String userName, String userEmail, String userPassword) {
        //this.userId = userId;
        this.userName = userName;
        this.userEmail = userEmail;
        this.userPassword = userPassword;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getUserEmail() {
        return userEmail;
    }

    public void setUserEmail(String userEmail) {
        this.userEmail = userEmail;
    }

    public String getUserPassword() {
        return userPassword;
    }

    public void setUserPassword(String userPassword) {
        this.userPassword = userPassword;
    }
}
