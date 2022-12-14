/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package fproject.window;

import java.awt.Color;
import java.awt.Component;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.ListCellRenderer;

/**
 *
 * @author Jack
 */
public class CompanyRenderer extends JLabel implements ListCellRenderer<Company>{
    
    public CompanyRenderer(){
        setOpaque(true);
    }
    @Override
    public Component getListCellRendererComponent(JList<? extends Company> list, Company company, int index, boolean isSelected, boolean cellHasFocus) {
        String text = company.getName();
        ImageIcon icon  = company.getIcon();
        this.setText(text);
        if(icon != null)
            this.setIcon(icon);
        if (isSelected) {
            setBackground(Color.darkGray);
            setForeground(Color.WHITE);
        } 
        else {
            setBackground(Color.WHITE);
            setForeground(Color.BLACK);
        }
        return this;
    }
        
}
