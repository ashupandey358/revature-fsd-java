
import static org.junit.Assert.assertTrue;
import static org.junit.jupiter.api.Assertions.*;

import java.sql.SQLException;

import org.junit.jupiter.api.Test;

import com.revature.bankapp.dao.impl.CustomerDaoImpl;

import com.revature.banknew.form.CustomerForm;

class TestForLogin {

	@Test
	void test() {
		CustomerDaoImpl cus = new CustomerDaoImpl();
		try {
		CustomerForm c = cus.getEmail("ashupandey358@gmail.com");
		System.out.println(c);
		}
		catch (SQLException e) {
			e.printStackTrace();
			fail("Getting employee failed");
		}
	}

}
