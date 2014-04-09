/*
 * Filen inneholder klassen RegMainGUI.
 * Laget av  Henrik, Haakon, Peter 
 * Sist endret 09-04-2014 
 */

package norskreseptregister.gui;

import java.awt.*;
import java.awt.event.*;
import java.awt.image.*;
import java.io.*;
import javax.imageio.*;
import javax.swing.*;
import norskreseptregister.RegisterSystem;

public class RegMainGUI extends JPanel
{
    private JTabbedPane tabbedPane;
    RegistrerPasient tab1;
    RegistrerLege tab2;
    private RegisterSystem system;
    RegMainHjemGUI panel1 = new RegMainHjemGUI();
    
    public RegMainGUI(RegisterSystem system)
    {
        super(new GridLayout(1, 1));
        this.system = system;
        tab1 = new RegistrerPasient(system.getPasientRegister());
        tab2 = new RegistrerLege(system.getLegeRegister());
        JTabbedPane tabbedPane = new JTabbedPane();
        ImageIcon icon = new ImageIcon(getClass().getResource("bilder/Admin.jpg"));
        tabbedPane.addTab("Hjem", icon, panel1, "Hjem");
        tabbedPane.addTab("Registrer Pasient", icon, tab1, "Pasient");
        tabbedPane.addTab("Registrer Lege", icon, tab2, "Lege");
        //tabbedPane.addTab("Registrer Resept", icon, tab3, "Resept");
        add(tabbedPane);
    }
    
  private static void createAndShowGUI(RegisterSystem system)
  {
    //Create and set up the window.
    JFrame frame = new JFrame("Admin");
    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    frame.setSize(650,460);
    frame.getContentPane().add(new RegMainGUI(system), BorderLayout.CENTER);
    frame.pack();
    //Display the window.
   
    frame.setVisible(true);
  }

  public static void main(String[] args)
  {
    RegisterSystem system = new RegisterSystem();
    createAndShowGUI(system);
  }
    
}//end of class RegMainGUI
