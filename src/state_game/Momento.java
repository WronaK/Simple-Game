package state_game;

import board.buildings.Building;

public class Momento {
    private Building state;

    public Momento(Building state) {
        this.state = state;
    }

    public Building getState() {
        return state;
    }
}
