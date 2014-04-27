/*
 Filen inneholder klassen AdminMain. 
 Klassen inneholder tabsene
 Laget av  Peter Wilhelmsen, Haakon Winter, Henrik Fischer Bjelland
 Sist endret 09-04-2014
 */
package norskreseptregister.gui;

import java.awt.*;
import java.awt.event.*;
import java.awt.image.*;
import java.io.*;
import javax.imageio.*;
import javax.swing.*;
import norskreseptregister.ObjektKlasser.Medisin;
import norskreseptregister.ObjektKlasser.Medisinliste;
import norskreseptregister.Reg.RegisterSystem;

public class AdminMain extends JPanel
{
    private JTabbedPane tabbedPane;
    private AdminMainHjemGUI panel1;
    private final LegeLisensGUI panel3;
    private RegistrerMedisinGUI panel4;
    private StatistikkGUI panel5;
    private RegisterSystem system;

    //Newer opp GUI klasser og legger disse til å forskjellige tabbedPanes
    public AdminMain(RegisterSystem system)
    {
        this.system = system;
        panel1 = new AdminMainHjemGUI(this);
        panel3 = new LegeLisensGUI(system);
        panel4 = new RegistrerMedisinGUI();
        panel5 = new StatistikkGUI();
        tabbedPane = new JTabbedPane();
        ImageIcon elege = new ImageIcon("src/norskreseptregister/gui/bilder/Refresh-icon.png");
        ImageIcon hjem = new ImageIcon("src/norskreseptregister/gui/bilder/hjem.png");
        ImageIcon epille = new ImageIcon("src/norskreseptregister/gui/bilder/epille.png");
        ImageIcon statistikk = new ImageIcon("src/norskreseptregister/gui/bilder/statistikk.png");

        tabbedPane.addTab("Hjem", hjem, panel1, "Hjem");
        tabbedPane.addTab("Endre Lisens for lege", elege, panel3, "Endre lisens for Lege");
        tabbedPane.addTab("Registrer medisin", epille, panel4, "Registrer Medisin");
        tabbedPane.addTab("Statestikk", statistikk, panel5, "Statestikk");
        add(tabbedPane);

        setVisible(true);
        setSize(800, 400);
    }

    //Get metode for TabbedPane
    public JTabbedPane getTabbedPane()
    {
        return tabbedPane;
    }

    //Metode for å vise og sette størrelse på vinudet
    private static void createAndShowGUI(RegisterSystem system)
    {
        JFrame frame = new JFrame("Admin");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(300, 200);
        frame.getContentPane().add(new AdminMain(system), BorderLayout.CENTER);
        frame.pack();
        frame.setVisible(true);
    }
}//end of class AdminMain
