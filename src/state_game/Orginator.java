package state_game;

import board.buildings.Building;

public class Orginator {
    private Building state;

    public void setState(Building state) {
        this.state = state;
    }

    public Building getState() {
        return state;
    }

    public Momento saveStateToMomento() {
        return new Momento(state);
    }

    public void getStateFromMomento(Momento momento) {
        if(momento != null) {
            state = momento.getState();
        } else {
            state = null;
        }
    }
}
