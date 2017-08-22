package labmock;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ServicoDB implements IServicoDB{
	
	private Connection conn;

	@Override
	public void getDBConnection() throws SQLException, ClassNotFoundException {
		Class.forName("com.sql.jdbc.Driver");
		conn = DriverManager.getConnection("jdbc:mysql://localhost:8066/busca","admin","senha");
	}

	@Override
	public int persisteProcesso(IProcesso proc) throws SQLException {
		String statement = "INSERT INTO Processos (ProcessoName, Email)"+
							" VALUES('"+proc+"' , '"+proc.getEmail()+" ');";
		return conn.createStatement().executeUpdate(statement);
	}
	
}
