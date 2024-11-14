/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package pkg255project;

/**
 *
 * @author owenm
 */
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Random;

public class TicTacToe extends JFrame {
    JButton[][] nineButtons;
    HumanPlayer humanPlayer;
    ComputerPlayer computerPlayer;
    Player currentTurn;
    Random randomNumbers;
    boolean gameWasWon;

    public TicTacToe() {
        nineButtons = new JButton[3][3];
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                nineButtons[i][j] = new JButton(" ");
                nineButtons[i][j].setFont(new Font("Arial", Font.PLAIN, 40));
                nineButtons[i][j].addActionListener(new ActionListener() {
                    public void actionPerformed(ActionEvent evt) {
                        clickButton(evt);
                    }
                });
                add(nineButtons[i][j]);
            }
        }
        humanPlayer = new HumanPlayer();
        computerPlayer = new ComputerPlayer();
        currentTurn = humanPlayer;
        randomNumbers = new Random();
        setLayout(new GridLayout(3, 3));
        setSize(400, 400);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);
    }

    public void clickButton(ActionEvent evt) {
        if (currentTurn != humanPlayer) return;

        JButton buttonClicked = (JButton) evt.getSource();
        boolean result = placeSymbol(buttonClicked, currentTurn);

        if (!result) return;
    }

    public boolean placeSymbol(JButton button, Player player) {
        if (gameWasWon || !button.getText().equals(" ")) {
            return false;
        } else {
            button.setText(String.valueOf(player.symbol));
            button.setForeground(player.color); // Sets button text color to player's color
            changeTurn();
            return true;
        }
    }

    public void changeTurn() {
        if (checkWin()) return;
        currentTurn = (currentTurn == humanPlayer) ? computerPlayer : humanPlayer;
    }

    public boolean checkWin() {
        Player whoWon = checkWhoWon();
        boolean boardIsFull = isFull();

        if (whoWon == null && boardIsFull) {
            JOptionPane.showMessageDialog(null, "It's a tie!");
            gameWasWon = true;
            return true;
        }

        if (whoWon == humanPlayer) {
            JOptionPane.showMessageDialog(null, "You won!");
            gameWasWon = true;
            return true;
        }

        if (whoWon == computerPlayer) {
            JOptionPane.showMessageDialog(null, "Computer won!");
            gameWasWon = true;
            return true;
        }

        return false;
    }

    public Player checkWhoWon() {
        // Winning conditions for rows, columns, and diagonals
        for (int i = 0; i < 3; i++) {
            if (!nineButtons[i][0].getText().equals(" ") &&
                    nineButtons[i][0].getText().equals(nineButtons[i][1].getText()) &&
                    nineButtons[i][0].getText().equals(nineButtons[i][2].getText())) {
                return nineButtons[i][0].getText().equals("X") ? humanPlayer : computerPlayer;
            }

            if (!nineButtons[0][i].getText().equals(" ") &&
                    nineButtons[0][i].getText().equals(nineButtons[1][i].getText()) &&
                    nineButtons[0][i].getText().equals(nineButtons[2][i].getText())) {
                return nineButtons[0][i].getText().equals("X") ? humanPlayer : computerPlayer;
            }
        }

        if (!nineButtons[0][0].getText().equals(" ") &&
                nineButtons[0][0].getText().equals(nineButtons[1][1].getText()) &&
                nineButtons[0][0].getText().equals(nineButtons[2][2].getText())) {
            return nineButtons[0][0].getText().equals("X") ? humanPlayer : computerPlayer;
        }

        if (!nineButtons[0][2].getText().equals(" ") &&
                nineButtons[0][2].getText().equals(nineButtons[1][1].getText()) &&
                nineButtons[0][2].getText().equals(nineButtons[2][0].getText())) {
            return nineButtons[0][2].getText().equals("X") ? humanPlayer : computerPlayer;
        }

        return null;
    }

    public boolean isFull() {
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                if (nineButtons[i][j].getText().equals(" ")) {
                    return false;
                }
            }
        }
        return true;
    }

    public void runGame() {
        gameWasWon = false;

        while (!gameWasWon) {
            if (currentTurn == computerPlayer) {
                takeComputerTurn();
                changeTurn();
            } else {
                try {
                    Thread.sleep(200);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    public void takeComputerTurn() {
        if (isFull()) return;

        boolean result = false;
        while (!result) {
            int row = randomNumbers.nextInt(3);
            int col = randomNumbers.nextInt(3);
            JButton buttonPicked = nineButtons[row][col];
            result = placeSymbol(buttonPicked, computerPlayer);
        }
    }

    public static void main(String[] args) {
        new TicTacToe().runGame();
    }
}

public class TicTacToe extends javax.swing.JFrame {

    /**
     * Creates new form MemoryGame
     */
    public TicTacToe() {
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

        jPanel1 = new javax.swing.JPanel();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();
        jButton4 = new javax.swing.JButton();
        jButton5 = new javax.swing.JButton();
        jButton6 = new javax.swing.JButton();
        jButton7 = new javax.swing.JButton();
        jButton8 = new javax.swing.JButton();
        jButton9 = new javax.swing.JButton();
        jPanel2 = new javax.swing.JPanel();
        jScrollPane2 = new javax.swing.JScrollPane();
        jTextArea2 = new javax.swing.JTextArea();
        jScrollPane3 = new javax.swing.JScrollPane();
        jTextArea3 = new javax.swing.JTextArea();
        jScrollPane4 = new javax.swing.JScrollPane();
        jTextArea4 = new javax.swing.JTextArea();
        jMenuBar1 = new javax.swing.JMenuBar();
        jMenu1 = new javax.swing.JMenu();
        jMenuItem2 = new javax.swing.JMenuItem();
        jMenu2 = new javax.swing.JMenu();
        jMenuItem1 = new javax.swing.JMenuItem();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setPreferredSize(new java.awt.Dimension(500, 500));

        jPanel1.setLayout(new java.awt.GridLayout(3, 3));

        jButton1.setFont(new java.awt.Font("Dialog", 0, 100)); // NOI18N
        jButton1.setText("-");
        jPanel1.add(jButton1);

        jButton2.setFont(new java.awt.Font("Dialog", 0, 100)); // NOI18N
        jButton2.setText("-");
        jPanel1.add(jButton2);

        jButton3.setFont(new java.awt.Font("Dialog", 0, 100)); // NOI18N
        jButton3.setText("-");
        jPanel1.add(jButton3);

        jButton4.setFont(new java.awt.Font("Dialog", 0, 100)); // NOI18N
        jButton4.setText("-");
        jPanel1.add(jButton4);

        jButton5.setFont(new java.awt.Font("Dialog", 0, 100)); // NOI18N
        jButton5.setText("-");
        jPanel1.add(jButton5);

        jButton6.setFont(new java.awt.Font("Dialog", 0, 100)); // NOI18N
        jButton6.setText("-");
        jPanel1.add(jButton6);

        jButton7.setFont(new java.awt.Font("Dialog", 0, 100)); // NOI18N
        jButton7.setText("-");
        jPanel1.add(jButton7);

        jButton8.setFont(new java.awt.Font("Dialog", 0, 100)); // NOI18N
        jButton8.setText("-");
        jPanel1.add(jButton8);

        jButton9.setFont(new java.awt.Font("Dialog", 0, 100)); // NOI18N
        jButton9.setText("-");
        jPanel1.add(jButton9);

        jPanel2.setLayout(new java.awt.GridLayout(0, 1));

        jScrollPane2.setHorizontalScrollBarPolicy(javax.swing.ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
        jScrollPane2.setVerticalScrollBarPolicy(javax.swing.ScrollPaneConstants.VERTICAL_SCROLLBAR_NEVER);

        jTextArea2.setEditable(false);
        jTextArea2.setColumns(20);
        jTextArea2.setFont(new java.awt.Font("Dialog", 0, 12)); // NOI18N
        jTextArea2.setRows(5);
        jTextArea2.setText("GAME TYPE:\n[VS COMP /\n VS HUMAN]");
        jScrollPane2.setViewportView(jTextArea2);

        jPanel2.add(jScrollPane2);

        jScrollPane3.setHorizontalScrollBarPolicy(javax.swing.ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
        jScrollPane3.setVerticalScrollBarPolicy(javax.swing.ScrollPaneConstants.VERTICAL_SCROLLBAR_NEVER);

        jTextArea3.setEditable(false);
        jTextArea3.setColumns(20);
        jTextArea3.setFont(new java.awt.Font("Dialog", 0, 12)); // NOI18N
        jTextArea3.setRows(5);
        jTextArea3.setText("GAME RECORD");
        jScrollPane3.setViewportView(jTextArea3);

        jPanel2.add(jScrollPane3);

        jScrollPane4.setHorizontalScrollBarPolicy(javax.swing.ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
        jScrollPane4.setVerticalScrollBarPolicy(javax.swing.ScrollPaneConstants.VERTICAL_SCROLLBAR_NEVER);

        jTextArea4.setEditable(false);
        jTextArea4.setColumns(20);
        jTextArea4.setFont(new java.awt.Font("Dialog", 0, 12)); // NOI18N
        jTextArea4.setRows(5);
        jTextArea4.setText("GAME TIME");
        jScrollPane4.setViewportView(jTextArea4);

        jPanel2.add(jScrollPane4);

        jMenu1.setText("File");

        jMenuItem2.setText("Quit");
        jMenuItem2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                quitActionPerformed(evt);
            }
        });
        jMenu1.add(jMenuItem2);

        jMenuBar1.add(jMenu1);

        jMenu2.setText("Help");

        jMenuItem1.setText("About...");
        jMenuItem1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                aboutActionPerformed(evt);
            }
        });
        jMenu2.add(jMenuItem1);

        jMenuBar1.add(jMenu2);

        setJMenuBar(jMenuBar1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 381, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, 113, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void aboutActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_aboutActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_aboutActionPerformed

    private void quitActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_quitActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_quitActionPerformed

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
            java.util.logging.Logger.getLogger(MemoryGame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(MemoryGame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(MemoryGame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(MemoryGame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new TicTacToe().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButton4;
    private javax.swing.JButton jButton5;
    private javax.swing.JButton jButton6;
    private javax.swing.JButton jButton7;
    private javax.swing.JButton jButton8;
    private javax.swing.JButton jButton9;
    private javax.swing.JMenu jMenu1;
    private javax.swing.JMenu jMenu2;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JMenuItem jMenuItem1;
    private javax.swing.JMenuItem jMenuItem2;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JTextArea jTextArea2;
    private javax.swing.JTextArea jTextArea3;
    private javax.swing.JTextArea jTextArea4;
    // End of variables declaration//GEN-END:variables
}
