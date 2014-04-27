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
import norskreseptregister.ObjektKlasser.Lege;
import norskreseptregister.ObjektKlasser.Resept;
import norskreseptregister.Reg.LegeRegister;
import norskreseptregister.Reg.RegisterSystem;
import norskreseptregister.gui.regGUI.VelgPersonGUI;

public class LegeInfoGUI extends JPanel implements ActionListener
{
    private JTextField legedatafelt;
    private JTextArea utskrift;
    private JScrollPane utskriftscroll;
    private JPanel panel1, panel2;
    private JLabel legelabel, gruppelabel;
    private JButton visAlleLeger, visResepteriGruppe, velgLege, hjelp;
    private JCheckBox a, b, c;
    private Lege lege;
    private RegisterSystem system;
    private LegeRegister legeRegister;

    public LegeInfoGUI(RegisterSystem system, LegeRegister legeRegister)
    {
        this.system = system;
        this.legeRegister = legeRegister;
        
        legelabel = new JLabel("Legenavn   ");
        legedatafelt = new JTextField(20);
        legedatafelt.setText("Velg lege ved å på knappen til høyre");
        legedatafelt.setEditable(false);
        
        gruppelabel = new JLabel("Reseptgruppe");
        a = new JCheckBox("A", true);        
        b = new JCheckBox("B", true);
        c = new JCheckBox("C", true);
        
        visAlleLeger = new JButton("Print alle leger");
        visAlleLeger.setToolTipText("Trykk for å printe leger");
        visAlleLeger.addActionListener(this);       

        visResepteriGruppe = new JButton("Vis resepter");
        visResepteriGruppe.setToolTipText("Vis resepter i gruppe");
        visResepteriGruppe.addActionListener(this);
        
        hjelp = new JButton("?");
        hjelp.setToolTipText("Trykk for hjelp");
        hjelp.addActionListener(this);
        hjelp.setPreferredSize(new Dimension(20, 20));
        
        velgLege = new JButton("...");
        velgLege.setToolTipText("Trykk for å velge lege");
        velgLege.addActionListener(this);
        velgLege.setPreferredSize(new Dimension(20, 20));

        utskrift = new JTextArea(20,20);
        utskrift.setEditable(false); 
        utskriftscroll = new JScrollPane(utskrift);
        utskriftscroll.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);

       ///PANELS START ////
        panel1 = new JPanel();
        panel1.add(legelabel);
        panel1.add(legedatafelt);
        panel1.add(velgLege);
        panel1.setBorder(BorderFactory.createEtchedBorder());  

        panel2 = new JPanel();
        panel2.setBorder(BorderFactory.createEtchedBorder());
        panel2.add(gruppelabel);
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
        add(visAlleLeger, gc);

        gc.gridx = ++x;
        gc.gridy = 0;
        gc.gridheight = 6;
        add(utskriftscroll, gc);

        gc.gridx = ++x;
        gc.gridy = 6;
        add(hjelp, gc);
    }//end of Konstruktør
    
    //Metoden velger en lege.
    public void VelgLege()
    {
        LegeRegister legeRegister = system.getLegeRegister();
        DefaultListModel model = new DefaultListModel();
        for (Lege l : legeRegister.FinnAlleObjekter())
        {
            model.addElement(l.toString());
        }

        VelgPersonGUI velgLege = new VelgPersonGUI(model);
        velgLege.setLocationRelativeTo(this);
        velgLege.setVisible(true);
        int valgtIndex = velgLege.getValgtIndex();
        if (valgtIndex >= 0)    // Dvs at brukeren faktisk har gjort et valg
        {
            lege = legeRegister.HentEttObjekt(valgtIndex);
            legedatafelt.setText(lege.getNavn());
        }
    }
    
    //Metoden går igjennom listen med leger og returnerer disse i utskriftfeltet
    private void visAlleLeger()
    {
        String legeliste = "";
        List <Lege> list = system.getLegeRegister().FinnAlleObjekter();
        for (Lege lege : list)
        {
            legeliste+= lege.toString();
            legeliste +="\n\n";
        }
        utskrift.setText(legeliste);
    }
    
    //Metoden viser hvilke resepter en spesifikk lege har skrevet ut
    public void visResepterForLege()
    {
        if ( lege != null)
        {
                FinnResepterForLegeIReseptGruppe query = new FinnResepterForLegeIReseptGruppe(
                        lege, a.isSelected(), b.isSelected(), c.isSelected() );
                ArrayList <Resept> reseptene = system.getReseptRegister().FinnObjekterSomMatcher(query);
                String alleResepterForLege ="";
                for (Resept r : reseptene)
                {
                    alleResepterForLege += r.toString() + "\n-----------------\n";
                }
                utskrift.setText("Fant følgende resepter for :\n"
                        + lege.getNavn() + "\n-----------------\n" + alleResepterForLege);
        }           
        else
        {
            utskrift.setText("Du må velge en lege for å skrive ut");  
        }  
    }
    
    /*Metode for å lytte på hvilken knapp som er trykket på og kaller da 
    på metoden knyttet til denne knappen*/
    public void actionPerformed(ActionEvent e)
    {
        if (e.getSource() == velgLege)
        {
            VelgLege();
        }
        else if (e.getSource() == visAlleLeger)
        {
            visAlleLeger();
        }
        else if (e.getSource() == visResepteriGruppe)
        {
            visResepterForLege();
        }
     
        else if (e.getSource() == hjelp)
        {
            JOptionPane.showMessageDialog(null, "HJELP LEGEINFO");
        }
    }
    
}//end of class LegeInfoGUI