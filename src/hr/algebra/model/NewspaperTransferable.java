/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hr.algebra.model;

import java.awt.datatransfer.DataFlavor;
import java.awt.datatransfer.Transferable;
import java.awt.datatransfer.UnsupportedFlavorException;
import java.io.IOException;

/**
 *
 * @author Korisnik
 */
public class NewspaperTransferable implements Transferable{

    public static final DataFlavor NEWSPAPER_FLAVOR = new DataFlavor(Newspaper.class, "Newspaper");
    private static final DataFlavor[] SUPPORTED_FLAVORS = {NEWSPAPER_FLAVOR};
    
    private final Newspaper newspaper;

    public NewspaperTransferable(Newspaper newspaper) {
        this.newspaper = newspaper;
    }
    
    
    
    @Override
    public DataFlavor[] getTransferDataFlavors() {
       return SUPPORTED_FLAVORS;
    }

    @Override
    public boolean isDataFlavorSupported(DataFlavor flavor) {
        return NEWSPAPER_FLAVOR.equals(flavor);
    }

    @Override
    public Object getTransferData(DataFlavor flavor) throws UnsupportedFlavorException, IOException {
        if(isDataFlavorSupported(flavor)){
            return newspaper;
        }
        throw new UnsupportedFlavorException(flavor);
        
    }
    
}
