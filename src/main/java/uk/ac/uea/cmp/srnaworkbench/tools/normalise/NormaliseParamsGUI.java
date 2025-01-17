/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package uk.ac.uea.cmp.srnaworkbench.tools.normalise;

import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.logging.Level;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import uk.ac.uea.cmp.srnaworkbench.tools.ToolParameters;
import uk.ac.uea.cmp.srnaworkbench.tools.ToolParamsHost;
import uk.ac.uea.cmp.srnaworkbench.utils.StringUtils;
import static uk.ac.uea.cmp.srnaworkbench.utils.LOGGERS.WorkbenchLogger.LOGGER;

/**
 *
 * @author w0445959
 */
public class NormaliseParamsGUI extends javax.swing.JPanel implements ToolParamsHost
{
  
  // names for all seperate JPanels that denote parameter "categories"
  public static final String PANEL_NAME_GENERAL = "general";
  public static final String PANEL_NAME_REF_SAMPLE = "refSample";
  public static final String PANEL_NAME_TRIMMED_MEAN = "trimmedMean";
  public static final String PANEL_NAME_ABUNDANCE_DIST = "abundanceDist";
  public static final String PANEL_NAME_QUANTILE = "quantile";
  
  private NormalisationParams params;
  JPanel[] hp;
  /**
   * Creates new form NormaliseParamsGUI
   */
  public NormaliseParamsGUI()
  {
    initComponents();
    this.params = new NormalisationParams(); 
    initParamFields(this.params);
    
    // Give each panel an accessible ID
    generalPanel.setName( NormaliseParamsGUI.PANEL_NAME_GENERAL );
    samplePanel.setName( NormaliseParamsGUI.PANEL_NAME_REF_SAMPLE );
    trimmedMeanPanel.setName( NormaliseParamsGUI.PANEL_NAME_TRIMMED_MEAN );
    abundanceDistPanel.setName( NormaliseParamsGUI.PANEL_NAME_ABUNDANCE_DIST );
    this.quantilePanel.setName( NormaliseParamsGUI.PANEL_NAME_QUANTILE );
    
    // Add all panels to this array of all possible visible panels:
    hp = new JPanel[]{
      generalPanel, samplePanel, trimmedMeanPanel, abundanceDistPanel, quantilePanel
    };
    
    this.paramsToolBar.setHost( this );
  }
  
  /**
   * Initialise parameter fields with values from input params
   * This is used in the constructor where it is fed a default set of params
   * to be set initially, and in the update() method when a new set of params is
   * given from file
   * @param params 
   */
  private void initParamFields( NormalisationParams thisParams )
  {
    // Set text fields to show defaults for all parameters
    this.txtMinLength.setText( Integer.toString( thisParams.getMinLength()));
    this.txtMaxLength.setText( Integer.toString( thisParams.getMaxLength()));
    this.txtOutsfx.setText( thisParams.getOutSfx() );
    this.txtAtrimRatio.setText( Integer.toString(  thisParams.getAtrim()));
    this.txtMtrimRatio.setText( Integer.toString(  thisParams.getMtrim()));
    this.chkWeightTMM.setSelected( thisParams.isWeightFactors() );
    this.txtLogBase.setText(  Integer.toString(  thisParams.getLogBase() ));
    this.txtMinAbund.setText(  Integer.toString( thisParams.getMinConsider()));
    this.chkWeightByHits.setSelected( thisParams.isWeightByHits() );
    this.comboRefSample.addItem( thisParams.getRefSample() );
    this.comboRefSample.setSelectedItem( thisParams.getRefSample() );
    this.chkRNAseqMod.setSelected( thisParams.isRNASEQqnorm() );
  }
  
  /***
   * Sets only the panels visible whose .getName() returns the name in
   * the given array
   * @param panelNames names of panels to set visible 
   */
  public void setParamPanelVisible(String[] panelNames)
  {
    for(JPanel thisp : hp)
    {
      // For each panel, if its name is in the list, set visible. If it isn't
      // set not visible regardless of previous state
      boolean isInList = false;
      for (String q : panelNames )
      {
        if (thisp.getName().equals( q ))
          isInList = ( true );
      }
      thisp.setVisible( isInList );
    }
  }

  /**
   * Sets the list of filenames that the Reference sample combobox lists
   * This is found from the valid files that are currently in the input box
   * @param filenames a list of Files
   */
  public void setReferenceSampleSelection(ArrayList<File> filenames)
  {
    DefaultComboBoxModel<String> lm = new DefaultComboBoxModel<>();
    if (filenames.isEmpty())
    {
      // Blank combo box when no files have been given
      lm.addElement( "" );
    }
    else
    {
      // First element should be an auto choose prompt
      lm.addElement( NormalisationParams.STR_AUTO_CHOOSE );
      for (File thisFile : filenames)
      {
        String thisName = thisFile.getName();
        lm.addElement( thisName );
      }
    }
    this.comboRefSample.setModel( lm );
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

    abundanceDistPanel = new javax.swing.JPanel();
    txtLogBase = new javax.swing.JFormattedTextField();
    lblLogBase = new javax.swing.JLabel();
    lblMinConsider = new javax.swing.JLabel();
    txtMinAbund = new javax.swing.JFormattedTextField();
    trimmedMeanPanel = new javax.swing.JPanel();
    txtAtrimRatio = new javax.swing.JFormattedTextField();
    lblAtrimRatio = new javax.swing.JLabel();
    lblMtrimRatio = new javax.swing.JLabel();
    txtMtrimRatio = new javax.swing.JFormattedTextField();
    chkWeightTMM = new javax.swing.JCheckBox();
    samplePanel = new javax.swing.JPanel();
    lblRefSample = new javax.swing.JLabel();
    comboRefSample = new javax.swing.JComboBox<String>();
    generalPanel = new javax.swing.JPanel();
    txtMinLength = new javax.swing.JFormattedTextField();
    lblMinLength = new javax.swing.JLabel();
    lblMaxLength = new javax.swing.JLabel();
    txtMaxLength = new javax.swing.JFormattedTextField();
    chkWeightByHits = new javax.swing.JCheckBox();
    outputPanel = new javax.swing.JPanel();
    lblOutSfx = new javax.swing.JLabel();
    txtOutsfx = new javax.swing.JTextField();
    jPanel1 = new javax.swing.JPanel();
    paramsToolBar = new uk.ac.uea.cmp.srnaworkbench.swing.ParamsToolBar();
    quantilePanel = new javax.swing.JPanel();
    chkRNAseqMod = new javax.swing.JCheckBox();

    setBackground(new java.awt.Color(120, 120, 120));
    setBorder(javax.swing.BorderFactory.createTitledBorder(null, org.openide.util.NbBundle.getMessage(NormaliseParamsGUI.class, "NormaliseParamsGUI.border.title"), javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Lucida Sans Unicode", 0, 11), new java.awt.Color(255, 255, 255))); // NOI18N

    abundanceDistPanel.setBackground(new java.awt.Color(120, 120, 120));
    abundanceDistPanel.setBorder(javax.swing.BorderFactory.createTitledBorder(null, org.openide.util.NbBundle.getMessage(NormaliseParamsGUI.class, "NormaliseParamsGUI.abundanceDistPanel.border.title"), javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Lucida Sans Unicode", 0, 11), new java.awt.Color(255, 255, 255))); // NOI18N

    txtLogBase.setText(org.openide.util.NbBundle.getMessage(NormaliseParamsGUI.class, "NormaliseParamsGUI.txtLogBase.text")); // NOI18N

    lblLogBase.setFont(new java.awt.Font("Lucida Sans Unicode", 0, 11)); // NOI18N
    lblLogBase.setForeground(new java.awt.Color(255, 255, 255));
    lblLogBase.setText(org.openide.util.NbBundle.getMessage(NormaliseParamsGUI.class, "NormaliseParamsGUI.lblLogBase.text")); // NOI18N

    lblMinConsider.setFont(new java.awt.Font("Lucida Sans Unicode", 0, 11)); // NOI18N
    lblMinConsider.setForeground(new java.awt.Color(255, 255, 255));
    lblMinConsider.setText(org.openide.util.NbBundle.getMessage(NormaliseParamsGUI.class, "NormaliseParamsGUI.lblMinConsider.text")); // NOI18N

    txtMinAbund.setText(org.openide.util.NbBundle.getMessage(NormaliseParamsGUI.class, "NormaliseParamsGUI.txtMinAbund.text")); // NOI18N

    javax.swing.GroupLayout abundanceDistPanelLayout = new javax.swing.GroupLayout(abundanceDistPanel);
    abundanceDistPanel.setLayout(abundanceDistPanelLayout);
    abundanceDistPanelLayout.setHorizontalGroup(
      abundanceDistPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
      .addGroup(abundanceDistPanelLayout.createSequentialGroup()
        .addContainerGap()
        .addGroup(abundanceDistPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
          .addComponent(lblMinConsider, javax.swing.GroupLayout.DEFAULT_SIZE, 95, Short.MAX_VALUE)
          .addComponent(lblLogBase, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        .addGroup(abundanceDistPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
          .addComponent(txtLogBase, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 67, javax.swing.GroupLayout.PREFERRED_SIZE)
          .addComponent(txtMinAbund, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 67, javax.swing.GroupLayout.PREFERRED_SIZE))
        .addContainerGap())
    );
    abundanceDistPanelLayout.setVerticalGroup(
      abundanceDistPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
      .addGroup(abundanceDistPanelLayout.createSequentialGroup()
        .addContainerGap()
        .addGroup(abundanceDistPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
          .addComponent(txtLogBase, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
          .addComponent(lblLogBase))
        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
        .addGroup(abundanceDistPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
          .addComponent(txtMinAbund, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
          .addComponent(lblMinConsider))
        .addContainerGap(12, Short.MAX_VALUE))
    );

    trimmedMeanPanel.setBackground(new java.awt.Color(120, 120, 120));
    trimmedMeanPanel.setBorder(javax.swing.BorderFactory.createTitledBorder(null, org.openide.util.NbBundle.getMessage(NormaliseParamsGUI.class, "NormaliseParamsGUI.trimmedMeanPanel.border.title"), javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Lucida Sans Unicode", 0, 11), new java.awt.Color(255, 255, 255))); // NOI18N

    txtAtrimRatio.setText(org.openide.util.NbBundle.getMessage(NormaliseParamsGUI.class, "NormaliseParamsGUI.txtAtrimRatio.text")); // NOI18N

    lblAtrimRatio.setFont(new java.awt.Font("Lucida Sans Unicode", 0, 11)); // NOI18N
    lblAtrimRatio.setForeground(new java.awt.Color(255, 255, 255));
    lblAtrimRatio.setText(org.openide.util.NbBundle.getMessage(NormaliseParamsGUI.class, "NormaliseParamsGUI.lblAtrimRatio.text")); // NOI18N

    lblMtrimRatio.setFont(new java.awt.Font("Lucida Sans Unicode", 0, 11)); // NOI18N
    lblMtrimRatio.setForeground(new java.awt.Color(255, 255, 255));
    lblMtrimRatio.setText(org.openide.util.NbBundle.getMessage(NormaliseParamsGUI.class, "NormaliseParamsGUI.lblMtrimRatio.text")); // NOI18N

    txtMtrimRatio.setText(org.openide.util.NbBundle.getMessage(NormaliseParamsGUI.class, "NormaliseParamsGUI.txtMtrimRatio.text")); // NOI18N

    chkWeightTMM.setBackground(new java.awt.Color(120, 120, 120));
    chkWeightTMM.setForeground(new java.awt.Color(255, 255, 255));
    chkWeightTMM.setText(org.openide.util.NbBundle.getMessage(NormaliseParamsGUI.class, "NormaliseParamsGUI.chkWeightTMM.text")); // NOI18N
    chkWeightTMM.setToolTipText(org.openide.util.NbBundle.getMessage(NormaliseParamsGUI.class, "NormaliseParamsGUI.chkWeightTMM.toolTipText")); // NOI18N

    javax.swing.GroupLayout trimmedMeanPanelLayout = new javax.swing.GroupLayout(trimmedMeanPanel);
    trimmedMeanPanel.setLayout(trimmedMeanPanelLayout);
    trimmedMeanPanelLayout.setHorizontalGroup(
      trimmedMeanPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
      .addGroup(trimmedMeanPanelLayout.createSequentialGroup()
        .addContainerGap()
        .addGroup(trimmedMeanPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
          .addGroup(trimmedMeanPanelLayout.createSequentialGroup()
            .addComponent(chkWeightTMM)
            .addGap(0, 0, Short.MAX_VALUE))
          .addGroup(trimmedMeanPanelLayout.createSequentialGroup()
            .addGroup(trimmedMeanPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
              .addComponent(lblMtrimRatio, javax.swing.GroupLayout.DEFAULT_SIZE, 121, Short.MAX_VALUE)
              .addComponent(lblAtrimRatio, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(trimmedMeanPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
              .addComponent(txtAtrimRatio, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 67, javax.swing.GroupLayout.PREFERRED_SIZE)
              .addComponent(txtMtrimRatio, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 67, javax.swing.GroupLayout.PREFERRED_SIZE))))
        .addContainerGap())
    );
    trimmedMeanPanelLayout.setVerticalGroup(
      trimmedMeanPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
      .addGroup(trimmedMeanPanelLayout.createSequentialGroup()
        .addComponent(chkWeightTMM)
        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        .addGroup(trimmedMeanPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
          .addComponent(txtAtrimRatio, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
          .addComponent(lblAtrimRatio))
        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
        .addGroup(trimmedMeanPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
          .addComponent(txtMtrimRatio, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
          .addComponent(lblMtrimRatio)))
    );

    lblAtrimRatio.getAccessibleContext().setAccessibleName(org.openide.util.NbBundle.getMessage(NormaliseParamsGUI.class, "NormaliseParamsGUI.lblAtrimRatio.AccessibleContext.accessibleName")); // NOI18N

    samplePanel.setBackground(new java.awt.Color(120, 120, 120));
    samplePanel.setBorder(javax.swing.BorderFactory.createTitledBorder(null, org.openide.util.NbBundle.getMessage(NormaliseParamsGUI.class, "NormaliseParamsGUI.samplePanel.border.title"), javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Lucida Sans Unicode", 0, 11), new java.awt.Color(255, 255, 255))); // NOI18N

    lblRefSample.setFont(new java.awt.Font("Lucida Sans Unicode", 0, 11)); // NOI18N
    lblRefSample.setForeground(new java.awt.Color(255, 255, 255));
    lblRefSample.setText(org.openide.util.NbBundle.getMessage(NormaliseParamsGUI.class, "NormaliseParamsGUI.lblRefSample.text")); // NOI18N

    javax.swing.GroupLayout samplePanelLayout = new javax.swing.GroupLayout(samplePanel);
    samplePanel.setLayout(samplePanelLayout);
    samplePanelLayout.setHorizontalGroup(
      samplePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
      .addGroup(samplePanelLayout.createSequentialGroup()
        .addContainerGap()
        .addComponent(lblRefSample)
        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        .addComponent(comboRefSample, javax.swing.GroupLayout.PREFERRED_SIZE, 172, javax.swing.GroupLayout.PREFERRED_SIZE)
        .addContainerGap())
    );
    samplePanelLayout.setVerticalGroup(
      samplePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
      .addGroup(samplePanelLayout.createSequentialGroup()
        .addContainerGap()
        .addGroup(samplePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
          .addComponent(lblRefSample)
          .addComponent(comboRefSample, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        .addContainerGap(13, Short.MAX_VALUE))
    );

    generalPanel.setBackground(new java.awt.Color(120, 120, 120));
    generalPanel.setBorder(javax.swing.BorderFactory.createTitledBorder(null, org.openide.util.NbBundle.getMessage(NormaliseParamsGUI.class, "NormaliseParamsGUI.generalPanel.border.title"), javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Lucida Sans Unicode", 0, 11), new java.awt.Color(255, 255, 255))); // NOI18N

    txtMinLength.setText(org.openide.util.NbBundle.getMessage(NormaliseParamsGUI.class, "NormaliseParamsGUI.txtMinLength.text")); // NOI18N

    lblMinLength.setFont(new java.awt.Font("Lucida Sans Unicode", 0, 11)); // NOI18N
    lblMinLength.setForeground(new java.awt.Color(255, 255, 255));
    lblMinLength.setText(org.openide.util.NbBundle.getMessage(NormaliseParamsGUI.class, "NormaliseParamsGUI.lblMinLength.text")); // NOI18N

    lblMaxLength.setFont(new java.awt.Font("Lucida Sans Unicode", 0, 11)); // NOI18N
    lblMaxLength.setForeground(new java.awt.Color(255, 255, 255));
    lblMaxLength.setText(org.openide.util.NbBundle.getMessage(NormaliseParamsGUI.class, "NormaliseParamsGUI.lblMaxLength.text")); // NOI18N

    txtMaxLength.setText(org.openide.util.NbBundle.getMessage(NormaliseParamsGUI.class, "NormaliseParamsGUI.txtMaxLength.text")); // NOI18N

    chkWeightByHits.setBackground(new java.awt.Color(120, 120, 120));
    chkWeightByHits.setForeground(new java.awt.Color(255, 255, 255));
    chkWeightByHits.setText(org.openide.util.NbBundle.getMessage(NormaliseParamsGUI.class, "NormaliseParamsGUI.chkWeightByHits.text")); // NOI18N
    chkWeightByHits.setToolTipText(org.openide.util.NbBundle.getMessage(NormaliseParamsGUI.class, "NormaliseParamsGUI.chkWeightByHits.toolTipText")); // NOI18N

    javax.swing.GroupLayout generalPanelLayout = new javax.swing.GroupLayout(generalPanel);
    generalPanel.setLayout(generalPanelLayout);
    generalPanelLayout.setHorizontalGroup(
      generalPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
      .addGroup(generalPanelLayout.createSequentialGroup()
        .addContainerGap()
        .addGroup(generalPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
          .addGroup(generalPanelLayout.createSequentialGroup()
            .addGroup(generalPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
              .addComponent(lblMaxLength, javax.swing.GroupLayout.DEFAULT_SIZE, 118, Short.MAX_VALUE)
              .addComponent(lblMinLength, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(generalPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
              .addComponent(txtMinLength, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 67, javax.swing.GroupLayout.PREFERRED_SIZE)
              .addComponent(txtMaxLength, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 67, javax.swing.GroupLayout.PREFERRED_SIZE)))
          .addGroup(generalPanelLayout.createSequentialGroup()
            .addComponent(chkWeightByHits)
            .addGap(0, 0, Short.MAX_VALUE)))
        .addContainerGap())
    );
    generalPanelLayout.setVerticalGroup(
      generalPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
      .addGroup(generalPanelLayout.createSequentialGroup()
        .addContainerGap()
        .addGroup(generalPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
          .addComponent(txtMinLength, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
          .addComponent(lblMinLength))
        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
        .addGroup(generalPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
          .addComponent(txtMaxLength, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
          .addComponent(lblMaxLength))
        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        .addComponent(chkWeightByHits))
    );

    outputPanel.setBackground(new java.awt.Color(120, 120, 120));
    outputPanel.setBorder(javax.swing.BorderFactory.createTitledBorder(null, org.openide.util.NbBundle.getMessage(NormaliseParamsGUI.class, "NormaliseParamsGUI.outputPanel.border.title"), javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Lucida Sans Unicode", 0, 11), new java.awt.Color(255, 255, 255))); // NOI18N

    lblOutSfx.setFont(new java.awt.Font("Lucida Sans Unicode", 0, 11)); // NOI18N
    lblOutSfx.setForeground(new java.awt.Color(255, 255, 255));
    lblOutSfx.setText(org.openide.util.NbBundle.getMessage(NormaliseParamsGUI.class, "NormaliseParamsGUI.lblOutSfx.text")); // NOI18N

    txtOutsfx.setText(org.openide.util.NbBundle.getMessage(NormaliseParamsGUI.class, "NormaliseParamsGUI.txtOutsfx.text")); // NOI18N

    javax.swing.GroupLayout outputPanelLayout = new javax.swing.GroupLayout(outputPanel);
    outputPanel.setLayout(outputPanelLayout);
    outputPanelLayout.setHorizontalGroup(
      outputPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
      .addGroup(outputPanelLayout.createSequentialGroup()
        .addContainerGap()
        .addComponent(lblOutSfx, javax.swing.GroupLayout.PREFERRED_SIZE, 83, javax.swing.GroupLayout.PREFERRED_SIZE)
        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        .addComponent(txtOutsfx, javax.swing.GroupLayout.PREFERRED_SIZE, 172, javax.swing.GroupLayout.PREFERRED_SIZE)
        .addContainerGap())
    );
    outputPanelLayout.setVerticalGroup(
      outputPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
      .addGroup(outputPanelLayout.createSequentialGroup()
        .addContainerGap()
        .addGroup(outputPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
          .addComponent(lblOutSfx)
          .addComponent(txtOutsfx, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        .addContainerGap(13, Short.MAX_VALUE))
    );

    lblOutSfx.getAccessibleContext().setAccessibleName(org.openide.util.NbBundle.getMessage(NormaliseParamsGUI.class, "NormaliseParamsGUI.lblOutSfx.AccessibleContext.accessibleName")); // NOI18N
    txtOutsfx.getAccessibleContext().setAccessibleName(org.openide.util.NbBundle.getMessage(NormaliseParamsGUI.class, "NormaliseParamsGUI.txtOutsfx.AccessibleContext.accessibleName")); // NOI18N

    jPanel1.setBackground(new java.awt.Color(120, 120, 120));
    jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder(null, org.openide.util.NbBundle.getMessage(NormaliseParamsGUI.class, "NormaliseParamsGUI.jPanel1.border.title"), javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, null, new java.awt.Color(255, 255, 255))); // NOI18N

    javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
    jPanel1.setLayout(jPanel1Layout);
    jPanel1Layout.setHorizontalGroup(
      jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
      .addGroup(jPanel1Layout.createSequentialGroup()
        .addContainerGap()
        .addComponent(paramsToolBar, javax.swing.GroupLayout.PREFERRED_SIZE, 106, javax.swing.GroupLayout.PREFERRED_SIZE)
        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
    );
    jPanel1Layout.setVerticalGroup(
      jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
      .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        .addComponent(paramsToolBar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        .addContainerGap())
    );

    quantilePanel.setBackground(new java.awt.Color(120, 120, 120));
    quantilePanel.setBorder(javax.swing.BorderFactory.createTitledBorder(null, org.openide.util.NbBundle.getMessage(NormaliseParamsGUI.class, "NormaliseParamsGUI.quantilePanel.border.title"), javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Lucida Sans Unicode", 0, 11), new java.awt.Color(255, 255, 255))); // NOI18N

    chkRNAseqMod.setBackground(new java.awt.Color(120, 120, 120));
    chkRNAseqMod.setForeground(new java.awt.Color(255, 255, 255));
    chkRNAseqMod.setText(org.openide.util.NbBundle.getMessage(NormaliseParamsGUI.class, "NormaliseParamsGUI.chkRNAseqMod.text")); // NOI18N
    chkRNAseqMod.setToolTipText(org.openide.util.NbBundle.getMessage(NormaliseParamsGUI.class, "NormaliseParamsGUI.chkRNAseqMod.toolTipText")); // NOI18N
    chkRNAseqMod.setActionCommand(org.openide.util.NbBundle.getMessage(NormaliseParamsGUI.class, "NormaliseParamsGUI.chkRNAseqMod.actionCommand")); // NOI18N

    javax.swing.GroupLayout quantilePanelLayout = new javax.swing.GroupLayout(quantilePanel);
    quantilePanel.setLayout(quantilePanelLayout);
    quantilePanelLayout.setHorizontalGroup(
      quantilePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
      .addGroup(quantilePanelLayout.createSequentialGroup()
        .addContainerGap()
        .addComponent(chkRNAseqMod)
        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
    );
    quantilePanelLayout.setVerticalGroup(
      quantilePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
      .addGroup(quantilePanelLayout.createSequentialGroup()
        .addComponent(chkRNAseqMod)
        .addContainerGap(16, Short.MAX_VALUE))
    );

    javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
    this.setLayout(layout);
    layout.setHorizontalGroup(
      layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
      .addComponent(abundanceDistPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
      .addComponent(trimmedMeanPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
      .addComponent(samplePanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
      .addComponent(generalPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
      .addComponent(outputPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
      .addGroup(layout.createSequentialGroup()
        .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        .addContainerGap())
      .addComponent(quantilePanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
    );
    layout.setVerticalGroup(
      layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
      .addGroup(layout.createSequentialGroup()
        .addContainerGap()
        .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
        .addComponent(outputPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
        .addComponent(generalPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
        .addComponent(abundanceDistPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
        .addComponent(trimmedMeanPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
        .addComponent(quantilePanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
        .addComponent(samplePanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
    );

    outputPanel.getAccessibleContext().setAccessibleName(org.openide.util.NbBundle.getMessage(NormaliseParamsGUI.class, "NormaliseParamsGUI.outputPanel.AccessibleContext.accessibleName")); // NOI18N
    quantilePanel.getAccessibleContext().setAccessibleName(org.openide.util.NbBundle.getMessage(NormaliseParamsGUI.class, "NormaliseParamsGUI.quantilePanel.AccessibleContext.accessibleName")); // NOI18N
  }// </editor-fold>//GEN-END:initComponents
  // Variables declaration - do not modify//GEN-BEGIN:variables
  private javax.swing.JPanel abundanceDistPanel;
  private javax.swing.JCheckBox chkRNAseqMod;
  private javax.swing.JCheckBox chkWeightByHits;
  private javax.swing.JCheckBox chkWeightTMM;
  private javax.swing.JCheckBox chkWeightTMM1;
  private javax.swing.JCheckBox chkWeightTMM2;
  private javax.swing.JCheckBox chkWeightTMM3;
  private javax.swing.JCheckBox chkWeightTMM4;
  private javax.swing.JComboBox<String> comboRefSample;
  private javax.swing.JPanel generalPanel;
  private javax.swing.JPanel jPanel1;
  private javax.swing.JLabel lblAtrimRatio;
  private javax.swing.JLabel lblAtrimRatio1;
  private javax.swing.JLabel lblAtrimRatio2;
  private javax.swing.JLabel lblAtrimRatio3;
  private javax.swing.JLabel lblAtrimRatio4;
  private javax.swing.JLabel lblLogBase;
  private javax.swing.JLabel lblMaxLength;
  private javax.swing.JLabel lblMinConsider;
  private javax.swing.JLabel lblMinLength;
  private javax.swing.JLabel lblMtrimRatio;
  private javax.swing.JLabel lblMtrimRatio1;
  private javax.swing.JLabel lblMtrimRatio2;
  private javax.swing.JLabel lblMtrimRatio3;
  private javax.swing.JLabel lblMtrimRatio4;
  private javax.swing.JLabel lblOutSfx;
  private javax.swing.JLabel lblRefSample;
  private javax.swing.JPanel outputPanel;
  private uk.ac.uea.cmp.srnaworkbench.swing.ParamsToolBar paramsToolBar;
  private javax.swing.JPanel quantilePanel;
  private javax.swing.JPanel samplePanel;
  private javax.swing.JPanel trimmedMeanPanel;
  private javax.swing.JPanel trimmedMeanPanel1;
  private javax.swing.JPanel trimmedMeanPanel2;
  private javax.swing.JPanel trimmedMeanPanel3;
  private javax.swing.JPanel trimmedMeanPanel4;
  private javax.swing.JFormattedTextField txtAtrimRatio;
  private javax.swing.JFormattedTextField txtAtrimRatio1;
  private javax.swing.JFormattedTextField txtAtrimRatio2;
  private javax.swing.JFormattedTextField txtAtrimRatio3;
  private javax.swing.JFormattedTextField txtAtrimRatio4;
  private javax.swing.JFormattedTextField txtLogBase;
  private javax.swing.JFormattedTextField txtMaxLength;
  private javax.swing.JFormattedTextField txtMinAbund;
  private javax.swing.JFormattedTextField txtMinLength;
  private javax.swing.JFormattedTextField txtMtrimRatio;
  private javax.swing.JFormattedTextField txtMtrimRatio1;
  private javax.swing.JFormattedTextField txtMtrimRatio2;
  private javax.swing.JFormattedTextField txtMtrimRatio3;
  private javax.swing.JFormattedTextField txtMtrimRatio4;
  private javax.swing.JTextField txtOutsfx;
  // End of variables declaration//GEN-END:variables

  public boolean createParams()
  {
     try
    {
      String str_min_length = this.txtMinLength.getText().trim();
      int min_length = StringUtils.safeIntegerParse( str_min_length, StringUtils.safeIntegerParse( str_min_length, NormalisationParams.Definition.MIN_SRNA_LENGTH.getDefault( Integer.class )));
      
      String str_max_length = this.txtMaxLength.getText().trim();
      int max_length = StringUtils.safeIntegerParse( str_max_length, StringUtils.safeIntegerParse( str_max_length, NormalisationParams.Definition.MAX_SRNA_LENGTH.getDefault( Integer.class )));     
      
      String str_out_sfx = this.txtOutsfx.getText().trim();
      
      String str_log_base = this.txtLogBase.getText().trim();
      int log_base = StringUtils.safeIntegerParse( str_log_base, NormalisationParams.Definition.ABUNDANCE_DIST_LOG_BASE.getDefault( Integer.class ) );
      
      String str_min_abd = this.txtMinAbund.getText().trim();
      int min_abd = StringUtils.safeIntegerParse( str_min_abd, NormalisationParams.Definition.MINIMUM_SRNA_ABUNDANCE.getDefault( Integer.class ) );
      
      boolean isWeightByHits = this.chkWeightByHits.isSelected();
      
      //TMM params
      String str_mTrim = this.txtMtrimRatio.getText().trim();
      int mTrim = StringUtils.safeIntegerParse( str_mTrim, NormalisationParams.Definition.M_TRIM_PERCENTAGE.getDefault( Integer.class ) );
      String str_aTrim = this.txtAtrimRatio.getText().trim();
      int aTrim = StringUtils.safeIntegerParse( str_aTrim, NormalisationParams.Definition.A_TRIM_PERCENTAGE.getDefault( Integer.class ) ); 
      boolean isWeighted = this.chkWeightTMM.isSelected();  
      
      boolean isRNAseqMod = this.chkRNAseqMod.isSelected();
      
      String str_refSample = (String) this.comboRefSample.getSelectedItem();
      // If set to auto prompt, default to understood default of ""
      if (str_refSample.equals( NormalisationParams.STR_AUTO_CHOOSE ))
      {
        str_refSample = "";
      }
      str_refSample = str_refSample.trim();
      //String str_refSample = this.txtRefSample.getText().trim();

      NormalisationParams newParams = new NormalisationParams.Builder()
        .setMinLength( min_length )
        .setMaxLength( max_length )
        .setOutSfx( str_out_sfx )
        .setLogBase( log_base )
        .setMinConsider( min_abd )
        .setWeightByHits( isWeightByHits )
        .setMtrim( mTrim )
        .setAtrim( aTrim )
        .setWeightFactors( isWeighted )
        .setRefSample( str_refSample )
        .setRNASEQqnorm( isRNAseqMod )
        .build();
      this.params = newParams;
    }
    catch ( IllegalArgumentException e )
    {
      LOGGER.log( Level.WARNING, "failed params: {0}", e);
      return false;
    }

    return true;
  }
  
  public int getMinLength() { return params.getMinLength(); }
  public int getMaxLength() { return params.getMaxLength(); }
  public int getLogBase()
  {
    return params.getLogBase();
  }

  public int getMinAbund()
  {
    return params.getMinConsider();
  }
  
  public boolean isWeightByHits()
  {
    return params.isWeightByHits();
  }
  
  public int getMtrim(){
    return params.getMtrim();
  }
  
  public int getAtrim(){
    return params.getAtrim();
  }
  
  public boolean isRNAseqQnorm()
  {
    return params.isRNASEQqnorm();
  }
  
  public String getRefSample() {
    return params.getRefSample();
  }

  @Override
  public NormalisationParams getParams()
  {
    if (createParams())
    {
      return this.params;
    }
    else
    {
      return new NormalisationParams();
    }
  }

  @Override
  public void update( ToolParameters params )
  {
    if(!(params instanceof NormalisationParams))
    {
      showErrorDialog("Unexpected error. Parameter object given was not for normalisation params");    
    }
    else
    {
      initParamFields( (NormalisationParams) params );
    }
  }

  @Override
  public void showErrorDialog( String message )
  {
    JOptionPane.showMessageDialog( this, message, "Normalisation configuration error", JOptionPane.ERROR_MESSAGE);
  }
}
