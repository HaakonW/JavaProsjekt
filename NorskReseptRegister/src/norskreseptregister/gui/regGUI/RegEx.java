/*
 Testklasse for regex.

Laget av Peter Wilhelmsen

Sist lagret 22-04-14
 */

package norskreseptregister.gui.regGUI;

public class RegEx
{
    private String fornavn;
    private String etternavn;
    private String adresse;
    private int fodselsdato;
    private String legemiddel;
    private String atcNr;
    
    
    //Metode for å sjekke fornavn
    public boolean sjekkFornavn(String fornavn)
    {  
        if(fornavn.matches("[a-zæøåA-ZÆØÅ]"))
        {
            return true;
        }
        else
        {
            return false; 
        } 
    }
    
    
    //Metode for å sjekke etternavn
    public boolean sjekkEtternavn(String etternavn)
    {
        if(etternavn.matches("a-zæøåA-ZÆØÅ"))
        {
            return true;
        }
        else
        {
            return false;
        }
    }
    
    
    //Metode for å sjekke adresse
    public boolean sjekkAdresse(String adresse)
    {
        if(adresse.matches("a-zæøåA-zÆØÅ"))
        {
            return true;
        }
        else
        {
            return false;
        }
    }
    
}


/*
http://www.regular-expressions.info/java.html

http://stackoverflow.com/questions/4450045/difference-between-matches-and-find-in-java-regex

http://www.tutorialspoint.com/java/java_string_matches.htm

http://java67.blogspot.no/2012/09/java-string-matches-example-regular-expression.html

*/
