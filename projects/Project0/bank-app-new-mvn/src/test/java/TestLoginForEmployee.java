import static org.junit.jupiter.api.Assertions.*;

import java.sql.SQLException;

import org.junit.jupiter.api.Test;

import com.revature.bankapp.dao.impl.EmployeeDaoImpl;
import com.revature.banknew.model.EmployeeModel;

class TestLoginForEmployee {

	@Test
	void test() {
		EmployeeDaoImpl dao = new EmployeeDaoImpl();
		try {
			EmployeeModel c = dao.getEmail("ankitasingh123");
					
			System.out.println(c);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

}
