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
 * 自定义图片按钮 
 * @author Lifeng-Leven 
 * 
 */  
public class ImageButton {  
    private Image normalImage;  
    private Image mouseOverImage;  
    private Image mouseDownImage;  
    private Image disabledImage;  
    //默认鼠标样式  
    private Cursor normalCursor;  
    private Cursor handCursor = new Cursor(null, SWT.CURSOR_HAND);  
      
    private Label label;  
    /** 
     * 按钮是否可用 
     */  
    private boolean isDisabled = false;  
      
    private List<OnClickListener> listeners = new ArrayList<OnClickListener>();  
    /** 
     * 自定义带图片的按钮控件 
     * @param parent 
     * @param normalImage 
     * @param mouseOverImage 
     * @param mouseDownImage 
     */  
    public ImageButton(Composite parent,Image normalImage,Image mouseOverImage,Image mouseDownImage) {  
        this(parent,normalImage,mouseOverImage,mouseDownImage,null);  
    }  
    /** 
     * 自定义带图片的按钮控件 
     * @param parent 
     * @param normalImage 普通按钮背景图 
     * @param mouseOverImage 鼠标悬浮按钮背景图 
     * @param mouseDownImage 鼠标点击按钮背景图 
     * @param disabledImage 按钮失效背景图 
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
     * 设置按钮是否可用状态 
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
     * 处理无用资源 
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
     * 添加动作事件 
     * @param listener 
     */  
    public void addClickListener(OnClickListener listener){  
        listeners.add(listener);  
    }  
    /** 
     * 移除动作事件 
     * @param listener 
     */  
    public void removeClickListener(OnClickListener listener){  
        listeners.remove(listener);  
    }  
    /** 
     * 自定义动作接口 
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