/*
Filen inneholder klassen RegMainHjemGUI.
Laget av  Henrik Fischer Bjelland
Sist endret 09-04-2014 
*/

package norskreseptregister.gui.regGUI;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.*;

class RegMainHjemGUI extends JPanel implements ActionListener
{
    private JButton regPasient, regLege, regResept;
    private JPanel panel1, panel2;
    private JLabel label1, label2, label3;
    private final RegMainGUI regMainGUI;

    public RegMainHjemGUI(RegMainGUI regMainGUI)
    {
        this.regMainGUI = regMainGUI;
        ImageIcon regLeg = new ImageIcon("src/norskreseptregister/gui/bilder/doktor.png");
        ImageIcon regPas = new ImageIcon("src/norskreseptregister/gui/bilder/person.png");
        ImageIcon regRes = new ImageIcon("src/norskreseptregister/gui/bilder/Resept.png");
        regPasient= new JButton(regPas);
        regLege = new JButton(regLeg);
        regResept = new JButton(regRes);
        
        regPasient.setFocusPainted(false);
        regLege.setFocusPainted(false);
        regResept.setFocusPainted(false);
        
        regPasient.addActionListener(this);
        regLege.addActionListener(this);
        regResept.addActionListener(this);
        
        regPasient.setToolTipText("Registrer pasient");
        regLege.setToolTipText("Registrer lege");
        regResept.setToolTipText("Registrer resept");
        
        label1 = new JLabel("Registrer Pasient");
        label1.setFont(new Font ("PT Serif", Font.PLAIN, 20)); 
        label2 = new JLabel("Registrer Lege");
        label2.setFont(new Font ("PT Serif", Font.PLAIN, 20)); 
        label3 = new JLabel("Registrer Resept");
        label3.setFont(new Font ("PT Serif", Font.PLAIN, 20)); 
               
        panel2 = new JPanel();
        panel2.add(regPasient);
        panel2.add(regLege);
        panel2.add(regResept);
         
        GridBagConstraints gc = new GridBagConstraints();
        setLayout(new GridBagLayout());
       
        int x = 0;
        int y= 0;
     
        gc.gridx = 0;
        gc.gridy = ++y;
        gc.insets = new Insets(10,10,10,10);
        add(regPasient, gc);
        
        gc.gridx = ++x;
        gc.gridy = y;
        add(regLege, gc);
        
        gc.gridx = ++x;
        gc.gridy = y;
        add(regResept, gc);
        
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

    public void actionPerformed( ActionEvent e )
    {
       if (e.getSource() ==  regPasient)
       {
           regMainGUI.getTabbedPane().setSelectedIndex(1);
       } 
       else if (e.getSource() == regLege)
       {
           regMainGUI.getTabbedPane().setSelectedIndex(2); 
       }
        else if (e.getSource() == regResept)
       {
            regMainGUI.getTabbedPane().setSelectedIndex(3);
       }
    }
}//end of class RegMainHjemGUI
