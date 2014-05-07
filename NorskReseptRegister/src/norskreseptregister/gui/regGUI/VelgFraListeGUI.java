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
import java.util.ArrayList;
import java.util.Comparator;
import javax.swing.*;

public class VelgFraListeGUI extends JDialog
{
  private JList<String> navneliste;
  private JButton ok, avbryt;
  //private Navnevalg forelder;
  private Knappelytter kLytter;
  private Muselytter mLytter;
  private int valgtIndex;
  private final SortertListModel sortertModel;

  public VelgFraListeGUI(String listeOver, String velg, DefaultListModel<String> model)
  {
    //forelder = f;
    setModal(true);
    sortertModel = new SortertListModel(model);     // Vis alfabetisk sortert liste
    navneliste = new JList<>(sortertModel);
    /*
    Her må vi se litt hva vi skal gjøre, denne velgeren er for alle og kan velge flere pasienter,leger osv*/
    navneliste.setSelectionMode(ListSelectionModel.MULTIPLE_INTERVAL_SELECTION);
    valgtIndex = -1;
    navneliste.setSelectedIndex(0);
    String startnavn = navneliste.getSelectedValue();
    //forelder.settNavn(startnavn);
    
    JPanel listepanel = new JPanel();
    listepanel.setLayout(new BoxLayout(listepanel, 
            BoxLayout.PAGE_AXIS));
    listepanel.add(new JLabel(listeOver));
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
    ok = new JButton(velg);
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
      if (valgtIndex >= 0)
      {
          // Returner original (usortert) index, dvs indeksen fra *Register eller Medisinliste
          return sortertModel.getOriginalIndex(valgtIndex);
      }
      return -1;
  }
  
  public int [] getValgteFraListe()
  {
      int[] valgte = navneliste.getSelectedIndices();   // Indekser fra den sorterte lista
      int[] originalValgte = new int[valgte.length];
      for (int i = 0; i < valgte.length; i++)
      {
          // Finn original/usortert indeks
          originalValgte[i] = sortertModel.getOriginalIndex(valgte[i]);
      }
      return originalValgte;
  }
  
  // Hjelpeklasse som inneholder en string (en rad i lista) og den originale/usorterte indeksen
  private class StringOgIndex
  {
      private final String string;
      private final int index;
      
      public StringOgIndex(String string, int index)
      {
          this.string = string;
          this.index = index;
      }
      
      public String getString()
      {
          return string;
      }
      
      public int getIndex()
      {
          return index;
      }
  }
  
  // Klasse for å sammenligne to "StringOgIndex", slik at vi kan sortere dem alfabetisk
  // (Se ArrayList.sort()
  private class MinComparator implements Comparator<StringOgIndex>
  {
    public int compare(StringOgIndex o1, StringOgIndex o2)
    {
        return o1.getString().compareTo(o2.getString());
    }
  }
  
  // Sortert listemodell for navneListe
  // Har metode getOriginalIndex() for å konvertere fra sortert indeks til original indeks.
  // (Pasient-, Lege- og ReseptRegister pluss Medisinliste bruker de originale indeksene)
  private class SortertListModel extends DefaultListModel<String>
  {
      private final ArrayList<StringOgIndex> sortertListe;
      
      public SortertListModel(DefaultListModel<String> modelInn)
      {
          sortertListe = new ArrayList<>();
          for (int i = 0; i < modelInn.getSize(); i++)
          {
              sortertListe.add(new StringOgIndex(modelInn.get(i), i));
          }
          sortertListe.sort(new MinComparator());   // Sorter lista med stringer og originalindekser
          for (StringOgIndex soi : sortertListe)
          {
              addElement(soi.getString());  // Lag den nye listemodellen med sorterte stringer
          }
      }
      
      public int getOriginalIndex(int sortertIndex)
      {
          // ArrayLista "sortertListe" er 1:1 til den sorterte JList-en "navneListe"
          return sortertListe.get(sortertIndex).getIndex();
      }
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
        valgtIndex = -1;
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