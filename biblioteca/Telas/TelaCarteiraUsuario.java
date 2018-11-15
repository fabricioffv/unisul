/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package biblioteca.Telas;

import biblioteca.Classes.Emprestimo;
import biblioteca.Classes.Usuario;
import biblioteca.DAOs.EmprestimoDAO;
import biblioteca.DAOs.UsuarioDAO;
import java.sql.SQLException;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Fabricio
 */
public class TelaCarteiraUsuario extends javax.swing.JFrame {

    /**
     * Creates new form CarteiraUsuario
     */
    public TelaCarteiraUsuario() {
        initComponents();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jButtonConsultar = new javax.swing.JButton();
        jScrollPane2 = new javax.swing.JScrollPane();
        jTableEmprestimos = new javax.swing.JTable();
        jLabelMatricula = new javax.swing.JLabel();
        jLabelNome = new javax.swing.JLabel();
        jTextFieldMatricula = new javax.swing.JTextField();
        jTextFieldNome = new javax.swing.JTextField();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        jButtonConsultar.setFont(new java.awt.Font("Tahoma", 1, 17)); // NOI18N
        jButtonConsultar.setText("Consultar");
        jButtonConsultar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonConsultarActionPerformed(evt);
            }
        });

        jTableEmprestimos.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Código", "Titulo", "Data do Empréstimo", "Situação"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Integer.class, java.lang.String.class, java.lang.String.class, java.lang.String.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane2.setViewportView(jTableEmprestimos);

        jLabelMatricula.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabelMatricula.setText("Matrícula:");

        jLabelNome.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabelNome.setText("Nome:");

        jTextFieldMatricula.setToolTipText("Número da Matrícula");

        jTextFieldNome.setToolTipText("Nome Completo");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabelMatricula)
                    .addComponent(jLabelNome))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jTextFieldMatricula, javax.swing.GroupLayout.PREFERRED_SIZE, 104, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jTextFieldNome, javax.swing.GroupLayout.PREFERRED_SIZE, 255, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 71, Short.MAX_VALUE)
                .addComponent(jButtonConsultar, javax.swing.GroupLayout.PREFERRED_SIZE, 119, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(87, 87, 87))
            .addComponent(jScrollPane2, javax.swing.GroupLayout.Alignment.TRAILING)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabelMatricula)
                            .addComponent(jTextFieldMatricula, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(24, 24, 24)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabelNome)
                            .addComponent(jTextFieldNome, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(23, 23, 23)
                        .addComponent(jButtonConsultar, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(22, 22, 22)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 317, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButtonConsultarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonConsultarActionPerformed
        if(!TelaPrincipal.validaNumero(jTextFieldMatricula)){
            JOptionPane.showMessageDialog(null, "Campo " + jLabelMatricula.getText().replace(":", "") +
                " não pode ser zero, conter letras ou estar em branco!" ,"Informação",JOptionPane.INFORMATION_MESSAGE);
            jTextFieldMatricula.grabFocus();
        }else{
            int matricula = Integer.parseInt(jTextFieldMatricula.getText());
            ArrayList<Emprestimo> lista = new ArrayList<Emprestimo>();
            EmprestimoDAO edao = new EmprestimoDAO();
            Usuario u = null;
            UsuarioDAO ud = new UsuarioDAO();
            
            try{
                u = ud.consultar(matricula);
                if(u != null){
                    lista = edao.consultar(matricula);
                    if(!lista.isEmpty()){
                        jTextFieldNome.setText(u.getNome());
                        
                        DefaultTableModel df = (DefaultTableModel) jTableEmprestimos.getModel();
                        df.setRowCount(lista.size());
                    
                        for(int i= 0; i < lista.size(); i++){
                            jTableEmprestimos.setValueAt(lista.get(i).getCodigo(), i, 0);
                            jTableEmprestimos.setValueAt(lista.get(i).getPublicacao().getTitulo(), i, 1);
                            jTableEmprestimos.setValueAt(lista.get(i).dataToString(lista.get(i).getDataEmprestimo()), i, 2);
                            if(lista.get(i).estaDevolvido()){
                               jTableEmprestimos.setValueAt("Delvolvido", i, 3); 
                            }else{
                                jTableEmprestimos.setValueAt("Pendente", i, 3); 
                            }
                        }
                    }else{
                        JOptionPane.showMessageDialog(null, "Sem empréstimos");
                        limparCampos();
                    }
                    //jTextFieldMatricula.setText(Integer.toString(u.getMatricula()));
                    //jTextFieldNome.setText(u.getNome());
                }else{
                    JOptionPane.showMessageDialog(null, "Matrícula inexistente");
                    limparCampos();
                }
            }catch(SQLException e){
                System.out.println(e);
            }
        }

    }//GEN-LAST:event_jButtonConsultarActionPerformed

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
            java.util.logging.Logger.getLogger(TelaCarteiraUsuario.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(TelaCarteiraUsuario.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(TelaCarteiraUsuario.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(TelaCarteiraUsuario.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new TelaCarteiraUsuario().setVisible(true);
            }
        });
    }
    
     private void limparCampos(){
        this.jTextFieldMatricula.setText("");
        this.jTextFieldNome.setText("");
        
        for(int i= 0; i < jTableEmprestimos.getRowCount(); i++){
            jTableEmprestimos.setValueAt("", i, 0);
            jTableEmprestimos.setValueAt("", i, 1);
            jTableEmprestimos.setValueAt("", i, 2);
            jTableEmprestimos.setValueAt("", i, 3);
            
        }
        jTableEmprestimos.clearSelection();
        DefaultTableModel df = (DefaultTableModel) jTableEmprestimos.getModel();
        df.setRowCount(0);
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButtonConsultar;
    private javax.swing.JLabel jLabelMatricula;
    private javax.swing.JLabel jLabelNome;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTable jTableEmprestimos;
    private javax.swing.JTextField jTextFieldMatricula;
    private javax.swing.JTextField jTextFieldNome;
    // End of variables declaration//GEN-END:variables
}
