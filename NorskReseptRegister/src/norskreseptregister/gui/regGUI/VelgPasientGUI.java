/*
Filen inneholder klassen VelgPasientGUI
Laget av  Henrik Fischer Bjelland
Sist endret 17-04-2014  
*/

package norskreseptregister.gui.regGUI;

import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.Random;
import javax.swing.*;
import norskreseptregister.gui.regGUI.RegistrerResept;

public class VelgPasientGUI extends JDialog
{
  private JList<String> navneliste;
  private String[] navn =
  {
    "Tjuven", "Cpt. Redbeard", "HønefossPrisen", "Solli.Prins",
    "Blæsert.Prins","Ekeberg.Prins"
  };
  private JButton ok, dropp;
  //private Navnevalg forelder;
  private Knappelytter kLytter;
  private Muselytter mLytter;

  public VelgPasientGUI(RegistrerResept registrerResept/*Navnevalg f*/)
  {
    //super(registrerResept,"Navnevelger", true); //modalt dialogvindu
    //forelder = f;
    navneliste = new JList<>(navn);
    //skal bare kunne velge ett navn om gangen:
    navneliste.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
    //velger et tilfeldig startnavn i lista:
    Random velger = new Random();
    int start = velger.nextInt(navn.length);
    navneliste.setSelectedIndex(start);
    String startnavn = navneliste.getSelectedValue();
    //forelder.settNavn(startnavn);
    
    JPanel listepanel = new JPanel();
    listepanel.setLayout(new BoxLayout(listepanel, 
            BoxLayout.PAGE_AXIS));
    listepanel.add(new JLabel("Jentenavn som slutter på e:"));
    listepanel.add(Box.createRigidArea(new Dimension(0, 5)));
    JScrollPane listeskroller = new JScrollPane(navneliste);
    listeskroller.setPreferredSize(new Dimension(250, 80));
    listeskroller.setMinimumSize(new Dimension(250, 80));
    listeskroller.setAlignmentX(LEFT_ALIGNMENT); 
                                //ønsker venstrejustering
    listepanel.add(listeskroller);
    listepanel.setBorder(
            BorderFactory.createEmptyBorder(10, 10, 10, 10));

    JPanel knappepanel = new JPanel();
    knappepanel.setLayout(new BoxLayout(knappepanel, 
            BoxLayout.LINE_AXIS));
    knappepanel.setBorder(
            BorderFactory.createEmptyBorder(0, 10, 10, 10));
    knappepanel.add(Box.createHorizontalGlue());
    ok = new JButton("OK");
    dropp = new JButton("Dropp å velge");
    knappepanel.add(dropp);
    knappepanel.add(Box.createRigidArea(new Dimension(10, 0)));
    knappepanel.add(ok);

    kLytter = new Knappelytter();
    ok.addActionListener(kLytter);
    dropp.addActionListener(kLytter);
    mLytter = new Muselytter();
    navneliste.addMouseListener(mLytter);

    Container c = getContentPane();
    c.add(listepanel, BorderLayout.CENTER);
    c.add(knappepanel, BorderLayout.PAGE_END);
    pack();
    //sikrer at det valgte navnet er synlig i navnelista når 
    //dialogvinduet blir åpnet:
    navneliste.ensureIndexIsVisible(start);
  }

  private class Knappelytter implements ActionListener
  {
    public void actionPerformed(ActionEvent e)
    {
      if (e.getSource() == ok)
      {
        String navn = navneliste.getSelectedValue();
        //forelder.settNavn(navn);
        setVisible(false);
      }
      else if (e.getSource() == dropp)
      {
        setVisible(false);
      }
    }
  }

  //Lytter på dobbeltklikk i navnelista
  private class Muselytter extends MouseAdapter
  {
    public void mouseClicked(MouseEvent e)
    {
      if (e.getSource() == navneliste && e.getClickCount() == 2)
      {
        ok.doClick();  //samme effekt som å klikke på ok-knappen
      }
    }
  }
}