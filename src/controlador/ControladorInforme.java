package controlador;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import javax.swing.table.DefaultTableModel;
import modelo.dao.VentaDAO;
import modelo.dto.Venta;
import vista.VistaInforme;

public class ControladorInforme implements ActionListener {
	private VistaInforme vista;
	private VentaDAO modeloV;
	private DefaultTableModel modeloT;
	
	public ControladorInforme(VistaInforme vista) {
		this.vista = vista;
		this.modeloV = new VentaDAO();
		this.vista.btnConsultarInformes.addActionListener(this);
		modeloT = (DefaultTableModel) this.vista.tableInforme.getModel();
		this.vista.setVisible(true);
		
		
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getSource().equals(vista.btnConsultarInformes)) {
			ArrayList<Venta> listaVenta = modeloV.readAll();
			
			int filas = modeloT.getRowCount();
			
			for (int i = 0; i < filas; i++) {
				modeloT.removeRow(0);
			}
			
			for (Venta venta : listaVenta) {
				
				Object[] fila = {venta.getId(), venta.getFecha(), venta.getCliente().getId(), venta.getCliente().getNombre(), 
						venta.getReduccion(), venta.getAumento(), venta.getTotalVenta()};
				 modeloT.addRow(fila);
			}
		}
	}
}
