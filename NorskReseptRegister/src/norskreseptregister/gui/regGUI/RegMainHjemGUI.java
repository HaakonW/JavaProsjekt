/*
Filen inneholder klassen RegMainHjemGUI. 
Laget av Henrik Fischer Bjelland, Haakon Winther 
Sist endret 27-04-2014 
 */
package norskreseptregister.gui.regGUI;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

/*
Det er denne filen som gjør at hjem siden har de 3 ikonene for endre lisens, registrer medisisn eller statestikk.
Det er her man kan endre bildene, knapper eller utseene for hjem fanen.
*/
public class RegMainHjemGUI extends JPanel implements ActionListener
{
    private JButton regPasient, regLege, regResept;
    private JPanel knappepanel;
    private JLabel pasientlabel, legelabel, reseptlabel;
    private final RegMainGUI regMainGUI;

    public RegMainHjemGUI(RegMainGUI regMainGUI)
    {
        this.regMainGUI = regMainGUI;
        ImageIcon regLeg = new ImageIcon("src/norskreseptregister/gui/bilder/doktor.png");
        ImageIcon regPas = new ImageIcon("src/norskreseptregister/gui/bilder/person.png");
        ImageIcon regRes = new ImageIcon("src/norskreseptregister/gui/bilder/Resept.png");
        
        regPasient = new JButton(regPas);
        regPasient.setFocusPainted(false);
        regPasient.addActionListener(this);
        regPasient.setToolTipText("Registrer pasient");
        
        regLege = new JButton(regLeg);
        regLege.setFocusPainted(false);
        regLege.addActionListener(this);
        regLege.setToolTipText("Registrer lege");
        
        regResept = new JButton(regRes);
        regResept.setFocusPainted(false);
        regResept.addActionListener(this);
        regResept.setToolTipText("Registrer resept");      

        pasientlabel = new JLabel("Registrer Pasient");
        pasientlabel.setFont(new Font("PT Serif", Font.PLAIN, 20));
        
        legelabel = new JLabel("Registrer Lege");
        legelabel.setFont(new Font("PT Serif", Font.PLAIN, 20));
        
        reseptlabel = new JLabel("Registrer Resept");
        reseptlabel.setFont(new Font("PT Serif", Font.PLAIN, 20));

        knappepanel = new JPanel();
        knappepanel.add(regPasient);
        knappepanel.add(regLege);
        knappepanel.add(regResept);
        
        /*
         START INNSETTINGEN AV ELEMENTENE I LAYOUTEN
         OPPRETTER EN INT X OG INT Y FOR Å ENKELT KUNNE UTVIDE
         MED FLERE ELEMENTER        
         INSETS ER AVSTAND FRA TOP, VENSTRE, BUNN OG HØYRE
        */       

        GridBagConstraints gc = new GridBagConstraints();
        setLayout(new GridBagLayout());

        int x = 0;
        int y = 0;

        gc.gridx = 0;
        gc.gridy = ++y;
        gc.insets = new Insets(10, 10, 10, 10);
        add(regPasient, gc);

        gc.gridx = ++x;
        gc.gridy = y;
        add(regLege, gc);

        gc.gridx = ++x;
        gc.gridy = y;
        add(regResept, gc);

        x = 0; // NULLSTILLER X pga ny rad

        gc.gridx = x;
        gc.gridy = ++y;
        add(pasientlabel, gc);

        gc.gridx = ++x;
        gc.gridy = y;
        add(legelabel, gc);

        gc.gridx = ++x;
        gc.gridy = y;
        add(reseptlabel, gc);
    }
    /** METODE FOR Å BLI SENDT VIDERE TIL DE ANDRE FANENENE FRA FORSIDEN
        DETTE ER FOR Å BLI SENDT VIDERE MED KNAPPENE ***/
    public void actionPerformed(ActionEvent e)
    {
        if (e.getSource() == regPasient)
        {
            regMainGUI.getTabbedPane().setSelectedIndex(1);
        } else if (e.getSource() == regLege)
        {
            regMainGUI.getTabbedPane().setSelectedIndex(2);
        } else if (e.getSource() == regResept)
        {
            regMainGUI.getTabbedPane().setSelectedIndex(3);
        }
    }
}//end of class RegMainHjemGUI