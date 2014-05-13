/*
 Filen inneholder klassen InfoMainGUI.
 Laget av Haakon Winther
 Sist endret 09-04-2014
 */
package norskreseptregister.gui.info;

import javax.swing.*;
import norskreseptregister.ObjektKlasser.Medisinliste;
import norskreseptregister.Reg.RegisterSystem;

// InfoMainGUI er klassen er der tab'sene blir opprettet og infoklassene blir knyttet til disse.
public class InfoMainGUI extends JPanel
{
    private JTabbedPane tabbedPane;
    InfoMainHjemGUI hjempanel;
    LegeInfoGUI legeinfopanel;
    PasientInfoGUI pasientinfopanel;
    MedisinInfoGUI medisininfopanel;
    private Medisinliste medisinliste;

    public InfoMainGUI(RegisterSystem system, Medisinliste medisinliste)
    {
        this.medisinliste = medisinliste;
        hjempanel = new InfoMainHjemGUI(this);
        legeinfopanel = new LegeInfoGUI(system);
        pasientinfopanel = new PasientInfoGUI(system);
        medisininfopanel = new MedisinInfoGUI(system, medisinliste);
        tabbedPane = new JTabbedPane();
        
        ClassLoader cl = this.getClass().getClassLoader();
        ImageIcon hjem = new ImageIcon(cl.getResource("norskreseptregister/gui/bilder/hjem.png"));
        ImageIcon epille = new ImageIcon(cl.getResource("norskreseptregister/gui/bilder/ikonpille.png"));
        ImageIcon docinfo = new ImageIcon(cl.getResource("norskreseptregister/gui/bilder/ikondocinfo.png"));
        ImageIcon pasinfo = new ImageIcon(cl.getResource("norskreseptregister/gui/bilder/ikonpasinfo.png"));

        tabbedPane.addTab("Hjem", hjem, hjempanel, "Hjem");
        tabbedPane.addTab("Legeinfo", docinfo, legeinfopanel, "Lege");
        tabbedPane.addTab("PasientInfo", pasinfo, pasientinfopanel, "Pasient");
        tabbedPane.addTab("Medisininfo", epille, medisininfopanel, "Legemiddel");
        add(tabbedPane);
    }

    //Get metode for TabbedPane
    public JTabbedPane getTabbedPane()
    {
        return tabbedPane;
    }

}//end of class InfoMainGUI
