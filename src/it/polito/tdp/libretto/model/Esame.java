package it.polito.tdp.libretto.model;

import java.time.LocalDate;

//Oggetto semplice che contiene i dati rfelativi ad ogni singolo esame
//POJO plain old java object
//Contiene:
//-dati privati (proprietà
//-costruttore
//-getter e setter
//-metodi di servizio (hashCode, toString, compareTo, eqauls,..)

	public class Esame {

//	info minime:
	
		private String codice;
		private String titolo;
		private String docente;
//	private Docente docente; questa è la soluzione più giusta, perchè non è strettamente legata al corso
//	( non è un suo attirbuto), ma esiste indipedentemente
		private boolean superato;
		private int voto;
		private LocalDate dataSuperamento;
		
	/**
	 * Nuovo esame, non ancora superato
	 * @param codice codice dell'esame
	 * @param titolo denominazione del corso
	 * @param docente cognome e nome del docente titolare
	 */
		
	public Esame(String codice, String titolo, String docente) {
		super();
			this.codice = codice;
			this.titolo = titolo;
			this.docente = docente;
			
			this.superato = false;
		}

	/**
	 * @return the codice
	 */
	public String getCodice() {
		return codice;
	}

	/**
	 * @param codice the codice to set
	 */
	public void setCodice(String codice) {
		this.codice = codice;
	}

	/**
	 * @return the titolo
	 */
	public String getTitolo() {
		return titolo;
	}

	/**
	 * @param titolo the titolo to set
	 */
	public void setTitolo(String titolo) {
		this.titolo = titolo;
	}

	/**
	 * @return the docente
	 */
	public String getDocente() {
		return docente;
	}

	/**
	 * @param docente the docente to set
	 */
	public void setDocente(String docente) {
		this.docente = docente;
	}

	/**
	 * @return the superato
	 */
	public boolean isSuperato() {
		return superato;
	}

	/**
	 * @param superato the superato to set
	 */
	private void setSuperato(boolean superato) {
		this.superato = superato;
	}

	/** Restituisce il voto solo se l'esame è stato superato, altrimenti eccezione.
	 * @return the voto
	 */
	public int getVoto() {
		if(this.superato)
			return voto;
		else {
			throw new IllegalStateException("Esame "+codice+" non ancora superato");
		}
	}

	/**
	 * @param voto the voto to set
	 */
	private void setVoto(int voto) {
		this.voto = voto;
	}

	/**
	 * @return the dataSuperamento
	 */
	public LocalDate getDataSuperamento() {		
		if(this.superato){
		return dataSuperamento;}
	else {
		throw new IllegalStateException("Esame "+codice+" non ancora superato");
	}

		
	}

	/**
	 * @param dataSuperamento the dataSuperamento to set
	 */
	private void setDataSuperamento(LocalDate dataSuperamento) {
		this.dataSuperamento = dataSuperamento;
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "Esame [codice=" + codice + ", titolo=" + titolo + ", docente=" + docente + ", superato=" + superato
				+ ", voto=" + voto + ", dataSuperamento=" + dataSuperamento + "]";
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#hashCode()
	 */
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((codice == null) ? 0 : codice.hashCode());
		return result;
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#equals(java.lang.Object)
	 */
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Esame other = (Esame) obj;
		if (codice == null) {
			if (other.codice != null)
				return false;
		} else if (!codice.equals(other.codice))
			return false;
		return true;
	}
		
	/**
	 * Se l'esame non è ancora superato, lo considera superato con il voto e la data specificati.
	 * Se invece l'esame era già superato, genera un'eccezione.
	 * @param voto
	 * @param data
	 */
	public void supera( int voto, LocalDate data){
		if(! this.superato){
			this.superato = true;
			this.voto = voto;
			this.dataSuperamento = data;
			}
		else {
			throw new IllegalStateException("Esame "+codice+" già superato");
			//illegalargument il valore dell'argomento non è lecito
			}
	}

	
		
}
