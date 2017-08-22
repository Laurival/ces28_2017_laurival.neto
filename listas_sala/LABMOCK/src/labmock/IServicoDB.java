package labmock;

import java.sql.SQLException;

public interface IServicoDB {
	public void getDBConnection() throws SQLException, ClassNotFoundException;
	public int persisteProcesso(IProcesso proc) throws SQLException ;
}
