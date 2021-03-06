/*******************************************************************************
 * Copyright (C) 2013 Peter Brewer.
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
 *     Peter Brewer
 ******************************************************************************/

package org.fhaes.preferences;

import javax.swing.JFrame;

import org.fhaes.preferences.FHAESPreferences.PrefKey;
import org.fhaes.util.Builder;

public class App {
	public static FHAESPreferences prefs;
	public static JFrame mainFrame = new JFrame();

	public static void init() {
		mainFrame.setIconImage(Builder.getApplicationIcon());
		prefs = new FHAESPreferences();
		prefs.setBooleanPref(PrefKey.DONT_REQUEST_PARAM_CONFIRMATION, false);
	}

	public static void init(JFrame frame) {
		mainFrame = frame;
		prefs = new FHAESPreferences();
		prefs.setBooleanPref(PrefKey.DONT_REQUEST_PARAM_CONFIRMATION, false);

	}

}
