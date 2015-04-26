import javax.swing.ButtonModel;

import org.eclipse.jface.action.MenuManager;
import org.eclipse.jface.action.StatusLineManager;
import org.eclipse.jface.action.ToolBarManager;
import org.eclipse.jface.resource.ImageDescriptor;
import org.eclipse.jface.window.ApplicationWindow;
import org.eclipse.swt.SWT;
import org.eclipse.swt.graphics.Image;
import org.eclipse.swt.graphics.ImageData;
import org.eclipse.swt.graphics.Point;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Control;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.wb.swt.SWTResourceManager;
import org.eclipse.swt.layout.FillLayout;
import org.eclipse.swt.custom.StackLayout;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Text;
import org.eclipse.swt.widgets.Label;



public class GameWindow extends ApplicationWindow {
	Image backgImage=new Image(Display.getCurrent(), "./res/universe.jpg");
	private Text txtVer;

	/**
	 * Create the application window.
	 */
	public GameWindow() {
		super(null);
		setShellStyle(SWT.MIN);
		setBlockOnOpen(true);
		createActions();
	}

	/**
	 * Create contents of the application window.
	 * @param parent
	 */
	@Override
	protected Control createContents(Composite parent) {
		Composite container = new Composite(parent, SWT.NONE);
		container.setBackgroundImage(backgImage);
		container.setBackgroundMode(3);
		container.setLayout(null);
		
		txtVer = new Text(container, SWT.READ_ONLY);
		txtVer.setForeground(SWTResourceManager.getColor(255, 255, 255));
		txtVer.setEditable(false);
		txtVer.setText("ver 0.01");
		txtVer.setBounds(1175, 600, 89, 20);
		
		ImageButton button=new ImageButton(container, backgImage, backgImage, backgImage, backgImage);
		button.setBounds(524, 165, 185, 69);
		

		

		return container;
	}

	/**
	 * Create the actions.
	 */
	private void createActions() {
		// Create the actions
	}

	/**
	 * Create the menu manager.
	 * @return the menu manager
	 */


	/**
	 * Create the toolbar manager.
	 * @return the toolbar manager
	 */


	/**
	 * Create the status line manager.
	 * @return the status line manager
	 */


	/**
	 * Launch the application.
	 * @param args
	 */

	/**
	 * Configure the shell.
	 * @param newShell
	 */
	@Override
	protected void configureShell(Shell newShell) {
		super.configureShell(newShell);
		newShell.setText("New Application");
	}

	/**
	 * Return the initial size of the window.
	 */
	@Override
	protected Point getInitialSize() {
		return new Point(1280, 688);
	}
	class button1 implements ImageButton.OnClickListener{
		public void onClick(){
			
		}
	}
}