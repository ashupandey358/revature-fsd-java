import static org.junit.jupiter.api.Assertions.*;

import java.sql.SQLException;

import org.junit.jupiter.api.Test;

import com.bankapp.Details.CustomerUser;
import com.revature.bankapp.dao.UserDao;
import com.revature.bankapp.daoImpl.UserDaoImpl;

class TestingGetDataFromUseridAndPass {

	@Test
	void test() {
		UserDao dao = new UserDaoImpl();
		CustomerUser customerUser = new CustomerUser();
		customerUser.setEmailid("ashu1@gmail.com");
		customerUser.setPassword("@shu1");
		try {
			dao.getCustomerUser(customerUser.getEmailid(), customerUser.getPassword());
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			fail("Not yet implemented");
		}

	}

}
