/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package castracker;

import javax.swing.*;
import javax.swing.text.AttributeSet;
import javax.swing.text.BadLocationException;
import javax.swing.text.DocumentFilter;
import javax.swing.text.PlainDocument;

public class DocListenerEg extends JPanel {
   public static JTextField fields = new JTextField(12);

   public DocListenerEg() {
      MyDocFilter myFilter = new MyDocFilter();
      
         ((PlainDocument) fields.getDocument()).setDocumentFilter(myFilter);
         add(fields);
      
   }

   private class MyDocFilter extends DocumentFilter {
      @Override
      public void insertString(DocumentFilter.FilterBypass fb, int offset,
            String text, AttributeSet attr) throws BadLocationException {
         for (char c : text.toCharArray()) {
            if (!Character.isDigit(c)) {
               return;
            }
         }
         fb.insertString(offset, text.toUpperCase(), attr);
      }

      @Override
      public void replace(DocumentFilter.FilterBypass fb, int offset,
            int length, String text, AttributeSet attrs)
            throws BadLocationException {
         for (char c : text.toCharArray()) {
            if (!Character.isDigit(c)) {
               return;
            }
         }
         fb.replace(offset, length, text.toUpperCase(), attrs);
      }
   }
}