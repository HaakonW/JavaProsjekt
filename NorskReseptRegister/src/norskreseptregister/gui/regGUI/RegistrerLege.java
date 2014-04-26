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
    private RegEx regex;
    
    public RegistrerLege(LegeRegister legeRegister)
    {
        super("Adresse    ");
        this.legeRegister = legeRegister;
        reg.addActionListener(this);
        
       
    }//end of konstruktør RegistrerLege

    private void nyLege()
    {
        if(regex.sjekkFornavn(fornavnfelt.getText()) && regex.sjekkEtternavn(
                etternavnfelt.getText()) && regex.sjekkAdresse(infofelt.getText()))
        {
            Lege ny = new Lege(fornavnfelt.getText(), etternavnfelt.getText(), 
                                infofelt.getText());
            legeRegister.SettInn(ny);
            utskrift.setText("Registrert Lege: \n" + ny.toString());
        }
        else
        {
            utskrift.setText("Feil!");
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
    
}//end of class RegistrerLege