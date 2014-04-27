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
import norskreseptregister.gui.regGUI.VelgPersonGUI;
import javax.swing.DefaultListModel;

public class StatistikkGUI extends JPanel implements ActionListener
{
    private JLabel fradato, tildato, fraAar, tilAar, velgLegemiddel;
    private JTextField fraAarfelt, tilAarfelt, velgaar1, velgaar2, medisinfelt;
    private String [] maned;
    private JButton knapp1, knapp2, knapp3, velgMedisin;
    private JComboBox rullgardin1, rullgardin2;
    private JPanel panel1, panel2, panel3;
    private JTextArea temp;
    private tabellFrame frame;
    private Medisinliste medisinliste;
    private RegisterSystem system;
    private Medisin medisin;
    
    StatistikkGUI(RegisterSystem system, Medisinliste medisinliste)
    {
        this.system = system;
        this.medisinliste = medisinliste;
        
        String maned[] =
        {
            "Januar", "Februar", "Mars", "April", "Mai", "Juni", "Juli", "August",
            "Septemeber", "Oktober", "November", "Desember"
        };
        rullgardin1 = new JComboBox();
        rullgardin2 = new JComboBox();
        
        fraAarfelt = new JTextField(4);
        tilAarfelt = new JTextField(4);
        
        fradato = new JLabel("Fra Måned");
        tildato = new JLabel("Til Måned");
        
        velgLegemiddel = new JLabel("Velg Legemiddel");
        
        velgMedisin = new JButton("...");
        velgMedisin.setPreferredSize(new Dimension(20, 20));
        velgMedisin.addActionListener(this);
        
        medisinfelt = new JTextField(20);
        medisinfelt.setEditable(false);
        
        fraAar = new JLabel("Velg år");
        tilAar = new JLabel("Velg år");
        temp = new JTextArea(20, 50);

        int teller = 0;

        for (int i = 0; i < maned.length; i++)
        {
            rullgardin1.addItem(maned[i]);

        }
        for (int i = 0; i < maned.length; i++)
        {
            rullgardin2.addItem(maned[i]);

        }

        panel1 = new JPanel();
        panel1.add(velgLegemiddel);
        panel1.add(medisinfelt);
        panel1.add(velgMedisin);

        panel2 = new JPanel();
        panel2.add(fradato);
        panel2.add(rullgardin1);
        panel2.add(fraAar);
        panel2.add(fraAarfelt);

        panel3 = new JPanel();
        panel3.add(tildato);
        panel3.add(rullgardin2);
        panel3.add(tilAar);
        panel3.add(tilAarfelt);

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
        add(panel3, gc);

        gc.gridx = x;
        gc.gridy = ++y;
        //add(temp, gc);

        gc.gridx = x;
        gc.gridy = ++y;
        //add(frame.tabellet, gc);
 
    }
    
    //Metode for å velge ut en medisin
    private void VelgMedisin()
    {
        DefaultListModel model = new DefaultListModel();
        for (Medisin m : medisinliste.FinnAlle())
        {
            model.addElement(m.toString());
        }
        VelgPersonGUI velgMedisin = new VelgPersonGUI(model);
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