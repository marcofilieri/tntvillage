import java.awt.datatransfer.Clipboard;
import java.awt.datatransfer.StringSelection;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumnModel;
import java.awt.*;
import java.util.ArrayList;
/*
 * Created by JFormDesigner on Thu Sep 12 09:18:14 CEST 2019
 */



/**
 * @author unknown
 */
public class Gui extends JFrame {
    public Gui() {
        initComponents();
    }

    public JTable getTable1() {
        return table1;
    }

    private void table1MouseClicked(MouseEvent e) {
       copy_content();
    }

    private void initComponents() {
        // JFormDesigner - Component initialization - DO NOT MODIFY  //GEN-BEGIN:initComponents
        scrollPane1 = new JScrollPane();
        table1 = new JTable();

        //======== this ========
        Container contentPane = getContentPane();
        contentPane.setLayout(new GridLayout());

        //======== scrollPane1 ========
        {

            //---- table1 ----
            table1.setModel(new DefaultTableModel(
                new Object[][] {
                },
                new String[] {
                    "Title", "Link"
                }
            ) {
                boolean[] columnEditable = new boolean[] {
                    false, false
                };
                @Override
                public boolean isCellEditable(int rowIndex, int columnIndex) {
                    return columnEditable[columnIndex];
                }
            });
            {
                TableColumnModel cm = table1.getColumnModel();
                cm.getColumn(0).setResizable(false);
                cm.getColumn(1).setResizable(false);
            }
            table1.setAutoCreateRowSorter(true);
            table1.setRowSelectionAllowed(false);
            table1.setComponentOrientation(ComponentOrientation.LEFT_TO_RIGHT);
            table1.setMaximumSize(null);
            table1.addMouseListener(new MouseAdapter() {
                @Override
                public void mouseClicked(MouseEvent e) {
                    table1MouseClicked(e);
                }
            });
            scrollPane1.setViewportView(table1);
        }
        contentPane.add(scrollPane1);
        pack();
        setLocationRelativeTo(getOwner());
        // JFormDesigner - End of component initialization  //GEN-END:initComponents
    }

    // JFormDesigner - Variables declaration - DO NOT MODIFY  //GEN-BEGIN:variables
    private JScrollPane scrollPane1;
    private JTable table1;
    // JFormDesigner - End of variables declaration  //GEN-END:variables

    public void addRow(){
        DefaultTableModel model = (DefaultTableModel) table1.getModel();
        Row row = new Row();
        ArrayList vet = row.rows();
        for(Object oggetto: vet.toArray()){
            model.addRow((Object[]) oggetto);
        }
    }

    private void copy_content(){
        if(table1.getSelectedColumn() == 1){
            String myString = table1.getValueAt(table1.getSelectedRow(),table1.getSelectedColumn()).toString();
            StringSelection stringSelection = new StringSelection(myString);
            Clipboard clipboard = Toolkit.getDefaultToolkit().getSystemClipboard();
            clipboard.setContents(stringSelection, null);
        }
    }
}
