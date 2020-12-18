package board.buildings;

public class GoldMine extends Building {
    public static final String NAME = "Gruba Złotŏ";
    public static final int CONSTRUCTION_COST = 5000;
    public static final int BUILDING_INCOME = 100;

    public GoldMine(int constructionDay) {
        super(CONSTRUCTION_COST, BUILDING_INCOME, constructionDay);
    }

    @Override
    protected void updateNumberBuildings(int[] numberBuilding) {
        numberBuilding[0] += 1;
    }

    @Override
    protected boolean chceckAdditionalRequirements() {
        return true;
    }

    @Override
    protected boolean checkRequiredBuildings(int[] numberBuilding) {
        if(numberBuilding[3] != 0 && numberBuilding[0] < numberBuilding[3]) {
            return true;
        }
        return false;
    }

    @Override
    public void deleteBuilding(int[] numberBuilding) {
        if(numberBuilding[0] > 0) {
            numberBuilding[0] -= 1;
        }
    }
}
