package ua.epam.javaexternal.task8.multithreading.version1;

import java.util.LinkedList;
import java.util.Queue;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;

public class PortA
{
    private int numOfPiers;

    BlockingQueue<PierA> availablePiers;
    LinkedList<PierA> usedPiers;
    Queue<ShipA> shipsInPort;

    public PortA(int numOfPiers)
    {
        this.numOfPiers = numOfPiers;
        availablePiers = new ArrayBlockingQueue<>(numOfPiers);
        usedPiers = new LinkedList<>();
        shipsInPort = new LinkedList<>();

        for (int i = 0; i < numOfPiers; i++)
        {
            try
            {
                availablePiers.put(new PierA());
            }
            catch (InterruptedException e)
            {
                e.printStackTrace();
            }
        }
    }

    public void processShipsQueue()
    {
        while (!shipsInPort.isEmpty())
        {
            ShipA processingShip = shipsInPort.peek();
            PierA pier = getFreePier();
            processingShip.setPier(pier);
            new Thread(processingShip).start();
            freePier(pier);
            shipsInPort.remove();
        }
    }

    public void registerShipInPort(ShipA ship)
    {
        shipsInPort.add(ship);
    }

    public synchronized PierA getFreePier()
    {
        PierA freePier = availablePiers.peek();
        usedPiers.add(freePier);

        try
        {
            availablePiers.take();
        }
        catch (InterruptedException e)
        {
            e.printStackTrace();
        }

        return freePier;
    }

    public synchronized void freePier(PierA pier)
    {
        try
        {
            usedPiers.remove(pier);
            availablePiers.put(pier);
        }
        catch (InterruptedException e)
        {
            e.printStackTrace();
        }
    }
}
