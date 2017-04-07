package edu.matc.trickortreat;

import org.apache.log4j.Logger;

import java.util.Date;

/**
 * Created by student on 4/2/17.
 */
public class Monster implements Runnable{
    private final Logger logger = Logger.getLogger(this.getClass());

    String name;
    Date inTime;
    RileysHouse home;

    public Monster(RileysHouse home){
        this.home = home;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Date getInTime() {
        return inTime;
    }

    public void setInTime(Date inTime) {
        this.inTime = inTime;
    }

    public void run (){
        goTrickOrTreating();
    }

    private synchronized  void goTrickOrTreating(){
        home.add(this);
    }
}
