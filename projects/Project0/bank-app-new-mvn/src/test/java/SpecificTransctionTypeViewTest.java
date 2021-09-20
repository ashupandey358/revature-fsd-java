import static org.junit.jupiter.api.Assertions.*;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Test;

import com.revature.bankapp.dao.impl.TransctionDaoImpl;
import com.revature.banknew.transction.Transction;

class SpecificTransctionTypeViewTest {

	@Test
	void test() {
		TransctionDaoImpl dao = new TransctionDaoImpl();
		try {
			ArrayList<Transction> s = (ArrayList<Transction>) dao.viewTransctionforSpecificAccount("501");
			s.forEach(System.out::println);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
