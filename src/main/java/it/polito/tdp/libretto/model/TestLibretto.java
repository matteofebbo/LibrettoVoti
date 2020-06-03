package it.polito.tdp.libretto.model;

import java.time.LocalDate;

public class TestLibretto {
	
	Libretto lib ;
	
	private void run() {
		this.lib = new Libretto() ; // crea libretto vuoto
		// 1. Inserire alcuni voti
		Voto v1 = new Voto("Tecniche di programmazione", 30, LocalDate.of(2020, 06, 15)) ;
		Voto v2 = new Voto("Analisi II", 28, LocalDate.of(2020, 06, 28)) ;

		lib.add(v1);
		lib.add(v2);
		lib.add(new Voto("Economia", 24, LocalDate.of(2020, 02, 14)));
		
		System.out.println(this.lib) ;
		//2. Stampa tutti i voti uguali a 28
		System.out.println(this.lib.stampaVotiUguali(28)) ;
		
		System.out.println(this.lib.estraiVotiUguali(28)) ;
		
		//3. Cerca esame superato a apartire dal nome
		
		String nomeCorso="Analisi II";
		Voto votoAnalisi=lib.cercaNomeCorso(nomeCorso);
		System.out.println("Il voto di "+nomeCorso+" e' "+votoAnalisi.getVoto());
		
		//4. 5. Verifica voti duplicati o voti in conflitto
		Voto economia2= new Voto("Economia", 24, LocalDate.now());
		Voto economia3= new Voto("Economia", 21, LocalDate.now());
		System.out.println("Economia con 24 e' duplicato: "+lib.isDuplicato(economia2) +" /conflitto: "+lib.isConflitto(economia2));
		System.out.println("Economia con 21 e' duplicato: "+lib.isDuplicato(economia3) +" /conflitto: "+lib.isConflitto(economia3));
		
		//6. Migliora il libretto
		Libretto migliorato=lib.creaLibrettoMigliorato();
		System.out.println("Miglioramento del libretto");
		System.out.println(lib);
		System.out.println(migliorato);
		
		//7. Stampa in ordine alfabetico
		Libretto alfabetico = new Libretto(lib);
		alfabetico.ordinaPerCorso();
		System.out.println(alfabetico);
		//7. Stampa in ordine di voto
		Libretto alfabetico1 = new Libretto(lib);
		alfabetico1.ordinaPerVoto();
		System.out.println(alfabetico1);
		
		//9. elimina dal libretto voti minori di 24
		lib.add(new Voto("Chimica",19,LocalDate.now()));
		lib.ordinaPerCorso();
		System.out.println(lib);
		lib.cancellaVotiScarsi();
		System.out.println(lib);
	}

	public static void main(String[] args) {
		TestLibretto test = new TestLibretto() ;
		test.run();
	}

}
