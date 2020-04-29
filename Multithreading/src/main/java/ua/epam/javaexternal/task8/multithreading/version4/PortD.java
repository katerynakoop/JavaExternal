package ua.epam.javaexternal.task8.multithreading.version4;

import java.util.LinkedList;
import java.util.Queue;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

public class PortD
{
    private int numOfPiers;
    ReentrantLock lock = new ReentrantLock();
    Condition notEmpty = lock.newCondition();

    Queue<PierD> availablePiers;
    LinkedList<PierD> usedPiers;
    Queue<ShipD> shipsInPort;

    public PortD(int numOfPiers)
    {
        this.numOfPiers = numOfPiers;
        availablePiers = new LinkedList<>();
        usedPiers = new LinkedList<>();
        shipsInPort = new LinkedList<>();

        for (int i = 0; i < numOfPiers; i++)
        {
            availablePiers.add(new PierD());
        }
    }

    public void processShipsQueue()
    {
        while (!shipsInPort.isEmpty())
        {
            ShipD processingShip = shipsInPort.peek();
            PierD pier = getFreePier();
            processingShip.setPier(pier);
            new Thread(processingShip).start();
            shipsInPort.remove();
            freePier(pier);
        }
    }

    public void registerShipInPort(ShipD ship)
    {
        shipsInPort.add(ship);
    }

    public PierD getFreePier()
    {
        lock.lock();
        PierD freePier = availablePiers.peek();
        usedPiers.add(freePier);

        try
        {
            while(availablePiers.size() == 0)
                notEmpty.await();

            availablePiers.poll();
        }
        catch (InterruptedException e)
        {
            e.printStackTrace();
        }
        finally
        {
            lock.unlock();
        }

        return freePier;
    }

    public void freePier(PierD pier)
    {
        lock.lock();
        try
        {
            usedPiers.remove(pier);
            availablePiers.add(pier);
            notEmpty.signal();
        }
        finally
        {
            lock.unlock();
        }
    }
}
