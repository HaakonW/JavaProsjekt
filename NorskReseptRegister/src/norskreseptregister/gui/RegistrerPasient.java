/*
 * Filen inneholder 
 * Laget av  * 
 * Sist endret  * 
 */

package norskreseptregister.gui;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.*;
import java.io.*;
import javax.imageio.*;
import javax.swing.*;
import norskreseptregister.Pasient;
import norskreseptregister.PasientRegister;
import norskreseptregister.RegisterSystem;
import java.util.List;
/**
 *
 * @author Henrik
 */

public class RegistrerPasient extends JPanel implements ActionListener
{
    private PasientRegister pasientRegister;
    private String pasientliste = "pasientliste.txt";
    private JTextField fornavnfelt, etternavnfelt, fodselsdatofelt;
    private JButton regPasient, visListe;
    private JTextArea utskrift;
    private String medisinlisten = "lagreMedisin.txt";
    
    
    public RegistrerPasient(PasientRegister pasientRegister)
    {
        this.pasientRegister = pasientRegister;
        fornavnfelt = new JTextField(40);
        etternavnfelt = new JTextField(40);
        fodselsdatofelt = new JTextField(40);
        regPasient = new JButton("Registrer");
        visListe = new JButton("Vis liste");
        utskrift = new JTextArea(15,45);
        
        regPasient.addActionListener(this);
        visListe.addActionListener(this);
        
        //liste = new Medisinliste();
        
        //For å lese listen ved oppstart
        //lesObjektFraFil();
        
        add( new JLabel("Fornavn   "));
        add(fornavnfelt);
        add( new JLabel("Etternavn   "));
        add(etternavnfelt);
        add( new JLabel("Fødselsdato   "));
        add(fodselsdatofelt);
        add(utskrift);
        add(regPasient);
        add(visListe);
        
        utskrift.setEditable(false); 
    }
    
    private void nyPasient()
    {
        /*Pasient ny = new Pasient(fornavnfelt.getText(), etternavnfelt.getText(), 
                fodselsdatofelt.getText()) {};
        pasientRegister.SettInn(ny);
        utskrift.setText("Registrert pasient: \n" + ny.toString());*/
    }
    
    private void TomFelt()
    {
        fornavnfelt.setText("");
        etternavnfelt.setText("");
        fodselsdatofelt.setText("");
    }
    
    private void SkrivUt()
    {
        String pasientliste = "";
        List <Pasient> list = pasientRegister.FinnAlle();
        for (Pasient pasient : list)
        {
            pasientliste+= pasient.toString();
            pasientliste +="\n\n";
        }
        utskrift.setText(pasientliste);
    }
    
    public void actionPerformed(ActionEvent e)
    {
        if(e.getSource() == regPasient)
        {
            nyPasient();
            TomFelt();
        }
        if(e.getSource() == visListe)
        {
            SkrivUt();
        }
    }
}//end of class Registrer Pasient