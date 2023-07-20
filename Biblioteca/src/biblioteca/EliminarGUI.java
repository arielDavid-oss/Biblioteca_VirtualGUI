/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package biblioteca;

import java.io.File;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author ariel
 */
public class EliminarGUI extends javax.swing.JFrame {

    private RandomAccessFile raf;

    /**
     * Creates new form EliminarGUI
     */
    public EliminarGUI() {
        initComponents();

        try {
            // Abrir el archivo para lectura/escritura
            File file = new File("biblioteca.dat");
            raf = new RandomAccessFile(file, "rw");
        } catch (IOException ex) {
            Logger.getLogger(EliminarGUI.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        lblIndicacion = new javax.swing.JLabel();
        txtIndice = new javax.swing.JTextField();
        btnAceptar = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Eliminar Libros");
        setLocation(new java.awt.Point(700, 300));
        setMinimumSize(null);

        lblIndicacion.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N
        lblIndicacion.setText("Ingrese el numero de indice para eliminar");

        txtIndice.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N

        btnAceptar.setText("Aceptar");
        btnAceptar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAceptarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(29, 29, 29)
                .addComponent(lblIndicacion)
                .addGap(18, 18, 18))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(btnAceptar)
                        .addGap(161, 161, 161))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(txtIndice, javax.swing.GroupLayout.PREFERRED_SIZE, 52, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(177, 177, 177))))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(lblIndicacion)
                .addGap(32, 32, 32)
                .addComponent(txtIndice, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(28, 28, 28)
                .addComponent(btnAceptar)
                .addGap(64, 64, 64))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnAceptarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAceptarActionPerformed
        // TODO add your handling code here:
        try {
            // Obtener el índice ingresado por el usuario
            int indice = Integer.parseInt(txtIndice.getText());
            // Verificar si el índice es válido
            if (indice >= 0) {
                // Calcular la posición en el archivo
                long posicion = indice * Libro.SIZE;
                // Verificar si la posición está dentro del archivo
                if (posicion < raf.length()) {
                    // Mover el puntero de lectura/escritura a la posición correspondiente
                    raf.seek(posicion);
                    // Borrar el registro sobrescribiéndolo con ceros
                    byte[] ceros = new byte[Libro.SIZE];
                    raf.write(ceros);
                    // Mostrar mensaje de éxito
                    javax.swing.JOptionPane.showMessageDialog(this, "Registro eliminado correctamente.");
                } else {
                    // Mostrar mensaje de error si el índice está fuera de rango
                    javax.swing.JOptionPane.showMessageDialog(this, "Índice fuera de rango.");
                }
            } else {
                // Mostrar mensaje de error si el índice es negativo
                javax.swing.JOptionPane.showMessageDialog(this, "Índice inválido.");
            }
        } catch (IOException ex) {
            Logger.getLogger(EliminarGUI.class.getName()).log(Level.SEVERE, null, ex);
        }

    }//GEN-LAST:event_btnAceptarActionPerformed

    /**
     * @param args the command line arguments
     */

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAceptar;
    private javax.swing.JLabel lblIndicacion;
    private javax.swing.JTextField txtIndice;
    // End of variables declaration//GEN-END:variables
}
