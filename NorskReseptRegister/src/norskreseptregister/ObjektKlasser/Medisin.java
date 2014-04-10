/*
 Filen inneholder klassen Medisin og metoder/program for at vi kan legge
inn medisiner på en fil, slik at hovedprogrammet kan sjekke om medisinen finnes
når en resepet skal skrives ut.

 Laget av Peter Wilhelmsen 
 Sist endret 31/03/14 
 */

package norskreseptregister.ObjektKlasser;

import java.io.*;

public class Medisin implements Serializable
{
    private String navn;
    private String atcNr;
    Medisin neste;
    
    //Konstruktør
    public Medisin(String navn, String atcNr)
    {
        this.navn = navn;
        this.atcNr = atcNr;
        neste = null;
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
            
    /* Vet ikke om vi får bruk for denne
    MÅ returnere navn eller atcnr, sjekk 
    */
    public String toString()
    {
        String tekst = "";
        /*tekst += "Navn: " + navn +
                "\nAtc-Nummer: " + atcNr +
                "\nAnvisning: " + anvisning;
        */
        tekst += navn + " - " + atcNr;
        return tekst;
    }
 
}// end of class Medisin