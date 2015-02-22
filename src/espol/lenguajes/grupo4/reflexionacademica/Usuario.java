package espol.lenguajes.grupo4.reflexionacademica;

public class Usuario {
	private String username;
	private String nombre;
	private String apellido;
	private String idcedula;
	
	public Usuario(String username, String nombre, String apellido, String idCedula)
	{
		this.username=username;
		this.nombre=nombre;
		this.apellido=apellido;
		this.idcedula=idCedula;
	}
	
	public String getUsername() {
		return username;
	}
	
	public String getNombre() {
		return nombre;
	}
	
	public String getApellido() {
		return apellido;
	}
	
	public String getIdCedula() {
		return idcedula;
	}
	
	@Override
	public String toString() {
		String toInfo = "";
		toInfo += "Nombre: "+this.nombre+" "+this.apellido;
		return toInfo;
	}
}
