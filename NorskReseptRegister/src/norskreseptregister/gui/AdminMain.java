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
    //private	JPanel	panel2;
    //private	JPanel	LegeLisensGUI;
    LegeLisensGUI panel3 = new LegeLisensGUI();
    MedisinGUI panel4 = new MedisinGUI();
    
    public AdminMain()
    {
        super(new GridLayout(1, 1));
        JTabbedPane tabbedPane = new JTabbedPane();
        ImageIcon icon = new ImageIcon(getClass().getResource("bilder/Admin.jpg"));
        tabbedPane.addTab("Admininstasjon", icon, panel1, "Admin");
        tabbedPane.addTab("Endre Lisens for lege", icon, panel3, "Lege");
        tabbedPane.addTab("Registrer medisin", icon, panel4, "blank");
        add(tabbedPane);
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
  }

  public static void main(String[] args)
  {
    createAndShowGUI();
  }
    
}