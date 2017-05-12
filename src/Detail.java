

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Shobhit Agarwal
 */
public class Detail extends javax.swing.JFrame {

    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	/**
     * Creates new form Detail
     */
    public Detail() {
        initComponents();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
   
    // <editor-fold defaultstate="collapsed" desc="Generated Code">                          
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        jTextArea1 = new javax.swing.JTextArea();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("How To Play");

        jTextArea1.setEditable(false);
        jTextArea1.setColumns(20);
        jTextArea1.setLineWrap(true);
        jTextArea1.setRows(5);
        jTextArea1.setText("Each player uses both hands to play the game, the number of digits extended on a hand showing the number of points that the hand has. Both players start with each hand having one point � one finger extended on each hand. The goal of the game is for a player to force their opponent to extend all of their fingers and thumbs on both hands. A hand with all fingers and its thumb extended is called a \"dead hand\". Players take turns to tap one of their hands against another hand that is not dead (either their own other hand, or one of their opponent's). The number of points on the tapping hand is added to the number on the tapped hand, and the player with the tapped hand extends their digits to show the new score. The tapping hand remains unchanged.\n\nA player may tap their own hand to transfer points from one hand to the other. For example, if a player had three points on his or her right hand and one on his or her left, the player could rearrange them to have two on each hand. A \"dead hand\" is treated as having no points, for this purpose, which allows a player to bring a dead hand back into play by transferring points to it. You cannot prolong the game by not taking your turn.\n\nChopsticks can also be played the way mentioned above except if one hand gets more than five points the leftover points are left on the hand. This means that five is subtracted from the number of points that one hand gets, and the only way a hand can get knocked out is if it accumulates another five or more points. For example, if a player has four on a hand and the other transfers three points to that hand, the hand gets two points (since 3 + 4 = 7 and 7 Mod 5 = 2 ). This way of playing is generally for more advanced players and requires more strategy.\n\nPlayers are allowed to evenly divide an even number of points in one hand to an empty hand or combine two hands, an action known as \"split\". For example, a player with a dead hand and four fingers on the other can use their turn to \"split\" the points 2:2. This variation is quite commonly played in India. The players can split the finger count any way they want. If they have a 4/1 distribution, they can split that to 3/2. This variation is sometimes played instead of allowing transfers or redistributions.\n\nTransferring or splitting points between the two hands is not allowed when the values of both hands merely switch places, as it could be used as in tactic to unnecessarily prolong the game. For example, if a player's left hand has three points and their right hand has two points, they are allowed to transfer points such that one hand has four points and the other hand has one point, but it would be an illegal move to transfer three to the right hand and two the left hand. It would also be illegal, if a player has one point on one hand and one dead hand, to transfer the one point to the dead hand.");
        jTextArea1.setWrapStyleWord(true);
        jScrollPane1.setViewportView(jTextArea1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(30, 30, 30)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 577, Short.MAX_VALUE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 476, Short.MAX_VALUE)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>                        

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
            java.util.logging.Logger.getLogger(Detail.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Detail.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Detail.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Detail.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
    }
        //</editor-fold>

        /* Create and display the form */
        

    // Variables declaration - do not modify                     
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextArea jTextArea1;
    // End of variables declaration                   
}
