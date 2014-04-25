/*
 Filen inneholder klassen LegeInfoGUI
 Laget av Henrik Fischer Bjelland
 Sist endret 11-04-2014 
 */
package norskreseptregister.gui.info;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import javax.swing.*;
import javax.swing.JPanel;
import norskreseptregister.ObjektKlasser.Medisin;
import norskreseptregister.ObjektKlasser.Medisinliste;
import norskreseptregister.ObjektKlasser.Pasient;
import norskreseptregister.ObjektKlasser.Resept;
import norskreseptregister.Reg.RegisterSystem;
import norskreseptregister.gui.regGUI.VelgMedisinGUI;
import norskreseptregister.gui.regGUI.VelgPersonGUI;

public class MedisinInfoGUI extends JPanel implements ActionListener
{
    private JTextField medisindatafelt;
    private JTextArea utskrift;
    private JScrollPane utskriftscroll;
    private JPanel panel1, panel2, panel3, panel4, panel5, panel6;
    private JLabel medisinlabel;
    private JButton knapp1, knapp2, knapp3, velgMedisin, hjelp;
    private final Medisinliste medisinliste;
    private Medisin medisin;
    private final RegisterSystem system;
   
    public MedisinInfoGUI(RegisterSystem system, Medisinliste medisinliste)
    {
        this.system = system;
        this.medisinliste = medisinliste;
        medisinlabel = new JLabel("Medisin");
        medisindatafelt = new JTextField(20);
        medisindatafelt.setText("Velg medisin fra listen til høyre");
        velgMedisin = new JButton("...");
        knapp1 = new JButton("Vis pasienter ");
        knapp2 = new JButton("Vis Leger");
        hjelp = new JButton ("?");
        utskrift = new JTextArea(20,20);
        utskrift.setBorder(BorderFactory.createEtchedBorder(Color.LIGHT_GRAY, Color.black));
        utskriftscroll = new JScrollPane(utskrift);
        ///PANELS START ////
        
        panel1 = new JPanel();
        panel1.add(medisinlabel);
        panel1.add(medisindatafelt); 
        panel1.add(velgMedisin);
       
        panel3 = new JPanel();
        panel3.add(knapp1);  
        panel3.add(knapp2);
       
       
       panel4 = new JPanel();
       panel4.add(utskriftscroll);
       
       velgMedisin.addActionListener(this);
       knapp1.addActionListener(this);
       knapp2.addActionListener(this);
       hjelp.addActionListener(this);
       medisindatafelt.setEditable(false);
       velgMedisin.setPreferredSize(new Dimension(20, 20));
       hjelp.setPreferredSize(new Dimension(20, 20));

       ///GRID START ////
       GridBagConstraints gc = new GridBagConstraints();
       setLayout(new GridBagLayout());
       gc.gridx = 0;
       gc.gridy = 0;
       gc.insets = new Insets(10, 5, 5, 10);
       gc.anchor = GridBagConstraints.WEST;
       gc.fill = GridBagConstraints.HORIZONTAL;
       add(panel1, gc);   

       gc.gridx = 0;
       gc.gridy = 1;
       add(panel3, gc);

        gc.gridx = 1;
        gc.gridy = 0;
        gc.gridheight = 6;
        add(panel4, gc);
        
        gc.gridx = 2;
        gc.gridy = 6;
        add(hjelp, gc);

        utskrift.setEditable(false); 
    }
    
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
            medisindatafelt.setText(medisin.getNavn());
        }
    }
    
    private void visPasienter()
    {
        FinnReseptForMedisin query = new FinnReseptForMedisin(medisin);
        ArrayList <Resept> resepter = system.getReseptRegister().FinnObjekterSomMatcher(query);
        HashMap <String, Resept> unikePasientResepter = new HashMap<>(); 
        String pasienter="";
        for (Resept r : resepter)
        {
            unikePasientResepter.put(r.getPasientdata().getNavn(), r);
        }
        for (Map.Entry<String, Resept> e : unikePasientResepter.entrySet())
        {
            pasienter += e.getValue().getPasientdata().getNavn() + "\n";
        }
        utskrift.setText("Pasienter som har mottat " + medisin.getNavn() + ":\n" + pasienter);
    }
    
    private void visLeger()
    {
        FinnReseptForMedisin query = new FinnReseptForMedisin(medisin);
        ArrayList <Resept> resepter = system.getReseptRegister().FinnObjekterSomMatcher(query);
        HashMap <String, Resept> unikeLegeResepter = new HashMap<>();
        String leger="";
        for (Resept r : resepter)
        {
            unikeLegeResepter.put(r.getLegedata().getNavn(), r);
        }
        for (Map.Entry<String, Resept> e : unikeLegeResepter.entrySet())
        {
            leger += e.getValue().getLegedata().getNavn() + "\n";
        }
        utskrift.setText("Leger som har skrevet ut " + medisin.getNavn() + ":\n" + leger);
    }
    

    public void actionPerformed(ActionEvent e)
    {
        if (e.getSource() == velgMedisin)
        {
            VelgMedisin();
        }
        else if (e.getSource() == knapp1)
        {
            visPasienter();
        }
        else if (e.getSource() == knapp2)
        {
            visLeger();
        }
        else if (e.getSource() == hjelp)
        {
            JOptionPane.showMessageDialog(null, "HJELP Medisininfo");
        }
        
    }
    
}//end of class LegeInfoGUI
