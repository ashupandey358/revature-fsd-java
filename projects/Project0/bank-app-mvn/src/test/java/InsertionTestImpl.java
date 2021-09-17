import static org.junit.jupiter.api.Assertions.*;

import java.sql.SQLException;

import org.junit.jupiter.api.Test;

import com.bankapp.Details.CustomerUser;
import com.revature.bankapp.daoImpl.UserDaoImpl;

class InsertionTestImpl {

	@Test
	void test() {
		UserDaoImpl udi = new UserDaoImpl();
		try {
			udi.insertUser(new CustomerUser("v","c","p","q"));
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			fail("Not yet implemented");
		}
		
		
		
	}

}
