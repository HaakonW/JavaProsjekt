/*
Filen inneholder AdminMain klassen. AdminMain 
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
    RegistrerMedisinGUI panel4;    
    private RegisterSystem system;
    
    //Newer opp GUI klasser og legger disse til å forskjellige tabbedPanes
    public AdminMain(RegisterSystem system)
    {
        this.system = system;
        panel1 = new AdminMainHjemGUI();
        panel3 = new LegeLisensGUI(system);
        panel4 = new RegistrerMedisinGUI();
        JTabbedPane tabbedPane = new JTabbedPane();
        ImageIcon elege = new ImageIcon("src/norskreseptregister/gui/bilder/Refresh-icon.png");
        ImageIcon hjem = new ImageIcon("src/norskreseptregister/gui/bilder/hjem.png");
        ImageIcon epille = new ImageIcon("src/norskreseptregister/gui/bilder/epille.png");
        
        tabbedPane.addTab("Hjem", hjem, panel1, "Hjem");
        tabbedPane.addTab("Endre Lisens for lege", elege, panel3, "Endre lisens for Lege");
        tabbedPane.addTab("Registrer medisin", epille, panel4, "Registrer Medisin");
        add(tabbedPane);
        
    }
    //Metode for å vise og sette størrelse på vinudet
    private static void createAndShowGUI(RegisterSystem system)
    {
      //Create and set up the window.
      JFrame frame = new JFrame("Admin");
      frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
      frame.setSize(300,200);
      frame.getContentPane().add(new AdminMain(system), BorderLayout.CENTER);

      frame.setVisible(true);
      frame.pack(); // Litt kranglete med størrelsen

      //sakset herfra: http://stackoverflow.com/questions/144892/how-to-center-a-window-in-java
      /*Dimension dimension = Toolkit.getDefaultToolkit().getScreenSize();      
      int x=(int)((dimension.getWidth() - 620)/2);
      int y=(int)((dimension.getHeight() - 450)/2);
      frame.setLocation(x, y);*/
    }

}//end of class AdminMain