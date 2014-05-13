/*
 Filen inneholder klassen LegeInfoGUI
 Laget av Henrik Fischer Bjelland, Haakon Winther
 Sist endret 11-05-2014 
 */
package norskreseptregister.gui.info;

import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;
import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import norskreseptregister.HovedVindu;
import norskreseptregister.ObjektKlasser.Lege;
import norskreseptregister.ObjektKlasser.Resept;
import norskreseptregister.Reg.LegeRegister;
import norskreseptregister.Reg.RegisterSystem;
import norskreseptregister.gui.regGUI.VelgFraListeGUI;

// LegeInfoGUI skal kunne gi informasjon om hvilke resepter inne en valgt reseptgruppe en lege har skrevet ut resepter
public class LegeInfoGUI extends JPanel implements ActionListener
{
    private JTextField legedatafelt;
    private JTextArea utskrift;
    private JScrollPane utskriftscroll;
    private JPanel legepanel, knappepanel;
    private JLabel legelabel, gruppelabel;
    private JButton visAlleLeger, visResepteriGruppe, velgLege, hjelp;
    private JCheckBox a, b, c;
    private Lege lege;
    private RegisterSystem system;
    private LegeRegister legeRegister;
    private HovedVindu hovedvindu;

    public LegeInfoGUI(RegisterSystem system)
    {
        this.system = system;
        legeRegister = system.getLegeRegister();
        legelabel = new JLabel("Legenavn   ");
        legedatafelt = new JTextField(20);
        legedatafelt.setText("Velg lege ved å på knappen til høyre");
        legedatafelt.setEditable(false);

        gruppelabel = new JLabel("Reseptgruppe");
        a = new JCheckBox("A", true);
        b = new JCheckBox("B", true);
        c = new JCheckBox("C", true);

        visAlleLeger = new JButton("Vis alle leger");
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

        utskrift = new JTextArea(20, 20);
        utskrift.setEditable(false);
        utskrift.setLineWrap(true);
        utskrift.setWrapStyleWord(true);

        utskriftscroll = new JScrollPane(utskrift);
        utskriftscroll.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);

        legepanel = new JPanel();
        legepanel.add(legelabel);
        legepanel.add(legedatafelt);
        legepanel.add(velgLege);
        legepanel.setBorder(BorderFactory.createEtchedBorder());

        knappepanel = new JPanel();
        knappepanel.setBorder(BorderFactory.createEtchedBorder());
        knappepanel.add(gruppelabel);
        knappepanel.add(a);
        knappepanel.add(b);
        knappepanel.add(c);
        knappepanel.add(visResepteriGruppe);

        /* Her starter layouten for registrer en person. Sjekk
         produktdokumentasjonen for forklaring av layouten*/
        GridBagConstraints gc = new GridBagConstraints();
        setLayout(new GridBagLayout());
        int x = 0;
        int y = 0;

        gc.gridx = x;
        gc.gridy = y;
        gc.insets = new Insets(5, 10, 5, 10);
        add(legepanel, gc);

        gc.gridx = x;
        gc.gridy = ++y;
        gc.fill = GridBagConstraints.HORIZONTAL;
        add(knappepanel, gc);

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

    // Metode for å velge en lege
    public void VelgLege()
    {
        VelgFraListeGUI velgLege = new VelgFraListeGUI("Liste over alle leger:",
                "Velg lege", legeRegister.getListModel());
        velgLege.setLocationRelativeTo(this);
        velgLege.setVisible(true);
        int valgtIndex = velgLege.getValgtIndex();
        if (valgtIndex >= 0)    // Dvs at brukeren faktisk har gjort et valg
        {
            lege = legeRegister.HentEttObjekt(valgtIndex);
            legedatafelt.setText(lege.getNavn());
        }
    }

    // Metoden går igjennom listen med leger og returnerer disse i utskriftfeltet
    private void visAlleLeger()
    {
        String legeliste = "";
        List<Lege> list = system.getLegeRegister().FinnAlleObjekter();
        for (Lege lege : list)
        {
            legeliste += lege.toString();
            legeliste += "\n\n";
        }
        utskrift.setText(legeliste);
    }

    // Metoden viser hvilke resepter en spesifikk lege har skrevet ut
    public void visResepterForLege()
    {
        if (lege != null)
        {
            FinnResepterForLegeIReseptGruppe query = new FinnResepterForLegeIReseptGruppe(
                    lege, a.isSelected(), b.isSelected(), c.isSelected());
            ArrayList<Resept> reseptene = system.getReseptRegister().FinnObjekterSomMatcher(query);
            String alleResepterForLege = "";
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

    /*
     Metode for å lytte på hvilken knapp som er trykket på og kaller da 
     på metoden knyttet til denne knappen
     */
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
            hovedvindu.visBrukerveiledning();
        }
    }
}//end of class LegeInfoGUI
