package ua.epam.javaexternal.task8.multithreading.version2;

public class RunnerB
{
    public static void main(String[] args)
    {
        PortB port = new PortB(3);

        ShipB ship1 = new ShipB(33, "ship1", port);
        ship1.setOperations("load", 33);
        port.registerShipInPort(ship1);

        ShipB ship2 = new ShipB(18, "ship2", port);
        ship2.setOperations("complex", 18, 18);
        port.registerShipInPort(ship2);

        ShipB ship3 = new ShipB(22, "ship3", port);
        ship3.setNumOfContainersOnShip(50);
        ship3.setOperations("unload", 40);
        port.registerShipInPort(ship3);

        ShipB ship4 = new ShipB(20, "ship4", port);
        ship4.setOperations("complex", 20, 15);
        port.registerShipInPort(ship4);

        ShipB ship5 = new ShipB(60, "ship5", port);
        ship5.setNumOfContainersOnShip(60);
        ship5.setOperations("unload", 40);
        port.registerShipInPort(ship5);

        ShipB ship6 = new ShipB(20, "ship6", port);
        ship6.setOperations("load", 20);
        port.registerShipInPort(ship6);

        ShipB ship7 = new ShipB(50, "ship7", port);
        ship7.setOperations("complex", 50, 40);
        port.registerShipInPort(ship7);

        port.processShipsQueue();
    }
}
