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
    
    public RegistrerPasient(PasientRegister pasientRegister)
    {
        super("Fødselsdato", "dd/mm/åååå");
        this.pasientRegister = pasientRegister;       
        reg.addActionListener(this);
        
 
    }//end of konstruktør
    
    private void nyPasient()
    {
        if(sjekkFornavn(fornavnfelt.getText()) && sjekkEtternavn(etternavnfelt.getText())
                        && sjekkFodselsdato(infofelt.getText()))
        {
            Pasient ny = new Pasient(fornavnfelt.getText(), etternavnfelt.getText(), 
                infofelt.getText());
        pasientRegister.SettInn(ny);
        utskrift.setText("Registrert pasient: \n" + ny.toString());
        }
        
    }
    
    private void SkrivUt()
    {
        String pasientliste = "";
        List <Pasient> list = pasientRegister.FinnAlleObjekter();
        for (Pasient pasient : list)
        {
            pasientliste+= pasient.toString();
            pasientliste +="\n\n";
        }
        utskrift.setText(pasientliste);
    }
    
    //RegEx for fornavn
    public boolean sjekkFornavn(String fornavn)
    {  
 
        if(fornavn.matches("^[a-zøæåéA-ZØÆÅ. \\-]{2,20}"))
        {
            return true;
        }
        else
        {
            utskrift.setText("Fornavnet må være kun bokstaver.");
            return false;
        } 
    }
    
    public boolean sjekkEtternavn(String etternavn)
    {
        
        if(etternavn.matches("^[a-zøæåéA-ZØÆÅ. \\-]{2,20}"))
        {
            return true;
        }
        else
        {
            utskrift.setText("Etternavnet må være kun bokstaver.");
            return false;
        }
    }
    
    //Metode for å sjekke adresse
    public boolean sjekkFodselsdato(String fodselsdato)
    {
       if(infofelt.getText().matches("\\d.*"))
        {
            return true;
        }
        else
        {
            utskrift.setText("Adresse må være kun bokstaver.");
            return false;
        }
    }
    
    public void actionPerformed(ActionEvent e)
    {
        if(e.getSource() == reg)
        {
            nyPasient();
            TomFelt();
        }
      
        if (e.getSource() == hjelper)
        {
            JOptionPane.showMessageDialog(null, "HJELP PASIENT");
        }
    }
}//end of class Registrer Pasient