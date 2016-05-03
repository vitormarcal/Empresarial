
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;


public class PopulaBanco {

	public static void main(String[] args) {

		EntityManagerFactory factory = Persistence.createEntityManagerFactory("EmpresarialPU");
		EntityManager manager = factory.createEntityManager();
		
	}
}
