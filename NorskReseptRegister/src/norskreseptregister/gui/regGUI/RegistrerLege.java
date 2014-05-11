/*
 Filen inneholder klassen RegistrerLege.
 Laget av  Henrik Fischer Bjelland, Haakon Winther
 Sist endret 09-04-2014  
 */
package norskreseptregister.gui.regGUI;

import java.awt.event.*;
import java.util.ArrayList;
import java.util.List;
import javax.swing.*;
import norskreseptregister.ObjektKlasser.Lege;
import norskreseptregister.Reg.LegeRegister;

// RegistrerLege er en subklasse av RegistrerPersonGUI. Klassen er ment for å kunne registrere en Lege
public class RegistrerLege extends RegistrerPersonGUI implements ActionListener
{
    private LegeRegister legeRegister;

    public RegistrerLege(LegeRegister legeRegister)
    {
        super("Adresse      ", "");
        this.legeRegister = legeRegister;
    }

    /* 
     Metode som sjekker om feltene er fylt ut korrekt, gir en feilmelding hvis de 
     ikke er og registrerer legen i registeret hvis alt er riktig fylt inn.
     */
    private void nyLege()
    {
        String tekst = "";

        if (sjekkFornavn(fornavnfelt.getText()) && sjekkEtternavn(etternavnfelt.getText()) 
                && sjekkAdresse(infofelt.getText()))
        {
            Lege ny = new Lege(fornavnfelt.getText(), etternavnfelt.getText(),
                    infofelt.getText());
            ArrayList<Lege> eksisterendeLeger = legeRegister.FinnObjekterSomMatcher(new FinnLegeData(ny));
            if (eksisterendeLeger.size() > 0)
            {
                utskrift.setText("Legen finnes allerede.");
                fornavnfelt.requestFocus();
            }
            else
            {
                legeRegister.SettInn(ny);
                utskrift.setText("Registrert Lege: \n" + ny.toString());
            }
        }
    }

    // Metode for å skrive ut alle legene i registeret.
    private void SkrivUt()
    {
        String legeliste = "";
        List<Lege> list = legeRegister.FinnAlleObjekter();
        for (Lege lege : list)
        {
            legeliste += lege.toString();
            legeliste += "\n\n";
        }
        utskrift.setText(legeliste);
    }

    // Metode for å lytte på hvilken knapp som er trykket på og kaller deretter på en spesifikk metode
    public void actionPerformed(ActionEvent e)
    {
        if (e.getSource() == reg)
        {
            nyLege();
            TomFelt();
        }
        else if (e.getSource() == hjelp)
        {
            JOptionPane.showMessageDialog(null, "HJELP PASIENT");
        }
    }
}//end of class RegistrerLege
