import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;

import org.junit.jupiter.api.Test;

import com.bankapp.Details.NewAccount;
import com.revature.bankapp.daoImpl.UserDaoImpl;

class ViewAccountTest {

	@Test
	void test() {
		UserDaoImpl udi = new UserDaoImpl();
		ArrayList<NewAccount> view=udi.viewAccount(2);
		view.forEach(System.out::println);
		
	}

}
