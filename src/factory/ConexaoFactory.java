package factory;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import javax.swing.JOptionPane;

public class ConexaoFactory {

	// N�o se esque�a de alterar as vari�veis USUARIO e SENHA do banco de dados
	
	private static final String USUARIO = "system";  // <<< Nome de usu�rio mySQL
	private static final String SENHA = "root"; // <<< Senha de usu�rio mySQL
	private static final String URL = "jdbc:mysql://localhost:3306/produtopoo";
	
//	private static final String URL = "jdbc:oracle:thin:@localhost:1521:xe"; // Conex�o oracle
	
	public static Connection conectar() {
		try {
			Class.forName("com.mysql.jdbc.Driver");
//			Class.forName("oracle.jdbc.OracleDriver");  // 	Conex�o oracle
		} catch (ClassNotFoundException e1) {
		}
		Connection conexao = null;
		try {
			conexao = DriverManager.getConnection(URL, USUARIO, SENHA);
		} catch (SQLException e) {
			JOptionPane.showMessageDialog(null, "N�o foi poss�vel estabelecer uma conex�o com o banco de dados", "Erro",
					JOptionPane.ERROR_MESSAGE);
		}
		return conexao;
	}

}
