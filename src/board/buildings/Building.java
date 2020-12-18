package board.buildings;

public abstract class Building {
    private int constructionCost;
    private int buildingIncome;
    private int constructionDay;

    public Building(int constructionCost, int buildingIncome, int constructionDay) {
        this.constructionCost = constructionCost;
        this.buildingIncome = buildingIncome;
        this.constructionDay = constructionDay;
    }

    public int getConstructionCost() {
        return constructionCost;
    }

    public int getBuildingIncome() {
        return buildingIncome;
    }

    public boolean chceckBuildingBuilt(int amountGold, int[] numberBuilding) {
        if(checkRequiredMoney(amountGold)) {
            if(chceckAdditionalRequirements()) {
                if(!checkRequiredBuildings(numberBuilding)) {
                    return false;
                }
            }
            updateNumberBuildings(numberBuilding);
            return true;
        }
        return false;
    }

    protected boolean checkRequiredMoney(int amountGold) {
        return amountGold >= constructionCost? true : false;
    }

    protected boolean chceckAdditionalRequirements() {
        return false;
    }

    protected boolean checkRequiredBuildings(int[] numberBuilding) {
        return true;
    }

    protected abstract void updateNumberBuildings(int[] numberBuilding);

    public abstract void deleteBuilding(int[] numberBuilding);

    public int getConstructionDay() {
        return constructionDay;
    }
}
