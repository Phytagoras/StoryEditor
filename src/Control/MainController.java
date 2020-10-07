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
    public Event[] getEvents(){
        return story.getAllEvents();
    }


    public void test(){
        story.insertNewEvent();
        story.insertNewEvent();
        for (Event event :
                story.getAllEvents()) {
            event.setIntroduction("Testititest");
            event.insertNewChoice();
            event.insertNewChoice();
        }
        story.getAllEvents()[1].getAllChoices()[1].setChoiceIntro("dfasf");
        panelControl.init();
        panelControl.update();
    }

    public void addNewEvent() {
        story.insertNewEvent();
    }

    public void deleteEventByIndex(int currentEvent) {
        story.deleteEventByIndex(currentEvent);
    }
}
