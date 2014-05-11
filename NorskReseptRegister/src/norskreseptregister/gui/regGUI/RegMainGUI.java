/*
 Filen inneholder klassen RegMainGUI.
 Laget av  Henrik Fischer Bjelland, Haakon Winther, Peter Wilhelmsen 
 Sist endret 11-05-2014 
 */
package norskreseptregister.gui.regGUI;

import javax.swing.*;
import norskreseptregister.ObjektKlasser.Medisinliste;
import norskreseptregister.Reg.RegisterSystem;

// RegMainGUI er klassen er der tab'sene blir opprettet og registreringsklassene blir knyttet til disse.
public class RegMainGUI extends JPanel
{
    private JTabbedPane tabbedPane;
    RegistrerPasient pasienttab;
    RegistrerLege legetab;
    RegistrerResept resepttab;
    private RegisterSystem system;
    RegMainHjemGUI panel1 = new RegMainHjemGUI(this);
    private Medisinliste medisinliste;

    public RegMainGUI(RegisterSystem system, Medisinliste medisinliste)
    {
        this.system = system;
        this.medisinliste = medisinliste;
        pasienttab = new RegistrerPasient(system.getPasientRegister());
        legetab = new RegistrerLege(system.getLegeRegister());
        resepttab = new RegistrerResept(system, medisinliste);
        tabbedPane = new JTabbedPane();

        ImageIcon hjem = new ImageIcon("src/norskreseptregister/gui/bilder/hjem.png");
        ImageIcon doktor = new ImageIcon("src/norskreseptregister/gui/bilder/ikondoktor.png");
        ImageIcon pasienten = new ImageIcon("src/norskreseptregister/gui/bilder/ikonperson.png");
        ImageIcon resept = new ImageIcon("src/norskreseptregister/gui/bilder/ikonresept.png");

        tabbedPane.addTab("Hjem", hjem, panel1, "Hjem");
        tabbedPane.addTab("Registrer Pasient", pasienten, pasienttab, "Registrer pasient");
        tabbedPane.addTab("Registrer Lege", doktor, legetab, "Registrer Lege");
        tabbedPane.addTab("Registrer Resept", resept, resepttab, "Registrer Resept");
        add(tabbedPane);
    }

    // Get-metode for å kunne hente ut hvilke tab som er trykket på
    public JTabbedPane getTabbedPane()
    {
        return tabbedPane;
    }

}//end of class RegMainGUI
