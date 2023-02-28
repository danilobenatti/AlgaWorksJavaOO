package registerclient.dao.jdbc;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.HashSet;
import java.util.Set;

import registerclient.dao.DAOException;
import registerclient.dao.PhoneDAO;
import registerclient.model.Phone;

public class JdbcPhoneDAO implements PhoneDAO {
	
	private Connection connection;
	
	public JdbcPhoneDAO(Connection connection) {
		this.connection = connection;
	}
	
	@Override
	public void save(Phone phone) {
		StringBuilder sql = new StringBuilder();
		sql.append("INSERT INTO phone (");
		sql.append("type,");
		sql.append("number,");
		sql.append("idclient");
		sql.append(") VALUES (?,?,?)");
		try (PreparedStatement ps = this.connection.prepareStatement(
				sql.toString(), Statement.RETURN_GENERATED_KEYS)) {
			ps.setString(1, Character.toString(phone.getType()));
			ps.setString(2, phone.getNumber());
			ps.setLong(3, phone.getClient().getId());
			ps.executeUpdate();
			ResultSet resultSet = ps.getGeneratedKeys();
			if (resultSet.next()) {
				phone.setId(resultSet.getLong(1));
			}
		} catch (SQLException ex) {
			throw new DAOException("Error saving phone", ex);
		}
	}
	
	@Override
	public void saveAll(Set<Phone> phones) {
		StringBuilder sql = new StringBuilder();
		sql.append("INSERT INTO phone (");
		sql.append("type,");
		sql.append("number,");
		sql.append("idclient");
		sql.append(") VALUES (?,?,?)");
		try (PreparedStatement ps = this.connection.prepareStatement(
				sql.toString(), Statement.RETURN_GENERATED_KEYS)) {
			for (Phone phone : phones) {
				ps.setString(1, String.valueOf(phone.getType()));
				ps.setString(2, phone.getNumber());
				ps.setLong(3, phone.getClient().getId());
				ps.addBatch();
			}
			ps.executeBatch();
			ResultSet resultSet = ps.getGeneratedKeys();
			Set<Long> setIds = new HashSet<>();
			while (resultSet.next()) {
				long id = resultSet.getLong(1);
				setIds.add(id);
			}
		} catch (SQLException ex) {
			throw new DAOException("Error saving list of phones", ex);
		}
	}
	
}
