/*
Filen inneholder klassen RegistrerLege.
Laget av  Henrik Fischer Bjelland, Haakon Winther
Sist endret 09-04-2014  
*/

package norskreseptregister.gui.regGUI;

import java.awt.*;
import java.awt.event.*;
import java.awt.image.*;
import java.io.*;
import javax.imageio.*;
import javax.swing.*;
import norskreseptregister.ObjektKlasser.Lege;
import norskreseptregister.Reg.LegeRegister;
import norskreseptregister.Reg.RegisterSystem;
import java.util.List;

public class RegistrerLege extends RegistrerPersonGUI implements ActionListener
{
    private LegeRegister legeRegister;
    
    public RegistrerLege(LegeRegister legeRegister)
    {
        super("Adresse    ");
        this.legeRegister = legeRegister;
        reg.addActionListener(this);
        
       
    }//end of konstruktør RegistrerLege

    private void nyLege()
    {
        Lege ny = new Lege(fornavnfelt.getText(), etternavnfelt.getText(), 
                infofelt.getText());
        legeRegister.SettInn(ny);
        utskrift.setText("Registrert Lege: \n" + ny.toString());
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