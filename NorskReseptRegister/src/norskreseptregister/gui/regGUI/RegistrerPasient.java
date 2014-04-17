/*
Filen inneholder klassen RegistrerPasient.
Laget av Henrik Fischer Bjelland, Haakon Winther
Sist endret 09-04-2014 
*/

package norskreseptregister.gui.regGUI;

import java.awt.*;
import java.io.*;
import javax.swing.*;
import java.util.List;
import javax.imageio.*;
import java.awt.image.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import norskreseptregister.ObjektKlasser.Pasient;
import norskreseptregister.Reg.PasientRegister;
import norskreseptregister.Reg.RegisterSystem;


public class RegistrerPasient extends RegistrerPersonGUI implements ActionListener
{
    private PasientRegister pasientRegister;
    private String pasientliste = "pasientliste.txt";
    
    public RegistrerPasient(PasientRegister pasientRegister)
    {
        super("Fødselsdato");
        this.pasientRegister = pasientRegister;       
        reg.addActionListener(this);
        vis.addActionListener(this);
 
    }//end of konstruktør
    
    private void nyPasient()
    {
        Pasient ny = new Pasient(fornavnfelt.getText(), etternavnfelt.getText(), 
                infofelt.getText());
        pasientRegister.SettInn(ny);
        utskrift.setText("Registrert pasient: \n" + ny.toString());
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
        if(e.getSource() == reg)
        {
            nyPasient();
            TomFelt();
        }
        if(e.getSource() == vis)
        {
            SkrivUt();
        }
    }
}//end of class Registrer Pasient