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
package net.refractions.udig.legend.internal;

import org.eclipse.osgi.util.NLS;

public class Messages extends NLS {
	private static final String BUNDLE_NAME = "net.refractions.udig.legend.internal.messages"; //$NON-NLS-1$

	public static String LegendGraphicStyleConfigurator_background_colour;

	public static String LegendGraphicStyleConfigurator_font_colour;

	public static String LegendGraphicStyleConfigurator_horizontal_margin;

	public static String LegendGraphicStyleConfigurator_horizontal_spacing;

	public static String LegendGraphicStyleConfigurator_indent_size;

	public static String LegendGraphicStyleConfigurator_vertical_margin;

	public static String LegendGraphicStyleConfigurator_vertical_spacing;
	static {
		// initialize resource bundle
		NLS.initializeMessages(BUNDLE_NAME, Messages.class);
	}

	private Messages() {
	}
}
