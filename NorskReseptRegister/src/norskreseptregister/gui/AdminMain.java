/*
 Filen inneholder AdminMain klassen.
 Laget av  Peter, Haakon, Henrik.
 Sist endret  09-04-2014
 */

package norskreseptregister.gui;

import java.awt.*;
import java.awt.event.*;
import java.awt.image.*;
import java.io.*;
import javax.imageio.*;
import javax.swing.*;

public class AdminMain extends JPanel
{
    private JTabbedPane tabbedPane;
    private JLabel hei;
    AdminMainHjemGUI panel1 = new AdminMainHjemGUI();
    LegeLisensGUI panel3 = new LegeLisensGUI();
    MedisinGUI panel4 = new MedisinGUI();    
    
    public AdminMain()
    {
        JTabbedPane tabbedPane = new JTabbedPane();
        ImageIcon icon = new ImageIcon(getClass().getResource("bilder/Admin.jpg"));
        tabbedPane.addTab("Hjem", icon, panel1, "Hjem");
        tabbedPane.addTab("Endre Lisens for lege", icon, panel3, "Lege");
        tabbedPane.addTab("Registrer medisin", icon, panel4, "Registrer Medisin");
        add(tabbedPane);
        hei = new JLabel("Dette er for admin. "); 
    }
    
    private static void createAndShowGUI()
    {
      //Create and set up the window.
      JFrame frame = new JFrame("Admin");
      frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
      frame.setSize(300,200);
      frame.getContentPane().add(new AdminMain(), BorderLayout.CENTER);

      //Display the window.

      frame.setVisible(true);
      frame.pack(); // Litt kranglete med størrelsen

      //sakset herfra: http://stackoverflow.com/questions/144892/how-to-center-a-window-in-java
      Dimension dimension = Toolkit.getDefaultToolkit().getScreenSize();      
      int x=(int)((dimension.getWidth() - 450)/2);
      int y=(int)((dimension.getHeight() - 450)/2);
      frame.setLocation(x, y);
    }

    public static void main(String[] args)
    {
      createAndShowGUI();
    }
}//end of class AdminMain