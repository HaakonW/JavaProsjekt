/*
Filen inneholder klassen SuperGUI.
Laget av Henrik Fischer Bjelland 
Sist endret 11-04-2014 


DETTE SKAL EGENTLIG VÆRE SUPER, MEN ER PÅ VANLIG INNTIL VIDERE
*/

package norskreseptregister.gui.info;

import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import javax.swing.*;

public abstract class SuperGUI extends JPanel 
{
    private JButton knapp1, knapp2, knapp3;
    private JPanel[] panelxArray;
    private JPanel[] panelyArray;
    private JPanel panel1, panel2, panel3, panel4, panel5, panel6, panel7, panel8;
    
        
    public SuperGUI()
    {
        panelxArray = new JPanel[15];
        panelyArray = new JPanel[5];
        //http://stackoverflow.com/questions/10351196/adding-jpanels-to-jpanel-array//
        
        knapp1 = new JButton ("Fane 2");
        knapp2 = new JButton ("Fane 3");
        knapp3 = new JButton ("Fane 4");
        
        panel1 = new JPanel();
        panel1.add(knapp1);
        panel1.add(knapp2);
        panel1.add(knapp3);
        
        GridBagConstraints gc = new GridBagConstraints();
        setLayout(new GridBagLayout());
        gc.gridx = 0;
        gc.gridy = 0;
        gc.insets = new Insets(10, 5, 5, 10);
        gc.anchor = GridBagConstraints.WEST;
        gc.fill = GridBagConstraints.HORIZONTAL;
        add(panel1, gc);
        
    }

}//end of class SuperGUI