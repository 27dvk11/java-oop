/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ims.gui;

import ims.bll.EmployeeBLL;
import ims.dal.DepartmentBLL;
import ims.dto.Department;
import ims.dto.Employee;
import java.awt.Dimension;
import java.awt.Toolkit;
import java.util.Iterator;
import java.util.List;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author NAT
 */
public class EmployeeListGUI extends javax.swing.JFrame {

    List<Employee> empList;
    List<Department> depList;
    EmployeeBLL empBLL;
    DepartmentBLL depBLL;

    /**
     * Creates new form EmployeeList
     */
    public EmployeeListGUI() {
        initComponents();
        setInfoDialog();
        empBLL = new EmployeeBLL();
        depBLL = new DepartmentBLL();
    }

    public void setInfoDialog() {
        Dimension dimension = Toolkit.getDefaultToolkit().getScreenSize();
        int x = (int) ((dimension.getWidth() - getWidth()) / 2);
        int y = (int) ((dimension.getHeight() - getHeight()) / 2);
        setLocation(x, y);
        setResizable(false);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jToolBar1 = new javax.swing.JToolBar();
        btNew = new javax.swing.JButton();
        jSeparator1 = new javax.swing.JToolBar.Separator();
        btEdit = new javax.swing.JButton();
        jSeparator2 = new javax.swing.JToolBar.Separator();
        btDelete = new javax.swing.JButton();
        jSeparator3 = new javax.swing.JToolBar.Separator();
        jButton4 = new javax.swing.JButton();
        jSeparator4 = new javax.swing.JToolBar.Separator();
        btClose = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        tbEmployee = new javax.swing.JTable();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowOpened(java.awt.event.WindowEvent evt) {
                formWindowOpened(evt);
            }
        });

        jToolBar1.setRollover(true);

        btNew.setText("Thêm ");
        btNew.setFocusable(false);
        btNew.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btNew.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        btNew.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btNewActionPerformed(evt);
            }
        });
        jToolBar1.add(btNew);
        jToolBar1.add(jSeparator1);

        btEdit.setText("Sửa");
        btEdit.setFocusable(false);
        btEdit.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btEdit.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        btEdit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btEditActionPerformed(evt);
            }
        });
        jToolBar1.add(btEdit);
        jToolBar1.add(jSeparator2);

        btDelete.setText("Xóa");
        btDelete.setFocusable(false);
        btDelete.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btDelete.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        btDelete.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btDeleteActionPerformed(evt);
            }
        });
        jToolBar1.add(btDelete);
        jToolBar1.add(jSeparator3);

        jButton4.setText("In");
        jButton4.setFocusable(false);
        jButton4.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jButton4.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        jToolBar1.add(jButton4);
        jToolBar1.add(jSeparator4);

        btClose.setText("Thoát");
        btClose.setFocusable(false);
        btClose.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btClose.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        btClose.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btCloseActionPerformed(evt);
            }
        });
        jToolBar1.add(btClose);

        tbEmployee.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Mã ", "Tên", "Tuổi", "Đơn vị"
            }
        ));
        jScrollPane1.setViewportView(tbEmployee);
        if (tbEmployee.getColumnModel().getColumnCount() > 0) {
            tbEmployee.getColumnModel().getColumn(1).setPreferredWidth(200);
            tbEmployee.getColumnModel().getColumn(3).setPreferredWidth(100);
        }

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jToolBar1, javax.swing.GroupLayout.PREFERRED_SIZE, 830, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
            .addComponent(jScrollPane1)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jToolBar1, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(5, 5, 5)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 320, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents
    Employee employeeToEdit;
    private void btNewActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btNewActionPerformed
        EmployeeGUI emGui = new EmployeeGUI(this);
        emGui.setLisDepartment(depList);
        emGui.setVisible(true);

        Employee newEmployee = emGui.getEmployee();

        if (newEmployee != null) {
            try {
                empBLL.save(newEmployee);
                empList.add(newEmployee);
                
                DefaultTableModel model = (DefaultTableModel) tbEmployee.getModel();
                int newRow = tbEmployee.getRowCount();
                model.addRow(new Object[0]);
                updateTableEmployee(newEmployee, newRow);
                
            } catch (Exception ex) {
                String message = "Could not save new employee. Error:\n" + ex.getMessage();
                JOptionPane.showMessageDialog(this, message, "Error", JOptionPane.ERROR_MESSAGE);
            }
        }
    }//GEN-LAST:event_btNewActionPerformed

    private void updateTableEmployee(Employee employee, int row){
        DefaultTableModel model =(DefaultTableModel) tbEmployee.getModel();
        model.setValueAt(employee.getId(), row, 0);
        model.setValueAt(employee.getFullName(), row, 1);
        model.setValueAt(employee.getAge(), row, 2);
        model.setValueAt(employee.getDepartment().getFullName(), row, 3);
    }
    private void formWindowOpened(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowOpened
        empList = empBLL.listAll();
        depList = depBLL.listAll();
        DefaultTableModel model = (DefaultTableModel) tbEmployee.getModel();
        int row = 0;
        for (Iterator iterator = empList.iterator(); iterator.hasNext();) {
            Employee emp = (Employee) iterator.next();
            model.addRow(new Object[0]);
            updateTableEmployee(emp, row);          
            row++;
        }

    }//GEN-LAST:event_formWindowOpened

    private void btEditActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btEditActionPerformed
        int selectedRow = tbEmployee.getSelectedRow();
        EmployeeGUI emGui = new EmployeeGUI(this);
        if (selectedRow >= 0) {
            employeeToEdit = empList.get(selectedRow);            
            emGui.setLisDepartment(depList);
            emGui.setEmployee(employeeToEdit);
            emGui.setVisible(true);
        }
        
        Employee editedEmployee = emGui.getEmployee();

            
	if (editedEmployee != null) {
            try {
                empBLL.save(editedEmployee);		
                updateTableEmployee(editedEmployee,selectedRow);                                
            } catch (Exception ex) {
                String message = "Could not update Employee. Error:\n" + ex.getMessage();
                JOptionPane.showMessageDialog(this, message, "Error", JOptionPane.ERROR_MESSAGE);			
            }				
        }		
    }//GEN-LAST:event_btEditActionPerformed

    private void btCloseActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btCloseActionPerformed
        dispose();
    }//GEN-LAST:event_btCloseActionPerformed

    private void btDeleteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btDeleteActionPerformed
        Employee employeeToDelete ;
        try {
            int selectedRow = tbEmployee.getSelectedRow();
            if (selectedRow >= 0) {
                employeeToDelete = empList.get(selectedRow);                		
		if (employeeToDelete != null) {
                    String message = String.format( "Do you really want to delete '%s'?", employeeToDelete.getFullName()); 
                    int answer = JOptionPane.showConfirmDialog(this, message, "Confirmation", JOptionPane.YES_NO_OPTION);
                    if (answer == JOptionPane.OK_OPTION) {                                
                        empBLL.delete(employeeToDelete);
                        empList.remove(employeeToDelete);
                        DefaultTableModel model =(DefaultTableModel)tbEmployee.getModel();
                        model.removeRow(selectedRow);
                    }
                }
            }
        } catch (Exception ex) {
            String message = "Could not delete category. Error:\n"+ ex.getMessage();
            JOptionPane.showMessageDialog(this, message, "Error", JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_btDeleteActionPerformed
    

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btClose;
    private javax.swing.JButton btDelete;
    private javax.swing.JButton btEdit;
    private javax.swing.JButton btNew;
    private javax.swing.JButton jButton4;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JToolBar.Separator jSeparator1;
    private javax.swing.JToolBar.Separator jSeparator2;
    private javax.swing.JToolBar.Separator jSeparator3;
    private javax.swing.JToolBar.Separator jSeparator4;
    private javax.swing.JToolBar jToolBar1;
    private javax.swing.JTable tbEmployee;
    // End of variables declaration//GEN-END:variables

}