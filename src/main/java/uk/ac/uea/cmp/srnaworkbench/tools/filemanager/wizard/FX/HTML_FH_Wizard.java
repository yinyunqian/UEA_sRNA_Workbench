/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package uk.ac.uea.cmp.srnaworkbench.tools.filemanager.wizard.FX;

import java.awt.Dimension;
import java.awt.Point;
import java.io.IOException;
import java.nio.file.Path;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.logging.Level;
import javafx.application.Platform;
import javafx.embed.swing.JFXPanel;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javax.swing.JFrame;
import javax.swing.JInternalFrame;
import javax.swing.SwingUtilities;
import static uk.ac.uea.cmp.srnaworkbench.utils.LOGGERS.WorkbenchLogger.LOGGER;

/**
 *
 * @author w0445959
 */
public class HTML_FH_Wizard extends javax.swing.JDialog
{

    
      private static Scene scene;
    
    private static Parent root;
    
    private static HTMLWizardViewController controller;

    

    
    /**
     * Creates new form FileHierarchyViewer
     */
    public HTML_FH_Wizard(JFrame parent, String title, String message)
    {
        super(parent, title, false);

        // This method is invoked on the EDT thread
        initComponents();
        

        final JFXPanel fxPanel = new JFXPanel();
        this.mainScrollPane.setViewportView(fxPanel);
        Platform.runLater(() ->
        {
            initFX(fxPanel);
        });
        if (parent != null) {
      Dimension parentSize = parent.getSize(); 
      Point p = parent.getLocation(); 
      setLocation(p.x + parentSize.width / 4, p.y + parentSize.height / 4);
    }
//    JPanel messagePane = new JPanel();
//    messagePane.add(new JLabel(message));
//    getContentPane().add(messagePane);
//    JPanel buttonPane = new JPanel();
//    JButton button = new JButton("OK"); 
//    buttonPane.add(button); 
//    button.addActionListener(this);
//    getContentPane().add(buttonPane, BorderLayout.SOUTH);
    setDefaultCloseOperation(HIDE_ON_CLOSE);
    pack(); 
    
    }
    
    private void initFX(JFXPanel fxPanel) {
        // This method is invoked on the JavaFX thread
        createScene();
        fxPanel.setScene(scene);
    }

    private void createScene() 
    {
        try
        {
            //Parent root = FXMLLoader.load(FileHierarchyViewer.class.getResource("/fxml/FileHierarchyView.fxml"));
            FXMLLoader loader = new FXMLLoader(HTML_FH_Wizard.class.getResource("/fxml/HTMLWizardView.fxml"));
            root = loader.load();
            scene = new Scene(root);
            scene.getStylesheets().add("/styles/Styles.css");

            controller = (HTMLWizardViewController)loader.getController();
            controller.setStageAndSetupListeners(scene);
            controller.addParent(this);
        }
        catch (IOException ex)
        {
            LOGGER.log(Level.SEVERE, null, ex);
        }

    }
    
    public static void main(String[] args)
    {
        
        SwingUtilities.invokeLater(() ->
        {
            initAndShowGUI();
        });
    }
    
    private static void initAndShowGUI() {
        

        HTML_FH_Wizard frame = new HTML_FH_Wizard(new JFrame(), "", "");
        frame.setVisible(true);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents()
    {

        mainScrollPane = new javax.swing.JScrollPane();

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(mainScrollPane, javax.swing.GroupLayout.DEFAULT_SIZE, 1019, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(mainScrollPane, javax.swing.GroupLayout.DEFAULT_SIZE, 675, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JScrollPane mainScrollPane;
    // End of variables declaration//GEN-END:variables

    public Map<String, List<Path>> getSamples()
    {
        return controller.getSamples();
    }
    public Path getGenome()
    {
        return controller.getGenome();
    }
}
