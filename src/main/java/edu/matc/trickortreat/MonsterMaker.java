package edu.matc.trickortreat;

import java.util.Date;
import java.util.LinkedList;
import java.util.List;
import java.util.concurrent.TimeUnit;
import org.apache.log4j.Logger;


/**
 * Created by student on 4/2/17.
 */
public class MonsterMaker implements Runnable{
    private final Logger logger = Logger.getLogger(this.getClass());

    RileysHouse home;

    public MonsterMaker(RileysHouse home){
        this.home = home;
    }

    public void run(){
        while(true){
            Monster monster = new Monster(home);
            monster.setInTime(new Date());
            Thread thmonster = new Thread(monster);
            monster.setName("Monster Thread" + thmonster.getId());
            thmonster.start();

            try {
                TimeUnit.SECONDS.sleep((long)(Math.random()*10));
            } catch(InterruptedException iex){
                iex.printStackTrace();
            }
        }
    }
}
