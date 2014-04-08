/*
 * Filen inneholder 
 * Laget av  * 
 * Sist endret  * 
 */

package norskreseptregister.gui;

/**
 *
 * @author Henrik
 */
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTabbedPane;
import javax.swing.SwingUtilities;
import norskreseptregister.RegisterSystem;

public class RegMainGUI extends JFrame
{
    RegisterSystem system;
    JFrame frame;
    JTabbedPane tabbedPane;
    RegistrerPasient f1;
    RegistrerLege f2;
    MainGui f3;
    
    
    public RegMainGUI(RegisterSystem system) 
    {
        frame = new JFrame();
        tabbedPane = new JTabbedPane();
        f1 = new RegistrerPasient(system);
        f2 = new RegistrerLege(system);
        //f3 = new GridbackBeta();
        this.system = system;
        tabbedPane.add("Registrer Pasient", f1);
        tabbedPane.add("Registrer Lege", f2);
        //tabbedPane.add("Gridbag Layout", f3);
        frame.getContentPane().add(tabbedPane);
        frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        frame.setSize(640, 480);
        // frame.pack();
        frame.setLocationByPlatform(true);
        frame.setVisible(true);
    }
    
       
    }//end of class RegMainGUI