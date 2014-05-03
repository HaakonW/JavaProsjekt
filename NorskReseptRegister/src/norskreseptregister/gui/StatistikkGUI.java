/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package norskreseptregister.gui;

import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;
import norskreseptregister.ObjektKlasser.Medisin;
import norskreseptregister.ObjektKlasser.Medisinliste;
import norskreseptregister.Reg.RegisterSystem;
import norskreseptregister.gui.regGUI.VelgFraListeGUI;
import javax.swing.DefaultListModel;

public class StatistikkGUI extends JPanel implements ActionListener
{
    private JLabel fradato, tildato, fraAar, tilAar, velgLegemiddel;
    private final JTextField fraAarfelt, medisinfelt;
    private final JButton velgMedisin;
    private JPanel panel1, panel2, panel3, panel4;
    private JTextArea utskrift;
    private tabellFrame frame;
    private Medisinliste medisinliste;
    private RegisterSystem system;
    private Medisin medisin;
    
    StatistikkGUI(RegisterSystem system, Medisinliste medisinliste, MedisinTabell medisintabell)
    {
        this.system = system;
        this.medisinliste = medisinliste;
        
        fraAarfelt = new JTextField(4);
 
        velgLegemiddel = new JLabel("Velg Legemiddel");
        
        velgMedisin = new JButton("...");
        velgMedisin.setPreferredSize(new Dimension(20, 20));
        velgMedisin.addActionListener(this);
        
        medisinfelt = new JTextField(20);
        medisinfelt.setEditable(false);
        
        fraAar = new JLabel("Velg år");
        utskrift = new JTextArea(20, 50);

        panel1 = new JPanel();
        panel1.add(velgLegemiddel);
        panel1.add(medisinfelt);
        panel1.add(velgMedisin);

        panel2 = new JPanel();
        panel2.add(fraAar);
        panel2.add(fraAarfelt);
        
        panel4 = new JPanel();
        panel4.add(utskrift);

        GridBagConstraints gc = new GridBagConstraints();
        setLayout(new GridBagLayout());

        int x = 0;
        int y = 0;

        gc.gridx = x;
        gc.gridy = y;
        add(panel1, gc);

        gc.gridx = x;
        gc.gridy = ++y;
        add(panel2, gc);

        gc.gridx = x;
        gc.gridy = ++y;
        add(panel4, gc);

        gc.gridx = x;
        gc.gridy = ++y;
        //add(frame.tabellet, gc);
 
    }
    
    //Metode for å velge ut en medisin
    private void VelgMedisin()
    {
        VelgFraListeGUI velgMedisin = new VelgFraListeGUI("Liste over alle medisiner:",
                "Velg medisin", medisinliste.getListModel());
        velgMedisin.setLocationRelativeTo(this);
        velgMedisin.setVisible(true);
        int valgtIndex = velgMedisin.getValgtIndex();
        if (valgtIndex >= 0)    // Dvs at brukeren faktisk har gjort et valg
        {
            medisin = medisinliste.HentEttElement(valgtIndex);
            medisinfelt.setText(medisin.getNavn());
        }
    }


    public void actionPerformed(ActionEvent e)
    {
        if (e.getSource() == velgMedisin)
        {
            VelgMedisin();
        }
    }
}

// tips: http://mathbits.com/MathBits/Java/Graphics/bargraphonly.htm