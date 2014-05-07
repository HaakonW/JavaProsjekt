/*
 Filen inneholder klassen Register som er den abstrakte superklassen
 til Lege-, Pasient- og Reseptregisterne.
 Klassen har metoder for å sette inn objekter, slette objekter, hente ut et objekt utifra valgt index,
 finne objekter som matcher fra et utvalgskriteriet, skrive og lese til fil.
 Laget av Henrik Fischer Bjelland
 Sist endret 27-04-2014
 */
package norskreseptregister.Reg;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.DefaultListModel;
import norskreseptregister.Interface.UtvalgsKriterie;

public abstract class Register<T>
{
    private ArrayList<T> list;

    //Konstruktøren instansier en tom liste av <T>
    public Register()
    {
        list = new ArrayList<T>();
    }

    //Metode for å sette inn et objekt
    public void SettInn(T nyttObjekt)
    {
        list.add(nyttObjekt);
    }

    //Metode for å slette et objekt
    public boolean SlettEttObjekt(T objekt)
    {
        return list.remove(objekt);
    }

    //Finner alle elemente i lista som oppfyller kriterie
    public ArrayList FinnObjekterSomMatcher(UtvalgsKriterie<T> utvalgsKriteriet)
    {
        ArrayList<T> resultat = new ArrayList<T>();
        for (T objekt : list)
        {
            if (utvalgsKriteriet.objektetSkalVaereMed(objekt))
            {
                resultat.add(objekt);
            }
        }
        return resultat;
    }

    //Metode for å hente ut et objekt av valgt index
    public T HentEttObjekt(int index)
    {
        return list.get(index);
    }

    //Metode som returnerer alle objektene i listen ArrayList av type T
    public ArrayList<T> FinnAlleObjekter()
    {
        return list;
    }
    
    //
    public DefaultListModel<String> getListModel()
    {
        DefaultListModel<String> model = new DefaultListModel<>();
        for (T objekt : FinnAlleObjekter())
        {
            model.addElement(objekt.toString());
        }
        return model;
    }

    //Metode for å skrive til en tekstfil
    public void SkrivTilFil(String filNavn)
    {
        try (ObjectOutputStream utfil = new ObjectOutputStream(
                new FileOutputStream(filNavn)))
        {
            utfil.writeObject(list);
            //utfil.close(); //kanskje denne skal bort? unødvendig?
        } catch (FileNotFoundException ex)
        {
            System.out.println("Fant ikke fila");
        } catch (IOException ioe)
        {
            System.out.println("Kan ikke skrive til fil!");
        }
    }

    //Metode for å lese fra en tekstfil.
    public void LesFraFil(String filNavn)
    {
        try (ObjectInputStream innfil = new ObjectInputStream(
                new FileInputStream(filNavn)))
        {
            list = (ArrayList<T>) innfil.readObject();
            //innfil.close(); //kanskje denne skal bort? unødvendig?
        } catch (FileNotFoundException ex)
        {
            System.out.println("Fant ikke fila");
        } catch (IOException ioe)
        {
            System.out.println("Kan ikke lese fra fil!");
        } catch (ClassNotFoundException cnfe)
        {
            System.out.println("Finner ikke klassen");
        }
    }
}//end of class Register
