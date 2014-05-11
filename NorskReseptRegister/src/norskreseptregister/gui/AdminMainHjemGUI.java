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

/* AdminMainHjemGUI er det første vinduet du kommer til hvis du åpner Admin siden.
Her får du oversikt over hvilke funksjoner du kan gjøre i Adminvinduet.
*/
public class AdminMainHjemGUI extends JPanel implements ActionListener
{
    private JPanel panel1, panel2;
    private JLabel label1, label2, label3;
    private JButton endreLisens, regMed, statistikk;
    LegeLisensGUI paneltest;
    private RegisterSystem system;
    private AdminMain adminMain;

    public AdminMainHjemGUI(AdminMain adminMain)
    {
        this.adminMain = adminMain;
        this.paneltest = new LegeLisensGUI(system);
        ImageIcon modLeg = new ImageIcon("src/norskreseptregister/gui/bilder/Refresh-icon.png");
        ImageIcon regPill = new ImageIcon("src/norskreseptregister/gui/bilder/epille.png");
        ImageIcon statistikkbilde = new ImageIcon("src/norskreseptregister/gui/bilder/statistikk.png");        
        
        label1 = new JLabel("Endre Lisens");
        label1.setFont(new Font ("PT Serif", Font.PLAIN, 20));
        label2 = new JLabel("Registrer medisin");
        label2.setFont(new Font ("PT Serif", Font.PLAIN, 20));
        label3 = new JLabel("Statistikk");
        label3.setFont(new Font ("PT Serif", Font.PLAIN, 20));
        
        endreLisens = new JButton(modLeg);
        endreLisens.setFocusPainted(false);
        endreLisens.addActionListener(this);
        endreLisens.setToolTipText("Endre lisens for lege");
        
        regMed = new JButton(regPill);
        regMed.setFocusPainted(false);
        regMed.addActionListener(this);
        regMed.setToolTipText("Registrer ny medisin");
        
        statistikk = new JButton(statistikkbilde);
        statistikk.setFocusPainted(false);
        statistikk.addActionListener(this);
        statistikk.setToolTipText("Statistikk"); 
               
        /* Her starter layouten for Hjemviduet til Admin. Som i de andre
        filene er int x og int y satt til 0 for å enkelt kunne utvide kolonner eller
        rader. Insets er satt til 10,10,10,10. Som igjen betyr avstanden til neste element.
        Insets kan leses som en klokke. Hel, kvart på, halv. */

        GridBagConstraints gc = new GridBagConstraints();
        setLayout(new GridBagLayout());  
        
        int x = 0;
        int y = 0;
        //Første rad
        gc.gridx = x;
        gc.gridy = y; 
        gc.insets = new Insets(10,10,10,10);
        add(endreLisens, gc);
        
        gc.gridx = ++x;
        gc.gridy = y;
        add(regMed, gc);
        
        gc.gridx = ++x;
        gc.gridy = y;
        add(statistikk, gc);
        
        //Andre rad. Nullstiller x verdien
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
        
    }// end of konstruktør
    
    // Metode for å lytte på om knapp1 eller knapp2 er trykket på
    public void actionPerformed(ActionEvent e)
    {
        if (e.getSource() == endreLisens)
        {
            adminMain.getTabbedPane().setSelectedIndex(1);
        }
        else if(e.getSource() == regMed)
        {
            adminMain.getTabbedPane().setSelectedIndex(2);
        }
        else if (e.getSource() == statistikk)
        {
            adminMain.getTabbedPane().setSelectedIndex(3);
        }
    }

}// end of class AdminMainHjemGUI
