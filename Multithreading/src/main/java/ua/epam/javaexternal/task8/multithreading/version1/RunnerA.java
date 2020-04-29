package ua.epam.javaexternal.task8.multithreading.version1;

public class RunnerA
{
    public static void main(String[] args)
    {
        PortA port = new PortA(4);

        ShipA ship1 = new ShipA(50, "ship1", port);
        ship1.setOperations("load", 50);
        port.registerShipInPort(ship1);

        ShipA ship2 = new ShipA(18, "ship2", port);
        ship2.setOperations("complex", 10, 10);
        port.registerShipInPort(ship2);

        ShipA ship3 = new ShipA(40, "ship3", port);
        ship3.setNumOfContainersOnShip(40);
        ship3.setOperations("unload", 40);
        port.registerShipInPort(ship3);

        ShipA ship4 = new ShipA(20, "ship4", port);
        ship4.setOperations("complex", 20, 15);
        port.registerShipInPort(ship4);

        ShipA ship5 = new ShipA(60, "ship5", port);
        ship5.setNumOfContainersOnShip(50);
        ship5.setOperations("unload", 40);
        port.registerShipInPort(ship5);

        ShipA ship6 = new ShipA(10, "ship6", port);
        ship6.setOperations("load", 10);
        port.registerShipInPort(ship6);

        ShipA ship7 = new ShipA(50, "ship7", port);
        ship7.setOperations("complex", 50, 40);
        port.registerShipInPort(ship7);

        port.processShipsQueue();
    }
}
