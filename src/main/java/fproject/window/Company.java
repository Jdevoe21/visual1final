/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package fproject.window;

import java.awt.Desktop;
import java.awt.Image;
import java.io.IOException;
import java.io.Serializable;
import java.net.MalformedURLException;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.URL;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.imageio.ImageIO;
import javax.swing.ImageIcon;

/**
 *
 * @author Jack
 */
public class Company implements Serializable{
    private static int dim = 20;
    String name;
    String domain;
    String logo;
    
    @Override
    public String toString(){
        return name + ": " + domain;
    }
    
    public String getName(){
        return name;
    }
    public ImageIcon getIcon(){
        try {
            Image img = ImageIO.read(new URL(logo));
            Image scaled = img.getScaledInstance(dim, dim, Image.SCALE_SMOOTH);
            return new ImageIcon(scaled);
        } catch (MalformedURLException ex) {
            Logger.getLogger(Company.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(Company.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }
    
    public void navigate(){
        try {
            Desktop.getDesktop().browse(new URI(logo));
        } catch (URISyntaxException | IOException ex) {
            Logger.getLogger(Company.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
