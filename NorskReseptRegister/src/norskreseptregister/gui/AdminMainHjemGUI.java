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
        label1.setFont(new Font ("PT Serif", Font.PLAIN, 20)); 
        label2 = new JLabel("Registrer medisin");
        label2.setFont(new Font ("PT Serif", Font.PLAIN, 20));
        
        knapp1.setFocusPainted(false);
        knapp2.setFocusPainted(false);
        
        knapp1.setToolTipText("Endre lisens for lege");
        knapp2.setToolTipText("Registrer ny medisin");     
        
        knapp1.addActionListener(this);
        knapp2.addActionListener(this);

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
    
    //Metode for å lytte på om knapp1 eller knapp2 er trykket på
    public void actionPerformed(ActionEvent e)
    {
        if (e.getSource() == knapp1)
        {
            
        }
    }

}//end of class AdminMainHjemGUI
