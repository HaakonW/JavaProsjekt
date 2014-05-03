/*
 Filen inneholder klassen Medisin.
 Klassen har variabler for en spesifikk medisin og get- og set-metoder for å 
 hente eller sette medisinen i gruppe a,b eller c.
 Laget av Peter Wilhelmsen, Henrik Fischer Bjelland
 Sist endret 27-04-2014
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

    /*
     Konstruktør der variabler blir initialisert, alle gruppene blir satt til false
     og i RegistrerMedisinGUI blir det kalt på set-metoder for å sette medisin i en medisingruppe.
     */
    public Medisin(String navn, String atcNr)
    {
        this.navn = navn;
        this.atcNr = atcNr;
        neste = null;
        gruppeA = false;
        gruppeB = false;
        gruppeC = false;
    }

    //Set-metode for at en medisin kan settes i medisingruppene A
    public void setGruppeA(boolean gruppeA)
    {
        this.gruppeA = gruppeA;
    }

    //Set-metode for at en medisin kan settes i medisingruppene B
    public void setGruppeB(boolean gruppeB)
    {
        this.gruppeB = gruppeB;
    }

    //Set-metode for at en medisin kan settes i medisingruppene C
    public void setGruppeC(boolean gruppeC)
    {
        this.gruppeC = gruppeC;
    }

    //Get-metode for navn på medisinen
    public String getNavn()
    {
        return navn;
    }

    //Get-metode for AtcNr
    public String getAtcNr()
    {
        return atcNr;
    }

    //Get-metode for medisingruppene A
    public boolean getGruppeA()
    {
        return gruppeA;
    }

    //Get-metode for medisingruppene B
    public boolean getGruppeB()
    {
        return gruppeB;
    }

    //Get-metode for medisingruppene C
    public boolean getGruppeC()
    {
        return gruppeC;
    }
    
    //Metode for å hente ut hvilke gruppe medisinen er i.
    public String getGruppe()
    {
        String medisinGruppe = "";
        if (gruppeA)
        {
            medisinGruppe += "A ";
        }
        else if (gruppeB)
        {
            medisinGruppe += "B ";
        }
        else if (gruppeC)
        {
            medisinGruppe += "C ";
        }
        return medisinGruppe;
    }
    
    //Denne metoden returnerer en informativ tekst om en medisin.
    public String toString()
    {
        String tekst = "";
        tekst += navn + " - " + atcNr
                + " - Medisingruppe: " + getGruppe();
        return tekst;
    }
}// end of class Medisin
