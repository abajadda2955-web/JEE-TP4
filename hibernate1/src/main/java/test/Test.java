package test;

import entities.Machine;
import entities.Salle;
import service.MachineService;
import service.SalleService;

import java.util.Date;
import java.util.List;

public class Test {

    public static void main(String[] args) {
        SalleService salleService = new SalleService();
        MachineService machineService = new MachineService();


        Salle salle1 = new Salle("A1");
        Salle salle2 = new Salle("B2");

        salleService.create(salle1);
        salleService.create(salle2);

        System.out.println("Salles créées avec succès !");


        List<Salle> salles = salleService.findAll();
        if (!salles.isEmpty()) {
            Salle sallePourMachine1 = salles.get(0);
            Salle sallePourMachine2 = salles.get(1);


            Machine machine1 = new Machine("M123", new Date(), sallePourMachine1);
            Machine machine2 = new Machine("M124", new Date(), sallePourMachine2);

            machineService.create(machine1);
            machineService.create(machine2);

            System.out.println("Machines créées avec succès !");
        }


        System.out.println("\n=== Liste des salles et leurs machines ===");
        for(Salle salle : salleService.findAll()) {
            System.out.println("Salle: " + salle.getCode());
            if (salle.getMachines() != null) {
                for(Machine machine : salle.getMachines()) {
                    System.out.println("  Machine: " + machine.getRef());
                }
            }
        }


        System.out.println("\n=== Test de findBetweenDate ===");
        Date d1 = new Date(System.currentTimeMillis() - 30L * 24 * 60 * 60 * 1000); // Il y a 30 jours
        Date d2 = new Date(); // Date actuelle

        List<Machine> machinesEntreDates = machineService.findBetweenDate(d1, d2);
        System.out.println("Machines achetées entre " + d1 + " et " + d2 + ":");
        for(Machine m : machinesEntreDates) {
            System.out.println("  " + m.getRef() + " achetée le " + m.getDateAchat());
        }
    }
}