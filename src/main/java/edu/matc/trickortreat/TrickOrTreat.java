package edu.matc.trickortreat;
import org.apache.log4j.BasicConfigurator;
import org.apache.log4j.Logger;

/**
 * Created by student on 4/2/17.
 */
public class TrickOrTreat {
    public static void main(String args[]){

        BasicConfigurator.configure();

        RileysHouse home = new RileysHouse();

        Riley riley = new Riley(home);

        MonsterMaker monsterMaker = new MonsterMaker(home);

        Thread thRiley = new Thread(riley);
        Thread thMonsterMaker = new Thread(monsterMaker);
        thRiley.start();
        thMonsterMaker.start();
    }
}
