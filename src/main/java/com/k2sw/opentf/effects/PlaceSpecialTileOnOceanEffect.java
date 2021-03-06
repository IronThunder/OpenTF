package com.k2sw.opentf.effects;

import com.k2sw.opentf.*;

import java.util.*;

public class PlaceSpecialTileOnOceanEffect extends Effect {
    @Override
    public GameState[] apply(GameStateBuilder state, PlayerID currentPlayer) {
        Set<TileSlot> unplaced = new HashSet<>(state.getTileSlotsByType(TileSlotType.Ocean));
        TileSlot[] availableSlots = new TileSlot[unplaced.size()];
        unplaced.toArray(availableSlots);
        GameState initialState = state.build();
        GameState[] results = EffectHelpers.permuteTiles(initialState, currentPlayer, availableSlots, TileType.Special);
        if (results.length == 0) return new GameState[]{state.build()};
        else return results;
    }

    @Override
    public String getText() {
        return "Place a special tile on a spot reserved for an ocean.";
    }
}
