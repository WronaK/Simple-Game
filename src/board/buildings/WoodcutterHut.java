package board.buildings;

public class WoodcutterHut extends Building {
    public static final String NAME = "Chatka Siōngŏrza";
    public static final int CONSTRUCTION_COST = 1500;
    public static final int BUILDING_INCOME = 300;

    public WoodcutterHut(int constructionDay) {
        super(CONSTRUCTION_COST, BUILDING_INCOME, constructionDay);
    }

    @Override
    protected void updateNumberBuildings(int[] numberBuilding) {
        numberBuilding[4] += 1;
    }

    @Override
    public void deleteBuilding(int[] numberBuilding) {
        if(numberBuilding[4] > 0) {
            numberBuilding[4] -= 1;
        }
    }
}
