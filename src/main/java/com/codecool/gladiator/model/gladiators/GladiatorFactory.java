package com.codecool.gladiator.model.gladiators;

import com.codecool.gladiator.util.RandomUtils;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.util.List;
import java.util.Random;

public class GladiatorFactory {

    private List<String> names;

    public GladiatorFactory(String fileOfNames) {
        try {
            String shortPath = "src/main/resources/Names.txt";
            File file = new File(shortPath);
            names = Files.readAllLines(file.toPath());
        } catch (IOException|NullPointerException e) {
            System.out.println("Names file not found or corrupted!");
            System.exit(1);
        }
    }

    /**
     * Picks a random name from the file given in the constructor
     *
     * @return gladiator name
     */
    private String getRandomName() {
        int randomIndex = RandomUtils.getInstance().getRANDOM().nextInt(names.size());
        return names.get(randomIndex);

    }

    /**
     * Instantiates a new gladiator with random name and type.
     * Creating an Archer, an Assassin, or a Brutal has the same chance,
     * while the chance of creating a Swordsman is the double of the chance of creating an Archer.
     * @return new Gladiator
     */
    public Gladiator generateRandomGladiator() {
        int randomInt = RandomUtils.getInstance().getRANDOM().nextInt(5)+1;
        Random random = RandomUtils.getInstance().getRANDOM();
        String name = this.getRandomName();
        int baseHP = random.nextInt(75)+25;
        int baseSP = random.nextInt(75)+25;
        int baseDEX = random.nextInt(75)+25;
        int baseLvl = random.nextInt(5)+1;

        switch (randomInt){
            case 1: return new Assasin(name,baseHP, baseSP, baseDEX, baseLvl);
            case 2: return new Brutal(name,baseHP, baseSP, baseDEX, baseLvl);
            case 3: return new Archer(name,baseHP, baseSP, baseDEX, baseLvl);
            default: return new Swordsman(name,baseHP, baseSP, baseDEX, baseLvl);
        }
    }
}
