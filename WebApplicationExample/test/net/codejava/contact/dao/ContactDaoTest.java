package net.codejava.contact.dao;

import static org.junit.jupiter.api.Assertions.*;

import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.jdbc.datasource.DriverManagerDataSource;

import net.codejava.contact.model.Contact;

class ContactDaoTest {
	
	private DriverManagerDataSource dataSource;
	
	private ContactDao dao;
	@BeforeEach
	void setupBeforeEach() {
		dataSource = new DriverManagerDataSource();
		dataSource.setDriverClassName("com.mysql.jdbc.Driver");
		dataSource.setUrl("jdbc:mysql://localhost:3306/contactdb");
		dataSource.setUsername("root");
		dataSource.setPassword("Visa@20");
		
		dao=new ContactDaoImpl(dataSource);
	}

	@Test
	void testSave() {
		
		Contact contact= new Contact("Sudhakar", "sudha@gmail.com", "London", "9876543210");
		int result=dao.save(contact);
		assertTrue(result>0);
	}

	@Test
	void testUpdate() {
		
		Contact contact= new Contact(1,"Sudhakar", "sudhakar@gmail.com", "London", "9876543210");
		int result=dao.update(contact);
		assertTrue(result>0);
		
		
	}

	@Test
	void testGet() {
		Integer id=1;
		Contact contact=dao.get(id);
		if(id!=null) {
			System.out.println(contact);
		}
		assertNotNull(contact);
	}

	@Test
	void testDelete() {
		Integer id=1;
		int result=dao.delete(id);
		assertTrue(result>0);
	}

	@Test
	void testList() {
		List<Contact> list=dao.list();
		for(Contact contact:list) {
			System.out.println(contact);
		}
		assertTrue(!list.isEmpty());
	}

}
