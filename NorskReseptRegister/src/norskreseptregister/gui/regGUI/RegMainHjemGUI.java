/*
 * Filen inneholder klassen RegMainHjemGUI.
 * Laget av  Henrik 
 * Sist endret 09-04-2014 
 */

package norskreseptregister.gui.regGUI;

import java.awt.*;
import javax.swing.*;

class RegMainHjemGUI extends JPanel
{
    private JButton regPasient, regLege, regResept;
    private JPanel panel2;

    public RegMainHjemGUI()
    {
        regPasient= new JButton("Registrer Pasient");
        regLege = new JButton("Registrer Lege");
        regResept = new JButton("Registrer Resept");

        panel2 = new JPanel();
        panel2.add(regPasient);
        panel2.add(regLege);
        panel2.add(regResept);
        
        GridBagConstraints gc = new GridBagConstraints();
        setLayout(new GridBagLayout());
        gc.gridx = 0;
        gc.gridy = 0;
        gc.insets = new Insets(10, 5, 5, 10);
        gc.anchor = GridBagConstraints.WEST;
        gc.fill = GridBagConstraints.HORIZONTAL;
        //add(panel1, gc);
        
        gc.gridx = 0;
        gc.gridy = 1;
        add(panel2, gc);
    }
}//end of class RegMainHjemGUI
