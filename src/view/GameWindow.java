package view;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

public class GameWindow extends JFrame{
    private JButton[] button = new JButton[5];
    private JLabel[] number = new JLabel[5];
    private JLabel[][] informationBuildings = new JLabel[5][3];
    private JLabel amountGold = new JLabel();
    private JLabel time = new JLabel();
    private JLabel day = new JLabel();
    private JButton undoMove = new JButton();

    public GameWindow(String[][] informationBuildings) {
        setInformationBuildings(informationBuildings);
        setPreferredSize(new Dimension(1100, 500));
        setResizable(false);
        displayBoards();
    }

    private void displayBoards() {
        setLayout(new GridLayout(1, 2));

        JLabel map = new JLabel();
        try {
            BufferedImage image = ImageIO.read(new File("mapa.jpg"));
            map.setIcon(new ImageIcon(image));
        } catch (IOException e) {
            e.printStackTrace();
        }

        JPanel panel = new JPanel();
        panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));
        JPanel panelBuildings = addPanelBuildings();
        JPanel panelSettings = addPanelSettings();
        panel.add(panelBuildings);
        panel.add(panelSettings);

        add(map);
        add(panel);
        pack();

    }

    private JPanel addPanelBuildings() {
        JPanel panelBuildings = new JPanel();
        panelBuildings.setPreferredSize(new Dimension(500, 500));
        panelBuildings.setLayout(new BoxLayout(panelBuildings, BoxLayout.Y_AXIS));

        for(int i = 0; i < button.length; i++) {
            JPanel panelBuilding = new JPanel();
            this.button[i] = new JButton();
            this.number[i] = new JLabel();
            if (i%2==0) {
                panelBuilding.setBackground(Color.CYAN);
            } else {
                panelBuilding.setBackground(Color.WHITE);
            }
            button[i].setBackground(Color.YELLOW);
            addInfromationBulding(panelBuilding, button[i], number[i], informationBuildings[i]);
            panelBuildings.add(panelBuilding);
        }
        panelBuildings.setVisible(true);
        return panelBuildings;
    }

    private JPanel addPanelSettings() {
        JLabel labelAmountGold = new JLabel();
        labelAmountGold.setText("wielość złotŏ");
        labelAmountGold.setBackground(Color.WHITE);

        JLabel labelTime = new JLabel();
        labelTime.setText("ôstały czas");
        JLabel labelDay = new JLabel();
        labelDay.setText("dziyń");

        JPanel panelSettings = new JPanel();
        panelSettings.setLayout(new GridLayout(2, 3));
        labelAmountGold.setHorizontalAlignment(SwingConstants.CENTER);
        labelTime.setHorizontalAlignment(SwingConstants.CENTER);
        labelDay.setHorizontalAlignment(SwingConstants.CENTER);
        amountGold.setHorizontalAlignment(SwingConstants.CENTER);
        time.setHorizontalAlignment(SwingConstants.CENTER);
        day.setHorizontalAlignment(SwingConstants.CENTER);

        panelSettings.add(labelAmountGold);
        panelSettings.add(labelTime);
        panelSettings.add(labelDay);
        panelSettings.add(amountGold);
        panelSettings.add(time);
        panelSettings.add(day);
        panelSettings.setVisible(true);

        JPanel panel = new JPanel();
        panel.setLayout(new BoxLayout(panel, BoxLayout.X_AXIS));
        panel.add(panelSettings);
        undoMove.setText("Cŏfnij ruch");
        undoMove.setBackground(Color.YELLOW);
        panel.add(undoMove);
        return panel;
    }

    private void addInfromationBulding(JPanel panel, JButton creatBulding, JLabel numberK, JLabel[] informationBuilding) {
        panel.setLayout(new GridLayout(2, 4));
        JLabel labelConstructionCost = new JLabel();
        JLabel labelBuildingIncome = new JLabel();
        labelBuildingIncome.setText("Dochōd");
        labelConstructionCost.setText("Utrŏta Zbudowaniŏ");
        creatBulding.setText("Postŏw Budōnek");
        JLabel numberBuilding = new JLabel();
        numberBuilding.setText("Numer budōnkōw");

        numberBuilding.setHorizontalAlignment(SwingConstants.CENTER);
        labelConstructionCost.setHorizontalAlignment(SwingConstants.CENTER);
        creatBulding.setHorizontalAlignment(SwingConstants.CENTER);
        labelBuildingIncome.setHorizontalAlignment(SwingConstants.CENTER);
        numberK.setHorizontalAlignment(SwingConstants.CENTER);

        panel.add(informationBuilding[0]);
        panel.add(labelConstructionCost);
        panel.add(informationBuilding[1]);
        panel.add(numberBuilding);
        panel.add(creatBulding);
        panel.add(labelBuildingIncome);
        panel.add(informationBuilding[2]);
        panel.add(numberK);

        pack();
    }


    public void addButtonListener(ActionListener actionListener) {
        for(JButton b: button) {
            b.addActionListener(actionListener);
        }
        undoMove.addActionListener(actionListener);
    }

    public void setAmountGold(int amountGold) {
        this.amountGold.setText(String.valueOf(amountGold));
    }

    public void setTime(String time) {
        this.time.setText(time);
    }

    public void setDay(int day) {
        this.day.setText(String.valueOf(day));
    }

    public JButton[] getButton() {
        return button;
    }

    public void setNumber(int[] number) {
        for(int i = 0; i < this.number.length; i++) {
            this.number[i].setText(String.valueOf(number[i]));
        }
    }

    private void setInformationBuildings(String[][] informationBuildings) {
        for(int i = 0; i < this.informationBuildings.length; i++) {
            for(int j = 0; j < this.informationBuildings[i].length; j++) {
                this.informationBuildings[i][j] = new JLabel();
                this.informationBuildings[i][j].setText(informationBuildings[i][j]);
                this.informationBuildings[i][j].setHorizontalAlignment(SwingConstants.CENTER);
            }
        }
    }

    public JButton getUndoMove() {
        return undoMove;
    }
}
