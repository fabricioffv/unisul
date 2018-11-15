/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package biblioteca.Telas;

import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

/**
 *
 * @author Fabricio
 */
public class TelaPrincipal extends javax.swing.JFrame {

    /**
     * Creates new form TelaPrincipal
     */
    public TelaPrincipal() {
        super("Tela Principal");
        initComponents();
//        ImageIcon icon = new ImageIcon("C:/Users/Fabricio/Desktop/NetBeans/Biblioteca/img/b.jpg");
//        JLabel label = new JLabel(icon);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jMenuItem1 = new javax.swing.JMenuItem();
        jLabel = new javax.swing.JLabel();
        jMenuBar1 = new javax.swing.JMenuBar();
        jMenuCadastros = new javax.swing.JMenu();
        jMenuItemUsuarios = new javax.swing.JMenuItem();
        jMenuItemPublicacao = new javax.swing.JMenuItem();
        jMenuMovimentacao = new javax.swing.JMenu();
        jMenuItemEmprestimo = new javax.swing.JMenuItem();
        jMenuItemDevolucao = new javax.swing.JMenuItem();
        jMenuBalancos = new javax.swing.JMenu();
        jMenuItemBalancoAcervo = new javax.swing.JMenuItem();
        jMenuItemBalancoMov = new javax.swing.JMenuItem();
        jMenu1 = new javax.swing.JMenu();
        jMenuItemCarteiraUsuario = new javax.swing.JMenuItem();

        jMenuItem1.setText("jMenuItem1");

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel.setIcon(new javax.swing.ImageIcon("C:\\Users\\Fabricio\\Desktop\\NetBeans\\Biblioteca\\src\\biblioteca\\img\\b.jpg")); // NOI18N

        jMenuCadastros.setText("Cadastros");

        jMenuItemUsuarios.setText("Usuários");
        jMenuItemUsuarios.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItemUsuariosActionPerformed(evt);
            }
        });
        jMenuCadastros.add(jMenuItemUsuarios);

        jMenuItemPublicacao.setText("Publicações");
        jMenuItemPublicacao.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItemPublicacaoActionPerformed(evt);
            }
        });
        jMenuCadastros.add(jMenuItemPublicacao);

        jMenuBar1.add(jMenuCadastros);

        jMenuMovimentacao.setText("Movimentação");

        jMenuItemEmprestimo.setText("Emprésitmo");
        jMenuItemEmprestimo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItemEmprestimoActionPerformed(evt);
            }
        });
        jMenuMovimentacao.add(jMenuItemEmprestimo);

        jMenuItemDevolucao.setText("Devolução");
        jMenuItemDevolucao.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItemDevolucaoActionPerformed(evt);
            }
        });
        jMenuMovimentacao.add(jMenuItemDevolucao);

        jMenuBar1.add(jMenuMovimentacao);

        jMenuBalancos.setText("Balanços");

        jMenuItemBalancoAcervo.setText("Balanço do Acervo");
        jMenuItemBalancoAcervo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItemBalancoAcervoActionPerformed(evt);
            }
        });
        jMenuBalancos.add(jMenuItemBalancoAcervo);

        jMenuItemBalancoMov.setText("Balanço de Movimentações");
        jMenuItemBalancoMov.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItemBalancoMovActionPerformed(evt);
            }
        });
        jMenuBalancos.add(jMenuItemBalancoMov);

        jMenuBar1.add(jMenuBalancos);

        jMenu1.setText("Carteira");

        jMenuItemCarteiraUsuario.setText("Usuário");
        jMenuItemCarteiraUsuario.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItemCarteiraUsuarioActionPerformed(evt);
            }
        });
        jMenu1.add(jMenuItemCarteiraUsuario);

        jMenuBar1.add(jMenu1);

        setJMenuBar(jMenuBar1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jMenuItemDevolucaoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItemDevolucaoActionPerformed
        TelaDevolucao td = new TelaDevolucao();
        td.setVisible(true);        // TODO add your handling code here:
        td.setLocationRelativeTo(null);
    }//GEN-LAST:event_jMenuItemDevolucaoActionPerformed

    private void jMenuItemEmprestimoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItemEmprestimoActionPerformed
        TelaEmprestimo te = new TelaEmprestimo();
        te.setVisible(true);
        te.setLocationRelativeTo(null);
    }//GEN-LAST:event_jMenuItemEmprestimoActionPerformed

    private void jMenuItemPublicacaoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItemPublicacaoActionPerformed
        TelaCadastroPublicacao tcp = new TelaCadastroPublicacao();
        tcp.setVisible(true);
        tcp.setLocationRelativeTo(null);
    }//GEN-LAST:event_jMenuItemPublicacaoActionPerformed

    private void jMenuItemUsuariosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItemUsuariosActionPerformed
        TelaCadastroUsuario tcu = new TelaCadastroUsuario();
        tcu.setVisible(true);
        tcu.setLocationRelativeTo(null);
    }//GEN-LAST:event_jMenuItemUsuariosActionPerformed

    private void jMenuItemBalancoAcervoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItemBalancoAcervoActionPerformed
        TelaBalancoAcervo tba = new TelaBalancoAcervo();
        tba.setVisible(true);        // TODO add your handling code here:
        tba.setLocationRelativeTo(null);
    }//GEN-LAST:event_jMenuItemBalancoAcervoActionPerformed

    private void jMenuItemBalancoMovActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItemBalancoMovActionPerformed
        TelaBalancoMovimentacao tbv = new TelaBalancoMovimentacao();
        tbv.setVisible(true);
        tbv.setLocationRelativeTo(null);
    }//GEN-LAST:event_jMenuItemBalancoMovActionPerformed

    private void jMenuItemCarteiraUsuarioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItemCarteiraUsuarioActionPerformed
        TelaCarteiraUsuario tcu = new TelaCarteiraUsuario();
        tcu.setVisible(true);
        tcu.setLocationRelativeTo(null);
    }//GEN-LAST:event_jMenuItemCarteiraUsuarioActionPerformed

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
            java.util.logging.Logger.getLogger(TelaPrincipal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(TelaPrincipal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(TelaPrincipal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(TelaPrincipal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new TelaPrincipal().setVisible(true);
            }
        });
    }
    
    public static boolean validaNumero(JTextField field) {
        int valor = 0;
        if (field.getText().length() != 0){
            try {
                valor = Integer.parseInt(field.getText());
                return (valor > 0);
            }catch(NumberFormatException ex){
//                JOptionPane.showMessageDialog(null, "O Campo " + label.getText().replace(":", "") + " só aceita números" ,"Informação",JOptionPane.INFORMATION_MESSAGE);
//                field.grabFocus();
                return false;
            }
        }else{
//            JOptionPane.showMessageDialog(null, "O Campo " + label.getText().replace(":", "") + " está vazio!" ,"Informação",JOptionPane.INFORMATION_MESSAGE);;
//            field.grabFocus();
            
            return false;
        }

    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jLabel;
    private javax.swing.JMenu jMenu1;
    private javax.swing.JMenu jMenuBalancos;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JMenu jMenuCadastros;
    private javax.swing.JMenuItem jMenuItem1;
    private javax.swing.JMenuItem jMenuItemBalancoAcervo;
    private javax.swing.JMenuItem jMenuItemBalancoMov;
    private javax.swing.JMenuItem jMenuItemCarteiraUsuario;
    private javax.swing.JMenuItem jMenuItemDevolucao;
    private javax.swing.JMenuItem jMenuItemEmprestimo;
    private javax.swing.JMenuItem jMenuItemPublicacao;
    private javax.swing.JMenuItem jMenuItemUsuarios;
    private javax.swing.JMenu jMenuMovimentacao;
    // End of variables declaration//GEN-END:variables
}
