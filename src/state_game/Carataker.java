package state_game;

import java.util.ArrayList;
import java.util.List;

public class Carataker {
    private List<Momento> buildings = new ArrayList<>();

    public void add(Momento state) {
        buildings.add(state);
    }

    private void remove(int index) {
        buildings.remove(index);
    }

    public Momento get(int index) {

        if(index < 0) {
            return null;
        }
        Momento momento = buildings.get(index);
        remove(index);
        return momento;
    }
}
