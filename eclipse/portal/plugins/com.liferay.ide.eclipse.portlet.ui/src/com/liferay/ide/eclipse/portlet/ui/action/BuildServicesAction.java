package com.liferay.ide.eclipse.portlet.ui.action;

import com.liferay.ide.eclipse.portlet.core.PortletCore;
import com.liferay.ide.eclipse.portlet.core.job.BuildServiceJob;

import org.eclipse.core.resources.IFile;
import org.eclipse.jface.action.IAction;
import org.eclipse.jface.viewers.ISelection;
import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.swt.widgets.Display;
import org.eclipse.ui.IObjectActionDelegate;
import org.eclipse.ui.IWorkbenchPart;


public class BuildServicesAction implements IObjectActionDelegate {

	private ISelection fSelection;

	public BuildServicesAction() {
	}

	public Display getDisplay() {
		Display display = Display.getCurrent();

		if (display == null)
			display = Display.getDefault();

		return display;
	}

	public void run(IAction action) {
		if (fSelection instanceof IStructuredSelection) {
			Object[] elems = ((IStructuredSelection) fSelection).toArray();

			IFile servicesFile = null;

			Object elem = elems[0];

			if (elem instanceof IFile) {
				servicesFile = (IFile) elem;

				BuildServiceJob job = PortletCore.createServiceBuilderJob(servicesFile);

				job.schedule();
			}
		}

	}

	public void selectionChanged(IAction action, ISelection selection) {
		fSelection = selection;
	}

	public void setActivePart(IAction action, IWorkbenchPart targetPart) {
	}
}
