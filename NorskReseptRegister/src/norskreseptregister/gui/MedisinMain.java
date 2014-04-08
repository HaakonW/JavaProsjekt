/*Main-metode for å kjøre programmet
    - Vanlig main-metode nå, må byttes til eventQueue.invokeLater
    
- Legges inn i hovedprogrammet senere. 
- Sjekker ikke om typen medisin er lagret fra før, kan dermed legge
    inn samme type flere ganger om man ikke husker hva som er lagt inn.

Laget av Peter Wilhelmsen
Sist endret 07.04.14
*/
package norskreseptregister.gui;
import java.awt.event.*;
/**
 *
 * @author PeterWilhelmsen
 */
public class MedisinMain 
{
    public static void main(String[] args)
    {
        final MedisinGUI vindu = new MedisinGUI() {}; //{} - abstract,feilmelding uten
        vindu.addWindowListener(new WindowAdapter(){
            public void windowClosing(WindowEvent e)
            {
                vindu.skrivObjektTilFil();
                System.exit(0);
            }
        });
    }
}
