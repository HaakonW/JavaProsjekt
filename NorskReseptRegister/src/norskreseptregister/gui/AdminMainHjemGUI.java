/*
Filen inneholder AdminMainHjemGUI klassen.
Laget av Henrik Fischer Bjelland
Sist endret  09-04-2014
*/

package norskreseptregister.gui;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import norskreseptregister.Reg.RegisterSystem;

class AdminMainHjemGUI extends JPanel
{
    //private JButton endreLisens, medisin;
    private JPanel panel2, panel1;
    private JLabel label1;
    private JButton knapp1, knapp2;
    LegeLisensGUI paneltest;
    private RegisterSystem system;

    public AdminMainHjemGUI()
    {
        this.paneltest = new LegeLisensGUI(system);
        //endreLisens = new JButton("Endre Lisens");
        //medisin = new JButton("Registrer Medisin");
        ImageIcon modLeg = new ImageIcon("src/norskreseptregister/gui/bilder/Refresh-icon.png");
        ImageIcon regPill = new ImageIcon("src/norskreseptregister/gui/bilder/epille.png");
        
        label1 = new JLabel("Velkommen til Admindelen av programmet. Her kan du oppdatere en lege sin lisens eller legge inn nye medisiner");
        label1.setBorder(BorderFactory.createEtchedBorder(Color.LIGHT_GRAY, Color.black));
        
        knapp1 = new JButton(modLeg);
        knapp2 = new JButton(regPill);
        
        knapp1.setFocusPainted(false);
        knapp2.setFocusPainted(false);
        
        knapp1.setToolTipText("Endre lisens for lege");
        knapp2.setToolTipText("Registrer ny medisin");        
       
        
        GridBagConstraints gc = new GridBagConstraints();
        setLayout(new GridBagLayout());
        
        gc.gridx= 0;
        gc.gridy= 0;
        gc.insets = new Insets(0,20,40,20);
        gc.gridwidth = 3;         
        gc.fill = GridBagConstraints.HORIZONTAL;
        add(label1, gc);
        
        gc.gridx = 0;
        gc.gridy = 1; 
        gc.gridwidth = 1;
        gc.insets = new Insets(0,100,0,0);
        add(knapp1, gc);
        
        gc.gridx = 2;
        gc.gridy = 1;
        gc.gridwidth = 1;
        gc.fill = GridBagConstraints.NONE;
        add(knapp2, gc);
    }
    
  
    
}//end of class AdminMainHjemGUI
