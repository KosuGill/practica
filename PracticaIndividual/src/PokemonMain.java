import java.util.ArrayList;
import java.util.Iterator;
import java.util.Scanner;


public class PokemonMain {
	
	public static void encontrarPokemon (ArrayList<Pokemon> pokemon) {
		
		int huevo;
		Scanner teclado = new Scanner(System.in);
		System.out.println("Valor del huevo:");
		huevo = teclado.nextInt();
		
		Pokemon objeto = new Pokemon (huevo);
		pokemon.add(objeto);
		
	}
	
	public static void verPokedex (ArrayList <Pokemon>  pokemon) {
		
		Iterator<Pokemon> iteradorListaPokemon = pokemon.iterator();
		
		while (iteradorListaPokemon.hasNext()) {

			Pokemon mostrar = iteradorListaPokemon.next();

			System.out.println(pokemon.indexOf(mostrar)+ " " + mostrar.getNombre() + " " + mostrar.combatir() + mostrar.nivel());

		}
	}
	
	public static void entrenarPokemon (ArrayList <Pokemon> pokemon) throws ArrayIndexOutOfBoundsException {
		
		int ganas, posicion;
		Scanner teclado = new Scanner(System.in);
		
		System.out.println("Posicion: ");
		posicion = teclado.nextInt();
		
		/*System.out.println("Ganas: "); OTRA FORMA (PASANDOLE LAS GANAS)
		ganas = teclado.nextInt();
		pokemon.get(posicion).entrenar2(ganas);*/
			
		if (posicion < 0 || posicion >= pokemon.size()) {
			throw new ArrayIndexOutOfBoundsException("El pokemon no existe");
		} 
		Pokemon pokemon1 = pokemon.get(posicion);
		pokemon.get(posicion).entrenar();
	
	}
	
	//Combaten 2 pokemon pero pasandoles un arraylist
	public static void Combatir1 (ArrayList <Pokemon> pokemon) {
		
		verPokedex(pokemon);
		
		int posicion1, posicion2;
		Scanner teclado = new Scanner(System.in);
		System.out.println("Elegir pokemon: ");
		posicion1 = teclado.nextInt();
		System.out.println("Posicion: ");
		posicion2 = teclado.nextInt();
		
		Pokemon objeto1 = pokemon.get(posicion1);
		Pokemon objeto2 = pokemon.get(posicion2);
		
		if ((pokemon.contains(objeto1) == true) && (pokemon.contains(objeto2))) {
			
			if (pokemon.get(posicion1).combatir()> pokemon.get(posicion2).combatir()) {
				System.out.println("Ganador " + pokemon.get(posicion1).getNombre() + " " + pokemon.get(posicion1).combatir());
			} else {
				System.out.println("Ganador " + pokemon.get(posicion2).getNombre() + " " + pokemon.get(posicion2).combatir());

			}
				
		}
		
	}
	
	//Combate pokemon pasando dos objetos
	public static void Combatir (Pokemon pokeA, Pokemon pokeB) {
		
		if (pokeA.combatir() > pokeB.combatir()) {
			
			System.out.println("Ganador " + pokeA.getNombre() + " " + pokeA.combatir() + " / " + pokeA.nivel());
			
		} else {
			
			System.out.println("Ganador " + pokeB.getNombre() + " " + pokeB.combatir() + " / " + pokeB.nivel());

		}
	}
	
	public static boolean existo (Pokemon poke, ArrayList <Pokemon> pokemon) {
		boolean si = false;
		
		if (pokemon.contains(poke) == true) {
			si = true;
		}
		return si;
	}
	
	
	public static void opcionesMenu () {
		System.out.println(" 1. Encontrar pokemon nuevo \n 2. Entrenar \n 3. Combatir \n 4. Ver pokedex \n 5. Salir \n");
	}
	

	public static void main(String[] args) {
		// Variables
		
		int opcionMenu;
		boolean controlaMenu=false, controlaSubMenu=false;
		char opcionSubMenu;
		
		ArrayList <Pokemon> pokemon = new ArrayList <Pokemon>();
		
		Scanner teclado = new Scanner(System.in);
		
		while (controlaMenu == false ) {
			
			opcionesMenu();
			
			System.out.print("Opcion: ");
			opcionMenu = teclado.nextInt();
			switch (opcionMenu) {
			
			case 1:
				
				encontrarPokemon(pokemon);//Metodo de encontrar el pokemon
				
				controlaSubMenu=false;//Resetear el valor para cuando volvamos a repetir desde el menu principal
				
				//Bucle para que se puedan introducir mas pokemon dentro de la opcion
				while (controlaSubMenu==false) {
					
					controlaSubMenu=false;//Resetar el valor para cuando se quiera introducir otro pokemon desde el menu principal
					
					System.out.println("¿Quiere encontrar otro pokemon? (Y/N)");
					System.out.print("Opcion:");
					opcionSubMenu=teclado.next().charAt(0);
					
					//Comprobamos si hemos terminado de encontrar pokemons
					if (opcionSubMenu=='n' || opcionSubMenu=='N') {
						controlaSubMenu=true;
					} else {
						encontrarPokemon(pokemon);
					}
				}
				
				break;
				
			case 2:
				
				verPokedex(pokemon); //Ver la lista de pokemon y sus posiciones para elegir cual entrenar
				
				
				try {
					entrenarPokemon(pokemon);
				} catch (Exception ex) {
					System.out.println(ex.getMessage());
				}
				
				
				controlaSubMenu=false;//Resetear el valor para cuando volvamos a repetir desde el menu principal
				
				//Bucle para que se puedan entrenar mas pokemon dentro de la opcion
				while (controlaSubMenu==false) {
					
					
					System.out.println("¿Quiere entrenar otro pokemon? (Y/N)");
					System.out.print("Opcion:");
					opcionSubMenu=teclado.next().charAt(0);
					
					//Comprobamos si hemos terminado de entrenar pokemons
					if (opcionSubMenu=='n' || opcionSubMenu=='N') {
						controlaSubMenu=true;
					} else {
						try {
							entrenarPokemon(pokemon);
						} catch (Exception ex) {
							ex.getMessage();
						}
					}
				}
				
				//Mostramos los resultados despues del aumento de nivel
				System.out.println("Despues del aumento de nivel los stats han quedado asi: ");
				verPokedex(pokemon);
				
				break;
				
			case 3:
				
				int posicion1, posicion2;
				
				verPokedex(pokemon); //Ver la lista de pokemon y sus posiciones para elegir cuales combatiran
				
				System.out.println("Elegir pokemon que va a luchar: ");
				posicion1 = teclado.nextInt();
				System.out.println("Elegir al otro pokemon que va a luchar ");
				posicion2 = teclado.nextInt();
				
				Pokemon objeto1 = pokemon.get(posicion1);
				Pokemon objeto2 = pokemon.get(posicion2);
				
				if ((existo(objeto1, pokemon) == true) && (existo (objeto2, pokemon) == true)) {
					Combatir(pokemon.get(posicion1), pokemon.get(posicion2));
				}
				
				
				controlaSubMenu=false;//Resetear el valor para cuando volvamos a repetir desde el menu principal
				
				//Bucle para que se puedan hacer mas combates
				while (controlaSubMenu==false) {
					
					controlaSubMenu=false;//Resetar el valor para cuando se quiera entrenar otro pokemon desde el menu principal
					
					System.out.println("¿Quiere realizar otro combate? (Y/N)");
					System.out.print("Opcion:");
					opcionSubMenu=teclado.next().charAt(0);
					
					//Preguntar si se se quieren poner a combatir mas pokemon
					if (opcionSubMenu=='n' || opcionSubMenu=='N') {
						
						controlaSubMenu=true;
						
					} else {
						
						verPokedex(pokemon);
						
						System.out.println("Elegir pokemon que va a luchar: ");
						posicion1 = teclado.nextInt();
						
						System.out.println("Elegir al otro pokemon que va a luchar ");
						posicion2 = teclado.nextInt();
						
						Pokemon objeto3 = pokemon.get(posicion1);
						Pokemon objeto4 = pokemon.get(posicion2);
						
						if ((existo(objeto3, pokemon) == true) && (existo (objeto3, pokemon) == true)) {
							Combatir(pokemon.get(posicion1), pokemon.get(posicion2));
						}
						
					}
				}
				
				break;
				
			case 4:
				
				verPokedex(pokemon);
				
				break;
				
			case 5:
				
				controlaMenu=true;
				break;
				
			default:
				
				System.out.println("Esa opcion no existe en el menu");
				break;
			}
		}
		
		
		
		
		
	}

}
