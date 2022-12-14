/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hr.algebra.view.userview;

import hr.algebra.dal.Repository;
import hr.algebra.dal.RepositoryFactory;
import hr.algebra.model.Article;
import hr.algebra.model.Journalists;
import hr.algebra.model.Newspaper;
import hr.algebra.utils.FileUtils;
import hr.algebra.utils.IconUtils;
import hr.algebra.utils.MessageUtils;
import hr.algebra.view.model.NewspaperTableModel;
import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.UUID;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.ListSelectionModel;
import javax.swing.text.JTextComponent;

/**
 *
 * @author Korisnik
 */
public class EditNewspaperPanel extends javax.swing.JPanel {

      private List<JTextComponent> validationFields;
    private List<JLabel> errorLabels;

    private static final String DIR = "assets";

    private Repository repository;
    private NewspaperTableModel newspaperTableModel;

    private Newspaper selectedNewspaper;
    
    /**
     * Creates new form EditNewspaperPanel
     */
    public EditNewspaperPanel() {
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

        lbLastNameError = new javax.swing.JLabel();
        btnChoosePicture = new javax.swing.JButton();
        lbIcon = new javax.swing.JLabel();
        lbArticleError = new javax.swing.JLabel();
        btnAdd = new javax.swing.JButton();
        lbJournalistError = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        btnUpdate = new javax.swing.JButton();
        lbIconError = new javax.swing.JLabel();
        btnDelete = new javax.swing.JButton();
        tfPicturePath = new javax.swing.JTextField();
        lbTitleError = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tbNewspaper = new javax.swing.JTable();
        jLabel3 = new javax.swing.JLabel();
        lbEmail = new javax.swing.JLabel();
        cbJournalist = new javax.swing.JComboBox<>();
        tfTitle = new javax.swing.JTextField();
        cbArticle = new javax.swing.JComboBox<>();

        addComponentListener(new java.awt.event.ComponentAdapter() {
            public void componentShown(java.awt.event.ComponentEvent evt) {
                formComponentShown(evt);
            }
        });

        lbLastNameError.setForeground(java.awt.Color.red);

        btnChoosePicture.setText("Choose image");
        btnChoosePicture.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnChoosePictureActionPerformed(evt);
            }
        });

        lbIcon.setIcon(new javax.swing.ImageIcon(getClass().getResource("/assets/no_image.png"))); // NOI18N
        lbIcon.setPreferredSize(new java.awt.Dimension(480, 300));

        lbArticleError.setForeground(java.awt.Color.red);
        lbArticleError.setToolTipText("");

        btnAdd.setText("Add");
        btnAdd.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAddActionPerformed(evt);
            }
        });

        lbJournalistError.setForeground(java.awt.Color.red);

        jLabel2.setText("Title");

        btnUpdate.setText("Update");
        btnUpdate.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnUpdateActionPerformed(evt);
            }
        });

        lbIconError.setForeground(java.awt.Color.red);

        btnDelete.setBackground(java.awt.Color.red);
        btnDelete.setForeground(new java.awt.Color(255, 255, 255));
        btnDelete.setText("Delete");
        btnDelete.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDeleteActionPerformed(evt);
            }
        });

        tfPicturePath.setEditable(false);
        tfPicturePath.setBackground(new java.awt.Color(204, 204, 204));
        tfPicturePath.setName(""); // NOI18N

        lbTitleError.setForeground(java.awt.Color.red);

        tbNewspaper.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4", "Title 5", "Title 6"
            }
        ));
        tbNewspaper.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tbNewspaperMouseClicked(evt);
            }
        });
        tbNewspaper.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                tbNewspaperKeyReleased(evt);
            }
        });
        jScrollPane1.setViewportView(tbNewspaper);

        jLabel3.setText("Journalist");

        lbEmail.setText("Article");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane1)
            .addGroup(layout.createSequentialGroup()
                .addGap(33, 33, 33)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel2)
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(btnAdd, javax.swing.GroupLayout.PREFERRED_SIZE, 275, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addComponent(btnUpdate, javax.swing.GroupLayout.DEFAULT_SIZE, 165, Short.MAX_VALUE))
                                    .addComponent(btnDelete, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addGroup(layout.createSequentialGroup()
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(jLabel3)
                                            .addGroup(layout.createSequentialGroup()
                                                .addComponent(tfTitle, javax.swing.GroupLayout.PREFERRED_SIZE, 344, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addGap(18, 18, 18)
                                                .addComponent(lbLastNameError, javax.swing.GroupLayout.PREFERRED_SIZE, 16, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                .addComponent(lbTitleError, javax.swing.GroupLayout.PREFERRED_SIZE, 16, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                        .addGap(0, 0, Short.MAX_VALUE)))
                                .addGap(61, 61, 61))
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(lbEmail)
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(cbJournalist, javax.swing.GroupLayout.PREFERRED_SIZE, 367, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addComponent(lbJournalistError, javax.swing.GroupLayout.PREFERRED_SIZE, 16, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(cbArticle, javax.swing.GroupLayout.PREFERRED_SIZE, 367, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addComponent(lbArticleError, javax.swing.GroupLayout.PREFERRED_SIZE, 16, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addComponent(tfPicturePath)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(btnChoosePicture))
                            .addComponent(lbIcon, javax.swing.GroupLayout.PREFERRED_SIZE, 500, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addComponent(lbIconError, javax.swing.GroupLayout.PREFERRED_SIZE, 12, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(39, 39, 39))))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(16, 16, 16)
                .addComponent(jLabel2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lbIcon, javax.swing.GroupLayout.PREFERRED_SIZE, 347, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lbIconError, javax.swing.GroupLayout.PREFERRED_SIZE, 19, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(lbTitleError, javax.swing.GroupLayout.PREFERRED_SIZE, 12, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(tfTitle, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(lbLastNameError, javax.swing.GroupLayout.PREFERRED_SIZE, 12, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(26, 26, 26)
                        .addComponent(jLabel3)
                        .addGap(4, 4, 4)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(cbJournalist, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(lbJournalistError, javax.swing.GroupLayout.PREFERRED_SIZE, 12, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(36, 36, 36)
                        .addComponent(lbEmail)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(cbArticle, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(lbArticleError, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(100, 100, 100)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(btnUpdate, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btnAdd, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnDelete, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnChoosePicture)
                    .addComponent(tfPicturePath, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 319, Short.MAX_VALUE)
                .addContainerGap())
        );
    }// </editor-fold>//GEN-END:initComponents

    private void btnChoosePictureActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnChoosePictureActionPerformed
        File file = FileUtils.uploadFile("Images", "jpg", "jpeg", "png");
        if (file == null) {
            return;
        }
        tfPicturePath.setText(file.getAbsolutePath());
        setIcon(lbIcon, file);
    }//GEN-LAST:event_btnChoosePictureActionPerformed

    private void btnAddActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAddActionPerformed

        if (formValid()) {
            try {
                
                String localPicturePath = uploadPicture();
                Newspaper newspaper = new Newspaper(
                    tfTitle.getText().trim(),
                    (int)cbJournalist.getSelectedItem(),
                    (int)cbArticle.getSelectedItem(),
                    localPicturePath

                );
                repository.createNewspaper(newspaper);
                newspaperTableModel.setNewspapers(repository.selectNewspapers());

                clearForm();
            } catch (Exception ex) {
                Logger.getLogger(EditNewspaperPanel.class.getName()).log(Level.SEVERE, null, ex);
                MessageUtils.showErrorMessage("Error", "Unable to create newspaper!");
            }
        }
    }//GEN-LAST:event_btnAddActionPerformed
 private String uploadPicture() throws IOException {
        String picturePath = tfPicturePath.getText().trim();
        String ext = picturePath.substring(picturePath.lastIndexOf("."));
        String pictureName = UUID.randomUUID() + ext;
        String localPicturePath = DIR + File.separator + pictureName;
        FileUtils.copy(picturePath, localPicturePath);
        return localPicturePath;
    }
    private void btnUpdateActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnUpdateActionPerformed
        if (selectedNewspaper == null) {
            MessageUtils.showInformationMessage("Wrong operation", "Please choose newspaper to update");
            return;
        }
        if (formValid()) {
            try {
                if (!tfPicturePath.getText().trim().equals(selectedNewspaper.getPicturePath())) {
                    if (selectedNewspaper.getPicturePath() != null) {
                        Files.deleteIfExists(Paths.get(selectedNewspaper.getPicturePath()));
                    }
                    String localPicturePath = uploadPicture();
                    selectedNewspaper.setPicturePath(localPicturePath);
                }
                
                selectedNewspaper.setTitle(tfTitle.getText().trim());
                selectedNewspaper.setJournalistID((int)cbJournalist.getSelectedItem());
                selectedNewspaper.setArticleID((int)cbArticle.getSelectedItem());

                repository.updateNewspaper(selectedNewspaper.getId(), selectedNewspaper);
                newspaperTableModel.setNewspapers(repository.selectNewspapers());

                clearForm();
            } catch (Exception ex) {
                Logger.getLogger(EditNewspaperPanel.class.getName()).log(Level.SEVERE, null, ex);
                MessageUtils.showErrorMessage("Error", "Unable to update newspaper!");
            }
        }
    }//GEN-LAST:event_btnUpdateActionPerformed

    private void btnDeleteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDeleteActionPerformed

        if (selectedNewspaper == null) {
            MessageUtils.showInformationMessage("Wrong operation", "Please choose journalist to delete");
            return;
        }
        if (MessageUtils.showConfirmDialog(
            "Delete journalist",
            "Do you really want to delete newspaper?") == JOptionPane.YES_OPTION) {
        try {
            if (selectedNewspaper.getPicturePath() != null) {
                Files.deleteIfExists(Paths.get(selectedNewspaper.getPicturePath()));
            }
            repository.deleteNewspaper(selectedNewspaper.getId());
            newspaperTableModel.setNewspapers(repository.selectNewspapers());

            clearForm();
        } catch (Exception ex) {
            Logger.getLogger(EditNewspaperPanel.class.getName()).log(Level.SEVERE, null, ex);
            MessageUtils.showErrorMessage("Error", "Unable to delete newspaper!");
        }
        }
    }//GEN-LAST:event_btnDeleteActionPerformed

    private void tbNewspaperMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tbNewspaperMouseClicked
        showNewspaper();
    }//GEN-LAST:event_tbNewspaperMouseClicked

    private void tbNewspaperKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_tbNewspaperKeyReleased
        showNewspaper();
    }//GEN-LAST:event_tbNewspaperKeyReleased

    private void formComponentShown(java.awt.event.ComponentEvent evt) {//GEN-FIRST:event_formComponentShown
       init();
    }//GEN-LAST:event_formComponentShown
 public void showNewspaper() {
        clearForm();
        int selectedRow = tbNewspaper.getSelectedRow();
        int rowIndex = tbNewspaper.convertRowIndexToModel(selectedRow);
        int selectNewspaperId = (int) newspaperTableModel.getValueAt(rowIndex, 0);

        try {
            Optional<Newspaper> optNewspaper = repository.selectNewspaper(selectNewspaperId);
            if (optNewspaper.isPresent()) {
                selectedNewspaper = optNewspaper.get();
                fillForm(selectedNewspaper);
            }
        } catch (Exception ex) {
            Logger.getLogger(EditNewspaperPanel.class.getName()).log(Level.SEVERE, null, ex);
            MessageUtils.showErrorMessage("Error", "Unable to show newspaper!");
        }
    }
    
    
      private void init() {
        try {
            
            initValidation();
            initRepository();
            initTable();
            
            
            List<Journalists> journalistList = repository.selectJournalists();
            List<Article> articleList = repository.selectArticles();
            for (Journalists journalist : journalistList)
            {
                cbJournalist.addItem(journalist.getId());
            }
            for (Article article : articleList)
            {
                cbArticle.addItem(article.getId());
            }
            
        } catch (Exception ex) {
            Logger.getLogger(EditNewspaperPanel.class.getName()).log(Level.SEVERE, null, ex);
            MessageUtils.showErrorMessage("Unrecoverable error", "Cannot initiate the form");
            System.exit(1);
        }
    }

    private void initValidation() {
        validationFields = Arrays.asList(tfTitle,tfPicturePath);
        errorLabels = Arrays.asList(lbTitleError, lbLastNameError, lbJournalistError, lbArticleError, lbIconError);
    }

    private void initRepository() throws Exception {
        repository = RepositoryFactory.getRepository();
    }

    private void initTable() throws Exception {
        tbNewspaper.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        tbNewspaper.setAutoCreateRowSorter(true);
        tbNewspaper.setRowHeight(25);
        newspaperTableModel = new NewspaperTableModel(repository.selectNewspapers());
        tbNewspaper.setModel(newspaperTableModel);
    }

    private void fillForm(Newspaper newspaper) throws Exception {
        tfTitle.setText(newspaper.getTitle());
        cbArticle.getSelectedItem();
        cbJournalist.getSelectedItem();
        if (newspaper.getPicturePath() != null && Files.exists(Paths.get(newspaper.getPicturePath()))) {
            tfPicturePath.setText(newspaper.getPicturePath());
            setIcon(lbIcon, new File(newspaper.getPicturePath()));
        }
       
        
    }

    private void setIcon(JLabel label, File file) {
        try {
            label.setIcon(IconUtils.createIcon(file, label.getWidth(), label.getHeight()));
        } catch (IOException ex) {
            Logger.getLogger(EditNewspaperPanel.class.getName()).log(Level.SEVERE, null, ex);
            MessageUtils.showErrorMessage("Error", "Unable to set icon!");
        }
    }

    private void clearForm() {
        validationFields.forEach(e -> e.setText(""));
        errorLabels.forEach(e -> e.setText(""));

        lbIcon.setIcon(new ImageIcon(getClass().getResource("/assets/no_image.png")));

        selectedNewspaper = null;
    }

    private boolean formValid() {
        boolean ok = true;

        for (int i = 0; i < validationFields.size(); i++) {
            ok &= !validationFields.get(i).getText().trim().isEmpty();
            errorLabels.get(i).setText(validationFields.get(i).getText().trim().isEmpty() ? "X" : "");
        }

        return ok;
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAdd;
    private javax.swing.JButton btnChoosePicture;
    private javax.swing.JButton btnDelete;
    private javax.swing.JButton btnUpdate;
    private javax.swing.JComboBox<Integer> cbArticle;
    private javax.swing.JComboBox<Integer> cbJournalist;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel lbArticleError;
    private javax.swing.JLabel lbEmail;
    private javax.swing.JLabel lbIcon;
    private javax.swing.JLabel lbIconError;
    private javax.swing.JLabel lbJournalistError;
    private javax.swing.JLabel lbLastNameError;
    private javax.swing.JLabel lbTitleError;
    private javax.swing.JTable tbNewspaper;
    private javax.swing.JTextField tfPicturePath;
    private javax.swing.JTextField tfTitle;
    // End of variables declaration//GEN-END:variables
}
