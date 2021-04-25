package com.codecool.gladiator.model;

import com.codecool.gladiator.model.gladiators.Gladiator;
import com.codecool.gladiator.util.RandomUtils;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/**
 * Combat class, used for simulating fights between pairs of gladiators
 */
public class Combat {

    private final Gladiator gladiator1;
    private final Gladiator gladiator2;

    private final List<String> combatLog;

    public Combat(Contestants contestants) {
        this.gladiator1 = contestants.gladiator1;
        this.gladiator2 = contestants.gladiator2;
        this.combatLog = new ArrayList<>();
    }

    /**
     * Simulates the combat and returns the winner.
     * If one of the opponents is null, the winner is the one that is not null
     * If both of the opponents are null, the return value is null
     *
     * @return winner of combat
     */
    public Gladiator simulate() {
        boolean random = RandomUtils.getInstance().getRANDOM().nextBoolean();
        Gladiator attacker = random ? gladiator1 : gladiator2;
        Gladiator defender = random ? gladiator2 : gladiator1;

    while (!gladiator1.isDead() && !gladiator2.isDead()) {

            int chanceOfHit = Math.abs(attacker.getMaxDex() - defender.getMaxDex());
            if (chanceOfHit < 10)
                chanceOfHit = 10;
            else if (chanceOfHit > 100)
                chanceOfHit = 100;

            int randomInt = RandomUtils.getInstance().getRANDOM().nextInt(100);

            if (randomInt <= chanceOfHit) {
                int damage = calculateDamage(attacker);
                defender.decreaseHp(damage);
                combatLog.add(attacker.getFullName() + " deals: " + damage);
            } else {
                combatLog.add(attacker.getFullName() + " missed");
            }

            if (defender.isDead()) {
                combatLog.add(defender.getFullName() + "has died, " + attacker.getFullName() + " wins!");
            }
            Gladiator temp = attacker;
            attacker = defender;
            defender = temp;
        }
        return gladiator1.isDead() ? gladiator2 : gladiator1;
    }

    public Gladiator getGladiator1() {
        return gladiator1;
    }

    public Gladiator getGladiator2() {
        return gladiator2;
    }

    public String getCombatLog(String separator) {
        return String.join(separator, combatLog);
    }

    public int calculateDamage(Gladiator gladiator) {
        Random random = RandomUtils.getInstance().getRANDOM();
        double randomValue = 0.1 + (0.5 - 0.1) * random.nextDouble();

        int damage = (int) (gladiator.getMaxSp() * randomValue);

        return damage;
    }
}
