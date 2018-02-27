
public class Ataques {
	
	//Variables
	private String nombreAtaque, tipo;
	private int poderAtaque;
	
	//Constructor
	
	public Ataques (String tipo, String nombre, int fuerza) {
		this.tipo = tipo;
		this.nombreAtaque=nombre;
		this.poderAtaque=fuerza;
	}
	
	//Metodos

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
