/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/*
 * ParamsToolBar.java
 *
 * Created on Nov 23, 2011, 11:02:27 AM
 */
package uk.ac.uea.cmp.srnaworkbench.swing;

import java.io.File;
import java.io.IOException;
import javax.swing.filechooser.FileFilter;
import uk.ac.uea.cmp.srnaworkbench.tools.ToolParameters;
import uk.ac.uea.cmp.srnaworkbench.tools.ToolParamsHost;
import uk.ac.uea.cmp.srnaworkbench.utils.FileDialogUtils;
import uk.ac.uea.cmp.srnaworkbench.utils.FileDialogUtils.FileExtFilter;

/**
 *
 * @author ezb11yfu
 */
public class ParamsToolBar extends javax.swing.JPanel
{
  private ToolParamsHost host;

  public ParamsToolBar()
  {
    initComponents();
  }

  /** This method is called from within the constructor to
   * initialize the form.
   * WARNING: Do NOT modify this code. The content of this method is
   * always regenerated by the Form Editor.
   */
  @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents()
    {

        jToolBar = new javax.swing.JToolBar();
        cmdLoad = new javax.swing.JButton();
        filler1 = new javax.swing.Box.Filler(new java.awt.Dimension(3, 0), new java.awt.Dimension(3, 0), new java.awt.Dimension(3, 32767));
        cmdSave = new javax.swing.JButton();

        setBackground(new java.awt.Color(120, 120, 120));

        jToolBar.setBackground(new java.awt.Color(120, 120, 120));
        jToolBar.setFloatable(false);
        jToolBar.setRollover(true);

        cmdLoad.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/SharedImages/add-item.png"))); // NOI18N
        cmdLoad.setToolTipText("Load parameters from disk");
        cmdLoad.setFocusable(false);
        cmdLoad.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        cmdLoad.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        cmdLoad.addActionListener(new java.awt.event.ActionListener()
        {
            public void actionPerformed(java.awt.event.ActionEvent evt)
            {
                cmdLoadActionPerformed(evt);
            }
        });
        jToolBar.add(cmdLoad);
        jToolBar.add(filler1);

        cmdSave.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/SharedImages/save.png"))); // NOI18N
        cmdSave.setToolTipText("Save parameters to disk");
        cmdSave.setFocusable(false);
        cmdSave.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        cmdSave.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        cmdSave.addActionListener(new java.awt.event.ActionListener()
        {
            public void actionPerformed(java.awt.event.ActionEvent evt)
            {
                cmdSaveActionPerformed(evt);
            }
        });
        jToolBar.add(cmdSave);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jToolBar, javax.swing.GroupLayout.DEFAULT_SIZE, 400, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jToolBar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
    }// </editor-fold>//GEN-END:initComponents

  public void setHost(ToolParamsHost host)
  {
    this.host = host;
  }

  @Override
  public void setEnabled( boolean enabled )
  {
    super.setEnabled( enabled );

    this.cmdLoad.setEnabled( enabled );
    this.cmdSave.setEnabled( enabled );
  }

  public void setLoadEnabled( boolean enabled )
  {
    cmdLoad.setEnabled( enabled );
  }

  public void setSaveEnabled( boolean enabled )
  {
    cmdSave.setEnabled( enabled );
  }

private void cmdLoadActionPerformed( java.awt.event.ActionEvent evt )//GEN-FIRST:event_cmdLoadActionPerformed
  {//GEN-HEADEREND:event_cmdLoadActionPerformed
    File load_file = FileDialogUtils.showSingleFileOpenDialog( FileExtFilter.PARAMETER.getFilter(), this.getParent() );

    if ( load_file != null )
    {
      try
      {
        ToolParameters t = ToolParameters.load( host.getParams(), load_file );
        host.update(t);
      }
      catch (Exception e)
      {
        host.showErrorDialog( e.getMessage() );
      }
    }
  }//GEN-LAST:event_cmdLoadActionPerformed

  private void cmdSaveActionPerformed( java.awt.event.ActionEvent evt )//GEN-FIRST:event_cmdSaveActionPerformed
  {//GEN-HEADEREND:event_cmdSaveActionPerformed
    File save_file = FileDialogUtils.showFileSaveDialog( this, FileExtFilter.PARAMETER.getFilter() );
    if ( save_file != null )
    {
      try
      {
        ToolParameters t = host.getParams();
        if(t == null)
          throw new IOException("Parameters have not been initilised");
        t.save( save_file );
      }
      catch (IOException ioe)
      {
        host.showErrorDialog( ioe.getMessage() );
      }
    }
  }//GEN-LAST:event_cmdSaveActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton cmdLoad;
    private javax.swing.JButton cmdSave;
    private javax.swing.Box.Filler filler1;
    private javax.swing.JToolBar jToolBar;
    // End of variables declaration//GEN-END:variables
}
