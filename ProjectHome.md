Using FreeType (font rasterization engine) and Harfbuzz-ng (complex script layout engine), this Android widget allows Indic text (Devanagari / Hindi, Kannada, Tamil, Telugu etc) to be rendered on Android phones without having to root the phone.

The complex script layout engine (Harfbuzz-ng) maps Unicode code points to glyph ids, and the font rasterization engine (FreeType) does glyph (vector graphics) to image (bitmap) rendering.

All Android phones ship with FreeType library, but only a few (like Samsung Galaxy 5) ship with Harfbuzz library along with required Indic fonts. By rooting the phone one can install additional fonts and libraries. However, rooting could imply loosing the phone's warranty.

Android widget created as part of this project implements the text rendering stack at an application level, and hence any application that uses this widget would be able to render Indic text without having to root the phone.

For more understanding of the way text rendering works and the libraries involved in it, please study http://behdad.org/text/ (State of Text Rendering) and http://userguide.icu-project.org/layoutengine (the working of ICU Layout Engine).