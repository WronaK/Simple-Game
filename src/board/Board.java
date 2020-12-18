package board;

import board.buildings.Building;
import state_game.Carataker;
import state_game.Orginator;

public class Board {
    private int INITIAL_AMOUNT_OF_GOLD = 2000;
    private int[] numberBuildings = {0, 0, 0, 0, 0};
    private int amountGold = INITIAL_AMOUNT_OF_GOLD;
    private int dailyIncome = 0;
    private int day = 1;
    private int numberAllBuildings = 0;
    private Orginator orginator = new Orginator();
    private Carataker carataker = new Carataker();

    public void addBuilding(Building building) {
        if(building.chceckBuildingBuilt(amountGold, numberBuildings)) {
            numberAllBuildings += 1;
            orginator.setState(building);
            carataker.add(orginator.saveStateToMomento());
            amountGold -= building.getConstructionCost();
            dailyIncome += building.getBuildingIncome();
        }
    }

    public void undoMove() {
        orginator.getStateFromMomento(carataker.get(numberAllBuildings-1));
        Building building = orginator.getState();
        if (building != null) {
            amountGold += building.getConstructionCost();
            amountGold -= (day - building.getConstructionDay()) * building.getBuildingIncome();
            dailyIncome -= building.getBuildingIncome();
            building.deleteBuilding(numberBuildings);
            numberAllBuildings -= 1;
        }
    }

    public int getAmountGold() {
        return amountGold;
    }

    public int getDay() {
        return day;
    }

    public void updateDay() {
        this.day += 1;
    }

    public void updateIncome() {
        amountGold += dailyIncome;
    }

    public int[] getNumberBuildings() {
        return numberBuildings;
    }
}
