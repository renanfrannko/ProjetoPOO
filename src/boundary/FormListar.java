package boundary;

import javax.swing.JPanel;
import javax.swing.JScrollPane;

import control.CtrlProduto;

public class FormListar extends JPanel {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private CtrlProduto ctProd;;

	public FormListar() {
		this.setSize(600, 300);

		ctProd = new CtrlProduto();
		this.add(new JScrollPane(ctProd.listar()));

		this.setVisible(true);
	}

	public void listar() {
		this.removeAll();
		this.add(new JScrollPane(ctProd.listar()));
	}

}
