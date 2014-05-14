/*
 Filen inneholder klassen AdminMain.
 Laget av  Peter Wilhelmsen, Haakon Winter, Henrik Fischer Bjelland
 Sist endret 09-04-2014
 */
package norskreseptregister.gui;

import java.awt.*;
import java.awt.event.*;
import java.awt.image.*;
import java.io.*;
import javax.imageio.*;
import javax.swing.ImageIcon;
import javax.swing.JPanel;
import javax.swing.JTabbedPane;
import norskreseptregister.ObjektKlasser.Medisin;
import norskreseptregister.ObjektKlasser.Medisinliste;
import norskreseptregister.Reg.RegisterSystem;

// Klassen inneholder tabsene
public class AdminMain extends JPanel
{
    private JTabbedPane tabbedPane;
    private AdminMainHjemGUI hjempanel;
    private final LegeLisensGUI legepanel;
    private RegistrerMedisinGUI medisinpanel;
    private StatistikkGUI statistikkpanel;
    private RegisterSystem system;
    private Medisinliste medisinliste;
    private MedisinTabell medisintabell;

    // Newer opp GUI klasser og legger disse til å forskjellige tabbedPanes
    public AdminMain(RegisterSystem system, Medisinliste medisinliste)
    {
        this.system = system;
        this.medisinliste = medisinliste;
        hjempanel = new AdminMainHjemGUI(this);
        legepanel = new LegeLisensGUI(system);
        medisinpanel = new RegistrerMedisinGUI(medisinliste);
        statistikkpanel = new StatistikkGUI(system, medisinliste, medisintabell);
        tabbedPane = new JTabbedPane();
        
        ClassLoader cl = this.getClass().getClassLoader();
        ImageIcon elege = new ImageIcon(cl.getResource("norskreseptregister/gui/bilder/ikonRefresh-icon.png"));
        ImageIcon hjem = new ImageIcon(cl.getResource("norskreseptregister/gui/bilder/hjem.png"));
        ImageIcon epille = new ImageIcon(cl.getResource("norskreseptregister/gui/bilder/ikonpille.png"));
        ImageIcon statistikk = new ImageIcon(cl.getResource("norskreseptregister/gui/bilder/ikonstatistikk.png"));

        tabbedPane.addTab("Hjem", hjem, hjempanel, "Hjem");
        tabbedPane.addTab("Endre Lisens for lege", elege, legepanel, "Endre lisens for Lege");
        tabbedPane.addTab("Registrer medisin", epille, medisinpanel, "Registrer Medisin");
        tabbedPane.addTab("Statistikk", statistikk, statistikkpanel, "Statistikk");
        add(tabbedPane);
    }

    // Get metode for TabbedPane
    public JTabbedPane getTabbedPane()
    {
        return tabbedPane;
    }
}//end of class AdminMain
