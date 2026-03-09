package test;

import entities.Machine;
import entities.Salle;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import service.MachineService;
import service.SalleService;

import java.util.Date;
import java.util.List;

import static org.junit.Assert.*;

public class MachineServiceTest {

    private MachineService machineService;
    private SalleService salleService;
    private Machine machine;
    private Salle salle;

    @Before
    //Initialiser les instances
    public void setUp() {
        machineService = new MachineService();
        salleService = new SalleService();

        // Créer et persister une salle
        salle = new Salle("A307");
        salleService.create(salle);

        // Créer et persister une machine
        machine = new Machine("MACH-001", new Date(), salle);
        machineService.create(machine);
    }

    //supprimer la machine et la salle apres chaque teste
    @After
    public void tearDown() {
        // Supprimer la machine après chaque test
        Machine foundMachine = machineService.findById(machine.getId());
        if (foundMachine != null) {
            machineService.delete(foundMachine);
        }

        // Supprimer la salle après chaque test
        Salle foundSalle = salleService.findById(salle.getId());
        if (foundSalle != null) {
            salleService.delete(foundSalle);
        }
    }

   //verifier la creation
    @Test
    public void testCreate() {
        assertNotNull("La machine devrait avoir un ID après création", machine.getId());
    }

    //Verifier la recuperation par id de la machine 
    @Test
    public void testFindById() {
        Machine foundMachine = machineService.findById(machine.getId());
        assertNotNull("La machine devrait être trouvée", foundMachine);
        assertEquals("La référence de la machine trouvée devrait correspondre",
                machine.getRef(), foundMachine.getRef());
    }

    @Test
    public void testUpdate() {
        machine.setRef("MACH-002");
        boolean result = machineService.update(machine);
        assertTrue("La mise à jour devrait réussir", result);

        Machine updatedMachine = machineService.findById(machine.getId());
        assertEquals("La référence mise à jour devrait correspondre", "MACH-002", updatedMachine.getRef());
    }

    @Test
    public void testDelete() {
        boolean result = machineService.delete(machine);
        assertTrue("La suppression devrait réussir", result);

        Machine foundMachine = machineService.findById(machine.getId());
        assertNull("La machine ne devrait plus être trouvée après suppression", foundMachine);
    }

    @Test
    public void testFindBetweenDate() {
        Date d1 = new Date(System.currentTimeMillis() - 86400000); // Hier
        Date d2 = new Date(); // Aujourd'hui

        List<Machine> machines = machineService.findBetweenDate(d1, d2);
        assertNotNull("La liste des machines ne devrait pas être null", machines);

        // Vérifier si notre machine est dans les résultats
        boolean found = false;
        for (Machine m : machines) {
            if (m.getId() == machine.getId()) {
                found = true;
                break;
            }
        }
        assertTrue("La machine devrait être trouvée dans la période", found);
    }
}