package registerclient.dao.jdbc;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import registerclient.dao.ClientDAO;
import registerclient.dao.DAOException;
import registerclient.model.Client;

public class JdbcClientDAO implements ClientDAO {
	
	private Connection connection;
	
	public JdbcClientDAO(Connection connection) {
		this.connection = connection;
	}
	
	@Override
	public void save(Client client) {
		StringBuilder sql = new StringBuilder();
		sql.append("INSERT INTO client (");
		sql.append("name,");
		sql.append("birthday,");
		sql.append("deathDate,");
		sql.append("gender,");
		sql.append("isAlive,");
		sql.append("idaddress");
		sql.append(") VALUES (?,?,?,?,?,?)");
		try (PreparedStatement ps = this.connection.prepareStatement(
				sql.toString(), Statement.RETURN_GENERATED_KEYS)) {
			ps.setString(1, client.getName());
			ps.setDate(2, client.getBirthday() == null ? null
					: Date.valueOf(client.getBirthday()));
			ps.setDate(3, client.getDeathDate() == null ? null
					: Date.valueOf(client.getDeathDate()));
			ps.setString(4, String.valueOf(client.getGender()));
			ps.setBoolean(5, client.isAlive());
			ps.setLong(6, client.getAddress().getId());
			ps.executeUpdate();
			ResultSet resultSet = ps.getGeneratedKeys();
			if (resultSet.next()) {
				client.setId(resultSet.getLong(1));
			}
		} catch (SQLException ex) {
			throw new DAOException("Error saving client", ex);
		}
	}
	
	@Override
	public Client searchById(Long id) {
		String sql = String.format("SELECT * FROM client WHERE id = %d", id);
		Client client = null;
		try (PreparedStatement ps = this.connection.prepareStatement(sql)) {
			ResultSet resultSet = ps.executeQuery();
			while (resultSet.next()) {
				client = new Client();
				client.setId(resultSet.getLong(1));
				client.setName(resultSet.getString(2));
				client.setBirthday(resultSet.getDate(3) != null
						? resultSet.getDate(3).toLocalDate()
						: null);
				client.setDeathDate(resultSet.getDate(4) != null
						? resultSet.getDate(4).toLocalDate()
						: null);
				client.setGender(resultSet.getString(5).charAt(0));
				client.setAlive(resultSet.getBoolean(6));
			}
		} catch (SQLException ex) {
			throw new DAOException("Error searching client", ex);
		}
		return client;
	}
	
	@Override
	public List<Client> searchAll() {
		List<Client> list = new ArrayList<>();
		String sql = "SELECT * FROM client";
		try (PreparedStatement ps = this.connection.prepareStatement(sql)) {
			ResultSet resultSet = ps.executeQuery();
			while (resultSet.next()) {
				Client client = new Client();
				client.setId(resultSet.getLong("id"));
				client.setName(resultSet.getString("name"));
				client.setBirthday(resultSet.getDate("birthday") != null
						? resultSet.getDate("birthday").toLocalDate()
						: null);
				client.setDeathDate(resultSet.getDate("deathDate") != null
						? resultSet.getDate("deathDate").toLocalDate()
						: null);
				client.setGender(resultSet.getString("gender").charAt(0));
				client.setAlive(resultSet.getBoolean("isALive"));
				list.add(client);
			}
		} catch (SQLException ex) {
			throw new DAOException("Error searching clients", ex);
		}
		return list;
	}
	
	@Override
	public void saveAll(List<Client> list) {
		StringBuilder sql = new StringBuilder();
		sql.append("INSERT INTO client (");
		sql.append("name,");
		sql.append("birthday,");
		sql.append("deathDate,");
		sql.append("gender,");
		sql.append("isAlive");
		sql.append(") VALUES (?,?,?,?,?)");
		try (PreparedStatement ps = this.connection.prepareStatement(
				sql.toString(), Statement.RETURN_GENERATED_KEYS)) {
			for (Client client : list) {
				ps.setString(1, client.getName());
				ps.setDate(2, client.getBirthday() == null ? null
						: Date.valueOf(client.getBirthday()));
				ps.setDate(3, client.getDeathDate() == null ? null
						: Date.valueOf(client.getDeathDate()));
				ps.setString(4, String.valueOf(client.getGender()));
				ps.setBoolean(5, client.isAlive());
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
			throw new DAOException("Error saving list of clients", ex);
		}
	}
	
}
