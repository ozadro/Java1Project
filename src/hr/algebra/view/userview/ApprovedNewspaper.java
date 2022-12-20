/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hr.algebra.view.userview;

import hr.algebra.dal.Repository;
import hr.algebra.dal.RepositoryFactory;
import hr.algebra.model.Newspaper;
import hr.algebra.model.NewspaperArchive;
import hr.algebra.model.NewspaperTransferable;
import hr.algebra.utils.JAXBUtils;
import hr.algebra.utils.MessageUtils;
import java.awt.datatransfer.Transferable;
import java.awt.datatransfer.UnsupportedFlavorException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.DefaultListModel;
import javax.swing.DropMode;
import javax.swing.JComponent;
import javax.swing.ListSelectionModel;
import javax.swing.TransferHandler;
import static javax.swing.TransferHandler.COPY;
import javax.xml.bind.JAXBException;

/**
 * 
 *
 * @author Korisnik
 */
public class ApprovedNewspaper extends javax.swing.JPanel {
         private static final String FILENAME = "newspaperarchive.xml";
        private Repository repository;
        private final DefaultListModel<Newspaper> newspaperModel = new DefaultListModel<>();
        private final DefaultListModel<Newspaper> approvedModel = new DefaultListModel<>();
        private List<Newspaper> newspaper;
        
        
    /**
     * Creates new form ApprovedNewspaper
     * @throws java.lang.Exception
     */
    public ApprovedNewspaper() throws Exception {
        initComponents();
        
        
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        lsNewspaper = new javax.swing.JList<>();
        jScrollPane2 = new javax.swing.JScrollPane();
        lsApprovedNewspaper = new javax.swing.JList<>();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        btnArchive = new javax.swing.JButton();

        addComponentListener(new java.awt.event.ComponentAdapter() {
            public void componentShown(java.awt.event.ComponentEvent evt) {
                formComponentShown(evt);
            }
        });

        jScrollPane1.setViewportView(lsNewspaper);

        jScrollPane2.setViewportView(lsApprovedNewspaper);

        jLabel1.setText("NewsPaper");

        jLabel2.setText("Approved Newspaper: ");

        btnArchive.setText("Archive Newspaper");
        btnArchive.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnArchiveMouseClicked(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(105, 105, 105)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 209, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel1))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jLabel2)
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                    .addComponent(btnArchive, javax.swing.GroupLayout.DEFAULT_SIZE, 229, Short.MAX_VALUE))
                .addContainerGap(168, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(48, 48, 48)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(jLabel2))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 333, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 333, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnArchive, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(55, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void formComponentShown(java.awt.event.ComponentEvent evt) {//GEN-FIRST:event_formComponentShown
            try
            {   
                init();
            } catch (Exception ex)
            {
                Logger.getLogger(ApprovedNewspaper.class.getName()).log(Level.SEVERE, null, ex);
            }
    }//GEN-LAST:event_formComponentShown

    private void btnArchiveMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnArchiveMouseClicked
      
        List<Newspaper> helperPaper = new ArrayList<Newspaper>();
        Newspaper helperNews;
        for (int i = 0; i < lsApprovedNewspaper.getModel().getSize(); i++)
        {
            helperNews = lsApprovedNewspaper.getModel().getElementAt(i);
            helperPaper.add(helperNews);
            
        }
             try
             {
                 JAXBUtils.save(new NewspaperArchive(helperPaper),FILENAME);
                 MessageUtils.showInformationMessage("Info", "Newspaper saved");
             } catch (JAXBException ex)
             {
                  MessageUtils.showErrorMessage("Error", "Unable to save newspaper, you're fired");
                 Logger.getLogger(ApprovedNewspaper.class.getName()).log(Level.SEVERE, null, ex);
             }
       
       
    }//GEN-LAST:event_btnArchiveMouseClicked


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnArchive;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JList<Newspaper> lsApprovedNewspaper;
    private javax.swing.JList<Newspaper> lsNewspaper;
    // End of variables declaration//GEN-END:variables

     private void init() throws Exception {
         initRepository();
         fillNewspaperList();
         initDragNDrop();
    }
     
      private void initRepository() throws Exception {
        repository = RepositoryFactory.getRepository();
    }
    
    private void fillNewspaperList() throws Exception {
      newspaperModel.clear();
      approvedModel.clear();
      newspaper = repository.selectNewspapers();
      newspaper.forEach(newspaperModel::addElement);
      lsNewspaper.setModel(newspaperModel);

       
    }
    
    
     private void initDragNDrop() {
        lsNewspaper.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        lsNewspaper.setDragEnabled(true);
        lsNewspaper.setTransferHandler(new ExportTransferHandler());

        lsApprovedNewspaper.setDropMode(DropMode.ON);
        lsApprovedNewspaper.setTransferHandler(new ImportTransferHandler());
    }

    private class ExportTransferHandler extends TransferHandler {

        @Override
        public int getSourceActions(JComponent c) {
            // defines icon shown in target before drop
            return COPY;
            //return MOVE;
        }

        @Override
        public Transferable createTransferable(JComponent c) {
            return new NewspaperTransferable(lsNewspaper.getSelectedValue());
        }
    }

    private class ImportTransferHandler extends TransferHandler {

        // we define whether we can import stringFlavor that we need for JList<String>
        @Override
        public boolean canImport(TransferHandler.TransferSupport support) {
            return support.isDataFlavorSupported(NewspaperTransferable.NEWSPAPER_FLAVOR);
        }

        // we import the data
        @Override
        public boolean importData(TransferHandler.TransferSupport support) {
            Transferable transferable = support.getTransferable();
            try {
                Newspaper data = (Newspaper) transferable.getTransferData(NewspaperTransferable.NEWSPAPER_FLAVOR);

                if (!approvedModel.contains(data)) {
                    approvedModel.addElement(data);
                    lsApprovedNewspaper.setModel(approvedModel);
                    // we remove the item from the source, in case of MOVE
                    //((DefaultListModel<String>)lsSource.getModel()).remove(lsSource.getSelectedIndex());
                    return true;
                }

            } catch (UnsupportedFlavorException | IOException ex) {
                Logger.getLogger(ApprovedNewspaper.class.getName()).log(Level.SEVERE, null, ex);
            }
            return false;
        }
    }

   
}