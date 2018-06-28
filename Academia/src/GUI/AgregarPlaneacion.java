/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI;

import clases.Tema;
import clases.Unidad;
import java.sql.Date;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import javax.swing.JButton;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Juuan
 */
public class AgregarPlaneacion extends javax.swing.JFrame {
    public static ArrayList<Tema> temas = new ArrayList<Tema>();
    public static DefaultTableModel modelo;

    public static DefaultTableModel getModelo() {
        return modelo;
    }

    public static void setModelo(DefaultTableModel modelo) {
        AgregarPlaneacion.modelo = modelo;
    }

    public static JButton getEliminarButton() {
        return eliminarButton;
    }

    public static void setEliminarButton(JButton eliminarButton) {
        AgregarPlaneacion.eliminarButton = eliminarButton;
    }

    public static JTable getTemasTable() {
        return temasTable;
    }

    public static void setTemasTable(JTable temasTable) {
        AgregarPlaneacion.temasTable = temasTable;
    }
    
    
    public static ArrayList<Tema> getTemas() {
        return temas;
    }

    public static void setTemas(ArrayList<Tema> temas) {
        AgregarPlaneacion.temas = temas;
        modelo = (DefaultTableModel) AgregarPlaneacion.temasTable.getModel();
    }
    
    /**
     * Creates new form AgregarPlaneacion
     */
    public AgregarPlaneacion() {
        initComponents();
        eliminarButton.setEnabled(false);
    }
    
    public boolean validarCampos(){
        if(numeroUnidadIn.getText() == "" || nombreUnidadIn.getText() == "" || tareasYPracticasIn.getText()=="" || tecnicaDidacticaIn.getText() == "" || fechaIn.getText() == "" || temas.size() == 0){
            return false;
        }
        return true;
    }
    
    public boolean validarFecha(String fecha){
        SimpleDateFormat estructura = new SimpleDateFormat("yyyy-mm-dd");
        estructura.setLenient(false);
        try{
            estructura.parse(fecha);
        }catch(ParseException excepcion){
            
            return false;
        }
        return true;
    }
    
    public static void cargarTablaTemas(){
        for(int i = 0; i<temas.size(); i++){
            temasTable.setValueAt(temas.get(i).getNombre(), i, 0);
        }
    }
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        panel = new javax.swing.JPanel();
        planeacionText = new javax.swing.JLabel();
        nombreUnidadText = new javax.swing.JLabel();
        temasText = new javax.swing.JLabel();
        fechasText = new javax.swing.JLabel();
        tareasYPracticasText = new javax.swing.JLabel();
        tecnicaDidacticaText = new javax.swing.JLabel();
        nombreUnidadIn = new javax.swing.JTextField();
        fechaIn = new javax.swing.JTextField();
        tareasYPracticasIn = new javax.swing.JTextField();
        tecnicaDidacticaIn = new javax.swing.JTextField();
        numeroUnidadText = new javax.swing.JLabel();
        numeroUnidadIn = new javax.swing.JTextField();
        aceptarButton = new javax.swing.JButton();
        cancelarButton = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        temasTable = new javax.swing.JTable();
        agregarButton = new javax.swing.JButton();
        eliminarButton = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        planeacionText.setText("Planeacion: ");

        nombreUnidadText.setText("Nombre de Unidad: ");

        temasText.setText("Temas: ");

        fechasText.setText("Fechas (aaaa-mm-dd): ");

        tareasYPracticasText.setText("Tareas y prácticas: ");

        tecnicaDidacticaText.setText("Técnica didactica: ");

        nombreUnidadIn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                nombreUnidadInActionPerformed(evt);
            }
        });
        nombreUnidadIn.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                nombreUnidadInKeyTyped(evt);
            }
        });

        fechaIn.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                fechaInKeyTyped(evt);
            }
        });

        tareasYPracticasIn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tareasYPracticasInActionPerformed(evt);
            }
        });
        tareasYPracticasIn.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                tareasYPracticasInKeyTyped(evt);
            }
        });

        tecnicaDidacticaIn.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                tecnicaDidacticaInKeyTyped(evt);
            }
        });

        numeroUnidadText.setText("Número de unidad: ");

        numeroUnidadIn.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                numeroUnidadInKeyTyped(evt);
            }
        });

        aceptarButton.setText("Aceptar");
        aceptarButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                aceptarButtonActionPerformed(evt);
            }
        });

        cancelarButton.setText("Cancelar");
        cancelarButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cancelarButtonActionPerformed(evt);
            }
        });

        temasTable.setAutoCreateRowSorter(true);
        temasTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Nombre"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class
            };
            boolean[] canEdit = new boolean [] {
                false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane1.setViewportView(temasTable);

        agregarButton.setText("Agregar Tema");
        agregarButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                agregarButtonActionPerformed(evt);
            }
        });

        eliminarButton.setText("Eliminar Tema");
        eliminarButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                eliminarButtonActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout panelLayout = new javax.swing.GroupLayout(panel);
        panel.setLayout(panelLayout);
        panelLayout.setHorizontalGroup(
            panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(panelLayout.createSequentialGroup()
                        .addComponent(tareasYPracticasText)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(tareasYPracticasIn, javax.swing.GroupLayout.PREFERRED_SIZE, 398, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(panelLayout.createSequentialGroup()
                        .addComponent(tecnicaDidacticaText)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(tecnicaDidacticaIn, javax.swing.GroupLayout.PREFERRED_SIZE, 399, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(0, 58, Short.MAX_VALUE))
            .addGroup(panelLayout.createSequentialGroup()
                .addGap(122, 122, 122)
                .addComponent(aceptarButton)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(cancelarButton)
                .addGap(107, 107, 107))
            .addGroup(panelLayout.createSequentialGroup()
                .addGroup(panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(panelLayout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 507, Short.MAX_VALUE)
                            .addGroup(panelLayout.createSequentialGroup()
                                .addComponent(fechasText)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(fechaIn, javax.swing.GroupLayout.PREFERRED_SIZE, 147, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelLayout.createSequentialGroup()
                                .addComponent(nombreUnidadText)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(nombreUnidadIn))
                            .addGroup(panelLayout.createSequentialGroup()
                                .addComponent(temasText)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(agregarButton)
                                .addGap(18, 18, 18)
                                .addComponent(eliminarButton))
                            .addGroup(panelLayout.createSequentialGroup()
                                .addComponent(numeroUnidadText)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(numeroUnidadIn, javax.swing.GroupLayout.PREFERRED_SIZE, 136, javax.swing.GroupLayout.PREFERRED_SIZE))))
                    .addGroup(panelLayout.createSequentialGroup()
                        .addGap(252, 252, 252)
                        .addComponent(planeacionText)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        panelLayout.setVerticalGroup(
            panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelLayout.createSequentialGroup()
                .addGap(17, 17, 17)
                .addComponent(planeacionText)
                .addGap(18, 18, 18)
                .addGroup(panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(numeroUnidadText)
                    .addComponent(numeroUnidadIn, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(nombreUnidadText)
                    .addComponent(nombreUnidadIn, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(temasText)
                    .addComponent(agregarButton)
                    .addComponent(eliminarButton))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 88, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(fechasText)
                    .addComponent(fechaIn, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(tareasYPracticasText)
                    .addComponent(tareasYPracticasIn, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(tecnicaDidacticaText)
                    .addComponent(tecnicaDidacticaIn, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(27, 27, 27)
                .addGroup(panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(aceptarButton)
                    .addComponent(cancelarButton))
                .addContainerGap(22, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(panel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(panel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void nombreUnidadInActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_nombreUnidadInActionPerformed
        
    }//GEN-LAST:event_nombreUnidadInActionPerformed

    private void aceptarButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_aceptarButtonActionPerformed
        if(!validarCampos() || !validarFecha(fechaIn.getText())){
            JOptionPane.showMessageDialog(this, "Se deben llenar todos los campos o la fecha esta ingresada incorrectamente");
        }else{
            Unidad unidad = new Unidad();
            unidad.setNumeroUnidad(numeroUnidadIn.getText());
            unidad.setNombre(nombreUnidadIn.getText());
            unidad.setTemas(temas);
            unidad.setFecha(Date.valueOf(fechaIn.getText()));
            unidad.setTareasYPracticas(tareasYPracticasIn.getText());
            unidad.setTecnicaDidactica(tecnicaDidacticaIn.getText());
            ElaborarPlanDeCurso.unidades.add(unidad);
            ElaborarPlanDeCurso.modelo = (DefaultTableModel) ElaborarPlanDeCurso.planeacionTable.getModel();
            Object nuevo[]= {""};
            ElaborarPlanDeCurso.modelo.addRow(nuevo);
            ElaborarPlanDeCurso.cargarTablaUnidades();
            ElaborarPlanDeCurso.getEliminarPlaneacionButton().setEnabled(true);
            dispose();
        }
    }//GEN-LAST:event_aceptarButtonActionPerformed

    private void tareasYPracticasInActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tareasYPracticasInActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_tareasYPracticasInActionPerformed

    private void numeroUnidadInKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_numeroUnidadInKeyTyped
        char caracteres= evt.getKeyChar();
        if (caracteres<'0'||caracteres>'9') evt.consume();
        if(numeroUnidadIn.getText().length() >= 11){
            evt.consume();
        }
    }//GEN-LAST:event_numeroUnidadInKeyTyped

    private void nombreUnidadInKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_nombreUnidadInKeyTyped
        if(nombreUnidadIn.getText().length() >= 300){
            evt.consume();
        }
    }//GEN-LAST:event_nombreUnidadInKeyTyped

    private void tareasYPracticasInKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_tareasYPracticasInKeyTyped
        if (tareasYPracticasIn.getText().length()>= 1000){
            evt.consume();
        }
    }//GEN-LAST:event_tareasYPracticasInKeyTyped

    private void tecnicaDidacticaInKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_tecnicaDidacticaInKeyTyped
        if(tecnicaDidacticaIn.getText().length() >= 500){
            evt.consume();
        }
    }//GEN-LAST:event_tecnicaDidacticaInKeyTyped

    private void fechaInKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_fechaInKeyTyped
        char caracteres= evt.getKeyChar();
        if ((caracteres<'0'||caracteres>'9') && caracteres != '-') evt.consume();
        if(fechaIn.getText().length() >= 10){
            evt.consume();
        }
    }//GEN-LAST:event_fechaInKeyTyped

    private void cancelarButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cancelarButtonActionPerformed
        dispose();
    }//GEN-LAST:event_cancelarButtonActionPerformed

    private void agregarButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_agregarButtonActionPerformed
        AgregarTema agregarTema = new AgregarTema();
        agregarTema.setVisible(true);
    }//GEN-LAST:event_agregarButtonActionPerformed

    private void eliminarButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_eliminarButtonActionPerformed
        if (modelo.getRowCount()-1 >= 0){
            eliminarButton.setEnabled(true);
            modelo.removeRow(modelo.getRowCount()-1);
            temas.remove(temas.get(temas.size()-1));
        }
        if (modelo.getRowCount()-1 <= 0){
            eliminarButton.setEnabled(false);
        }
    }//GEN-LAST:event_eliminarButtonActionPerformed

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
            java.util.logging.Logger.getLogger(AgregarPlaneacion.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(AgregarPlaneacion.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(AgregarPlaneacion.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(AgregarPlaneacion.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new AgregarPlaneacion().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton aceptarButton;
    private javax.swing.JButton agregarButton;
    private javax.swing.JButton cancelarButton;
    private static javax.swing.JButton eliminarButton;
    private javax.swing.JTextField fechaIn;
    private javax.swing.JLabel fechasText;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextField nombreUnidadIn;
    private javax.swing.JLabel nombreUnidadText;
    private javax.swing.JTextField numeroUnidadIn;
    private javax.swing.JLabel numeroUnidadText;
    private javax.swing.JPanel panel;
    private javax.swing.JLabel planeacionText;
    private javax.swing.JTextField tareasYPracticasIn;
    private javax.swing.JLabel tareasYPracticasText;
    private javax.swing.JTextField tecnicaDidacticaIn;
    private javax.swing.JLabel tecnicaDidacticaText;
    public static javax.swing.JTable temasTable;
    private javax.swing.JLabel temasText;
    // End of variables declaration//GEN-END:variables
}
