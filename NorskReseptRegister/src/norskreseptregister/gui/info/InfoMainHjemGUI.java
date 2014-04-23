/*
Filen inneholder AdminMainHjemGUI klassen.
Laget av Henrik Fischer Bjelland
Sist endret  09-04-2014
*/

package norskreseptregister.gui.info;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import norskreseptregister.Reg.RegisterSystem;
import norskreseptregister.gui.LegeLisensGUI;

class InfoMainHjemGUI extends JPanel
{
    private JButton knapp1, knapp2, knapp3, knapp4, knapp5, knapp6;
    private JPanel panel3, panel2, panel1;
    private JLabel label1, label2, label3;
    LegeLisensGUI paneltest;
    private RegisterSystem system;

    public InfoMainHjemGUI()
    {
        this.paneltest = new LegeLisensGUI(system);
        ImageIcon legeinf = new ImageIcon("src/norskreseptregister/gui/bilder/docinfo.png");
        ImageIcon pasinf = new ImageIcon("src/norskreseptregister/gui/bilder/pasinfo.png");
        ImageIcon medinf = new ImageIcon("src/norskreseptregister/gui/bilder/epille.png");
        
        knapp1 = new JButton(pasinf);
        knapp2 = new JButton(legeinf);
        knapp3 = new JButton(medinf);
        
        knapp1.setFocusPainted(false);
        
        knapp1.setToolTipText("Info om pasient");
        knapp2.setToolTipText("Info om lege");
        knapp3.setToolTipText("Info om medisin");
        
        label1 = new JLabel("LegeInfo");
        label1.setFont(new Font ("georgia", Font.BOLD, 20)); // Evig DØLL MÅ SKIFTES SENERE
        label2 = new JLabel("PasientInfo");
        label2.setFont(new Font ("palatino", Font.ITALIC, 20)); // Evig DØLL MÅ SKIFTES SENERE
        label3 = new JLabel("MedisinInfo");
        label3.setFont(new Font ("baskerville", Font.ROMAN_BASELINE, 20)); // Evig DØLL MÅ SKIFTES SENERE
        
        
   
        
        GridBagConstraints gc = new GridBagConstraints();
        setLayout(new GridBagLayout());
        
        int x = 0;
        int y= 0;
     
        
        gc.gridx = 0;
        gc.gridy = ++y;
        gc.insets = new Insets(10,10,10,10);
        add(knapp1, gc);
        
        gc.gridx = ++x;
        gc.gridy = y;
        add(knapp2, gc);
        
        gc.gridx = ++x;
        gc.gridy = y;
        add(knapp3, gc);
        
        x = 0;
        
        gc.gridx = x;
        gc.gridy = ++y;
        add(label1,gc);
                
        gc.gridx = ++x;
        gc.gridy = y;
        add(label2, gc); 
        
        gc.gridx = ++x;
        gc.gridy = y;
        add(label3,gc);
    }

}//end of class AdminMainHjemGUI
