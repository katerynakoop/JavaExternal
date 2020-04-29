package ua.epam.javaexternal.task8.multithreading.version1;

import java.util.Map;

public class PierA
{
    private final int pierCapacity = 300;
    private int numOfContainersOnPier = 150;
    private ShipA ship;

    public synchronized void serveTheShip(ShipA processingShip)
    {
        ship = processingShip;

        Map<String, Integer> actions = ship.getActions();
        System.out.println("Serving the ship: " + ship.getName());

        int numOfContainers = 0;

        if(actions.containsKey("load"))
        {
            numOfContainers = actions.get("load");
            if(isPierReadyToGiveContainers(numOfContainers) && ship.canShipGetContainers(numOfContainers))
            {
                System.out.println("Loading the containers on: " + ship.getName());
                putContainersToShip(numOfContainers);
                ship.setNumOfContainersOnShip(ship.getNumOfContainersOnShip() + numOfContainers);
                System.out.println("Containers was successfully loaded on: " + ship.getName());
            }
        }

        if(actions.containsKey("unload"))
        {
            numOfContainers = actions.get("unload");
            if(isPierReadyToGetContainers(numOfContainers) && ship.canShipGiveContainers(numOfContainers))
            {
                System.out.println("Unloading the containers from: " + ship.getName());
                getContainersFromShip(numOfContainers);
                ship.setNumOfContainersOnShip(ship.getNumOfContainersOnShip() - numOfContainers);
                System.out.println("Containers was successfully unloaded from: " + ship.getName());
            }
        }
    }

    public boolean isPierReadyToGetContainers(int numOfContainers)
    {
        if((pierCapacity - numOfContainersOnPier) >= numOfContainers)
        {
            return true;
        }
        else
        {
            System.err.println("Warning: the pier " + this.hashCode() + " can not get this num of containers"
            + " from " + ship.getName());
            return false;
        }
    }

    public boolean isPierReadyToGiveContainers(int numOfContainers)
    {
        if(numOfContainersOnPier > numOfContainers)
        {
            return true;
        }
        else
        {
            System.err.println("Warning: the pier " + this.hashCode() + " does not contain enough containers"
            + " to give to " + ship.getName());
            return false;
        }
    }

    public void getContainersFromShip(int numOfUnloadedContainers)
    {
        numOfContainersOnPier += numOfUnloadedContainers;
    }

    public void putContainersToShip(int numOfLoadedContainers)
    {
        numOfContainersOnPier -= numOfLoadedContainers;
    }
}