package fr.diginamic.bank.tests;

import fr.diginamic.bank.entities.*;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.EntityTransaction;
import jakarta.persistence.Persistence;
import org.junit.*;
import org.junit.rules.TestName;
import org.slf4j.Logger;

import java.time.LocalDate;

public class TestBank {
    private static final EntityManagerFactory emf = Persistence.createEntityManagerFactory("bank");
    private static final EntityManager em = emf.createEntityManager();
    private static final Logger logger = org.slf4j.LoggerFactory.getLogger(TestBank.class);
    private static final Logger errorLogger = org.slf4j.LoggerFactory.getLogger("errorLogger");

    @Rule
    public TestName name = new TestName();

    @BeforeClass
    public static void init() {
        System.out.println("<--- Initialisation des tests --->");
        System.out.println();
    }

    @Before
    public void initTest() {
        System.out.println("--- Début test " + name.getMethodName() + " ---");
    }

    @After
    public void endTest() {
        System.out.println("--- Fin test " + name.getMethodName() + " ---");
        System.out.println();
    }

    @AfterClass
    public static void end() {
        try {
            em.close();
            emf.close();
        } catch (Exception e) {
            System.err.println(e.getMessage());
        }
        System.out.println("<--- Fin des tests --->");
    }

    @Test
    public void connection() {Assert.assertNotNull(em);}

    @Test
    public void createBank() {
        Bank bank = new Bank("Société Générale");
        EntityTransaction et = em.getTransaction();
        et.begin();
        em.persist(bank);
        et.commit();
        Bank bank2 = em.find(Bank.class, 1);
        Assert.assertEquals("Société Générale", bank2.getName());
    }

    @Test
    public void getBank() {
        try{
            Bank bank = em.find(Bank.class, 1);
            Assert.assertEquals("Société Générale", bank.getName());
        } catch (Exception e) {
            errorLogger.error(e.getMessage());
        }
    }

    @Test
    public void insertClient() {
        Address address = new Address(1, "rue de la Paix", "75000", "Paris");
        Client client = new Client("Jean", "Dupont", LocalDate.of(1980, 1, 1), address);
        EntityTransaction et = em.getTransaction();
        et.begin();
        em.persist(client);
        et.commit();
    }

    @Test
    public void insertLivretA() {
        LivretA livretA = new LivretA(1, 0, 0.03, em.find(Bank.class, 1));
        Client client = em.find(Client.class, 1);
        client.addAccount(livretA);
        EntityTransaction et = em.getTransaction();
        et.begin();
        em.persist(livretA);
        et.commit();
    }

    @Test
    public void insertAssuranceVie(){
        AssuranceVie assuranceVie = new AssuranceVie(2, 0.75, LocalDate.of(2022, 12, 31), 0.03, em.find(Bank.class, 1));
        Client client = em.find(Client.class, 1);
        client.addAccount(assuranceVie);
        EntityTransaction et = em.getTransaction();
        et.begin();
        em.persist(assuranceVie);
        et.commit();
    }

    @Test
    public void insertOperation(){
        Account account = em.find(Account.class, 1);
        Virement virement = new Virement("Jean", LocalDate.now(), 100, "Virement de Jean");
        account.addOperation(virement);
        EntityTransaction et = em.getTransaction();
        et.begin();
        em.persist(virement);
        et.commit();
    }
}
