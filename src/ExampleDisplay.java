import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class ExampleDisplay extends Canvas implements KeyListener {
    public static Dimension size = Toolkit.getDefaultToolkit().getScreenSize();
    public static int screenWidth = (int)size.getWidth();
    public static int screenHeight = (int)size.getHeight();
    public static JFrame mainframe = new JFrame("mainframe");
    public static JLabel theTextLabel;

    public void paint(Graphics g) {
        setBackground(Color.BLACK);
        g.setColor(Color.WHITE);
        g.drawString("Version 1.0",20,20);
        g.drawString("Screen Width: " + screenWidth,20,40);
        g.drawString("Screen Height: " + screenHeight,20,60);
    }

    @Override
    public void keyTyped(KeyEvent e) {

    }

    @Override
    public void keyPressed (KeyEvent e){
        int keyCode = e.getKeyCode();
            theTextLabel.setText(e.getKeyChar() + " Key Pressed");
        switch (keyCode) {
            case KeyEvent.VK_UP -> theTextLabel.setText ("UP ARROW Key Pressed");
            case KeyEvent.VK_LEFT -> theTextLabel.setText ("LEFT ARROW Key Pressed");
            case KeyEvent.VK_DOWN -> theTextLabel.setText ("DOWN ARROW Key Pressed");
            case KeyEvent.VK_RIGHT -> theTextLabel.setText ("RIGHT ARROW Key Pressed");
            case KeyEvent.VK_SHIFT -> theTextLabel.setText ("SHIFT Key Pressed");
            case KeyEvent.VK_CAPS_LOCK -> theTextLabel.setText ("CAPS LOCK Key Pressed");
            case KeyEvent.VK_CONTROL -> theTextLabel.setText ("CONTROL Key Pressed");
            case KeyEvent.VK_BACK_SPACE -> theTextLabel.setText ("BACKSPACE Key Pressed");
            case KeyEvent.VK_ENTER -> theTextLabel.setText ("ENTER Key Pressed");
            case KeyEvent.VK_SPACE -> theTextLabel.setText ("SPACE Key Pressed");
            case KeyEvent.VK_F1 -> mainframe.setUndecorated(false);
            case KeyEvent.VK_F12 -> System.exit(0);
        }

    }

    @Override
    public void keyReleased(KeyEvent e) {theTextLabel.setText ("Press F12 to exit.");}

    public static void initializeMainframe(){

        ExampleDisplay D = new ExampleDisplay();

        theTextLabel = new JLabel();
        theTextLabel.setHorizontalAlignment(0);
        theTextLabel.setBackground(new Color (0,0,0,0));
        int theTextLabelWidth = screenWidth/4;
        int theTextLabelHeight = screenHeight/4;

        theTextLabel.setBounds (screenWidth/2-theTextLabelWidth/2,screenHeight/2-theTextLabelHeight/2, theTextLabelWidth, theTextLabelHeight);

        mainframe.setSize(screenWidth, screenHeight);
        mainframe.getContentPane().setBackground(Color.WHITE);
        mainframe.setTitle("This is, in fact, the main frame");
        mainframe.addKeyListener(D);
        mainframe.setUndecorated(true);
        mainframe.add(theTextLabel);
        mainframe.add(D);
        mainframe.setVisible(true);
        mainframe.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
    }

    public static void main(String[] args) {
        initializeMainframe();
    }
}