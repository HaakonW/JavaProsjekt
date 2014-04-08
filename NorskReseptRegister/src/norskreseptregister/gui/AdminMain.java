/*
 * Filen inneholder 
 * Laget av  * 
 * Sist endret  * 
 */

package norskreseptregister.gui;

import java.awt.*;
import java.awt.event.*;
import java.awt.image.*;
import java.io.*;
import javax.imageio.*;
import javax.swing.*;
/**
 *
 * @author Bandet
 */

public class AdminMain extends JPanel
{
    private JTabbedPane tabbedPane;
    private	JPanel	panel1;
    private	JPanel	panel2;
    private	JPanel	panel3;
    
    public AdminMain()
            {
                super(new GridLayout(1, 1));
                JTabbedPane tabbedPane = new JTabbedPane();
                ImageIcon icon = new ImageIcon(getClass().getResource("bilder/Admin.jpg"));
                tabbedPane.addTab("Admininstasjon", icon, panel1, "Admin");
                tabbedPane.addTab("Registrer medisin", icon, panel2, "Medisin");
                tabbedPane.addTab("Fiks Lege", icon, panel3, "Lege");
                tabbedPane.addTab("Blank", icon, panel3, "blank");
                 add(tabbedPane);
            }
     private static void createAndShowGUI()
  {
    //Create and set up the window.
    JFrame frame = new JFrame("Admin");
    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    frame.setSize(600,400);
    frame.getContentPane().add(new AdminMain(), BorderLayout.CENTER);

    //Display the window.
   
    frame.setVisible(true);
  }

  public static void main(String[] args)
  {
    createAndShowGUI();
  }
    
}