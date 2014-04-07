/*
  Filen inneholder klassen Lege, som er subklasse til superklassen Person.
  Variabler, getmetoder og toString for lege.

  Laget av  Peter Wilhelmsen* 
  Sist endret  31/03/14 
 */

package norskreseptregister;


public class Lege extends Person
{
    //private String legenummer;
    private String arbeidssted;
    private boolean bevillingA;
    private boolean bevillingB;
    private boolean bevillingC;
    
    public Lege(String fornavn, String etternavn, //String legenummer,
                String arbeidssted)
    {
        super(fornavn,etternavn);
        //this.legenummer = legenummer;
        this.arbeidssted = arbeidssted;
        bevillingA = true;
        bevillingB = true;
        bevillingC = true;
    }
    
    /*public String getLegenummer()
    {
        return legenummer;
    }*/
    
    public String getArbeidssted()
    {
        return arbeidssted;
    }
    
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
    
    public String toString()
    {
        String bevilling = "";
        if (bevillingA )
        {
            bevilling+= "A";
        }
        if (bevillingB )
        {
            bevilling+= "B";
        }
        if (bevillingC )
        {
            bevilling+= "C";
        }
        
        String tekst = "";
        tekst += "Legenummer: " + //legenummer +
                "\nArbeidssted: " + arbeidssted +
                "\nBevilling for medisingruppe: " + bevilling + "\n";
        return tekst;
    }// end of toString
} //End of class Lege
