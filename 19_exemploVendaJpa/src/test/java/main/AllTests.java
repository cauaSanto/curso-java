package main;

import main.Dao.ClienteDaoTest;
import main.Dao.ProdutoDAOTest;
import main.service.ClienteServiceTest;
import main.service.ProdutoServiceTest;
import org.junit.runner.RunWith;
import org.junit.runners.Suite;

@RunWith(Suite.class)
@Suite.SuiteClasses({ ClienteServiceTest.class, ClienteDaoTest.class,
        ProdutoServiceTest.class, ProdutoDAOTest.class,
        VendaDAOTest.class})
public class AllTests {

}
