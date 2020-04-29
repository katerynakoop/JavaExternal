package ua.epam.javaexternal.task8.multithreading.version3;

import java.util.Queue;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class RunnerC
{
    public static void main(String[] args)
    {
        int numOfPiers = 3;
        PortC port = new PortC(numOfPiers);
        ExecutorService executorService = Executors.newFixedThreadPool(numOfPiers);

        ShipC ship1 = new ShipC(33, "ship1", port);
        ship1.setOperations("load", 33);
        port.registerShipInPort(ship1);

        ShipC ship2 = new ShipC(18, "ship2", port);
        ship2.setOperations("complex", 10, 8);
        port.registerShipInPort(ship2);

        ShipC ship3 = new ShipC(62, "ship3", port);
        ship3.setNumOfContainersOnShip(50);
        ship3.setOperations("unload", 40);
        port.registerShipInPort(ship3);

        ShipC ship4 = new ShipC(20, "ship4", port);
        ship4.setOperations("complex", 20, 15);
        port.registerShipInPort(ship4);

        ShipC ship5 = new ShipC(60, "ship5", port);
        ship5.setNumOfContainersOnShip(50);
        ship5.setOperations("unload", 40);
        port.registerShipInPort(ship5);

        ShipC ship6 = new ShipC(10, "ship6", port);
        ship6.setOperations("load", 5);
        port.registerShipInPort(ship6);

        ShipC ship7 = new ShipC(50, "ship7", port);
        ship7.setOperations("complex", 50, 50);
        port.registerShipInPort(ship7);


        Queue<ShipC> ships = port.getShipsInPort();

        for(ShipC ship: ships)
        {
            PierC pier = port.getFreePier();
            ship.setPier(pier);
            executorService.submit(ship);
            port.freePier(pier);
        }

        executorService.shutdown();

    }
}
