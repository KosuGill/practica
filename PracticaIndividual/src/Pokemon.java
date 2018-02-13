import java.util.Random;

public class Pokemon {
	
	//Variables
	
	private String nombre;
	private Double fuerza;
	
	//Constructores
	
	public Pokemon (int huevo) {
		Random numeroAleatorio = new Random();
		
		if (huevo == 0) {
			Double valorAleatorioPikachu = Math.random() * (60-30) + 30;
			this.nombre="Pikachu";
			this.fuerza=valorAleatorioPikachu;
			
		}
		if (huevo == 1) {
			Double valorAleatorioSquirtle = Math.random() * (50-40) + 40;
			this.nombre="Squirtle";
			this.fuerza=valorAleatorioSquirtle;
			
		}
		
		if (huevo == 2) {
			Double valorAleatorioCharmander = Math.random() * (55-45) + 45;
			this.nombre="Charmander";
			this.fuerza=valorAleatorioCharmander;
			
		}
		
	}
	//Metodos
	
	public String getNombre () {
		return this.nombre;
	}
	
	public Double combatir () {
		return this.fuerza;
	}
	public void entrenar () {
		int ganas;
		ganas = (int) Math.floor(Math.random()*6);
		this.fuerza=this.fuerza+ganas;
	}
	public void entrenar2 (int ganas) {
		this.fuerza= this.fuerza+ganas;
	}
	public int nivel () {
		
		int nivel=0;
		
		if (this.fuerza>=0 && this.fuerza<=20) {
			
			nivel = 1;
		}
		if (this.fuerza>=21 && this.fuerza<=40) {
			
			nivel = 2;
		}
		if (this.fuerza>=41 && this.fuerza<=50) {
			
			nivel = 3;
		}
		if (this.fuerza>=51 && this.fuerza<=60) {
			nivel = 4;
		}
		if (this.fuerza>60) {
			nivel = 5;
		} 
		return nivel;
	}
	

}
