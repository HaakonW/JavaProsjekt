/*
 * Filen inneholder klassen RegistrerLege.
 * Laget av  Henrik 
 * Sist endret 09-04-2014 
 */

package norskreseptregister.gui;

import java.awt.*;
import java.awt.event.*;
import java.awt.image.*;
import java.io.*;
import javax.imageio.*;
import javax.swing.*;
import norskreseptregister.Lege;
import norskreseptregister.RegisterSystem;

public class RegistrerLege extends JPanel
{
    private JButton regLege, sjekkLege;
    private JTextField fornavnfelt, etternavnfelt, adressefelt;
    private JLabel fornavnlabel, etternavnlabel, adresselabel; 
    private JTextArea legeutskrift;
    private JButton registrer, avbryt;
    private JPanel panel1, panel2, panel3, panel4, panel5;
    //private JCheckBox a, b, c;
    //private JRadioButton bevilgning, bevilgningFalse;
    RegisterSystem system;
    
    public RegistrerLege()
    {
        this.system = system;
        fornavnlabel = new JLabel("Fornavn   ");
        etternavnlabel = new JLabel("Etternavn ");
        adresselabel = new JLabel("Adresse   ");
        etternavnfelt = new JTextField(20);
        fornavnfelt = new JTextField(20);
        adressefelt = new JTextField(20);
        registrer = new JButton("Registrer Lege");
        avbryt = new JButton("Avbryt");
        legeutskrift = new JTextArea(20, 20);
        legeutskrift.setEditable(false);        
        
        
        
        /////PANEL START////
        panel1 = new JPanel();
        panel1.add(fornavnlabel);
        panel1.add(fornavnfelt);
        
        panel2 = new JPanel();
        panel2.add(etternavnlabel);
        panel2.add(etternavnfelt);
        
        panel3 = new JPanel();
        panel3.add(adresselabel);
        panel3.add(adressefelt);
        
        panel4 = new JPanel();
        panel4.add(registrer);
        panel4.add(avbryt);
        
        panel5 = new JPanel();
        panel5.add(legeutskrift);
        
        //// GRID START ////
        GridBagConstraints gc = new GridBagConstraints();
        setLayout(new GridBagLayout());
        
        gc.gridx = 0;
        gc.gridy = 0;
        gc.insets = new Insets(10, 5, 5, 10);
        gc.anchor = GridBagConstraints.WEST;
        gc.fill = GridBagConstraints.HORIZONTAL;
        add(panel1, gc);
        
        gc.gridx = 0;
        gc.gridy = 1;
        add(panel2, gc);
        
        gc.gridx = 0;
        gc.gridy = 2;
        gc.anchor = GridBagConstraints.WEST;
        add(panel3, gc);
        
        gc.gridx = 0;
        gc.gridy = 3;
        add(panel4, gc);
        
        gc.gridx = 2;
        gc.gridy = 0; 
        gc.gridheight = 6;
        add(panel5, gc);
       
    }//end of konstruktør RegistrerLege
    
    private void Commit()
    {
        
       Lege lege = new Lege(fornavnfelt.getText(), etternavnfelt.getText(), adressefelt.getText());

       system.getLegeRegister().SettInn(lege);       
        
    }
    
   
    
    public void TomFelt()
    {
        fornavnfelt.setText("");
        etternavnfelt.setText("");
        adressefelt.setText("");
    }
        //privat lytteklasse som plukker opp trykk å
    private class Knappelytter implements ActionListener
    {
        public void actionPerformed( ActionEvent e )
        {
           if (e.getSource() ==  registrer)
           {
                Commit();
                TomFelt();
            } 
           else if (e.getSource() == avbryt)
           {
                TomFelt();
           }
        }
        
    }//end of class Knappelytter
    
}//end of class RegistrerLege