import java.util.ArrayList;  
import java.util.List;  
import org.eclipse.swt.SWT;  
import org.eclipse.swt.graphics.Cursor;  
import org.eclipse.swt.graphics.Image;  
import org.eclipse.swt.widgets.Composite;  
import org.eclipse.swt.widgets.Event;  
import org.eclipse.swt.widgets.Label;  
import org.eclipse.swt.widgets.Listener;  
import org.eclipse.swt.widgets.Shell;  
/** 
 * �Զ���ͼƬ��ť 
 * @author Lifeng-Leven 
 * 
 */  
public class ImageButton {  
    private Image normalImage;  
    private Image mouseOverImage;  
    private Image mouseDownImage;  
    private Image disabledImage;  
    //Ĭ�������ʽ  
    private Cursor normalCursor;  
    private Cursor handCursor = new Cursor(null, SWT.CURSOR_HAND);  
      
    private Label label;  
    /** 
     * ��ť�Ƿ���� 
     */  
    private boolean isDisabled = false;  
      
    private List<OnClickListener> listeners = new ArrayList<OnClickListener>();  
    /** 
     * �Զ����ͼƬ�İ�ť�ؼ� 
     * @param parent 
     * @param normalImage 
     * @param mouseOverImage 
     * @param mouseDownImage 
     */  
    public ImageButton(Composite parent,Image normalImage,Image mouseOverImage,Image mouseDownImage) {  
        this(parent,normalImage,mouseOverImage,mouseDownImage,null);  
    }  
    /** 
     * �Զ����ͼƬ�İ�ť�ؼ� 
     * @param parent 
     * @param normalImage ��ͨ��ť����ͼ 
     * @param mouseOverImage ���������ť����ͼ 
     * @param mouseDownImage �������ť����ͼ 
     * @param disabledImage ��ťʧЧ����ͼ 
     */  
    public ImageButton(final Composite parent,Image normalImage,Image mouseOverImage,Image mouseDownImage,Image disabledImage) {  
        label = new Label(parent, SWT.NONE);  
        this.normalImage = normalImage;  
        this.mouseOverImage = mouseOverImage;  
        this.mouseDownImage = mouseDownImage;  
        this.disabledImage = disabledImage;  
        normalCursor = parent.getCursor();  
        label.setImage(normalImage);  
        label.addListener(SWT.MouseEnter, new Listener() {  
            public void handleEvent(Event event) {  
                if (!isDisabled && ImageButton.this.mouseOverImage != null) {  
                    label.setImage(ImageButton.this.mouseOverImage);  
                    parent.getShell().setCursor(handCursor);  
                }  
            }  
        });  
        label.addListener(SWT.MouseExit, new Listener() {  
            public void handleEvent(Event event) {  
                if (!isDisabled && ImageButton.this.normalImage != null) {  
                    label.setImage(ImageButton.this.normalImage);  
                    parent.getShell().setCursor(normalCursor);  
                }  
            }  
        });  
        label.addListener(SWT.MouseDown, new Listener() {  
            public void handleEvent(Event event) {  
                if (!isDisabled && ImageButton.this.mouseDownImage != null) {  
                    label.setImage(ImageButton.this.mouseDownImage);  
                }  
            }  
        });  
        label.addListener(SWT.MouseUp, new Listener() {  
            public void handleEvent(Event event) {  
                if(!isDisabled){  
                    if(event.widget.equals(label)){  
                        if (ImageButton.this.mouseOverImage != null) {  
                            label.setImage(ImageButton.this.mouseOverImage);  
                        }  
                    }  
                    for(OnClickListener listener : listeners){  
                        listener.onClick();  
                    }  
                }  
            }  
        });  
    }  
    /** 
     * ���ð�ť�Ƿ����״̬ 
     * @param isDisabled 
     */  
    public void setDisabled(boolean isDisabled){  
        this.isDisabled = isDisabled;  
        if(isDisabled){  
            if(disabledImage!=null){  
                label.setImage(disabledImage);  
            }  
        }  
    }  
    /** 
     * ����������Դ 
     */  
    public void dispose(){  
        if(normalImage!=null && !normalImage.isDisposed()){  
            normalImage.dispose();  
        }  
        if(mouseOverImage!=null && !mouseOverImage.isDisposed()){  
            mouseOverImage.dispose();  
        }  
        if(mouseDownImage!=null && !mouseDownImage.isDisposed()){  
            mouseDownImage.dispose();  
        }  
        if(disabledImage!=null && !disabledImage.isDisposed()){  
            disabledImage.dispose();  
        }  
    }  
    /** 
     * ��Ӷ����¼� 
     * @param listener 
     */  
    public void addClickListener(OnClickListener listener){  
        listeners.add(listener);  
    }  
    /** 
     * �Ƴ������¼� 
     * @param listener 
     */  
    public void removeClickListener(OnClickListener listener){  
        listeners.remove(listener);  
    }  
    /** 
     * �Զ��嶯���ӿ� 
     * @author Lifeng-Leven 
     * 
     */  
    public interface OnClickListener{  
        public void onClick();  
    }  
  
    public void setLayoutData(Object btnData) {  
        if(label!=null && !label.isDisposed()){  
            label.setLayoutData(btnData);  
        }  
    }  
    public void setBounds(int x,int y,int x1,int y1) {  
        if(label!=null && !label.isDisposed()){  
            label.setBounds(x,y,x1,y1);
        }  
    }
    public Shell getShell() {  
        if(label!=null && !label.isDisposed()){  
            return label.getShell();  
        }  
        return null;  
    }  
} 