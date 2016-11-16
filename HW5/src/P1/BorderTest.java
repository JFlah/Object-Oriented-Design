package P1;

import java.awt.*;
import javax.swing.*;
import javax.swing.border.CompoundBorder;
import javax.swing.border.LineBorder;
import javax.swing.border.TitledBorder;

public class BorderTest {
    public static void main(String[] args) {
        GUIFrame1 frame = new GUIFrame1();
        frame.pack();
    }
}

@SuppressWarnings("serial")
class GUIFrame1 extends JFrame {
    private GUIPanel1 panel;

    public GUIFrame1() {
        setTitle("P1.BorderTest");
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setLocation(200,200);
        panel = new GUIPanel1();
        setContentPane(panel);
        setVisible(true);
    }
}

@SuppressWarnings("serial")
class GUIPanel1 extends JPanel {
    private JTextField txt1 = new JTextField("Hello!", 30);
    private JTextField txt2 = new JTextField("Hello!", 30);
    private JTextField txt3 = new JTextField("Hello!", 30);
    private JTextField txt4 = new JTextField("Hello!", 30);
    private JTextField txt5 = new JTextField("Hello!", 30);

    private JTextArea area1;
    private JScrollPane area1sp;
    private JTextArea area2;
    private JScrollPane area2sp;

    private JList<String> lst;

    LineBorder redLine = (LineBorder) BorderFactory.createLineBorder(Color.red, 4);
    LineBorder greenLine = (LineBorder) BorderFactory.createLineBorder(Color.green, 4);
    LineBorder blueLine = (LineBorder) BorderFactory.createLineBorder(Color.blue, 4);

    CompoundBorder redGreenCompound = BorderFactory.createCompoundBorder(redLine, greenLine);

    CompoundBorder tripleBorderRGB = BorderFactory.createCompoundBorder(redGreenCompound, blueLine);

    TitledBorder titleGreen = BorderFactory.createTitledBorder(greenLine, "A Green Border", TitledBorder.LEFT, TitledBorder.CENTER);
    CompoundBorder titleGreenRed = BorderFactory.createCompoundBorder(titleGreen, redLine);

    TitledBorder titleCompound = BorderFactory.createTitledBorder(redGreenCompound, "A Red-Green Border", TitledBorder.LEFT, TitledBorder.CENTER);

    TitledBorder titleRed = BorderFactory.createTitledBorder(redLine, "A Red Border", TitledBorder.LEFT, TitledBorder.CENTER);
    CompoundBorder titleGreenTitleRed = BorderFactory.createCompoundBorder(titleGreen, titleRed);

    TitledBorder titleCompoundScrollPane = BorderFactory.createTitledBorder(redGreenCompound, "A bordered scrollpane", TitledBorder.LEFT, TitledBorder.CENTER);

    public GUIPanel1() {
        // Text 1
        txt1.setBorder(redGreenCompound);
        add(txt1);

        // Text 2
        txt2.setBorder(tripleBorderRGB);
        add(txt2);

        // Text 3
        txt3.setBorder(titleGreenRed);
        add(txt3);

        // Text 4
        txt4.setBorder(titleCompound);
        add(txt4);

        // Text 5
        txt5.setBorder(titleGreenTitleRed);
        add(txt5);

        // JList component for TextArea components
        String[] listitems = new String[] {"Hello!", "a", "ab", "abc"};
        lst = new JList<String>(listitems);
        lst.setVisibleRowCount(3);

        // Area 1
        area1 = new JTextArea(5, 5);
        area1.append(listitems[0]+"\n"+listitems[1]+"\n"+listitems[2]+"\n"+listitems[3]);
        area1sp = new JScrollPane(area1);
        area1sp.setBorder(titleCompoundScrollPane);
        add(area1sp);

        // Area 2
        area2 = new JTextArea(5, 5);
        area2.append(listitems[0]+"\n"+listitems[1]+"\n"+listitems[2]+"\n"+listitems[3]);
        area2.setBorder(blueLine);
        area2sp = new JScrollPane(area2);
        area2sp.setBorder(titleRed);
        add(area2sp);

        setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
    }
}