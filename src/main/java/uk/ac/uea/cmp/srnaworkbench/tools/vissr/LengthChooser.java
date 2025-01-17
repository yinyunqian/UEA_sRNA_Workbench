/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package uk.ac.uea.cmp.srnaworkbench.tools.vissr;

import uk.ac.uea.cmp.srnaworkbench.utils.*;
import uk.ac.uea.cmp.srnaworkbench.utils.patman.*;
import uk.ac.uea.cmp.srnaworkbench.utils.FileDialogUtils.FileExtFilter;

import java.awt.Cursor;
import java.io.*;
import java.util.*;
import javax.swing.JOptionPane;

/**
 *
 * @author prb07qmu
 */
final class LengthChooser extends javax.swing.JPanel
{
  private final String _sequenceId;

  // Populated from the file
  private Patman _patman;

  private File _file;

  // Populated when the file is chosen
  private final List<Integer> _allLengths = CollectionUtils.newArrayList();

  // These lists provide the data for the JLists
  private final List<Integer> _listLeft  = CollectionUtils.newArrayList();
  private final List<Integer> _listRight = CollectionUtils.newArrayList();

  /** Creates new form */
  public LengthChooser( String sequenceId, boolean aggregate, int numLengthsRequired )
  {
    _sequenceId = sequenceId == null ? "" : sequenceId;

    initComponents();

    String msg = "";

    if ( numLengthsRequired != -1 )
    {
      msg += "Please choose up to" + numLengthsRequired + " length(s). ";
    }

    if ( ! _sequenceId.isEmpty() )
    {
      msg += "Filtering on '" + _sequenceId + "'.";
    }

    lblStatus.setText( msg );
  }

  private void doChoosePatmanFile()
  {
    File f = FileDialogUtils.showSingleFileOpenDialog( FileExtFilter.PATMAN.getFilter(), this );

    if ( f == null || ! f.exists() )
      return;

    _file = f;

    txtFileName.setText( _file.getName() );

    setCursor( Cursor.getPredefinedCursor( Cursor.WAIT_CURSOR ) );
    ThreadUtils.safeSleep( 10 );
    try
    {
      // Process the file
      loadPatmanFile();
    }
    finally
    {
      setCursor( Cursor.getDefaultCursor() );
    }
  }

  private void loadPatmanFile()
  {
    _patman = null;

    try
    {
      PatmanReader pr = new PatmanReader( _file );
      _patman = pr.process();
    }
    catch ( IOException ex )
    {
      lblStatus.setText( " An error occurred while loading the file" );
      return;
    }

    if ( _patman == null )
    {
      lblStatus.setText( " No data loaded from the file for '" + _sequenceId + "'" );
      return;
    }

    Map<Integer, Integer> lenToFreq = _patman.getLengthToFrequencyBreakdown( _sequenceId );

    if ( lenToFreq ==  null || lenToFreq.isEmpty() )
    {
      lblStatus.setText( " No data loaded from the file for '" + _sequenceId + "'" );
    }

    _allLengths.clear();
    _allLengths.addAll( lenToFreq.keySet()  );
    Collections.sort( _allLengths );

    initialiseListData();
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

        txtFileName = new javax.swing.JTextField();
        btnChooseFile = new javax.swing.JButton();
        paneRight = new javax.swing.JScrollPane();
        listSelectedLengths = new javax.swing.JList();
        lblStatus = new javax.swing.JLabel();
        paneLeft = new javax.swing.JScrollPane();
        listAllLengths = new javax.swing.JList();
        jLabel1 = new javax.swing.JLabel();
        btnMoveAllLeft = new javax.swing.JButton();
        btnMoveAllRight = new javax.swing.JButton();

        setForeground(java.awt.Color.white);
        setMaximumSize(new java.awt.Dimension(400, 420));
        setMinimumSize(new java.awt.Dimension(400, 420));
        setPreferredSize(new java.awt.Dimension(400, 420));

        txtFileName.setText(" Please choose a Patman output file");
        txtFileName.setEnabled(false);

        btnChooseFile.setText("...");
        btnChooseFile.setToolTipText("Click to choose a Patman output file");
        btnChooseFile.setMargin(new java.awt.Insets(2, 2, 2, 2));
        btnChooseFile.addActionListener(new java.awt.event.ActionListener()
        {
            public void actionPerformed(java.awt.event.ActionEvent evt)
            {
                btnChooseFileActionPerformed(evt);
            }
        });

        listSelectedLengths.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        listSelectedLengths.setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
        listSelectedLengths.setToolTipText("Double-click an item to remove it");
        listSelectedLengths.addMouseListener(new java.awt.event.MouseAdapter()
        {
            public void mouseClicked(java.awt.event.MouseEvent evt)
            {
                listSelectedLengthsMouseClicked(evt);
            }
        });
        paneRight.setViewportView(listSelectedLengths);

        lblStatus.setText("No file");

        listAllLengths.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        listAllLengths.setToolTipText("Double-click a type to add it");
        listAllLengths.addMouseListener(new java.awt.event.MouseAdapter()
        {
            public void mouseClicked(java.awt.event.MouseEvent evt)
            {
                listAllLengthsMouseClicked(evt);
            }
        });
        paneLeft.setViewportView(listAllLengths);

        jLabel1.setText("Selected lengths");

        btnMoveAllLeft.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/SharedImages/double_arrow-round_left.png"))); // NOI18N
        btnMoveAllLeft.setIconTextGap(0);
        btnMoveAllLeft.setMargin(new java.awt.Insets(2, 2, 2, 2));
        btnMoveAllLeft.addActionListener(new java.awt.event.ActionListener()
        {
            public void actionPerformed(java.awt.event.ActionEvent evt)
            {
                btnMoveAllLeftActionPerformed(evt);
            }
        });

        btnMoveAllRight.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/SharedImages/double_arrow-round_right.png"))); // NOI18N
        btnMoveAllRight.setIconTextGap(0);
        btnMoveAllRight.setMargin(new java.awt.Insets(2, 2, 2, 2));
        btnMoveAllRight.addActionListener(new java.awt.event.ActionListener()
        {
            public void actionPerformed(java.awt.event.ActionEvent evt)
            {
                btnMoveAllRightActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(10, 10, 10)
                .addComponent(txtFileName, javax.swing.GroupLayout.PREFERRED_SIZE, 330, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(10, 10, 10)
                .addComponent(btnChooseFile, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addGroup(layout.createSequentialGroup()
                .addGap(270, 270, 270)
                .addComponent(jLabel1))
            .addGroup(layout.createSequentialGroup()
                .addGap(10, 10, 10)
                .addComponent(paneLeft, javax.swing.GroupLayout.PREFERRED_SIZE, 160, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(10, 10, 10)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btnMoveAllLeft, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnMoveAllRight, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(10, 10, 10)
                .addComponent(paneRight, javax.swing.GroupLayout.PREFERRED_SIZE, 160, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addGroup(layout.createSequentialGroup()
                .addGap(10, 10, 10)
                .addComponent(lblStatus, javax.swing.GroupLayout.PREFERRED_SIZE, 340, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(10, 10, 10)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(txtFileName, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnChooseFile))
                .addGap(16, 16, 16)
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(paneLeft, javax.swing.GroupLayout.PREFERRED_SIZE, 300, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(100, 100, 100)
                        .addComponent(btnMoveAllLeft, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(10, 10, 10)
                        .addComponent(btnMoveAllRight, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(paneRight, javax.swing.GroupLayout.PREFERRED_SIZE, 300, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(10, 10, 10)
                .addComponent(lblStatus, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
    }// </editor-fold>//GEN-END:initComponents

  private void btnChooseFileActionPerformed( java.awt.event.ActionEvent evt )//GEN-FIRST:event_btnChooseFileActionPerformed
  {//GEN-HEADEREND:event_btnChooseFileActionPerformed
    doChoosePatmanFile();
  }//GEN-LAST:event_btnChooseFileActionPerformed

  private void listAllLengthsMouseClicked( java.awt.event.MouseEvent evt )//GEN-FIRST:event_listAllLengthsMouseClicked
  {//GEN-HEADEREND:event_listAllLengthsMouseClicked
    if ( evt.getClickCount() == 2 )
    {
      Object obj = listAllLengths.getSelectedValue();
      moveItem( obj, true );
    }
  }//GEN-LAST:event_listAllLengthsMouseClicked

  private void listSelectedLengthsMouseClicked( java.awt.event.MouseEvent evt )//GEN-FIRST:event_listSelectedLengthsMouseClicked
  {//GEN-HEADEREND:event_listSelectedLengthsMouseClicked
    if ( evt.getClickCount() == 2 )
    {
      Object obj = listSelectedLengths.getSelectedValue();
      moveItem( obj, false );
    }
  }//GEN-LAST:event_listSelectedLengthsMouseClicked

  private void btnMoveAllLeftActionPerformed( java.awt.event.ActionEvent evt )//GEN-FIRST:event_btnMoveAllLeftActionPerformed
  {//GEN-HEADEREND:event_btnMoveAllLeftActionPerformed
    moveAll( false );   }//GEN-LAST:event_btnMoveAllLeftActionPerformed

  private void btnMoveAllRightActionPerformed( java.awt.event.ActionEvent evt )//GEN-FIRST:event_btnMoveAllRightActionPerformed
  {//GEN-HEADEREND:event_btnMoveAllRightActionPerformed
    moveAll( true );   }//GEN-LAST:event_btnMoveAllRightActionPerformed

  private void moveItem( Object o, boolean toRight )
  {
    if ( o == null )
      return;

    Integer i = Integer.valueOf( o.toString() );

    if ( toRight )
    {
      _listLeft.remove( i );
      _listRight.add( i );
    }
    else
    {
      _listLeft.add( i );
      _listRight.remove( i );
    }

    setListData();
  }

  private void moveAll( boolean toRight )
  {
    if ( toRight )
    {
      _listRight.addAll( _listLeft );
      _listLeft.clear();
    }
    else
    {
      _listLeft.addAll( _listRight );
      _listRight.clear();
    }

    setListData();
  }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnChooseFile;
    private javax.swing.JButton btnMoveAllLeft;
    private javax.swing.JButton btnMoveAllRight;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel lblStatus;
    private javax.swing.JList listAllLengths;
    private javax.swing.JList listSelectedLengths;
    private javax.swing.JScrollPane paneLeft;
    private javax.swing.JScrollPane paneRight;
    private javax.swing.JTextField txtFileName;
    // End of variables declaration//GEN-END:variables

  private void initialiseListData()
  {
    _listLeft.clear();
    _listRight.clear();

    _listLeft.addAll( _allLengths );

    setListData();
  }

  private void setListData()
  {
    Object[] obj = {};

    listAllLengths.setListData( obj );
    listSelectedLengths.setListData( obj );

    Collections.sort( _listLeft );
    Collections.sort( _listRight );

    listAllLengths.setListData( _listLeft.toArray() );
    listSelectedLengths.setListData( _listRight.toArray() );
  }

  List<Integer> getSelectedLengths()
  {
    return _listRight;
  }

  Patman getPatman()
  {
    return _patman;
  }

  String getFileName()
  {
    return _file == null ? "" : _file.getName();
  }

  public static void main( String... args )
  {
    LengthChooser lengthChooser = new LengthChooser( "Chr1", false, -1 );

    int result = JOptionPane.showConfirmDialog( null,
      lengthChooser,
      "Select sequence lengths",
      JOptionPane.OK_CANCEL_OPTION );

    System.out.println( "rtc: " + result );
    System.out.println( lengthChooser.getSelectedLengths() );
  }
}
