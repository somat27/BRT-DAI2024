/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package Menus;


import com.sun.jdi.connect.spi.Connection;
import javax.swing.ImageIcon;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;



/**
 *
 * @author tomas
 */
public class MenuBilhetePersonalizado extends javax.swing.JFrame {
    String linhaSelecionada = "Amarela";
    // Adicionar no Anterior e no Proximo o nome das linhas, e muda automaticamente quando se clica
    public void iniciarBilhete() {
        BotaoAnterior.setEnabled(false);
        BotaoAnterior.setVisible(false);
        BotaoAnterior.setText("");
        BotaoProximo.setText("Linha Azul >>");
        TextoPercurso.setText("Bilhetes - Amarela");
    }
    
    public String[] LerBaseDados() {        
        java.sql.Connection con = null;
        Statement st = null;
        ResultSet rs = null;
        List<String> resultados = new ArrayList<>();

        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            con = DriverManager.getConnection("jdbc:mysql://sql11.freesqldatabase.com:3306/sql11702206", "sql11702206", "95uBqxnYKt");
            st = con.createStatement();
            rs = st.executeQuery("SELECT * FROM Bilhetes");

            while (rs.next()) {
                String linha = rs.getString("Linha");
                //String quantidade = rs.getString("Quantidade_Bilhetes");
                //String tipo = rs.getString("Tipo_Bilhete");
                
                String direcao = rs.getString("Direcao");
                String horario = rs.getString("Horario");
                String estacao = rs.getString("Estacao");

                //resultados.add("Linha: " + linha + ", Quantidade: " + quantidade + ", Tipo: " + tipo);
                System.out.println(linha + " " + direcao + " " + horario + " " + estacao);
            }
        } catch (ClassNotFoundException | SQLException ex) {
            Logger.getLogger(MenuBilhetePersonalizado.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            try {
                if (rs != null) rs.close();
                if (st != null) st.close();
                if (con != null) con.close();
            } catch (SQLException ex) {
                Logger.getLogger(MenuBilhetePersonalizado.class.getName()).log(Level.SEVERE, null, ex);
            }
        }

        return null;//resultados.toArray(new String[0]);
    }

    
    public void mudarInfoTexto() {
        String BaseDadosString[] = LerBaseDados();
        if(BaseDadosString != null){
            String quantidadeBilhetes = BaseDadosString[2];
            String filePath = System.getProperty("user.dir")+ "\\src\\Assets\\QrCodes\\Qr-" + linhaSelecionada + quantidadeBilhetes + ".png";
            ImageIcon icon = new ImageIcon(filePath);
            QrCode.setIcon(icon);
            QrCode.revalidate();
            QrCode.repaint();
            
            TextoCaminho.setText("\nQuantidade: " + quantidadeBilhetes);
        } else {
            String filePath = System.getProperty("user.dir")+ "\\src\\Assets\\QrCodes\\QrVazio.png";
            ImageIcon icon = new ImageIcon(filePath);
            QrCode.setIcon(icon);
            QrCode.revalidate();
            QrCode.repaint();
            
            TextoCaminho.setText("Quantidade: 0");
        }
    } 
    
    private int pagina = 0;
    /**
     * Creates new form Login_Application
     */
    public MenuBilhetePersonalizado() {
        initComponents();
        //iniciarBilhete();
        //mudarInfoTexto();
        BotaoProximo.setEnabled(false);
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

        BotaoAnterior.setText("Único");
        BotaoAnterior.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        BotaoAnterior.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                BotaoAnteriorMouseClicked(evt);
            }
        });
        BotaoAnterior.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BotaoAnteriorActionPerformed(evt);
            }
        });

        BotaoProximo.setText("Personalizado");
        BotaoProximo.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        BotaoProximo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BotaoProximoActionPerformed(evt);
            }
        });

        TextoPercurso.setFont(new java.awt.Font("Arial Rounded MT Bold", 1, 36)); // NOI18N
        TextoPercurso.setForeground(new java.awt.Color(255, 255, 255));
        TextoPercurso.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        TextoPercurso.setText("Bilhetes");

        TextoCaminho.setFont(new java.awt.Font("Arial Rounded MT Bold", 1, 12)); // NOI18N
        TextoCaminho.setForeground(new java.awt.Color(255, 255, 255));
        TextoCaminho.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        TextoCaminho.setText("jLabel1");

        QrCode.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        QrCode.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Assets/QrCodes/QrVazio.png")));
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
                .addGap(45, 45, 45)
                .addComponent(QrCode, javax.swing.GroupLayout.PREFERRED_SIZE, 350, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        FundoLayout.setVerticalGroup(
            FundoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(FundoLayout.createSequentialGroup()
                .addComponent(Topo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(2, 2, 2)
                .addComponent(TextoPercurso, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(FundoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(BotaoAnterior, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(BotaoProximo, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(TextoCaminho, javax.swing.GroupLayout.PREFERRED_SIZE, 251, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(QrCode, javax.swing.GroupLayout.PREFERRED_SIZE, 350, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(90, 90, 90))
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
        if (linhaSelecionada.equals("Azul")) {
            TextoPercurso.setText("Bilhetes - Amarela");
            linhaSelecionada = "Amarela";
            
            BotaoAnterior.setEnabled(false);
            BotaoAnterior.setVisible(false);
            BotaoProximo.setEnabled(true);
            
            BotaoProximo.setText("Linha Azul >>");
            BotaoAnterior.setText("");
        } else if (linhaSelecionada.equals("Verde")) {
            TextoPercurso.setText("Bilhetes - Azul");
            linhaSelecionada = "Azul";
            
            BotaoAnterior.setEnabled(true);
            BotaoProximo.setEnabled(true);
            
            BotaoProximo.setText("Linha Verde >>");
            BotaoAnterior.setText("<< Linha Amarela");
        } else if (linhaSelecionada.equals("Vermelha")) {
            TextoPercurso.setText("Bilhetes - Verde");
            linhaSelecionada = "Verde";
            
            BotaoAnterior.setEnabled(true);
            BotaoProximo.setEnabled(true);
            BotaoProximo.setVisible(true);
            
            BotaoProximo.setText("Linha Vermelha >>");
            BotaoAnterior.setText("<< Linha Azul");
        }
        mudarInfoTexto();
    }//GEN-LAST:event_BotaoAnteriorActionPerformed

    private void BotaoProximoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BotaoProximoActionPerformed
        if (linhaSelecionada.equals("Amarela")) {
            TextoPercurso.setText("Bilhetes - Azul");
            linhaSelecionada = "Azul";
            
            BotaoAnterior.setEnabled(true);
            BotaoAnterior.setVisible(true);
            BotaoProximo.setEnabled(true);
            
            BotaoProximo.setText("Linha Verde >>");
            BotaoAnterior.setText("<< Linha Amarela");
        } else if (linhaSelecionada.equals("Azul")) {
            TextoPercurso.setText("Bilhetes - Verde");
            linhaSelecionada = "Verde";
            
            BotaoAnterior.setEnabled(true);
            BotaoProximo.setEnabled(true);
            BotaoProximo.setVisible(true);
            
            BotaoProximo.setText("Linha Vermelha >>");
            BotaoAnterior.setText("<< Linha Azul");
        } else if (linhaSelecionada.equals("Verde")) {
            TextoPercurso.setText("Bilhetes - Vermelha");
            linhaSelecionada = "Vermelha";
            
            BotaoAnterior.setEnabled(true);
            BotaoProximo.setEnabled(false);
            BotaoProximo.setVisible(false);
            
            BotaoProximo.setText("");
            BotaoAnterior.setText("<< Linha Verde");
        }
        mudarInfoTexto();
    }//GEN-LAST:event_BotaoProximoActionPerformed

    private void BotaoVoltarMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_BotaoVoltarMouseClicked
        dispose();
        MenuBRT Voltar = new MenuBRT();
        Voltar.setVisible(true);
    }//GEN-LAST:event_BotaoVoltarMouseClicked

    private void BotaoAnteriorMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_BotaoAnteriorMouseClicked
        dispose();
        MenuBilhetes Menu = new MenuBilhetes();
        Menu.setVisible(true);
    }//GEN-LAST:event_BotaoAnteriorMouseClicked

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new MenuBilhetePersonalizado().setVisible(true);
            }
        });
    }

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
