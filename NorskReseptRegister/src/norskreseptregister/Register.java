/*
 * Filen inneholder 
 * Laget av   
 * Sist endret   
 */

package norskreseptregister;

/**
 *
 * @author Henrik
 */
import java.util.ArrayList;
import java.util.List;

public abstract class Register<T>
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
}//end of class Register
