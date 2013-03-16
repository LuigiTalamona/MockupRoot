package org.talamona.mockup.classe;

/**
 *
 * @author luigi
 */
public class Elicottero extends Aeromobile{

	public Elicottero(String matricola){
		super(matricola);
	}
	public Object leggiRegistroVolo(){
		return null;
	}
	public static void main(String[] args){
		Elicottero e = new Elicottero("CHK-0001");
	}
	
}
