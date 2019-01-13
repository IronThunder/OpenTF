package com.k2sw.opentf.effects;

import com.k2sw.opentf.*;

public class IncreaseTemperatureEffect implements Effect {
    @Override
    public GameState[] apply(GameStateBuilder state, PlayerID currentPlayer) {
        if (state.getTemperature() < Global.MAX_TEMPERATURE) {
            state.withTemperature(state.getTemperature() + 1);
            state.getPlayerByID(currentPlayer).increaseTerraformingScore(1);
        }
        return new GameState[]{state.build()};
    }
}
