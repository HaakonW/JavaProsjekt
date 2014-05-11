/*
Vindu som viser hvem som har laget programmet, rettigheter og lignende.

Laget av Peter Wilhelmsen
Sist endret 11-05-14
 */

package norskreseptregister;

import java.awt.Color;
import java.awt.Font;
import javax.swing.JFrame;
import javax.swing.JTextArea;

public class OmVindu
{
    private JFrame ramme;
    private JTextArea utskrift;
    private Font font;
    private String tekst;
            
    public OmVindu()
    {
        ramme = new JFrame();
        utskrift = new JTextArea();
        font = new Font("Monospaced",Font.PLAIN,11);
        
        tekst = "\nNorsk ReseptRegister av \n"
                + "Henrik Bjelland, Haakon Winther & Peter Wilhelmsen\n\n";
        tekst += "Norsk ReseptRegister version 1.0 \n™ and © 2014 Gruppe 38.\n";
        tekst += "All Rights Reserved.";
        
        utskrift.setText(tekst);
        utskrift.setFont(font);
        utskrift.setBackground(Color.LIGHT_GRAY);
        utskrift.setEditable(false);
        
        ramme.setTitle("Norsk ReseptRegister");
        ramme.add(utskrift);
        ramme.setSize(350,400);
        //ramme.pack();
        ramme.setLocationRelativeTo(null);
        ramme.setVisible(true);
    }
}
