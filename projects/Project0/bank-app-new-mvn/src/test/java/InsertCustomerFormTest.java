import static org.junit.jupiter.api.Assertions.*;

import java.sql.SQLException;

import org.junit.jupiter.api.Test;

import com.revature.bankapp.dao.impl.CustomerDaoImpl;
import com.revature.banknew.form.CustomerForm;

class InsertCustomerFormTest {

	@Test
	void test() {
		CustomerDaoImpl customer = new CustomerDaoImpl();
		try {
			customer.customerData(new CustomerForm(102,"Rani","Pandey","ranipandey786@gmail.com","rani@1234"));
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			fail("Not yet implemented");
		}
		
	}

}
