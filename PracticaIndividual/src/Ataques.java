
public class Ataques {
	
	//Variables
	private String nombreAtaque, tipo;
	private int poderAtaque;
	
	//Constructor
	
	//Los ataques tendran un tipo elemental, un nombre y una fuerza
	public Ataques (String tipo, String nombreAtaque, int poderAtaque) {
		this.tipo = tipo;
		this.nombreAtaque=nombreAtaque;
		this.poderAtaque=poderAtaque;
	}
	public Ataques () {
		this.tipo = "";
		this.nombreAtaque="";
		this.poderAtaque=0;
	}
	
	//Metodos
		
		//Setters y Getters
		public void setTipoAtaque (String tipo) {
			this.tipo=tipo;
		}
		
		public String getTipoAtaque () {
			return this.tipo;
		}
		
		public void setNombreAtaque (String nombreAtaque) {
			this.nombreAtaque=nombreAtaque;
		}
		
		public String getNombreAtaque () {
			return this.nombreAtaque;
		}
		
		public void setPoderAtaque (int poderAtaque) {
			this.poderAtaque=poderAtaque;
		}
		
		public int getPoderAtaque () {
			return this.poderAtaque;
		}
		
}
