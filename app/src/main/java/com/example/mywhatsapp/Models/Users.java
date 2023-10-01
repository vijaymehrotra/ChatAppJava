package com.example.mywhatsapp.Models;

public class Users {
    String profilepic, username, mail ,password, userId,lastmessage;

    //SignIn Constructor
    public Users(String profilepic, String username, String mail, String password, String userId, String lastmessage) {
        this.profilepic = profilepic;
        this.username = username;
        this.mail = mail;
        this.password = password;
        this.userId = userId;
        this.lastmessage = lastmessage;
    }

    public String getUserId() {
        return userId;
    }

    public Users(){}

    //SignUp Constructor
    public Users( String username, String mail, String password) {
        this.username = username;
        this.mail = mail;
        this.password = password;
    }

    public void setProfilepic(String profilepic) {
        this.profilepic = profilepic;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public void setMail(String mail) {
        this.mail = mail;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public void setLastmessage(String lastmessage) {
        this.lastmessage = lastmessage;
    }

    public String getProfilepic() {
        return profilepic;
    }

    public String getUsername() {
        return username;
    }

    public String getMail() {
        return mail;
    }

    public String getPassword() {
        return password;
    }

    public String getUserId(String key) {
        return userId;
    }

    public String getLastmessage() {
        return lastmessage;
    }
}
