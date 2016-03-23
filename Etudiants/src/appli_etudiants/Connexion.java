/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package appli_etudiants;

import com.mysql.jdbc.Connection;
import java.security.NoSuchAlgorithmException;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

/**
 *
 * @author nc
 */
public class Connexion extends javax.swing.JDialog {
    private InterfaceGraphique fenetre;
    /**
     * Creates new form Connexion
     */
     
    public Connexion(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        initComponents();
        //positionnement au milieu de la fenetre parente
        this.setLocationRelativeTo(parent);
        //modal==true signifie que l'on ne peut pas revenir 
        //sur la precedente fenêtre dans fermer connexion
        this.setModal(true);
        //on stocke dans this.fenetre la référence vers la fenetre parente
        this.fenetre=(InterfaceGraphique)parent;
    }

    

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jDialog1 = new javax.swing.JDialog();
        jButtonConnecter = new javax.swing.JButton();
        jPassMDP = new javax.swing.JPasswordField();
        jLabelMDP = new javax.swing.JLabel();
        jLabelIdentifiant = new javax.swing.JLabel();
        jTextFieldIdentifiant = new javax.swing.JTextField();
        jLabelConnexionCompte = new javax.swing.JLabel();
        jLabelBackgroundConnexion = new javax.swing.JLabel();

        org.jdesktop.layout.GroupLayout jDialog1Layout = new org.jdesktop.layout.GroupLayout(jDialog1.getContentPane());
        jDialog1.getContentPane().setLayout(jDialog1Layout);
        jDialog1Layout.setHorizontalGroup(
            jDialog1Layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
            .add(0, 400, Short.MAX_VALUE)
        );
        jDialog1Layout.setVerticalGroup(
            jDialog1Layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
            .add(0, 300, Short.MAX_VALUE)
        );

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Connexion");
        setBackground(new java.awt.Color(64, 64, 64));
        setModal(true);
        setResizable(false);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jButtonConnecter.setText("Connexion");
        jButtonConnecter.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonConnecterActionPerformed(evt);
            }
        });
        getContentPane().add(jButtonConnecter, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 250, 100, 30));

        jPassMDP.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        jPassMDP.setCaretColor(new java.awt.Color(240, 240, 240));
        getContentPane().add(jPassMDP, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 200, 320, -1));

        jLabelMDP.setFont(new java.awt.Font("Tahoma", 1, 15)); // NOI18N
        jLabelMDP.setForeground(new java.awt.Color(240, 240, 240));
        jLabelMDP.setText("Mot de passe");
        getContentPane().add(jLabelMDP, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 170, -1, 20));

        jLabelIdentifiant.setFont(new java.awt.Font("Tahoma", 1, 15)); // NOI18N
        jLabelIdentifiant.setForeground(new java.awt.Color(240, 240, 240));
        jLabelIdentifiant.setText("Identifiant");
        getContentPane().add(jLabelIdentifiant, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 100, 80, -1));

        jTextFieldIdentifiant.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        jTextFieldIdentifiant.setCaretColor(new java.awt.Color(240, 240, 240));
        getContentPane().add(jTextFieldIdentifiant, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 130, 320, -1));

        jLabelConnexionCompte.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabelConnexionCompte.setForeground(new java.awt.Color(240, 240, 240));
        jLabelConnexionCompte.setText("Connexion au compte");
        getContentPane().add(jLabelConnexionCompte, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 10, -1, -1));

        jLabelBackgroundConnexion.setIcon(new javax.swing.ImageIcon(getClass().getResource("/appli_etudiants/image/background_bleu4.jpg"))); // NOI18N
        getContentPane().add(jLabelBackgroundConnexion, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 470, 330));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButtonConnecterActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonConnecterActionPerformed
        // TODO add your handling code here:
        /**
         * Code ici qui va interroger la base de données
         */
        //Vérification des saisies
        if (jTextFieldIdentifiant.getText().length()==0 || jPassMDP.getText().length()==0){
            JOptionPane.showMessageDialog(this, "Erreur de saisie, les deux champs doivent être renseignés.");
            
            this.fenetre.deconnecte();
        }else{
            
            try {
                //interrogation de la BD pour savoir si l'identifiant/mot de passe est correct
                //instanciation de la classe Driver du paquetage jdbc de mysql
                Class.forName("com.mysql.jdbc.Driver");
                //Chaine de connexion (prise dans l'onglet services)
                String connexionUrl="jdbc:mysql://localhost:3306/applietudiants?user=applietudiants&password=sio";
               
                //etablissement de la connexion
                Connection maConnexion=(Connection)DriverManager.getConnection(connexionUrl);
                
                //requete
                Statement requete=maConnexion.createStatement();
                String identifiant=jTextFieldIdentifiant.getText();
                String mdp=jPassMDP.getText();
                
            
                //application du cryptage md5 au mdp
                // ici on appelle md5 membre static de la classe outils
                mdp=Outils.md5(mdp);
            
                ResultSet lignesRetournees=requete.executeQuery("select * from Utilisateurs where identifiant='"+identifiant+"' and mot_de_passe='"+mdp+"'");
                if (lignesRetournees.next()){
                    String nom=lignesRetournees.getString("nom");
                    String prenom=lignesRetournees.getString("prenom");
                    String courriel=lignesRetournees.getString("courriel");
                    String numtel=lignesRetournees.getString("num_de_telephone");
                    String ddn=lignesRetournees.getString("date_de_naissance");
                    String adresse=lignesRetournees.getString("adresse");
                    String ville=lignesRetournees.getString("ville");
                   
                  
                    //Modifications de la Mission 2 à placer ici
                 
                    this.fenetre.connecte(nom,prenom,courriel,numtel,ddn,adresse,identifiant,ville);
                    this.setVisible(false);
                    this.fenetre.majConnexion();
                   
                    
             
                    
                    
                }else{
                    JOptionPane.showMessageDialog(rootPane, "identifiant ou mot de passe incorrect");
                };
                
                
            } catch (ClassNotFoundException ex) {
                JOptionPane.showMessageDialog(rootPane, "Classe de connexion mysql non trouvee..."+ex.toString());
            }
             catch (SQLException ex) {
                JOptionPane.showMessageDialog(rootPane, "SQL exception ... "+ex.toString());
            }
            catch (NoSuchAlgorithmException ex) {
                    Logger.getLogger(Connexion.class.getName()).log(Level.SEVERE, null, ex);
            }

        }
        

    }//GEN-LAST:event_jButtonConnecterActionPerformed
 

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
            java.util.logging.Logger.getLogger(Connexion.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Connexion.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Connexion.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Connexion.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the dialog */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                Connexion dialog = new Connexion(new javax.swing.JFrame(), true);
                dialog.addWindowListener(new java.awt.event.WindowAdapter() {
                    @Override
                    public void windowClosing(java.awt.event.WindowEvent e) {
                        System.exit(0);
                    }
                });
                dialog.setVisible(true);
            }
        });
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButtonConnecter;
    private javax.swing.JDialog jDialog1;
    private javax.swing.JLabel jLabelBackgroundConnexion;
    private javax.swing.JLabel jLabelConnexionCompte;
    private javax.swing.JLabel jLabelIdentifiant;
    private javax.swing.JLabel jLabelMDP;
    private javax.swing.JPasswordField jPassMDP;
    private javax.swing.JTextField jTextFieldIdentifiant;
    // End of variables declaration//GEN-END:variables
}