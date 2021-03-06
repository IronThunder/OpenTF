package com.k2sw.opentf.effects;

import com.k2sw.opentf.*;

import java.util.*;

public class PlaceSpecialTileNotNextToTileEffect extends Effect {
    @Override
    public GameState[] apply(GameStateBuilder state, PlayerID currentPlayer) {
        Set<TileSlot> unplaced = new HashSet<>(state.getTileSlotsByType(TileSlotType.Desert));
        Set<TileSlot> available = new HashSet<>();
        for (TileSlot slot : unplaced) {
            boolean shouldAdd = true;
            for (TileSlot neighbor : slot.getNeighbors()) {
                if (state.getPlacedTiles().containsKey(neighbor)) shouldAdd = false;
            }
            if (shouldAdd) available.add(slot);
        }
        TileSlot[] availableSlots = new TileSlot[available.size()];
        available.toArray(availableSlots);
        GameState initialState = state.build();
        GameState[] results = EffectHelpers.permuteTiles(initialState, currentPlayer, availableSlots, TileType.Special);
        if (results.length == 0) return new GameState[]{state.build()};
        else return results;
    }

    @Override
    public String getText() {
        return "Place a unique tile not next to any other tile.";
    }
}
