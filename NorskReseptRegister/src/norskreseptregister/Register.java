/*
 * Filen inneholder 
 * Laget av Henrik  
 * Sist endret  09-04-2014
 */

package norskreseptregister;

import java.util.ArrayList;
import java.util.List;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;

public abstract class Register<T extends SkriveLeseObjekt>
{
    private List<T> list;
    private Class<T> classObject;
    
    public Register(Class<T> classObject)
    {
        this.classObject = classObject;
        list = new ArrayList<T>(); //instansiere en tom liste av <T>
    }

    public void SettInn(T nyttElement)
    {
        list.add(nyttElement);
    }

    // Finner alle elemente i lista som oppfyller kriterie
    public List<T> Finn(Kriterie<T> kriterie)
    {
        ArrayList<T> resultat = new ArrayList<T>();
        for (T element : list) 
        {
            if (kriterie.erOppfyltFor(element))
            {
                    resultat.add(element);
            }
        }
        return resultat;
    }
    
    public List<T> FinnAlle()
    {
        return list;
    }
    
    public void SkrivTilFil(String filNavn)
    {
        try (FileOutputStream filnavn = new FileOutputStream(filNavn))
        {
            for (T element : list) 
            {
                // objektet skriver selv sine data til fil
                element.SkrivObjektTilFil(filnavn);
            }
            // Lukk filen
            filnavn.close(); 
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
    
    public void LesTilFil(String filNavn) 
    {
        try (FileInputStream filnavn = new FileInputStream(filNavn))
        {
            do
            {
                T nyttElement = classObject.newInstance();
                if (nyttElement.LesObjektFraFil(filnavn))
                {
                    SettInn(nyttElement);
                }
                else
                {
                    break;
                }
            }
            while(true);
        }
        catch (FileNotFoundException ex)
        {
            System.out.println("Fant ikke fila");
        }
        catch (IOException ioe)
        {
            System.out.println("Kan ikke skrive til fil!");
        } catch (InstantiationException ex) {
            Logger.getLogger(Register.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            Logger.getLogger(Register.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    
}//end of class Register
