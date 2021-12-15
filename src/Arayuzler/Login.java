//
// Login.java
//
package Arayuzler;

import Siniflar.Personel;
import static Siniflar.Sabitler.FONK;
import static Siniflar.Sabitler.PERSONELUSER;
import javax.swing.JOptionPane;

public class Login extends javax.swing.JFrame {

  public Login() {
    // Sabitler.java'da seçtiğimiz TEMA aktif olsun.
    FONK.startWindowsTheme();
    // Arayüz nesnelerinin yüklenmesi.
    initComponents();
    // Panel, ekranın ortasında açılır.
    setLocationRelativeTo(null);
    // Tüm pencerelerde programa ait temel ikon gösterilir.
    FONK.setIcon(this);
  }

  @SuppressWarnings("unchecked")
  // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
  private void initComponents() {

    jLabel2 = new javax.swing.JLabel();
    txtUser = new javax.swing.JTextField();
    jLabel3 = new javax.swing.JLabel();
    btnLogin = new javax.swing.JButton();
    jLabel1 = new javax.swing.JLabel();
    txtPass = new javax.swing.JPasswordField();
    jSeparator1 = new javax.swing.JSeparator();

    setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
    setTitle("Depo Yönetim Sistemi | Giriş");
    setIconImages(null);
    setResizable(false);

    jLabel2.setFont(new java.awt.Font("Tahoma", 1, 15)); // NOI18N
    jLabel2.setText("Şifre :");

    txtUser.setFont(new java.awt.Font("Tahoma", 1, 16)); // NOI18N
    txtUser.setToolTipText("Kullanıcı Adınız");

    jLabel3.setFont(new java.awt.Font("Tahoma", 1, 15)); // NOI18N
    jLabel3.setText("Kullanıcı Adı:");

    btnLogin.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
    btnLogin.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Arayuzler/images/login.png"))); // NOI18N
    btnLogin.setText("       GİRİŞ YAP");
    btnLogin.setToolTipText("Giriş yapmak için tıklayın.");
    btnLogin.addActionListener(new java.awt.event.ActionListener() {
      public void actionPerformed(java.awt.event.ActionEvent evt) {
        btnLoginActionPerformed(evt);
      }
    });

    jLabel1.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
    jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
    jLabel1.setText("DEPO YÖNETİM SİSTEMİ");

    txtPass.setFont(new java.awt.Font("Tahoma", 1, 16)); // NOI18N
    txtPass.setToolTipText("Şifreniz");

    jSeparator1.setForeground(new java.awt.Color(204, 204, 204));

    javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
    getContentPane().setLayout(layout);
    layout.setHorizontalGroup(
      layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
      .addGroup(layout.createSequentialGroup()
        .addGap(36, 36, 36)
        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
          .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 322, javax.swing.GroupLayout.PREFERRED_SIZE)
          .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
            .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, 324, Short.MAX_VALUE)
            .addGroup(layout.createSequentialGroup()
              .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addComponent(jLabel2, javax.swing.GroupLayout.Alignment.TRAILING)
                .addComponent(jLabel3, javax.swing.GroupLayout.Alignment.TRAILING))
              .addGap(18, 18, 18)
              .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                .addComponent(txtUser)
                .addComponent(btnLogin, javax.swing.GroupLayout.DEFAULT_SIZE, 206, Short.MAX_VALUE)
                .addComponent(txtPass)))))
        .addContainerGap(40, Short.MAX_VALUE))
    );
    layout.setVerticalGroup(
      layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
      .addGroup(layout.createSequentialGroup()
        .addGap(22, 22, 22)
        .addComponent(jLabel1)
        .addGap(18, 18, 18)
        .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
        .addGap(22, 22, 22)
        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
          .addComponent(txtUser, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
          .addComponent(jLabel3))
        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
          .addComponent(jLabel2)
          .addComponent(txtPass, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        .addGap(35, 35, 35)
        .addComponent(btnLogin, javax.swing.GroupLayout.PREFERRED_SIZE, 51, javax.swing.GroupLayout.PREFERRED_SIZE)
        .addContainerGap(35, Short.MAX_VALUE))
    );

    pack();
  }// </editor-fold>//GEN-END:initComponents

    private void btnLoginActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnLoginActionPerformed
    Personel personel = FONK.kontrolUserPass(txtUser.getText(), new String(txtPass.getPassword()));

    if (personel != null) {
      if (PERSONELUSER.equals("root")) {
        new AdminPanel().setVisible(true);
      } else {
        new PersonelPanel().setVisible(true);
      }
      this.dispose();
    } else {
      JOptionPane.showMessageDialog(this, "Kullanıcı Adı veya Şifre hatalı!\n"
              + "Lütfen yeniden deneyiniz...", "Giriş yapılamadı!", 2);

      txtUser.setText("");
      txtPass.setText("");
      txtUser.requestFocus();
    }
    }//GEN-LAST:event_btnLoginActionPerformed

  // Variables declaration - do not modify//GEN-BEGIN:variables
  private javax.swing.JButton btnLogin;
  private javax.swing.JLabel jLabel1;
  private javax.swing.JLabel jLabel2;
  private javax.swing.JLabel jLabel3;
  private javax.swing.JSeparator jSeparator1;
  private javax.swing.JPasswordField txtPass;
  private javax.swing.JTextField txtUser;
  // End of variables declaration//GEN-END:variables
}
