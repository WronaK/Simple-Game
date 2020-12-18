package board.buildings;

public class Quarry extends Building {
    public static final String NAME = "Kamieniołom";
    public static final int CONSTRUCTION_COST = 500;
    public static final int BUILDING_INCOME = 200;

    public Quarry(int constructionDay) {
        super(CONSTRUCTION_COST, BUILDING_INCOME, constructionDay);
    }

    @Override
    protected void updateNumberBuildings(int[] numberBuilding) {
        numberBuilding[1] += 1;
    }

    @Override
    public void deleteBuilding(int[] numberBuilding) {
        if(numberBuilding[1] > 0) {
            numberBuilding[1] -= 1;
        }
    }
}
