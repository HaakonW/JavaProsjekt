/*
Filen inneholder AdminMainHjemGUI klassen.
Laget av Henrik Fischer Bjelland
Sist endret  09-04-2014
*/

package norskreseptregister.gui;

import java.awt.*;
import java.awt.event.*;
import static java.awt.font.TextAttribute.FONT;
import javax.swing.*;
import norskreseptregister.Reg.RegisterSystem;

class AdminMainHjemGUI extends JPanel
{
    //private JButton endreLisens, medisin;
    private JPanel panel2, panel1;
    private JLabel label1, label2, label3;
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
        
        label1 = new JLabel("Endre lisens");
        label1.setFont(new Font ("Arial", Font.ITALIC, 30)); // Evig DØLL MÅ SKIFTES SENERE
        label2 = new JLabel("Registrer medisin");
        label2.setFont(new Font ("Arial", Font.ITALIC, 30)); // Evig DØLL MÅ SKIFTES SENERE
        
        knapp1.setFocusPainted(false);
        knapp2.setFocusPainted(false);
        
        knapp1.setToolTipText("Endre lisens for lege");
        knapp2.setToolTipText("Registrer ny medisin");        
       
        
        GridBagConstraints gc = new GridBagConstraints();
        setLayout(new GridBagLayout());      
        
        gc.gridx = 0;
        gc.gridy = 1; 
        gc.insets = new Insets(10,10,10,10);
        add(knapp1, gc);
        
        gc.gridx = 1;
        gc.gridy = 1;
        add(knapp2, gc);
        
        gc.gridx = 0;
        gc.gridy = 2;
        add(label1, gc);
        
        gc.gridx = 1;
        gc.gridy = 2;
        add(label2, gc);
    }//end of konstruktør

}//end of class AdminMainHjemGUI
