package boundary;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

import control.CtrlProduto;
import dao.ProdutoDAO;
import entity.Produto;

public class FormEditar extends JPanel {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JTextField tfNome;
	private JTextField tfDesc;
	private JTextField tfPreco;
	private Produto produto;
	private JTextField tfID;
	private JButton btnProcurar;
	private JButton btnEditar;

	private void buscar() {

		CtrlProduto prod = new CtrlProduto();

		try {
			produto = prod.buscarPorCodigo(Long.parseLong(tfID.getText()));
			tfNome.setEditable(true);
			tfDesc.setEditable(true);
			tfPreco.setEditable(true);
			btnEditar.setEnabled(true);

			tfNome.setText(produto.getNome());
			tfDesc.setText(produto.getDescricao());
			tfPreco.setText(Double.toString(produto.getPreco()));
		} catch (Exception e) {
			limpar();
			JOptionPane.showMessageDialog(this, "O código digitado não é válido", "Erro", JOptionPane.ERROR_MESSAGE);
		}

	}

	private void editar() {

		ProdutoDAO dao = new ProdutoDAO();

		try {
			produto.setNome(tfNome.getText());
			produto.setDescricao(tfDesc.getText());
			produto.setPreco(Double.parseDouble(tfPreco.getText()));
			dao.editar(produto);
			limpar();

			JOptionPane.showMessageDialog(this, "Produto editado com sucesso!");
		} catch (Exception e) {
			JOptionPane.showMessageDialog(this, "Não foi possível editar o produto!", "Erro",
					JOptionPane.ERROR_MESSAGE);

		}

	}

	private void limpar() {
		tfID.setText("");
		tfNome.setText("");
		tfDesc.setText("");
		tfPreco.setText("");

		tfNome.setEditable(false);
		tfDesc.setEditable(false);
		tfPreco.setEditable(false);
		btnEditar.setEnabled(false);
	}

	public FormEditar() {

		this.setSize(600, 300);
		setLayout(null);

		JLabel lblProduto = new JLabel("Produto:");
		lblProduto.setFont(new Font("Arial", Font.PLAIN, 22));
		lblProduto.setBounds(35, 92, 105, 37);
		add(lblProduto);

		JLabel lblPreo = new JLabel("Pre\u00E7o:");
		lblPreo.setFont(new Font("Tahoma", Font.PLAIN, 22));
		lblPreo.setBounds(35, 178, 82, 37);
		add(lblPreo);

		JLabel lblDescrio = new JLabel("Descri\u00E7\u00E3o:");
		lblDescrio.setFont(new Font("Tahoma", Font.PLAIN, 22));
		lblDescrio.setBounds(35, 130, 124, 46);
		add(lblDescrio);

		tfNome = new JTextField();
		tfNome.setBounds(152, 103, 139, 22);
		add(tfNome);
		tfNome.setColumns(10);
		tfNome.setEditable(false);

		tfDesc = new JTextField();
		tfDesc.setBounds(152, 146, 139, 22);
		add(tfDesc);
		tfDesc.setColumns(10);
		tfDesc.setEditable(false);

		tfPreco = new JTextField();
		tfPreco.setBounds(152, 189, 139, 22);
		add(tfPreco);
		tfPreco.setColumns(10);
		tfPreco.setEditable(false);

		btnEditar = new JButton("Editar Produto");
		btnEditar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				editar();
			}
		});
		btnEditar.setBounds(152, 224, 139, 25);
		add(btnEditar);
		btnEditar.setEnabled(false);

		JLabel lblId = new JLabel("ID:");
		lblId.setFont(new Font("Tahoma", Font.PLAIN, 22));
		lblId.setBounds(35, 54, 82, 25);
		add(lblId);

		tfID = new JTextField();
		tfID.setBounds(152, 59, 29, 22);
		add(tfID);
		tfID.setColumns(10);

		btnProcurar = new JButton("Procurar");
		btnProcurar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				buscar();
			}
		});
		btnProcurar.setBounds(196, 58, 95, 25);
		add(btnProcurar);

		this.setVisible(true);

	}
}
