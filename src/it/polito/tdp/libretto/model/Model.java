package it.polito.tdp.libretto.model;

import java.util.ArrayList;
import java.util.List;

public class Model {
	
	private List <Esame> esami;
	
	public Model(){
		this.esami = new ArrayList<Esame> ();
		}
	
	/**
	 * Aggiunge un nuovo esame all'elenco degli esami presenti, verificando che non ci sia già
	 * @param e
	 * @return true se l'ha inseerito, false se esisteva già e non l'ha quindi inserito
	 */
	public boolean addEsame (Esame e) {
		if(!esami.contains(e)){
			esami.add(e);
			return true;
			}
		else{
			return false;
		}
		// altrimenti con una generazione di un eccezione	
	}

	/** 
	 * Ricerca se esiste un esame con il codice specificato
	 * Se esiste, lo restituisce, altrimenti restituisce null.
	 * @param codice codice dell'esame da ricercare
	 * @return esame trovato, oppure null se non trovato
	 */
	public Esame trovaEsame (String codice){
	// fa internamente il ciclo for, creo l'oggetto perchè indexOf confronta oggetti 
		int pos = this.esami.indexOf(new Esame(codice, null, null));
		if(pos == -1){
			return null;}
		else {
			return esami.get(pos);}
				}
}
