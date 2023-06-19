import java.sql.*;
import java.text.SimpleDateFormat;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.*;


public class addPeminjaman extends javax.swing.JFrame {
    String url ="jdbc:mysql://localhost/perpustakaan";
    Statement stmt = null;
    PreparedStatement ps = null;
    Connection conn = null;
    ResultSet rs;
    
    editPeminjaman ep = new editPeminjaman();
    public DefaultTableModel tableModel;
    public int baris;
    
    public addPeminjaman(){
        initComponents();
        tampil_nama();
        tampil_buku();
        
        
        
        tableModel = new DefaultTableModel();
        tableModel.addColumn("No");
        tableModel.addColumn("No Mahasiswa");
        tableModel.addColumn("Nama");
        tableModel.addColumn("No Buku");
        tableModel.addColumn("Buku");
        tableModel.addColumn("Tanggal Pinjam");
        tableModel.addColumn("Tanggal Kembali");
        Listpinjam.setModel(tableModel);
        
        tampilJoin();
//        try {
//            Class.forName("com.mysql.cj.jdbc.Driver");
//            conn = DriverManager.getConnection(url, "root", "");
//            stmt = conn.createStatement();
//            rs = stmt.executeQuery("select peminjaman.id_pinjam, peminjaman.id_mahasiswa, mahasiswa.nama,peminjaman.id_buku, buku.judul, peminjaman.tanggal_pinjam, peminjaman.tanggal_kembali from peminjaman inner join mahasiswa on mahasiswa.id_mahasiswa = peminjaman.id_mahasiswa inner join buku on buku.id_buku = peminjaman.id_buku");
//            
//            while (rs.next()) {
//                String no = String.valueOf(rs.getInt("id_pinjam"));
//                String id_mahasiswa = rs.getString("id_mahasiswa");
//                String nama = rs.getString("nama");
//                String id_buku = rs.getString("id_buku");
//                String buku = rs.getString("judul");
//                String tgl_pinjam = String.valueOf(rs.getDate("tanggal_pinjam"));
//                String tgl_kembali = String.valueOf(rs.getDate("tanggal_kembali"));
//
//                String listPinjam[] = {no, id_mahasiswa,nama,id_buku, buku, tgl_pinjam, tgl_kembali};
//                //System.out.println(id_buku);
//
//                tableModel.addRow(listPinjam);
//                Listpinjam.setModel(tableModel);
//            }
//        } catch (ClassNotFoundException | SQLException e) {
//            System.out.println(e.getMessage());
//        }
    }
    
    public void tampilJoin(){
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            conn = DriverManager.getConnection(url, "root", "");
            stmt = conn.createStatement();
            rs = stmt.executeQuery("select peminjaman.id_pinjam, peminjaman.id_mahasiswa, mahasiswa.nama,peminjaman.id_buku, buku.judul, peminjaman.tanggal_pinjam, peminjaman.tanggal_kembali from peminjaman inner join mahasiswa on mahasiswa.id_mahasiswa = peminjaman.id_mahasiswa inner join buku on buku.id_buku = peminjaman.id_buku");
            
            while (rs.next()) {
                String no = String.valueOf(rs.getInt("id_pinjam"));
                String id_mahasiswa = rs.getString("id_mahasiswa");
                String nama = rs.getString("nama");
                String id_buku = rs.getString("id_buku");
                String buku = rs.getString("judul");
                String tgl_pinjam = String.valueOf(rs.getDate("tanggal_pinjam"));
                String tgl_kembali = String.valueOf(rs.getDate("tanggal_kembali"));

                String listPinjam[] = {no, id_mahasiswa,nama,id_buku, buku, tgl_pinjam, tgl_kembali};
                //System.out.println(id_buku);

                tableModel.addRow(listPinjam);
                Listpinjam.setModel(tableModel);
            }
        } catch (ClassNotFoundException | SQLException e) {
            System.out.println(e.getMessage());
        }
    }

    public void tampil_nama(){
    try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            conn = DriverManager.getConnection(url, "root", "");
            stmt = conn.createStatement();
            rs = stmt.executeQuery("SELECT * FROM mahasiswa");

            while (rs.next()) {
                cbNama.addItem(String.valueOf(rs.getInt("id_mahasiswa")));
            }
            rs.last();
            int jumlahdata = rs.getRow();
            rs.first();
            }catch (ClassNotFoundException | SQLException e) {
            System.out.println(e.getMessage());
        }
    }
    
    public void tampil_buku(){
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            conn = DriverManager.getConnection(url, "root", "");
            stmt = conn.createStatement();
            rs = stmt.executeQuery("SELECT * FROM buku");

            while (rs.next()) {
                cbBuku.addItem(String.valueOf(rs.getInt("id_buku")));
            }
            rs.last();
            int jumlahdata = rs.getRow();
            rs.first();
            }catch (ClassNotFoundException | SQLException e) {
            System.out.println(e.getMessage());
        }
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
        jTable1 = new javax.swing.JTable();
        panelTPeminjaman = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        cbNama = new javax.swing.JComboBox<>();
        jLabel3 = new javax.swing.JLabel();
        cbBuku = new javax.swing.JComboBox<>();
        jLabel4 = new javax.swing.JLabel();
        tglPinjam = new com.toedter.calendar.JDateChooser();
        jLabel5 = new javax.swing.JLabel();
        tglKembali = new com.toedter.calendar.JDateChooser();
        bSimpan = new javax.swing.JButton();
        backTP = new javax.swing.JButton();
        bEdit = new javax.swing.JButton();
        bHapus = new javax.swing.JButton();
        jScrollPane2 = new javax.swing.JScrollPane();
        Listpinjam = new javax.swing.JTable();

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        jScrollPane1.setViewportView(jTable1);

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        panelTPeminjaman.setBackground(new java.awt.Color(255, 204, 153));

        jLabel1.setFont(new java.awt.Font("Helvetica Neue", 1, 32)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("Peminjaman");

        jLabel2.setFont(new java.awt.Font("Helvetica Neue", 0, 16)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setText("Nama");

        cbNama.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "--- Nama ---" }));
        cbNama.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cbNamaActionPerformed(evt);
            }
        });

        jLabel3.setFont(new java.awt.Font("Helvetica Neue", 0, 16)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(255, 255, 255));
        jLabel3.setText("Buku");

        cbBuku.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "--- Buku ---" }));

        jLabel4.setFont(new java.awt.Font("Helvetica Neue", 0, 16)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(255, 255, 255));
        jLabel4.setText("Tanggal Pinjam ");

        jLabel5.setFont(new java.awt.Font("Helvetica Neue", 0, 16)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(255, 255, 255));
        jLabel5.setText("Tanggal Kembali");

        bSimpan.setText("Tambah");
        bSimpan.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        bSimpan.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bSimpanActionPerformed(evt);
            }
        });

        backTP.setBackground(new java.awt.Color(255, 204, 153));
        backTP.setFont(new java.awt.Font("Helvetica Neue", 1, 14)); // NOI18N
        backTP.setForeground(new java.awt.Color(242, 242, 242));
        backTP.setText("Back");
        backTP.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        backTP.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                backTPActionPerformed(evt);
            }
        });

        bEdit.setText("Edit");
        bEdit.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        bEdit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bEditActionPerformed(evt);
            }
        });

        bHapus.setText("Hapus");
        bHapus.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        bHapus.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bHapusActionPerformed(evt);
            }
        });

        Listpinjam.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null}
            },
            new String [] {
                "No", "No Mahasiswa", "Nama", "No Buku", "Judul", "Tanggal Pinjam", "Tanggal Kembali"
            }
        ));
        Listpinjam.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                ListpinjamMouseClicked(evt);
            }
        });
        jScrollPane2.setViewportView(Listpinjam);

        javax.swing.GroupLayout panelTPeminjamanLayout = new javax.swing.GroupLayout(panelTPeminjaman);
        panelTPeminjaman.setLayout(panelTPeminjamanLayout);
        panelTPeminjamanLayout.setHorizontalGroup(
            panelTPeminjamanLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelTPeminjamanLayout.createSequentialGroup()
                .addGap(115, 115, 115)
                .addGroup(panelTPeminjamanLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(panelTPeminjamanLayout.createSequentialGroup()
                        .addGroup(panelTPeminjamanLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel3)
                            .addComponent(jLabel5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(panelTPeminjamanLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(tglPinjam, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 225, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(cbBuku, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 225, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(tglKembali, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 225, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(cbNama, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 225, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(panelTPeminjamanLayout.createSequentialGroup()
                        .addComponent(bSimpan, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(98, 98, 98)
                        .addComponent(bEdit, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(bHapus, javax.swing.GroupLayout.PREFERRED_SIZE, 91, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(37, 37, 37)))
                .addGap(94, 94, 94))
            .addGroup(panelTPeminjamanLayout.createSequentialGroup()
                .addGap(49, 49, 49)
                .addComponent(backTP, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 152, Short.MAX_VALUE)
                .addComponent(jLabel1)
                .addGap(241, 241, 241))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelTPeminjamanLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 669, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(17, 17, 17))
        );
        panelTPeminjamanLayout.setVerticalGroup(
            panelTPeminjamanLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelTPeminjamanLayout.createSequentialGroup()
                .addGap(37, 37, 37)
                .addGroup(panelTPeminjamanLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel1)
                    .addComponent(backTP, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(30, 30, 30)
                .addGroup(panelTPeminjamanLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(cbNama, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(24, 24, 24)
                .addGroup(panelTPeminjamanLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(cbBuku, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel3))
                .addGap(24, 24, 24)
                .addGroup(panelTPeminjamanLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(tglPinjam, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel4))
                .addGap(18, 18, 18)
                .addGroup(panelTPeminjamanLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(tglKembali, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel5))
                .addGap(39, 39, 39)
                .addGroup(panelTPeminjamanLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(bSimpan, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(bEdit, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(bHapus, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(54, 54, 54)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 147, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(77, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(panelTPeminjaman, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(panelTPeminjaman, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void bSimpanActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bSimpanActionPerformed
        // TODO add your handling code here:
        String tampilan = "yyyy-MM-dd";
        SimpleDateFormat fm = new SimpleDateFormat(tampilan);
        String tglpinjam = String.valueOf(fm.format(tglPinjam.getDate()));
        String tglkembali = String.valueOf(fm.format(tglKembali.getDate()));
        
        try{
           String sql = "INSERT INTO peminjaman(id_mahasiswa,id_buku, tanggal_pinjam, tanggal_kembali) values('"+(String)cbNama.getSelectedItem()+ 
                   "','"+(String)cbBuku.getSelectedItem()+
                   "','"+tglpinjam+
                   "','"+tglkembali+"')"; 
           stmt=conn.createStatement();
           int simpan = stmt.executeUpdate(sql);
           if(simpan>0){
               javax.swing.JOptionPane.showMessageDialog(this,"Data berhasil ditambahkan",
                       "pesan",javax.swing.JOptionPane.INFORMATION_MESSAGE);
           }else{
              javax.swing.JOptionPane.showMessageDialog(this,"Data gagal ditambahkan",
                       "pesan",javax.swing.JOptionPane.INFORMATION_MESSAGE); 
           }
           tableModel.setRowCount(0);
           dispose();
           new addPeminjaman().setVisible(true);
        }catch(Exception e){
            e.printStackTrace();
        }
        tampilJoin();
    }//GEN-LAST:event_bSimpanActionPerformed

    private void backTPActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_backTPActionPerformed
        // TODO add your handling code here:
        dispose();
    }//GEN-LAST:event_backTPActionPerformed

    private void cbNamaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbNamaActionPerformed
        // TODO add your handling code here:
        
    }//GEN-LAST:event_cbNamaActionPerformed

    private void bEditActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bEditActionPerformed
        // TODO add your handling code here:
        ep.setVisible(true);
    }//GEN-LAST:event_bEditActionPerformed

    private void ListpinjamMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_ListpinjamMouseClicked
        // TODO add your handling code here:
        
        baris = Listpinjam.getSelectedRow();
        ep.jTextField5.setText(Listpinjam.getValueAt(baris, 0).toString());
        ep.jTextField1.setText(Listpinjam.getValueAt(baris, 1).toString());
        ep.jTextField2.setText(Listpinjam.getValueAt(baris, 3).toString());
        ep.jTextField3.setText(Listpinjam.getValueAt(baris, 5).toString());
        ep.jTextField4.setText(Listpinjam.getValueAt(baris, 6).toString());
        
    }//GEN-LAST:event_ListpinjamMouseClicked

    private void bHapusActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bHapusActionPerformed
        // TODO add your handling code here:
        try{
           String sql = "delete from peminjaman WHERE id_pinjam = "+ ep.jTextField5.getText() +""; 
           stmt=conn.createStatement();
           int simpan = stmt.executeUpdate(sql);
           if(simpan>0){
               javax.swing.JOptionPane.showMessageDialog(this,"Data berhasil dihapus",
                       "pesan",javax.swing.JOptionPane.INFORMATION_MESSAGE);
           }else{
              javax.swing.JOptionPane.showMessageDialog(this,"Data gagal dihapus"
                      + "",
                       "pesan",javax.swing.JOptionPane.INFORMATION_MESSAGE); 
           }
           tableModel.setRowCount(0);
        }catch(Exception e){
            e.printStackTrace();
        }
        tampilJoin();
    }//GEN-LAST:event_bHapusActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(addPeminjaman.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(addPeminjaman.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(addPeminjaman.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(addPeminjaman.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new addPeminjaman().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    public javax.swing.JTable Listpinjam;
    private javax.swing.JButton bEdit;
    private javax.swing.JButton bHapus;
    private javax.swing.JButton bSimpan;
    private javax.swing.JButton backTP;
    private javax.swing.JComboBox<String> cbBuku;
    private javax.swing.JComboBox<String> cbNama;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTable jTable1;
    private javax.swing.JPanel panelTPeminjaman;
    private com.toedter.calendar.JDateChooser tglKembali;
    private com.toedter.calendar.JDateChooser tglPinjam;
    // End of variables declaration//GEN-END:variables
}
