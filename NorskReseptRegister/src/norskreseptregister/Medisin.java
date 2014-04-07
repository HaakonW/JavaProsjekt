/*
 Filen inneholder klassen Medisin og metoder/program for at vi kan legge
inn medisiner på en fil, slik at hovedprogrammet kan sjekke om medisinen finnes
når en resepet skal skrives ut.

 Laget av Peter Wilhelmsen 
 Sist endret 31/03/14 
 */

package norskreseptregister;

import java.io.*;

public class Medisin 
{
    private String navn;
    private String atcNr;
    private String anvisning;
    Medisin neste;
    
    
    //Konstruktør
    public Medisin(String navn, String atcNr, String anvisning)
    {
        this.navn = navn;
        this.atcNr = atcNr;
        this.anvisning = anvisning;
        neste = null;
    }
    
    //For å kunne sjekke navnet i medisinliste
    public String getNavn()
    {
        return navn;
    }
            
    
    
    /* Vet ikke om vi får bruk for denne
    MÅ returnere navn eller atcnr, sjekk 
    */
    public String toString()
    {
        String tekst = "";
        tekst += "Navn: " + navn +
                "\nAtc-Nummer: " + atcNr +
                "\nAnvisning: " + anvisning;
        
        return tekst;
    }
    
    
    //Opprette ny medisin
    public void registrerMedisin()
    {
       //Medisin ny = new Medisin();
       // <hente tekst fra riktig felt, sende me som parameter i medisin>
        
        //< Sette inn i medisinregister >
    }
    
    
    
    // Lese objekt fra fil  - HUSK Å IMPORTER java.io.*;
    public boolean lesObjektFraFil(DataInputStream innfil)
    {
        try
        {
            navn = innfil.readUTF();
            atcNr = innfil.readUTF();
            anvisning = innfil.readUTF();
            return true;
            
        }
        catch(FileNotFoundException fnfe)
        {
            System.out.println("Finner ikke filen!");
            return false;
        }
        catch(IOException ioe)
        {
            System.out.println("Problemer med filen!");
            return false;
        }
    }
    
    
     //Lagre objektet på fil - try med ressurser
    
    public void skrivObjektTilFil(DataOutputStream utfil)
    {
        try
        {
            utfil.writeUTF(navn);
            utfil.writeUTF(atcNr);
            utfil.writeUTF(anvisning);
        }
        catch(IOException ioe)
        {
            System.out.println("Kan ikke skrive til fil!");
        }
    }
}// end of class Medisin