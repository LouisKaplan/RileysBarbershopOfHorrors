package edu.matc.trickortreat;

import java.util.LinkedList;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.apache.log4j.Logger;

/**
 * Created by student on 4/2/17.
 */
public class RileysHouse {
    private final Logger logger = Logger.getLogger(this.getClass());

    int maxLine;
    List<Monster> kids;

    public RileysHouse(){
        maxLine = 10;
        kids = new LinkedList<Monster>();
    }

    public void giveCandy() {
        Monster monster;
        logger.info("Riley greets a new monster");
        synchronized (kids) {
            while (kids.size() == 0) {
                logger.info("Riley is back inside, watching Charlie Brown");
                try {
                    kids.wait();
                } catch (InterruptedException iex) {
                    iex.printStackTrace();
                }
            }
            logger.info("Riley is giving candy to a little monster");
            monster = (Monster) ((LinkedList<?>) kids).poll();
        }
        long duration = 0;
        try {
            logger.info("Gave candy to monster : " + monster.getName());
            duration = (long) 3;
            TimeUnit.SECONDS.sleep(duration);
        } catch (InterruptedException iex) {
            iex.printStackTrace();
        }
        logger.info("Gave candy to " + monster.getName());
    }

    public void add (Monster monster){
        logger.info("Monster: " + monster.getName()+ " is in line at Riley's house");

        synchronized (kids){
            if(kids.size() == maxLine){
                logger.info("The line is too long for Monster " + monster.getName());
                return;
            }
            ((LinkedList<Monster>)kids).offer(monster);
            logger.info("Monster " + monster.getName() + " rang the doorbell");

            if(kids.size()==1){
                kids.notify();
            }
        }
    }
}
