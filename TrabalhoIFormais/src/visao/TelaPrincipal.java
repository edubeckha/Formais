package visao;

import automatoFinito.AutomatoFinito;
import automatoFinito.SimboloAlfabeto;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import javax.swing.table.DefaultTableModel;
import gramatica.modelo.Gramatica;
import gramatica.modelo.Producao;
import gramatica.modelo.Simbolo;
import static java.lang.reflect.Array.set;
import java.util.Iterator;
import javax.swing.JOptionPane;

public class TelaPrincipal extends javax.swing.JFrame {

    
      Object[][] data = null;
      String[] columnNames = new String[1];
      DefaultTableModel modeloGramatica, modeloAutomato;
      ArrayList<Producao> producoesDaGramatica;
 
      Gramatica gramatica = Gramatica.retornaSingleton();
      AutomatoFinito automato = AutomatoFinito.retornaInstancia();
    public TelaPrincipal() {
        initComponents();
        columnNames[0] = "δ";
        data = new Object[0][0];
        inicializarComponentes();
    }
    
    public void inicializarComponentes(){
        modeloGramatica = (DefaultTableModel) tabelaGramatica.getModel();
        modeloAutomato = new DefaultTableModel(data, columnNames);
        tabelaAutomato.setModel(modeloAutomato);
        producoesDaGramatica = new ArrayList<>();
    }
   
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jTabbedPane1 = new javax.swing.JTabbedPane();
        jPanel1 = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tabelaGramatica = new javax.swing.JTable();
        adicionarLinhaGramatica = new javax.swing.JButton();
        salvarGramatica = new javax.swing.JButton();
        resetarGramatica = new javax.swing.JButton();
        jTextField2 = new javax.swing.JTextField();
        jTextField3 = new javax.swing.JTextField();
        jTextField4 = new javax.swing.JTextField();
        jButton1 = new javax.swing.JButton();
        jPanel3 = new javax.swing.JPanel();
        jTextField5 = new javax.swing.JTextField();
        jScrollPane2 = new javax.swing.JScrollPane();
        tabelaAutomato = new javax.swing.JTable();
        adicionarLinhaAutomato = new javax.swing.JButton();
        resetaAutomato = new javax.swing.JButton();
        salvarAutomato = new javax.swing.JButton();
        jTextField1 = new javax.swing.JTextField();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        jPanel2.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        tabelaGramatica.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        tabelaGramatica.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "N", "Não - Terminais", "Lado Direito da Produção"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Integer.class, java.lang.String.class, java.lang.String.class
            };
            boolean[] canEdit = new boolean [] {
                false, true, true
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tabelaGramatica.setToolTipText("");
        tabelaGramatica.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        tabelaGramatica.setFocusable(false);
        tabelaGramatica.setGridColor(new java.awt.Color(0, 0, 0));
        tabelaGramatica.setInheritsPopupMenu(true);
        tabelaGramatica.setUpdateSelectionOnSort(false);
        jScrollPane1.setViewportView(tabelaGramatica);
        if (tabelaGramatica.getColumnModel().getColumnCount() > 0) {
            tabelaGramatica.getColumnModel().getColumn(0).setResizable(false);
            tabelaGramatica.getColumnModel().getColumn(0).setPreferredWidth(3);
            tabelaGramatica.getColumnModel().getColumn(1).setResizable(false);
            tabelaGramatica.getColumnModel().getColumn(1).setHeaderValue("Não - Terminais");
            tabelaGramatica.getColumnModel().getColumn(2).setHeaderValue("Lado Direito da Produção");
        }

        adicionarLinhaGramatica.setText("Adicionar Nova Linha");
        adicionarLinhaGramatica.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                adicionarLinhaGramaticaActionPerformed(evt);
            }
        });

        salvarGramatica.setText("Salvar");
        salvarGramatica.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                salvarGramaticaActionPerformed(evt);
            }
        });

        resetarGramatica.setText("Resetar Gramática");
        resetarGramatica.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                resetarGramaticaActionPerformed(evt);
            }
        });

        jTextField2.setEditable(false);
        jTextField2.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        jTextField2.setText("Gramática Regular:");
        jTextField2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField2ActionPerformed(evt);
            }
        });

        jTextField3.setEditable(false);
        jTextField3.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        jTextField3.setText("Expressão Regular:");
        jTextField3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField3ActionPerformed(evt);
            }
        });

        jTextField4.setHorizontalAlignment(javax.swing.JTextField.CENTER);

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jTextField2, javax.swing.GroupLayout.PREFERRED_SIZE, 140, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addComponent(adicionarLinhaGramatica)
                                .addGap(18, 18, 18)
                                .addComponent(resetarGramatica)
                                .addGap(18, 18, 18)
                                .addComponent(salvarGramatica))
                            .addComponent(jTextField3, javax.swing.GroupLayout.PREFERRED_SIZE, 140, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(0, 48, Short.MAX_VALUE))
                    .addComponent(jTextField4))
                .addContainerGap())
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jTextField2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 126, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(adicionarLinhaGramatica)
                    .addComponent(resetarGramatica)
                    .addComponent(salvarGramatica))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 167, Short.MAX_VALUE)
                .addComponent(jTextField3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jTextField4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(47, 47, 47))
        );

        jButton1.setText("Sair");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jPanel3.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        jTextField5.setEditable(false);
        jTextField5.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        jTextField5.setText("Autômato Finito:");
        jTextField5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField5ActionPerformed(evt);
            }
        });

        tabelaAutomato.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        tabelaAutomato.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {

            }
        ));
        tabelaAutomato.setToolTipText("");
        tabelaAutomato.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        tabelaAutomato.setFocusable(false);
        tabelaAutomato.setGridColor(new java.awt.Color(0, 0, 0));
        tabelaAutomato.setInheritsPopupMenu(true);
        tabelaAutomato.getTableHeader().setReorderingAllowed(false);
        tabelaAutomato.setUpdateSelectionOnSort(false);
        jScrollPane2.setViewportView(tabelaAutomato);

        adicionarLinhaAutomato.setText("Adicionar Nova Linha");
        adicionarLinhaAutomato.setEnabled(false);
        adicionarLinhaAutomato.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                adicionarLinhaAutomatoActionPerformed(evt);
            }
        });

        resetaAutomato.setText("Criar Novo Automato");
        resetaAutomato.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                resetaAutomatoActionPerformed(evt);
            }
        });

        salvarAutomato.setText("Salvar");
        salvarAutomato.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                salvarAutomatoActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 379, Short.MAX_VALUE)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jTextField5, javax.swing.GroupLayout.PREFERRED_SIZE, 140, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(jPanel3Layout.createSequentialGroup()
                                .addComponent(adicionarLinhaAutomato)
                                .addGap(18, 18, 18)
                                .addComponent(resetaAutomato)
                                .addGap(18, 18, 18)
                                .addComponent(salvarAutomato)))
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jTextField5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 126, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(adicionarLinhaAutomato)
                    .addComponent(resetaAutomato)
                    .addComponent(salvarAutomato))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jButton1))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jButton1)
                .addContainerGap())
        );

        jTextField1.setEditable(false);
        jTextField1.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        jTextField1.setText("Alunos: Eduardo Beckhauser e Marcio Monteiro");
        jTextField1.setBorder(null);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, 425, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(100, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void salvarGramaticaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_salvarGramaticaActionPerformed
        producoesDaGramatica.clear();
        Simbolo origem;
        Producao conjuntoProducoes;
        for(int i = 0; i < tabelaGramatica.getRowCount(); i++){
            if(i == 0) //se ele eh o simbolo inicial da gramatica eh o simbolo inicial da gramatica
            origem = new Simbolo(String.valueOf(tabelaGramatica.getValueAt(i, 1)),0);
            else //se nao ele eh um simbolo nao terminal
            origem = new Simbolo(String.valueOf(tabelaGramatica.getValueAt(i, 1)),1);

           List<String> listaProducoes = Arrays.asList(String.valueOf(tabelaGramatica.getValueAt(i, 2)).split("\\|"));
            for (String s : listaProducoes){
                conjuntoProducoes = new Producao(origem);
                adicionaUmaProducao(s , conjuntoProducoes);
            }

        }
        gramatica.definirNovaGramatica(producoesDaGramatica);
    }//GEN-LAST:event_salvarGramaticaActionPerformed

    private void adicionarLinhaGramaticaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_adicionarLinhaGramaticaActionPerformed
        modeloGramatica.addRow(new Object[]{tabelaGramatica.getRowCount() + 1, "", ""});
    }//GEN-LAST:event_adicionarLinhaGramaticaActionPerformed

    private void resetarGramaticaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_resetarGramaticaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_resetarGramaticaActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
       System.exit(0);
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jTextField2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField2ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextField2ActionPerformed

    private void jTextField3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField3ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextField3ActionPerformed

    private void jTextField5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField5ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextField5ActionPerformed

    private void adicionarLinhaAutomatoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_adicionarLinhaAutomatoActionPerformed
        modeloAutomato.addRow(new Object[]{""});
    }//GEN-LAST:event_adicionarLinhaAutomatoActionPerformed

    private void resetaAutomatoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_resetaAutomatoActionPerformed
        automato.resetarAutomato();
        String alfabeto = retornaAlfabeto();
        if(alfabeto == null)
            return;
        while(alfabeto.isEmpty())
            alfabeto = retornaAlfabeto();
        
        List<String> nomeSimbolos = Arrays.asList(alfabeto.split("\\,"));
            for (String s : nomeSimbolos)
                automato.alfabeto.add(new SimboloAlfabeto(s));
            
            adicionarLinhaAutomato.setEnabled(true);
            criarColunasAPartirDoAlfabeto();
    }//GEN-LAST:event_resetaAutomatoActionPerformed

    private void salvarAutomatoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_salvarAutomatoActionPerformed
       int numLinhas = tabelaAutomato.getRowCount();
       int numColunas = tabelaAutomato.getColumnCount();
       data = new Object[tabelaAutomato.getRowCount()][tabelaAutomato.getColumnCount()];
       for(int i = 0; i < tabelaAutomato.getRowCount(); i++){
           for(int j = 0; j < tabelaAutomato.getColumnCount(); j++){
               data[i][j] = tabelaAutomato.getValueAt(i, j);
           }  
       }
       automato.tratarDadosEntrada(data, numLinhas, numColunas);
    }//GEN-LAST:event_salvarAutomatoActionPerformed

    
    //GRAMATICA
    /**
     * Adiciona um novo conjunto de producoes da gramatica a partir dos dados digitados pelo usuario.
     * @param s Producao a ser inserida na gramatica
     * @param producao Producao à qual deve-se inserir um naoterminal e um terminal para a composicao da mesma.
     */
    public void adicionaUmaProducao(String s, Producao producao){
            producao.terminal = s.substring(0, 1);
            try{
                producao.naoTerminal = s.substring(1, 2);
            } catch(Exception e){
                producao.naoTerminal = "";
            }
        producoesDaGramatica.add(producao);
    }
    
    
    
    //AUTOMATO
    /**
     * Função que recebe um novo alfabeto quando ao automato é ressetado.
     * @return Um novo alfabeto
     */
    public String retornaAlfabeto(){
        String alfabeto;
        try{
            alfabeto = JOptionPane.showInputDialog("Digite o alfabeto do seu autômato separado por virgulas, sem espaços. (Ex.a,b,c)");
        }catch(Exception e){
            return "";
        }
        return alfabeto;      
    }
    
    /**
     * Função que cria as colunas a partir do alfabeto inserido pelo usuario
     */
    public void criarColunasAPartirDoAlfabeto(){   
      columnNames = null;
      data = new Object[0][0];
      columnNames = new String[automato.alfabeto.size()+1];
      
      int i = 1;
      columnNames[0] = "δ";
      for(Iterator<SimboloAlfabeto> it = automato.alfabeto.iterator(); it.hasNext();){
          columnNames[i] = it.next().nome;
          i++;
      }
      
      modeloAutomato = new DefaultTableModel(data, columnNames);
      tabelaAutomato.setModel(modeloAutomato);
        
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

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton adicionarLinhaAutomato;
    private javax.swing.JButton adicionarLinhaGramatica;
    private javax.swing.JButton jButton1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTabbedPane jTabbedPane1;
    private javax.swing.JTextField jTextField1;
    private javax.swing.JTextField jTextField2;
    private javax.swing.JTextField jTextField3;
    private javax.swing.JTextField jTextField4;
    private javax.swing.JTextField jTextField5;
    private javax.swing.JButton resetaAutomato;
    private javax.swing.JButton resetarGramatica;
    private javax.swing.JButton salvarAutomato;
    private javax.swing.JButton salvarGramatica;
    private javax.swing.JTable tabelaAutomato;
    private javax.swing.JTable tabelaGramatica;
    // End of variables declaration//GEN-END:variables
}
