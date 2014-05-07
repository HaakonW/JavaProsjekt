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
import java.util.List;
import javax.swing.*;
import javax.swing.JPanel;
import norskreseptregister.ObjektKlasser.Pasient;
import norskreseptregister.ObjektKlasser.Resept;
import norskreseptregister.Reg.LegeRegister;
import norskreseptregister.Reg.PasientRegister;
import norskreseptregister.Reg.RegisterSystem;
import norskreseptregister.gui.regGUI.VelgFraListeGUI;

public class PasientInfoGUI extends JPanel implements ActionListener
{

    private JTextField pasientdatafelt;
    private JTextArea utskrift;
    private JScrollPane utskriftscroll;
    private JPanel panel1, panel2;
    private JLabel pasientlabel;
    private JButton visAllePasienter, visResepteriGruppe, velgPasient, hjelp;
    private JCheckBox a, b, c;
    private RegisterSystem system;
    private PasientRegister pasientRegister;
    private Pasient pasient;

    public PasientInfoGUI(RegisterSystem system, PasientRegister pasientRegister)
    {
        this.system = system;
        this.pasientRegister = pasientRegister;

        pasientlabel = new JLabel("Pasient   ");
        pasientdatafelt = new JTextField(20);
        pasientdatafelt.setText("Velg pasient med knappen til høyre");
        pasientdatafelt.setEditable(false);

        visAllePasienter = new JButton("Print alle pasienter");
        visAllePasienter.setToolTipText("Trykk for å printe pasienter");
        visAllePasienter.addActionListener(this);

        visResepteriGruppe = new JButton("Vis resepter");
        visResepteriGruppe.setToolTipText("Trykk for å vise resepter");
        visResepteriGruppe.addActionListener(this);
        a = new JCheckBox("A", true);
        b = new JCheckBox("B", true);
        c = new JCheckBox("C", true);

        hjelp = new JButton("?");
        hjelp.setToolTipText("Trykk for hjelp");
        hjelp.addActionListener(this);
        hjelp.setPreferredSize(new Dimension(20, 20));

        velgPasient = new JButton("...");
        velgPasient.setToolTipText("Trykk for å vise over pasienter");
        velgPasient.addActionListener(this);
        velgPasient.setPreferredSize(new Dimension(20, 20));

        utskrift = new JTextArea(20, 20);
        utskriftscroll = new JScrollPane(utskrift);
        utskriftscroll.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
        utskrift.setEditable(false);

        ///PANEL START ////       
        panel1 = new JPanel();
        panel1.add(pasientlabel);
        panel1.add(pasientdatafelt);
        panel1.add(velgPasient);
        panel1.setBorder(BorderFactory.createEtchedBorder());

        panel2 = new JPanel();
        panel2.setBorder(BorderFactory.createEtchedBorder());
        panel2.add(a);
        panel2.add(b);
        panel2.add(c);
        panel2.add(visResepteriGruppe);

        ///GRID START ////
        GridBagConstraints gc = new GridBagConstraints();
        setLayout(new GridBagLayout());

        int x = 0;
        int y = 0;

        gc.gridx = x;
        gc.gridy = y;
        gc.insets = new Insets(5, 10, 5, 10);
        add(panel1, gc);

        gc.gridx = x;
        gc.gridy = ++y;
        gc.fill = GridBagConstraints.HORIZONTAL;
        add(panel2, gc);

        gc.gridx = x;
        gc.gridy = ++y;
        add(visAllePasienter, gc);

        gc.gridx = ++x;
        gc.gridy = 0;
        gc.gridheight = 6;
        add(utskriftscroll, gc);

        gc.gridx = ++x;
        gc.gridy = 6;
        add(hjelp, gc); 
    }//end of Konstruktør

    //Metoden for velge pasient
    private void VelgPasient()
    {
        // #info: Gjort dialogen slik at den kan brukes til å velge mange forskjellige ting
        PasientRegister pasientRegister = system.getPasientRegister();
        VelgFraListeGUI velgPasient = new VelgFraListeGUI("Liste over alle pasienter:",
                "Velg pasient", pasientRegister.getListModel());
        velgPasient.setLocationRelativeTo(this);
        velgPasient.setVisible(true);
        int valgtIndex = velgPasient.getValgtIndex();
        if (valgtIndex >= 0)    // Dvs at brukeren faktisk har gjort et valg
        {
            pasient = pasientRegister.HentEttObjekt(valgtIndex);
            pasientdatafelt.setText(pasient.getNavn());
        }
    }

    //Metoden for å vise allepasienter
    private void visAllePasienter()
    {
        String legeliste = "";
        List <Pasient> list = system.getPasientRegister().FinnAlleObjekter();
        for (Pasient pasient : list)
        {
            legeliste+= pasient.toString();
            legeliste +="\n\n";
        }
        utskrift.setText(legeliste);
    }

    //Metoden viser hvilke resepter en spesifikk lege har skrevet ut
    public void visResepterForPasient()
    {
        if ( pasient != null)
        {
                FinnResepterForPasientIReseptGruppe query = new FinnResepterForPasientIReseptGruppe(
                        pasient, a.isSelected(), b.isSelected(), c.isSelected() );
                ArrayList <Resept> reseptene = system.getReseptRegister().FinnObjekterSomMatcher(query);
                String alleResepterForPasient ="";
                for (Resept r : reseptene)
                {
                    alleResepterForPasient += r.toString() + "\n-----------------\n";
                }
                utskrift.setText("Fant følgende resepter for :\n"
                        + pasient.getNavn() + "\n-----------------\n" + alleResepterForPasient);
        }           
        else
        {
            utskrift.setText("Du må velge en lege for å skrive ut");  
        }  
    }

    //Metode for å fange opp trykking på knapper
    public void actionPerformed(ActionEvent e)
    {
        if (e.getSource() == velgPasient)
        {
            VelgPasient();
        }
        else if (e.getSource() == visAllePasienter)
        {
            visAllePasienter();
        }
        else if (e.getSource() == visResepteriGruppe)
        {
            visResepterForPasient();
        }

        else if (e.getSource() == hjelp)
        {
            JOptionPane.showMessageDialog(null, "Pasient info. \n"+
                                                 "Velg lege ved å trykke på ...\n" +
                                                  "For mere informasjon trykk HER");
        }
    }

}//end of class LegeInfoGUI