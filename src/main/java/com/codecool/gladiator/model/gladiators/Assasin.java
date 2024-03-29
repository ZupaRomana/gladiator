package com.codecool.gladiator.model.gladiators;

public class Assasin extends Gladiator{

    public Assasin(String name, int baseHp, int baseSp, int baseDex, int level) {
        super(name, baseHp, baseSp, baseDex, level);
    }

    @Override
    protected Multiplier getHpMultiplier() {
        return Multiplier.Low;
    }

    @Override
    protected Multiplier getSpMultiplier() {
        return Multiplier.High;
    }

    @Override
    protected Multiplier getDexMultiplier() {
        return Multiplier.High;
    }
}
