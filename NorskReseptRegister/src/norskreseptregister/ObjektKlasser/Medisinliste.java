/*
Filen inneholder klassen Midisinliste og er en egendefinert liste over
alle medisine i programmet vårt. 
Laget av  Peter WIlhelmsen
Sist endret  31-03-2014 
 */

package norskreseptregister.ObjektKlasser;

import java.io.*;

//Medisinliste
public class Medisinliste implements Serializable
{
    private Medisin hode;

    public Medisinliste()
    {
        hode = null;
    }

    //Sette inn medisiner i lista
    public void settInn(Medisin ny)
    {
        if( ny != null)
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

        while(hjelp != null)
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
    public boolean finnMedisin (String medisinnavn)
    {
        if( hode == null)
        {
           return false;
        }

        if(hode.getNavn().equals(medisinnavn) )
        {
            //return hode.toString();
            return true;
        }

        Medisin hjelp = hode;

       while( hjelp.neste != null)
       {
           if(hjelp.neste.getNavn().equals(medisinnavn) )
           {
               //return hjelp.neste.toString();
               return true;
           }

           hjelp.neste = hjelp.neste.neste;
       }

       //return "Finner ikke medisin med navn " + medisinnavn;
       return false;
    }

}// end of class Medisinliste