/*
 * Created by JFormDesigner on Fri Jul 01 14:54:06 CST 2022
 */

package Frame;

import java.awt.event.*;
import SQL.Msql;

import java.awt.*;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.Format;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Timer;
import java.util.TimerTask;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;

/**
 * @author unknown
 */
public class Fpanel extends JPanel {

    public Fpanel(String user) throws SQLException {
        initComponents();
        label4.setText("当前用户："+user);
        label5.setText("状态：已连接");
        displayTime();
        setTable1();
    }

    private void setTable1() throws SQLException {
        //表格初始化属性
        String[] columnNames={"用户编号","用户密码","用户地址"};

        String[][] userdatas=new String[][]{};

        DefaultTableModel tableModel=new DefaultTableModel(userdatas,columnNames);

        userTable.setEnabled(false);
        userTable.setModel(tableModel);


        //数据库连接
        Connection con=Msql.connectData();
        Statement stat= con.createStatement();
        //执行初次显示动作
        ResultSet rs= stat.executeQuery("select * from cjl.User");
        while (rs.next()){
            String[] strings=new String[3];
            strings[0]=rs.getString("no");
            strings[1]=rs.getString("password");
            strings[2]=rs.getString("address");

            tableModel.addRow(strings);

            userTable.setModel(tableModel);
        }



    }

    private void displayTime(){
        Timer timer = new Timer();
        timer.schedule(new TimeTask(),0,1000);
    }

    private void editorModeMouseClicked(MouseEvent e) {
        if(editorMode.isSelected()){
            userTable.setEnabled(true);
        }
        else {
            userTable.setEnabled(false);
        }

    }
    private void initComponents() {
        // JFormDesigner - Component initialization - DO NOT MODIFY  //GEN-BEGIN:initComponents
        menuBar1 = new JMenuBar();
        menu1 = new JMenu();
        menuItem1 = new JMenuItem();
        menuItem2 = new JMenuItem();
        panel1 = new JPanel();
        label3 = new JLabel();
        label4 = new JLabel();
        label5 = new JLabel();
        label6 = new JLabel();
        tabbedPane1 = new JTabbedPane();
        panel2 = new JPanel();
        scrollPane1 = new JScrollPane();
        userTable = new JTable();
        panel7 = new JPanel();
        label9 = new JLabel();
        editorMode = new JToggleButton();
        label2 = new JLabel();
        panel3 = new JPanel();
        panel4 = new JPanel();
        panel5 = new JPanel();
        panel6 = new JPanel();

        //======== this ========
        setLayout(new BorderLayout());

        //======== menuBar1 ========
        {

            //======== menu1 ========
            {
                menu1.setText("text");

                //---- menuItem1 ----
                menuItem1.setText("text");
                menu1.add(menuItem1);
                menu1.addSeparator();

                //---- menuItem2 ----
                menuItem2.setText("text");
                menu1.add(menuItem2);
            }
            menuBar1.add(menu1);
        }
        add(menuBar1, BorderLayout.NORTH);

        //======== panel1 ========
        {
            panel1.setLayout(new GridLayout(4, 0));

            //---- label3 ----
            label3.setText("\u7f51\u4e0a\u8d2d\u7269\u7ba1\u7406");
            panel1.add(label3);

            //---- label4 ----
            label4.setText("\u7528\u6237\u540d\uff1a");
            panel1.add(label4);

            //---- label5 ----
            label5.setText("\u72b6\u6001");
            panel1.add(label5);

            //---- label6 ----
            label6.setText("\u8fde\u63a5\u65f6\u957f");
            panel1.add(label6);
        }
        add(panel1, BorderLayout.WEST);

        //======== tabbedPane1 ========
        {
            tabbedPane1.setFont(tabbedPane1.getFont().deriveFont(tabbedPane1.getFont().getSize() + 10f));

            //======== panel2 ========
            {
                panel2.setLayout(new BorderLayout());

                //======== scrollPane1 ========
                {

                    //---- userTable ----
                    userTable.setFont(userTable.getFont().deriveFont(userTable.getFont().getSize() + 3f));
                    scrollPane1.setViewportView(userTable);
                }
                panel2.add(scrollPane1, BorderLayout.CENTER);

                //======== panel7 ========
                {
                    panel7.setLayout(new GridLayout(4, 2));

                    //---- label9 ----
                    label9.setText("\u5de5\u4f5c\u533a");
                    label9.setHorizontalAlignment(SwingConstants.CENTER);
                    label9.setFont(label9.getFont().deriveFont(label9.getFont().getSize() + 9f));
                    panel7.add(label9);

                    //---- editorMode ----
                    editorMode.setText("\u7f16\u8f91\u6a21\u5f0f");
                    editorMode.setToolTipText("\u6309\u4e0b\u5f00\u542f\u7f16\u8f91\u6a21\u5f0f");
                    editorMode.addMouseListener(new MouseAdapter() {
                        @Override
                        public void mouseClicked(MouseEvent e) {
                            editorModeMouseClicked(e);
                        }
                    });
                    panel7.add(editorMode);
                }
                panel2.add(panel7, BorderLayout.EAST);

                //---- label2 ----
                label2.setText("\u7cfb\u7edf\u6d88\u606f\uff1a");
                panel2.add(label2, BorderLayout.SOUTH);
            }
            tabbedPane1.addTab("\u7528\u6237\u4fe1\u606f", panel2);

            //======== panel3 ========
            {
                panel3.setLayout(null);

                {
                    // compute preferred size
                    Dimension preferredSize = new Dimension();
                    for(int i = 0; i < panel3.getComponentCount(); i++) {
                        Rectangle bounds = panel3.getComponent(i).getBounds();
                        preferredSize.width = Math.max(bounds.x + bounds.width, preferredSize.width);
                        preferredSize.height = Math.max(bounds.y + bounds.height, preferredSize.height);
                    }
                    Insets insets = panel3.getInsets();
                    preferredSize.width += insets.right;
                    preferredSize.height += insets.bottom;
                    panel3.setMinimumSize(preferredSize);
                    panel3.setPreferredSize(preferredSize);
                }
            }
            tabbedPane1.addTab("\u8ba2\u5355\u4fe1\u606f", panel3);

            //======== panel4 ========
            {
                panel4.setLayout(null);

                {
                    // compute preferred size
                    Dimension preferredSize = new Dimension();
                    for(int i = 0; i < panel4.getComponentCount(); i++) {
                        Rectangle bounds = panel4.getComponent(i).getBounds();
                        preferredSize.width = Math.max(bounds.x + bounds.width, preferredSize.width);
                        preferredSize.height = Math.max(bounds.y + bounds.height, preferredSize.height);
                    }
                    Insets insets = panel4.getInsets();
                    preferredSize.width += insets.right;
                    preferredSize.height += insets.bottom;
                    panel4.setMinimumSize(preferredSize);
                    panel4.setPreferredSize(preferredSize);
                }
            }
            tabbedPane1.addTab("\u5f85\u5ba1\u6838\u5546\u54c1", panel4);

            //======== panel5 ========
            {
                panel5.setLayout(null);

                {
                    // compute preferred size
                    Dimension preferredSize = new Dimension();
                    for(int i = 0; i < panel5.getComponentCount(); i++) {
                        Rectangle bounds = panel5.getComponent(i).getBounds();
                        preferredSize.width = Math.max(bounds.x + bounds.width, preferredSize.width);
                        preferredSize.height = Math.max(bounds.y + bounds.height, preferredSize.height);
                    }
                    Insets insets = panel5.getInsets();
                    preferredSize.width += insets.right;
                    preferredSize.height += insets.bottom;
                    panel5.setMinimumSize(preferredSize);
                    panel5.setPreferredSize(preferredSize);
                }
            }
            tabbedPane1.addTab("\u5546\u54c1\u4fe1\u606f", panel5);

            //======== panel6 ========
            {
                panel6.setLayout(null);

                {
                    // compute preferred size
                    Dimension preferredSize = new Dimension();
                    for(int i = 0; i < panel6.getComponentCount(); i++) {
                        Rectangle bounds = panel6.getComponent(i).getBounds();
                        preferredSize.width = Math.max(bounds.x + bounds.width, preferredSize.width);
                        preferredSize.height = Math.max(bounds.y + bounds.height, preferredSize.height);
                    }
                    Insets insets = panel6.getInsets();
                    preferredSize.width += insets.right;
                    preferredSize.height += insets.bottom;
                    panel6.setMinimumSize(preferredSize);
                    panel6.setPreferredSize(preferredSize);
                }
            }
            tabbedPane1.addTab("\u7ba1\u7406\u5458\u4fe1\u606f", panel6);
        }
        add(tabbedPane1, BorderLayout.CENTER);
        // JFormDesigner - End of component initialization  //GEN-END:initComponents
    }

    // JFormDesigner - Variables declaration - DO NOT MODIFY  //GEN-BEGIN:variables
    private JMenuBar menuBar1;
    private JMenu menu1;
    private JMenuItem menuItem1;
    private JMenuItem menuItem2;
    private JPanel panel1;
    private JLabel label3;
    private JLabel label4;
    private JLabel label5;
    private static JLabel label6;
    private JTabbedPane tabbedPane1;
    private JPanel panel2;
    private JScrollPane scrollPane1;
    private JTable userTable;
    private JPanel panel7;
    private JLabel label9;
    private JToggleButton editorMode;
    private JLabel label2;
    private JPanel panel3;
    private JPanel panel4;
    private JPanel panel5;
    private JPanel panel6;
    // JFormDesigner - End of variables declaration  //GEN-END:variables

    private static class TimeTask extends TimerTask{

        @Override
        public void run() {
            Format format = new SimpleDateFormat("HH:mm:ss");
            label6.setText("连接时长："+format.format(new Date()));
        }
    }
}
