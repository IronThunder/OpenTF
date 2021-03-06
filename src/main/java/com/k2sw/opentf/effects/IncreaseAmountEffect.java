package com.k2sw.opentf.effects;

import com.k2sw.opentf.*;

public class IncreaseAmountEffect extends Effect {
    private ResourceType type;
    private int amount;

    public IncreaseAmountEffect(ResourceType type, int amount) {
        this.type = type;
        this.amount = amount;
    }

    public GameState[] apply(GameStateBuilder state, PlayerID currentPlayer) {
        state.getPlayerByID(currentPlayer).changeAmount(type, amount);

        return new GameState[]{state.build()};
    }

    @Override
    public String getText() {
        return "Gain " + amount + " " + type + " resource(s).";
    }
}
