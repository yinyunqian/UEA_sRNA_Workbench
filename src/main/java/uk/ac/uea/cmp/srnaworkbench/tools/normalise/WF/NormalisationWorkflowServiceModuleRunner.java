/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package uk.ac.uea.cmp.srnaworkbench.tools.normalise.WF;

import uk.ac.uea.cmp.srnaworkbench.workflow.WorkflowRunner;

/**
 *
 * @author w0445959
 */
public class NormalisationWorkflowServiceModuleRunner extends WorkflowRunner
{
    public NormalisationWorkflowServiceModuleRunner(NormalisationWorkflowServiceModule module)
    {
        super(module);
    }
    
    @Override
    public boolean getActive()
    {
        if (this.engine instanceof NormalisationWorkflowServiceModule)
        {
            
            return !((NormalisationWorkflowServiceModule)engine).readyToContinue();
        }
        return false;
    }
    
}
