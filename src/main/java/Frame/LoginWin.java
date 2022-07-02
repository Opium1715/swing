/*
 * Created by JFormDesigner on Fri Jul 01 14:41:18 CST 2022
 */

package Frame;

import SQL.Msql;

import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.Date;




/**
 * @author unknown
 */
public class LoginWin extends JFrame {

    private String user;

    private String pass;
    public LoginWin() {
        initComponents();
        this.user=null;
        this.pass=null;
    }

    private void Login_buttonMouseClicked(MouseEvent e) throws SQLException {
        Connection con = null;
        PreparedStatement ps = null;
        try {
            user = username.getText();
            pass = password.getText();
            System.out.println(user);
            System.out.println(pass);
            con = Msql.connectData();

            ps = con.prepareStatement("select * from cjl.User where no =? and password = ? ");
            ps.setString(1, user);
            ps.setString(2, pass);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                setContentPane(new Fpanel(user));
                repaint();
                System.out.println("user：" + user + " 登录成功在 " + new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new
                        Date()));
            } else {
                label1.setText("用户名或密码错误！请重试！");
                System.out.println("用户名或密码错误！请重试！");
            }
        } catch (SQLException ex) {
            throw new RuntimeException(ex);
        }
       finally {
            assert con != null;
            assert ps != null;
            Msql.freeConnect(con,ps);
        }
    }


    private void initComponents() {
        // JFormDesigner - Component initialization - DO NOT MODIFY  //GEN-BEGIN:initComponents
        username = new JTextField();
        password = new JTextField();
        Login_button = new JButton();
        label1 = new JLabel();
        label2 = new JLabel();
        label3 = new JLabel();
        vSpacer1 = new JPanel(null);
        imageLable = new JLabel();

        //======== this ========
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setFont(new Font(Font.DIALOG, Font.PLAIN, 16));
        setIconImage(new ImageIcon(getClass().getResource("/icon.jpg")).getImage());
        Container contentPane = getContentPane();
        contentPane.setLayout(null);
        contentPane.add(username);
        username.setBounds(825, 220, 245, 50);
        contentPane.add(password);
        password.setBounds(825, 335, 245, 50);

        //---- Login_button ----
        Login_button.setText("\u767b\u5f55");
        Login_button.setFont(Login_button.getFont().deriveFont(Login_button.getFont().getSize() + 11f));
        Login_button.setToolTipText("\u70b9\u51fb\u767b\u5f55");
        Login_button.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                try {
                    Login_buttonMouseClicked(e);
                } catch (SQLException ex) {
                    throw new RuntimeException(ex);
                }
            }
        });
        contentPane.add(Login_button);
        Login_button.setBounds(870, 450, 165, 55);

        //---- label1 ----
        label1.setText("\u6b22\u8fce\u4f7f\u7528\uff01");
        label1.setFont(label1.getFont().deriveFont(label1.getFont().getSize() + 12f));
        label1.setHorizontalAlignment(SwingConstants.CENTER);
        contentPane.add(label1);
        label1.setBounds(700, 85, 495, label1.getPreferredSize().height);

        //---- label2 ----
        label2.setText("\u7528\u6237\u540d");
        label2.setFont(label2.getFont().deriveFont(label2.getFont().getSize() + 11f));
        contentPane.add(label2);
        label2.setBounds(720, 230, 90, 35);

        //---- label3 ----
        label3.setText("\u5bc6\u7801");
        label3.setFont(label3.getFont().deriveFont(label3.getFont().getSize() + 11f));
        contentPane.add(label3);
        label3.setBounds(720, 340, 90, 35);
        contentPane.add(vSpacer1);
        vSpacer1.setBounds(705, 575, 510, 70);

        //---- imageLable ----
        imageLable.setIcon(new ImageIcon(getClass().getResource("/login.jpg")));
        contentPane.add(imageLable);
        imageLable.setBounds(0, -5, 710, 655);

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
    private JTextField username;
    private JTextField password;
    private JButton Login_button;
    private JLabel label1;
    private JLabel label2;
    private JLabel label3;
    private JPanel vSpacer1;
    private JLabel imageLable;
    // JFormDesigner - End of variables declaration  //GEN-END:variables
}
