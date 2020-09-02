package it.rockpaperscissors;

import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

//Execute this code to play

/*
 * Devo leggere in input il valore dato da me.
 * Il computer sceglie tramite una funzione random. 
 * 
 * */

public class Main {
	
	static int punteggioMio, punteggioPC = 0; 
	
	public static void execute() {
		// TODO Auto-generated method stub
		System.out.println("Benvenuto al gioco ***Carta - Forbice - Sasso*** di Francesco.");
		System.out.println("Chi arriva primo a 3 vittorie, VINCE LA PARTITA.");
		System.out.println("Per giocare basta digitare:");
		System.out.println("C - se vuoi giocare Carta.");
		System.out.println("F - se vuoi giocare Forbice.");
		System.out.println("S - se vuoi giocare Sasso.");
		System.out.println("****************************");
		System.out.println("Punteggio mio = " + punteggioMio);
		System.out.println("Punteggio PC = " + punteggioPC);
		
		//ArrayList scelte del PCC
		ArrayList<String> sceltePC = new ArrayList<String>();
		sceltePC.add("C");
		sceltePC.add("S");
		sceltePC.add("F");
		
		
		while(punteggioMio < 3 && punteggioPC < 3) {
			
			String valMio = start().toUpperCase(); 
			String valPC = randomSceltaPC(sceltePC).toUpperCase(); 
			System.out.println("Il PC ha giocato: " + valPC);
			
			switch (valMio) {
			case "C":
				if(valPC == "S") {
					System.out.println("Hai vinto.");
					punteggioMio++; 
					System.out.println("Punteggio mio = " + punteggioMio);
					System.out.println("Punteggio PC = " + punteggioPC);
				}
				else if(valPC == "F") {
					System.out.println("Hai perso.");
					punteggioPC++; 
					System.out.println("Punteggio mio = " + punteggioMio);
					System.out.println("Punteggio PC = " + punteggioPC);
				}
				else {
					System.out.println("Hai pareggiato.");
					System.out.println("Punteggio mio = " + punteggioMio);
					System.out.println("Punteggio PC = " + punteggioPC);
				}
				break;
				
			case "F":
				if(valPC == "C") {
					System.out.println("Hai vinto.");
					punteggioMio++; 
					System.out.println("Punteggio mio = " + punteggioMio);
					System.out.println("Punteggio PC = " + punteggioPC);
				}
				else if(valPC == "S") {
					System.out.println("Hai perso.");
					punteggioPC++; 
					System.out.println("Punteggio mio = " + punteggioMio);
					System.out.println("Punteggio PC = " + punteggioPC);
				}
				else {
					System.out.println("Hai pareggiato.");
					System.out.println("Punteggio mio = " + punteggioMio);
					System.out.println("Punteggio PC = " + punteggioPC);
				}
				break;
				
			case "S":
				if(valPC == "F") {
					System.out.println("Hai vinto.");
					punteggioMio++; 
					System.out.println("Punteggio mio = " + punteggioMio);
					System.out.println("Punteggio PC = " + punteggioPC);
				}
				else if(valPC == "C") {
					System.out.println("Hai perso.");
					punteggioPC++; 
					System.out.println("Punteggio mio = " + punteggioMio);
					System.out.println("Punteggio PC = " + punteggioPC);
				}
				else {
					System.out.println("Hai pareggiato.");
					System.out.println("Punteggio mio = " + punteggioMio);
					System.out.println("Punteggio PC = " + punteggioPC);
				}
				break;
				
			default:
				System.err.println("ERROR.");
				break;
			}
		}
	}

	public static void main(String[] args) {
		execute();
		//Sono fuori dal ciclo.
		if(punteggioMio == 3) {
			System.out.println("Complimenti, HAI VINTO!");
		}
		else if(punteggioPC == 3) {
			System.out.println("Mannaggia, hai perso.");
		}
		
		//Azzero di nuovo. 
		punteggioMio=0;
		punteggioPC=0;
		System.out.println("Vuoi riprovare? (y/n)");
		Scanner scr = new Scanner(System.in);
		String rip = scr.nextLine();
		while(rip.toLowerCase().equals("y")) {
			//Restart
			execute();
			System.out.println("Vuoi riprovare? (y/n)");
			scr= new Scanner(System.in);
			rip = scr.nextLine();
			//Azzero di nuovo. 
			punteggioMio=0;
			punteggioPC=0;
			
		}
		System.out.println("A presto ciao.");
	}
	
	
	//Funzione start che mi dice il punteggio.
	public static String start() {
//		System.out.println("Punteggio mio = " + punteggioMio);
//		System.out.println("Punteggio PC = " + punteggioPC);
		
		System.out.println("Fai la tua scelta: (S, C, F)");
		Scanner sc = new Scanner(System.in); //leggo la mia scelta
		String str = sc.nextLine().toUpperCase(); //Contiene cosa ho giocato.
		
		while(!str.equals("C") && !str.equals("F") && !str.equals("S")) {
			System.out.println("Carattere non valido. Riprova.");
			System.out.println("Fai la tua scelta: (S, C, F)");
			sc = new Scanner(System.in); //leggo la mia scelta
			str = sc.nextLine().toUpperCase(); //Contiene cosa ho giocato.
		}
		return str.toUpperCase();
	}
	
	
	//Scelta random del PC
	public static String randomSceltaPC(ArrayList<String> list) {
		Random random = new Random();
        int ch = random.nextInt(list.size());
        return list.get(ch).toUpperCase();
	}

}
