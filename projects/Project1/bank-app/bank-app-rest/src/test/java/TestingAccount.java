import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import com.revature.bankapp.dao.TransctionDao;
import com.revature.bankapp.dao.impl.CustomerDaoImpl;
import com.revature.bankapp.dao.impl.TransctionDaoImpl;
import com.revature.bankapp.exception.AppException;
import com.revature.banknew.model.Account;

class TestingAccount {

	@Test
	void test() {
		TransctionDao dao = new TransctionDaoImpl();
		try {
			int balance = dao.currentAmount("501");
			System.out.println(balance);
		} catch (AppException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
