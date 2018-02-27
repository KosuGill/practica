import java.util.ArrayList;
import java.util.Iterator;
import java.util.Scanner;


public class PokemonMain {
	
	//Especificamos el numero de huevo que queremos tener y los datos de ese pokemon se asignaran automaticamente con el constructor
	public static void encontrarPokemon (ArrayList<Pokemon> pokemon) throws NullPointerException {
		
		int huevo;
		
		Scanner teclado = new Scanner(System.in);
		
		System.out.println("Valor del huevo:");
		huevo = teclado.nextInt();
		
		if (huevo < 0 || huevo > 2) {
			throw new NullPointerException ("No se puede asignar un valor que no este comprendido entre 0 y 2 (incluidos)");
		}
		
		//Si no se lanza la excepcion se asignan los datos del pokemon al objeto y se entrena
		Pokemon objeto = new Pokemon (huevo);
		pokemon.add(objeto);
		
	}
	
	//Recorremos el arraylist de pokemon y los mostramos
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
			throw new ArrayIndexOutOfBoundsException("El pokemon no existe\n");

		} else {//Si no se lanza la excepcion se asignan los datos del pokemon al objeto y se entrena
			Pokemon pokemon1 = pokemon.get(posicion);
			pokemon.get(posicion).entrenar();
		}

	} 
		
	
	//Combaten 2 pokemon pero pasandoles un arraylist
	public static void Combatir1 (ArrayList <Pokemon> pokemon) {
		
		verPokedex(pokemon);//Mostramos la pokedex
		
		int posicion1, posicion2;
		Scanner teclado = new Scanner(System.in);
		System.out.println("Elegir pokemon: ");
		posicion1 = teclado.nextInt();
		System.out.println("Posicion: ");
		posicion2 = teclado.nextInt();
		
		Pokemon objeto1 = pokemon.get(posicion1);
		Pokemon objeto2 = pokemon.get(posicion2);
		
		if ((pokemon.contains(objeto1) == true) && (pokemon.contains(objeto2))) {//Comparamos si ambos objetos existen en el arraylist
			
			if (pokemon.get(posicion1).combatir()> pokemon.get(posicion2).combatir()) {
				
				System.out.println("Ganador " + pokemon.get(posicion1).getNombre() + " " + pokemon.get(posicion1).combatir());
			
			} else {
				
				System.out.println("Ganador " + pokemon.get(posicion2).getNombre() + " " + pokemon.get(posicion2).combatir());

			}
				
		}
		
	}
	
	
	//Combate pokemon pasando dos objetos
	
	public static void Combatir (Pokemon pokeA, Pokemon pokeB){
		
		if (pokeA.combatir() > pokeB.combatir()) {//Comparamos cual tiene mayor fuerza
			
			System.out.println("El ganador es " + pokeA.getNombre() + " con una fuerza de" + pokeA.combatir() + " y un nivel de " + pokeA.nivel());
			
		} else {
			
			System.out.println("El ganador es " + pokeB.getNombre() + " con una fuerza de " + pokeB.combatir() + " y un nivel de " + pokeB.nivel());

		}
	}
	
	//Metodo para saber si un objeto existe en un arraylist
	public static boolean existo (Pokemon poke, ArrayList <Pokemon> pokemon) {
		
		boolean si = false;
		
		if (pokemon.contains(poke) == true) {//Comprobamos si el objeto existe en el arraylist
			
			si = true;
			
		}
		return si;
	}
	
	//Comprueba si existe la posicion en el array list
	public static void posicionesMal (int posicion, ArrayList <Pokemon> pokemon) throws ArrayIndexOutOfBoundsException {
		
		
		if (posicion >= pokemon.size() || posicion < 0) {//Vemos si esta fuera o no del rango
			
			throw new ArrayIndexOutOfBoundsException("El pokemon en la posicion " + posicion + " no existe");
			
		}
		
	}
	
	//Mostrar las opciones del menu
	public static void opcionesMenu () {
		System.out.println("\n 1. Encontrar pokemon nuevo \n 2. Entrenar \n 3. Combatir \n 4. Ver pokedex \n 5. Salir \n");
	}
	

	public static void main(String[] args) {
		
		// Variables
		
		int opcionMenu;
		boolean controlaMenu=false, controlaSubMenu=false;
		char opcionSubMenu;
		
		ArrayList <Pokemon> pokemon = new ArrayList <Pokemon>();
		ArrayList <Ataques> ataques = new ArrayList <Ataques>();
		
		Scanner teclado = new Scanner(System.in);
		
		while (controlaMenu == false ) {
			
			opcionesMenu();//Mostramos el menu
			
			System.out.print("Opcion: ");
			opcionMenu = teclado.nextInt();
			switch (opcionMenu) {//Opcion del menu
			
			case 1:
				
				try {
					encontrarPokemon(pokemon);//Metodo de encontrar el pokemon
				} catch (Exception ex) {
					System.out.print(ex.getMessage());
				}
				
				controlaSubMenu=false;//Resetear el valor para cuando volvamos a repetir desde el menu principal
				
				//Bucle para que se puedan introducir mas pokemon dentro de la opcion
				while (controlaSubMenu==false) {
					
					controlaSubMenu=false;//Resetar el valor para cuando se quiera introducir otro pokemon desde el menu principal
					
					System.out.println("\n¿Quiere encontrar otro pokemon? (Y/N)");
					System.out.print("Opcion:");
					opcionSubMenu=teclado.next().charAt(0);
					
					//Comprobamos si hemos terminado de encontrar pokemons
					if (opcionSubMenu=='n' || opcionSubMenu=='N') {
						
						controlaSubMenu=true;
						
					} else {
						
						try {
							encontrarPokemon(pokemon);//Metodo de encontrar el pokemon
						} catch (Exception ex) {
							System.out.print(ex.getMessage());
						}
						
					}
				}
				
				break;
				
			case 2:
				
				verPokedex(pokemon); //Ver la lista de pokemon y sus posiciones para elegir cual entrenar
				
				//Comprobamos si se genera una excepcion
				try {
					entrenarPokemon(pokemon);
				} catch (Exception ex) {
					System.out.println(ex.getMessage());
				}
				
				
				controlaSubMenu=false;//Resetear el valor para cuando volvamos a repetir desde el menu principal
				
				//Bucle para que se puedan entrenar mas pokemon dentro de la opcion
				while (controlaSubMenu==false) {
					
					
					System.out.println("\n¿Quiere entrenar otro pokemon? (Y/N)");
					System.out.print("Opcion:");
					opcionSubMenu=teclado.next().charAt(0);
					
					//Comprobamos si hemos terminado de entrenar pokemons
					if (opcionSubMenu=='n' || opcionSubMenu=='N') {
						controlaSubMenu=true;
					} else {
						try {
							entrenarPokemon(pokemon);
						} catch (Exception ex) {
							System.out.println(ex.getMessage());
						}
					}
				}
				
				//Mostramos los resultados despues del aumento de nivel
				System.out.println("Despues del aumento de nivel los stats han quedado asi: ");
				verPokedex(pokemon);
				
				break;
				
			case 3:
				
				//Variables
				int posicion1, posicion2;
				Pokemon objeto1 = null, objeto2 = null, objeto3 = null, objeto4= null;
				
				
				verPokedex(pokemon); //Ver la lista de pokemon y sus posiciones para elegir cuales combatiran
				
				//Entradas
				System.out.println("Elegir pokemon que va a luchar: ");
				posicion1 = teclado.nextInt();
				System.out.println("Elegir al otro pokemon que va a luchar ");
				posicion2 = teclado.nextInt();
				
				
				//Comprobamos si el pokemon en esa posicion existe utilizando un metodo
				try {
					
					posicionesMal (posicion1, pokemon);
					
				} catch (Exception ex) {
					
					System.out.println(ex.getMessage());
					
				}
				
				//Comprobamos si el pokemon en esa posicion existe utilizando un metodo (Si no se pone el try catch se ejecutan y dan error)
				try {
					
					posicionesMal (posicion2, pokemon);
					
				} catch (Exception ex) {
					System.out.println(ex.getMessage());
				}
				
				//Comprobamos si se pueden asignar los datos a los objetos
				try {
					
					objeto1 = pokemon.get(posicion1);
					objeto2 = pokemon.get(posicion2);
					
					
				} catch (Exception ex) {
					
					System.out.println("No se han podido asignar las posiciones de los pokemons a los objetos");
					
				}
				
				//Comprobamos si los pokemon en esa posicion existe utilizando un metodo (Si no se pone la condicion se ejecuta por error cuando alguno de los pokemon esta mal)
				if ((existo(objeto1, pokemon) == true) && (existo (objeto2, pokemon) == true)) {
						Combatir(pokemon.get(posicion1), pokemon.get(posicion2));
					
				}
				
				controlaSubMenu=false;//Resetear el valor para cuando volvamos a repetir desde el menu principal
				
				//Bucle para que se puedan hacer mas combates
				while (controlaSubMenu==false) {
					
					controlaSubMenu=false;//Resetar el valor para cuando se quiera entrenar otro pokemon desde el menu principal
					
					System.out.println("\n¿Quiere realizar otro combate? (Y/N)");
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
						
						//Comprobamos si el pokemon en esa posicion existe utilizando un metodo
						try {
							posicionesMal (posicion1, pokemon);
						} catch (Exception ex) {
							System.out.println(ex.getMessage());
						}
						
						
						//Comprobamos si el pokemon en esa posicion existe utilizando un metodo (Si no se pone el try catch se ejecutan y dan error
						try {
							posicionesMal (posicion2, pokemon);
						} catch (Exception ex) {
							System.out.println(ex.getMessage());
						}
						
						
						//Comprobamos si se pueden asignar los datos a los objetos
						try {
							objeto3 = pokemon.get(posicion1);
							objeto4 = pokemon.get(posicion2);
							
						} catch (Exception ex) {
							System.out.println("No se han podido asignar las posiciones de los pokemons a los objetos");
						}
						
						
						//Comprobamos si los pokemon en esa posicion existe utilizando un metodo (Si no se pone la condicion se ejecuta por error cuando alguno de los pokemon esta mal
						if ((existo(objeto3, pokemon) == true) && (existo (objeto4, pokemon) == true)) {
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
