/*
Filen inneholder klassen InfoMainGUI. Her skal man kunne hente ut informasjon....
Laget av  Haakon Winther
Sist endret 09-04-2014
*/

package norskreseptregister.gui.info;

import java.awt.*;
import java.awt.event.*;
import java.awt.image.*;
import java.io.*;
import javax.imageio.*;
import javax.swing.*;
import norskreseptregister.Reg.RegisterSystem;

public class InfoMainGUI extends JPanel
{
    private JTabbedPane tabbedPane;
    InfoMainHjemGUI panel1;
    LegeInfoGUI panel2;
    //PasientInfoGUI panel3 = new PasientInfoGUI();
    MedisinInfoGUI panel4;
    private RegisterSystem system;

    
    public InfoMainGUI(RegisterSystem system)
    {
        panel1 = new InfoMainHjemGUI();
        panel2 = new LegeInfoGUI(system);
        panel4 = new MedisinInfoGUI();
        JTabbedPane tabbedPane = new JTabbedPane();
        ImageIcon hjem = new ImageIcon("src/norskreseptregister/gui/bilder/hjem.png");
        ImageIcon epille = new ImageIcon("src/norskreseptregister/gui/bilder/epille.png");
        ImageIcon docinfo = new ImageIcon("src/norskreseptregister/gui/bilder/docinfo.png");
        ImageIcon pasinfo = new ImageIcon("src/norskreseptregister/gui/bilder/pasinfo.png");
        
        tabbedPane.addTab("Hjem", hjem, panel1, "Hjem");
        tabbedPane.addTab("Legeinfo", docinfo, panel2, "Lege");
        //tabbedPane.addTab("PasientInfo", pasinfo, panel3, "Pasient");
        tabbedPane.addTab("Medisininfo", epille, panel4, "Legemiddel");
        add(tabbedPane);
    }
    
    private static void createAndShowGUI(RegisterSystem system)
    {
        //Create and set up the window.
        JFrame frame = new JFrame("Informasjon");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(500,400);
        frame.getContentPane().add(new InfoMainGUI(system), BorderLayout.CENTER);
        
        frame.setVisible(true);
        frame.pack(); 

        Dimension dimension = Toolkit.getDefaultToolkit().getScreenSize();      
        int x=(int)((dimension.getWidth() - 620)/2);
        int y=(int)((dimension.getHeight() - 450)/2);
        frame.setLocation(x, y); 
  }
    
}//end of class InfoMainGUI
