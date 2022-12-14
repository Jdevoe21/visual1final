/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package fproject.window;

import com.google.gson.Gson;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Jack
 */
public class CompanyAPI {
    private static final String apiHost = "https://autocomplete.clearbit.com/v1/companies/suggest?query=";
    private URL url;
    private HttpURLConnection con;
    
    public CompanyAPI(){
        
    }
    
    public Company[] query(String q){
        Gson gson = new Gson();
        try {
            url = new URL(apiHost + q);
            con = (HttpURLConnection) url.openConnection();
            BufferedReader in = new BufferedReader(new InputStreamReader(con.getInputStream()));
            return gson.fromJson(in, Company[].class);
        } catch (MalformedURLException ex) {
            Logger.getLogger(CompanyAPI.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(CompanyAPI.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }
    
}
