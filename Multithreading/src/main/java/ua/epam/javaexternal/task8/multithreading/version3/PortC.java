package ua.epam.javaexternal.task8.multithreading.version3;

import java.util.LinkedList;
import java.util.Queue;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.Semaphore;

public class PortC
{
    private int numOfPiers;

    Queue<PierC> availablePiers;
    LinkedList<PierC> usedPiers;
    Queue<ShipC> shipsInPort;
    Semaphore semaphore;


    public PortC(int numOfPiers)
    {
        this.numOfPiers = numOfPiers;
        availablePiers = new ArrayBlockingQueue<>(numOfPiers);
        usedPiers = new LinkedList<>();
        shipsInPort = new LinkedList<>();
        semaphore = new Semaphore(numOfPiers);

        for (int i = 0; i < numOfPiers; i++)
        {
            availablePiers.add(new PierC());
        }
    }

    public void registerShipInPort(ShipC ship)
    {
        shipsInPort.add(ship);
    }

    public Queue<ShipC> getShipsInPort()
    {
        return shipsInPort;
    }

    public synchronized PierC getFreePier()
    {
        PierC freePier = availablePiers.peek();

        try
        {
            semaphore.acquire();
            freePier = availablePiers.peek();
            usedPiers.add(freePier);
            availablePiers.remove();
        }
        catch (InterruptedException e)
        {
            e.printStackTrace();
        }

        return freePier;
    }

    public synchronized void freePier(PierC pier)
    {
        usedPiers.remove(pier);
        availablePiers.add(pier);
        semaphore.release();
    }
}
