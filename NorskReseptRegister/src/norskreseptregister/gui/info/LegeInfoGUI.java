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
    private JPanel panel1, panel2, panel3, panel4, panel5, panel6;
    private JLabel fornavnlabel, gruppelabel;
    private JButton visAlleLeger, visResepteriGruppe, velgLege, hjelp;
    private JCheckBox a, b, c;
    private Lege lege;
    private RegisterSystem system;
    private LegeRegister legeRegister;

    public LegeInfoGUI(RegisterSystem system, LegeRegister legeRegister)
    {
        this.system = system;
        this.legeRegister = legeRegister;
        fornavnlabel = new JLabel("Legenavn   ");
        gruppelabel = new JLabel("Reseptgruppe");
        legedatafelt = new JTextField(20);
        visAlleLeger = new JButton("Vis alle leger");
        legedatafelt.setText("Velg lege ved å på knappen til høyre");

        visResepteriGruppe = new JButton("Vis resepter");
        hjelp = new JButton("?");
        velgLege = new JButton("...");

        utskrift = new JTextArea(20,20);
        utskrift.setEditable(false); 
        utskriftscroll = new JScrollPane(utskrift);
        utskriftscroll.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);

        a = new JCheckBox("A", true);        
        b = new JCheckBox("B", true);
        c = new JCheckBox("C", true);

        velgLege.addActionListener(this);
        visResepteriGruppe.addActionListener(this);
        visAlleLeger.addActionListener(this);
        hjelp.addActionListener(this);

        velgLege.setPreferredSize(new Dimension(20, 20));
        legedatafelt.setEditable(false);
        hjelp.setPreferredSize(new Dimension(20, 20));

        ///PANELS START ////
        panel1 = new JPanel();
        panel1.add(fornavnlabel);
        panel1.add(legedatafelt);
        panel1.add(velgLege);

        panel4 = new JPanel();
        panel4.setBorder(BorderFactory.createEtchedBorder());
        panel4.add(gruppelabel);
        panel4.add(a);
        panel4.add(b);
        panel4.add(c);
        panel4.add(visResepteriGruppe);

        panel5 = new JPanel();
        panel5.add(utskriftscroll);

        ///GRID START ////
        GridBagConstraints gc = new GridBagConstraints();
        setLayout(new GridBagLayout());
        gc.gridx = 0;
        gc.gridy = 0;
        gc.insets = new Insets(10, 5, 5, 10);
        add(panel1, gc);

        gc.gridx = 0;
        gc.gridy = 1;
        add(panel4, gc);

        gc.gridx = 0;
        gc.gridy = 2;
        add(visAlleLeger, gc);

        gc.gridx = 1;
        gc.gridy = 0;
        gc.gridheight = 6;
        add(panel5, gc);

        gc.gridx = 2;
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
            if ( a.isSelected() )
            {
                utskrift.setText("skriver ut alle resepter" + "\n" + "i medisinklasse a");
            }
            if (b.isSelected())
            {
                utskrift.setText("skriver ut alle resepter" + "\n" + " i medisinklasse b");
            }
            if ( c.isSelected())
            {
                utskrift.setText("skriver ut alle resepter" + "\n" + " i medisinklasse c");
            }
            if ( a.isSelected() && b.isSelected())
            {
                utskrift.setText("skriver ut alle resepter" + "\n" + " i medisinklasse a og b");
            } 
            if ( a.isSelected() && c.isSelected())
            {
                utskrift.setText("skriver ut alle resepter" + "\n" + " i medisinklasse a og c");
            } 
            if ( b.isSelected() && c.isSelected())
            {
                utskrift.setText("skriver ut alle resepter" + "\n" + " i medisinklasse b og c");
            }
            if (a.isSelected() && b.isSelected() && c.isSelected())
            {
                FinnResepterForLege query = new FinnResepterForLege(lege);
                ArrayList <Resept> reseptene = system.getReseptRegister().FinnObjekterSomMatcher(query);
                String alleResepterForLege ="";
                for (Resept r : reseptene)
                {
                    alleResepterForLege += r.toString() + "\n-----------------\n";
                }
                utskrift.setText("Fant følgende resepter for :\n"
                        + lege.getNavn() + "\n-----------------\n" + alleResepterForLege);   
                
            }
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