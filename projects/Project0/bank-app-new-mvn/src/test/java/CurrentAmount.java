import static org.junit.jupiter.api.Assertions.*;

import java.sql.SQLException;

import org.junit.jupiter.api.Test;

import com.revature.bankapp.dao.impl.TransctionDaoImpl;
import com.revature.banknew.model.AccountModel;

class CurrentAmount {

	@Test
	void test() {
		TransctionDaoImpl dao = new TransctionDaoImpl();
		try {
			AccountModel c = dao.currentAmount("501");
			System.out.println(c);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
