package edu.matc.trickortreat;

import org.apache.log4j.Logger;

/**
 * Created by student on 4/2/17.
 */
public class Riley implements Runnable{
    private final Logger logger = Logger.getLogger(this.getClass());

    RileysHouse home;

    public Riley(RileysHouse home){
        this.home = home;
    }
    public void run(){
        try {
                Thread.sleep(10000);
            }
            catch(InterruptedException iex){
                iex.printStackTrace();
            }
            logger.info("Riley is ready for the trick or treaters");
            while(true){
                home.giveCandy();
        }
    }
}
