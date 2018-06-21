/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI;

import clases.Profesor;

/**
 *
 * @author Juuan
 */
public class ElaborarPlanDeCurso extends javax.swing.JFrame {
    private static Profesor profesor;
    private static int posicionCurso;

    public static int getPosicionCurso() {
        return posicionCurso;
    }

    public static void setPosicionCurso(int posicionCurso) {
        ElaborarPlanDeCurso.posicionCurso = posicionCurso;
    }

    public static Profesor getProfesor() {
        return profesor;
    }

    public static void setProfesor(Profesor profesor) {
        ElaborarPlanDeCurso.profesor = profesor;
    }
    
    /**
     * Creates new form ElaborarPlanDeCurso
     */
    public ElaborarPlanDeCurso() {
        initComponents();
        mostrarDatosPrincipales();
        
    }
    
    public void mostrarDatosPrincipales(){
        claveNrcOut.setText(Integer.toString(profesor.getCursos().get(posicionCurso).getNrc()));
        experienciaEducativaOut.setText(profesor.getCursos().get(posicionCurso).getExperienciaEducativa().getNombreEE());
        
        bloqueOut.setText(Integer.toString(profesor.getCursos().get(posicionCurso).getBloque()));
        seccionOut.setText(Integer.toString(profesor.getCursos().get(posicionCurso).getSeccion()));
        academicoOut.setText(profesor.getNombre());
        periodoOut.setText(profesor.getCursos().get(posicionCurso).getPeriodo().getNombrePeriodo());
    }
    public void guardarPlaneacion(){
        
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
        claveNrcText = new javax.swing.JLabel();
        academicoText = new javax.swing.JLabel();
        experienciaEducativaText = new javax.swing.JLabel();
        programaEducativoText = new javax.swing.JLabel();
        bloqueText = new javax.swing.JLabel();
        seccionText = new javax.swing.JLabel();
        periodoText = new javax.swing.JLabel();
        objetivoGeneralText = new javax.swing.JLabel();
        objetivoGeneralIn = new javax.swing.JTextField();
        planeacionText = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        planeacionTable = new javax.swing.JTable();
        bibliograficaText = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        bibliografiaTable = new javax.swing.JTable();
        calendarioEvaluacionText = new javax.swing.JLabel();
        jScrollPane3 = new javax.swing.JScrollPane();
        calendariaEvaluacionTable = new javax.swing.JTable();
        guardarButton = new javax.swing.JButton();
        cancelarButton = new javax.swing.JButton();
        guardarComoBorradorButton = new javax.swing.JButton();
        claveNrcOut = new javax.swing.JLabel();
        experienciaEducativaOut = new javax.swing.JLabel();
        programaEducativoOut = new javax.swing.JLabel();
        bloqueOut = new javax.swing.JLabel();
        seccionOut = new javax.swing.JLabel();
        academicoOut = new javax.swing.JLabel();
        periodoOut = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        claveNrcText.setText("CLAVE NRC: ");

        academicoText.setText("ACADÉMICO: ");

        experienciaEducativaText.setText("E.E: ");

        programaEducativoText.setText("P.E: ");

        bloqueText.setText("Bloque: ");

        seccionText.setText("Sección: ");

        periodoText.setText("PERIODO: ");

        objetivoGeneralText.setText("OBJETIVO GENERAL: ");

        planeacionText.setText("PLANEACIÓN: ");

        planeacionTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null}
            },
            new String [] {
                "Unidad", "Temas", "Fechas", "Tareas y prácticas", "Técnica didactica"
            }
        ));
        jScrollPane1.setViewportView(planeacionTable);

        bibliograficaText.setText("BIBLIOGRAFÍA: ");

        bibliografiaTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Autor(es)", "Título de libro", "Editorial", "Año"
            }
        ));
        jScrollPane2.setViewportView(bibliografiaTable);

        calendarioEvaluacionText.setText("CALENDARIO DE EVALUACIÓN: ");

        calendariaEvaluacionTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null}
            },
            new String [] {
                "Unidad", "Fechas", "Criterio de evaluación: ", "Instrumento", "Porcentaje"
            }
        ));
        jScrollPane3.setViewportView(calendariaEvaluacionTable);

        guardarButton.setText("Guardar");
        guardarButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                guardarButtonActionPerformed(evt);
            }
        });

        cancelarButton.setText("Cancelar");

        guardarComoBorradorButton.setText("Guardar como borrador");

        claveNrcOut.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));

        experienciaEducativaOut.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));

        programaEducativoOut.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));

        bloqueOut.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));

        seccionOut.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));

        academicoOut.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));

        periodoOut.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));

        javax.swing.GroupLayout panelLayout = new javax.swing.GroupLayout(panel);
        panel.setLayout(panelLayout);
        panelLayout.setHorizontalGroup(
            panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelLayout.createSequentialGroup()
                .addGap(22, 22, 22)
                .addGroup(panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jScrollPane3)
                    .addComponent(jScrollPane2)
                    .addComponent(objetivoGeneralIn, javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, panelLayout.createSequentialGroup()
                        .addComponent(claveNrcText)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(claveNrcOut, javax.swing.GroupLayout.PREFERRED_SIZE, 57, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(experienciaEducativaText)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(experienciaEducativaOut, javax.swing.GroupLayout.PREFERRED_SIZE, 115, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(programaEducativoText)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(programaEducativoOut, javax.swing.GroupLayout.PREFERRED_SIZE, 186, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(bloqueText)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(bloqueOut, javax.swing.GroupLayout.PREFERRED_SIZE, 47, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(seccionText)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(seccionOut, javax.swing.GroupLayout.DEFAULT_SIZE, 52, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, panelLayout.createSequentialGroup()
                        .addGroup(panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(calendarioEvaluacionText, javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(bibliograficaText, javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(planeacionText, javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(objetivoGeneralText, javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, panelLayout.createSequentialGroup()
                                .addComponent(academicoText)
                                .addGap(4, 4, 4)
                                .addComponent(academicoOut, javax.swing.GroupLayout.PREFERRED_SIZE, 269, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(periodoText)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(periodoOut, javax.swing.GroupLayout.PREFERRED_SIZE, 158, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addGap(90, 90, 90))
            .addGroup(panelLayout.createSequentialGroup()
                .addGap(138, 138, 138)
                .addComponent(guardarButton)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(guardarComoBorradorButton)
                .addGap(75, 75, 75)
                .addComponent(cancelarButton)
                .addGap(209, 209, 209))
        );
        panelLayout.setVerticalGroup(
            panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelLayout.createSequentialGroup()
                .addGap(23, 23, 23)
                .addGroup(panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(claveNrcText, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(experienciaEducativaText, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(programaEducativoText, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(bloqueText, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(seccionText, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(claveNrcOut, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(experienciaEducativaOut, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(programaEducativoOut, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(bloqueOut, javax.swing.GroupLayout.PREFERRED_SIZE, 15, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(seccionOut, javax.swing.GroupLayout.PREFERRED_SIZE, 15, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(academicoText)
                    .addComponent(periodoText)
                    .addComponent(academicoOut, javax.swing.GroupLayout.PREFERRED_SIZE, 15, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(periodoOut, javax.swing.GroupLayout.PREFERRED_SIZE, 15, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(27, 27, 27)
                .addComponent(objetivoGeneralText)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(objetivoGeneralIn, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(planeacionText)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 89, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(bibliograficaText)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 87, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(33, 33, 33)
                .addComponent(calendarioEvaluacionText)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 89, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(guardarButton)
                    .addComponent(cancelarButton)
                    .addComponent(guardarComoBorradorButton))
                .addGap(26, 26, 26))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(panel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(panel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void guardarButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_guardarButtonActionPerformed
        
    }//GEN-LAST:event_guardarButtonActionPerformed

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
            java.util.logging.Logger.getLogger(ElaborarPlanDeCurso.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(ElaborarPlanDeCurso.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(ElaborarPlanDeCurso.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(ElaborarPlanDeCurso.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new ElaborarPlanDeCurso().setVisible(true);
            }
        });
        
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel academicoOut;
    private javax.swing.JLabel academicoText;
    private javax.swing.JTable bibliografiaTable;
    private javax.swing.JLabel bibliograficaText;
    private javax.swing.JLabel bloqueOut;
    private javax.swing.JLabel bloqueText;
    private javax.swing.JTable calendariaEvaluacionTable;
    private javax.swing.JLabel calendarioEvaluacionText;
    private javax.swing.JButton cancelarButton;
    private javax.swing.JLabel claveNrcOut;
    private javax.swing.JLabel claveNrcText;
    private javax.swing.JLabel experienciaEducativaOut;
    private javax.swing.JLabel experienciaEducativaText;
    private javax.swing.JButton guardarButton;
    private javax.swing.JButton guardarComoBorradorButton;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JTextField objetivoGeneralIn;
    private javax.swing.JLabel objetivoGeneralText;
    private javax.swing.JPanel panel;
    private javax.swing.JLabel periodoOut;
    private javax.swing.JLabel periodoText;
    private javax.swing.JTable planeacionTable;
    private javax.swing.JLabel planeacionText;
    private javax.swing.JLabel programaEducativoOut;
    private javax.swing.JLabel programaEducativoText;
    private javax.swing.JLabel seccionOut;
    private javax.swing.JLabel seccionText;
    // End of variables declaration//GEN-END:variables
}
