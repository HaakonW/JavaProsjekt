/*
 Filen inneholder klassen LegeInfoGUI
 Laget av Henrik Fischer Bjelland
 Sist endret 11-04-2014 
 */
package norskreseptregister.gui.info;

import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import javax.swing.*;
import javax.swing.JPanel;
import norskreseptregister.ObjektKlasser.Medisin;
import norskreseptregister.ObjektKlasser.Medisinliste;
import norskreseptregister.ObjektKlasser.Resept;
import norskreseptregister.Reg.RegisterSystem;
import norskreseptregister.gui.regGUI.VelgPersonGUI;

public class MedisinInfoGUI extends JPanel implements ActionListener
{
    private JTextField medisindatafelt;
    private JTextArea utskrift;
    private JScrollPane utskriftscroll;
    private JPanel panel1, panel2;
    private JLabel medisinlabel;
    private JButton visPasient, visLeger, velgMedisin, hjelp;
    private final Medisinliste medisinliste;
    private Medisin medisin;
    private final RegisterSystem system;
   
    public MedisinInfoGUI(RegisterSystem system, Medisinliste medisinliste)
    {
        this.system = system;
        this.medisinliste = medisinliste;
        
        medisinlabel = new JLabel("Medisin");
        medisindatafelt = new JTextField(20);
        medisindatafelt.setText("Velg medisin med knappen til høyre");
        medisindatafelt.setEditable(false);
        
        velgMedisin = new JButton("...");
        velgMedisin.setToolTipText("Trykk for å velge medisin");
        velgMedisin.addActionListener(this);
        velgMedisin.setPreferredSize(new Dimension(20, 20));
        
        visPasient = new JButton("Vis pasienter ");
        visPasient.setToolTipText("Trykk for å velge pasient");
        visPasient.addActionListener(this);
        
        visLeger = new JButton("Vis Leger");
        visLeger.setToolTipText("Trykk for å vise leger");
        visLeger.addActionListener(this);
        
        hjelp = new JButton ("?");
        hjelp.setToolTipText("Trykk her for å få hjelp");
        hjelp.addActionListener(this);
        hjelp.setPreferredSize(new Dimension(20, 20));
        
        utskrift = new JTextArea(20,20);
        utskrift.setEditable(false); 
        utskriftscroll = new JScrollPane(utskrift);
        utskriftscroll.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);

        ///PANELS START ////
        panel1 = new JPanel();
        panel1.add(medisinlabel);
        panel1.add(medisindatafelt); 
        panel1.add(velgMedisin);
        panel1.setBorder(BorderFactory.createEtchedBorder());  

        panel2 = new JPanel();
        panel2.add(visPasient);  
        panel2.add(visLeger);
        panel2.setBorder(BorderFactory.createEtchedBorder());    

        ///GRID START ////
        GridBagConstraints gc = new GridBagConstraints();
        setLayout(new GridBagLayout());
        
        int x = 0;
        int y = 0;
        
        gc.gridx = x;
        gc.gridy = y;
        gc.insets = new Insets(5, 10, 5, 10);       
        gc.fill = GridBagConstraints.HORIZONTAL;
        add(panel1, gc);   

        gc.gridx = x;
        gc.gridy = ++y;
        add(panel2, gc);

        gc.gridx = ++x;
        gc.gridy = 0;
        gc.gridheight = 6;
        add(utskriftscroll, gc);

        gc.gridx = 2;
        gc.gridy = 6;
        add(hjelp, gc);
    }
    
    //metode for å velge medisin i popup vindu
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
    
    //metoden for å vise pasienter i popup vinduet
    private void visPasienter()
    {
        FinnReseptForMedisin query = new FinnReseptForMedisin(medisin);
        ArrayList <Resept> resepter = system.getReseptRegister().FinnObjekterSomMatcher(query);
        HashMap <String, Resept> unikePasientResepter = new HashMap<>(); 
        String pasienter="";
        for (Resept r : resepter)
        {
            unikePasientResepter.put(r.getPasient().getNavn(), r);
        }
        for (Map.Entry<String, Resept> e : unikePasientResepter.entrySet())
        {
            pasienter += e.getValue().getPasient().getNavn() + "\n";
        }
        utskrift.setText("Pasienter som har mottat " + medisin.getNavn() + ":\n" + pasienter);
    }
    
    //metode for å vise Leger i popup vinduet
    private void visLeger()
    {
        FinnReseptForMedisin query = new FinnReseptForMedisin(medisin);
        ArrayList <Resept> resepter = system.getReseptRegister().FinnObjekterSomMatcher(query);
        HashMap <String, Resept> unikeLegeResepter = new HashMap<>();
        String leger="";
        for (Resept r : resepter)
        {
            unikeLegeResepter.put(r.getLege().getNavn(), r);
        }
        for (Map.Entry<String, Resept> e : unikeLegeResepter.entrySet())
        {
            leger += e.getValue().getLege().getNavn() + "\n";
        }
        utskrift.setText("Leger som har skrevet ut " + medisin.getNavn() + ":\n" + leger);
    }
    
    //metode for å lytte på knappene
    public void actionPerformed(ActionEvent e)
    {
        if (e.getSource() == velgMedisin)
        {
            VelgMedisin();
        }
        else if (e.getSource() == visPasient)
        {
            visPasienter();
        }
        else if (e.getSource() == visLeger)
        {
            visLeger();
        }
        else if (e.getSource() == hjelp)
        {
            JOptionPane.showMessageDialog(null, "HJELP Medisininfo");
        } 
    }
    
}//end of class LegeInfoGUI
