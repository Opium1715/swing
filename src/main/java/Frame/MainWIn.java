/*
 * Created by JFormDesigner on Fri Jul 01 22:17:53 CST 2022
 */

package Frame;

import java.awt.*;
import javax.swing.*;

/**
 * @author unknown
 */
public class MainWIn extends JFrame {
    String user="test";
    public MainWIn() {
        initComponents();
        setContentPane(new Fpanel(user));
    }

    private void initComponents() {
        // JFormDesigner - Component initialization - DO NOT MODIFY  //GEN-BEGIN:initComponents
        vSpacer1 = new JPanel(null);

        //======== this ========
        Container contentPane = getContentPane();
        contentPane.setLayout(null);
        contentPane.add(vSpacer1);
        vSpacer1.setBounds(0, 0, 960, 645);

        {
            // compute preferred size
            Dimension preferredSize = new Dimension();
            for(int i = 0; i < contentPane.getComponentCount(); i++) {
                Rectangle bounds = contentPane.getComponent(i).getBounds();
                preferredSize.width = Math.max(bounds.x + bounds.width, preferredSize.width);
                preferredSize.height = Math.max(bounds.y + bounds.height, preferredSize.height);
            }
            Insets insets = contentPane.getInsets();
            preferredSize.width += insets.right;
            preferredSize.height += insets.bottom;
            contentPane.setMinimumSize(preferredSize);
            contentPane.setPreferredSize(preferredSize);
        }
        pack();
        setLocationRelativeTo(getOwner());
        // JFormDesigner - End of component initialization  //GEN-END:initComponents
    }

    // JFormDesigner - Variables declaration - DO NOT MODIFY  //GEN-BEGIN:variables
    private JPanel vSpacer1;
    // JFormDesigner - End of variables declaration  //GEN-END:variables
}
