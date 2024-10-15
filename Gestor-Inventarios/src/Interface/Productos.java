/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package Interface;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author esauj
 */
public class Productos extends javax.swing.JFrame {

    /**
     * Creates new form Productos
     */
    public Productos() {
        initComponents();
        cargarCategorias();
        llenarTablaProductos();
    }

    private void cargarCategorias() {
        File archivoCategorias = new File("categorias.txt");

        try (BufferedReader br = new BufferedReader(new FileReader(archivoCategorias))) {
            String linea;

            // Limpiamos el comboBox antes de llenarlo
            cmbCategoria.removeAllItems();

            // Leer cada línea del archivo
            while ((linea = br.readLine()) != null) {
                // Dividir la línea en los diferentes valores (id y descripción)
                String[] partes = linea.split("\\|");

                // Solo agregamos la descripción de la categoría al comboBox
                if (partes.length >= 2) {
                    cmbCategoria.addItem(partes[1].trim()); // Agregamos el nombre de la categoría
                }
            }

        } catch (IOException e) {
            e.printStackTrace();
        }

        // Añadir el ActionListener después de cargar las categorías
        cmbCategoria.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String categoriaSeleccionada = (String) cmbCategoria.getSelectedItem();
                if (categoriaSeleccionada != null) {
                    cargarSubCategorias(categoriaSeleccionada);
                }
            }
        });

        // Opcional: seleccionar la primera categoría y cargar sus subcategorías
        if (cmbCategoria.getItemCount() > 0) {
            cmbCategoria.setSelectedIndex(0);
            String primeraCategoria = (String) cmbCategoria.getSelectedItem();
            cargarSubCategorias(primeraCategoria);
        }
    }

    private void cargarSubCategorias(String categoriaSeleccionada) {
        File archivoSubCategorias = new File("subCategorias.txt");

        try (BufferedReader br = new BufferedReader(new FileReader(archivoSubCategorias))) {
            String linea;

            // Limpiamos el comboBox de subcategorías antes de llenarlo
            cmbSub.removeAllItems();

            // Leer cada línea del archivo
            while ((linea = br.readLine()) != null) {
                // Dividir la línea en los diferentes valores (id, categoría, subcategoría)
                String[] partes = linea.split("\\|");

                // Verificamos que la línea tenga al menos 3 partes
                if (partes.length >= 3) {
                    String categoria = partes[1].trim(); // Nombre de la categoría
                    String subCategoria = partes[2].trim(); // Nombre de la subcategoría

                    // Si la subcategoría pertenece a la categoría seleccionada, la agregamos
                    if (categoria.equalsIgnoreCase(categoriaSeleccionada)) {
                        cmbSub.addItem(subCategoria);
                    }
                }
            }

        } catch (IOException e) {
            e.printStackTrace();
        }

        // Opcional: seleccionar la primera subcategoría si existe
        if (cmbSub.getItemCount() > 0) {
            cmbSub.setSelectedIndex(0);
        }
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        tblProductos = new javax.swing.JTable();
        jToggleButton1 = new javax.swing.JToggleButton();
        btnAgregar = new javax.swing.JToggleButton();
        btnEditar = new javax.swing.JToggleButton();
        btnEspecificaciones = new javax.swing.JToggleButton();
        btnEliminar = new javax.swing.JToggleButton();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        txtNombre = new javax.swing.JTextField();
        txtDescripcion = new javax.swing.JTextField();
        cmbCategoria = new javax.swing.JComboBox<>();
        cmbSub = new javax.swing.JComboBox<>();
        txtPrecio = new javax.swing.JTextField();
        txtStock = new javax.swing.JTextField();
        txtId = new javax.swing.JTextField();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        tblProductos.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null}
            },
            new String [] {
                "Id", "Nombre", "Descripcion", "Categoria", "Sub Categoria", "Precio Venta", "Stock"
            }
        ));
        tblProductos.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblProductosMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tblProductos);

        jToggleButton1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Interface/resources/imgs/exit.png"))); // NOI18N
        jToggleButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jToggleButton1ActionPerformed(evt);
            }
        });

        btnAgregar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Interface/resources/imgs/mas.png"))); // NOI18N
        btnAgregar.setText("AGREGAR");
        btnAgregar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAgregarActionPerformed(evt);
            }
        });

        btnEditar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Interface/resources/imgs/lapiz.png"))); // NOI18N
        btnEditar.setText("EDITAR");

        btnEspecificaciones.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Interface/resources/imgs/especificaciones.png"))); // NOI18N
        btnEspecificaciones.setText("ESPECIFICACIONES");

        btnEliminar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Interface/resources/imgs/borrar.png"))); // NOI18N
        btnEliminar.setText("ELIMINAR");
        btnEliminar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEliminarActionPerformed(evt);
            }
        });

        jLabel1.setText("Productos");

        jLabel2.setText("Nombre : ");

        jLabel3.setText("Categoria :");

        jLabel4.setText("Sub Categoria :");

        jLabel5.setText("Descripción :");

        jLabel6.setText("Precio venta :");

        jLabel7.setText("Stock :");

        cmbCategoria.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        cmbSub.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        txtId.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtIdActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(65, 65, 65)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jToggleButton1)
                        .addGap(20, 20, 20))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 696, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel5)
                                    .addComponent(jLabel2)
                                    .addComponent(txtId, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(18, 18, 18)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(txtNombre, javax.swing.GroupLayout.DEFAULT_SIZE, 148, Short.MAX_VALUE)
                                    .addComponent(txtDescripcion))
                                .addGap(18, 18, 18)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel4)
                                    .addComponent(jLabel3))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(cmbCategoria, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(cmbSub, javax.swing.GroupLayout.PREFERRED_SIZE, 154, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(18, 18, 18)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel7)
                                    .addComponent(jLabel6))
                                .addGap(18, 18, 18)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(txtStock, javax.swing.GroupLayout.DEFAULT_SIZE, 69, Short.MAX_VALUE)
                                    .addComponent(txtPrecio))))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 28, Short.MAX_VALUE)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(btnEliminar, javax.swing.GroupLayout.PREFERRED_SIZE, 167, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btnEspecificaciones, javax.swing.GroupLayout.PREFERRED_SIZE, 171, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btnEditar, javax.swing.GroupLayout.PREFERRED_SIZE, 170, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btnAgregar, javax.swing.GroupLayout.PREFERRED_SIZE, 170, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(16, 16, 16))))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jToggleButton1)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addGap(18, 18, 18)
                        .addComponent(txtId, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel2)
                            .addComponent(jLabel6)
                            .addComponent(txtNombre, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel3)
                            .addComponent(cmbCategoria, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtPrecio, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(23, 23, 23)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel5)
                            .addComponent(jLabel7)
                            .addComponent(txtDescripcion, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel4)
                            .addComponent(cmbSub, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtStock, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(21, 21, 21)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 291, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(btnAgregar)
                        .addGap(12, 12, 12)
                        .addComponent(btnEditar)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(btnEspecificaciones)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(btnEliminar)))
                .addGap(64, 64, 64))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jToggleButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jToggleButton1ActionPerformed
        this.dispose();
        Menu menu = new Menu();
        menu.setVisible(true);
    }//GEN-LAST:event_jToggleButton1ActionPerformed

    private void btnAgregarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAgregarActionPerformed
        try {
            File archivo = new File("productos.txt");

            // Generar automáticamente el nuevo ID
            String id = gestor.inventarios.Productos.generarNuevoId(archivo);
            String nombre = txtNombre.getText().trim();
            String descripcion = txtDescripcion.getText().trim();
            String categoria = cmbCategoria.getSelectedItem().toString();
            String subCategoria = cmbSub.getSelectedItem().toString();
            double precio = Double.parseDouble(txtPrecio.getText().trim());
            int stock = Integer.parseInt(txtStock.getText().trim());

            // Verifica que no haya campos vacíos
            if (nombre.isEmpty() || descripcion.isEmpty() || txtPrecio.getText().isEmpty() || txtStock.getText().isEmpty()) {
                JOptionPane.showMessageDialog(this, "Por favor, complete todos los campos.", "Error", JOptionPane.WARNING_MESSAGE);
                return;
            }

            // Agregar el producto al archivo
            gestor.inventarios.Productos.agregarProducto(id, nombre, descripcion, categoria, subCategoria, precio, stock);

            // Limpiar los campos de texto y seleccionar las opciones por defecto
            txtDescripcion.setText("");
            txtNombre.setText("");
            txtPrecio.setText("");
            txtStock.setText("");
            cmbCategoria.setSelectedIndex(0);
            cmbCategoria.setSelectedIndex(0);

            // Verificar si cmbSub tiene elementos antes de seleccionar
            if (cmbSub.getItemCount() > 0) {
                cmbSub.setSelectedIndex(0);
            } else {
                // Opcional: deshabilitar cmbSub si no hay subcategorías
                cmbSub.setSelectedIndex(-1); // No selección
                cmbSub.setEnabled(false);
                JOptionPane.showMessageDialog(this, "No hay subcategorías disponibles para la categoría seleccionada.", "Sin Subcategorías", JOptionPane.INFORMATION_MESSAGE);
            }

            // Actualizar la tabla con los productos
            llenarTablaProductos();
            JOptionPane.showMessageDialog(this, "Producto agregado correctamente.");
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(this, "Precio y Stock deben ser números válidos.", "Error", JOptionPane.ERROR_MESSAGE);
        } catch (Exception e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(this, "Ocurrió un error al agregar el producto.", "Error", JOptionPane.ERROR_MESSAGE);
        }

    }//GEN-LAST:event_btnAgregarActionPerformed

    private void tblProductosMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblProductosMouseClicked
        int filaSeleccionada = tblProductos.rowAtPoint(evt.getPoint());  // Obtiene la fila seleccionada a partir del punto del clic

        // Verifica que se hizo clic dentro de una fila válida
        if (filaSeleccionada != -1) {
            // Obtener los datos de la fila seleccionada (suponiendo que las columnas están en el orden correcto)
            String id = tblProductos.getValueAt(filaSeleccionada, 0).toString();  // ID del usuario (columna 0)
            String nombre = tblProductos.getValueAt(filaSeleccionada, 1).toString();  // Nombre de usuario (columna 1)
            String descripcion = tblProductos.getValueAt(filaSeleccionada, 2).toString();  // Contraseña (columna 2)
            String categoria = tblProductos.getValueAt(filaSeleccionada, 3).toString();  // Rol (columna 3)
            String sub = tblProductos.getValueAt(filaSeleccionada, 4).toString();  // Rol (columna 3)
            double precio = Double.parseDouble(tblProductos.getValueAt(filaSeleccionada, 5).toString());
            int stock = Integer.parseInt(tblProductos.getValueAt(filaSeleccionada, 6).toString());

            // Llenar los campos con los valores obtenidos
            txtId.setText(id);
            txtNombre.setText(nombre);
            txtDescripcion.setText(descripcion);
            cmbCategoria.setSelectedItem(categoria);
            cmbSub.setSelectedItem(sub);
            txtStock.setText(String.valueOf(stock));
            txtPrecio.setText(String.valueOf(precio));

        } else {
            // Si no se selecciona ninguna fila válida, limpia los campos
            limpiarCampos();
        }


    }//GEN-LAST:event_tblProductosMouseClicked

    private void txtIdActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtIdActionPerformed

    }//GEN-LAST:event_txtIdActionPerformed

    private void btnEliminarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEliminarActionPerformed
        int filaSeleccionada = tblProductos.getSelectedRow();

        // Verifica si se ha seleccionado una fila
        if (filaSeleccionada != -1) {
            // Obtiene el ID del usuario en la columna 0 (primera columna de la tabla)
            String id = tblProductos.getValueAt(filaSeleccionada, 0).toString();

            // Llama al método para eliminar el usuario del archivo
            gestor.inventarios.Productos.eliminarProducto(id);

            // Actualiza la tabla después de eliminar el usuario
            llenarTablaProductos();
            limpiarCampos();
        } else {
            // Muestra un mensaje de error si no se seleccionó ninguna fila
            javax.swing.JOptionPane.showMessageDialog(this, "Por favor seleccione un producto para eliminar.");
        }
    }//GEN-LAST:event_btnEliminarActionPerformed

    private void limpiarCampos() {
        txtId.setText("");
        txtNombre.setText("");
        txtDescripcion.setText("");
        txtPrecio.setText("");
        txtStock.setText("");
        cmbSub.setSelectedIndex(0);
        cmbCategoria.setSelectedIndex(0);
    }

    private void llenarTablaProductos() {
        // Definimos el modelo de la tabla
        txtId.setVisible(false);
        DefaultTableModel model = (DefaultTableModel) tblProductos.getModel();

        // Limpiamos la tabla antes de llenarla
        model.setRowCount(0);

        File archivo = new File("productos.txt");

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
            java.util.logging.Logger.getLogger(Productos.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Productos.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Productos.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Productos.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Productos().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JToggleButton btnAgregar;
    private javax.swing.JToggleButton btnEditar;
    private javax.swing.JToggleButton btnEliminar;
    private javax.swing.JToggleButton btnEspecificaciones;
    private javax.swing.JComboBox<String> cmbCategoria;
    private javax.swing.JComboBox<String> cmbSub;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JToggleButton jToggleButton1;
    private javax.swing.JTable tblProductos;
    private javax.swing.JTextField txtDescripcion;
    private javax.swing.JTextField txtId;
    private javax.swing.JTextField txtNombre;
    private javax.swing.JTextField txtPrecio;
    private javax.swing.JTextField txtStock;
    // End of variables declaration//GEN-END:variables
}
