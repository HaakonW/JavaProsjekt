/*
 Filen inneholder klassen Pasient som er subklassen til Person.
 Laget av Henrik Fischer Bjelland
 Sist endret 13-05-2014
 */
package norskreseptregister.ObjektKlasser;

import java.io.Serializable;

// Pasient har info som er unik for en spesiell pasient.
public class Pasient extends Person implements Serializable
{
    private static final long serialVersionUID = 3L;
    private String fodselsdato;

    /*
     Konstruktøren henter inn variabler fra superklassen Person og legger 
     til det som er spesiellt for en pasient.
     */
    public Pasient(String fornavn, String etternavn, String fodselsdato)
    {
        super(fornavn, etternavn);
        this.fodselsdato = fodselsdato;
    }

    // Parameterløs konstruktør
    public Pasient()
    {
    }

    // Get-metode for fødselsdato
    public String getFodselsdato()
    {
        return fodselsdato;
    }

    // toString-metoden returnerer en informativ tekst om en spesifikk pasient
    public String toString()
    {
        StringBuilder pasientinfo = new StringBuilder();
        pasientinfo.append(super.toString());
        pasientinfo.append("Fødselsdato: " + fodselsdato);
        return pasientinfo.toString();
    }

}//End of class Pasient
