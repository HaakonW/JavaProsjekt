/*
Filen inneholder klassen Lege, som er subklasse til superklassen Person.
Variabler, get- og setmetoder og toString for lege.
Laget av  Peter Wilhelmsen, Henrik Fischer Bjelland
Sist endret 10-04-2014 
*/

package norskreseptregister.ObjektKlasser;

import java.io.Serializable;

public class Lege extends Person implements Serializable
{
    private static final long serialVersionUID = 2L;
    private String arbeidssted;
    private boolean bevillingA;
    private boolean bevillingB;
    private boolean bevillingC;
    
    public Lege()
    {
        //parameterløs konstruktør
    }
    
    public Lege(String fornavn, String etternavn, String arbeidssted)
    {
        super(fornavn,etternavn);
        this.arbeidssted = arbeidssted;
        bevillingA = true;
        bevillingB = true;
        bevillingC = true;
    }
    //Set metoder for de forskjellige bevillingene
    public void setBevillingA(boolean bevillingA)
    {
        this.bevillingA = bevillingA;
    }

    public void setBevillingB(boolean bevillingB)
    {
        this.bevillingB = bevillingB;
    }

    public void setBevillingC(boolean bevillingC)
    {
        this.bevillingC = bevillingC;
    }
    
    //Get metode for arbeidssted
    public String getArbeidssted()
    {
        return arbeidssted;
    }
    //Get metoder for de forskjellige bevillingene
    public boolean getBevillingA()
    {
        return bevillingA;
    }
    
    public boolean getBevillingB()
    {
        return bevillingB;
    }
    
    public boolean getBevillingC()
    {
        return bevillingC;
    }
    
    //Denne metoden returnerer en informativ tekst om legen som blir opprettet.
    public String toString()
    {
        String bevilling = getBevilling();
        
        String tekst = super.toString();
        tekst += "Arbeidssted: " + arbeidssted +
                "\nBevilling for medisingruppe: " + bevilling + "\n";
        return tekst;
    }// end of toString
    
    //Denne metoden henter og skriver den valgte bevillingen for en lege.
    public String getBevilling()
    {
        String bevilling = "";
        if (bevillingA )
        {
            bevilling+= "A ";
        }
        if (bevillingB )
        {
            bevilling+= "B ";
        }
        if (bevillingC )
        {
            bevilling+= "C";
        }
        return bevilling;
    }
    

} //End of class Lege