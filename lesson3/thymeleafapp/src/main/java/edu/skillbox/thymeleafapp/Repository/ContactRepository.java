package edu.skillbox.thymeleafapp.Repository;

import java.sql.*;
import java.util.UUID;

import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.PreparedStatementCreator;
import org.springframework.jdbc.object.UpdatableSqlQuery;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.stereotype.Repository;

import edu.skillbox.thymeleafapp.Contact.Contact;
import edu.skillbox.thymeleafapp.Contact.ContactDto.CreateContactDto;
import edu.skillbox.thymeleafapp.Contact.ContactDto.SearchContactDto;
import edu.skillbox.thymeleafapp.Contact.ContactDto.UpdateContactDto;
import lombok.RequiredArgsConstructor;

@Repository
@RequiredArgsConstructor
public class ContactRepository {

	private final JdbcTemplate jdbcTemplate;

	public Iterable<Contact> findAll() {
		String query = "SELECT * FROM thymeleaf.contact";
		return jdbcTemplate.query(query, BeanPropertyRowMapper.newInstance(Contact.class));
	}

	public Contact findByEmail(String email) {
		String query = "SELECT * FROM thymeleaf.contact WHERE email = ?";
		return jdbcTemplate.queryForObject(query, Contact.class, email);
	}

	public Contact findById(String id) {
		String query = "SELECT * FROM thymeleaf.contact WHERE id = UUID(?)";
		// System.out.println(id);
		return jdbcTemplate.queryForObject(query, BeanPropertyRowMapper.newInstance(Contact.class), id);
	}

	public Contact save(CreateContactDto contactDto) {
		String query = "INSERT INTO thymeleaf.contact (first_name, last_name, email, phone) VALUES (?,?,?,?)";

		GeneratedKeyHolder holder = new GeneratedKeyHolder();
		jdbcTemplate.update(new PreparedStatementCreator() {
			@Override
			public PreparedStatement createPreparedStatement(Connection con) throws SQLException {
				PreparedStatement statement = con.prepareStatement(query, Statement.RETURN_GENERATED_KEYS);
				statement.setString(1, contactDto.getFirstName());
				statement.setString(2, contactDto.getLastName());
				statement.setString(3, contactDto.getEmail());
				statement.setString(4, contactDto.getPhone());
				return statement;
			}
		}, holder);
		String primaryKey = holder.getKeys().get("id").toString();
		return jdbcTemplate.queryForObject("SELECT * FROM thymeleaf.contact where id = UUID(?)",
				BeanPropertyRowMapper.newInstance(Contact.class), primaryKey);
	}

	public void update(UpdateContactDto contactDto) {
		String quiry = "UPDATE thymeleaf.contact SET first_name= ?, last_name = ?, email = ?, phone = ? WHERE id = UUID(?)";
		jdbcTemplate.update(quiry,
				new Object[] { contactDto.getFirstName(), contactDto.getLastName(), contactDto.getEmail(),
						contactDto.getPhone(), contactDto.getId() });
	}

	public void delete(String id) {
		String quiry = "DELETE FROM thymeleaf.contact WHERE id = UUID(?)";
		jdbcTemplate.update(quiry, new Object[] { id });
	}

}
