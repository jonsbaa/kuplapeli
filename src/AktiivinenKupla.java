import java.util.Random;


public class AktiivinenKupla extends Kupla {
	public static Random rand = new Random();
	private Maailma maailma;
	private Pelimaailma pelimaailma;
	private double aste;
	private boolean pysahtynyt;
	private boolean nykyinen;
	private double x;
	private double y;

	public AktiivinenKupla(Pelimaailma p, Maailma m, 
			boolean nykyinen){
		super();
		this.maailma = m;
		this.pelimaailma = m.annaPelimaailma();
		this.nykyinen = nykyinen;
		if (this.nykyinen){
			this.asetaSijainti(228, 454);
		} else {
			this.asetaSijainti(228, 499);
		}
	}

	/**
	 * Metodi, jolla kuplaa liikutetaan. Kupla kimpoaa vasemmasta ja oikeasta
	 * sein�st� kulmassa, jonka asteluku on 180 - tulokulma. Liikkuminen
	 * tapahtuu kasvattamalla x:n ja y:n arvoja haluttuun suuntaan.
	 * @param muutos
	 */
	public void liiku(long muutos){
		double x = this.annaX();
		double y = this.annaY();
		
		this.aste = this.pelimaailma.annaKulma();
		
		/*
		 * T�rm�ttiin vasempaan sein��n.
		 */
		if (x < 50){
			aste = 180 - aste;
		}
		
		/*
		 * T�rm�ttiin oikeaan sein��n.
		 */
		if (x > 405){
			aste = 180 - aste;
		}

		/*
		 * Liikutetaan.
		 */
		
		if (y > 50){
		x += Math.cos(Math.toRadians(aste))*muutos*0.1;
		
		} else {
			this.pelimaailma.asetaKlikattu(false);
			this.pysahtynyt = true;
			
		}

		/*
		 * Y:n muutokset (ei koskaan kimpoa y-suunnassa, vaan pys�htyy yl�s
		 * tai kuplaan osuessaan).
		 */
		if (y > 50 && y < 465){
			y -= Math.sin(Math.toRadians(aste))*muutos*0.1;
		}

		this.asetaSijainti(x, y);
	}
	
	/**
	 * Antaa sen asteen, johon on liiku-metodissa p��dytty mahdollisen t�rm�ilyn
	 * seurauksena.
	 * @return
	 */
	public double annaAste(){
		return this.aste;
	}
	
	public boolean onPysahtynyt(){
		return this.pysahtynyt;
	}
	
	public void asetaNykyiseksi(){
		this.nykyinen = true;
		this.asetaSijainti(228, 454);
	}
}
