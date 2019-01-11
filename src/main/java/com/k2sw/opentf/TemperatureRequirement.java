package com.k2sw.opentf;

public class TemperatureRequirement implements Requirement {
    private int amount;
    private boolean greater;

    public TemperatureRequirement(int amount, boolean greater) {
        this.amount = amount;
        this.greater = greater;
    }

    public int getAmount() {
        return amount;
    }

    public boolean isGreater() {
        return greater;
    }

    @Override
    public boolean check(GameStateBuilder state, PlayerID currentPlayer) {
        if (greater)
            return state.getTemperature() >= amount;
        else
            return state.getTemperature() <= amount;
    }
}
