import java.util.ArrayList;
import java.util.Iterator;
import java.util.Scanner;


public class PokemonMain {
	
	//Especificamos el numero de huevo que queremos tener y los datos de ese pokemon se asignaran automaticamente con el constructor
	public static void encontrarPokemon (ArrayList<Pokemon> pokemon) throws NullPointerException {
		
		//Variables
		int huevo;
		
		//Entradas
		Scanner teclado = new Scanner(System.in);
		
		System.out.println("Valor del huevo: (Del 0 al 6)");
		huevo = teclado.nextInt();
		
		
		//Para comprobar que no se introduce un valor no deseado
		if (huevo < 0 || huevo > 6) {
			throw new NullPointerException ("No se puede asignar un valor que no este comprendido entre 0 y 2 (incluidos)");
		}
		
		//Vemor el pokemon que hemos encontrado dependiendo del valor del huevo introducido
		if (huevo == 0) {
			System.out.println("Has encontrado un Pikachu");
		}
		if (huevo == 1) {
			System.out.println("Has encontrado un Squirtle");
		}
		
		if (huevo == 2) {
			System.out.println("Has encontrado un Charmander");
		}
		if (huevo == 3) {
			System.out.println("Has encontrado un Bulbasaur");
		}
		if (huevo == 4) {
			System.out.println("Has encontrado un Pidgey");
		}
		if (huevo == 5) {
			System.out.println("Has encontrado un Eevee");
		}
		if (huevo == 6) {
			System.out.println("Has encontrado un Mankey");
		}
		
		//Si no se lanza la excepcion se asignan los datos del pokemon al objeto y se entrena
		Pokemon objeto = new Pokemon (huevo);
		pokemon.add(objeto);
		
	}
	
	//Recorremos el arraylist de pokemon y los mostramos
	public static void verPokedex (ArrayList <Pokemon>  pokemon) throws Exception {
		
		//Si el array de pokemon creara una excepcion
		if (pokemon.size()==0) {
			
			throw new Exception ("No tienes ningun pokemon registrado en la pokedex");
			
		} else {//Si no esta vacio recorrera el array y mostrara lo que contiene
			
			Iterator<Pokemon> iteradorListaPokemon = pokemon.iterator();
			
			while (iteradorListaPokemon.hasNext()) {

				Pokemon mostrar = iteradorListaPokemon.next();

				System.out.println(pokemon.indexOf(mostrar)+ " " + mostrar.getNombre() + " " + mostrar.combatir() + mostrar.nivel());

			}
			
		}
		
	}
	
	//Subimos las stats de un pokemon seleccionado usando un metodo de la clase
	public static void entrenarPokemon (ArrayList <Pokemon> pokemon) throws ArrayIndexOutOfBoundsException {
		
		//Variables
		int ganas, posicion;
		Scanner teclado = new Scanner(System.in);
		
		//Entradas
		System.out.println("Posicion: ");
		posicion = teclado.nextInt();
		
		/*System.out.println("Ganas: "); OTRA FORMA (PASANDOLE LAS GANAS)
		ganas = teclado.nextInt();
		pokemon.get(posicion).entrenar2(ganas);*/
			
		//Si se le pasa una posicion que no existe lanza una excepcion
		if (posicion < 0 || posicion >= pokemon.size()) {
			throw new ArrayIndexOutOfBoundsException("El pokemon no existe\n");

		} else {//Si no se lanza la excepcion se asignan los datos del pokemon al objeto y se entrena
			Pokemon pokemon1 = pokemon.get(posicion);
			pokemon.get(posicion).entrenar();
		}

	} 
		
	
	//Combaten 2 pokemon pero pasandoles un arraylist
	public static void Combatir1 (ArrayList <Pokemon> pokemon) {
		
<<<<<<< HEAD
		//Mostramos los pokemons
		verPokedex(pokemon);//Mostramos la pokedex
=======
		//Mostramos la pokedex
		try {
			verPokedex(pokemon);
		} catch (Exception ex) {
			System.out.println(ex.getMessage());
		}
>>>>>>> 542bf3ac4f824f7ba92a8caea48e805bc56fb23c
		
		//Variables
		int posicion1, posicion2;
		Scanner teclado = new Scanner(System.in);
		
		System.out.println("Elegir pokemon: ");
		posicion1 = teclado.nextInt();
		
		System.out.println("Posicion: ");
		posicion2 = teclado.nextInt();
		
<<<<<<< HEAD
		//Asignamos los valores a los objetos
=======
		//Cogemos los dos pokemons selecionados
>>>>>>> 542bf3ac4f824f7ba92a8caea48e805bc56fb23c
		Pokemon objeto1 = pokemon.get(posicion1);
		Pokemon objeto2 = pokemon.get(posicion2);
		
		
		if ((pokemon.contains(objeto1) == true) && (pokemon.contains(objeto2))) {//Comparamos si ambos objetos existen en el arraylist
			
			//Comparamos quien tiene mas fuerza, el que tenga mas fuerza ganara el combate
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
			
			System.out.println("El ganador es " + pokeA.getNombre() + " con una fuerza de " + pokeA.combatir() + " y un nivel de " + pokeA.nivel());
			
		} else {
			
			System.out.println("El ganador es " + pokeB.getNombre() + " con una fuerza de " + pokeB.combatir() + " y un nivel de " + pokeB.nivel());

		}
	}
	
	//Metodo para saber si un objeto existe en un arraylist
	public static boolean existo (Pokemon poke, ArrayList <Pokemon> pokemon) {
		
		//Variables
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
	
	//La efectividad es uno de los valores que se tiene en cuenta a la hora de calcular el daño es el tipo del pokemon y el tipo del rival
	public static Double efectividad (Pokemon pokeA, Pokemon pokeB) {
		
		//Variables
		int posicion1, posicion2;
		Double efectividad=0.0, bonificacion=0.0; 
		
		
		//Comprobacion de la efectividad, si es debil a ese tipo se le da 0,5. neutro 1, superefectivo 2
		
		//Tipo electrico
		if (pokeA.getTipo() == "Electrico" && (pokeB.getTipo() == "Electrico" || pokeB.getTipo() == "Planta")) {
			efectividad = 0.5;
		}
		else if (pokeA.getTipo() == "Electrico" && (pokeB.getTipo() == "Normal" || pokeB.getTipo() == "Lucha" || pokeB.getTipo() == "Fuego" ) ) {
			efectividad = 1.0;
		}
		else if (pokeA.getTipo() == "Electrico" && (pokeB.getTipo() == "Agua" || pokeB.getTipo() == "Volador") ) {
			efectividad = 2.0;
		}
		
		//Tipo Agua
		else if (pokeA.getTipo() == "Agua" && (pokeB.getTipo() == "Planta" || pokeB.getTipo() == "Electrico" || pokeB.getTipo() == "Agua")) {
			efectividad = 0.5;
		}
		else if (pokeA.getTipo() == "Agua" && (pokeB.getTipo() == "Volador" || pokeB.getTipo() == "Normal" || pokeB.getTipo() == "Lucha" ) ) {
			efectividad = 1.0;
		}
		else if (pokeA.getTipo() == "Agua" && pokeB.getTipo() == "Fuego" ) {
			efectividad = 2.0;
		}
		
		//Tipo Fuego
		else if (pokeA.getTipo() == "Fuego" && (pokeB.getTipo() == "Agua" || pokeB.getTipo() == "Fuego")) {
			efectividad = 0.5;
		}
		else if (pokeA.getTipo() == "Fuego" && (pokeB.getTipo() == "Normal" || pokeB.getTipo() == "Lucha" || pokeB.getTipo() == "Volador" || pokeB.getTipo() == "Electrico") ) {
			efectividad = 1.0;
		}
		else if (pokeA.getTipo() == "Fuego" && pokeB.getTipo() == "Planta" ) {
			efectividad = 2.0;
		}
		
		//Tipo Planta
		else if (pokeA.getTipo() == "Planta" && (pokeB.getTipo() == "Planta" || pokeB.getTipo() == "Fuego" || pokeB.getTipo() == "Volador") ) {
			efectividad = 0.5;
		}
		else if (pokeA.getTipo() == "Planta" && (pokeB.getTipo() == "Normal" || pokeB.getTipo() == "Lucha" || pokeB.getTipo() == "Electrico" ) ) {
			efectividad = 1.0;
		}
		else if (pokeA.getTipo() == "Planta" && pokeB.getTipo() == "Agua" ) {
			efectividad = 2.0;
		}
		
		//Tipo Volador
		else if(pokeA.getTipo() == "Volador" && pokeB.getTipo() == "Electrico") {
			efectividad = 0.5;
		}
		else if (pokeA.getTipo() == "Volador" && (pokeB.getTipo() == "Normal" || pokeB.getTipo() == "Agua" || pokeB.getTipo() == "Volador" || pokeB.getTipo() == "Fuego" ) ) {
			efectividad = 1.0;
		}
		else if (pokeA.getTipo() == "Volador" && (pokeB.getTipo() == "Planta" || pokeB.getTipo() == "Lucha")) {
			efectividad = 2.0;
		}
		
		//Pokemons de tipo normal
		else if (pokeA.getTipo() == "Normal" && (pokeB.getTipo() == "Normal" || pokeB.getTipo() == "Lucha" || pokeB.getTipo() == "Volador" || pokeB.getTipo() == "Agua" || pokeB.getTipo() == "Electrico" || pokeB.getTipo() == "Fuego" || pokeB.getTipo() == "Planta") ) {
			efectividad = 1.0;
		}
		
		//Pokemons de tipo Lucha
		else if (pokeA.getTipo() == "Lucha" && pokeB.getTipo() == "Volador") {
			efectividad = 0.5;
		}
		else if (pokeA.getTipo() == "Lucha" && (pokeB.getTipo() == "Agua" || pokeB.getTipo() == "Lucha" || pokeB.getTipo() == "Fuego" || pokeB.getTipo() == "Electrico" || pokeB.getTipo() == "Planta") ) {
			efectividad = 1.0;
		}
		else if (pokeA.getTipo() == "Lucha" && pokeB.getTipo() == "Normal" ) {
			efectividad = 2.0;
		}
		
		//Devolvemos el dato
		return efectividad;	
		
		
	}
	
	//Si el tipo del pokemon coincide con el tipo del ataque la bonificacion será la maxima 1,5, si no será 1
	public static Double bonificacionTipoAtaque (Pokemon pokeA, Pokemon pokeB) {
		
		//Variable
		double bonificacion;
		
		//Comparamos el tipo del pokemon y el del ataque que va a utilizar
		if (pokeA.getTipo() == pokeA.getAtaquePokemon().getTipoAtaque()) {//Si son del mismo tipo el pokemon y el ataque es un 150%
			
			bonificacion = 1.5;
			
			
		} else {//Si no se queda igual
			
			bonificacion = 1;
			
		}
		
		return bonificacion;
	}
	
	
	//Mostrar las opciones del menu
	public static void opcionesMenu () {
		
		System.out.println("\n 1. Encontrar pokemon nuevo \n 2. Entrenar \n 3. Combatir \n 4. Ver pokedex \n 5. Luchar Avanzado \n 6. Salir \n");

	}
	

	public static void main(String[] args) {
		
		// Variables
		
		int opcionMenu;
		boolean controlaMenu=false, controlaSubMenu=false;
		char opcionSubMenu;
		
		//Objetos
		ArrayList <Pokemon> pokemon = new ArrayList <Pokemon>();
		ArrayList <Ataques> ataques = new ArrayList <Ataques>();
		
		Scanner teclado = new Scanner(System.in);
		
		while (controlaMenu == false ) {
			
			opcionesMenu();//Mostramos el menu
			
			System.out.print("Opcion: ");
			opcionMenu = teclado.nextInt();
			switch (opcionMenu) {//Opcion del menu
			
			//Encontrar pokemon
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
			
			//Entrenar pokemons
			case 2:
			
				 //Ver la lista de pokemon y sus posiciones para elegir cual entrenar
				
				try {
					
					verPokedex(pokemon);
					
					entrenarPokemon(pokemon);
					
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
								verPokedex(pokemon);
								entrenarPokemon(pokemon);
							} catch (Exception ex) {
								System.out.println(ex.getMessage());
							}
							
						}
					}
					
					//Mostramos los resultados despues del aumento de nivel
					System.out.println("Despues del aumento de nivel los stats han quedado asi: ");
					try {
						verPokedex(pokemon);
					} catch (Exception ex) {
						System.out.println(ex.getMessage());
					}
					
					
				} catch (Exception ex) {
					System.out.println(ex.getMessage());
				}
				
				
<<<<<<< HEAD
				break;
			
			//Hacer combatir 2 pokemons
=======
				
				
				break;
			
			//Combatir pokemon
>>>>>>> 542bf3ac4f824f7ba92a8caea48e805bc56fb23c
			case 3:
				
				//Variables
				int posicion1, posicion2;
				Pokemon objeto1 = null, objeto2 = null, objeto3 = null, objeto4= null;
				
				
				//Ver la lista de pokemon y sus posiciones para elegir cuales combatiran
				
				try {
					verPokedex(pokemon);
					
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
							
							//Ver lista de pokemon
							try {
								verPokedex(pokemon);
							} catch (Exception ex) {
								System.out.println(ex.getMessage());
							}
							
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
							
							
							//Comprobamos si los pokemon en esa posicion existe utilizando un metodo (Si no se pone la condicion se ejecuta por error cuando alguno de los pokemon esta mal)
							if ((existo(objeto3, pokemon) == true) && (existo (objeto4, pokemon) == true)) {
								Combatir(pokemon.get(posicion1), pokemon.get(posicion2));
							}
							
						}
					}
					
				} catch (Exception ex) {
					
					System.out.println(ex.getMessage());
					
				}
				
				break;
			
<<<<<<< HEAD
			//Mostrar pokemons que tenemos
=======
			//Ver los pokemons que tenemos
>>>>>>> 542bf3ac4f824f7ba92a8caea48e805bc56fb23c
			case 4:
				
				try {
					verPokedex(pokemon);
				} catch (Exception ex) {
					System.out.println(ex.getMessage());
				}
				
				break;
				
			//Salir del menu
			case 5:
				
				//Variables
				Pokemon objeto5, objeto6;
				double dañoPokemon;
				int variacion;
			
				//Mostramos los pokemons que hay
				verPokedex(pokemon);
				
				//Entradas
				System.out.println("Elegir pokemon que va a luchar: ");
				posicion1 = teclado.nextInt();
				
				System.out.println("Elegir al otro pokemon que va a luchar ");
				posicion2 = teclado.nextInt();
				
				objeto5 = pokemon.get(posicion1);//Asignamos los valores a los objetos
				objeto6 = pokemon.get(posicion2);
				
				//La variacion es un dato de la formula de daño que varia aleatoriamente de 85-100
				variacion = (int)(Math.random() * (100-85) + 85);
				
				//Formula del daño, el total del daño es la vida que perdera el Pokemon rival
				dañoPokemon = (0.01 * bonificacionTipoAtaque (objeto5, objeto6) * efectividad (objeto5, objeto6) * variacion)*( (0.2 * 30 * objeto5.combatir() * objeto5.getAtaquePokemon().getPoderAtaque()) / (25*objeto5.getDefensa()) );

				
				System.out.println("\n" + objeto5.getNombre() + " ha usado " + objeto5.getAtaquePokemon().getNombreAtaque() + " contra " + objeto6.getNombre());
				
				//Mostraremos diferentes mensajes dependiendo de la efectividad que haya tenido el ataque
				
				if (efectividad (objeto5, objeto6) == 2.0) {//Si es super efectivo
					
					System.out.println("El ataque ha sido SUPER EFECTIVO");
					
					if (objeto5.getNombre() == "Eevee") {//Mensaje especial para eevee porque es un ALLAHU AK-EEVEE
						
						System.out.println("El mapa se ha llenado de trocitos de Eevee (FINAL DRAMATICO)");
						
					}
					
					if (objeto6.getVida() - dañoPokemon <= 0) {//Vemos si ha perdido toda la vida o no con el daño del ataque
						
						System.out.println("Has vencido al " + objeto6.getNombre() + " rival");
						
					} else { //Si no ha perdido toda la vida
						
						System.out.println("No has vencido al " + objeto6.getNombre() + " rival");
						
						if (objeto5.getNombre() == "Bulbasaur") {//Como soy su creador yo decido que su ataque se hace en un turno, aunque realmente usa dos
							
							System.out.println("Es normal que no lo haya matado, Rayo Sola necesita dos turnos para cargarse");
						
						}
					}
				}
				
				else if (efectividad (objeto5, objeto6) == 1.0) {//Si es neutro
					
					System.out.println("El ataque ha sido NORMAL");
					
					if (objeto5.getNombre() == "Eevee") {//Mismo mensaje de antes de eevee
						System.out.println("El mapa se ha llenado de trocitos de Eevee (FINAL DRAMATICO)");
					}
					
					if (objeto6.getVida() - dañoPokemon <= 0) {///Comprobacion de vida y daño
						
						System.out.println("Has vencido al " + objeto6.getNombre() + " rival");
						
					} else {//Si no ha perdido toda la vida
			
						System.out.println("No has vencido al " + objeto6.getNombre() + " rival");
						
						if (objeto5.getNombre() == "Bulbasaur") {
							System.out.println("Es normal que no lo haya matado, Rayo Sola necesita dos turnos para cargarse");
						}
					}
				}
				
				else if (efectividad (objeto5, objeto6) == 0.5) {//Poco efectivo
					
					System.out.println("El ataque ha sido POCO EFECTIVO");
					
					if (objeto5.getNombre() == "Eevee") {//Mensaje de eevee
						System.out.println("El mapa se ha llenado de trocitos de Eevee (FINAL DRAMATICO)");
					}
					
					if (objeto6.getVida() - dañoPokemon <= 0) {//Comprobacion de la vida
						
						System.out.println("Has vencido al " + objeto6.getNombre() + " rival");
						
					} else {//Si no ha perdido toda la vida
						
						System.out.println("No has vencido al " + objeto6.getNombre() + " rival");
						
						if (objeto5.getNombre() == "Bulbasaur") {
							System.out.println("Es normal que no lo haya matado, Rayo Solar necesita dos turnos para cargarse");
						}
						
					}
				}
				
				
				break;
				
			//Salir
			case 6:
				
				controlaMenu=true;
				break;
				
			//Opciones por defecto	
			default:
				
				System.out.println("Esa opcion no existe en el menu");
				break;
			}
		}
		
		
		
		
		
	}

}
