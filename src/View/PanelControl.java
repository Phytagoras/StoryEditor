package View;

import Control.MainController;

import javax.swing.*;
import java.awt.event.*;

public class PanelControl {
    private MainController mainController;
    private JPanel mainPanel;
    private JList list1;
    private JList list2;
    private JTextField textFieldFirstPara;
    private JTextField textFieldSecondPara;
    private JTextField textFieldThirdPara;
    private JTextField textFieldFourthPara;
    private JTextArea outcomeField;
    private JTextArea choiceField;
    private JTextArea introductionField;
    private JButton newButtonMainList;
    private JButton deleteButtonMainList;
    private JButton newButtonChoiceList;
    private JButton deleteButtonChoiceList;
    private JButton saveButton;

    public PanelControl() {

        list1.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent mouseEvent) {
                super.mouseClicked(mouseEvent);
                updateList2();
            }
        });
    }

    public void update() {
        list1.setModel(mainController.getListOfEvents());
        updateList2();
    }

    private void updateList2() {
        list2.setModel(mainController.getListOfCoices(1));
    }

    public void setMainController(MainController mainController) {
        this.mainController = mainController;
    }

    public JPanel getMainPanel() {
        return mainPanel;
    }
}

