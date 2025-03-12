package controlador;

import modelo.ImplementacionBD;
import modelo.UsuarioDAO;
import vista.VentanaOpciones;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Map;

public class LoginControlador {
	UsuarioDAO dao = new ImplementacionBD();
	
	public void visualizarPantalla() {
		VentanaOpciones ven = new VentanaOpciones(this);
		ven.setVisible(true);	
	}
	


}