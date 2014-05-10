/*
 Filen inneholder klassen Person som er superklassen til Lege og Pasient.
 Klassen har variabler som er feller for Lege- og Pasientklassene og get-metoder
 for disse.
 Laget av  Henrik Fischer Bjelland
 Sist endret 27-04-2014 
 */
package norskreseptregister.ObjektKlasser;

import java.io.Serializable;

public abstract class Person implements Serializable
{
    private static final long serialVersionUID = 1L;
    private String fornavn;
    private String etternavn;

    public Person(String fornavn, String etternavn)
    {
        this.fornavn = fornavn;
        this.etternavn = etternavn;
    }

    //Parameterløs kontruktør
    public Person()
    {
    }

    //Get-metode for fornavn
    public String getFornavn()
    {
        return fornavn;
    }

    //Get-metode for etternavn
    public String getEtternavn()
    {
        return etternavn;
    }

    //Get-metode for hele navnet
    public String getNavn()
    {
        return etternavn + ", " + fornavn;
    }

    //toString-metoden returnerer en informativ tekst om den aktuelle personen
    public String toString()
    {
        String tekst = "";
        tekst += etternavn + " " + fornavn + ",\n";
        return tekst;
    }
}//End of class Person
