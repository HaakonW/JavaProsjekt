/*
 Filen inneholder klassen AdminMainHjemGUI.
 Laget av Henrik Fischer Bjelland, Haakon Winther
 Sist endret 11-05-2014
 */
package norskreseptregister.gui.info;

import java.awt.*;
import java.awt.event.*;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import norskreseptregister.Reg.RegisterSystem;
import norskreseptregister.gui.LegeLisensGUI;

/*
 InfoMainHjemGUI er siden du kommer til ved å trykke på Informasjon i hovedprogrammet. 
 Den inneholder tre knapper som sender deg videre til en av informasjonsvinduene.
 Det er her man kan endre bildene, knapper eller utseende for hjem fanen.
 */
public class InfoMainHjemGUI extends JPanel implements ActionListener
{
    private JButton legeInfo, pasientInfo, medisinInfo;
    private JLabel legelabel, pasientlabel, medisinlabel;
    LegeLisensGUI paneltest;
    private RegisterSystem system;
    private final InfoMainGUI infoMainGUI;

    public InfoMainHjemGUI(InfoMainGUI infoMainGUI)
    {
        this.infoMainGUI = infoMainGUI;
        this.paneltest = new LegeLisensGUI(system);
        
        ClassLoader cl = this.getClass().getClassLoader();
        ImageIcon legeinf = new ImageIcon(cl.getResource("norskreseptregister/gui/bilder/docinfo.png"));
        ImageIcon pasinf = new ImageIcon(cl.getResource("norskreseptregister/gui/bilder/pasinfo.png"));
        ImageIcon medinf = new ImageIcon(cl.getResource("norskreseptregister/gui/bilder/epille.png"));

        legeInfo = new JButton(legeinf);
        pasientInfo = new JButton(pasinf);
        medisinInfo = new JButton(medinf);

        legeInfo.setFocusPainted(false);

        legeInfo.setToolTipText("Info om lege");
        pasientInfo.setToolTipText("Info om pasient");
        medisinInfo.setToolTipText("Info om medisin");

        legeInfo.addActionListener(this);
        pasientInfo.addActionListener(this);
        medisinInfo.addActionListener(this);

        legelabel = new JLabel("LegeInfo");
        legelabel.setFont(new Font("PT Serif", Font.PLAIN, 20));

        pasientlabel = new JLabel("PasientInfo");
        pasientlabel.setFont(new Font("PT Serif", Font.PLAIN, 20));

        medisinlabel = new JLabel("MedisinInfo");
        medisinlabel.setFont(new Font("PT Serif", Font.PLAIN, 20));

        /* Her starter layouten for registrer en person. Sjekk
         produktdokumentasjonen for forklaring av layouten*/
        GridBagConstraints gc = new GridBagConstraints();
        setLayout(new GridBagLayout());

        int x = 0;
        int y = 0;

        gc.gridx = 0;
        gc.gridy = ++y;
        gc.insets = new Insets(10, 10, 10, 10);
        add(legeInfo, gc);

        gc.gridx = ++x;
        gc.gridy = y;
        add(pasientInfo, gc);

        gc.gridx = ++x;
        gc.gridy = y;
        add(medisinInfo, gc);

        x = 0;

        gc.gridx = x;
        gc.gridy = ++y;
        add(legelabel, gc);

        gc.gridx = ++x;
        gc.gridy = y;
        add(pasientlabel, gc);

        gc.gridx = ++x;
        gc.gridy = y;
        add(medisinlabel, gc);
    }

    // Metode for å lytte på hvilken knapp som er trykket på og kaller deretter på en spesifikk metode
    public void actionPerformed(ActionEvent e)
    {
        if (e.getSource() == legeInfo)
        {
            infoMainGUI.getTabbedPane().setSelectedIndex(1);
        }
        else if (e.getSource() == pasientInfo)
        {
            infoMainGUI.getTabbedPane().setSelectedIndex(2);
        }
        else if (e.getSource() == medisinInfo)
        {
            infoMainGUI.getTabbedPane().setSelectedIndex(3);
        }
    }
}//end of class AdminMainHjemGUI
