/*
Filen inneholder klassen VelgPasientGUI.
Klassen er ment for å lage et JDialog vindu med alle objektene for enten Pasient, Lege eller medisin
utifra hvilke metode som blir kalt.
Laget av  Henrik Fischer Bjelland
Sist endret 27-04-2014  
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
import norskreseptregister.ObjektKlasser.Pasient;
import norskreseptregister.Reg.PasientRegister;
import norskreseptregister.Reg.RegisterSystem;
import norskreseptregister.gui.regGUI.RegistrerResept;

public class VelgPersonGUI extends JDialog
{
  private JList<String> navneliste;
  private JButton ok, avbryt;
  //private Navnevalg forelder;
  private Knappelytter kLytter;
  private Muselytter mLytter;
  private int valgtIndex;

  public VelgPersonGUI(DefaultListModel model)
  {
    //forelder = f;
    setModal(true);
    navneliste = new JList<>(model);
    //skal bare kunne velge ett navn om gangen:
    navneliste.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
    valgtIndex = -1;
    navneliste.setSelectedIndex(0);
    String startnavn = navneliste.getSelectedValue();
    //forelder.settNavn(startnavn);
    
    JPanel listepanel = new JPanel();
    listepanel.setLayout(new BoxLayout(listepanel, 
            BoxLayout.PAGE_AXIS));
    listepanel.add(new JLabel("Liste over alle pasienter:"));
    listepanel.add(Box.createRigidArea(new Dimension(0, 5)));
    JScrollPane listeskroller = new JScrollPane(navneliste);
    listeskroller.setPreferredSize(new Dimension(350, 200));
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
    ok = new JButton("Velg Pasient");
    avbryt = new JButton("Avbryt");
    knappepanel.add(avbryt);
    knappepanel.add(Box.createRigidArea(new Dimension(10, 0)));
    knappepanel.add(ok);

    kLytter = new Knappelytter();
    ok.addActionListener(kLytter);
    avbryt.addActionListener(kLytter);
    mLytter = new Muselytter();
    navneliste.addMouseListener(mLytter);

    Container c = getContentPane();
    c.add(listepanel, BorderLayout.CENTER);
    c.add(knappepanel, BorderLayout.PAGE_END);
    pack();
    //sikrer at det valgte navnet er synlig i navnelista når 
    //dialogvinduet blir åpnet:
    navneliste.ensureIndexIsVisible(valgtIndex);
  }//end of Konstruktør
  
  //Get-metode for vagltIndex
  public int getValgtIndex()
  {
    return valgtIndex;
  }
  
  //Privat lytteklassse som lytter på om knappene er trykket på. 
  private class Knappelytter implements ActionListener
  {
    public void actionPerformed(ActionEvent e)
    {
      if (e.getSource() == ok)
      {
        valgtIndex = navneliste.getSelectedIndex();
        setVisible(false);
      }
      else if (e.getSource() == avbryt)
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
}//end of class VelgPasientGUI