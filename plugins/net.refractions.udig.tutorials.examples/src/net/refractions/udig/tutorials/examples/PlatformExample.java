/*
 *    uDig - User Friendly Desktop Internet GIS client
 *    http://udig.refractions.net
 *    (C) 2012, Refractions Research Inc.
 *
 *    This library is free software; you can redistribute it and/or
 *    modify it under the terms of the GNU Lesser General Public
 *    License as published by the Free Software Foundation;
 *    version 2.1 of the License.
 *
 *    This library is distributed in the hope that it will be useful,
 *    but WITHOUT ANY WARRANTY; without even the implied warranty of
 *    MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the GNU
 *    Lesser General Public License for more details.
 */
package net.refractions.udig.tutorials.examples;

import net.refractions.udig.core.internal.ExtensionPointProcessor;
import net.refractions.udig.core.internal.ExtensionPointUtil;
import net.refractions.udig.project.ui.tool.ModalTool;

import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IConfigurationElement;
import org.eclipse.core.runtime.IExtension;
import org.eclipse.core.runtime.IExtensionPoint;
import org.eclipse.core.runtime.IExtensionRegistry;
import org.eclipse.core.runtime.ILog;
import org.eclipse.core.runtime.IStatus;
import org.eclipse.core.runtime.Platform;
import org.eclipse.core.runtime.Status;

/**
 * The eclipse Platform is where all the magic happens.
 * <p>
 * 
 * @author jive
 * @since 1.2.0
 */
public class PlatformExample {
    void processingExtensionPointByHand() {
        String xpid = "net.refractions.udig.project.ui.tool";
        IExtensionRegistry registry = Platform.getExtensionRegistry();
        IExtensionPoint extensionPoint = registry.getExtensionPoint(xpid);
        if (extensionPoint == null) {
            throw new NullPointerException("Could not find extensionPoint:" + xpid);
        }
        for( IExtension extension : extensionPoint.getExtensions() ) {
            for( IConfigurationElement element : extension.getConfigurationElements() ) {
                String name = element.getName();
                System.out.println(name);
                if ("modalTool".equals(name)) {
                    try {
                        ModalTool tool = (ModalTool) element.createExecutableExtension("class");
                        System.out.println(tool);
                    } catch (CoreException e) {
                        // Perhaps an error in the constructor?
                        String message = "Could not create Modal tool "
                                + element.getAttribute("class");
                        Status status = new Status(IStatus.ERROR, extension.getContributor()
                                .getName(), message, e);
                        Activator.getDefault().getLog().log(status);
                    }
                }
            }
        }
    }
    @SuppressWarnings("deprecation")
    void processingExtensionPointUsingUtilityClassOld() {
        String xpid = "net.refractions.udig.project.ui.tool";
        ExtensionPointUtil.process(xpid, new ExtensionPointProcessor(){
            public void process( IExtension extension, IConfigurationElement element )
                    throws Exception {
                String name = element.getName();
                System.out.println(name);
                if ("modalTool".equals(name)) {
                    ModalTool tool = (ModalTool) element.createExecutableExtension("class");
                    System.out.println(tool);
                }
            }
        });
    }
    void processingExtensionPointUsingUtilityClass() {
        String xpid = "net.refractions.udig.project.ui.tool";
        ExtensionPointUtil.process(Activator.getDefault(), xpid, new ExtensionPointProcessor(){
            public void process( IExtension extension, IConfigurationElement element )
                    throws Exception {
                String name = element.getName();
                System.out.println(name);
                if ("modalTool".equals(name)) {
                    ModalTool tool = (ModalTool) element.createExecutableExtension("class");
                    System.out.println(tool);
                }
            }
        });
    }
}