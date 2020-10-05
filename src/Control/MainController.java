package Control;

import Model.Choice;
import Model.Event;
import Model.Story;
import View.PanelControl;

import javax.swing.*;

public class MainController {
    private PanelControl panelControl;
    private Story story = new Story();

    public MainController(PanelControl panelControl) {
        this.panelControl = panelControl;
        panelControl.setMainController(this);
        readFile();
        test();
    }

    private void readFile() {
        //@TODO readAnExistingFile

    }

    private void writeFile() {
        //@TODO writeTheStoryFile
    }
    public DefaultListModel<String> getListOfEvents(){
        DefaultListModel listOfEvents = new DefaultListModel();
        for (Event event :
                story.getAllEvents()) {
            listOfEvents.addElement(event.getIntroduction());
        }

        return listOfEvents;
    }

    public DefaultListModel<String> getListOfCoices(int index){
        DefaultListModel listOfChoices = new DefaultListModel();
        story.getAllEvents()[index].insertNewChoice();
        story.getAllEvents()[index].insertNewChoice();
        for (Choice choice :
                story.getAllEvents()[index].getAllChoices()) {
            listOfChoices.addElement(choice.getChoiceIntro());
        }

        return listOfChoices;
    }


    public void test(){
        story.insertNewEvent();
        story.insertNewEvent();
        for (Event event :
                story.getAllEvents()) {
            event.setIntroduction("Testititest");
        }
        panelControl.update();
    }
}
