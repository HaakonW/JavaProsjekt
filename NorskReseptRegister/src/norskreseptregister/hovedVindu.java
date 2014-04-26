/*
 Inneholder klasse for å kjøre hovedvindu, med MainGUI.
 Laget av Peter Wilhelmsen, Henrik Fischer Bjelland
 Sist endret 25/04/14
 */
package norskreseptregister;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Container;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.LayoutManager;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JDesktopPane;
import javax.swing.JFrame;
import javax.swing.JInternalFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import norskreseptregister.ObjektKlasser.Medisinliste;
import norskreseptregister.Reg.RegisterSystem;
import norskreseptregister.gui.AdminMain;
import norskreseptregister.gui.info.InfoMainGUI;
import norskreseptregister.gui.regGUI.RegMainGUI;

public class hovedVindu extends JFrame
{
    private JDesktopPane hovedvindu;
    private Menylytter lytter;

    private JMenuBar menylinje;
    private JMenu valg1;
    private JMenu valg2;
    private JMenu valg3;
    private JMenu valg4;

    private JMenuItem submeny1;
    private JMenuItem submeny2;
    private JMenuItem submeny3;
    private JMenuItem submeny4;
    
    private ImageIcon footer;
    private JDesktopPane p;
    
    private RegisterSystem system;
    private final Medisinliste medisinliste;

    //Konstruktør
    public hovedVindu(final RegisterSystem system, Medisinliste medisinliste)
    {
        lytter = new Menylytter();

        menylinje = new JMenuBar();
        valg1 = new JMenu("Admin");
        valg1.setMnemonic('A');
        valg2 = new JMenu("Registrere");
        valg2.setMnemonic('R');
        valg3 = new JMenu("Informasjon");
        valg3.setMnemonic('I');
        valg4 = new JMenu("Statistikk");
        valg4.setMnemonic('S');
        submeny1 = new JMenuItem("Gå inn");
        submeny2 = new JMenuItem("Åpne vinduet");
        submeny3 = new JMenuItem("Klikk videre");
        submeny4 = new JMenuItem("Vis statistikk");
        
        menylinje.add(valg1);
        menylinje.add(valg2);
        menylinje.add(valg3);
        menylinje.add(valg4);

        valg1.add(submeny1);
        valg2.add(submeny2);
        valg3.add(submeny3);
        valg4.add(submeny4);
        valg4.addSeparator(); //Legger inn skillelinje i submeny
        //valg4.add(); //Kun for å teste/se resultat av skillelinje

        submeny1.addActionListener(lytter);
        submeny2.addActionListener(lytter);
        submeny3.addActionListener(lytter);
        submeny4.addActionListener(lytter);

        //Setter inn menylinjen i vinduet.
        setJMenuBar(menylinje);

        ImageIcon footer = new ImageIcon ("src/norskreseptregister/gui/bilder/pille.png");
        final Image img = footer.getImage();
        
        //Opprette hovedvinduet
        hovedvindu = new JDesktopPane(){
             public void paintComponent(Graphics g){
                super.paintComponent(g);
                g.drawImage(img,400,170,450,350,this);
            }
        };
        
        //Skriver til alle register, ikke medisin.
        addWindowListener(new WindowAdapter()
        {
            public void windowClosing(WindowEvent winEvt)
            {
                system.SkrivTilFil();
            }
        });

     ////////////////////////////////////////////////////////////////////////
      /* EKSEMPEL PÅ INTERNALFRAME
      
         JInternalFrame ramme = new JInternalFrame("Internramme");
         ramme.setSize(300,200);
         ramme.setVisible(true);
         hovedvindu.add(ramme);*/
        ////////////////////////////////////////////////////////////////////////

        getContentPane().add(hovedvindu, BorderLayout.CENTER);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        hovedvindu.setBackground(Color.WHITE); //Sette bakgrunnsfarge på hovedvindu
        setSize(1450, 900);
        setVisible(true);
        this.system = system;
        this.medisinliste = medisinliste;

    }// End of Konstruktør

    //Skal lytte på trykk i menylinjen.
    private class Menylytter implements ActionListener
    {
        public void actionPerformed(ActionEvent e)
        {
            if (e.getSource() == submeny1)
            {
                JInternalFrame internvindu = new JInternalFrame(
                        "Admin", true, true, true, true);

                //plassere et panel i det nye interne vinduet
                //Container intern = internvindu.getContentPane();
                AdminMain ny = new AdminMain(system);
                internvindu.add(ny, BorderLayout.CENTER);

                internvindu.setDefaultCloseOperation(
                        JInternalFrame.DISPOSE_ON_CLOSE);

                internvindu.pack();
                internvindu.setLocation(-10,-2);

                hovedvindu.add(internvindu);
                internvindu.setVisible(true);
            }
            if (e.getSource() == submeny2)
            {
                JInternalFrame internvindu2 = new JInternalFrame(
                        "Registrering", true, true, true, true);

                RegMainGUI regG = new RegMainGUI(system, medisinliste);
                //Container c = internvindu.getContentPane();
                internvindu2.add(regG, BorderLayout.CENTER);

                internvindu2.setDefaultCloseOperation(
                        JInternalFrame.DISPOSE_ON_CLOSE);

                internvindu2.pack();
                
                internvindu2.setLocation(700,-2);
                hovedvindu.add(internvindu2);
                internvindu2.setVisible(true);
            }
            if (e.getSource() == submeny3)
            {
                JInternalFrame internvindu3 = new JInternalFrame(
                        "Informasjon", true, true, true, true);

                InfoMainGUI infoG = new InfoMainGUI(system, medisinliste);
                internvindu3.add(infoG, BorderLayout.CENTER);

                internvindu3.setDefaultCloseOperation(
                        JInternalFrame.DISPOSE_ON_CLOSE);

                internvindu3.pack();
                
                internvindu3.setLocation(-10,310);    
                hovedvindu.add(internvindu3);
                internvindu3.setVisible(true);
            }
            /*if(e.getSource() == submeny4)
            {
                JInternalFrame internvindu4 = new JInternalFrame(
                "Statistikk",true, true, true,true);
                
                StatistikkTabell statistikk = new StatistikkTabell();
                //internvindu4.add(statistikk);
                
                internvindu4.setSize(300,300);
                internvindu4.pack();
                hovedvindu.add(internvindu4);
                internvindu4.setVisible(true);
            }*/
        }//end of method actionPerformed
    } //end of Menylytter

}//end of class hovedVindu