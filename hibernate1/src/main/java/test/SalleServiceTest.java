package test;

import entities.Salle;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import service.SalleService;

import java.util.List;

import static org.junit.Assert.*;

public class SalleServiceTest {

    private SalleService salleService;
    private Salle salle;

    @Before
    public void setUp() {
        salleService = new SalleService();
        salle = new Salle("A307");

        // Créer et persister la salle avant chaque test
        salleService.create(salle);
    }

    @After
    public void tearDown() {
        // Supprimer la salle après chaque test si elle existe
        Salle foundSalle = salleService.findById(salle.getId());
        if (foundSalle != null) {
            salleService.delete(foundSalle);
        }
    }

    @Test
    public void testCreate() {
        assertNotNull("La salle devrait avoir un ID après création", salle.getId());
    }

    @Test
    public void testFindById() {
        Salle foundSalle = salleService.findById(salle.getId());
        assertNotNull("La salle devrait être trouvée", foundSalle);
        assertEquals("Le code de la salle trouvée devrait correspondre",
                salle.getCode(), foundSalle.getCode());
    }

    @Test
    public void testUpdate() {
        salle.setCode("B202");
        boolean result = salleService.update(salle);
        assertTrue("La mise à jour devrait réussir", result);

        Salle updatedSalle = salleService.findById(salle.getId());
        assertEquals("Le code mis à jour devrait correspondre", "B202", updatedSalle.getCode());
    }

    @Test
    public void testDelete() {
        boolean result = salleService.delete(salle);
        assertTrue("La suppression devrait réussir", result);

        Salle foundSalle = salleService.findById(salle.getId());
        assertNull("La salle ne devrait plus être trouvée après suppression", foundSalle);
    }

    @Test
    public void testFindAll() {
        List<Salle> salles = salleService.findAll();
        assertNotNull("La liste des salles ne devrait pas être null", salles);
        assertTrue("La liste devrait contenir au moins une salle", salles.size() > 0);
    }
}