/*
 * Autor: Antonio Garcia Illescas
 * 
 * Esta clase se ha modificado para usar una opcion extra llamada "Luchar Avanzado" que recrea la formula que se
 * utiliza en el juego para calcular la potencia del ataque y perdida de daño durante los combates pokemon.
 * 
 * Por falta de tiempo se ha añadido solo un ataque por pokemon y no una lista con varios tampoco se han filtrado
 * los errores del ultimo apartado por este mismo motivo.
 * 
 * Se han elegido valores fijos en las variables nuevas y los valores que se han utilizado son los que tendrian
 * dichos pokemon cuando estuvieran en nivel 30.
 * 
*/
import java.util.Random;

public class Pokemon {
	
	//Variables
	
	private String nombre, tipo;
	private Double fuerza;
	private int defensa, vida;
	private Ataques ataquesPokemon;
	
	
	//Constructores
	
	public Pokemon (int huevo) {
		Random numeroAleatorio = new Random();
		
		//Pikachu
		if (huevo == 0) {
			Double valorAleatorioPikachu = Math.random() * (60-30) + 30;
			this.nombre="Pikachu";
			this.fuerza=valorAleatorioPikachu;
			this.tipo="Electrico";
			this.defensa=29;
			this.vida=61;
			this.ataquesPokemon=new Ataques ("Electrico", "Trueno", 120);
			
		}
		
		//Squirtle
		if (huevo == 1) {
			Double valorAleatorioSquirtle = Math.random() * (50-40) + 40;
			this.nombre="Squirtle";
			this.fuerza=valorAleatorioSquirtle;
			this.tipo="Agua";
			this.defensa=44;
			this.vida=66;
			this.ataquesPokemon=new Ataques ("Agua", "Hidrobomba", 120);
		}
		//Charmander
		if (huevo == 2) {
			Double valorAleatorioCharmander = Math.random() * (40-35) + 35;
			this.nombre="Charmander";
			this.fuerza=valorAleatorioCharmander;
			this.tipo="Fuego";
			this.defensa=30;
			this.vida=63;
			this.ataquesPokemon =new Ataques ("Fuego", "Llamarada", 120);

		}
		//Bulbasaur
		if (huevo == 3) {
			Double valorBulbasaur = Math.random() * (50-40) + 40;
			this.nombre="Bulbasaur";
			this.fuerza=valorBulbasaur;
			this.tipo="Planta";
			this.defensa=34;
			this.vida=67;
			this.ataquesPokemon = new Ataques ("Planta", "Rayo Solar", 120);
		}
		//Pidgey
		if (huevo == 4) {
			Double valorPidgey = Math.random() * (40-35) + 35;
			this.nombre="Pidgey";
			this.fuerza=valorPidgey;
			this.tipo="Volador";
			this.defensa=29;
			this.vida=64;
			this.ataquesPokemon = new Ataques ("Volador", "Pajaro Osado", 120);
		}
		//Eevee
		if (huevo == 5) {
			Double valorEevee = Math.random() * (50-40) + 40;
			this.nombre="Eevee";
			this.fuerza=valorEevee;
			this.tipo="Normal";
			this.defensa=35;
			this.vida=73;
			this.ataquesPokemon = new Ataques ("Normal", "Autodestruccion", 200);

		}
		//Mankey
		if (huevo == 6) {
			Double valorMankey = Math.random() * (60-50) + 50;
			this.nombre = "Mankey";
			this.fuerza = valorMankey;
			this.tipo = "Lucha";
			this.defensa = 26;
			this.vida = 64;
			this.ataquesPokemon = new Ataques ( "Lucha", "A bocajarro", 120 );
			
		}
		
	}
	//Metodos
	
	//Setter y Getters
	public String getNombre () {
		return this.nombre;
	}
	
	public Double combatir () {
		return this.fuerza;
	}
	
	public String getTipo () {
		return this.tipo;
	}
	
	public Ataques getAtaquePokemon () {
		return this.ataquesPokemon;
	}
	
	public void setAtaques (Ataques ataque) {
		this.ataquesPokemon=ataque;
	}
	
	public int getDefensa () {
		return this.defensa;
	}
	
	public int getVida () {
		return this.vida;
	}
	
	//Metodo entrenar usando un valor aleatorio para las ganas
	public void entrenar () {
		
		int ganas;
		
		ganas = (int) Math.floor(Math.random()*6);
		
		this.fuerza=this.fuerza+ganas;
	}
	
	//Metodo entrenar pasandole las ganas
	public void entrenar2 (int ganas) {
		
		this.fuerza= this.fuerza+ganas;
		
	}
	
	public int nivel () {
		
		int nivel=0;
		
		if (this.fuerza>=0 && this.fuerza<=20) {//Nivel 1
			
			nivel = 1;
		}
		if (this.fuerza>=21 && this.fuerza<=40) {//Nivel 2
			
			nivel = 2;
		}
		if (this.fuerza>=41 && this.fuerza<=50) {//Nivel 3
			
			nivel = 3;
		}
		if (this.fuerza>=51 && this.fuerza<=60) {//Nivel 4
			nivel = 4;
		}
		if (this.fuerza>60) { //Nivel 5
			nivel = 5;
		} 
		
		return nivel;
		
	}
	
	//Metodo equals que que compara el nombre y la fuerza para ver si dos pokemons son iguales
		// (probablemente no funcione y creo que tampoco lo he utilizado)
	public boolean equals (Object objeto) {
		
		boolean igual= false;
		
		if (objeto instanceof Pokemon) {
			Pokemon pokiman = (Pokemon) objeto;
			if (pokiman.getNombre().equals(this.getNombre()) && (pokiman.combatir().equals(this.combatir()))) {
				igual = true;
			}
		}
		
		return igual;
	}
	

}
