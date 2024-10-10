/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package Interface;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author esauj
 */
public class Users extends javax.swing.JFrame {

    /**
     * Creates new form Users
     */
    public Users() {
        initComponents();
        llenarTablaUsuarios();
        cargarRolesDesdeArchivo();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        tlbUsers = new javax.swing.JTable();
        btnAddUser = new javax.swing.JButton();
        btnDeleteUser = new javax.swing.JButton();
        btnEditUser = new javax.swing.JButton();
        btnExit = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        txtUsuario = new javax.swing.JTextField();
        txtContraseña = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        cmbRoles = new javax.swing.JComboBox<>();
        jLabel5 = new javax.swing.JLabel();
        txtId = new javax.swing.JTextField();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        tlbUsers.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Id", "Usuario", "Contraseña", "Rol"
            }
        ));
        tlbUsers.setCellSelectionEnabled(true);
        tlbUsers.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tlbUsersMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tlbUsers);

        btnAddUser.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Interface/resources/imgs/agregar-usuario.png"))); // NOI18N
        btnAddUser.setText("AGREGAR");
        btnAddUser.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAddUserActionPerformed(evt);
            }
        });

        btnDeleteUser.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Interface/resources/imgs/delete.png"))); // NOI18N
        btnDeleteUser.setText("ELIMINAR");
        btnDeleteUser.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDeleteUserActionPerformed(evt);
            }
        });

        btnEditUser.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Interface/resources/imgs/editar-usuario.png"))); // NOI18N
        btnEditUser.setText("EDITAR");
        btnEditUser.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEditUserActionPerformed(evt);
            }
        });

        btnExit.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Interface/resources/imgs/exit.png"))); // NOI18N
        btnExit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnExitActionPerformed(evt);
            }
        });

        jLabel1.setFont(new java.awt.Font("Segoe UI Historic", 0, 12)); // NOI18N
        jLabel1.setText("USUARIOS");

        jLabel3.setText("Usuario :");

        jLabel4.setText("Contraseña :");

        cmbRoles.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        cmbRoles.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cmbRolesActionPerformed(evt);
            }
        });

        jLabel5.setText("Rol :");

        txtId.setEditable(false);
        txtId.setEnabled(false);
        txtId.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtIdActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(54, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 625, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(42, 42, 42)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(btnAddUser, javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(btnDeleteUser, javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(btnEditUser, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 151, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addComponent(txtId)
                            .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(btnExit, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 47, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(txtUsuario, javax.swing.GroupLayout.PREFERRED_SIZE, 139, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel3))
                                .addGap(30, 30, 30)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(txtContraseña, javax.swing.GroupLayout.PREFERRED_SIZE, 139, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel4))
                                .addGap(18, 18, 18)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel5)
                                    .addComponent(cmbRoles, javax.swing.GroupLayout.PREFERRED_SIZE, 142, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(199, 199, 199)))))
                .addGap(25, 25, 25))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(15, 15, 15)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btnExit)
                    .addComponent(jLabel1))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 46, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(jLabel4)
                    .addComponent(jLabel5))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtUsuario, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtContraseña, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(cmbRoles, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtId, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(btnAddUser)
                        .addGap(40, 40, 40)
                        .addComponent(btnEditUser)
                        .addGap(39, 39, 39)
                        .addComponent(btnDeleteUser))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(24, 24, 24)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 227, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(75, 75, 75))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnAddUserActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAddUserActionPerformed
        File archivo = new File("users.txt");

        // Generar automáticamente el nuevo ID
        String id = gestor.inventarios.Users.generarNuevoId(archivo);
        String usuario = txtUsuario.getText();
        String contraseña = txtContraseña.getText();
        String rol = cmbRoles.getSelectedItem().toString();

        // Agregar el usuario al archivo
        gestor.inventarios.Users.agregarUsuario(id, usuario, contraseña, rol);
        txtUsuario.setText("");             // Limpiar campo de usuario
        txtContraseña.setText("");          // Limpiar campo de contraseña
        cmbRoles.setSelectedIndex(0);

        llenarTablaUsuarios(); // Actualizar la tabla después de agregar el nuevo usuario
    }//GEN-LAST:event_btnAddUserActionPerformed

    private void btnDeleteUserActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDeleteUserActionPerformed
        // TODO add your handling code here:

        // Obtiene la fila seleccionada de la tabla
        int filaSeleccionada = tlbUsers.getSelectedRow();

        // Verifica si se ha seleccionado una fila
        if (filaSeleccionada != -1) {
            // Obtiene el ID del usuario en la columna 0 (primera columna de la tabla)
            String id = tlbUsers.getValueAt(filaSeleccionada, 0).toString();

            // Llama al método para eliminar el usuario del archivo
            gestor.inventarios.Users.eliminarUsuario(id);

            // Actualiza la tabla después de eliminar el usuario
            llenarTablaUsuarios();
        } else {
            // Muestra un mensaje de error si no se seleccionó ninguna fila
            javax.swing.JOptionPane.showMessageDialog(this, "Por favor seleccione un usuario para eliminar.");
        }

    }//GEN-LAST:event_btnDeleteUserActionPerformed

    private void cmbRolesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cmbRolesActionPerformed

    }//GEN-LAST:event_cmbRolesActionPerformed

    private void btnExitActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnExitActionPerformed
        this.dispose();

        // Abrir la ventana Menu
        Menu menu = new Menu();  // Crear una instancia de la ventana Menu
        menu.setVisible(true);
    }//GEN-LAST:event_btnExitActionPerformed

    private void btnEditUserActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEditUserActionPerformed
        if (txtId.getText().isEmpty()) {
            JOptionPane.showMessageDialog(this, "Por favor, selecciona un registro para editar.", "Error", JOptionPane.ERROR_MESSAGE);
            return;  // Salir si no hay ningún registro seleccionado
        }

        // Si el campo no está vacío, entonces continúa
        String idEditar = txtId.getText();  // Obtener el ID a editar

        // Obtener los nuevos valores de los campos de texto
        String nuevoUsuario = txtUsuario.getText();
        String nuevaContraseña = txtContraseña.getText();
        String nuevoRol = cmbRoles.getSelectedItem().toString();

        // Llamar al método para editar el usuario
        gestor.inventarios.Users.editarUsuario(idEditar, nuevoUsuario, nuevaContraseña, nuevoRol);

        // Limpiar los campos
        txtId.setText("");
        txtUsuario.setText("");
        txtContraseña.setText("");
        cmbRoles.setSelectedIndex(0);

        // Actualizar la tabla
        llenarTablaUsuarios();
    }//GEN-LAST:event_btnEditUserActionPerformed

    private void tlbUsersMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tlbUsersMouseClicked
        int filaSeleccionada = tlbUsers.rowAtPoint(evt.getPoint());  // Obtiene la fila seleccionada a partir del punto del clic

        // Verifica que se hizo clic dentro de una fila válida
        if (filaSeleccionada != -1) {
            // Obtener los datos de la fila seleccionada (suponiendo que las columnas están en el orden correcto)
            String id = tlbUsers.getValueAt(filaSeleccionada, 0).toString();  // ID del usuario (columna 0)
            String usuario = tlbUsers.getValueAt(filaSeleccionada, 1).toString();  // Nombre de usuario (columna 1)
            String contraseña = tlbUsers.getValueAt(filaSeleccionada, 2).toString();  // Contraseña (columna 2)
            String rol = tlbUsers.getValueAt(filaSeleccionada, 3).toString();  // Rol (columna 3)

            // Llenar los campos con los valores obtenidos
            txtId.setText(id);
            txtUsuario.setText(usuario);
            txtContraseña.setText(contraseña);
            cmbRoles.setSelectedItem(rol);  // Ajusta el comboBox al rol seleccionado
        } else {
            // Si no se selecciona ninguna fila válida, limpia los campos
            limpiarCampos();
        }
    }//GEN-LAST:event_tlbUsersMouseClicked

    private void limpiarCampos() {
        txtId.setText("");
        txtUsuario.setText("");
        txtContraseña.setText("");
        cmbRoles.setSelectedIndex(0);  // Restablece el ComboBox al primer valor
    }

    private void txtIdActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtIdActionPerformed
        txtId.setVisible(true);
    }//GEN-LAST:event_txtIdActionPerformed

    private void cargarRolesDesdeArchivo() {
        File archivoRoles = new File("Roles.txt");

        try (BufferedReader br = new BufferedReader(new FileReader(archivoRoles))) {
            String linea;

            // Limpiamos el comboBox antes de llenarlo
            cmbRoles.removeAllItems();

            // Leer cada línea del archivo
            while ((linea = br.readLine()) != null) {
                // Dividir la línea en los diferentes valores (id y descripción)
                String[] partes = linea.split("\\|");

                // Solo agregamos la descripción del rol al comboBox
                if (partes.length >= 2) {
                    cmbRoles.addItem(partes[1]); // Agregamos el nombre del rol
                }
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(Users.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Users.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Users.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Users.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Users().setVisible(true);
            }
        });
    }

    private void llenarTablaUsuarios() {
        // Definimos el modelo de la tabla
        DefaultTableModel model = (DefaultTableModel) tlbUsers.getModel();

        // Limpiamos la tabla antes de llenarla
        model.setRowCount(0);

        File archivo = new File("users.txt");

        try (BufferedReader br = new BufferedReader(new FileReader(archivo))) {
            String linea;
            // Leer cada línea del archivo
            while ((linea = br.readLine()) != null) {
                // Dividir la línea en los diferentes valores
                String[] partes = linea.split("\\|");
                // Agregar los valores como una nueva fila en la tabla
                model.addRow(partes);
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAddUser;
    private javax.swing.JButton btnDeleteUser;
    private javax.swing.JButton btnEditUser;
    private javax.swing.JButton btnExit;
    private javax.swing.JComboBox<String> cmbRoles;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable tlbUsers;
    private javax.swing.JTextField txtContraseña;
    private javax.swing.JTextField txtId;
    private javax.swing.JTextField txtUsuario;
    // End of variables declaration//GEN-END:variables
}
