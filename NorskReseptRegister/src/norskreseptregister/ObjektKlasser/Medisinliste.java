/*
 Filen inneholder klassen Midisinliste og er en egendefinert liste over
 alle medisinene i programmet vårt. 
 Laget av  Peter Wilhelmsen, Henrik Fischer Bjelland
 Sist endret  27-04-2014 
 */
package norskreseptregister.ObjektKlasser;

import java.io.*;
import java.util.ArrayList;
import javax.swing.DefaultListModel;
import javax.swing.JOptionPane;

//Medisinliste
public class Medisinliste implements Serializable
{
    private static final long serialVersionUID = 6L;
    private static String medisinlisten = "lagreMedisin.txt";
    private Medisin hode;

    public Medisinliste()
    {
        hode = null;
    }

    //Metoden sette inn medisiner i lista
    public void settInn(Medisin ny)
    {
        if (ny != null)
        {
            ny.neste = hode;
            hode = ny;
        }
    }

    //Vise registrert medisin
    public String toString()
    {
        String tekst = "";
        Medisin hjelp = hode;

        while (hjelp != null)
        {
            tekst += "-" + hjelp.toString() + "\n";
            hjelp = hjelp.neste;
        }
        return tekst;
    }

    /*Finn medisin - Kan brukes når vi skal sjekke om medisinen finnes
     i hovedprogrammet
     - Må legge inn muligheten for å søke på atcNr
     */
    public boolean finnMedisin(String medisinnavn)
    {
        if (hode == null)
        {
            return false;
        }
        if (hode.getNavn().equals(medisinnavn))
        {
            //return hode.toString();
            return true;
        }
        Medisin hjelp = hode;

        while (hjelp != null)
        {
            if (hjelp.getNavn().equals(medisinnavn))
            {
                return true;
            }
            hjelp = hjelp.neste;
        }
        //return "Finner ikke medisin med navn " + medisinnavn;
        return false;
    }

    //FinnAlle brukes for finne alle medisiner
    public ArrayList<Medisin> FinnAlle()
    {
        ArrayList<Medisin> liste = new ArrayList();

        Medisin hjelp = hode;

        while (hjelp != null)
        {
            liste.add(hjelp);
            hjelp = hjelp.neste;
        }
        return liste;
    }
    
    //
    public DefaultListModel getListModel()
    {
        DefaultListModel model = new DefaultListModel();
        for (Medisin medisin : FinnAlle())
        {
            model.addElement(medisin.toString());
        }
        return model;
    }

    //HentEttElement brukes til å søke igjennom medisinlisten vår og finne en bestemt medisin
    public Medisin HentEttElement(int index)
    {
        Medisin hjelp = hode;
        int elementindex = 0;

        while (hjelp != null)
        {
            if (elementindex == index)
            {
                return hjelp;
            }
            hjelp = hjelp.neste;
            elementindex++;
        }
        return null;
    }

    //Metode for å lese fra tekstfilen medisinliste.
    public static Medisinliste lesObjektFraFil()
    {
        try (ObjectInputStream innfil = new ObjectInputStream(
                new FileInputStream(medisinlisten)))
        {
            return (Medisinliste) innfil.readObject();

        } catch (ClassNotFoundException cnfe)
        {
            JOptionPane.showMessageDialog(null, cnfe.getMessage());
            /* Må kanskje legge inn muligheten for å opprette ny liste
             om det ikke finnes en: liste = new Medisinliste();*/
        } catch (IOException ioe)
        {
            JOptionPane.showMessageDialog(null, "Feil ved lesing, "
                    + "ny liste blir opprettet");
            //Kan opprette ny tom liste her også. Som forslaget i kommentar over
        }
        return null;
    }

    //
    public void SkrivTilFil()
    {
        try (ObjectOutputStream utfil = new ObjectOutputStream(
                new FileOutputStream(medisinlisten)))
        {
            utfil.writeObject(this);
            utfil.close();
        } catch (NotSerializableException nse)
        {
            JOptionPane.showMessageDialog(null, "Objektet er ikke serialisert!");
        } catch (FileNotFoundException fnfe)
        {
            JOptionPane.showMessageDialog(null, "Finner ikke " + medisinlisten);
        } catch (IOException ioe)
        {
            System.out.println("Kan ikke skrive til fil!");
        }
    }
}// end of class Medisinliste
