/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package uk.ac.uea.cmp.srnaworkbench.tools.expressionCalculator;

import javax.swing.JPanel;
import uk.ac.uea.cmp.srnaworkbench.GUIInterface;
import uk.ac.uea.cmp.srnaworkbench.tools.ToolHost;

/**
 *
 * @author w0445959
 */
public class ExpressionCalculatorMainFrame extends javax.swing.JInternalFrame implements GUIInterface, ToolHost
{
  private boolean showingParams = false;
  /**
   * Creates new form ExpressionCalculatorMainFrame
   */
  public ExpressionCalculatorMainFrame()
  {
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

        expressionCalculatorInputPanel = new uk.ac.uea.cmp.srnaworkbench.tools.expressionCalculator.ExpressionCalculatorInputPanel();

        setBackground(new java.awt.Color(120, 120, 120));
        setClosable(true);
        setIconifiable(true);
        setMaximizable(true);
        setResizable(true);

        org.jdesktop.layout.GroupLayout layout = new org.jdesktop.layout.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
            .add(layout.createSequentialGroup()
                .addContainerGap()
                .add(expressionCalculatorInputPanel, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, 887, Short.MAX_VALUE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
            .add(layout.createSequentialGroup()
                .addContainerGap()
                .add(expressionCalculatorInputPanel, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 407, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(226, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private uk.ac.uea.cmp.srnaworkbench.tools.expressionCalculator.ExpressionCalculatorInputPanel expressionCalculatorInputPanel;
    // End of variables declaration//GEN-END:variables

  @Override
  public void runProcedure()
  {
    throw new UnsupportedOperationException( "Not supported yet." );
  }

  @Override
  public JPanel getParamsPanel()
  {
    return new JPanel();
  }

  @Override
  public void setShowingParams( boolean newState )
  {
    showingParams = newState;
  }

  @Override
  public boolean getShowingParams()
  {
    return this.showingParams;
  }

  @Override
  public void shutdown()
  {
    throw new UnsupportedOperationException( "Not supported yet." );
  }

  @Override
  public void update()
  {
    throw new UnsupportedOperationException( "Not supported yet." );
  }

  @Override
  public void setRunningStatus( boolean running )
  {
    throw new UnsupportedOperationException( "Not supported yet." );
  }

  @Override
  public void showErrorDialog( String message )
  {
    throw new UnsupportedOperationException( "Not supported yet." );
  }
}
