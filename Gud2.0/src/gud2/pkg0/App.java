import java.util.StringTokenizer;


 
public class App {
	public static void main(String[] args) {
 
		String guttenavn = "Jan Per Bjørn Ole Lars Kjell Knut Svein Arne Thomas Hans Geir Morten Tor Terje Odd Martin Erik Andreas John Anders Rune Trond Daniel Tore Kristian Jon Marius Tom Stian Magnus Olav Harald Øyvind Henrik Gunnar Espen Rolf Fredrik Leif Christian Eirik Nils Jonas Helge Håkon Einar Steinar Frode Øystein Jørgen Alexander Arild Kjetil Petter Frank Kåre Stein Mathias Kristoffer Johan Dag Stig Kenneth Vidar Ivar Tommy Ola Pål Emil Håvard Roger Karl Magne Sverre Simen Sondre Egil Eivind Adrian Robert Alf Kim Vegard Jens Sebastian Sander Tobias Thor Roy Johannes Sindre Torbjørn Roar Finn Erling Sigurd Markus Asbjørn Joakim";
		String jentenavn = "Anne Inger Kari Marit Ingrid Liv Eva Berit Anna Hilde Astrid Ida Maria Marianne Bjørg Nina Solveig Randi Elisabeth Kristin Bente Heidi Silje Hanne Linda Tone Gerd Tove Elin Anita Wenche Ragnhild Camilla Ellen Karin Hege Ann Mona Marie Else Aud Julie Monica Kristine Laila Turid Stine Helene Reidun åse Jorunn Mari Sissel Line Lene Mette Trine Grethe Emma Thea Malin Unni Grete Gunn May Emilie Sara Nora Lise Ruth Anette Linn Kirsten Siri Eli Cecilie Marte Irene Gro Britt Kjersti Ingeborg Janne Siv Sigrid Karoline Vilde Sofie Martine Andrea Tonje Karen Rita Jenny Torill Elise Cathrine Synnøve Hanna Maren";
                String etternavn = "Hansen Johansen Olsen Larsen Andersen Pedersen Nilsen Kristiansen Jensen Karlsen Johnsen Pettersen Eriksen Berg Haugen Hagen Johannessen Andreassen Jacobsen Dahl Jørgensen Halvorsen Henriksen Lund Sørensen Jakobsen Gundersen Moen Iversen Svendsen Strand Solberg Martinsen Paulsen Knutsen Eide Bakken Kristoffersen Mathisen Lie Rasmussen Amundsen Lunde Kristensen Bakke Berge Moe Nygård Fredriksen Solheim Nguyen Lien Holm Andresen Christensen Hauge Knudsen Nielsen Evensen Sæther Aas Hanssen Myhre Haugland Thomassen Simonsen Sivertsen Berntsen Danielsen Ali Arnesen Rønning Næss Sandvik Antonsen Haug Ellingsen Edvardsen Vik Thorsen Gulbrandsen Isaksen Birkeland Ruud Ahmed Strøm Aasen ødegård Jenssen Tangen Eliassen Myklebust Bøe Mikkelsen Aune Helland Tveit Abrahamsen Brekke Madsen Engen";
                
                int dag = 1;
                int maned = 1;
                int aar = 1945;
                      
                StringTokenizer st1 = new StringTokenizer(jentenavn);
                StringTokenizer st2 = new StringTokenizer(etternavn);
 
		System.out.println("---- Split by space ------");
		while (st1.hasMoreElements() && st2.hasMoreElements())
                {       
                        System.out.println("STRING " +(st1.nextElement()) );			
                        System.out.println("DELAY 50");
                        System.out.println("TAB");
                        System.out.println("DELAY 50");
                        System.out.println("TAB");                        
                        System.out.println("STRING "+ (st2.nextElement()));
                        System.out.println("DELAY 50");
                        System.out.println("TAB");
                        System.out.println("DELAY 50");
                        System.out.println(("STRING " + dag + "/" + maned + "/" + aar));
                        System.out.println("DELAY 50");
                        System.out.println("TAB");
                        System.out.println("DELAY 50");
                        System.out.println("ENTER");
                        System.out.println("DELAY 50");
                        System.out.println("DELAY 50");
                        System.out.println("TAB");
                        System.out.println("DELAY 50");
                        System.out.println("TAB");
                        System.out.println("DELAY 50");
                        System.out.println("TAB");
                                               
                        
                        if(dag <= 30)       
                          dag++;
                        
                        else 
                         dag = 1;                        
                        
                        if(maned<12)                        
                            maned++;                        
                        else
                            maned = 1;
                        
                       if (aar >= 2013)                       
                          aar = 1921;                     
                       else                   
                           aar++;
                    
                        
                        
                        
                        
                        
                        
		}
 
		
	}
}