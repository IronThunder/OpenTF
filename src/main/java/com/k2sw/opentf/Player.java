package com.k2sw.opentf;

import java.util.HashMap;
import java.util.Map;

public class Player implements PlayerOrBuilder {
    private Map<ResourceType, Integer> production;
    private Map<ResourceType, Integer> amounts;
    private int terraformingScore;
    private PlayerID playerID;
    private CardState[] tableau;

    public Player(Map<ResourceType, Integer> production, Map<ResourceType, Integer> amounts, int terraformingScore, PlayerID playerID, CardState[] tableau) {
        this.production = production;
        this.amounts = amounts;
        this.terraformingScore = terraformingScore;
        this.playerID = playerID;
        this.tableau = tableau;
    }

    @Override
    public Map<ResourceType, Integer> getProduction() {
        return production;
    }

    @Override
    public Map<ResourceType, Integer> getAmounts() {
        return amounts;
    }

    @Override
    public int getTerraformingScore() {
        return terraformingScore;
    }

    @Override
    public PlayerID getPlayerID() {
        return playerID;
    }

    public CardState[] getTableau() {
        return tableau;
    }
}