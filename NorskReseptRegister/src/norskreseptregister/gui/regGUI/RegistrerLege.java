/*
Filen inneholder klassen RegistrerLege.
Laget av  Henrik Fischer Bjelland, Haakon Winther
Sist endret 09-04-2014  
*/

package norskreseptregister.gui.regGUI;

import java.awt.event.*;
import javax.swing.*;
import norskreseptregister.ObjektKlasser.Lege;
import norskreseptregister.Reg.LegeRegister;
import java.util.List;

public class RegistrerLege extends RegistrerPersonGUI implements ActionListener
{
    private LegeRegister legeRegister;
    //private RegEx regex;
    
    public RegistrerLege(LegeRegister legeRegister)
    {
        super("Adresse    ", "");
        this.legeRegister = legeRegister;
        reg.addActionListener(this);
        
       
    }//end of konstruktør RegistrerLege

    private void nyLege()
    {
        String tekst="";
        
        if(sjekkFornavn(fornavnfelt.getText()) && sjekkEtternavn(etternavnfelt.getText()) && sjekkAdresse(infofelt.getText()))
        {
            Lege ny = new Lege(fornavnfelt.getText(), etternavnfelt.getText(), 
                                infofelt.getText());
            legeRegister.SettInn(ny);
            utskrift.setText("Registrert Lege: \n" + ny.toString());
        }
        else
        {
            if(!sjekkFornavn(fornavnfelt.getText()))
            {
                tekst += "Feil i fornavn\n";
            }
            if(!sjekkEtternavn(etternavnfelt.getText()))
            {
                tekst += "Feil i etternavn\n";
            }
            if(!sjekkAdresse(infofelt.getText()))
            {
                tekst += "Feil i adresse\n";
            }
            utskrift.setText("Feil!\n" + tekst);
        }
       /* Lege ny = new Lege(fornavnfelt.getText(), etternavnfelt.getText(), 
                infofelt.getText());
        legeRegister.SettInn(ny);
        utskrift.setText("Registrert Lege: \n" + ny.toString()); */
    }

    private void SkrivUt()
    {
        String legeliste = "";
        List <Lege> list = legeRegister.FinnAlleObjekter();
        for (Lege lege : list)
        {
            legeliste+= lege.toString();
            legeliste +="\n\n";
        }
        utskrift.setText(legeliste);
    }
        
    public void actionPerformed( ActionEvent e )
    {
       if (e.getSource() ==  reg)
       {
            nyLege();
            TomFelt();
        } 
     
       if (e.getSource() == hjelper);
       {
          JOptionPane.showMessageDialog(null, "HJELP LEGE"); 
       }
    }
    
    
    public boolean sjekkFornavn(String fornavn)
    {  
 
        if(fornavn.matches("\\w.*"))
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
        
        if(etternavn.matches("\\w.*"))
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
    public boolean sjekkAdresse(String adresse)
    {
       if(infofelt.getText().matches("\\w.*"))
        {
            return true;
        }
        else
        {
            utskrift.setText("Adresse må være kun bokstaver.");
            return false;
        }
    }
    
}//end of class RegistrerLege