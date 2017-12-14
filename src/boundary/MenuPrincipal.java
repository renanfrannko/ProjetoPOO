package boundary;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class MenuPrincipal extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel menuLateral;
	private FormAdicionar formAdd;
	private FormEditar formEdit;
	private FormExcluir formExcluir;
	private FormListar formList;
	private String formAtivo;

	private JButton bListar;
	private JButton bAdd;
	private JButton bEdit;
	private JButton bExcluir;

	private void instanciarMenuLateral() {
		menuLateral = new JPanel();
		menuLateral.setSize(200, 300);
		menuLateral.setLayout(new GridLayout(4, 1));
		menuLateral.setVisible(true);

		menuLateral.add(bListar);
		menuLateral.add(bAdd);
		menuLateral.add(bEdit);
		menuLateral.add(bExcluir);

	}

	private void instarciarForms() {
		formAdd = new FormAdicionar();
		formEdit = new FormEditar();
		formExcluir = new FormExcluir();
		formList = new FormListar();

		formAtivo = "List";
	}

	private void instanciarButtons() {
		bListar = new JButton("Listar");
		bListar.setBackground(new Color(119, 136, 153));

		bAdd = new JButton("Add Produtos");
		bEdit = new JButton("Edit Produtos");
		bExcluir = new JButton("Excluir Produtos");

		bListar.setEnabled(false);
	}

	private void defineFrame() {

		this.setTitle("Frannko | Produtos em estoque");
		this.setSize(800, 600);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		this.add(menuLateral, BorderLayout.SOUTH);
		this.add(formList);

		this.setVisible(true);
	}

	private void adicionarListener() {

		bListar.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent arg0) {
				defineButtons("List");
				removeConteudo();
				adicionaConteudo("List");

			}
		});

		bListar.addMouseListener(new MouseAdapter() {

			@Override
			public void mouseEntered(MouseEvent me) {
				// só inserir aqui o código
				bListar.setBackground(new Color(224, 102, 255));
				bListar.setForeground(Color.WHITE);
			}

			public void mouseExited(MouseEvent me) {
				bListar.setBackground(new Color(119, 136, 153));
			}
		});

		bAdd.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent arg0) {
				defineButtons("Add");
				removeConteudo();
				adicionaConteudo("Add");

			}
		});

		bEdit.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent arg0) {
				defineButtons("Edit");
				removeConteudo();
				adicionaConteudo("Edit");

			}
		});

		bExcluir.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent arg0) {
				defineButtons("Excluir");
				removeConteudo();
				adicionaConteudo("Excluir");

			}
		});

	}

	private void removeConteudo() {

		if (formAtivo == "List") {
			this.remove(formList);
			formList.setVisible(false);
		} else if (formAtivo == "Add") {
			this.remove(formAdd);
			formAdd.setVisible(false);
		} else if (formAtivo == "Edit") {
			this.remove(formEdit);
			formEdit.setVisible(false);
		} else if (formAtivo == "Excluir") {
			this.remove(formExcluir);
			formExcluir.setVisible(false);
		}

	}

	private void adicionaConteudo(String bt) {

		formAtivo = bt;

		if (bt == "List") {
			this.add(formList);
			formList.listar();
			formList.setVisible(true);
		} else if (bt == "Add") {
			this.add(formAdd);
			formAdd.setVisible(true);
		} else if (bt == "Edit") {
			this.add(formEdit);
			formEdit.setVisible(true);
		} else if (bt == "Excluir") {
			this.add(formExcluir);
			formExcluir.setVisible(true);
		}

		revalidate();
	}

	private void defineButtons(String bt) {

		switch (bt) {

		case "List":
			bListar.setEnabled(false);
			bAdd.setEnabled(true);
			bEdit.setEnabled(true);
			bExcluir.setEnabled(true);
			break;

		case "Add":
			bListar.setEnabled(true);
			bAdd.setEnabled(false);
			bEdit.setEnabled(true);
			bExcluir.setEnabled(true);
			break;

		case "Edit":
			bListar.setEnabled(true);
			bAdd.setEnabled(true);
			bEdit.setEnabled(false);
			bExcluir.setEnabled(true);
			break;

		case "Excluir":
			bListar.setEnabled(true);
			bAdd.setEnabled(true);
			bEdit.setEnabled(true);
			bExcluir.setEnabled(false);
			break;
		default:
			break;
		}

	}

	public MenuPrincipal() {

		instanciarButtons();
		adicionarListener();
		instanciarMenuLateral();
		instarciarForms();
		defineFrame();

	}

	public static void main(String[] args) {
		new MenuPrincipal();
	}
}
