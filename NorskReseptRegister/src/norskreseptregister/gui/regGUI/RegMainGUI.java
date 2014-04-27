/*
 Filen inneholder klassen RegMainGUI.
 Laget av  Henrik Fischer Bjelland, Haakon Winther, Peter Wilhelmsen 
 Sist endret 17-04-2014 
 */
package norskreseptregister.gui.regGUI;

import java.awt.*;
import java.awt.event.WindowEvent;
import javax.swing.*;
import norskreseptregister.ObjektKlasser.Medisinliste;
import norskreseptregister.Reg.RegisterSystem;

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
        super(new GridLayout(1, 1));
        this.system = system;
        this.medisinliste = medisinliste;
        tab1 = new RegistrerPasient(system.getPasientRegister());
        tab2 = new RegistrerLege(system.getLegeRegister());
        tab3 = new RegistrerResept(system, medisinliste);
        tabbedPane = new JTabbedPane();
        ImageIcon hjem = new ImageIcon("src/norskreseptregister/gui/bilder/hjem.png");
        ImageIcon doktor = new ImageIcon("src/norskreseptregister/gui/bilder/doktor.png");
        ImageIcon pasienten = new ImageIcon("src/norskreseptregister/gui/bilder/person.png");
        ImageIcon resept = new ImageIcon("src/norskreseptregister/gui/bilder/resept.png");

        tabbedPane.addTab("Hjem", hjem, panel1, "Hjem");
        tabbedPane.addTab("Registrer Pasient", pasienten, tab1, "Registrer pasient");
        tabbedPane.addTab("Registrer Lege", doktor, tab2, "Registrer Lege");
        tabbedPane.addTab("Registrer Resept", resept, tab3, "Registrer Resept");
        //tabbedPane.addTab("Registrer Resept", icon, tab3, "Resept");
        add(tabbedPane);
    }

    public JTabbedPane getTabbedPane()
    {
        return tabbedPane;
    }

    private static void createAndShowGUI(final RegisterSystem system, Medisinliste medisinliste)

    {
        //Create and set up the window.
        JFrame frame = new JFrame("Admin");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(650, 460);
        frame.getContentPane().add(new RegMainGUI(system, medisinliste), BorderLayout.CENTER);
        //Display the window.
        frame.pack();
        frame.setVisible(true);
    }
    
    // GIR FEIL NÅR HOVEDVINDU SKAL KJØRES.Må settes tom 
    public RegMainGUI()
    {

    }

}//end of class RegMainGUI
