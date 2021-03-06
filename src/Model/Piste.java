package Model;


/**
 * Javan Point-luokka ottaa parametreina int-tyyppisen x:n ja y:n, mutta
 * tarvitsin k�ytt��ni double-tyyppiset, joten tein oman luokan pisteit� varten.
 * @author 345480
 *
 */
public class Piste {

	/** Pisteen x-koordinaatti. */
	private double x;

	/** Pisteen y-koordinaatti. */
	private double y;

	/**
	 * Pisteen konstruktori, joka ottaa parametreinaan x:n ja y:n.
	 * N�m� alustetaan.
	 * @param x pisteen x-koordinaatti.
	 * @param y pisteen y-koordinaatti.
	 */
	public Piste(double x, double y) {
		this.x = x;
		this.y = y;
	}

	/**
	 * Metodi palauttaa pisteen x-koordinaatin.
	 * @return x-koordinaatti
	 */
	public double annaX(){
		return this.x;
	}

	/**
	 * Metodi palauttaa pisteen y-koordinaatin.
	 * @return y-koordinaatti
	 */
	public double annaY(){
		return this.y;
	}

	/**
	 * Asettaa pisteelle sijainnin.
	 */
	public void asetaSijainti(double x, double y){
		this.x = x;
		this.y = y;
	}
}
