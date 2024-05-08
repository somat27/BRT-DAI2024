/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package Menus;


import com.google.zxing.BarcodeFormat;
import com.google.zxing.MultiFormatWriter;
import com.google.zxing.common.BitMatrix;
import javax.swing.ImageIcon;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.HashMap;
import java.util.Map;
import com.google.zxing.EncodeHintType;
import com.google.zxing.WriterException;
import com.google.zxing.qrcode.decoder.ErrorCorrectionLevel;
import java.awt.image.BufferedImage;
import java.io.UnsupportedEncodingException;



/**
 *
 * @author tomas
 */
public class MenuBilhetes extends javax.swing.JFrame {

    private final Connection con;
    
    public void GerarQrCode() {
        String QrCodeData = LerBaseDados();

        try {
            String charset = "UTF-8";

            Map <EncodeHintType, ErrorCorrectionLevel> hintMap = new HashMap <EncodeHintType, ErrorCorrectionLevel> ();
            hintMap.put(EncodeHintType.ERROR_CORRECTION, ErrorCorrectionLevel.L);
            BitMatrix matrix = new MultiFormatWriter().encode(new String (QrCodeData.getBytes(charset), charset), 
                    BarcodeFormat.QR_CODE,350,350,hintMap);

            //MatrixToImageWriter.writeToFile(matrix,filePath.substring(filePath.lastIndexOf('.')+1), new File(filePath));
            // Convertendo a matriz BitMatrix em uma imagem BufferedImage
            int width = matrix.getWidth();
            int height = matrix.getHeight();
            BufferedImage image = new BufferedImage(width, height, BufferedImage.TYPE_INT_RGB);
            for (int y = 0; y < height; y++) {
                for (int x = 0; x < width; x++) {
                    image.setRGB(x, y, matrix.get(x, y) ? 0xFF000000 : 0xFFFFFFFF);
                }
            }

            // Convertendo a imagem BufferedImage em um ImageIcon
            ImageIcon icon = new ImageIcon(image);
            QrCode.setIcon(icon);
            QrCode.revalidate();
            QrCode.repaint();

            TextoCaminho.setText("<html>" + QrCodeData.replaceAll("<","&lt;").replaceAll(">", "&gt;").replaceAll("\n", "<br/>") + "</html>");
        } catch (WriterException | UnsupportedEncodingException e) {
            System.out.println(e);
        }
    }
    
    public String LerBaseDados() {        
        Statement st;
        ResultSet rs;
        String resultado = "";

        try {
            st = con.createStatement();
            rs = st.executeQuery("SELECT * FROM BilhetesUnicos");

            while (rs.next()) {
                String linha = rs.getString("Linha");
                int quantidade = rs.getInt("Quantidade_Bilhetes");
                
                if(quantidade>0)
                    resultado = resultado + quantidade + " - " + linha + "\n";
            }
            st.close();
            rs.close();
            //String resultado = quantidadeAmarela + " - Amarela \n" + quantidadeVerde + " - Verde \n" + quantidadeAzul + " - Azul \n" + quantidadeVermelha + " - Vermelha";
            return resultado;
        } catch (SQLException ex) {
            Logger.getLogger(MenuBilhetes.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }
    
    private final int pagina = 0;
    /**
     * Creates new form Login_Application
     * @param con
     */
    public MenuBilhetes(Connection con) {
        initComponents();
        this.con = con;
        GerarQrCode();
        BotaoAnterior.setEnabled(false);
     }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        Fundo = new javax.swing.JPanel();
        Topo = new java.awt.Panel();
        TUB_logo = new javax.swing.JLabel();
        BotaoVoltar = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        BotaoAnterior = new javax.swing.JButton();
        BotaoProximo = new javax.swing.JButton();
        TextoPercurso = new javax.swing.JLabel();
        TextoCaminho = new javax.swing.JLabel();
        QrCode = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setBackground(new java.awt.Color(0, 71, 103));
        setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        setIconImages(null);
        setUndecorated(true);
        setResizable(false);
        setSize(new java.awt.Dimension(440, 920));

        Fundo.setBackground(new java.awt.Color(0, 71, 103));
        Fundo.setForeground(new java.awt.Color(0, 71, 103));

        Topo.setBackground(new java.awt.Color(3, 125, 190));
        Topo.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));

        TUB_logo.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        TUB_logo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Assets/TUB.png"))); // NOI18N

        BotaoVoltar.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        BotaoVoltar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Assets/seta-esquerda.png"))); // NOI18N
        BotaoVoltar.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        BotaoVoltar.setMaximumSize(new java.awt.Dimension(70, 70));
        BotaoVoltar.setMinimumSize(new java.awt.Dimension(70, 70));
        BotaoVoltar.setPreferredSize(new java.awt.Dimension(70, 70));
        BotaoVoltar.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                BotaoVoltarMouseClicked(evt);
            }
        });

        jLabel2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Assets/notificacao.png"))); // NOI18N

        jLabel3.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Assets/do-utilizador.png"))); // NOI18N

        javax.swing.GroupLayout TopoLayout = new javax.swing.GroupLayout(Topo);
        Topo.setLayout(TopoLayout);
        TopoLayout.setHorizontalGroup(
            TopoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(TopoLayout.createSequentialGroup()
                .addComponent(BotaoVoltar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 33, Short.MAX_VALUE)
                .addComponent(TUB_logo, javax.swing.GroupLayout.PREFERRED_SIZE, 235, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
        TopoLayout.setVerticalGroup(
            TopoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jLabel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(BotaoVoltar, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(TUB_logo, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        BotaoAnterior.setFont(new java.awt.Font("Arial Rounded MT Bold", 0, 12)); // NOI18N
        BotaoAnterior.setText("Único");
        BotaoAnterior.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        BotaoAnterior.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BotaoAnteriorActionPerformed(evt);
            }
        });

        BotaoProximo.setFont(new java.awt.Font("Arial Rounded MT Bold", 0, 12)); // NOI18N
        BotaoProximo.setText("Personalizado");
        BotaoProximo.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        BotaoProximo.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                BotaoProximoMouseClicked(evt);
            }
        });
        BotaoProximo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BotaoProximoActionPerformed(evt);
            }
        });

        TextoPercurso.setFont(new java.awt.Font("Arial Rounded MT Bold", 1, 36)); // NOI18N
        TextoPercurso.setForeground(new java.awt.Color(255, 255, 255));
        TextoPercurso.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        TextoPercurso.setText("Bilhetes Únicos");

        TextoCaminho.setFont(new java.awt.Font("Arial Rounded MT Bold", 1, 24)); // NOI18N
        TextoCaminho.setForeground(new java.awt.Color(255, 255, 255));
        TextoCaminho.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        TextoCaminho.setText("Sem Bilhetes");

        QrCode.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        QrCode.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Assets/QrVazio.png")));
        QrCode.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);

        javax.swing.GroupLayout FundoLayout = new javax.swing.GroupLayout(Fundo);
        Fundo.setLayout(FundoLayout);
        FundoLayout.setHorizontalGroup(
            FundoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(Topo, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(FundoLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(TextoCaminho, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, FundoLayout.createSequentialGroup()
                .addGap(26, 26, 26)
                .addComponent(BotaoAnterior, javax.swing.GroupLayout.PREFERRED_SIZE, 140, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(BotaoProximo, javax.swing.GroupLayout.PREFERRED_SIZE, 140, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(26, 26, 26))
            .addGroup(FundoLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(TextoPercurso, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
            .addGroup(FundoLayout.createSequentialGroup()
                .addGap(42, 42, 42)
                .addComponent(QrCode, javax.swing.GroupLayout.PREFERRED_SIZE, 350, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        FundoLayout.setVerticalGroup(
            FundoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(FundoLayout.createSequentialGroup()
                .addComponent(Topo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(2, 2, 2)
                .addComponent(TextoPercurso, javax.swing.GroupLayout.PREFERRED_SIZE, 104, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(FundoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(BotaoAnterior, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(BotaoProximo, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(TextoCaminho, javax.swing.GroupLayout.PREFERRED_SIZE, 251, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(51, 51, 51)
                .addComponent(QrCode, javax.swing.GroupLayout.PREFERRED_SIZE, 350, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(45, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(Fundo, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(Fundo, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void BotaoAnteriorActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BotaoAnteriorActionPerformed

    }//GEN-LAST:event_BotaoAnteriorActionPerformed

    private void BotaoProximoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BotaoProximoActionPerformed
        
    }//GEN-LAST:event_BotaoProximoActionPerformed

    private void BotaoVoltarMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_BotaoVoltarMouseClicked
        dispose();
        MenuBRT Voltar = new MenuBRT();
        Voltar.setVisible(true);
    }//GEN-LAST:event_BotaoVoltarMouseClicked

    private void BotaoProximoMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_BotaoProximoMouseClicked
        dispose();
        MenuBilhetePersonalizado Menu = new MenuBilhetePersonalizado(con);
        Menu.setVisible(true);
    }//GEN-LAST:event_BotaoProximoMouseClicked


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton BotaoAnterior;
    private javax.swing.JButton BotaoProximo;
    private javax.swing.JLabel BotaoVoltar;
    private javax.swing.JPanel Fundo;
    private javax.swing.JLabel QrCode;
    private javax.swing.JLabel TUB_logo;
    private javax.swing.JLabel TextoCaminho;
    private javax.swing.JLabel TextoPercurso;
    private java.awt.Panel Topo;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    // End of variables declaration//GEN-END:variables
}
