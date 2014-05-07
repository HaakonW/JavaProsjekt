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
        tabbedPane.addTab("Registrer Pasient", doktor, tab1, "Registrer pasient");
        tabbedPane.addTab("Registrer Lege", pasienten, tab2, "Registrer Lege");
        tabbedPane.addTab("Registrer Resept", resept, tab3, "Registrer Resept");
        add(tabbedPane);
    }

    public JTabbedPane getTabbedPane()
    {
        return tabbedPane;
    }

    /*private static void createAndShowGUI(final RegisterSystem system, Medisinliste medisinliste)

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

     }*/ ///// TEST TEST TEST ///// LAR DETTE STÅ NOEN DAGER OG SER OM ALT FUNGERER SOM DET SKAL /////////
}//end of class RegMainGUI