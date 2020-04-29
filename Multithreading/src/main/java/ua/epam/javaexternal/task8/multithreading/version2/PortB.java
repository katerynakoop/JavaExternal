package ua.epam.javaexternal.task8.multithreading.version2;

import java.util.LinkedList;
import java.util.Queue;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.Semaphore;

public class PortB
{
    private int numOfPiers;

    Queue<PierB> availablePiers;
    LinkedList<PierB> usedPiers;
    Queue<ShipB> shipsInPort;
    Semaphore semaphore;


    public PortB(int numOfPiers)
    {
        this.numOfPiers = numOfPiers;
        availablePiers = new ArrayBlockingQueue<>(numOfPiers);
        usedPiers = new LinkedList<>();
        shipsInPort = new LinkedList<>();
        semaphore = new Semaphore(numOfPiers);

        for (int i = 0; i < numOfPiers; i++)
        {
            availablePiers.add(new PierB());
        }
    }

    public void processShipsQueue()
    {
        while (!shipsInPort.isEmpty())
        {
            ShipB processingShip = shipsInPort.peek();
            PierB pier = getFreePier();
            processingShip.setPier(pier);
            new Thread(processingShip).start();
            shipsInPort.remove();
            freePier(pier);
        }
    }

    public void registerShipInPort(ShipB ship)
    {
        shipsInPort.add(ship);
    }

    public synchronized PierB getFreePier()
    {
        PierB freePier = availablePiers.peek();

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

    public synchronized void freePier(PierB pier)
    {
        usedPiers.remove(pier);
        availablePiers.add(pier);
        semaphore.release();
    }
}
