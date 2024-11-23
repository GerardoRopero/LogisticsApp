package controlador;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import javax.swing.table.DefaultTableModel;
import modelo.dao.NoPerecederoDAO;
import modelo.dao.PerecederoDAO;
import modelo.dto.NoPerecedero;
import modelo.dto.Perecedero;
import vista.VistaListaProducto;

public class ControladorListaProducto implements ActionListener {
	private VistaListaProducto vista;
	private NoPerecederoDAO modeloN;
	private PerecederoDAO modeloP;
	private DefaultTableModel modeloT;
	
	public ControladorListaProducto(VistaListaProducto vista) {
		this.vista = vista;
		this.modeloN = new NoPerecederoDAO();
		this.modeloP = new PerecederoDAO();
		this.vista.btnConsultarProductos.addActionListener(this);
		this.modeloT = (DefaultTableModel) this.vista.tableListaProductos.getModel();
		this.vista.setVisible(true);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getSource().equals(vista.btnConsultarProductos)) {
			ArrayList<Perecedero> listaPerecedero = modeloP.readAll();
			ArrayList<NoPerecedero> listaNoPerecedero = modeloN.readAll();

			int filas = modeloT.getRowCount();
			
			for (int i = 0; i < filas; i++) {
				modeloT.removeRow(0);
			}
			
			for (Perecedero perecedero : listaPerecedero) {
				perecedero.calcularPrecio();
				Object[] fila = {perecedero.getId(), perecedero.getNombre(), perecedero.getPrecioFinal(), perecedero.getTipo()};
				modeloT.addRow(fila);
			}
			
			for (NoPerecedero noPerecedero : listaNoPerecedero) {
				noPerecedero.calcularPrecio();
				Object[] fila = {noPerecedero.getId(), noPerecedero.getNombre(), noPerecedero.getPrecioFinal(), noPerecedero.getTipo()};
				modeloT.addRow(fila);
			}
		}
	}
}
