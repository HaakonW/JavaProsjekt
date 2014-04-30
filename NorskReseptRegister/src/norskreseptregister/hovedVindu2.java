/*
 Filen inneholder klassen hovedVindu2.
 Klassen inneholder hovedvinduet som er det første du kommer til ved å kjøre programmet.
 Laget av Peter Wilhelmsen, Henrik Fischer Bjelland, Haakon Winther
 Sist endret 29/04/14
 */

package norskreseptregister;

import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import javax.swing.*;
import javax.swing.JButton;
import javax.swing.JFrame;
import norskreseptregister.ObjektKlasser.Medisinliste;
import norskreseptregister.Reg.RegisterSystem;
import norskreseptregister.gui.info.InfoMainGUI;
import norskreseptregister.gui.regGUI.RegMainGUI;

public class hovedVindu2 extends JFrame implements ActionListener
{  
    private JLabel label1, label2, label3,tekstLabel;
    private JButton adminVindu, registreringVindu, infoVindu;
    private RegisterSystem system;
    private Medisinliste medisinliste;
    private JMenuBar menylinje;
    private JMenu meny;
    private JMenuItem menuItem, menuItem2;
    
    public hovedVindu2(RegisterSystem system, Medisinliste medisinliste)
    {  
        this.system = system;
        this.medisinliste = medisinliste;
        ImageIcon admin = new ImageIcon("src/norskreseptregister/gui/bilder/Admin.png");
        ImageIcon register = new ImageIcon("src/norskreseptregister/gui/bilder/register.png");
        ImageIcon info = new ImageIcon("src/norskreseptregister/gui/bilder/info.png");
        
        adminVindu = new JButton(admin);
        registreringVindu = new JButton(register);
        infoVindu = new JButton(info);
        
        adminVindu.addActionListener(this);
        registreringVindu.addActionListener(this);
        infoVindu.addActionListener(this);
        
        tekstLabel = new JLabel("Velkomen til Norsk ReseptRegister.");
        tekstLabel.setFont(new Font ("PT Serif", Font.PLAIN, 17));
        
        label1 = new JLabel("Admin");
        label1.setFont(new Font ("PT Serif", Font.PLAIN, 20));
        
        label2 = new JLabel("Registrering");
        label2.setFont(new Font ("PT Serif", Font.PLAIN, 20));
        
        label3 = new JLabel("Informasjon");
        label3.setFont(new Font ("PT Serif", Font.PLAIN, 20));
        
        adminVindu.setFocusPainted(false);
        registreringVindu.setFocusPainted(false);
        infoVindu.setFocusPainted(false);
        
        adminVindu.setToolTipText("Gå til Admin");
        registreringVindu.setToolTipText("Gå til Registrering");
        infoVindu.setToolTipText("Gå til info"); 
        
        GridBagConstraints gc = new GridBagConstraints();
        setLayout(new GridBagLayout());      
       
        gc.gridx = 0;
        gc.gridy = 1; 
        gc.insets = new Insets(10,10,10,10);
        add(adminVindu, gc);
        
        gc.gridx = 1;
        gc.gridy = 1;
        add(registreringVindu, gc);
        
        gc.gridx = 2;
        gc.gridy = 1;
        add(infoVindu, gc);
        
        gc.gridx = 0;
        gc.gridy = 2;
        add(label1, gc);
        
        gc.gridx = 1;
        gc.gridy = 2;
        add(label2, gc);
        
        gc.gridx = 2;
        gc.gridy = 2;
        add(label3, gc);
        
        gc.gridx = 0;
        gc.gridy = 3;
        gc.fill = 3;
        gc.gridwidth= GridBagConstraints.VERTICAL;
        add(tekstLabel, gc);
        
        menylinje = new JMenuBar();
        setJMenuBar(menylinje);
        
        meny = new JMenu("Fil");
        menylinje.add(meny);
        
        meny.setMnemonic(KeyEvent.VK_E);
        meny.getAccessibleContext().setAccessibleDescription(
        "The only menu in this program that has menu items");
        
        //a group of JMenuItems
        menuItem = new JMenuItem("Om",
                         KeyEvent.VK_T);
        menuItem2 = new JMenuItem("Avslutt");
        
        menuItem.setAccelerator(KeyStroke.getKeyStroke(
        KeyEvent.VK_1, ActionEvent.ALT_MASK));
        menuItem.getAccessibleContext().setAccessibleDescription(
        "This doesn't really do anything");
        meny.add(menuItem);
        meny.add(menuItem2);
        
        setVisible(true);
        setSize(740, 400);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);  
    }

    //Metode for å lytte på hvilke knapp som er trykket og oppretter deretter et vindu av valgt type.
    public void actionPerformed(ActionEvent e)
    {
        if (e.getSource() == adminVindu)
        {
            LoggInn ny = new LoggInn(system, medisinliste);
        }
        else if(e.getSource() == registreringVindu)
        {
            RegMainGUI reg = new RegMainGUI(system, medisinliste);
            JFrame frame = new JFrame(); 
            frame.getContentPane().add(new RegMainGUI(system, medisinliste));
            frame.pack();
            frame.setSize(740, 500);
            frame.setVisible(true);
            frame.setLocationRelativeTo(null);
        }
        else if(e.getSource() == infoVindu)
        {
            InfoMainGUI infoG = new InfoMainGUI(system, medisinliste);
            JFrame frame = new JFrame();
            setLocationRelativeTo(null);
            frame.getContentPane().add(new InfoMainGUI(system, medisinliste));
            frame.pack();
            frame.setSize(740, 450);
            frame.setVisible(true);
            frame.setLocationRelativeTo(null);
        }
    }
}