import static org.junit.jupiter.api.Assertions.*;

import java.sql.SQLException;
import java.util.List;

import org.junit.jupiter.api.Test;

import com.revature.bankapp.dao.impl.CustomerDaoImpl;
import com.revature.banknew.model.AccountModel;
import com.revature.banknew.model.CustomerModel;

class TestCaseForAccountType {

	@Test
	void test() {
		CustomerDaoImpl dao = new CustomerDaoImpl();
		 
		try {
			List<AccountModel> form = dao.specficAccount(101);
			for (int i = 0; i < form.size(); i++) {
				System.out.println((i+1)+ ".  - " + form.get(i));
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
