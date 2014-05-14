/*
 Filen inneholder klassen LegeInfoGUI
 Laget av Henrik Fischer Bjelland, Haakon Winther, Peter Wilhelmsen
 Sist endret 11-05-2014 
 */
package norskreseptregister.gui.info;

import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import norskreseptregister.HovedVindu;
import javax.swing.ToolTipManager;
import norskreseptregister.ObjektKlasser.Medisin;
import norskreseptregister.ObjektKlasser.Medisinliste;
import norskreseptregister.ObjektKlasser.Resept;
import norskreseptregister.Reg.RegisterSystem;
import norskreseptregister.gui.regGUI.VelgFraListeGUI;

//I MedisnInfoGUi kan man få informasjon om hvilke leger eller pasient som er tilknyttet en spesiell medisin
public class MedisinInfoGUI extends JPanel implements ActionListener
{
    private JTextField medisindatafelt;
    private JTextArea utskrift;
    private JScrollPane utskriftscroll;
    private JPanel medisinpanel, knappepanel;
    private JLabel medisinlabel;
    private JButton visPasient, visLeger, velgMedisin, hjelp;
    private final Medisinliste medisinliste;
    private final RegisterSystem system;
    private Medisin medisin;

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

        ClassLoader cl = this.getClass().getClassLoader();
        ImageIcon hjelpikon = new ImageIcon(cl.getResource("norskreseptregister/gui/bilder/hjelp.png"));
        hjelp = new JButton(hjelpikon);
        hjelp.addActionListener(this);
        hjelp.setPreferredSize(new Dimension(18, 25));
        hjelp.addMouseListener(new MouseAdapter(){
            public void mouseEntered(MouseEvent e){
                ToolTipManager.sharedInstance().setDismissDelay(6500);
            }
        });
        hjelp.setToolTipText("<html>" + "Velg medisin med ...knappen.<br>"
                            + "Velg om du vil vise pasienter som har fått <br>"
                            + "eller leger som har skrevet ut valgt medisin.<br>"
                            + "Mer hjelp,se brukerveiledning s. 12");
        
        utskrift = new JTextArea(20, 20);
        utskrift.setEditable(false);
        utskrift.setLineWrap(true);
        utskrift.setWrapStyleWord(true);

        utskriftscroll = new JScrollPane(utskrift);
        utskriftscroll.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);

        medisinpanel = new JPanel();
        medisinpanel.add(medisinlabel);
        medisinpanel.add(medisindatafelt);
        medisinpanel.add(velgMedisin);
        medisinpanel.setBorder(BorderFactory.createEtchedBorder());

        knappepanel = new JPanel();
        knappepanel.add(visPasient);
        knappepanel.add(visLeger);
        knappepanel.setBorder(BorderFactory.createEtchedBorder());

        /* Her starter layouten for registrer en person. Sjekk
         produktdokumentasjonen for forklaring av layouten*/
        GridBagConstraints gc = new GridBagConstraints();
        setLayout(new GridBagLayout());

        int x = 0;
        int y = 0;

        gc.gridx = x;
        gc.gridy = y;
        gc.insets = new Insets(5, 10, 5, 10);
        gc.fill = GridBagConstraints.HORIZONTAL;
        add(medisinpanel, gc);

        gc.gridx = x;
        gc.gridy = ++y;
        add(knappepanel, gc);

        gc.gridx = ++x;
        gc.gridy = 0;
        gc.gridheight = 6;
        add(utskriftscroll, gc);

        gc.gridx = 2;
        gc.gridy = 6;
        add(hjelp, gc);
    }

    // Metode for å velge medisin
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
            medisindatafelt.setText(medisin.getNavn());
        }
    }

    // Metode for å vise hvilke pasienter som har mottat en valgt medisin
    private void visPasienter()
    {
        FinnReseptForMedisin query = new FinnReseptForMedisin(medisin);
        ArrayList<Resept> resepter = system.getReseptRegister().FinnObjekterSomMatcher(query);
        HashMap<String, Resept> unikePasientResepter = new HashMap<>();
        String pasienter = "";
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

    // Metode for å vise hvilke leger som har skrevet ut en spesiell medisin
    private void visLeger()
    {
        FinnReseptForMedisin query = new FinnReseptForMedisin(medisin);
        ArrayList<Resept> resepter = system.getReseptRegister().FinnObjekterSomMatcher(query);
        HashMap<String, Resept> unikeLegeResepter = new HashMap<>();
        String leger = "";
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

    // Metode for å lytte på hvilken knapp som er trykket på og kaller deretter på en spesifikk metode
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
            HovedVindu.visBrukerveiledning();

        }
    }

}//end of class LegeInfoGUI
