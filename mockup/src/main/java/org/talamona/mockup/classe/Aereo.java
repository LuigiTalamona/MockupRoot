package org.talamona.mockup.classe;

/**
 *
 * @author luigi
 */
public class Aereo extends Aeromobile{

	public Aereo(String matricola){
		super(matricola);
	}
	public Object leggiRegistroVolo(){
		return null;
	}
	public static void main(String[] args){
		Aereo a = new Aereo("AZT-1234");
	}
	
}
