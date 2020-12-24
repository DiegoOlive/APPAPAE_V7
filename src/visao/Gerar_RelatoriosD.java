
package visao;
import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.pdf.PdfPCell;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfWriter;
import controle.OperacaoDoacao;
import java.awt.Desktop;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.logging.Logger;
import modelo.Doacao;

public class Gerar_RelatoriosD extends javax.swing.JFrame {
    private boolean per;
    /** Creates new form Gerar_Relatorios */
    public Gerar_RelatoriosD() {
        initComponents();
    }

    /** This method is called from within the constructor to
     * initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is
     * always regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel9 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        btn_gerar = new javax.swing.JButton();
        txt_data2 = new javax.swing.JFormattedTextField();
        btRetornar = new javax.swing.JButton();
        txt_data1 = new javax.swing.JFormattedTextField();
        jLabel7 = new javax.swing.JLabel();
        btn_modulo = new javax.swing.JButton();
        jLabel5 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setResizable(false);

        jPanel1.setBackground(new java.awt.Color(0, 18, 30));

        jLabel9.setForeground(new java.awt.Color(62, 150, 206));
        jLabel9.setText("Data inicial");

        jLabel10.setForeground(new java.awt.Color(62, 150, 206));
        jLabel10.setText("Data final:");

        btn_gerar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/visao/imagens/botao_gerar.png"))); // NOI18N
        btn_gerar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_gerarActionPerformed(evt);
            }
        });

        try {
            txt_data2.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.MaskFormatter("##/##/####")));
        } catch (java.text.ParseException ex) {
            ex.printStackTrace();
        }

        btRetornar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/visao/imagens/seta.png"))); // NOI18N
        btRetornar.setToolTipText("VOLTAR");
        btRetornar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btRetornarActionPerformed(evt);
            }
        });

        try {
            txt_data1.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.MaskFormatter("##/##/####")));
        } catch (java.text.ParseException ex) {
            ex.printStackTrace();
        }

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(33, 33, 33)
                .addComponent(btRetornar, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(1162, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addComponent(btn_gerar, javax.swing.GroupLayout.PREFERRED_SIZE, 125, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(574, 574, 574))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel9)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txt_data2, javax.swing.GroupLayout.PREFERRED_SIZE, 98, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(120, 120, 120)
                        .addComponent(jLabel10)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txt_data1, javax.swing.GroupLayout.PREFERRED_SIZE, 98, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(422, 422, 422))))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(244, 244, 244)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel10)
                    .addComponent(jLabel9)
                    .addComponent(txt_data1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txt_data2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(132, 132, 132)
                .addComponent(btn_gerar, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 103, Short.MAX_VALUE)
                .addComponent(btRetornar, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        jLabel7.setIcon(new javax.swing.ImageIcon(getClass().getResource("/visao/imagens/logo_doacoes.png"))); // NOI18N

        btn_modulo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/visao/imagens/bt_modulo1.jpg"))); // NOI18N
        btn_modulo.setToolTipText("MODULOS");
        btn_modulo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_moduloActionPerformed(evt);
            }
        });

        jLabel5.setIcon(new javax.swing.ImageIcon(getClass().getResource("/visao/imagens/logo_sistema.png"))); // NOI18N

        jLabel4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/visao/imagens/APAE.png"))); // NOI18N

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(533, Short.MAX_VALUE)
                .addComponent(jLabel4)
                .addGap(365, 365, 365)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel5)
                    .addComponent(btn_modulo, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(47, 47, 47))
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                    .addGap(49, 49, 49)
                    .addComponent(jLabel7)
                    .addContainerGap(1036, Short.MAX_VALUE)))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel5)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 428, Short.MAX_VALUE)
                        .addComponent(btn_modulo, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(jLabel4)))
                .addContainerGap())
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                    .addGap(23, 23, 23)
                    .addComponent(jLabel7)
                    .addContainerGap(592, Short.MAX_VALUE)))
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void btn_moduloActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_moduloActionPerformed
        Tela_Modulos tM = new Tela_Modulos();
        tM.permissao(per);
        tM.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_btn_moduloActionPerformed

    private void btRetornarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btRetornarActionPerformed
        Operacao_Doacao opDD = new Operacao_Doacao();
        opDD.permissao(per);
        opDD.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_btRetornarActionPerformed

    private void btn_gerarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_gerarActionPerformed
        Document document = new Document();
        try{
            PdfWriter.getInstance(document, new FileOutputStream("Relatorio_Doacoes.pdf"));
            document.open();
            Paragraph p = new Paragraph("Relatório de doações APAE");
            p.setAlignment(1);
            document.add(p);
            p = new Paragraph(" ");
            document.add(p);

            PdfPTable table = new PdfPTable(3);

            PdfPCell cel1 = new PdfPCell(new Paragraph("CPF"));
            PdfPCell cel2 = new PdfPCell(new Paragraph("Valor"));
            PdfPCell cel3 = new PdfPCell(new Paragraph("Data"));
            document.add(new Paragraph(""));

            table.addCell(cel1);
            table.addCell(cel2);
            table.addCell(cel3);

            Date d1=null;
            d1=conv(txt_data2.getText());
            Date d2=null;
            d2=conv(txt_data1.getText());
            
            OperacaoDoacao dd = new OperacaoDoacao();
            java.sql.Date datan1;
            datan1 = new java.sql.Date(d1.getTime());
            java.sql.Date datan2;
            datan2 = new java.sql.Date(d2.getTime());

            for(Doacao obj : dd.visualizaLista(null, datan1, datan2)){

                cel1 = new PdfPCell(new Paragraph(Long.toString(obj.getCpf())));
               cel2 = new PdfPCell(new Paragraph(Double.toString(obj.getValor())));
               cel3 = new PdfPCell(new Paragraph(obj.getData().toString()));
            
               table.addCell(cel1);
               table.addCell(cel2);
               table.addCell(cel3);

            }
            document.add(table);
            document.close();
        } catch (DocumentException de){
            System.err.println(de.getMessage());
        } catch (IOException ioe){
            System.err.println(ioe.getMessage());
        }
        try{
            Desktop.getDesktop().open(new File("Relatorio_Doacoes.pdf"));
        } catch(IOException ex){
            System.err.println(ex.getMessage());
        }
    }//GEN-LAST:event_btn_gerarActionPerformed

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
            java.util.logging.Logger.getLogger(Gerar_RelatoriosD.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Gerar_RelatoriosD.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Gerar_RelatoriosD.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Gerar_RelatoriosD.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Gerar_RelatoriosD().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btRetornar;
    private javax.swing.JButton btn_gerar;
    private javax.swing.JButton btn_modulo;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JFormattedTextField txt_data1;
    private javax.swing.JFormattedTextField txt_data2;
    // End of variables declaration//GEN-END:variables
 void permissao(boolean x) {
        per = x;
    }
 private Date conv(String data) {
        SimpleDateFormat exib=new SimpleDateFormat("dd/MM/yyyy");
        Date nova=null;
        try {
            nova =exib.parse(data);           
        } catch (ParseException ex) {
            Logger.getLogger(null,"Data inválida");
        }
 
        return nova;
    }

}