import static org.junit.jupiter.api.Assertions.*;

import java.sql.SQLException;

import org.junit.jupiter.api.Test;

import com.revature.bankapp.dao.impl.TransctionDaoImpl;
import com.revature.banknew.model.TransctionModel;

class TransctionInsertData {

	@Test
	void test() {
		TransctionDaoImpl dao = new TransctionDaoImpl();
		try {
			dao.transctionCreate(new TransctionModel("D",40,"503"));
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
