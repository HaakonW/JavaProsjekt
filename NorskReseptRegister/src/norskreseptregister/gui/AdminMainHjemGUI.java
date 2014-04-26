/*
Filen inneholder AdminMainHjemGUI klassen. 
Dette er det første vinduet du kommer til hvis du åpner Admin siden.
Her får du oversikt over hvilke funksjoner du kan gjøre i Adminvinduet.
Laget av Henrik Fischer Bjelland
Sist endret  09-04-2014
*/

package norskreseptregister.gui;

import java.awt.*;
import java.awt.event.*;
import static java.awt.font.TextAttribute.FONT;
import javax.swing.*;
import norskreseptregister.Reg.RegisterSystem;

class AdminMainHjemGUI extends JPanel implements ActionListener
{
    
    private JPanel panel1, panel2;
    private JLabel label1, label2, label3;
    private JButton endreLisens, regMed, statestikk;
    LegeLisensGUI paneltest;
    private RegisterSystem system;

    public AdminMainHjemGUI()
    {
        this.paneltest = new LegeLisensGUI(system);
        ImageIcon modLeg = new ImageIcon("src/norskreseptregister/gui/bilder/Refresh-icon.png");
        ImageIcon regPill = new ImageIcon("src/norskreseptregister/gui/bilder/epille.png");
        ImageIcon statistikk = new ImageIcon("src/norskreseptregister/gui/bilder/statistikk.png");        
        
        label1 = new JLabel("Endre Lisens");
        label1.setFont(new Font ("PT Serif", Font.PLAIN, 20));
        label2 = new JLabel("Registrer medisin");
        label2.setFont(new Font ("PT Serif", Font.PLAIN, 20));
        label3 = new JLabel("Statestikk");
        label3.setFont(new Font ("PT Serif", Font.PLAIN, 20));
        
        endreLisens = new JButton(modLeg);
        endreLisens.setFocusPainted(false);
        endreLisens.addActionListener(this);
        endreLisens.setToolTipText("Endre lisens for lege");
        
        regMed = new JButton(regPill);
        regMed.setFocusPainted(false);
        regMed.addActionListener(this);
        regMed.setToolTipText("Registrer ny medisin");
        
        statestikk = new JButton(statistikk);
        statestikk.setFocusPainted(false);
        statestikk.addActionListener(this);
        statestikk.setToolTipText("Statistikk"); 
               
        //GRID STARTER ///

        GridBagConstraints gc = new GridBagConstraints();
        setLayout(new GridBagLayout());  
        
        int x = 0;
        int y = 0;
        //FØRSTE RAD
        gc.gridx = x;
        gc.gridy = y; 
        gc.insets = new Insets(10,10,10,10);
        add(endreLisens, gc);
        
        gc.gridx = ++x;
        gc.gridy = y;
        add(regMed, gc);
        
        gc.gridx = ++x;
        gc.gridy = y;
        add(statestikk, gc);
        
        //ANDRE RAD Nullstiller x//
        x = 0;  
        
        gc.gridx = x;
        gc.gridy = ++y;
        add(label1, gc);
        
        gc.gridx = ++x;
        gc.gridy = y;
        add(label2, gc);
        
        gc.gridx = ++x;
        gc.gridy = y;
        add(label3, gc);
        
        
    }//end of konstruktør
    
    //Metode for å lytte på om knapp1 eller knapp2 er trykket på
    public void actionPerformed(ActionEvent e)
    {
        if (e.getSource() == endreLisens)
        {
            
        }
    }

}//end of class AdminMainHjemGUI
