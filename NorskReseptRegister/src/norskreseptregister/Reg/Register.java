/*
Filen inneholder klassen Register som er den abstrakte superklassen
til alle registerne i programmet vårt.
Laget av Henrik Fischer Bjelland
Sist endret 09-04-2014
*/

package norskreseptregister.Reg;

import java.util.ArrayList;
import java.util.List;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.logging.Level;
import java.util.logging.Logger;
import norskreseptregister.Interface.UtvalgsKriterie;

public abstract class Register<T>
{
    private ArrayList<T> list;
    
    //I konstruktøren instansieres en tom liste av <T>
    public Register()
    {
        list = new ArrayList<T>(); 
    }
    //Meotde for å sette inn et objekt
    public void SettInn(T nyttObjekt)
    {
        list.add(nyttObjekt);
    }

    // Finner alle elemente i lista som oppfyller kriterie
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
    //Metode for å skrive til en tekstfil
    public void SkrivTilFil(String filNavn)
    {
        try (ObjectOutputStream utfil = new ObjectOutputStream(
                                        new FileOutputStream(filNavn)))
        {
            utfil.writeObject(list);  
            //utfil.close(); //kanskje denne skal bort? unødvendig?
        }
        catch (FileNotFoundException ex)
        {
            System.out.println("Fant ikke fila");
        }
        catch (IOException ioe)
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
           list = ( ArrayList<T> )innfil.readObject();
           //innfil.close(); //kanskje denne skal bort? unødvendig?
        }
        catch (FileNotFoundException ex)
        {
            System.out.println("Fant ikke fila");
        }
        catch (IOException ioe)
        {
            System.out.println("Kan ikke lese fra fil!");
        }
        catch (ClassNotFoundException cnfe)
        {
            System.out.println("Finner ikke klassen");
        }
    }  
    
}//end of class Register
