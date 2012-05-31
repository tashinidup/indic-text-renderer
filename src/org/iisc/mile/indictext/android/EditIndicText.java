package org.iisc.mile.indictext.android;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Rect;
import android.util.AttributeSet;
import android.widget.EditText;

public class EditIndicText extends EditText {
	private Rect mRect;
	private Paint mPaint;

	public EditIndicText(Context context) {
		this(context, null);
	}

	public EditIndicText(Context context, AttributeSet attrs) {
		super(context, attrs);
		mRect = new Rect();
		mPaint = new Paint();
		mPaint.setStyle(Paint.Style.STROKE);
		mPaint.setColor(0x800000FF);
	}

	private static final String LOG_TAG = EditIndicText.class.getName();

	Canvas savedCanvas;

	Boolean lock = new Boolean(true);

	public native void drawIndicText(String unicodeText, int xStart, int yBaseLine, int charHeight,
			Boolean lock);

	static {
		System.loadLibrary("complex-script-rendering");
	}

	public void drawGlyph(int glyphBitmap[][], int x, int y) {
		if (glyphBitmap == null) {
			return;
		}
		int height = glyphBitmap.length;
		if (height == 0) {
			return;
		}
		int width = glyphBitmap[0].length;
		Bitmap tempBitmap = Bitmap.createBitmap(width, height, Bitmap.Config.ARGB_8888);
		for (int i = 0; i < height; i++) {
			for (int j = 0; j < width; j++) {
				if (glyphBitmap[i][j] == 0) {
					tempBitmap.setPixel(j, i, Color.TRANSPARENT);
				} else {
					int graylevel = 255 - glyphBitmap[i][j];
					tempBitmap.setPixel(j, i, Color.rgb(graylevel, graylevel, graylevel));
				}
			}
		}
		savedCanvas.drawBitmap(tempBitmap, x, y, null);
	}

	@Override
	protected void onDraw(Canvas canvas) {
		int count = getLineCount();
		String[] textLines = getText().toString().split("\\n");
		Rect r = mRect;
		// Paint paint = mPaint;
		for (int i = 0; i < count; i++) {
			int baseline = getLineBounds(i, r);
			// canvas.drawLine(r.left, baseline + 1, r.right, baseline + 1, paint);
			// canvas.drawRect(r.left, r.top, r.left + 15, r.bottom, paint);
			savedCanvas = canvas;
			String currentText = i < textLines.length ? textLines[i] : "";
			drawIndicText(currentText, r.left, baseline, 14, lock);
		}
	}
}
