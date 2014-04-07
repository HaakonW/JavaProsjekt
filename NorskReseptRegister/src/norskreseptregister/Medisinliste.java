/*
 * Filen inneholder 
 * Laget av  * 
 * Sist endret  * 
 */

package norskreseptregister;

/**
 *
 * @author Peter
 */

    //Medisinliste
    public class Medisinliste
    {
        private Medisin hode;
        
        public Medisinliste()
        {
            hode = null;
        }
        
        //Sette inn medisiner i lista
        public void settInn(Medisin ny)
        {
            if( ny != null)
            {
                ny.neste = hode;
                hode = ny;
            }
        }
        
        /*Finn medisin - Kan brukes når vi skal sjekke om medisinen finnes
        i hovedprogrammet*/
        public boolean finnMedisin (String medisinnavn)
        {
            if( hode == null)
            {
               return false;
            }
            
            if(hode.getNavn().equals(medisinnavn) )
            {
                //return hode.toString();
                return true;
            }
            
            Medisin hjelp = hode;
            
           while( hjelp.neste != null)
           {
               if(hjelp.neste.getNavn().equals(medisinnavn) )
               {
                   //return hjelp.neste.toString();
                   return true;
               }
               
               hjelp.neste = hjelp.neste.neste;
           }
           
           //return "Finner ikke medisin med navn " + medisinnavn;
           return false;
        }
        
    }// end of class Medisinliste