/*

 *  Derechos de autor: UV-software(c)
 *  @auto: Juan Carlos Domínguez Dominguez
 *  @nombre: Control de academias
 *  @versión 0.3.7
 *  Este producto no puede ser intercambiado bajo ninguna circunstancia
	
 */

package GUI;

import DAO.PlanDeCursoDAO;
import clases.Curso;
import clases.PlanDeCurso;
import clases.Profesor;
import java.util.logging.Level;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Juuan
 */
public class PantallaProfesor extends javax.swing.JFrame {
    private static Profesor profesor;
    private static int posicionCurso;
    private Curso curso = new Curso();
    private PlanDeCursoDAO planDeCursoDAO = new PlanDeCursoDAO();
    private PlanDeCurso planDeCurso = new PlanDeCurso();

    public static int getPosicionCurso() {
        return posicionCurso;
    }

    public static void setPosicionCurso(int posicionCurso) {
        PantallaProfesor.posicionCurso = posicionCurso;
    }

    public static Profesor getProfesor() {
        return profesor;
    }

    public static void setProfesor(Profesor profesor) {
        PantallaProfesor.profesor = profesor;
    }
    
    /**
     * Creates new form PantallaProfesor
     */
    public PantallaProfesor() {
        initComponents();
        habilitarBotones();
    }
    
    public void habilitarBotones(){
        consultarJAButton.setEnabled(false);
        elaborarAPButton.setEnabled(false);
        elaborarPCButton.setEnabled(true);
        visualizarAPButton.setEnabled(false);
        visualizarMJAButton.setEnabled(false);
        visualizarPCButton.setEnabled(true);
        visualizarPTButton.setEnabled(false);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        panel = new javax.swing.JPanel();
        imagenUsuario = new javax.swing.JLabel();
        elaborarAPButton = new javax.swing.JButton();
        elaborarPCButton = new javax.swing.JButton();
        consultarJAButton = new javax.swing.JButton();
        visualizarMJAButton = new javax.swing.JButton();
        visualizarAPButton = new javax.swing.JButton();
        visualizarPCButton = new javax.swing.JButton();
        visualizarPTButton = new javax.swing.JButton();
        seleccionarExperienciaButton = new javax.swing.JButton();
        cerrarSesionButton = new javax.swing.JButton();

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 100, Short.MAX_VALUE)
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 100, Short.MAX_VALUE)
        );

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        imagenUsuario.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));

        elaborarAPButton.setText("Elaborar avance programatico");

        elaborarPCButton.setText("Elaborar plan de curso");
        elaborarPCButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                elaborarPCButtonActionPerformed(evt);
            }
        });

        consultarJAButton.setText("Consultar juntas de academia");

        visualizarMJAButton.setText("Visualizar minuta de junta de academia");

        visualizarAPButton.setText("Visualizar avance programatico");

        visualizarPCButton.setText("Visualizar plan de curso");
        visualizarPCButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                visualizarPCButtonActionPerformed(evt);
            }
        });

        visualizarPTButton.setText("Visualizar plan de trabajo");

        seleccionarExperienciaButton.setText("Seleccionar otra experiencia educativa");
        seleccionarExperienciaButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                seleccionarExperienciaButtonActionPerformed(evt);
            }
        });

        cerrarSesionButton.setText("Cerrar sesión");
        cerrarSesionButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cerrarSesionButtonActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout panelLayout = new javax.swing.GroupLayout(panel);
        panel.setLayout(panelLayout);
        panelLayout.setHorizontalGroup(
            panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelLayout.createSequentialGroup()
                .addGroup(panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(panelLayout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(imagenUsuario, javax.swing.GroupLayout.PREFERRED_SIZE, 129, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(seleccionarExperienciaButton)))
                    .addGroup(panelLayout.createSequentialGroup()
                        .addGap(77, 77, 77)
                        .addComponent(cerrarSesionButton)))
                .addGap(59, 59, 59)
                .addGroup(panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(panelLayout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addGroup(panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addComponent(visualizarMJAButton, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(visualizarAPButton, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(visualizarPCButton, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(visualizarPTButton, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                    .addComponent(consultarJAButton, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(elaborarPCButton, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(elaborarAPButton, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(53, 53, 53))
        );
        panelLayout.setVerticalGroup(
            panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(panelLayout.createSequentialGroup()
                        .addComponent(elaborarAPButton)
                        .addGap(18, 18, 18)
                        .addComponent(elaborarPCButton)
                        .addGap(18, 18, 18)
                        .addComponent(consultarJAButton)
                        .addGap(18, 18, 18)
                        .addComponent(visualizarMJAButton)
                        .addGap(18, 18, 18)
                        .addComponent(visualizarAPButton)
                        .addGap(18, 18, 18)
                        .addGroup(panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(visualizarPCButton)
                            .addComponent(seleccionarExperienciaButton))
                        .addGap(18, 18, 18)
                        .addGroup(panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(visualizarPTButton)
                            .addComponent(cerrarSesionButton)))
                    .addComponent(imagenUsuario, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(28, 28, 28))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(panel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(panel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void elaborarPCButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_elaborarPCButtonActionPerformed
        curso = profesor.getCursos().get(posicionCurso);
        planDeCurso = planDeCursoDAO.obtenerPlanDeCursoPorCurso(curso);
        if(planDeCurso.getEstado().equals("Completo") && curso.getNrc()==planDeCurso.getCurso().getNrc()){
            JOptionPane.showMessageDialog(this, "Ya se elaboro el plan de curso de esté curso.");
        }else{
            ElaborarPlanDeCurso.setProfesor(profesor);
            ElaborarPlanDeCurso.setPosicionCurso(posicionCurso);
            ElaborarPlanDeCurso elaborarPlanDeCurso = new ElaborarPlanDeCurso();
            elaborarPlanDeCurso.setVisible(true);
            dispose();
        }
    }//GEN-LAST:event_elaborarPCButtonActionPerformed

    private void visualizarPCButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_visualizarPCButtonActionPerformed
        curso = profesor.getCursos().get(posicionCurso);
        try {
            planDeCurso = planDeCursoDAO.obtenerPlanDeCursoPorCurso(curso);
            if (planDeCurso.getEstado().equals("Incompleto")) {
                JOptionPane.showMessageDialog(this, "No hay un plan de curso que mostrar.");
            } else {
                VisualizarPlanDeCurso.setProfesor(profesor);
                VisualizarPlanDeCurso.setPosicionCurso(posicionCurso);
                VisualizarPlanDeCurso visualizarPlanDeCurso = new VisualizarPlanDeCurso();
                visualizarPlanDeCurso.setVisible(true);
                dispose();
            }
        } catch (NullPointerException excepcion) {
            java.util.logging.Logger.getLogger(PantallaProfesor.class.getName()).log(Level.SEVERE, null, excepcion);
            JOptionPane.showMessageDialog(this, "No hay un plan de curso que mostrar");
        }
    }//GEN-LAST:event_visualizarPCButtonActionPerformed

    private void seleccionarExperienciaButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_seleccionarExperienciaButtonActionPerformed
        SeleccionarExperienciaEducativa seleccionar = new SeleccionarExperienciaEducativa();
        seleccionar.setVisible(true);
        dispose();
    }//GEN-LAST:event_seleccionarExperienciaButtonActionPerformed

    private void cerrarSesionButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cerrarSesionButtonActionPerformed
        dispose();
    }//GEN-LAST:event_cerrarSesionButtonActionPerformed

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
            java.util.logging.Logger.getLogger(PantallaProfesor.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(PantallaProfesor.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(PantallaProfesor.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(PantallaProfesor.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new PantallaProfesor().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton cerrarSesionButton;
    private javax.swing.JButton consultarJAButton;
    private javax.swing.JButton elaborarAPButton;
    private javax.swing.JButton elaborarPCButton;
    private javax.swing.JLabel imagenUsuario;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel panel;
    private javax.swing.JButton seleccionarExperienciaButton;
    private javax.swing.JButton visualizarAPButton;
    private javax.swing.JButton visualizarMJAButton;
    private javax.swing.JButton visualizarPCButton;
    private javax.swing.JButton visualizarPTButton;
    // End of variables declaration//GEN-END:variables
}
