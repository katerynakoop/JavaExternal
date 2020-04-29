package ua.epam.javaexternal.task8.multithreading.version1;

import java.util.HashMap;
import java.util.Map;

public class ShipA implements Runnable
{
    private int numOfContainersOnShip = 0;
    private int shipCapacity;
    private String name;
    Map<String, Integer> actions;

    private PortA port;
    private PierA pier;

    public ShipA(int shipCapacity, String name, PortA port)
    {
        this.actions = new HashMap<>();
        this.shipCapacity = shipCapacity;
        this.name = name;
        this.port = port;
    }

    public ShipA()
    {

    }

    @Override
    public void run()
    {
         pier.serveTheShip(this);
    }

    public boolean canShipGetContainers(int numOfContainers)
    {
        if(numOfContainers <= (shipCapacity - numOfContainersOnShip))
        {
            return true;
        }
        else
        {
            System.err.println("Warning: " + name + " trying to load " + numOfContainers + " containers," +
                    " but it can accept only " + (shipCapacity - numOfContainersOnShip) + " containers");
            return false;
        }
    }

    public boolean canShipGiveContainers(int numOfContainers)
    {
        if(numOfContainersOnShip >= numOfContainers)
        {
            return true;
        }
        else
        {
            System.err.println("Warning: " + name + " trying to unload " + numOfContainers + " containers," +
                    " but it contains only " + numOfContainersOnShip + " containers");
            return false;
        }
    }

    public void setOperations(String action, int numOfContainers)
    {
        if(action.equals("load") || action.equals("unload"))
            actions.put(action, numOfContainers);
    }

    public void setOperations(String action, int numOfContToLoad, int numOfContToUnload)
    {
        if(action.equals("complex"))
        {
            actions.put("load", numOfContToLoad);
            actions.put("unload", numOfContToUnload);
        }
    }

    public void setPier(PierA pier)
    {
        this.pier = pier;
    }

    public Map<String, Integer> getActions()
    {
        return actions;
    }

    public String getName()
    {
        return name;
    }

    public int getNumOfContainersOnShip()
    {
        return numOfContainersOnShip;
    }

    public void setNumOfContainersOnShip(int numOfContainersOnShip)
    {
        if((numOfContainersOnShip <= shipCapacity) && numOfContainersOnShip >= 0 )
            this.numOfContainersOnShip = numOfContainersOnShip;
        else
        {
            System.err.println("Warning: num of containers on ship can not be bigger than ship capacity or less than 0");
        }
    }
}
