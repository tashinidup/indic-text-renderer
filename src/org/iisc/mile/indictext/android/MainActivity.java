/**
 * Copyright © 2012 Shiva Kumar H R
 * 
 * Permission is hereby granted, free of charge, to any person obtaining a 
 * copy of this software and associated documentation files (the "Software"), 
 * to deal in the Software without restriction, including without limitation 
 * the rights to use, copy, modify, merge, publish, distribute, sublicense, 
 * and/or sell copies of the Software, and to permit persons to whom the 
 * Software is furnished to do so, subject to the following conditions:
 * 
 * The above copyright notice and this permission notice shall be included 
 * in all copies or substantial portions of the Software.
 * 
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS 
 * OR IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY, 
 * FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL 
 * THE AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER 
 * LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM, 
 * OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE SOFTWARE.
 */

package org.iisc.mile.indictext.android;

import android.app.Activity;
import android.graphics.Typeface;
import android.os.Bundle;
import android.widget.EditText;

public class MainActivity extends Activity {
	/** Called when the activity is first created. */
	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.main);

		Typeface fontHindi = Typeface.createFromAsset(getAssets(), "Lohit-Devanagari.ttf");
		final EditText editBoxHindi = (EditText) findViewById(R.id.editBoxHindi);
		editBoxHindi.setTypeface(fontHindi);

		Typeface fontKannada = Typeface.createFromAsset(getAssets(), "Lohit-Kannada.ttf");
		final EditText editBoxKannada = (EditText) findViewById(R.id.editBoxKannada);
		editBoxKannada.setTypeface(fontKannada);

		Typeface fontTamil = Typeface.createFromAsset(getAssets(), "Lohit-Tamil.ttf");
		final EditText editBoxTamil = (EditText) findViewById(R.id.editBoxTamil);
		editBoxTamil.setTypeface(fontTamil);
	}

}