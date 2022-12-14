/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package fproject.window;

import java.io.Serializable;

/**
 *
 * @author Jack
 */
public class Account implements Serializable{
    private Company company;
    private String username;
    private String password;
    
    public Account(String uname, String pass, Company comp){
        username = uname;
        password = pass;
        company = comp;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
    
    public Object[] getRow(){
        Object[] row = {company.toString(), username, password};
        return row;
    }
}
