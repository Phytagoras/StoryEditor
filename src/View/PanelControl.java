package View;

import Control.MainController;
import Model.Choice;
import Model.Event;

import javax.swing.*;
import java.awt.event.*;

import static java.lang.Integer.valueOf;

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
    private DefaultListModel<String> defaultListModel1 = new DefaultListModel<>(), defaultListModel2 = new DefaultListModel<>();
    private int currentEvent = 0;
    private int currentChoice = 0;

    public PanelControl() {
        textFieldFirstPara.addKeyListener(new KeyAdapter() {
            public void keyTyped(KeyEvent e) {
                char c = e.getKeyChar();
                if (!((c >= '0') && (c <= '9') ||
                        (c == KeyEvent.VK_MINUS) ||
                        (c == KeyEvent.VK_BACK_SPACE) ||
                        (c == KeyEvent.VK_DELETE))) {
                    e.consume();
                }
            }
        });

        textFieldSecondPara.addKeyListener(new KeyAdapter() {
            public void keyTyped(KeyEvent e) {
                char c = e.getKeyChar();
                if (!((c >= '0') && (c <= '9') ||
                        (c == KeyEvent.VK_MINUS) ||
                        (c == KeyEvent.VK_BACK_SPACE) ||
                        (c == KeyEvent.VK_DELETE))) {
                    e.consume();
                }
            }
        });

        textFieldThirdPara.addKeyListener(new KeyAdapter() {
            public void keyTyped(KeyEvent e) {
                char c = e.getKeyChar();
                if (!((c >= '0') && (c <= '9') ||
                        (c == KeyEvent.VK_MINUS) ||
                        (c == KeyEvent.VK_BACK_SPACE) ||
                        (c == KeyEvent.VK_DELETE))) {
                    e.consume();
                }
            }
        });

        textFieldFourthPara.addKeyListener(new KeyAdapter() {
            public void keyTyped(KeyEvent e) {
                char c = e.getKeyChar();
                if (!((c >= '0') && (c <= '9') ||
                        (c == KeyEvent.VK_MINUS) ||
                        (c == KeyEvent.VK_BACK_SPACE) ||
                        (c == KeyEvent.VK_DELETE))) {
                    e.consume();
                }
            }
        });
        list1.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent mouseEvent) {
                super.mouseClicked(mouseEvent);
                int tmp = list1.getSelectedIndex();
                currentEvent = tmp;
                updateList2();
            }
        });
        list2.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent mouseEvent) {
                super.mouseClicked(mouseEvent);
                int tmp = list2.getSelectedIndex();
                currentChoice = tmp;
                updateAllTextFields();
            }
        });
        saveButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                saveAll();
            }
        });
        newButtonMainList.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                mainController.addNewEvent();
                currentEvent = 0;
                update();
            }
        });
        deleteButtonMainList.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (currentEvent < mainController.getEvents().length&& currentEvent > -1) {
                    mainController.deleteEventByIndex(currentEvent);
                    currentEvent = 0;
                    update();
                }
            }
        });
        newButtonChoiceList.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (currentEvent < mainController.getEvents().length && currentEvent > -1) {
                    mainController.getEvents()[currentEvent].insertNewChoice();
                    currentChoice = 0;
                    updateList2();
                }
            }
        });
        deleteButtonChoiceList.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (currentEvent < mainController.getEvents().length && currentEvent > -1) {
                    if (currentChoice < mainController.getEvents()[currentEvent].getAllChoices().length) {
                        mainController.getEvents()[currentEvent].deleteChoiceByIndex(currentChoice);
                        currentChoice = 0;
                        updateList2();
                    }
                }
            }
        });
    }

    private void saveAll() {
        if (currentEvent < mainController.getEvents().length) {
            if (currentChoice < mainController.getEvents()[currentEvent].getAllChoices().length) {
                mainController.getEvents()[currentEvent].setIntroduction(introductionField.getText());
                mainController.getEvents()[currentEvent].getAllChoices()[currentChoice].setChoiceIntro(choiceField.getText());
                mainController.getEvents()[currentEvent].getAllChoices()[currentChoice].setChoiceOutcome(outcomeField.getText());
                mainController.getEvents()[currentEvent].getAllChoices()[currentChoice].setPar1(valueOf(textFieldFirstPara.getText()));
                mainController.getEvents()[currentEvent].getAllChoices()[currentChoice].setPar2(valueOf(textFieldSecondPara.getText()));
                mainController.getEvents()[currentEvent].getAllChoices()[currentChoice].setPar3(valueOf(textFieldThirdPara.getText()));
                mainController.getEvents()[currentEvent].getAllChoices()[currentChoice].setPar4(valueOf(textFieldFourthPara.getText()));
                update();
            }
        }
    }

    public void init() {
        list1.setModel(defaultListModel1);
        list2.setModel(defaultListModel2);

    }

    public void update() {
        if (currentEvent < mainController.getEvents().length && currentEvent>-1) {
            defaultListModel1.removeAllElements();
            fillModel(defaultListModel1, What.Events);
            list1.updateUI();
            introductionField.setText(mainController.getEvents()[currentEvent].getIntroduction());
            updateList2();
        } else {
            defaultListModel1.removeAllElements();
            list1.updateUI();
            defaultListModel2.removeAllElements();
            list2.updateUI();
            introductionField.setText("");
            choiceField.setText("");
            outcomeField.setText("");
            textFieldFirstPara.setText("");
            textFieldSecondPara.setText("");
            textFieldThirdPara.setText("");
            textFieldFourthPara.setText("");
        }
    }

    private void updateList2() {
        if (currentEvent < mainController.getEvents().length && currentEvent>-1) {
            if (currentChoice < mainController.getEvents()[currentEvent].getAllChoices().length && currentChoice>-1) {
                defaultListModel2.removeAllElements();
                fillModel(defaultListModel2, What.Choices);
                list2.updateUI();
                updateAllTextFields();
            }
        }
    }

    private void updateAllTextFields() {
        if (currentEvent < mainController.getEvents().length && currentEvent>-1) {
            if (currentChoice < mainController.getEvents()[currentEvent].getAllChoices().length && currentChoice>-1) {
                choiceField.setText(mainController.getEvents()[currentEvent].getAllChoices()[currentChoice].getChoiceIntro());
                outcomeField.setText(mainController.getEvents()[currentEvent].getAllChoices()[currentChoice].getChoiceOutcome());
                textFieldFirstPara.setText(mainController.getEvents()[currentEvent].getAllChoices()[currentChoice].getPar1() + "");
                textFieldSecondPara.setText(mainController.getEvents()[currentEvent].getAllChoices()[currentChoice].getPar2() + "");
                textFieldThirdPara.setText(mainController.getEvents()[currentEvent].getAllChoices()[currentChoice].getPar3() + "");
                textFieldFourthPara.setText(mainController.getEvents()[currentEvent].getAllChoices()[currentChoice].getPar4() + "");
            }
        }
    }

    public void setMainController(MainController mainController) {
        this.mainController = mainController;
    }

    public JPanel getMainPanel() {
        return mainPanel;
    }

    private void fillModel(DefaultListModel<String> defaultListModel, What what) {
        Event[] events = mainController.getEvents();
        switch (what) {
            case Events:
                for (Event event :
                        events) {
                    defaultListModel.addElement(event.getIntroduction());
                }
                break;
            case Choices:
                if (currentEvent < events.length) {
                    for (Choice choice :
                            events[currentEvent].getAllChoices()) {
                        defaultListModel.addElement(choice.getChoiceIntro());
                    }
                }
        }
    }

    private enum What {Events, Choices}

}

