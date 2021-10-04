import static org.junit.jupiter.api.Assertions.*;

import java.sql.SQLException;
import java.util.ArrayList;

import org.junit.jupiter.api.Test;

import com.revature.bankapp.dao.impl.EmployeeDaoImpl;
import com.revature.banknew.model.EmployeeModel;

class ListOfemployeeTest {

	@Test
	void test() {
			EmployeeDaoImpl employees = new EmployeeDaoImpl();
			try {
				ArrayList<EmployeeModel> employee =employees.getemployeelist();
				employee.forEach(System.out::println);
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
	}

}
