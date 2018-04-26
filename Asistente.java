package saludos;

import java.util.HashMap;
import java.util.Map;

public class Asistente {

	private String nombre;
	private Map<String, String> saludosMap;
	public final static String USUARIO = "delucas"; 
	
	public Asistente(String nombre) {
		this.nombre = nombre;
		cargarSaludosMap();
	}
	
	public void cargarSaludosMap() {
		
		saludosMap = new HashMap<>();
		saludosMap.put("HOLA", "¡Hola, " + USUARIO + "!");
		saludosMap.put("BUEN DÍA", "¡Hola, " + USUARIO + "!");
		saludosMap.put("BUENAS TARDES", "¡Hola, " + USUARIO + "!");
		saludosMap.put("HEY", "¡Hola, " + USUARIO + "!");
		saludosMap.put("GRACIAS", "No es nada, " + USUARIO);
	
	}
	
	public String escuchar(String mensaje) {
		
//		mensaje = StringUtils  Crear método que quita acentos
		mensaje = mensaje.toUpperCase();
		
		for (String clave : saludosMap.keySet()) {
			int encontrado = mensaje.indexOf(clave);
			//String[] lineas
			if (encontrado != -1) {
				return saludosMap.get(clave);
			}
			
		}
		
		return "";
	}
	
}
