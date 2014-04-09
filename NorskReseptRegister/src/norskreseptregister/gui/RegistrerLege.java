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
    private JTextField l_fornavn, l_etternavn, l_adresse;
    private JLabel etternavnLege, fornavnLege, adresseLege; // hva skjer her egentlig?
    private JTextArea legeutskrift;
    private JButton registrer, avbryt;
    //private JCheckBox a, b, c;
    //private JRadioButton bevilgning, bevilgningFalse;
    RegisterSystem system;
    
    public RegistrerLege()
    {
        this.system = system;
        /*a = new JCheckBox("A");
        Knappelytter handler = new Knappelytter();
        a.addActionListener (handler);
        b = new JCheckBox("B");
        b.addActionListener (handler);
        c = new JCheckBox("C");
        c.addActionListener (handler);*/
        etternavnLege = new JLabel("Fornavn   ");
        fornavnLege = new JLabel("Etternavn ");
        adresseLege = new JLabel("Adresse   ");
        l_etternavn = new JTextField(40);
        l_fornavn = new JTextField(40);
        l_adresse = new JTextField(40);
        registrer = new JButton("Registrer Lege");
        avbryt = new JButton("Avbryt");
        /*bevilgning = new JRadioButton();
        bevilgning.setText("Har bevilgning");
        bevilgningFalse = new JRadioButton();
        bevilgningFalse.setText("har IKKE bevilgning");*/
        legeutskrift = new JTextArea(15, 45);
        legeutskrift.setEditable(false);
        
        add(etternavnLege);              
        add(l_etternavn);
        add(fornavnLege);
        add(l_fornavn);
        add(adresseLege);
        add(l_adresse);
        add(legeutskrift);
        add(registrer);
        add(avbryt);
    }//end of konstruktør RegistrerLege
    
    private void Commit()
    { 
       Lege lege = new Lege(l_fornavn.getText(), l_etternavn.getText(), l_adresse.getText());
       system.getLegeRegister().SettInn(lege);
    }
    
    public void TomFelt()
    {
        l_fornavn.setText("");
        l_etternavn.setText("");
        l_adresse.setText("");
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