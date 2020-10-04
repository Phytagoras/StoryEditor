package Control;

import Model.Story;
import View.PanelControl;

public class MainController {
    private PanelControl panelControl;
    private Story story = new Story();

    public MainController(PanelControl panelControl) {
        this.panelControl = panelControl;
        readFile();
    }

    private void readFile() {
        //@TODO readAnExistingFile
    }

    private void writeFile() {
        //@TODO writeTheStoryFile
    }
}
