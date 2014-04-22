/*
Filen inneholder klassen Medisin og metoder/program for at vi kan legge
inn medisiner på en fil, slik at hovedprogrammet kan sjekke om medisinen finnes
når en resepet skal skrives ut.
Laget av Peter Wilhelmsen, Henrik Fischer Bjelland
Sist endret 11-04-2014
 */

package norskreseptregister.ObjektKlasser;

import java.io.*;

public class Medisin implements Serializable
{
    private static final long serialVersionUID = 5L;
    private String navn;
    private String atcNr;
    private boolean gruppeA;
    private boolean gruppeB;
    private boolean gruppeC;
    
    Medisin neste;
    
    //Konstruktør
    public Medisin(String navn, String atcNr)
    {
        this.navn = navn;
        this.atcNr = atcNr;
        neste = null;
        gruppeA = false;
        gruppeB = false;
        gruppeC = false;
    }
    
    //For å kunne sjekke navnet i medisinliste
    public String getNavn()
    {
        return navn;
    }
    
    public String getAtcNr()
    {
        return atcNr;
    }
    
    public boolean getGruppeA()
    {
        return gruppeA;
    }
    
    public boolean getGruppeB()
    {
        return gruppeB;
    }
    
    public boolean getGruppeC()
    {
        return gruppeC;
    }
            
    /* Vet ikke om vi får bruk for denne
    MÅ returnere navn eller atcnr, sjekk 
    */
    public String toString()
    {
        String medisinGruppe = "";
        if (gruppeA )
        {
            medisinGruppe+= "A ";
        }
        if (gruppeB )
        {
            medisinGruppe+= "B ";
        }
        if (gruppeC )
        {
            medisinGruppe+= "C";
        }
        
        String tekst = "";
        tekst += navn + " - " + atcNr
              + "Medisingruppe: " + medisinGruppe;
        return tekst;
    }
 
}// end of class Medisin