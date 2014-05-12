/*
 Filen inneholder klassen Lege, som er subklassen til Person.
 Laget av Peter Wilhelmsen, Henrik Fischer Bjelland
 Sist endret 12-05-2014 
 */
package norskreseptregister.ObjektKlasser;

import java.io.Serializable;

// Lege har spesifikke variabler, get- og set-metoder og toString for lege.
public class Lege extends Person implements Serializable
{
    private static final long serialVersionUID = 2L;
    private String arbeidssted;
    private boolean bevillingA;
    private boolean bevillingB;
    private boolean bevillingC;

    public Lege(String fornavn, String etternavn, String arbeidssted)
    {
        super(fornavn, etternavn);
        this.arbeidssted = arbeidssted;
        bevillingA = true;
        bevillingB = true;
        bevillingC = true;
    }
    
    // Parameterløs konstruktør
    public Lege()
    {
    }

    // Set-metode for sette a-bevillingen til en lege
    public void setBevillingA(boolean bevillingA)
    {
        this.bevillingA = bevillingA;
    }

    // Set-metode for sette b-bevillingen til en lege
    public void setBevillingB(boolean bevillingB)
    {
        this.bevillingB = bevillingB;
    }

    // Set-metode for sette c-bevillingen til en lege
    public void setBevillingC(boolean bevillingC)
    {
        this.bevillingC = bevillingC;
    }

    // Get-metode for arbeidssted
    public String getArbeidssted()
    {
        return arbeidssted;
    }

    // Get-metode for å hente ut a-bevilling til en lege
    public boolean getBevillingA()
    {
        return bevillingA;
    }

    // Get-metode for å hente ut b-bevilling til en lege
    public boolean getBevillingB()
    {
        return bevillingB;
    }

    // Get-metode for å hente ut c-bevilling til en lege
    public boolean getBevillingC()
    {
        return bevillingC;
    }

    // Denne metoden henter og skriver den valgte bevillingen for en lege i en String variabel.
    public String getBevilling()
    {
        String bevilling = "";
        if (bevillingA)
        {
            bevilling += "A ";
        }
        if (bevillingB)
        {
            bevilling += "B ";
        }
        if (bevillingC)
        {
            bevilling += "C";
        }
        return bevilling;
    }
    
    // Metode som returnerer navn og arbeidsted til en lege
    public String getNavnOgArbeidsSted()
    {
        String navnOgArbeidsSted = super.toString() + "Arbeidssted: " + arbeidssted;
        return navnOgArbeidsSted;
    }

    // Denne metoden returnerer en informativ tekst om legen som blir opprettet.
    public String toString()
    {
        String bevilling = getBevilling();
        String tekst = getNavnOgArbeidsSted();
        tekst+= "\nBevilling for medisingruppe: " + bevilling + "\n";
        return tekst;
    }
} //End of class Lege