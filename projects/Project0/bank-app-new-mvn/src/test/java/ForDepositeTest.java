import static org.junit.jupiter.api.Assertions.*;

import java.sql.SQLException;

import org.junit.jupiter.api.Test;

import com.revature.bankapp.dao.impl.TransctionDaoImpl;

class ForDepositeTest {

	@Test
	void test() {
		TransctionDaoImpl  dao = new TransctionDaoImpl();
		try {
			dao.forDeposite(1000, "D");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

}
