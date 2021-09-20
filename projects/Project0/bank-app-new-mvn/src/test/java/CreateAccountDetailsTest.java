import static org.junit.jupiter.api.Assertions.*;

import java.sql.SQLException;

import org.junit.jupiter.api.Test;

import com.revature.bankapp.dao.impl.CustomerDaoImpl;
import com.revature.banknew.model.AccountModel;

class CreateAccountDetailsTest {

	@Test
	void test() {
		CustomerDaoImpl dao = new CustomerDaoImpl();
		try {
			dao.accountModel(new AccountModel("500","199","9325973364",5000,"Saving","N",101));
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
