package com.k2sw.opentf.effects;

import com.k2sw.opentf.*;

public class MartianRailsActionEffect extends Effect {
    @Override
    public GameState[] apply(GameStateBuilder state, PlayerID currentPlayer) {
        int cityCount = 0;
        for (Tile tile : state.getPlacedTiles().values()){
            if (tile.getTileType() == TileType.City || tile.getTileType() == TileType.CapitalCity) cityCount++;
        }
        return new IncreaseAmountEffect(ResourceType.MegaCredits, cityCount).apply(state, currentPlayer);
    }

    @Override
    public String getText() {
        return "Gain 1 credit for each city on Mars.";
    }
}
