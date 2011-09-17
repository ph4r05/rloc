/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/*
 * JFrameScreen.java
 *
 * Created on Sep 15, 2011, 1:27:19 PM
 */
package rssi_graph.game;

import java.awt.Dimension;
import java.awt.Rectangle;
import java.text.DecimalFormat;
import java.text.NumberFormat;
import javax.swing.JPanel;

/**
 * Represents online status of game visible for users.
 * Usually displayed on separate screen.
 *  
 * @author ph4r05
 */
public class JFrameScreen extends javax.swing.JFrame {

    protected JPanelGame parentPanel = null;
    protected GameWorker gameWorker = null;
    
    /**
     * Flag indicating current state of window sizing for multiplayer.
     * TRUE by default = window is split at 2 parts
     */
    protected boolean currentMultiplayer=true;
    
    /** Creates new form JFrameScreen */
    public JFrameScreen() {
        initComponents();
    }

    /**
     * Generic initial method
     */
    public void initThis(){
        this.energyMeter1.initMeter();
        this.energyMeter2.initMeter();
    }
    
    /**
     * Set player name for frames & labels
     * @param player 
     */
    public void setPlayerName(int player, String playername){
        if (player==1){
            jPanelPlayer1.setBorder(javax.swing.BorderFactory.createTitledBorder(playername));
            jLabelPlayer1Name.setText(playername);
        } else if (player==2){
            jPanelPlayer2.setBorder(javax.swing.BorderFactory.createTitledBorder(playername));
            jLabelPlayer2Name.setText(playername);
        }
    }
    
    /**
     * Set multiplayer mode.
     * Disable second viewer, expand first to the full size/split half
     */
    public void setMultiplayer(boolean multiplayer){
        // if nothing changed, leave it
        if (multiplayer==currentMultiplayer) return;
        
        Rectangle bounds2 = this.jPanelPlayer2.getBounds();
        Dimension preferredSize2 = this.jPanelPlayer2.getPreferredSize();
        
        Rectangle bounds1 = this.jPanelPlayer1.getBounds();
        Dimension preferredSize1 = this.jPanelPlayer1.getPreferredSize();
        
        if (multiplayer==true){
            // here => now IS NOT multiplayer screen, but should be => split
            this.jPanelPlayer2.setVisible(true);
            this.jPanelPlayer1.setBounds(new Rectangle(bounds1.x, bounds1.y, bounds1.width - bounds2.width, bounds1.height));
            this.jPanelPlayer1.setPreferredSize(new Dimension(preferredSize1.width - preferredSize2.width, preferredSize1.height));
        } else {
            // here => now IS multiplayer screen, but shouldn't be => extend
            this.jPanelPlayer2.setVisible(false);
            this.jPanelPlayer1.setBounds(new Rectangle(bounds1.x, bounds1.y, bounds1.width + bounds2.width, bounds1.height));
            this.jPanelPlayer1.setPreferredSize(new Dimension(preferredSize1.width + preferredSize2.width, preferredSize1.height));
        }
        
        // update current state
        currentMultiplayer = multiplayer;
    }
    
    /**
     * Set energy
     * 
     * @param player
     * @param energy 
     */
    public void setEnergy(int player, double energy){
        NumberFormat formatter = new DecimalFormat("#00.00");
        String fEnergy = formatter.format(energy); 
        
        if (player==1){
            this.jLabelEnergy1.setText(fEnergy);
            this.energyMeter1.setCurrentValue(energy);
        } else if (player==2){
            this.jLabelEnergy2.setText(fEnergy);
            this.energyMeter2.setCurrentValue(energy);
        }
    }
    
    /**
     * Event fired - gui update
     */
    void updateGuiTimerFired() {
        double energy = this.gameWorker.getPlayer1().getEnergy();
        this.setEnergy(1, energy);
        
        if (this.gameWorker.getPlayer2() instanceof Player){
            energy = this.gameWorker.getPlayer2().getEnergy();
            this.setEnergy(2, energy);
        }
    }
    
    public JPanelGame getParentPanel() {
        return parentPanel;
    }

    public void setParentPanel(JPanelGame parentPanel) {
        this.parentPanel = parentPanel;
    }

    public GameWorker getGameWorker() {
        return gameWorker;
    }

    public void setGameWorker(GameWorker gameWorker) {
        this.gameWorker = gameWorker;
    }

    public JPanel getjPanelPlayer1() {
        return jPanelPlayer1;
    }

    public void setjPanelPlayer1(JPanel jPanelPlayer1) {
        this.jPanelPlayer1 = jPanelPlayer1;
    }

    public JPanel getjPanelPlayer2() {
        return jPanelPlayer2;
    }

    public void setjPanelPlayer2(JPanel jPanelPlayer2) {
        this.jPanelPlayer2 = jPanelPlayer2;
    }
    
    
    
    
    /** This method is called from within the constructor to
     * initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is
     * always regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jPanelPlayer1 = new javax.swing.JPanel();
        jLabelPlayer1Name = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabelEnergy1 = new javax.swing.JLabel();
        energyMeter1 = new rssi_graph.game.energyMeter();
        jPanelPlayer2 = new javax.swing.JPanel();
        jLabelPlayer2Name = new javax.swing.JLabel();
        jLabelEnergy2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        energyMeter2 = new rssi_graph.game.energyMeter();

        org.jdesktop.application.ResourceMap resourceMap = org.jdesktop.application.Application.getInstance(rssi_graph.RSSI_graphApp.class).getContext().getResourceMap(JFrameScreen.class);
        jLabel1.setText(resourceMap.getString("jLabel1.text")); // NOI18N
        jLabel1.setName("jLabel1"); // NOI18N

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setName("Form"); // NOI18N

        jPanelPlayer1.setBorder(javax.swing.BorderFactory.createTitledBorder(resourceMap.getString("jPanelPlayer1.border.title"))); // NOI18N
        jPanelPlayer1.setName("jPanelPlayer1"); // NOI18N

        jLabelPlayer1Name.setFont(new java.awt.Font("DejaVu Sans", 1, 24));
        jLabelPlayer1Name.setForeground(resourceMap.getColor("jLabelPlayer1Name.foreground")); // NOI18N
        jLabelPlayer1Name.setText(resourceMap.getString("jLabelPlayer1Name.text")); // NOI18N
        jLabelPlayer1Name.setName("jLabelPlayer1Name"); // NOI18N

        jLabel2.setFont(resourceMap.getFont("jLabel2.font")); // NOI18N
        jLabel2.setText(resourceMap.getString("jLabel2.text")); // NOI18N
        jLabel2.setName("jLabel2"); // NOI18N

        jLabelEnergy1.setFont(resourceMap.getFont("jLabelEnergy1.font")); // NOI18N
        jLabelEnergy1.setForeground(resourceMap.getColor("jLabelEnergy1.foreground")); // NOI18N
        jLabelEnergy1.setText(resourceMap.getString("jLabelEnergy1.text")); // NOI18N
        jLabelEnergy1.setName("jLabelEnergy1"); // NOI18N

        energyMeter1.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        energyMeter1.setName("energyMeter1"); // NOI18N

        javax.swing.GroupLayout jPanelPlayer1Layout = new javax.swing.GroupLayout(jPanelPlayer1);
        jPanelPlayer1.setLayout(jPanelPlayer1Layout);
        jPanelPlayer1Layout.setHorizontalGroup(
            jPanelPlayer1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelPlayer1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanelPlayer1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabelPlayer1Name)
                    .addGroup(jPanelPlayer1Layout.createSequentialGroup()
                        .addComponent(jLabel2)
                        .addGap(18, 18, 18)
                        .addComponent(jLabelEnergy1)))
                .addGap(59, 59, 59)
                .addComponent(energyMeter1, javax.swing.GroupLayout.DEFAULT_SIZE, 162, Short.MAX_VALUE)
                .addContainerGap())
        );
        jPanelPlayer1Layout.setVerticalGroup(
            jPanelPlayer1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelPlayer1Layout.createSequentialGroup()
                .addGroup(jPanelPlayer1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanelPlayer1Layout.createSequentialGroup()
                        .addComponent(jLabelPlayer1Name)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanelPlayer1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel2)
                            .addComponent(jLabelEnergy1)))
                    .addComponent(energyMeter1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(120, 120, 120))
        );

        jPanelPlayer2.setBorder(javax.swing.BorderFactory.createTitledBorder(resourceMap.getString("jPanelPlayer2.border.title"))); // NOI18N
        jPanelPlayer2.setName("jPanelPlayer2"); // NOI18N

        jLabelPlayer2Name.setFont(new java.awt.Font("DejaVu Sans", 1, 24));
        jLabelPlayer2Name.setForeground(resourceMap.getColor("jLabelPlayer2Name.foreground")); // NOI18N
        jLabelPlayer2Name.setText(resourceMap.getString("jLabelPlayer2Name.text")); // NOI18N
        jLabelPlayer2Name.setName("jLabelPlayer2Name"); // NOI18N

        jLabelEnergy2.setFont(resourceMap.getFont("jLabel3.font")); // NOI18N
        jLabelEnergy2.setForeground(resourceMap.getColor("jLabelEnergy2.foreground")); // NOI18N
        jLabelEnergy2.setText(resourceMap.getString("jLabelEnergy2.text")); // NOI18N
        jLabelEnergy2.setName("jLabelEnergy2"); // NOI18N

        jLabel3.setFont(resourceMap.getFont("jLabel3.font")); // NOI18N
        jLabel3.setText(resourceMap.getString("jLabel3.text")); // NOI18N
        jLabel3.setName("jLabel3"); // NOI18N

        energyMeter2.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        energyMeter2.setName("energyMeter2"); // NOI18N

        javax.swing.GroupLayout jPanelPlayer2Layout = new javax.swing.GroupLayout(jPanelPlayer2);
        jPanelPlayer2.setLayout(jPanelPlayer2Layout);
        jPanelPlayer2Layout.setHorizontalGroup(
            jPanelPlayer2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelPlayer2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanelPlayer2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabelPlayer2Name)
                    .addGroup(jPanelPlayer2Layout.createSequentialGroup()
                        .addComponent(jLabel3)
                        .addGap(18, 18, 18)
                        .addComponent(jLabelEnergy2)))
                .addGap(80, 80, 80)
                .addComponent(energyMeter2, javax.swing.GroupLayout.DEFAULT_SIZE, 161, Short.MAX_VALUE)
                .addContainerGap())
        );
        jPanelPlayer2Layout.setVerticalGroup(
            jPanelPlayer2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelPlayer2Layout.createSequentialGroup()
                .addGroup(jPanelPlayer2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanelPlayer2Layout.createSequentialGroup()
                        .addComponent(jLabelPlayer2Name)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanelPlayer2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel3)
                            .addComponent(jLabelEnergy2)))
                    .addComponent(energyMeter2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(120, 120, 120))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanelPlayer1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanelPlayer2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jPanelPlayer2, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanelPlayer1, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        java.awt.EventQueue.invokeLater(new Runnable() {

            public void run() {
                new JFrameScreen().setVisible(true);
            }
        });
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private rssi_graph.game.energyMeter energyMeter1;
    private rssi_graph.game.energyMeter energyMeter2;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabelEnergy1;
    private javax.swing.JLabel jLabelEnergy2;
    private javax.swing.JLabel jLabelPlayer1Name;
    private javax.swing.JLabel jLabelPlayer2Name;
    private javax.swing.JPanel jPanelPlayer1;
    private javax.swing.JPanel jPanelPlayer2;
    // End of variables declaration//GEN-END:variables

}
