package registerclient.dao.jdbc;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import registerclient.dao.AddressDAO;
import registerclient.dao.DAOException;
import registerclient.model.Address;

public class JdbcAddressDAO implements AddressDAO {
	
	private Connection connection;
	
	public JdbcAddressDAO(Connection connection) {
		this.connection = connection;
	}
	
	@Override
	public void save(Address address) {
		StringBuilder sql = new StringBuilder();
		sql.append("INSERT INTO address (");
		sql.append("street,");
		sql.append("city,");
		sql.append("estate");
		sql.append(") VALUES (?,?,?)");
		try (PreparedStatement ps = this.connection.prepareStatement(
				sql.toString(), Statement.RETURN_GENERATED_KEYS)) {
			ps.setString(1, address.getStreet());
			ps.setString(2, address.getCity());
			ps.setString(3, address.getEstate());
			ps.executeUpdate();
			ResultSet resultSet = ps.getGeneratedKeys();
			if (resultSet.next()) {
				address.setId(resultSet.getLong(1));
			}
		} catch (SQLException ex) {
			throw new DAOException("Error saving address", ex);
		}
	}
	
}
