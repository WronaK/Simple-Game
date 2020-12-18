package board.buildings;

public class Mint extends Building {
    public static final String NAME = "Mennica";
    public static final int CONSTRUCTION_COST = 10000;
    public static final int BUILDING_INCOME = 3000;

    public Mint(int constructionDay) {
        super(CONSTRUCTION_COST, BUILDING_INCOME, constructionDay);
    }

    @Override
    protected void updateNumberBuildings(int[] numberBuilding) {
        numberBuilding[2] += 1;
    }

    @Override
    protected boolean chceckAdditionalRequirements() {
        return true;
    }

    @Override
    protected boolean checkRequiredBuildings(int[] numberBuilding) {
        if(numberBuilding[4] != 0 && numberBuilding[2] < numberBuilding[4]) {
            return true;
        }
        return false;
    }

    @Override
    public void deleteBuilding(int[] numberBuilding) {
        if(numberBuilding[2] > 0) {
            numberBuilding[2] -= 1;
        }
    }
}
