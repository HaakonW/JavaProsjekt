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

<<<<<<< HEAD
    private JTabbedPane tabbedPane;
=======
    JTabbedPane tabbedPane;
>>>>>>> FETCH_HEAD
    RegistrerPasient tab1;
    RegistrerLege tab2;
    RegistrerResept tab3;
    private RegisterSystem system;
    RegMainHjemGUI panel1 = new RegMainHjemGUI();
<<<<<<< HEAD

    public RegMainGUI(RegisterSystem system)
=======
    private Medisinliste medisinliste;

    public RegMainGUI(RegisterSystem system, Medisinliste medisinliste)
>>>>>>> FETCH_HEAD
    {
        super(new GridLayout(1, 1));
        this.system = system;
        this.medisinliste = medisinliste;
        tab1 = new RegistrerPasient(system.getPasientRegister());
        tab2 = new RegistrerLege(system.getLegeRegister());
<<<<<<< HEAD
        tab3 = new RegistrerResept(system);
=======
        tab3 = new RegistrerResept(system, medisinliste);
>>>>>>> FETCH_HEAD
        JTabbedPane tabbedPane = new JTabbedPane();
        ImageIcon hjem = new ImageIcon("src/norskreseptregister/gui/bilder/hjem.png");
        ImageIcon doktor = new ImageIcon("src/norskreseptregister/gui/bilder/doktor.png");
        ImageIcon pasienten = new ImageIcon("src/norskreseptregister/gui/bilder/person.png");
        ImageIcon resept = new ImageIcon("src/norskreseptregister/gui/bilder/resept.png");

        tabbedPane.addTab("Hjem", hjem, panel1, "Hjem");
        tabbedPane.addTab("Registrer Pasient", pasienten, tab1, "Pasient");
        tabbedPane.addTab("Registrer Lege", doktor, tab2, "Lege");
        tabbedPane.addTab("Registrer Resept", resept, tab3, "Resept");
        //tabbedPane.addTab("Registrer Resept", icon, tab3, "Resept");
        add(tabbedPane);
    }

<<<<<<< HEAD
    private static void createAndShowGUI(final RegisterSystem system)
=======
    private static void createAndShowGUI(final RegisterSystem system, Medisinliste medisinliste)
>>>>>>> FETCH_HEAD
    {
        //Create and set up the window.
        JFrame frame = new JFrame("Admin");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(650, 460);
<<<<<<< HEAD
        frame.getContentPane().add(new RegMainGUI(system), BorderLayout.CENTER);
=======
        frame.getContentPane().add(new RegMainGUI(system, medisinliste), BorderLayout.CENTER);
>>>>>>> FETCH_HEAD
        //Display the window.
        frame.setVisible(true);
        frame.pack();
        Dimension dimension = Toolkit.getDefaultToolkit().getScreenSize();
        int x = (int) ((dimension.getWidth() - 650) / 2);
        int y = (int) ((dimension.getHeight() - 460) / 2);
        frame.setLocation(x, y);
        //dette må ligge i main etter hvert
    }

    /*public static void main(String[] args)
     {
     RegisterSystem system = new RegisterSystem();
     createAndShowGUI(system);
     }*/
    // GIR FEIL NÅR HOVEDVINDU SKAL KJØRES.Må settes tom 
    public RegMainGUI()
    {

    }

}//end of class RegMainGUI
