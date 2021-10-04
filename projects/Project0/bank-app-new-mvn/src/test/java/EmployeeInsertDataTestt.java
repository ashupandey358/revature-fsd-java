import static org.junit.jupiter.api.Assertions.*;

import java.sql.SQLException;

import org.junit.jupiter.api.Test;

import com.revature.bankapp.dao.impl.EmployeeDaoImpl;
import com.revature.banknew.model.EmployeeModel;

class EmployeeInsertDataTestt {

	@Test
	void test() {
		EmployeeDaoImpl emp = new EmployeeDaoImpl();
		try {
			emp.employeeData(new EmployeeModel(1384,"ram66776","ramsingh123@gmail.com", "ram@2001"," Cashier"));
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 
		
	}

}
