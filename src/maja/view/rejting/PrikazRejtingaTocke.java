/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package maja.view.rejting;

import java.awt.Dimension;
import java.awt.Image;
import java.awt.Toolkit;
import static java.lang.Short.SIZE;
import java.net.URL;
import java.sql.Date;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.GregorianCalendar;

import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.DefaultComboBoxModel;
import javax.swing.DefaultListModel;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;
import javax.swing.JSpinner;
import maja.controller.ObradaRejting;
import maja.controller.ObradaTockaInteresa;
import maja.model.Rejting;
import maja.model.TockaInteresa;
import maja.view.tockaInteresa.ProzorTockaInteresa;
import net.atlanticbb.tantlinger.shef.HTMLEditorPane;
import no.tornado.databinding.support.jxdatepicker.JXDatePickerBridge;


/**
 *
 * @author Maja
 */
public class PrikazRejtingaTocke extends javax.swing.JFrame {

    private TockaInteresa oznacenaStavka;
    private ObradaTockaInteresa obradaTockaInteresa;
    private ObradaRejting obradaRejting;
    private Rejting rejting;
    private ProzorTockaInteresa prozorTockaInteresa;
    private HTMLEditorPane html;
    private SimpleDateFormat df= new SimpleDateFormat("dd.MM.yyyy");
    private int odabrano;
    private java.util.Date date= new java.util.Date();


   
    public PrikazRejtingaTocke() {
        initComponents();
        this.odabrano=0;  
        rejting= new Rejting();
       obradaRejting= new ObradaRejting();
        oznacenaStavka=new TockaInteresa();
        obradaTockaInteresa=new ObradaTockaInteresa();
        ocistiLabele();
        html=new HTMLEditorPane();
        html.setSize(panel.getSize());
        panel.add(html);
       ucitajPodatke();
        this.prozorTockaInteresa=prozorTockaInteresa;
//        oznacenaStavka=new TockaInteresa();
        
//        DefaultListModel<Rejting> mr = new DefaultListModel<>();
//        this.lista.setModel(mr);
         Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();
        this.setLocation(dim.width/2-this.getSize().width/2, dim.height/2-this.getSize().height/2);
    }

    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        lista = new javax.swing.JList();
        jLabel1 = new javax.swing.JLabel();
        panel = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        ocjena = new javax.swing.JLabel();
        ocjena1 = new javax.swing.JLabel();
        ocjena2 = new javax.swing.JLabel();
        ocjena3 = new javax.swing.JLabel();
        ocjena4 = new javax.swing.JLabel();
        kombo = new javax.swing.JComboBox();
        jLabel5 = new javax.swing.JLabel();
        akcijaRating1 = new javax.swing.JButton();
        akcijaRating2 = new javax.swing.JButton();
        akcijaRating3 = new javax.swing.JButton();
        akcijaRating4 = new javax.swing.JButton();
        akcijaRating5 = new javax.swing.JButton();
        jLabel4 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Rating Details");
        setResizable(false);

        lista.addListSelectionListener(new javax.swing.event.ListSelectionListener() {
            public void valueChanged(javax.swing.event.ListSelectionEvent evt) {
                listaValueChanged(evt);
            }
        });
        jScrollPane1.setViewportView(lista);

        jLabel1.setText("Select date:");

        javax.swing.GroupLayout panelLayout = new javax.swing.GroupLayout(panel);
        panel.setLayout(panelLayout);
        panelLayout.setHorizontalGroup(
            panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 283, Short.MAX_VALUE)
        );
        panelLayout.setVerticalGroup(
            panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 175, Short.MAX_VALUE)
        );

        jLabel2.setText("Comment");

        jLabel3.setText("Rating:");

        kombo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                komboActionPerformed(evt);
            }
        });

        jLabel5.setText("Select point of interest:");

        akcijaRating1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/maja/ikone/star-empty-iconsmall.png"))); // NOI18N
        akcijaRating1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                akcijaRating1ActionPerformed(evt);
            }
        });

        akcijaRating2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/maja/ikone/star-empty-iconsmall.png"))); // NOI18N
        akcijaRating2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                akcijaRating2ActionPerformed(evt);
            }
        });

        akcijaRating3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/maja/ikone/star-empty-iconsmall.png"))); // NOI18N
        akcijaRating3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                akcijaRating3ActionPerformed(evt);
            }
        });

        akcijaRating4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/maja/ikone/star-empty-iconsmall.png"))); // NOI18N
        akcijaRating4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                akcijaRating4ActionPerformed(evt);
            }
        });

        akcijaRating5.setIcon(new javax.swing.ImageIcon(getClass().getResource("/maja/ikone/star-empty-iconsmall.png"))); // NOI18N
        akcijaRating5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                akcijaRating5ActionPerformed(evt);
            }
        });

        jLabel4.setText("Rate here!");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jLabel1)
                    .addComponent(kombo, 0, 158, Short.MAX_VALUE)
                    .addComponent(jLabel5)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE))
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(37, 37, 37)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel4)
                                    .addComponent(jLabel3))
                                .addGap(18, 18, 18)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(ocjena, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(ocjena1, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(ocjena2, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(ocjena3, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(ocjena4, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(akcijaRating1, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(akcijaRating2, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(akcijaRating3, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(akcijaRating4, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(akcijaRating5, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                            .addGroup(layout.createSequentialGroup()
                                .addGap(0, 0, Short.MAX_VALUE)
                                .addComponent(jLabel2)
                                .addGap(258, 258, 258))))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(panel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap())))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(ocjena, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(ocjena1, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(ocjena2, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(ocjena3, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(ocjena4, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                .addComponent(akcijaRating1, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(akcijaRating2, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(akcijaRating3, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(akcijaRating4, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(akcijaRating5, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addGap(10, 10, 10)
                                .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 13, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jLabel2)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(panel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(19, 19, 19)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel5)
                            .addComponent(jLabel3))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 16, Short.MAX_VALUE)
                        .addComponent(kombo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(29, 29, 29)
                        .addComponent(jLabel1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 175, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void listaValueChanged(javax.swing.event.ListSelectionEvent evt) {//GEN-FIRST:event_listaValueChanged
          if (evt.getValueIsAdjusting()) {
            return;
        }
         rejting = (Rejting) lista.getSelectedValue();
         if(rejting==null){
             return;
         }
        this.html.setText(rejting.getKomentar());
        try {
                    ocistiLabele();
            if(rejting.getOcjena()==1){
        Toolkit tk = getToolkit();
        Image image = tk.createImage(new URL("http://icons.iconarchive.com/icons/custom-icon-design/flatastic-2/24/star-full-icon.png"));
        ocistiLabele();
       
        this.ocjena.setIcon(new ImageIcon(image));
        
            }else if(rejting.getOcjena()==2){
        Toolkit tk = getToolkit();
        Image image = tk.createImage(new URL("http://icons.iconarchive.com/icons/custom-icon-design/flatastic-2/24/star-full-icon.png"));
        ocistiLabele();
        
        this.ocjena.setIcon(new ImageIcon(image));
        this.ocjena1.setIcon(new ImageIcon(image)); 
        
            }else if(rejting.getOcjena()==3){
            
        Toolkit tk = getToolkit();
        Image image = tk.createImage(new URL("http://icons.iconarchive.com/icons/custom-icon-design/flatastic-2/24/star-full-icon.png"));
        ocistiLabele();
        
        this.ocjena.setIcon(new ImageIcon(image));
        this.ocjena1.setIcon(new ImageIcon(image));
        this.ocjena2.setIcon(new ImageIcon(image));
      
            }else if(rejting.getOcjena()==4){
        
        Toolkit tk = getToolkit();
        Image image = tk.createImage(new URL("http://icons.iconarchive.com/icons/custom-icon-design/flatastic-2/24/star-full-icon.png"));
        ocistiLabele();
        
        this.ocjena.setIcon(new ImageIcon(image));
        this.ocjena1.setIcon(new ImageIcon(image));
        this.ocjena2.setIcon(new ImageIcon(image));
        this.ocjena3.setIcon(new ImageIcon(image));   
      
            } else if(rejting.getOcjena()==5){
        Toolkit tk = getToolkit();
        Image image = tk.createImage(new URL("http://icons.iconarchive.com/icons/custom-icon-design/flatastic-2/24/star-full-icon.png"));
        ocistiLabele();
        
        this.ocjena.setIcon(new ImageIcon(image));
        this.ocjena1.setIcon(new ImageIcon(image));
        this.ocjena2.setIcon(new ImageIcon(image));
        this.ocjena3.setIcon(new ImageIcon(image));
        this.ocjena4.setIcon(new ImageIcon(image));
     
            } 
            
        } catch (Exception e) {
            e.printStackTrace();
        }  
     
     
    }//GEN-LAST:event_listaValueChanged

    private void komboActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_komboActionPerformed
   
         oznacenaStavka = (TockaInteresa) kombo.getSelectedItem();
         if(oznacenaStavka==null){
             return;
         }
         odabrano=kombo.getSelectedIndex();
         
          DefaultListModel<Rejting> mr = new DefaultListModel<>();
        for (Rejting r : oznacenaStavka.getRejting()) {
            mr.addElement(r);
        }
        this.lista.setModel(mr);
         
    }//GEN-LAST:event_komboActionPerformed

    private void akcijaRating1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_akcijaRating1ActionPerformed
         if(oznacenaStavka==null){
            JOptionPane.showMessageDialog(rootPane, "Select point of interest first", "Error!", JOptionPane.ERROR_MESSAGE);
            this.kombo.requestFocus();
            return;
        }
         
          Calendar cal = new GregorianCalendar();
            int month = cal.get(Calendar.MONTH);
            int year = cal.get(Calendar.YEAR);
            int day = cal.get(Calendar.DAY_OF_MONTH);
            
         try {
            rejting.setDatum((java.util.Date) df.parse((day + "." + (month+1) + "." + year)));
        } catch (ParseException ex) {
          
        }
    
         if(html.getText().trim().length()==0){
            rejting.setKomentar("");
        }else{
             rejting.setKomentar(this.html.getText());
         }
        rejting.setOcjena(1);
        rejting.setTockaInteresa((TockaInteresa)this.kombo.getSelectedItem());
        
        try {
             rejting=obradaRejting.dodaj(rejting);
        } catch (Exception e) {
        }
       
        
        ucitajPodatke();
         
         
    }//GEN-LAST:event_akcijaRating1ActionPerformed

    private void akcijaRating2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_akcijaRating2ActionPerformed
        if(oznacenaStavka==null){
            JOptionPane.showMessageDialog(rootPane, "Select point of interest first", "Error!", JOptionPane.ERROR_MESSAGE);
            this.kombo.requestFocus();
            return;
        }
         
          Calendar cal = new GregorianCalendar();
            int month = cal.get(Calendar.MONTH);
            int year = cal.get(Calendar.YEAR);
            int day = cal.get(Calendar.DAY_OF_MONTH);
            
         try {
            rejting.setDatum((java.util.Date) df.parse((day + "." + (month+1) + "." + year)));
        } catch (ParseException ex) {
          
        }
    
         if(html.getText().trim().length()==0){
            rejting.setKomentar("");
        }else{
             rejting.setKomentar(this.html.getText());
         }
        rejting.setOcjena(2);
        rejting.setTockaInteresa((TockaInteresa)this.kombo.getSelectedItem());
        
        try {
             rejting=obradaRejting.dodaj(rejting);
        } catch (Exception e) {
        }
       
        
        ucitajPodatke();
    }//GEN-LAST:event_akcijaRating2ActionPerformed

    private void akcijaRating3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_akcijaRating3ActionPerformed
        if(oznacenaStavka==null){
            JOptionPane.showMessageDialog(rootPane, "Select point of interest first", "Error!", JOptionPane.ERROR_MESSAGE);
            this.kombo.requestFocus();
            return;
        }
         
          Calendar cal = new GregorianCalendar();
            int month = cal.get(Calendar.MONTH);
            int year = cal.get(Calendar.YEAR);
            int day = cal.get(Calendar.DAY_OF_MONTH);
            
         try {
            rejting.setDatum((java.util.Date) df.parse((day + "." + (month+1) + "." + year)));
        } catch (ParseException ex) {
          
        }
    
         if(html.getText().trim().length()==0){
            rejting.setKomentar("");
        }else{
             rejting.setKomentar(this.html.getText());
         }
        rejting.setOcjena(3);
        rejting.setTockaInteresa((TockaInteresa)this.kombo.getSelectedItem());
        
        try {
             rejting=obradaRejting.dodaj(rejting);
        } catch (Exception e) {
        }
       
        
        ucitajPodatke();
    }//GEN-LAST:event_akcijaRating3ActionPerformed

    private void akcijaRating4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_akcijaRating4ActionPerformed
        if(oznacenaStavka==null){
            JOptionPane.showMessageDialog(rootPane, "Select point of interest first", "Error!", JOptionPane.ERROR_MESSAGE);
            this.kombo.requestFocus();
            return;
        }
         
          Calendar cal = new GregorianCalendar();
            int month = cal.get(Calendar.MONTH);
            int year = cal.get(Calendar.YEAR);
            int day = cal.get(Calendar.DAY_OF_MONTH);
            
         try {
            rejting.setDatum((java.util.Date) df.parse((day + "." + (month+1) + "." + year)));
        } catch (ParseException ex) {
          
        }
    
         if(html.getText().trim().length()==0){
            rejting.setKomentar("");
        }else{
             rejting.setKomentar(this.html.getText());
         }
        rejting.setOcjena(4);
        rejting.setTockaInteresa((TockaInteresa)this.kombo.getSelectedItem());
        
        try {
             rejting=obradaRejting.dodaj(rejting);
        } catch (Exception e) {
        }
       
        
        ucitajPodatke();
    }//GEN-LAST:event_akcijaRating4ActionPerformed

    private void akcijaRating5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_akcijaRating5ActionPerformed
       if(oznacenaStavka==null){
            JOptionPane.showMessageDialog(rootPane, "Select point of interest first", "Error!", JOptionPane.ERROR_MESSAGE);
            this.kombo.requestFocus();
            return;
        }
         
          Calendar cal = new GregorianCalendar();
            int month = cal.get(Calendar.MONTH);
            int year = cal.get(Calendar.YEAR);
            int day = cal.get(Calendar.DAY_OF_MONTH);
            
         try {
            rejting.setDatum((java.util.Date) df.parse((day + "." + (month+1) + "." + year)));
        } catch (ParseException ex) {
          
        }
    
         if(html.getText().trim().length()==0){
            rejting.setKomentar("");
        }else{
             rejting.setKomentar(this.html.getText());
         }
        rejting.setOcjena(5);
        rejting.setTockaInteresa((TockaInteresa)this.kombo.getSelectedItem());
        
        try {
            obradaRejting.dodaj(rejting);
        } catch (Exception e) {
        }
       
        
        ucitajPodatke();
    }//GEN-LAST:event_akcijaRating5ActionPerformed

    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton akcijaRating1;
    private javax.swing.JButton akcijaRating2;
    private javax.swing.JButton akcijaRating3;
    private javax.swing.JButton akcijaRating4;
    private javax.swing.JButton akcijaRating5;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JComboBox kombo;
    private javax.swing.JList lista;
    private javax.swing.JLabel ocjena;
    private javax.swing.JLabel ocjena1;
    private javax.swing.JLabel ocjena2;
    private javax.swing.JLabel ocjena3;
    private javax.swing.JLabel ocjena4;
    private javax.swing.JPanel panel;
    // End of variables declaration//GEN-END:variables

//    private void ucitajPodatke() {
//  
//    }

    private void ocistiLabele() {
        this.ocjena.setIcon(null);
        this.ocjena1.setIcon(null);
        this.ocjena2.setIcon(null);
        this.ocjena3.setIcon(null);
        this.ocjena4.setIcon(null);
    }

    private void ucitajPodatke() {
      DefaultComboBoxModel<TockaInteresa> m = 
              new DefaultComboBoxModel<>();
        for (TockaInteresa t : obradaTockaInteresa.getTockaInteresa("")) {
            m.addElement(t);
        }
        this.kombo.setModel(m);
        this.kombo.setSelectedIndex(odabrano);
    }
}
