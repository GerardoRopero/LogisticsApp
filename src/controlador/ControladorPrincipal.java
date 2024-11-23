package controlador;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import vista.VistaCliente;
import vista.VistaInforme;
import vista.VistaListaPerecedero;
import vista.VistaListaProducto;
import vista.VistaNoPerecedero;
import vista.VistaPerecedero;
import vista.VistaPrincipal;
import vista.VistaVenta;

public class ControladorPrincipal implements ActionListener {
	private VistaPrincipal vista;
	
	public ControladorPrincipal(VistaPrincipal vista) {
		this.vista = vista;
		this.vista.mntmNoPerecedero.addActionListener(this);
		this.vista.mntmCliente.addActionListener(this);
		this.vista.mntmPerecedero.addActionListener(this);
		this.vista.mntmCrearVenta.addActionListener(this);
		this.vista.mntmInformeVentas.addActionListener(this);
		this.vista.mntmListaProductos.addActionListener(this);
		this.vista.mntmProductosPerecederos.addActionListener(this);
		this.vista.mntmSalir.addActionListener(this);
		this.vista.setVisible(true);
	}

	@SuppressWarnings("unused")
	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getSource().equals(vista.mntmPerecedero)) {
			ControladorPerecedero cPerecedero = new ControladorPerecedero(new VistaPerecedero());
		}
		
		if (e.getSource().equals(vista.mntmCliente)) {
			ControladorCliente cCliente = new ControladorCliente(new VistaCliente());
		}
		
		if (e.getSource().equals(vista.mntmNoPerecedero)) {
			ControladorNoPerecedero cNoPerecedero = new ControladorNoPerecedero(new VistaNoPerecedero());
		}
		
		if (e.getSource().equals(vista.mntmCrearVenta)) {
			ControladorVenta cVenta = new ControladorVenta(new VistaVenta());
		}
		
		if (e.getSource().equals(vista.mntmListaProductos)) {
			ControladorListaProducto cListaProducto = new ControladorListaProducto(new VistaListaProducto());
		}
		
		if (e.getSource().equals(vista.mntmProductosPerecederos)) {
			ControladorListaPerecedero cListaPerecedero = new ControladorListaPerecedero(new VistaListaPerecedero());
		}
		
		if (e.getSource().equals(vista.mntmInformeVentas)) {
			ControladorInforme cInforme = new ControladorInforme(new VistaInforme());
		}
		
		if (e.getSource().equals(vista.mntmSalir)) {
			System.exit(0);
		}
	}
}
