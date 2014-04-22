/*
 Testklasse for regex.

Laget av Peter Wilhelmsen

Sist lagret 22-04-14
 */

package norskreseptregister.gui.regGUI;

public class RegEx
{
    private String fornavn;
    
    private void testFornavn()
    {
        //fornavn = fornavnfelt.getText();
        fornavn.matches("[a-zA-Z]");
    }
    
}


/*
http://www.regular-expressions.info/java.html

http://stackoverflow.com/questions/4450045/difference-between-matches-and-find-in-java-regex

http://www.tutorialspoint.com/java/java_string_matches.htm

http://java67.blogspot.no/2012/09/java-string-matches-example-regular-expression.html

*/
