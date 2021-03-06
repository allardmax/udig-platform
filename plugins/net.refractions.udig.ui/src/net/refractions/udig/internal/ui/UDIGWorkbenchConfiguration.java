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
package net.refractions.udig.internal.ui;

import net.refractions.udig.ui.WorkbenchConfiguration;

import org.eclipse.swt.graphics.Point;
import org.eclipse.swt.graphics.Rectangle;
import org.eclipse.swt.widgets.Display;
import org.eclipse.ui.application.IWorkbenchWindowConfigurer;

public class UDIGWorkbenchConfiguration implements WorkbenchConfiguration {

	/**
     * Called to initialise the initial workbench windows size (1023,756)
     * and define what kind of things are visible by default.
     * <ul>
     * This implementation is only a default; you can use the
     * "workbenchConfiguration" extension point when you are implementing your
     * own udig based application in order to provide a custom implementation.
     * </p>
     * Specifcally people override this class in order to:
     * <ul>
     * <li>turn on perspectives:
     * <pre><code>configurer.setShowPerspectiveBar(true)</code></pre></li>
     * <li>Change the default size to be based on the screen size</li>
     * <pre><code></code></pre>
     * </ul>
     * 
     * @param configurer IWorkbenchWindowConfigurer used for configuring the workbench window
     */
    public void configureWorkbench( IWorkbenchWindowConfigurer configurer ) {
        configurer.setShowProgressIndicator(true);
        configurer.setInitialSize(new Point(1024, 768));
        
        //Rectangle bounds = Display.getDefault().getPrimaryMonitor().getClientArea();
        //configurer.setInitialSize(new Point(bounds.width, bounds.height));
        
        configurer.setShowCoolBar(true);
        configurer.setShowFastViewBars(true);
        //configurer.setShowPerspectiveBar(true);
        
        // these are required for the update site if nothing else
        configurer.setShowStatusLine(true);
        configurer.setShowProgressIndicator(true);
    }

}
