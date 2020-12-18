package controller;

import board.Board;
import board.buildings.*;
import view.GameWindow;

import javax.swing.*;
import java.awt.event.*;

public class Game {
    private int TIME_INTERVAL = 45;
    private int ONE_SECOND = 1000;

    private Board board;
    private GameWindow gameWindow;

    public void run() {
        this.board = new Board();
        this.gameWindow = new GameWindow(returnBuildingsInformation());
        setBasicInformationInView();
        setTime();
    }

    private void setTime() {
        Thread time = new Thread();
        time.start();
        int numberSeconds = TIME_INTERVAL;
        while (true) {
            try {
                if(numberSeconds==TIME_INTERVAL) {
                    gameWindow.setDay(board.getDay());
                }
                gameWindow.setTime((numberSeconds < 10?"00:0":"00:") + numberSeconds);
                time.sleep(ONE_SECOND);
                numberSeconds-=1;
                if(numberSeconds<0) {
                    board.updateIncome();
                    gameWindow.setAmountGold(board.getAmountGold());
                    board.updateDay();
                    numberSeconds=TIME_INTERVAL;
                }
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    private String[][] returnBuildingsInformation() {
        String[][] informationBuildings = new String[5][3];
        informationBuildings[0] = new String[]{GoldMine.NAME,
                String.valueOf(GoldMine.CONSTRUCTION_COST), String.valueOf(GoldMine.BUILDING_INCOME)};
        informationBuildings[1] = new String[]{Quarry.NAME,
                String.valueOf(Quarry.CONSTRUCTION_COST), String.valueOf(Quarry.BUILDING_INCOME)};
        informationBuildings[2] = new String[]{Mint.NAME,
                String.valueOf(Mint.CONSTRUCTION_COST), String.valueOf(Mint.BUILDING_INCOME)};
        informationBuildings[3] = new String[]{Sawmill.NAME,
                String.valueOf(Sawmill.CONSTRUCTION_COST), String.valueOf(Sawmill.BUILDING_INCOME)};
        informationBuildings[4] = new String[]{WoodcutterHut.NAME,
                String.valueOf(WoodcutterHut.CONSTRUCTION_COST), String.valueOf(WoodcutterHut.BUILDING_INCOME)};

        return informationBuildings;
    }

    private void setBasicInformationInView() {
        this.gameWindow.setAmountGold(board.getAmountGold());
        this.gameWindow.addButtonListener(new ButtonListener());
        this.gameWindow.setNumber(board.getNumberBuildings());
        this.gameWindow.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        gameWindow.setVisible(true);
    }

    class ButtonListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent actionEvent) {
            Object object = actionEvent.getSource();
            if(object == gameWindow.getButton()[1]) {
                Quarry quarry = new Quarry(board.getDay());
                board.addBuilding(quarry);
                gameWindow.setAmountGold(board.getAmountGold());
                gameWindow.setNumber(board.getNumberBuildings());
            } else if(object == gameWindow.getButton()[0]) {
                GoldMine goldMine = new GoldMine(board.getDay());
                board.addBuilding(goldMine);
                gameWindow.setAmountGold(board.getAmountGold());
                gameWindow.setNumber(board.getNumberBuildings());
            } else if(object == gameWindow.getButton()[2]) {
                Mint mint = new Mint(board.getDay());
                board.addBuilding(mint);
                gameWindow.setAmountGold(board.getAmountGold());
                gameWindow.setNumber(board.getNumberBuildings());
            } else if(object == gameWindow.getButton()[3]) {
                Sawmill sawmill = new Sawmill(board.getDay());
                board.addBuilding(sawmill);
                gameWindow.setAmountGold(board.getAmountGold());
                gameWindow.setNumber(board.getNumberBuildings());
            } else if(object == gameWindow.getButton()[4]) {
                WoodcutterHut woodcutterHut = new WoodcutterHut(board.getDay());
                board.addBuilding(woodcutterHut);
                gameWindow.setAmountGold(board.getAmountGold());
                gameWindow.setNumber(board.getNumberBuildings());
            } else if(object == gameWindow.getUndoMove()) {
                board.undoMove();
                gameWindow.setAmountGold(board.getAmountGold());
                gameWindow.setNumber(board.getNumberBuildings());
            }
        }
    }
}
