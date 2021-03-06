/*

 *  Derechos de autor: UV-software(c)
 *  @auto: Juan Carlos Domínguez Dominguez
 *  @nombre: Control de academias
 *  @versión 3.9.6
 *  Este producto no puede ser intercambiado bajo ninguna circunstancia
	
 */

package GUI;

import DAO.PlanDeCursoDAO;
import clases.Bibliografia;
import clases.CriterioDeEvaluacion;
import clases.Curso;
import clases.PlanDeCurso;
import clases.Profesor;
import clases.Unidad;
import java.util.ArrayList;
import javax.swing.JButton;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Juuan
 */
public class ElaborarPlanDeCurso extends javax.swing.JFrame {
    private static Profesor profesor;
    private static int posicionCurso;
    public static ArrayList<Unidad> unidades = new ArrayList<Unidad>();
    public static ArrayList<Bibliografia> bibliografias = new ArrayList<Bibliografia>();
    public static ArrayList<CriterioDeEvaluacion> criteriosDeEvaluacion = new ArrayList<CriterioDeEvaluacion>();
    public static DefaultTableModel modelo;
    private static Curso curso = new Curso();
    private static PlanDeCursoDAO planDeCursoDAO = new PlanDeCursoDAO();
    private static PlanDeCurso planDeCurso = new PlanDeCurso();

    public static ArrayList<Unidad> getUnidades() {
        return unidades;
    }

    public static JButton getEliminarBibliografiaButton() {
        return eliminarBibliografiaButton;
    }

    public static void setEliminarBibliografiaButton(JButton eliminarBibliografiaButton) {
        ElaborarPlanDeCurso.eliminarBibliografiaButton = eliminarBibliografiaButton;
    }

    public static JButton getEliminarEvaluacionButton() {
        return eliminarEvaluacionButton;
    }

    public static void setEliminarEvaluacionButton(JButton eliminarEvaluacionButton) {
        ElaborarPlanDeCurso.eliminarEvaluacionButton = eliminarEvaluacionButton;
    }

    public static JButton getEliminarPlaneacionButton() {
        return eliminarPlaneacionButton;
    }

    public static void setEliminarPlaneacionButton(JButton eliminarPlaneacionButton) {
        ElaborarPlanDeCurso.eliminarPlaneacionButton = eliminarPlaneacionButton;
    }

    
    public static void setUnidades(ArrayList<Unidad> unidades) {
        ElaborarPlanDeCurso.unidades = unidades;
    }

    public static ArrayList<Bibliografia> getBibliografias() {
        return bibliografias;
    }

    public static void setBibliografias(ArrayList<Bibliografia> bibliografias) {
        ElaborarPlanDeCurso.bibliografias = bibliografias;
    }

    public static ArrayList<CriterioDeEvaluacion> getCriteriosDeEvaluacion() {
        return criteriosDeEvaluacion;
    }

    public static void setCriteriosDeEvaluacion(ArrayList<CriterioDeEvaluacion> criteriosDeEvaluacion) {
        ElaborarPlanDeCurso.criteriosDeEvaluacion = criteriosDeEvaluacion;
    }
    
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
        curso = profesor.getCursos().get(posicionCurso);
        planDeCurso = planDeCursoDAO.obtenerPlanDeCursoPorCurso(curso);
        if(planDeCurso.getEstado().equals("Incompleto")){
            mostrarDatosPrincipales();
            objetivoGeneralIn.setText(planDeCurso.getObjetivoGeneral());
            cargarTablaBibliografiaIncompleta();
            cargarTablaEvaluacionesIncompleta();
            cargarTablaPlaneacionIncompleta();
        }else{
            mostrarDatosPrincipales();
            eliminarBibliografiaButton.setEnabled(false);
            eliminarPlaneacionButton.setEnabled(false);
            eliminarEvaluacionButton.setEnabled(false);
        }
    }
    
    public void mostrarDatosPrincipales(){
        claveNrcOut.setText(Integer.toString(profesor.getCursos().get(posicionCurso).getNrc()));
        experienciaEducativaOut.setText(profesor.getCursos().get(posicionCurso).getExperienciaEducativa().getNombreEE());
        
        bloqueOut.setText(Integer.toString(profesor.getCursos().get(posicionCurso).getBloque()));
        seccionOut.setText(Integer.toString(profesor.getCursos().get(posicionCurso).getSeccion()));
        academicoOut.setText(profesor.getNombre());
        periodoOut.setText(profesor.getCursos().get(posicionCurso).getPeriodo().getNombrePeriodo());
    }
    public static void cargarTablaPlaneacionIncompleta(){
        modelo = (DefaultTableModel) planeacionTable.getModel();
        for(int i = 0; i<planDeCurso.getUnidades().size(); i++){
            Object nuevo[]= {""};
            modelo.addRow(nuevo);
            planeacionTable.setValueAt(planDeCurso.getUnidades().get(i).getNombre(), i, 0);
            for(int j = 0; j<planDeCurso.getUnidades().get(i).getTemas().size();j++){
                planeacionTable.setValueAt(planDeCurso.getUnidades().get(i).getTemas().get(j).getNombre(), i, 1);
            }
            planeacionTable.setValueAt(planDeCurso.getUnidades().get(i).getFecha(), i, 2);
            planeacionTable.setValueAt(planDeCurso.getUnidades().get(i).getTareasYPracticas(), i, 3);
            planeacionTable.setValueAt(planDeCurso.getUnidades().get(i).getTecnicaDidactica(), i, 4);
        }
    }
    
    public static void cargarTablaBibliografiaIncompleta(){
        modelo = (DefaultTableModel) bibliografiaTable.getModel();
        for(int i = 0; i < planDeCurso.getBibliografias().size();i++){
            Object nuevo[]= {""};
            modelo.addRow(nuevo);
            bibliografiaTable.setValueAt(planDeCurso.getBibliografias().get(i).getAutor(), i, 0);
            bibliografiaTable.setValueAt(planDeCurso.getBibliografias().get(i).getTituloLibro(), i, 1);
            bibliografiaTable.setValueAt(planDeCurso.getBibliografias().get(i).getEditorial(), i, 2);
            bibliografiaTable.setValueAt(planDeCurso.getBibliografias().get(i).getAnio(), i, 3);
        }
    }
    
    public static void cargarTablaEvaluacionesIncompleta(){
        modelo = (DefaultTableModel) calendarioEvaluacionTable.getModel();
        for(int i = 0; i < planDeCurso.getCriteriosDeEvaluacion().size();i++){
            Object nuevo[]= {""};
            modelo.addRow(nuevo);
            calendarioEvaluacionTable.setValueAt(planDeCurso.getCriteriosDeEvaluacion().get(i).getUnidadesEvaluadas(), i, 0);
            calendarioEvaluacionTable.setValueAt(planDeCurso.getCriteriosDeEvaluacion().get(i).getFecha(), i, 1);
            calendarioEvaluacionTable.setValueAt(planDeCurso.getCriteriosDeEvaluacion().get(i).getCriterioEvaluacion(), i, 2);
            calendarioEvaluacionTable.setValueAt(planDeCurso.getCriteriosDeEvaluacion().get(i).getInstrumento(), i, 3);
            calendarioEvaluacionTable.setValueAt(planDeCurso.getCriteriosDeEvaluacion().get(i).getPorcentaje(), i, 4);
        }
    }
    
    public boolean validarCampos(){
        if(objetivoGeneralIn.getText() == "" || unidades.size() == 0 || bibliografias.size() == 0 || criteriosDeEvaluacion.size() == 0){
            return false;
        }
        return true;
    }
    
    public static void cargarTablaUnidades(){
        for(int i = 0; i<unidades.size(); i++){
            planeacionTable.setValueAt(unidades.get(i).getNombre(), i, 0);
            for(int j = 0; j<unidades.get(i).getTemas().size();j++){
                planeacionTable.setValueAt(unidades.get(i).getTemas().get(j).getNombre(), i, 1);
            }
            planeacionTable.setValueAt(unidades.get(i).getFecha(), i, 2);
            planeacionTable.setValueAt(unidades.get(i).getTareasYPracticas(), i, 3);
            planeacionTable.setValueAt(unidades.get(i).getTecnicaDidactica(), i, 4);
        }
    }
    
    public static void cargarTablaBibliografias(){
        for(int i = 0; i < bibliografias.size(); i++){
            bibliografiaTable.setValueAt(bibliografias.get(i).getAutor(), i, 0);
            bibliografiaTable.setValueAt(bibliografias.get(i).getTituloLibro(), i, 1);
            bibliografiaTable.setValueAt(bibliografias.get(i).getEditorial(), i, 2);
            bibliografiaTable.setValueAt(bibliografias.get(i).getAnio(), i, 3);
        }
    }
    
    public static void cargarTablaEvaluaciones(){
        for(int i = 0; i < criteriosDeEvaluacion.size(); i++){
            calendarioEvaluacionTable.setValueAt(criteriosDeEvaluacion.get(i).getUnidadesEvaluadas(), i, 0);
            calendarioEvaluacionTable.setValueAt(criteriosDeEvaluacion.get(i).getFecha(), i, 1);
            calendarioEvaluacionTable.setValueAt(criteriosDeEvaluacion.get(i).getCriterioEvaluacion(), i, 2);
            calendarioEvaluacionTable.setValueAt(criteriosDeEvaluacion.get(i).getInstrumento(), i, 3);
            calendarioEvaluacionTable.setValueAt(criteriosDeEvaluacion.get(i).getPorcentaje(), i, 4);
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
        calendarioEvaluacionTable = new javax.swing.JTable();
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
        agregarPlaneacionButton = new javax.swing.JButton();
        eliminarPlaneacionButton = new javax.swing.JButton();
        agregarBibliografiaButton = new javax.swing.JButton();
        eliminarBibliografiaButton = new javax.swing.JButton();
        agregarEvaluacionButton = new javax.swing.JButton();
        eliminarEvaluacionButton = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        claveNrcText.setText("CLAVE NRC: ");

        academicoText.setText("ACADÉMICO: ");

        experienciaEducativaText.setText("E.E: ");

        programaEducativoText.setText("P.E: ");

        bloqueText.setText("Bloque: ");

        seccionText.setText("Sección: ");

        periodoText.setText("PERIODO: ");

        objetivoGeneralText.setText("OBJETIVO GENERAL: ");

        objetivoGeneralIn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                objetivoGeneralInActionPerformed(evt);
            }
        });
        objetivoGeneralIn.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                objetivoGeneralInKeyTyped(evt);
            }
        });

        planeacionText.setText("PLANEACIÓN: ");

        planeacionTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Unidad", "Temas", "Fechas", "Tareas y prácticas", "Técnica didactica"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane1.setViewportView(planeacionTable);

        bibliograficaText.setText("BIBLIOGRAFÍA: ");

        bibliografiaTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Autor(es)", "Título de libro", "Editorial", "Año"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane2.setViewportView(bibliografiaTable);

        calendarioEvaluacionText.setText("CALENDARIO DE EVALUACIÓN: ");

        calendarioEvaluacionTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Unidad", "Fechas", "Criterio de evaluación: ", "Instrumento", "Porcentaje"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane3.setViewportView(calendarioEvaluacionTable);

        guardarButton.setText("Guardar");
        guardarButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                guardarButtonActionPerformed(evt);
            }
        });

        cancelarButton.setText("Cancelar");
        cancelarButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cancelarButtonActionPerformed(evt);
            }
        });

        guardarComoBorradorButton.setText("Guardar como borrador");
        guardarComoBorradorButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                guardarComoBorradorButtonActionPerformed(evt);
            }
        });

        claveNrcOut.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));

        experienciaEducativaOut.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));

        programaEducativoOut.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));

        bloqueOut.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));

        seccionOut.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));

        academicoOut.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));

        periodoOut.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));

        agregarPlaneacionButton.setText("Agregar");
        agregarPlaneacionButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                agregarPlaneacionButtonActionPerformed(evt);
            }
        });

        eliminarPlaneacionButton.setText("Eliminar");
        eliminarPlaneacionButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                eliminarPlaneacionButtonActionPerformed(evt);
            }
        });

        agregarBibliografiaButton.setText("Agregar");
        agregarBibliografiaButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                agregarBibliografiaButtonActionPerformed(evt);
            }
        });

        eliminarBibliografiaButton.setText("Eliminar");
        eliminarBibliografiaButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                eliminarBibliografiaButtonActionPerformed(evt);
            }
        });

        agregarEvaluacionButton.setText("Agregar");
        agregarEvaluacionButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                agregarEvaluacionButtonActionPerformed(evt);
            }
        });

        eliminarEvaluacionButton.setText("Eliminar");
        eliminarEvaluacionButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                eliminarEvaluacionButtonActionPerformed(evt);
            }
        });

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
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, panelLayout.createSequentialGroup()
                                .addComponent(calendarioEvaluacionText)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(agregarEvaluacionButton)
                                .addGap(40, 40, 40)
                                .addComponent(eliminarEvaluacionButton))
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, panelLayout.createSequentialGroup()
                                .addComponent(bibliograficaText)
                                .addGap(2, 2, 2)
                                .addComponent(agregarBibliografiaButton)
                                .addGap(33, 33, 33)
                                .addComponent(eliminarBibliografiaButton))
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, panelLayout.createSequentialGroup()
                                .addComponent(planeacionText)
                                .addGap(4, 4, 4)
                                .addComponent(agregarPlaneacionButton)
                                .addGap(31, 31, 31)
                                .addComponent(eliminarPlaneacionButton))
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
                .addGroup(panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(claveNrcText, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(experienciaEducativaText, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(programaEducativoText, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(bloqueText, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(seccionText, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(claveNrcOut, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(experienciaEducativaOut, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(programaEducativoOut, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(bloqueOut, javax.swing.GroupLayout.PREFERRED_SIZE, 15, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(seccionOut, javax.swing.GroupLayout.PREFERRED_SIZE, 15, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(18, 18, 18)
                .addGroup(panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(academicoOut, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 15, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(periodoOut, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 15, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(academicoText)
                        .addComponent(periodoText)))
                .addGap(18, 18, 18)
                .addComponent(objetivoGeneralText)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(objetivoGeneralIn, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(23, 23, 23)
                .addGroup(panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(planeacionText)
                    .addComponent(agregarPlaneacionButton)
                    .addComponent(eliminarPlaneacionButton))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 89, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(bibliograficaText)
                    .addComponent(agregarBibliografiaButton)
                    .addComponent(eliminarBibliografiaButton))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 87, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(28, 28, 28)
                .addGroup(panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(calendarioEvaluacionText)
                    .addComponent(agregarEvaluacionButton)
                    .addComponent(eliminarEvaluacionButton))
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
        if(!validarCampos()){
            JOptionPane.showMessageDialog(this, "Debes llenar al menos el objetivo general y un campo de cada tabla");
        }else{
            
            int opcion = JOptionPane.showConfirmDialog(null, "Si guarda el plan de curso ya no se podra modificar, ¿esta seguro de guardarlo permanentemente?", "Confirmacion", JOptionPane.OK_CANCEL_OPTION);
            if (opcion == 0){
                PlanDeCurso planDeCurso = new PlanDeCurso();
                planDeCurso.setObjetivoGeneral(objetivoGeneralIn.getText());
                planDeCurso.setBibliografias(bibliografias);
                for(int i = 0; i<criteriosDeEvaluacion.size(); i++){
                    criteriosDeEvaluacion.get(i).setExperienciaEducativa(profesor.getCursos().get(posicionCurso).getExperienciaEducativa());
                }
                planDeCurso.setCriteriosDeEvaluacion(criteriosDeEvaluacion);
                planDeCurso.setUnidades(unidades);
                planDeCurso.setEstado("Completo");
                planDeCurso.setCurso(profesor.getCursos().get(posicionCurso));
                PlanDeCursoDAO planDeCursoDAO = new PlanDeCursoDAO();
                planDeCursoDAO.agregarPlanDeCurso(planDeCurso);

                PantallaProfesor.setProfesor(profesor);
                PantallaProfesor.setPosicionCurso(posicionCurso);
                PantallaProfesor pantallaProfesor = new PantallaProfesor();
                pantallaProfesor.setVisible(true);
                dispose();
            }
        }
    }//GEN-LAST:event_guardarButtonActionPerformed

    private void objetivoGeneralInKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_objetivoGeneralInKeyTyped
        if (objetivoGeneralIn.getText().length() >= 500){
            evt.consume();
        }
    }//GEN-LAST:event_objetivoGeneralInKeyTyped

    private void objetivoGeneralInActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_objetivoGeneralInActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_objetivoGeneralInActionPerformed

    private void agregarPlaneacionButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_agregarPlaneacionButtonActionPerformed
        AgregarPlaneacion agregarPlaneacion = new AgregarPlaneacion();
        agregarPlaneacion.setVisible(true);
    }//GEN-LAST:event_agregarPlaneacionButtonActionPerformed

    private void eliminarPlaneacionButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_eliminarPlaneacionButtonActionPerformed
        if (modelo.getRowCount()-1 >= 0){
            eliminarPlaneacionButton.setEnabled(true);
            modelo.removeRow(modelo.getRowCount()-1);
            unidades.remove(unidades.get(unidades.size()-1));
        }
        if (modelo.getRowCount()-1 <= 0){
            eliminarPlaneacionButton.setEnabled(false);
        }
    }//GEN-LAST:event_eliminarPlaneacionButtonActionPerformed

    private void agregarBibliografiaButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_agregarBibliografiaButtonActionPerformed
        AgregarBibliografia agregarBibliografia = new AgregarBibliografia();
        agregarBibliografia.setVisible(true);
    }//GEN-LAST:event_agregarBibliografiaButtonActionPerformed

    private void eliminarBibliografiaButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_eliminarBibliografiaButtonActionPerformed
        if (modelo.getRowCount()-1 >= 0){
            eliminarBibliografiaButton.setEnabled(true);
            modelo.removeRow(modelo.getRowCount()-1);
            bibliografias.remove(bibliografias.get(bibliografias.size()-1));
        }
        if (modelo.getRowCount()-1 <= 0){
            eliminarBibliografiaButton.setEnabled(false);
        }
    }//GEN-LAST:event_eliminarBibliografiaButtonActionPerformed

    private void agregarEvaluacionButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_agregarEvaluacionButtonActionPerformed
        AgregarCriterioDeEvaluacion agregarCriterioDeEvaluacion = new AgregarCriterioDeEvaluacion();
        agregarCriterioDeEvaluacion.setVisible(true);
    }//GEN-LAST:event_agregarEvaluacionButtonActionPerformed

    private void eliminarEvaluacionButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_eliminarEvaluacionButtonActionPerformed
        if (modelo.getRowCount()-1 >= 0){
            eliminarEvaluacionButton.setEnabled(true);
            modelo.removeRow(modelo.getRowCount()-1);
            criteriosDeEvaluacion.remove(criteriosDeEvaluacion.get(criteriosDeEvaluacion.size()-1));
        }
        if (modelo.getRowCount()-1 <= 0){
            eliminarEvaluacionButton.setEnabled(false);
        }
    }//GEN-LAST:event_eliminarEvaluacionButtonActionPerformed

    private void guardarComoBorradorButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_guardarComoBorradorButtonActionPerformed
        if(!validarCampos()){
            JOptionPane.showMessageDialog(this, "Debes llenar al menos el objetivo general y un campo de cada tabla");
        }else{
            
            int opcion = JOptionPane.showConfirmDialog(null, "Seguro que quieres guardar como borrador?", "Confirmacion", JOptionPane.OK_CANCEL_OPTION);
            if (opcion == 0){
                PlanDeCurso planDeCurso = new PlanDeCurso();
                planDeCurso.setObjetivoGeneral(objetivoGeneralIn.getText());
                planDeCurso.setBibliografias(bibliografias);
                for(int i = 0; i<criteriosDeEvaluacion.size(); i++){
                    criteriosDeEvaluacion.get(i).setExperienciaEducativa(profesor.getCursos().get(posicionCurso).getExperienciaEducativa());
                }
                planDeCurso.setCriteriosDeEvaluacion(criteriosDeEvaluacion);
                planDeCurso.setUnidades(unidades);
                planDeCurso.setEstado("Incompleto");
                planDeCurso.setCurso(profesor.getCursos().get(posicionCurso));
                PlanDeCursoDAO planDeCursoDAO = new PlanDeCursoDAO();
                planDeCursoDAO.agregarPlanDeCurso(planDeCurso);

                PantallaProfesor.setProfesor(profesor);
                PantallaProfesor.setPosicionCurso(posicionCurso);
                PantallaProfesor pantallaProfesor = new PantallaProfesor();
                pantallaProfesor.setVisible(true);
                dispose();
            }
        }
    }//GEN-LAST:event_guardarComoBorradorButtonActionPerformed

    private void cancelarButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cancelarButtonActionPerformed
        int opcion = JOptionPane.showConfirmDialog(null, "Seguro que no deseas guardar los cambios?", "Confirmacion", JOptionPane.OK_CANCEL_OPTION);
        if (opcion == 0) {
            PantallaProfesor.setProfesor(profesor);
            PantallaProfesor.setPosicionCurso(posicionCurso);
            PantallaProfesor pantallaProfesor = new PantallaProfesor();
            pantallaProfesor.setVisible(true);
            dispose();
        }
    }//GEN-LAST:event_cancelarButtonActionPerformed

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
    private static javax.swing.JButton agregarBibliografiaButton;
    private static javax.swing.JButton agregarEvaluacionButton;
    private static javax.swing.JButton agregarPlaneacionButton;
    public static javax.swing.JTable bibliografiaTable;
    private javax.swing.JLabel bibliograficaText;
    private javax.swing.JLabel bloqueOut;
    private javax.swing.JLabel bloqueText;
    public static javax.swing.JTable calendarioEvaluacionTable;
    private javax.swing.JLabel calendarioEvaluacionText;
    private javax.swing.JButton cancelarButton;
    private javax.swing.JLabel claveNrcOut;
    private javax.swing.JLabel claveNrcText;
    private static javax.swing.JButton eliminarBibliografiaButton;
    private static javax.swing.JButton eliminarEvaluacionButton;
    private static javax.swing.JButton eliminarPlaneacionButton;
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
    public static javax.swing.JTable planeacionTable;
    private javax.swing.JLabel planeacionText;
    private javax.swing.JLabel programaEducativoOut;
    private javax.swing.JLabel programaEducativoText;
    private javax.swing.JLabel seccionOut;
    private javax.swing.JLabel seccionText;
    // End of variables declaration//GEN-END:variables
}
