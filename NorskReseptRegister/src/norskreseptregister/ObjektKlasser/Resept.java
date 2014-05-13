/*
 Filen inneholder klassen Respet.
 Laget av Haakon Winther, Henrik Fischer Bjelland
 Sist endret 13-05-2014
 */
package norskreseptregister.ObjektKlasser;

import java.io.Serializable;
import java.util.Date;

/*  
 Klassen har variabler for en spesifikk resept, get-metoder for disse og en 
 toString-metode med all informasjonen til en resept
 */
public class Resept implements Serializable
{
    private static final long serialVersionUID = 4L;
    private Date dato;
    private Pasient pasient;
    private Lege lege;
    private Medisin medisin;
    private String mengde;
    private String kategori;
    private String anvisning;

    // Konstruktør som initialiserer alle varieblene for en resept
    public Resept(Date dato, Pasient pasient, Lege lege,
            Medisin medisin, String mengde, String kategori, String anvisning)
    {
        this.dato = dato;
        this.pasient = pasient;
        this.lege = lege;
        this.medisin = medisin;
        this.mengde = mengde;
        this.kategori = kategori;
        this.anvisning = anvisning;
    }

    // Parameterløs konstruktør
    public Resept()
    {
    }

    // Get-metode for for dato
    public Date getDato()
    {
        return dato;
    }

    // Get-metode for pasient
    public Pasient getPasient()
    {
        return pasient;
    }

    // Get-metode for lege
    public Lege getLege()
    {
        return lege;
    }

    // Get-metode for medisin
    public Medisin getMedisin()
    {
        return medisin;
    }

    // Get-metode for mengde
    public String getMengde()
    {
        return mengde;
    }

    // Get-metode for kategori
    public String getKategori()
    {
        return kategori;
    }

    // Get-metode for anvisning
    public String getAnvisning()
    {
        return anvisning;
    }

    // toString-metoden returnerer en informativ tekst og en resept
    public String toString()
    {
        StringBuilder resept = new StringBuilder();
        resept.append("Utskrevet dato: " + dato);
        resept.append("\nPasient: " + pasient);
        resept.append("\nLege: " + lege);
        resept.append("\nMedisin: " + medisin.getNavn());
        resept.append("\nMengde: " + mengde);
        resept.append("\nAnvisning: " + anvisning);
        return resept.toString();
    }
} // End of class Resept
