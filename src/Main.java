import View.Frame;
import View.PanelControl;

import java.awt.*;

public class Main {
    private static PanelControl panelControl = new PanelControl();
    public static void main(String[] args) {
        Frame frame = new Frame();
        frame.setPane(panelControl.getPanel());
    }
}
