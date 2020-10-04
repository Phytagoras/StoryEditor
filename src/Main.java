import Control.MainController;
import View.Frame;
import View.PanelControl;

public class Main {
    private static PanelControl panelControl = new PanelControl();

    public static void main(String[] args) {
        Frame frame = new Frame();
        frame.setPane(panelControl.getMainPanel());
        MainController mainController = new MainController(panelControl);
    }
}
