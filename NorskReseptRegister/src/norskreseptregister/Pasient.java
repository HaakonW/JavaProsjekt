/*
 * Filen inneholder Pasient klassen med info som er unik for en spesiell pasient.
 * Laget av Henrik
 * Sist endret  31/03/2014
 */

package norskreseptregister;


public class Pasient extends Person
{
    private String fodselsdato;
    
    public Pasient(String fornavn, String etternavn, String fodselsdato)
    {
        super(fornavn,etternavn);
        this.fodselsdato = fodselsdato;
    }
    
    public String getFodselsdato()
    {
        return fodselsdato;
    }
    
    public String toString()
    {
        String tekst = "";
        tekst += "Fødselsdato: " + fodselsdato;
        return tekst;
    }
}//End of class Pasient