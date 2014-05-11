/*
 Filen inneholder klassen RegMainGUI.
 Laget av  Henrik Fischer Bjelland, Haakon Winther, Peter Wilhelmsen 
 Sist endret 27-04-2014 
 */
package norskreseptregister.gui.regGUI;

import java.awt.*;
import javax.swing.*;
import norskreseptregister.ObjektKlasser.Medisinliste;
import norskreseptregister.Reg.RegisterSystem;

//
public class RegMainGUI extends JPanel
{
    private JTabbedPane tabbedPane;
    RegistrerPasient tab1;
    RegistrerLege tab2;
    RegistrerResept tab3;
    private RegisterSystem system;
    RegMainHjemGUI panel1 = new RegMainHjemGUI(this);
    private Medisinliste medisinliste;

    public RegMainGUI(RegisterSystem system, Medisinliste medisinliste)
    {
        this.system = system;
        this.medisinliste = medisinliste;
        tab1 = new RegistrerPasient(system.getPasientRegister());
        tab2 = new RegistrerLege(system.getLegeRegister());
        tab3 = new RegistrerResept(system, medisinliste);
        tabbedPane = new JTabbedPane();

        ImageIcon hjem = new ImageIcon("src/norskreseptregister/gui/bilder/hjem.png");
        ImageIcon doktor = new ImageIcon("src/norskreseptregister/gui/bilder/ikondoktor.png");
        ImageIcon pasienten = new ImageIcon("src/norskreseptregister/gui/bilder/ikonperson.png");
        ImageIcon resept = new ImageIcon("src/norskreseptregister/gui/bilder/ikonresept.png");

        tabbedPane.addTab("Hjem", hjem, panel1, "Hjem");
        tabbedPane.addTab("Registrer Pasient", pasienten, tab1, "Registrer pasient");
        tabbedPane.addTab("Registrer Lege", doktor, tab2, "Registrer Lege");
        tabbedPane.addTab("Registrer Resept", resept, tab3, "Registrer Resept");
        add(tabbedPane);
    }

    // Get-metode for å kunne hente ut 
    public JTabbedPane getTabbedPane()
    {
        return tabbedPane;
    }

}//end of class RegMainGUI