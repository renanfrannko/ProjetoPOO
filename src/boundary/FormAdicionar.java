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
import entity.Produto;

public class FormAdicionar extends JPanel {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JTextField tfNome;
	private JTextField tfDesc;
	private JTextField tfPreco;
	private Produto produto;

	private void limpar() {
		tfNome.setText("");
		tfDesc.setText("");
		tfPreco.setText("");
	}

	private void adicionar() {
		try {
			produto.setNome(tfNome.getText());
			produto.setDescricao(tfDesc.getText());
			produto.setPreco(Double.parseDouble(tfPreco.getText()));

			CtrlProduto p = new CtrlProduto();
			p.setProduto(produto);
			p.adicionar();
			limpar();

			JOptionPane.showMessageDialog(this, "Produto adicionado com sucesso!");

		} catch (Exception e) {
			JOptionPane.showMessageDialog(this, "Não foi possível adicionar o produto!", "Erro",
					JOptionPane.ERROR_MESSAGE);
		}
	}

	public FormAdicionar() {

		produto = new Produto();
		this.setSize(600, 300);
		setLayout(null);

		JLabel lblProduto = new JLabel("Produto:");
		lblProduto.setFont(new Font("Tahoma", Font.PLAIN, 22));
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

		tfDesc = new JTextField();
		tfDesc.setBounds(152, 146, 139, 22);
		add(tfDesc);
		tfDesc.setColumns(10);

		tfPreco = new JTextField();
		tfPreco.setBounds(152, 189, 139, 22);
		add(tfPreco);
		tfPreco.setColumns(10);

		JButton btnAdicionar = new JButton("Adicionar Produto");
		btnAdicionar.setBounds(152, 224, 139, 25);
		add(btnAdicionar);

		btnAdicionar.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent arg0) {

				adicionar();

			}
		});

		this.setVisible(true);
	}
}
