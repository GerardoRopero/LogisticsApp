package main;

import controlador.ControladorPrincipal;
import vista.VistaPrincipal;

public class Main {
	@SuppressWarnings("unused")
	public static void main(String[] args) {
		ControladorPrincipal cPrincipal = new ControladorPrincipal(new VistaPrincipal());
	}
}

