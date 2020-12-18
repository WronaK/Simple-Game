package board.buildings;

public class Sawmill extends Building {
    public static final String NAME = "Tartak";
    public static final int CONSTRUCTION_COST = 3000;
    public static final int BUILDING_INCOME = 500;

    public Sawmill(int constructionDay) {
        super(CONSTRUCTION_COST, BUILDING_INCOME, constructionDay);
    }

    @Override
    protected void updateNumberBuildings(int[] numberBuilding) {
        numberBuilding[3] += 1;
    }

    @Override
    protected boolean chceckAdditionalRequirements() {
        return true;
    }

    @Override
    protected boolean checkRequiredBuildings(int[] numberBuilding) {
        if(numberBuilding[1] != 0 && numberBuilding[3] < numberBuilding[1]) {
            return true;
        }
        return false;
    }

    @Override
    public void deleteBuilding(int[] numberBuilding) {
        if(numberBuilding[3] > 0) {
            numberBuilding[3] -= 1;
        }
    }
}
