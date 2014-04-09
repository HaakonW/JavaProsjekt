/*
 Filen inneholder AdminMainHjemGUI klassen.
 Laget av Henrik.
 Sist endret  09-04-2014
 */

package norskreseptregister.gui;

import java.awt.*;
import javax.swing.*;

class AdminMainHjemGUI extends JPanel
{
    private JButton endreLisens, medisin;
    private JPanel panel2;

    public AdminMainHjemGUI()
    {
        endreLisens = new JButton("Endre Lisens");
        medisin = new JButton("Registrer Medisin");

        panel2 = new JPanel();
        panel2.add(endreLisens);
        panel2.add(medisin);
        
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
}//end of class AdminMainHjemGUI
