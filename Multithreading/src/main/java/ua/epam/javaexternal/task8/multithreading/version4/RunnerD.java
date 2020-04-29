package ua.epam.javaexternal.task8.multithreading.version4;

public class RunnerD
{
    public static void main(String[] args)
    {
        PortD port = new PortD(2);

        ShipD ship1 = new ShipD(33, "ship1", port);
        ship1.setOperations("load", 33);
        port.registerShipInPort(ship1);

        ShipD ship2 = new ShipD(18, "ship2", port);
        ship2.setOperations("complex", 18, 10);
        port.registerShipInPort(ship2);

        ShipD ship3 = new ShipD(62, "ship3", port);
        ship3.setNumOfContainersOnShip(50);
        ship3.setOperations("unload", 40);
        port.registerShipInPort(ship3);

        ShipD ship4 = new ShipD(20, "ship4", port);
        ship4.setOperations("complex", 20, 15);
        port.registerShipInPort(ship4);

        ShipD ship5 = new ShipD(60, "ship5", port);
        ship5.setOperations("unload", 40);
        port.registerShipInPort(ship5);

        ShipD ship6 = new ShipD(10, "ship6", port);
        ship6.setOperations("load", 20);
        port.registerShipInPort(ship6);

        ShipD ship7 = new ShipD(50, "ship7", port);
        ship7.setOperations("complex", 50, 60);
        port.registerShipInPort(ship7);

        port.processShipsQueue();
    }
}
