/*******************************************************************************
 * Copyright (C) 2013 NOAA/NCDC - Wendy Gross.
 * 
 * This program is free software: you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 * 
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 * 
 * You should have received a copy of the GNU General Public License
 * along with this program.  If not, see <http://www.gnu.org/licenses/>.
 * 
 * Contributors:
 *     Wendy Gross
 *     Peter Brewer
 ******************************************************************************/

package org.fhaes.filefilter;

import java.io.File;

public class PDFFilter extends FHAESFileFilter {
	/**
	 * This is the one of the methods that is declared in the abstract class
	 */
	public boolean accept(File f) {
		// if it is a directory -- we want to show it so return true.
		if (f.isDirectory())
			return true;

		// get the extension of the file
		String extension = getExtension(f);
		// check to see if the extension is equal to "html" or "htm"
		if ((extension.equals("pdf")) || (extension.equals("PDF")))
			return true;
		// default -- fall through. False is return on all
		// occasions except:
		// a) the file is a directory
		// b) the file's extension is what we are looking for.
		return false;
	}

	/**
	 * Again, this is declared in the abstract class The description of this filter
	 */
	public String getDescription() {
		return "Portable Document Format (*.pdf)";
	}

	@Override
	public String getPreferredFileExtension() {
		return "pdf";
	}

}
