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
import javax.swing.JOptionPane;

public abstract class Register<T extends SkriveLeseObjekt>
{
    private List<T> list;

    public Register()
    {
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
        try(FileOutputStream filnavn = new FileOutputStream(filNavn))
        {
            for (T element : list) 
            {
                // objektet skriver selv sine data til fil
                element.SkrivObjektTilFil(filnavn);
            }
            // Lukk filen
            filnavn.close(); 
        }
        catch(IOException ioe)
        {
            System.out.println("Kan ikke skrive til fil!");
        }
    }
    
    /*public Register <T> LesTilFil()
    {
        
    }*/
    
    
}//end of class Register
