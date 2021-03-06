/*
 * Licensed to the Apache Software Foundation (ASF) under one
 * or more contributor license agreements.  See the NOTICE file
 * distributed with this work for additional information
 * regarding copyright ownership.  The ASF licenses this file
 * to you under the Apache License, Version 2.0 (the
 * "License"); you may not use this file except in compliance
 * with the License.  You may obtain a copy of the License at
 *
 *   http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing,
 * software distributed under the License is distributed on an
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
 * KIND, either express or implied.  See the License for the
 * specific language governing permissions and limitations
 * under the License.
 */
package org.netbeans.modules.refactoring.java.ui;

import org.openide.awt.ActionID;
import org.openide.awt.ActionReference;
import org.openide.awt.ActionReferences;
import org.openide.awt.ActionRegistration;
import org.openide.util.HelpCtx;
import org.openide.util.Lookup;
import org.openide.util.NbBundle;


/**
 * Activates change method signature refactoring. It is possible to do it
 * on methods and constructors.
 *
 * @author Jan Becicka
 */
@ActionID(id = "org.netbeans.modules.refactoring.java.api.ui.ChangeParametersAction", category = "Refactoring")
@ActionRegistration(displayName = "#LBL_ChangeMethodSignatureAction", lazy = false)
@ActionReferences({
    @ActionReference(path = "Editors/text/x-java/RefactoringActions", name = "CallHierarchyAction", position = 430),
    @ActionReference(path = "Shortcuts", name = "CS-Y C")
})
public class ChangeParametersAction extends JavaRefactoringGlobalAction {
    
    /** Creates a new instance of ChangeParametersAction
     */
    public ChangeParametersAction() {
        super(NbBundle.getMessage(ChangeParametersAction.class, "LBL_ChangeMethodSignatureAction"), null); // NOI18N
        putValue("noIconInMenu", Boolean.TRUE); // NOI18N
    }
    
    @Override
    public final void performAction(Lookup context) {
        JavaActionsImplementationFactory.doChangeParameters(context);
    }
    
    @Override
    public org.openide.util.HelpCtx getHelpCtx() {
        return HelpCtx.DEFAULT_HELP;
    }

    @Override
    protected boolean asynchronous() {
        return false;
    }

    @Override
    protected boolean enable(Lookup context) {
        return JavaActionsImplementationFactory.canChangeParameters(context);
    }
}
