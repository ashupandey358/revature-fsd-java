import static org.junit.jupiter.api.Assertions.*;

import java.sql.SQLException;

import org.junit.jupiter.api.Test;

import com.bankapp.Details.NewAccount;
import com.revature.bankapp.daoImpl.UserDaoImpl;

class TestCreateAccount {

	@Test
	void test() {
		UserDaoImpl dao = new UserDaoImpl();
		try {
			dao.createAccount(new NewAccount("9","10","11","40",16));
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			fail("Not yet implemented");
		}
		
	}

}
