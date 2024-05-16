package com.example;

import javax.swing.text.AttributeSet;
import javax.swing.text.BadLocationException;
import javax.swing.text.PlainDocument;

class IntegerDocument extends PlainDocument {
    @Override
    public void insertString(int offs, String str, AttributeSet a) throws BadLocationException {
        if (str == null) {
            return;
        }
        try {
            Integer.parseInt(str);
            super.insertString(offs, str, a);
        } catch (NumberFormatException e) {
            e.printStackTrace();
        }
    }
}

class TextDocument extends PlainDocument {
    @Override
    public void insertString(int offs, String str, AttributeSet a) throws BadLocationException {
        if (str == null) {
            return;
        }
        super.insertString(offs, str.replaceAll("\\d", ""), a);
    }
}

class DoubleDocument extends PlainDocument {
    @Override
    public void insertString(int offs, String str, AttributeSet a) throws BadLocationException {
        if (str == null) {
            return;
        }
        try {
            Double.parseDouble(str);
            super.insertString(offs, str, a);
        } catch (NumberFormatException e) {
            e.printStackTrace();
        }
    }
}
