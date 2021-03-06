/*******************************************************************************
 * Copyright (c) 2013 Peter Brewer
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the GNU Public License v3.0
 * which accompanies this distribution, and is available at
 * http://www.gnu.org/licenses/gpl.html
 * 
 * Contributors:
 *     Peter Brewer
 *     Elena Velasquez
 ******************************************************************************/
package org.fhaes.filefilter;

import java.io.File;

import org.apache.commons.io.FilenameUtils;

public class SHPFileFilter extends FHAESFileFilter {

	@Override
	public boolean accept(File f) {
		if (FilenameUtils.getExtension(f.getAbsolutePath()).toLowerCase()
				.equals("shp")
				|| f.isDirectory()) {
			return true;
		}

		return false;
	}

	@Override
	public String getDescription() {
		return "GIS Shapefile (.shp)";
	}

	@Override
	public String getPreferredFileExtension() {
		return "shp";
	}

}
