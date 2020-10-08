package Control;

import Model.Choice;
import Model.Event;
import Model.Story;
import View.PanelControl;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class MainController {
    private PanelControl panelControl;
    private Story story = new Story();
    private File storyFile;

    public MainController(PanelControl panelControl) {
        this.panelControl = panelControl;
        storyFile = new File("src/Model/StoryFile.txt");
        try {
            if (storyFile.createNewFile()) {
                System.out.println("New Storyfile created!");
            } else System.out.println("Storyfile imported!");
        } catch (IOException e) {
            e.printStackTrace();
        }
        panelControl.setMainController(this);
        readFile();
        //test();
        panelControl.init();
        panelControl.update();
        //writeFile();
    }

    private void readFile() {
        try {
            Scanner in = new Scanner(storyFile);
            while (in.hasNextLine()) {
                String line = in.nextLine();
                if (line.equals("***")) {
                    story.insertNewEvent();
                    story.getAllEvents()[story.getAllEvents().length - 1].setIntroduction(in.nextLine());
                } else if (line.equals("**")) {
                    story.getAllEvents()[story.getAllEvents().length - 1].insertNewChoice();
                    story.getAllEvents()[story.getAllEvents().length - 1].getAllChoices()[story.getAllEvents()[story.getAllEvents().length - 1].getAllChoices().length - 1].setChoiceIntro(in.nextLine());
                } else if (line.equals("*")) {
                    story.getAllEvents()[story.getAllEvents().length - 1].getAllChoices()[story.getAllEvents()[story.getAllEvents().length - 1].getAllChoices().length - 1].setChoiceOutcome(in.nextLine());
                } else if (line.equals("#1")) {
                    story.getAllEvents()[story.getAllEvents().length - 1].getAllChoices()[story.getAllEvents()[story.getAllEvents().length - 1].getAllChoices().length - 1].setPar1(in.nextInt());
                } else if (line.equals("#2")) {
                    story.getAllEvents()[story.getAllEvents().length - 1].getAllChoices()[story.getAllEvents()[story.getAllEvents().length - 1].getAllChoices().length - 1].setPar2(in.nextInt());
                } else if (line.equals("#3")) {
                    story.getAllEvents()[story.getAllEvents().length - 1].getAllChoices()[story.getAllEvents()[story.getAllEvents().length - 1].getAllChoices().length - 1].setPar3(in.nextInt());
                } else if (line.equals("#4")) {
                    story.getAllEvents()[story.getAllEvents().length - 1].getAllChoices()[story.getAllEvents()[story.getAllEvents().length - 1].getAllChoices().length - 1].setPar4(in.nextInt());
                }
            }
            in.close();
        } catch (IOException e) {
            e.printStackTrace();
        }


    }

    public void writeFile() {
        try {
            storyFile.delete();
            storyFile.createNewFile();
            FileWriter fileWriter = new FileWriter(storyFile);

            for (Event event :
                    getEvents()) {
                fileWriter.write("***\n");
                fileWriter.write(event.getIntroduction() + "\n");
                for (Choice choice :
                        event.getAllChoices()) {
                    fileWriter.write("**\n");
                    fileWriter.write(choice.getChoiceIntro() + "\n");
                    fileWriter.write("*\n");
                    fileWriter.write(choice.getChoiceOutcome() + "\n");
                    fileWriter.write("#1\n");
                    fileWriter.write(choice.getPar1() + "\n");
                    fileWriter.write("#2\n");
                    fileWriter.write(choice.getPar2() + "\n");
                    fileWriter.write("#3\n");
                    fileWriter.write(choice.getPar3() + "\n");
                    fileWriter.write("#4\n");
                    fileWriter.write(choice.getPar4() + "\n");

                }


            }

            fileWriter.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public Event[] getEvents() {
        return story.getAllEvents();
    }


    public void test() {
        story.insertNewEvent();
        story.insertNewEvent();
        for (Event event :
                story.getAllEvents()) {
            event.setIntroduction("Testititest");
            event.insertNewChoice();
            event.insertNewChoice();
        }
        story.getAllEvents()[1].getAllChoices()[1].setChoiceIntro("dfasf");
    }

    public void addNewEvent() {
        story.insertNewEvent();
    }

    public void deleteEventByIndex(int currentEvent) {
        story.deleteEventByIndex(currentEvent);
    }
}


/*

***
    Irgendeine dumme Einleitung
    **
        Eine Auswahlmöglichkeit...
        *
            Deine Wahl war...BESCHISSEN!
            #1
                -100
            #2
                -3
            #3
                +14
            #4
                +33
    **
        Weitere Auswahl...
        *
            Die Wahl war super!
            #1
                +50
            #2
                -3
            #3
                +14
            #4
                +33
***
    Weitere Einleitung für ein neues Event
 */
