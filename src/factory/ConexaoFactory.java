package factory;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import javax.swing.JOptionPane;

public class ConexaoFactory {

	// Não se esqueça de alterar as variáveis USUARIO e SENHA do banco de dados
	
	private static final String USUARIO = "system";  // <<< Nome de usuário mySQL
	private static final String SENHA = "root"; // <<< Senha de usuário mySQL
	private static final String URL = "jdbc:mysql://localhost:3306/produtopoo";
	
//	private static final String URL = "jdbc:oracle:thin:@localhost:1521:xe"; // Conexão oracle
	
	public static Connection conectar() {
		try {
			Class.forName("com.mysql.jdbc.Driver");
//			Class.forName("oracle.jdbc.OracleDriver");  // 	Conexão oracle
		} catch (ClassNotFoundException e1) {
		}
		Connection conexao = null;
		try {
			conexao = DriverManager.getConnection(URL, USUARIO, SENHA);
		} catch (SQLException e) {
			JOptionPane.showMessageDialog(null, "Não foi possível estabelecer uma conexão com o banco de dados", "Erro",
					JOptionPane.ERROR_MESSAGE);
		}
		return conexao;
	}

}
