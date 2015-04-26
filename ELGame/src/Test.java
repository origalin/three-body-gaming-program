import java.awt.Window;

import org.eclipse.swt.widgets.Display;

public class Test {
	public static void main(String[] args) {
		GameWindow window = new GameWindow();
		try {

			window.setBlockOnOpen(true);
			window.open();
			Display.getCurrent().dispose();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
