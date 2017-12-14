package control;

import java.awt.Dimension;
import java.util.ArrayList;

import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import dao.ProdutoDAO;
import entity.Produto;

public class CtrlProduto {

	public Produto p;
	public ProdutoDAO pdao = new ProdutoDAO();

	public Produto getProduto() {
		return p;
	}

	public void setProduto(Produto p) {
		this.p = p;
	}

	public void adicionar() {
		pdao.salvar(p);
	}

	public Produto buscarPorCodigo(Long i) {
		ProdutoDAO d = new ProdutoDAO();
		Produto p;

		try {
			p = d.buscarPorCodigo(i);
			return p;
		} catch (Exception e) {
			return null;
		}
	}

	public JTable listar() {

		ProdutoDAO dao = new ProdutoDAO();
		ArrayList<Produto> p = dao.listar();

		DefaultTableModel model = new DefaultTableModel();
		model.addColumn("Id");
		model.addColumn("Produto");
		model.addColumn("Descrição");
		model.addColumn("Preço");
		JTable table = new JTable(model);

		for (int i = 0; i < p.size(); i++) {
			model.addRow(new Object[] { p.get(i).getCodigo(), p.get(i).getNome(), p.get(i).getDescricao(),
					p.get(i).getPreco() });
		}

		return table;

	}

}
