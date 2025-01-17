/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package uk.ac.uea.cmp.srnaworkbench.startup;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.List;
import java.util.logging.Level;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;
import javax.swing.SwingUtilities;
import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.pdmodel.PDPage;
import uk.ac.uea.cmp.srnaworkbench.swing.pdf.PDF_Utilities;
import static uk.ac.uea.cmp.srnaworkbench.utils.LOGGERS.WorkbenchLogger.LOGGER;
import uk.ac.uea.cmp.srnaworkbench.utils.Tools;


import javafx.scene.Scene;
import javax.swing.ScrollPaneConstants;

import static org.apache.commons.io.IOUtils.DIR_SEPARATOR;
import uk.ac.uea.cmp.srnaworkbench.swing.webbrowser.FXBrowser;
import uk.ac.uea.cmp.srnaworkbench.utils.GroupButtonUtils;

/**
 *
 * @author w0445959
 */
public class StartupOptionsLicence extends javax.swing.JDialog
{
    
    private PDDocument openPDFLicenceFile = PDF_Utilities.openPDFFile(getClass().getResourceAsStream(
            "/program" + DIR_SEPARATOR + "sRNA-WorkbenchEULA_A5.pdf"));

    // get all pages
 private List<PDPage> licence_pages =
      openPDFLicenceFile.getDocumentCatalog().getAllPages();

  
  private List<PDPage> visible_pages = licence_pages;
 
 private int currentIndex = -1;
 
 private int startupStage = 0;

 

  
 
 //used for web page display
 private Scene scene;
  /**
   * Creates new form StartupOptionsTwo
   * @param parent
   * @param modal
   */
  public StartupOptionsLicence( java.awt.Frame parent, boolean modal )
  {
    super( parent, modal );
    initComponents();
    nextPage();
    
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

        licenceTypeGrp = new javax.swing.ButtonGroup();
        trackingOptionsBtnGrp = new javax.swing.ButtonGroup();
        jPanel7 = new javax.swing.JPanel();
        jPanel1 = new javax.swing.JPanel();
        finishBtn = new javax.swing.JButton();
        prevBtn = new javax.swing.JButton();
        nextBtn = new javax.swing.JButton();
        mainViewScroller = new javax.swing.JScrollPane();
        PDF_ViewerLabel = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        jPanel3 = new javax.swing.JPanel();
        forwardsClick = new javax.swing.JButton();
        backwardsClick = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        licenceTypeOptionsPanel = new javax.swing.JPanel();
        jPanel5 = new javax.swing.JPanel();
        trackingRadioNo = new javax.swing.JRadioButton();
        trackingRadioYes = new javax.swing.JRadioButton();
        jPanel6 = new javax.swing.JPanel();
        commercialRadio = new javax.swing.JRadioButton();
        academicRadio = new javax.swing.JRadioButton();
        licenceTypeLbl = new javax.swing.JLabel();
        trackingLbl = new javax.swing.JLabel();
        userDetailsLbl = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DO_NOTHING_ON_CLOSE);
        setModal(true);
        setResizable(false);

        jPanel7.setBackground(new java.awt.Color(120, 120, 120));

        jPanel1.setBackground(new java.awt.Color(120, 120, 120));
        jPanel1.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(255, 255, 255), 1, true));

        finishBtn.setFont(new java.awt.Font("Lucida Sans Unicode", 0, 11)); // NOI18N
        finishBtn.setText("Finish");
        finishBtn.setEnabled(false);
        finishBtn.addActionListener(new java.awt.event.ActionListener()
        {
            public void actionPerformed(java.awt.event.ActionEvent evt)
            {
                finishBtnActionPerformed(evt);
            }
        });

        prevBtn.setFont(new java.awt.Font("Lucida Sans Unicode", 0, 11)); // NOI18N
        prevBtn.setText("Previous");
        prevBtn.setEnabled(false);
        prevBtn.addActionListener(new java.awt.event.ActionListener()
        {
            public void actionPerformed(java.awt.event.ActionEvent evt)
            {
                prevBtnActionPerformed(evt);
            }
        });

        nextBtn.setFont(new java.awt.Font("Lucida Sans Unicode", 0, 11)); // NOI18N
        nextBtn.setText("Next");
        nextBtn.addActionListener(new java.awt.event.ActionListener()
        {
            public void actionPerformed(java.awt.event.ActionEvent evt)
            {
                nextBtnActionPerformed(evt);
            }
        });

        org.jdesktop.layout.GroupLayout jPanel1Layout = new org.jdesktop.layout.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
            .add(org.jdesktop.layout.GroupLayout.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap(765, Short.MAX_VALUE)
                .add(prevBtn, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 106, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED)
                .add(nextBtn, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 106, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED)
                .add(finishBtn, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 106, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
            .add(org.jdesktop.layout.GroupLayout.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap(org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .add(jPanel1Layout.createParallelGroup(org.jdesktop.layout.GroupLayout.BASELINE)
                    .add(finishBtn)
                    .add(prevBtn)
                    .add(nextBtn))
                .addContainerGap())
        );

        PDF_ViewerLabel.setBackground(new java.awt.Color(255, 255, 255));
        mainViewScroller.setViewportView(PDF_ViewerLabel);

        jPanel2.setBackground(new java.awt.Color(120, 120, 120));

        jPanel3.setBackground(new java.awt.Color(120, 120, 120));
        jPanel3.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255, 255, 255)));

        forwardsClick.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/SharedImages/arrow-round_right.png"))); // NOI18N
        forwardsClick.setText("null");
        forwardsClick.setToolTipText("Next page");
        forwardsClick.addActionListener(new java.awt.event.ActionListener()
        {
            public void actionPerformed(java.awt.event.ActionEvent evt)
            {
                forwardsClickActionPerformed(evt);
            }
        });

        backwardsClick.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/SharedImages/arrow-round_left.png"))); // NOI18N
        backwardsClick.setText("null");
        backwardsClick.setToolTipText("Next page");
        backwardsClick.addActionListener(new java.awt.event.ActionListener()
        {
            public void actionPerformed(java.awt.event.ActionEvent evt)
            {
                backwardsClickActionPerformed(evt);
            }
        });

        jLabel1.setFont(new java.awt.Font("Lucida Sans Unicode", 0, 11)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("null");

        org.jdesktop.layout.GroupLayout jPanel3Layout = new org.jdesktop.layout.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
            .add(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .add(jLabel1, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, 97, Short.MAX_VALUE)
                .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED)
                .add(backwardsClick, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 44, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED)
                .add(forwardsClick, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 44, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
            .add(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .add(jPanel3Layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING, false)
                    .add(forwardsClick, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 36, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                    .add(backwardsClick, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 36, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                    .add(jLabel1, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 36, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        licenceTypeOptionsPanel.setBackground(new java.awt.Color(120, 120, 120));
        licenceTypeOptionsPanel.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255, 255, 255)));

        jPanel5.setBackground(new java.awt.Color(110, 110, 110));

        trackingRadioNo.setBackground(new java.awt.Color(110, 110, 110));
        trackingOptionsBtnGrp.add(trackingRadioNo);
        trackingRadioNo.setFont(new java.awt.Font("Lucida Sans Unicode", 0, 11)); // NOI18N
        trackingRadioNo.setForeground(new java.awt.Color(255, 255, 255));
        trackingRadioNo.setText("Academic User");
        trackingRadioNo.setEnabled(false);

        trackingRadioYes.setBackground(new java.awt.Color(110, 110, 110));
        trackingOptionsBtnGrp.add(trackingRadioYes);
        trackingRadioYes.setFont(new java.awt.Font("Lucida Sans Unicode", 0, 11)); // NOI18N
        trackingRadioYes.setForeground(new java.awt.Color(255, 255, 255));
        trackingRadioYes.setSelected(true);
        trackingRadioYes.setText("Academic User");
        trackingRadioYes.setEnabled(false);

        org.jdesktop.layout.GroupLayout jPanel5Layout = new org.jdesktop.layout.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
            .add(jPanel5Layout.createSequentialGroup()
                .addContainerGap()
                .add(jPanel5Layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
                    .add(trackingRadioYes)
                    .add(trackingRadioNo))
                .addContainerGap(org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
            .add(jPanel5Layout.createSequentialGroup()
                .addContainerGap()
                .add(trackingRadioYes)
                .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED)
                .add(trackingRadioNo)
                .addContainerGap())
        );

        jPanel6.setBackground(new java.awt.Color(110, 110, 110));

        commercialRadio.setBackground(new java.awt.Color(110, 110, 110));
        licenceTypeGrp.add(commercialRadio);
        commercialRadio.setFont(new java.awt.Font("Lucida Sans Unicode", 0, 11)); // NOI18N
        commercialRadio.setForeground(new java.awt.Color(255, 255, 255));
        commercialRadio.setText("Academic User");

        academicRadio.setBackground(new java.awt.Color(110, 110, 110));
        licenceTypeGrp.add(academicRadio);
        academicRadio.setFont(new java.awt.Font("Lucida Sans Unicode", 0, 11)); // NOI18N
        academicRadio.setForeground(new java.awt.Color(255, 255, 255));
        academicRadio.setText("Academic User");

        org.jdesktop.layout.GroupLayout jPanel6Layout = new org.jdesktop.layout.GroupLayout(jPanel6);
        jPanel6.setLayout(jPanel6Layout);
        jPanel6Layout.setHorizontalGroup(
            jPanel6Layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
            .add(jPanel6Layout.createSequentialGroup()
                .addContainerGap()
                .add(jPanel6Layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
                    .add(academicRadio)
                    .add(commercialRadio))
                .addContainerGap(org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel6Layout.setVerticalGroup(
            jPanel6Layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
            .add(jPanel6Layout.createSequentialGroup()
                .addContainerGap()
                .add(academicRadio)
                .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED)
                .add(commercialRadio)
                .addContainerGap())
        );

        org.jdesktop.layout.GroupLayout licenceTypeOptionsPanelLayout = new org.jdesktop.layout.GroupLayout(licenceTypeOptionsPanel);
        licenceTypeOptionsPanel.setLayout(licenceTypeOptionsPanelLayout);
        licenceTypeOptionsPanelLayout.setHorizontalGroup(
            licenceTypeOptionsPanelLayout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
            .add(jPanel5, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .add(org.jdesktop.layout.GroupLayout.TRAILING, jPanel6, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        licenceTypeOptionsPanelLayout.setVerticalGroup(
            licenceTypeOptionsPanelLayout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
            .add(licenceTypeOptionsPanelLayout.createSequentialGroup()
                .addContainerGap()
                .add(jPanel6, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .add(18, 18, 18)
                .add(jPanel5, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        licenceTypeLbl.setFont(new java.awt.Font("Lucida Sans Unicode", 0, 11)); // NOI18N
        licenceTypeLbl.setForeground(new java.awt.Color(255, 255, 255));
        licenceTypeLbl.setText("-Licence Type");

        trackingLbl.setFont(new java.awt.Font("Lucida Sans Unicode", 0, 11)); // NOI18N
        trackingLbl.setForeground(new java.awt.Color(255, 255, 255));
        trackingLbl.setText("-Licence Type");
        trackingLbl.setEnabled(false);

        userDetailsLbl.setFont(new java.awt.Font("Lucida Sans Unicode", 0, 11)); // NOI18N
        userDetailsLbl.setForeground(new java.awt.Color(255, 255, 255));
        userDetailsLbl.setText("-Licence Type");
        userDetailsLbl.setEnabled(false);

        org.jdesktop.layout.GroupLayout jPanel2Layout = new org.jdesktop.layout.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
            .add(licenceTypeOptionsPanel, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .add(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .add(jPanel2Layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
                    .add(userDetailsLbl, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .add(trackingLbl, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .add(licenceTypeLbl, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
            .add(org.jdesktop.layout.GroupLayout.TRAILING, jPanel3, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
            .add(org.jdesktop.layout.GroupLayout.TRAILING, jPanel2Layout.createSequentialGroup()
                .add(38, 38, 38)
                .add(licenceTypeLbl, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 33, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED)
                .add(trackingLbl, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 33, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED)
                .add(userDetailsLbl, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 33, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED, 207, Short.MAX_VALUE)
                .add(licenceTypeOptionsPanel, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(org.jdesktop.layout.LayoutStyle.UNRELATED)
                .add(jPanel3, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        org.jdesktop.layout.GroupLayout jPanel7Layout = new org.jdesktop.layout.GroupLayout(jPanel7);
        jPanel7.setLayout(jPanel7Layout);
        jPanel7Layout.setHorizontalGroup(
            jPanel7Layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
            .add(jPanel7Layout.createSequentialGroup()
                .addContainerGap()
                .add(jPanel7Layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
                    .add(jPanel7Layout.createSequentialGroup()
                        .add(jPanel2, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED)
                        .add(mainViewScroller))
                    .add(jPanel1, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        jPanel7Layout.setVerticalGroup(
            jPanel7Layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
            .add(jPanel7Layout.createSequentialGroup()
                .addContainerGap()
                .add(jPanel7Layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
                    .add(mainViewScroller)
                    .add(jPanel2, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .add(18, 18, 18)
                .add(jPanel1, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        org.jdesktop.layout.GroupLayout layout = new org.jdesktop.layout.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
            .add(jPanel7, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
            .add(jPanel7, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

  public void nextPage()
  {
    

    try
    {
      
      currentIndex++;
      if(currentIndex >= visible_pages.size())
        currentIndex = 0;
      BufferedImage bi = visible_pages.get( currentIndex ).convertToImage();
      //bi.
      PDF_ViewerLabel.setIcon( new ImageIcon( bi ) );
    }
    catch ( IOException ex )
    {
      LOGGER.log( Level.SEVERE, ex.getMessage() );
    }
    //PDFViewer PDFView = new PDFViewer(Tools.ROOT_DIR + DIR_SEPARATOR + "sRNA-WorkbenchEULA.pdf");

    
  }
  public void previousPage()
  {
    


    try
    {
      
      currentIndex--;
      if ( currentIndex < 0 )
      {
        currentIndex = visible_pages.size()-1;
      }
      BufferedImage bi = visible_pages.get( currentIndex ).convertToImage();
      PDF_ViewerLabel.setIcon( new ImageIcon( bi ) );
      
    }
    catch ( IOException ex )
    {
      LOGGER.log( Level.SEVERE, ex.getMessage() );
    }

    //PDFViewer PDFView = new PDFViewer(Tools.ROOT_DIR + DIR_SEPARATOR + "sRNA-WorkbenchEULA.pdf");

    
  }
  private void forwardsClickActionPerformed( java.awt.event.ActionEvent evt )//GEN-FIRST:event_forwardsClickActionPerformed
  {//GEN-HEADEREND:event_forwardsClickActionPerformed
    SwingUtilities.invokeLater( new Runnable()
    {
      @Override
      public void run()
      {


        nextPage();
      }
    } );
  }//GEN-LAST:event_forwardsClickActionPerformed

  private void backwardsClickActionPerformed( java.awt.event.ActionEvent evt )//GEN-FIRST:event_backwardsClickActionPerformed
  {//GEN-HEADEREND:event_backwardsClickActionPerformed
    //System.out.println("current highest depth: " + imageLayerPane.highestLayer());
    SwingUtilities.invokeLater( new Runnable()
    {
      @Override
      public void run()
      {


        previousPage();
      }
    } );

  }//GEN-LAST:event_backwardsClickActionPerformed

  private void nextStartupOption()
  {
    startupStage++;
    checkOptionState();
  }
  private void changeLicenceOptionsEnable(boolean newState)
  {
    
    academicRadio.setEnabled( newState );
    this.commercialRadio.setEnabled( newState );
    licenceTypeLbl.setEnabled( newState );
    
  
    
  }
  private void changeTrackingOptionsEnable(boolean newState)
  {
    trackingRadioYes.setEnabled( newState );
    trackingRadioNo.setEnabled( newState );
    //licenceTypeOptionsPanel.setVisible( newState );
    trackingLbl.setEnabled( newState );
   
  }
  private void changeUserDetailsEnable(boolean newState)
  {
    //licenceTypeOptionsPanel.setVisible( newState );
    userDetailsLbl.setEnabled( newState );
    
  }
  private void previousStartupOption()
  {
    startupStage--;
    checkOptionState();
    
  }
  private void finishOption()
  {
    sendData();
    
    this.setVisible( false );
  }
  private void changePDFControlClick(boolean newState)
  {
    backwardsClick.setEnabled( newState );
    forwardsClick.setEnabled(newState );
  }
  private void checkOptionState()
  {
    switch ( startupStage )
    {
      case 0:
        mainViewScroller.setViewportView( PDF_ViewerLabel );
        this.mainViewScroller.setVerticalScrollBarPolicy( ScrollPaneConstants.VERTICAL_SCROLLBAR_AS_NEEDED );

        changeLicenceOptionsEnable( true );
        changeTrackingOptionsEnable( false );
        changeUserDetailsEnable( false );
        prevBtn.setEnabled( false );
        nextBtn.setEnabled( true );
        finishBtn.setEnabled( false );

        visible_pages = licence_pages;
        this.currentIndex = -1;
        nextPage();

        break;
      case 1:
        //mainViewScroller.setViewportView( PDF_ViewerLabel );
        
        if ( GroupButtonUtils.getSelectedButtonText( this.licenceTypeGrp ) == null )
        {
          JOptionPane.showMessageDialog( this,
            "Please select a user type",
            "Please fill out missing information",
            JOptionPane.ERROR_MESSAGE );
          this.startupStage = 0;
        }
        else
        {
          createHTMLView("http://srna-workbench.cmp.uea.ac.uk/user-participation/");
          this.mainViewScroller.setVerticalScrollBarPolicy( ScrollPaneConstants.VERTICAL_SCROLLBAR_NEVER );
          changeLicenceOptionsEnable( false );
          changeTrackingOptionsEnable( true );
          changeUserDetailsEnable( false );
          prevBtn.setEnabled( true );
          nextBtn.setEnabled( true );
          finishBtn.setEnabled( false );
          
        }

        break;
      case 2:
        this.mainViewScroller.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_NEVER);
        changeLicenceOptionsEnable(false);
        changeTrackingOptionsEnable(false);
        changeUserDetailsEnable(true);
        prevBtn.setEnabled( true );
        nextBtn.setEnabled( false );
        finishBtn.setEnabled( true );

        createHTMLView("http://srna-workbench.cmp.uea.ac.uk/user-information/");
        break;
      default:
        finishOption();
        break;
    }
  }
  private void nextBtnActionPerformed( java.awt.event.ActionEvent evt )//GEN-FIRST:event_nextBtnActionPerformed
  {//GEN-HEADEREND:event_nextBtnActionPerformed
    nextStartupOption();
  }//GEN-LAST:event_nextBtnActionPerformed

  private void prevBtnActionPerformed( java.awt.event.ActionEvent evt )//GEN-FIRST:event_prevBtnActionPerformed
  {//GEN-HEADEREND:event_prevBtnActionPerformed
    previousStartupOption();
  }//GEN-LAST:event_prevBtnActionPerformed

  private void finishBtnActionPerformed( java.awt.event.ActionEvent evt )//GEN-FIRST:event_finishBtnActionPerformed
  {//GEN-HEADEREND:event_finishBtnActionPerformed
    finishOption();
  }//GEN-LAST:event_finishBtnActionPerformed

  private void createHTMLView(String path)
  {
     FXBrowser br = new FXBrowser();
    br.loadURL (  
  path);

    this.mainViewScroller.setViewportView( br );
    
     
  }
  
  
  private void sendData()
  {
    
    if ( GroupButtonUtils.getSelectedButtonText( licenceTypeGrp ).equals( "Academic User" ) )
    {
      //insertString = "UPDATE `LicenceTypes` SET `Academic`=`Academic`+1";
      
      Tools.updateServerData( "aca" );
    }
    else
    {
      if ( GroupButtonUtils.getSelectedButtonText( licenceTypeGrp ).equals( "Commercial User" ) )
      {
        //insertString = "UPDATE `LicenceTypes` SET `Commercial`=`Commercial`+1";
        
        Tools.updateServerData( "com" );
      }
    }

  }
  /**
   * @param args the command line arguments
   */
  public static void main( String args[] )
  {
    /*
     * Set the Nimbus look and feel
     */
    //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /*
     * If Nimbus (introduced in Java SE 6) is not available, stay with the
     * default look and feel. For details see
     * http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html
     */
//    try
//    {
//      for ( javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels() )
//      {
//        if ( "Nimbus".equals( info.getName() ) )
//        {
//          javax.swing.UIManager.setLookAndFeel( info.getClassName() );
//          break;
//        }
//      }
//    }
//    catch ( ClassNotFoundException ex )
//    {
//      java.util.logging.Logger.getLogger( StartupOptionsLicence.class.getName() ).log( java.util.logging.Level.SEVERE, null, ex );
//    }
//    catch ( InstantiationException ex )
//    {
//      java.util.logging.Logger.getLogger( StartupOptionsLicence.class.getName() ).log( java.util.logging.Level.SEVERE, null, ex );
//    }
//    catch ( IllegalAccessException ex )
//    {
//      java.util.logging.Logger.getLogger( StartupOptionsLicence.class.getName() ).log( java.util.logging.Level.SEVERE, null, ex );
//    }
//    catch ( javax.swing.UnsupportedLookAndFeelException ex )
//    {
//      java.util.logging.Logger.getLogger( StartupOptionsLicence.class.getName() ).log( java.util.logging.Level.SEVERE, null, ex );
//    }
    //</editor-fold>

    /*
     * Create and display the dialog
     */
    java.awt.EventQueue.invokeLater( new Runnable()
    {
      @Override
      public void run()
      {
        StartupOptionsLicence dialog = new StartupOptionsLicence( new javax.swing.JFrame(), true );
        dialog.addWindowListener( new java.awt.event.WindowAdapter()
        {
          @Override
          public void windowClosing( java.awt.event.WindowEvent e )
          {
            System.exit( 0 );
          }
        } );
        dialog.setVisible( true );
      }
    } );
  }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel PDF_ViewerLabel;
    private javax.swing.JRadioButton academicRadio;
    private javax.swing.JButton backwardsClick;
    private javax.swing.JRadioButton commercialRadio;
    private javax.swing.JButton finishBtn;
    private javax.swing.JButton forwardsClick;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JPanel jPanel7;
    private javax.swing.ButtonGroup licenceTypeGrp;
    private javax.swing.JLabel licenceTypeLbl;
    private javax.swing.JPanel licenceTypeOptionsPanel;
    private javax.swing.JScrollPane mainViewScroller;
    private javax.swing.JButton nextBtn;
    private javax.swing.JButton prevBtn;
    private javax.swing.JLabel trackingLbl;
    private javax.swing.ButtonGroup trackingOptionsBtnGrp;
    private javax.swing.JRadioButton trackingRadioNo;
    private javax.swing.JRadioButton trackingRadioYes;
    private javax.swing.JLabel userDetailsLbl;
    // End of variables declaration//GEN-END:variables

  public boolean getTrackingOption()
  {
    return GroupButtonUtils.getSelectedButtonText( this.trackingOptionsBtnGrp).equals( "Allow Feedback");
  }
  
  public String getUserType()
  {
    return GroupButtonUtils.getSelectedButtonText( licenceTypeGrp );
  }


}

