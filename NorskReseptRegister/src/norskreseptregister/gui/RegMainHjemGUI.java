/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package norskreseptregister.gui;

import java.awt.*;
import javax.swing.*;
/**
 *
 * @author Henrik
 */
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
}
