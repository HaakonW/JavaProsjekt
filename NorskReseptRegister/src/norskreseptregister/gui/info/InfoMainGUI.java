/*
Filen inneholder klassen RegMainGUI.
Laget av  Henrik Fischer Bjelland, Haakon Winther, Peter Wilhelmsen 
Sist endret 11-04-2014 
*/

package norskreseptregister.gui.info;

import java.awt.*;
import java.awt.event.WindowEvent;
import javax.swing.*;
import norskreseptregister.Info.InfoSystem;

public class InfoMainGUI extends JPanel
{
    private JTabbedPane tabbedPane;
    LegeInfoGUI tab1;
    PasientInfoGUI tab2;
    StatestikkGUI tab3;
    private InfoSystem system;
    InfoMainHjemGUI panel1 = new InfoMainHjemGUI();
    //SuperGUI panel1 = new SuperGUI();
    
    public InfoMainGUI(InfoSystem system)
    {
        //super(new GridLayout(1, 1));
       
        //tab1 = new LegeInfoGUI(system.getLegeInfo());
        //tab2 = new PasientInfoGUI(system.getPasientInfo());
        tab3 = new StatestikkGUI();
        JTabbedPane tabbedPane = new JTabbedPane();
        
        ImageIcon pille = new ImageIcon("src/norskreseptregister/gui/bilder/pille.png");
        
        
        tabbedPane.addTab("Hjem", pille, panel1, "Hjem");
        tabbedPane.addTab("LegeInfo", pille, tab1, "LegeInfo");
        tabbedPane.addTab("PasientInfo", pille, tab2, "PasientInfo");
        tabbedPane.addTab("Statestikk", pille, tab3, "Statestikk");
        
        add(tabbedPane);
        
    }
    
  private static void createAndShowGUI(final InfoSystem system)
  {
    //Create and set up the window.
    JFrame frame = new JFrame("Informasjon");
    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    frame.setSize(650,460);
    frame.getContentPane().add(new InfoMainGUI(system), BorderLayout.CENTER);
    frame.pack();
    //Display the window.
    frame.setVisible(true);
    Dimension dimension = Toolkit.getDefaultToolkit().getScreenSize();      
    int x=(int)((dimension.getWidth() - 650)/2);
    int y=(int)((dimension.getHeight() - 460)/2);
    frame.setLocation(x, y);
    //dette må ligge i main etter hvert
    frame.addWindowListener(new java.awt.event.WindowAdapter() {
    public void windowClosing(WindowEvent winEvt) {
        
    }
   });
  }

  public static void main(String[] args)
  {
    InfoSystem system = new InfoSystem();
    createAndShowGUI(system);
  }
    
}//end of class RegMainGUI
