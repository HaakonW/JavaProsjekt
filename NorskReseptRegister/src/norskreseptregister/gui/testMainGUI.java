/*
 * Filen er opprettet for å teste ut internvindu
 * Laget av Peter Wilhelmsen
 * Sist endret  08/04/14
 */

package norskreseptregister.gui;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import norskreseptregister.RegisterSystem;
import java.awt.image.*;
import javax.imageio.*;


public class testMainGUI extends JFrame
{
    JButton testknapp;
    JButton info;
    JButton registrer;
    JButton admin;
    JButton rad, rad1, rad2, rad3, rad4, rad5, rad6, rad7, rad8, rad9, rad10, rad11, rad12, rad13, rad14;
    JButton k, k1, k2, k3, k4, k5, k6, k7, k8, k9, k10, k11, k12, k13, k14;
    JLabel header;
    ImageIcon bilde;
    
    //Tilført for å få internvidu
    private JDesktopPane hovedvindu;
    
    public testMainGUI()
    {
        //Tilført for å få internvindu
        super("Testvindu");
        
        JMenuBar menylinje = new JMenuBar();
        JMenu addmeny = new JMenu("Lag vindu");
        JMenuItem lagVindu = new JMenuItem("Lag interntvindu");
        lagVindu.addActionListener(new Menylytter());
        menylinje.add(addmeny);
        setJMenuBar(menylinje);
        
        
        //oppretter desktoppen
        hovedvindu = new JDesktopPane();
        getContentPane().add(hovedvindu, BorderLayout.CENTER);
        setSize(600,400);
        
       
        
        
        testknapp = new JButton("test");
        //info = new JButton("infotest");
        //registrer = new JButton("registrertest");
        add(testknapp);
        //add(info);
        //add(registrer);
       
        
        testknapp.addActionListener(new Knappelytter());
        
        setVisible(true);
        
        
        
        /*Dimension size = getPreferredSize();
        size.width = 250;
        setPreferredSize(size);
        setVisible(true);
        setSize(900,500);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); 

        ImageIcon bilde = new ImageIcon("src/norskreseptregister/gui/bilder/pille.png");
        ImageIcon footer = new ImageIcon ("src/norskreseptregister/gui/bilder/footer.png");
        JLabel header = new JLabel("Velkommen til Norsk Reseptregister. Dette er hovedmenyen. Herfra kan du navigere videre.");

        JLabel footerlabel = new JLabel(footer);
        JLabel pillelabel = new JLabel (bilde);
 
        
        info = new JButton("Info");
        registrer = new JButton("Register");
        admin = new JButton("Admin");
        rad = new JButton("0.0");
        rad1 = new JButton("1");
        rad2 = new JButton("2");
        rad3 = new JButton("3");
        rad4 = new JButton("4");
        rad5 = new JButton("5");
        rad6 = new JButton("6");
        rad7 = new JButton("7");
        rad8 = new JButton("8");
        rad9 = new JButton("9");
        rad10 = new JButton("10");
        rad11 = new JButton("11");
        rad12 = new JButton("12");
     
        
       
        k1 = new JButton("1");
        k2 = new JButton("2");
        k3 = new JButton("3");
        k4 = new JButton("4");
        k5 = new JButton("5");
        k6 = new JButton("6");
        k7 = new JButton("7");
        k8 = new JButton("8");
        k9 = new JButton("9");
        k10 = new JButton("10");
        k11 = new JButton("11");
        k12 = new JButton("12");
        k13 = new JButton("13");
        k14 = new JButton("14");
        
        
                
        setLayout(new GridBagLayout());
        GridBagConstraints gc = new GridBagConstraints();
        
        //// HEADER ////
        
        gc.gridx = 0;
        gc.gridy = 0;
        add(rad, gc);
        
         gc.gridx = 1;
        gc.gridy = 0;
        add(rad1, gc);
        
         gc.gridx = 2;
        gc.gridy = 0;
        add(rad2, gc);
        
         gc.gridx = 3;
        gc.gridy = 0;
        add(rad3, gc);
        
         gc.gridx = 4;
        gc.gridy = 0;
        add(rad4, gc);
        
         gc.gridx = 5;
        gc.gridy = 0;
        add(rad5, gc);
        
         gc.gridx = 6;
        gc.gridy = 0;
        add(rad6, gc);
        
         gc.gridx = 7;
        gc.gridy = 0;
        add(rad7, gc);
        
         gc.gridx = 8;
        gc.gridy = 0;
        add(rad8, gc);
        
         gc.gridx = 9;
        gc.gridy = 0;
        add(rad9, gc);
        
         gc.gridx = 10;
        gc.gridy = 0;
        add(rad10, gc);
        
         gc.gridx = 11;
        gc.gridy = 0;
        add(rad11, gc);
        
         gc.gridx = 12;
        gc.gridy = 0;
        add(rad12, gc);
        
   
        //////// yyy//////
        gc.gridx=0;
        gc.gridy=1;
        add(k1, gc);
        
         gc.gridx=0;
        gc.gridy=2;
        add(k2, gc);
        
         gc.gridx=0;
        gc.gridy=3;
        add(k3, gc);
        
         gc.gridx=0;
        gc.gridy=4;
        add(k4, gc);
        
         gc.gridx=0;
        gc.gridy=5;
        add(k5, gc);
        
         gc.gridx=0;
        gc.gridy=6;
        add(k6, gc);
        
         gc.gridx=0;
        gc.gridy=7;
        add(k7, gc);
        
         gc.gridx=0;
        gc.gridy=8;
        add(k8, gc);
        
         gc.gridx=0;
        gc.gridy=9;
        add(k9, gc);
        
         gc.gridx=0;
        gc.gridy=10;
        add(k10, gc); 
        
       //////////////////    
        
      
   
       
       ///// BUTTON START //// 
        gc.gridx = 1;
        gc.gridy = 4;
        gc.gridwidth = 5;
        gc.fill = GridBagConstraints.HORIZONTAL;
        gc.insets = new Insets(10, 10, 10, 10);        
        add(info, gc);      
           
         
        gc.gridx = 1;
        gc.gridy = 5;
        //gc.gridwidth = 6;
        //gc.fill = GridBagConstraints.HORIZONTAL;
        add(registrer, gc);
        
       
        gc.gridx = 1;
        gc.gridy = 6;
        add(admin, gc);
        
        ////// BUTTON SLUTT /////
        
        /// START LOGO //////
        
        gc.gridx = 7;
        gc.gridy = 4; 
        gc.gridheight = 4;/*
        gc.gridwidth = 4;
        gc.fill = GridBagConstraints.VERTICAL;
        gc.fill = GridBagConstraints.HORIZONTAL;*/
        //add(pillelabel, gc);
        
        
        ///// SLUTT LOGO ///////
    
        
        
          
        
        // FINAL ROW
    /*
        gc.gridx = 1;
        gc.gridy = 3;
        add(footerlabel, gc);*/


    }
    
class panel extends JPanel
{

  private ImageIcon bilde;
  /*private String[] bildefiler =
  {
    "yellowflowers.png", "purpleflowers.png",
    "redflowers.png", "redflowers2.png", "lavenderflowers.png"
  };*/

  // velger et tilfeldig bilde for panelet
  public panel()
  {
    bilde = new ImageIcon("src/norskreseptregister/gui/bilder/pille.png");
    /*int randomNumber = (int) (Math.random() * 5);
    bilde = new ImageIcon(getClass().getResource(
            "bilder/" + bildefiler[randomNumber]));*/
  }

  // tegner ut bildet på panelet
  public void paintComponent(Graphics g)
  {
    super.paintComponent(g);
    bilde.paintIcon(this, g, 0, 0);
  }

  // returnerer bildets størrelse
  public Dimension getPreferredSize()
  {
    return new Dimension(bilde.getIconWidth(),
            bilde.getIconHeight());
  }
} // slutt på klasse Bildepanel
    
    
    
    class Menylytter implements ActionListener
    {
        public void actionPerformed(ActionEvent Event)
        {
            JInternalFrame internvindu = new JInternalFrame("Intern",true,true,true,true);
            Container c = internvindu.getContentPane();
            MedisinGUI ny = new MedisinGUI();
            //panel panel1 = new panel();
            
            c.add(ny,BorderLayout.CENTER);
            internvindu.setVisible(true);
            internvindu.setSize(200,200);
            
            hovedvindu.add(internvindu);
            
        }
    }
    
    
    class Knappelytter implements ActionListener
    {
        // HVA MÅ KALLES PÅ HER FOR Å FÅ OPP DE ANDRE PROGRAMMENE? ///
        public void actionPerformed( ActionEvent e )
        {
           if (e.getSource() ==  testknapp)
           {
               //InfoMainGUI vindu = new InfoMainGUI();
               JInternalFrame internvindu = new JInternalFrame("Intern",true,true,true,true);
               
               Container c = internvindu.getContentPane();
               MedisinGUI ny = new MedisinGUI();
               //JButton ny = new JButton();
               c.add(ny, BorderLayout.CENTER);
               
               hovedvindu.add(internvindu);
               internvindu.setVisible(true);
            } 
           else if (e.getSource() == registrer)
           {
              //KAller på Registrer vinduet   
           }
           else if (e.getSource() == info)
           {
               //Kaller på admin vinduet
           }
        }
        
    }//end of class Knappelytter
  
       
}
