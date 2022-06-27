/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package projek;
import java.awt.Color;
import java.awt.event.KeyEvent;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import javax.swing.*;
/**
 *
 * @author adity
 */
public class projekJForm extends javax.swing.JFrame {

    /**
     * Creates new form projekJFrom
     */
    
    public int totma1,totma2,totma3,totmi1,totmi2,totmi3,totsemua;
    public String ttotsemua;
    
    public projekJForm() {
        initComponents();
        harga.setEditable(false);
        ongkir.setEditable(false);
        total.setEditable(false);
        uKembali.setEditable(false);
        jLabel12.setText("");
    }
    
    
    void bersih(){
        ma1.setSelected(false);
        ma2.setSelected(false);
        ma3.setSelected(false);
        mi1.setSelected(false);
        mi2.setSelected(false);
        mi3.setSelected(false);
        maPorsi1.setText("");
        maPorsi2.setText("");
        maPorsi3.setText("");
        miPorsi1.setText("");
        miPorsi2.setText("");
        miPorsi3.setText("");
        harga.setText("");
        ongkir.setText("");
        total.setText("");
        jLabel12.setText("");
        uBayar.setText("");
        uKembali.setText("");
        hma1.setText("Rp. 0");
        hma2.setText("Rp. 0");
        hma3.setText("Rp. 0");
        hmi1.setText("Rp. 0");
        hmi2.setText("Rp. 0");
        hmi3.setText("Rp. 0");
    }
    
    public String formatUang(String var){
        
        final String regex = "\\B(?=(\\d{3})+(?!\\d))";
        final String string = var;
        final String subst = ".";
        
        final Pattern pattern = Pattern.compile(regex);
        final Matcher matcher = pattern.matcher(string);
        
        final String result = matcher.replaceAll(subst);
        
        return result;
    }
    
    public String hanyaAngka(String var){
        final String regex = "\\D";
        final String string = var;
        final String subst = "";
        
        final Pattern pattern = Pattern.compile(regex);
        final Matcher matcher = pattern.matcher(string);
        
        final String result = matcher.replaceAll(subst);
        
        return result;
    }
    
    public void hitungBayar(){
        totalHarga();
        if(totsemua==0){
            JOptionPane.showMessageDialog(null,"Mohon Pilih menu yang akan dipesan, lalu masukan uang bayar","Informasi",JOptionPane.INFORMATION_MESSAGE);
        }else if(Integer.parseInt(hanyaAngka(uBayar.getText())) >= Integer.parseInt(hanyaAngka(total.getText()))){
            jLabel12.setText("");
            JOptionPane.showMessageDialog(null,"Pesanan segera diproses","Pembayaran berhasil",JOptionPane.INFORMATION_MESSAGE);
            bersih();
        }else{
           jLabel12.setText("*uang anda kurang");
            uKembali.setText("");
            JOptionPane.showMessageDialog(null,"Uang anda kurang","Pembayaran gagal",JOptionPane.WARNING_MESSAGE);
        }
    }
    
    public void totalHarga(){
        
        //makanan
        if(ma1.isSelected()){
            if("".equals(maPorsi1.getText())){
                totma1 = 0;
                hma1.setText("Rp. 0");
            }else{
                totma1 = 20000*Integer.parseInt(maPorsi1.getText());
                hma1.setText("Rp. " + formatUang(Integer.toString(totma1)));
            }
        }else{
            totma1 = 0;
            hma1.setText("Rp. 0");
        }
        
        if(ma2.isSelected()){
            if("".equals(maPorsi2.getText())){
                totma2 = 0;
                hma2.setText("Rp. 0");
            }else{
                totma2 = 25000*Integer.parseInt(maPorsi2.getText());
                hma2.setText("Rp. " + formatUang(Integer.toString(totma2)));
            }
        }else{
            totma2 = 0;
            hma2.setText("Rp. 0");
        }
        
        if(ma3.isSelected()){
            if("".equals(maPorsi3.getText())){
                totma3 = 0;
                hma3.setText("Rp. 0");
            }else{
                totma3 = 15000*Integer.parseInt(maPorsi3.getText());
                hma3.setText("Rp. " + formatUang(Integer.toString(totma3)));
            }
        }else{
            totma3 = 0;
            hma3.setText("Rp. 0");
        }
        
        //minuman
        if(mi1.isSelected()){
            if("".equals(miPorsi1.getText())){
                totmi1 = 0;
                hmi1.setText("Rp. 0");
            }else{
                totmi1 = 10000*Integer.parseInt(miPorsi1.getText());
                hmi1.setText("Rp. " + formatUang(Integer.toString(totmi1)));
            }
        }else{
            totmi1 = 0;
            hmi1.setText("Rp. 0");
        }
        
        if(mi2.isSelected()){
            if("".equals(miPorsi2.getText())){
                totmi2 = 0;
                hmi2.setText("Rp. 0");
            }else{
                totmi2 = 10000*Integer.parseInt(miPorsi2.getText());
                hmi2.setText("Rp. " + formatUang(Integer.toString(totmi2)));
            }
        }else{
            totmi2 = 0;
            hmi2.setText("Rp. 0");
        }
        
        if(mi3.isSelected()){
            if("".equals(miPorsi3.getText())){
                totmi3 = 0;
                hmi3.setText("Rp. 0");
            }else{
                totmi3 = 10000*Integer.parseInt(miPorsi3.getText());}
                hmi3.setText("Rp. " + formatUang(Integer.toString(totmi3)));
        }else{
            totmi3 = 0;
            hmi3.setText("Rp. 0");
        }
        
        totsemua = totma1+totma2+totma3+totmi1+totmi2+totmi3;
        ttotsemua = Integer.toString(totsemua);
        harga.setText("Rp. " + formatUang(ttotsemua));
        if(totsemua == 0){
            ongkir.setText("Rp. 0");
        }else{
            ongkir.setText("Rp. 12.000");
        }
        
        total.setText("Rp. " + formatUang(Integer.toString(totsemua+Integer.parseInt(hanyaAngka(ongkir.getText())))));
    }
    

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jButton1 = new javax.swing.JButton();
        jPanel1 = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        ma3 = new javax.swing.JCheckBox();
        ma2 = new javax.swing.JCheckBox();
        ma1 = new javax.swing.JCheckBox();
        jLabel2 = new javax.swing.JLabel();
        maPorsi1 = new javax.swing.JTextField();
        maPorsi2 = new javax.swing.JTextField();
        maPorsi3 = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        hma1 = new javax.swing.JLabel();
        hma2 = new javax.swing.JLabel();
        hma3 = new javax.swing.JLabel();
        jPanel4 = new javax.swing.JPanel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        harga = new javax.swing.JTextField();
        ongkir = new javax.swing.JTextField();
        total = new javax.swing.JTextField();
        bReset = new javax.swing.JButton();
        bTutup = new javax.swing.JButton();
        jLabel9 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        uBayar = new javax.swing.JTextField();
        uKembali = new javax.swing.JTextField();
        bayar = new javax.swing.JButton();
        pesan = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        jPanel5 = new javax.swing.JPanel();
        mi3 = new javax.swing.JCheckBox();
        mi2 = new javax.swing.JCheckBox();
        mi1 = new javax.swing.JCheckBox();
        jLabel4 = new javax.swing.JLabel();
        miPorsi1 = new javax.swing.JTextField();
        miPorsi2 = new javax.swing.JTextField();
        miPorsi3 = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        jLabel15 = new javax.swing.JLabel();
        hmi1 = new javax.swing.JLabel();
        hmi2 = new javax.swing.JLabel();
        hmi3 = new javax.swing.JLabel();

        jButton1.setText("jButton1");

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(153, 0, 0));

        jPanel2.setBackground(new java.awt.Color(204, 0, 0));

        ma3.setBackground(new java.awt.Color(153, 0, 0));
        ma3.setForeground(new java.awt.Color(244, 244, 244));
        ma3.setText("Cheese Burger");
        ma3.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                ma3MouseClicked(evt);
            }
        });

        ma2.setBackground(new java.awt.Color(153, 0, 0));
        ma2.setForeground(new java.awt.Color(244, 244, 244));
        ma2.setText("Beef Burger");
        ma2.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                ma2MouseClicked(evt);
            }
        });
        ma2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ma2ActionPerformed(evt);
            }
        });

        ma1.setBackground(new java.awt.Color(153, 0, 0));
        ma1.setForeground(new java.awt.Color(244, 244, 244));
        ma1.setText("Crispy Chicken Burger");
        ma1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                ma1MouseClicked(evt);
            }
        });
        ma1.addPropertyChangeListener(new java.beans.PropertyChangeListener() {
            public void propertyChange(java.beans.PropertyChangeEvent evt) {
                ma1PropertyChange(evt);
            }
        });

        jLabel2.setForeground(new java.awt.Color(244, 244, 244));
        jLabel2.setText("MAKANAN");

        maPorsi1.setBackground(new java.awt.Color(153, 0, 0));
        maPorsi1.setForeground(new java.awt.Color(244, 244, 244));
        maPorsi1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                maPorsi1ActionPerformed(evt);
            }
        });
        maPorsi1.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                maPorsi1KeyPressed(evt);
            }
            public void keyReleased(java.awt.event.KeyEvent evt) {
                maPorsi1KeyReleased(evt);
            }
        });

        maPorsi2.setBackground(new java.awt.Color(153, 0, 0));
        maPorsi2.setForeground(new java.awt.Color(244, 244, 244));
        maPorsi2.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                maPorsi2MouseClicked(evt);
            }
        });
        maPorsi2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                maPorsi2ActionPerformed(evt);
            }
        });
        maPorsi2.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                maPorsi2KeyPressed(evt);
            }
            public void keyReleased(java.awt.event.KeyEvent evt) {
                maPorsi2KeyReleased(evt);
            }
        });

        maPorsi3.setBackground(new java.awt.Color(153, 0, 0));
        maPorsi3.setForeground(new java.awt.Color(244, 244, 244));
        maPorsi3.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                maPorsi3KeyPressed(evt);
            }
            public void keyReleased(java.awt.event.KeyEvent evt) {
                maPorsi3KeyReleased(evt);
            }
        });

        jLabel3.setForeground(new java.awt.Color(244, 244, 244));
        jLabel3.setText("JUMLAH");

        jLabel11.setForeground(new java.awt.Color(244, 244, 244));
        jLabel11.setText("TOTAL HARGA");

        hma1.setForeground(new java.awt.Color(244, 244, 244));
        hma1.setText("Rp. 0");

        hma2.setForeground(new java.awt.Color(244, 244, 244));
        hma2.setText("Rp. 0");

        hma3.setForeground(new java.awt.Color(244, 244, 244));
        hma3.setText("Rp. 0");

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 87, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(100, 100, 100))
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel2Layout.createSequentialGroup()
                        .addGap(8, 8, 8)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(ma2, javax.swing.GroupLayout.PREFERRED_SIZE, 157, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(ma1, javax.swing.GroupLayout.PREFERRED_SIZE, 157, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(ma3, javax.swing.GroupLayout.PREFERRED_SIZE, 157, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 9, Short.MAX_VALUE)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(maPorsi2, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(maPorsi1, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(maPorsi3, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jLabel3, javax.swing.GroupLayout.Alignment.TRAILING))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 66, Short.MAX_VALUE)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel11, javax.swing.GroupLayout.DEFAULT_SIZE, 96, Short.MAX_VALUE)
                    .addComponent(hma1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(hma2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(hma3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(jLabel3)
                    .addComponent(jLabel11))
                .addGap(18, 18, 18)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(ma1)
                    .addComponent(maPorsi1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(hma1))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 6, Short.MAX_VALUE)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(ma2, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(maPorsi2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(hma2))
                .addGap(9, 9, 9)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(ma3)
                    .addComponent(maPorsi3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(hma3))
                .addGap(38, 38, 38))
        );

        jPanel4.setBackground(new java.awt.Color(204, 0, 0));

        jLabel6.setForeground(new java.awt.Color(244, 244, 244));
        jLabel6.setText("Harga                                :");

        jLabel7.setForeground(new java.awt.Color(244, 244, 244));
        jLabel7.setText("Ongkos Kirim                   :");

        jLabel8.setForeground(new java.awt.Color(244, 244, 244));
        jLabel8.setText("Total                                 :");

        harga.setBackground(new java.awt.Color(153, 0, 0));
        harga.setForeground(new java.awt.Color(244, 244, 244));

        ongkir.setBackground(new java.awt.Color(153, 0, 0));
        ongkir.setForeground(new java.awt.Color(244, 244, 244));
        ongkir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ongkirActionPerformed(evt);
            }
        });

        total.setBackground(new java.awt.Color(153, 0, 0));
        total.setForeground(new java.awt.Color(244, 244, 244));
        total.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                totalActionPerformed(evt);
            }
        });

        bReset.setText("RESET");
        bReset.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                bResetMouseClicked(evt);
            }
        });

        bTutup.setText("TUTUP");
        bTutup.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                bTutupMouseClicked(evt);
            }
        });

        jLabel9.setForeground(new java.awt.Color(244, 244, 244));
        jLabel9.setText("Uang Bayar                       :");
        jLabel9.setMaximumSize(new java.awt.Dimension(142, 15));
        jLabel9.setMinimumSize(new java.awt.Dimension(142, 15));

        jLabel10.setForeground(new java.awt.Color(244, 244, 244));
        jLabel10.setText("Uang Kembali                   :");

        uBayar.setBackground(new java.awt.Color(153, 0, 0));
        uBayar.setForeground(new java.awt.Color(244, 244, 244));
        uBayar.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                uBayarMouseClicked(evt);
            }
        });
        uBayar.addPropertyChangeListener(new java.beans.PropertyChangeListener() {
            public void propertyChange(java.beans.PropertyChangeEvent evt) {
                uBayarPropertyChange(evt);
            }
        });
        uBayar.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                uBayarKeyPressed(evt);
            }
            public void keyReleased(java.awt.event.KeyEvent evt) {
                uBayarKeyReleased(evt);
            }
        });

        uKembali.setBackground(new java.awt.Color(153, 0, 0));
        uKembali.setForeground(new java.awt.Color(244, 244, 244));

        bayar.setText("BAYAR");
        bayar.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                bayarMouseClicked(evt);
            }
        });

        jLabel12.setForeground(new java.awt.Color(244, 244, 244));
        jLabel12.setText("jLabel12");

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                        .addComponent(jLabel8, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jLabel7, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 144, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jLabel6))
                .addGap(27, 27, 27)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(ongkir)
                    .addComponent(total)
                    .addComponent(harga, javax.swing.GroupLayout.PREFERRED_SIZE, 168, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addGap(3, 3, 3)
                        .addComponent(pesan, javax.swing.GroupLayout.PREFERRED_SIZE, 203, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel4Layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel4Layout.createSequentialGroup()
                                .addComponent(bTutup)
                                .addGap(65, 65, 65)
                                .addComponent(bReset)
                                .addGap(49, 49, 49)
                                .addComponent(bayar))
                            .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel4Layout.createSequentialGroup()
                                    .addComponent(jLabel9, javax.swing.GroupLayout.PREFERRED_SIZE, 142, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                    .addComponent(uBayar, javax.swing.GroupLayout.PREFERRED_SIZE, 166, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGroup(jPanel4Layout.createSequentialGroup()
                                    .addComponent(jLabel10, javax.swing.GroupLayout.PREFERRED_SIZE, 142, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                    .addComponent(uKembali))))
                        .addGap(81, 81, 81))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel4Layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 93, Short.MAX_VALUE)
                        .addComponent(jLabel12, javax.swing.GroupLayout.PREFERRED_SIZE, 185, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(222, 222, 222))))
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap(41, Short.MAX_VALUE)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel6)
                    .addComponent(harga, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel9, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(uBayar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(ongkir, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabel7))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel10)
                        .addComponent(uKembali, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(18, 18, 18)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel8)
                    .addComponent(total, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(pesan)
                    .addComponent(jLabel12))
                .addGap(20, 20, 20)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(bayar, javax.swing.GroupLayout.PREFERRED_SIZE, 53, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(bReset, javax.swing.GroupLayout.PREFERRED_SIZE, 53, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(bTutup, javax.swing.GroupLayout.PREFERRED_SIZE, 53, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(20, 20, 20))
        );

        jLabel1.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(244, 244, 244));
        jLabel1.setText("RAJA BURGER");

        jPanel5.setBackground(new java.awt.Color(204, 0, 0));
        jPanel5.setPreferredSize(new java.awt.Dimension(390, 167));

        mi3.setBackground(new java.awt.Color(153, 0, 0));
        mi3.setForeground(new java.awt.Color(244, 244, 244));
        mi3.setText("Sprite");
        mi3.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                mi3MouseClicked(evt);
            }
        });

        mi2.setBackground(new java.awt.Color(153, 0, 0));
        mi2.setForeground(new java.awt.Color(244, 244, 244));
        mi2.setText("Pepsi");
        mi2.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                mi2MouseClicked(evt);
            }
        });

        mi1.setBackground(new java.awt.Color(153, 0, 0));
        mi1.setForeground(new java.awt.Color(244, 244, 244));
        mi1.setText("Coca-Cola");
        mi1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                mi1MouseClicked(evt);
            }
        });

        jLabel4.setForeground(new java.awt.Color(244, 244, 244));
        jLabel4.setText("MINUMAN");

        miPorsi1.setBackground(new java.awt.Color(153, 0, 0));
        miPorsi1.setForeground(new java.awt.Color(244, 244, 244));
        miPorsi1.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                miPorsi1KeyPressed(evt);
            }
            public void keyReleased(java.awt.event.KeyEvent evt) {
                miPorsi1KeyReleased(evt);
            }
        });

        miPorsi2.setBackground(new java.awt.Color(153, 0, 0));
        miPorsi2.setForeground(new java.awt.Color(244, 244, 244));
        miPorsi2.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                miPorsi2KeyPressed(evt);
            }
            public void keyReleased(java.awt.event.KeyEvent evt) {
                miPorsi2KeyReleased(evt);
            }
        });

        miPorsi3.setBackground(new java.awt.Color(153, 0, 0));
        miPorsi3.setForeground(new java.awt.Color(244, 244, 244));
        miPorsi3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                miPorsi3ActionPerformed(evt);
            }
        });
        miPorsi3.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                miPorsi3KeyPressed(evt);
            }
            public void keyReleased(java.awt.event.KeyEvent evt) {
                miPorsi3KeyReleased(evt);
            }
        });

        jLabel5.setForeground(new java.awt.Color(244, 244, 244));
        jLabel5.setText("JUMLAH");

        jLabel15.setForeground(new java.awt.Color(244, 244, 244));
        jLabel15.setText("TOTAL HARGA");

        hmi1.setForeground(new java.awt.Color(244, 244, 244));
        hmi1.setText("Rp. 0");

        hmi2.setForeground(new java.awt.Color(244, 244, 244));
        hmi2.setText("Rp. 0");

        hmi3.setForeground(new java.awt.Color(244, 244, 244));
        hmi3.setText("Rp. 0");

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 87, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel5Layout.createSequentialGroup()
                        .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addComponent(mi2, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(mi1, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 157, Short.MAX_VALUE)
                            .addComponent(mi3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addGap(35, 35, 35)
                        .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel5)
                            .addComponent(miPorsi1, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(miPorsi2, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(miPorsi3, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 72, Short.MAX_VALUE)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jLabel15, javax.swing.GroupLayout.DEFAULT_SIZE, 91, Short.MAX_VALUE)
                    .addComponent(hmi1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(hmi2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(hmi3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel5Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(jLabel5)
                    .addComponent(jLabel15))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(mi1)
                    .addComponent(miPorsi1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(hmi1))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(mi2)
                    .addComponent(miPorsi2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(hmi2))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(mi3)
                    .addComponent(miPorsi3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(hmi3))
                .addGap(38, 38, 38))
        );

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap(23, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addGap(383, 383, 383))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jPanel5, javax.swing.GroupLayout.PREFERRED_SIZE, 421, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(16, 16, 16))))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(30, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(0, 0, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void ongkirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ongkirActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_ongkirActionPerformed

    private void totalActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_totalActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_totalActionPerformed

    private void ma2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ma2ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_ma2ActionPerformed

    private void maPorsi2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_maPorsi2ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_maPorsi2ActionPerformed

    private void ma1PropertyChange(java.beans.PropertyChangeEvent evt) {//GEN-FIRST:event_ma1PropertyChange
        // TODO add your handling code here:
    }//GEN-LAST:event_ma1PropertyChange

    private void bTutupMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_bTutupMouseClicked
        // TODO add your handling code here:
        int tutup;
        tutup = JOptionPane.showConfirmDialog(null,"Yakin tutup Program","Konfirmasi?",JOptionPane.YES_NO_OPTION);
        if (tutup == JOptionPane.YES_OPTION){
            dispose();
        }
    }//GEN-LAST:event_bTutupMouseClicked

    private void bResetMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_bResetMouseClicked
        // TODO add your handling code here:
        bersih();
    }//GEN-LAST:event_bResetMouseClicked

    private void bayarMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_bayarMouseClicked
        // TODO add your handling code here:
        hitungBayar();
    }//GEN-LAST:event_bayarMouseClicked

    private void maPorsi1KeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_maPorsi1KeyPressed
        // TODO add your handling code here:
        if ((evt.getKeyChar() >= '0' && evt.getKeyChar() <= '9') || evt.getKeyCode() == KeyEvent.VK_BACK_SPACE || evt.getKeyCode() == KeyEvent.VK_DELETE) {
            maPorsi1.setEditable(true);
            jLabel12.setText("");
        } else {
            maPorsi1.setEditable(false);
            jLabel12.setText("*Hanya masukan angka(0-9)");
        }
    }//GEN-LAST:event_maPorsi1KeyPressed

    private void maPorsi2KeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_maPorsi2KeyPressed
        // TODO add your handling code here:
        if ((evt.getKeyChar() >= '0' && evt.getKeyChar() <= '9') || evt.getKeyCode() == KeyEvent.VK_BACK_SPACE || evt.getKeyCode() == KeyEvent.VK_DELETE) {
            maPorsi2.setEditable(true);
            jLabel12.setText("");
        } else {
            maPorsi2.setEditable(false);
            jLabel12.setText("*Hanya masukan angka(0-9)");
        }
    }//GEN-LAST:event_maPorsi2KeyPressed

    private void maPorsi3KeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_maPorsi3KeyPressed
        // TODO add your handling code here:
        if ((evt.getKeyChar() >= '0' && evt.getKeyChar() <= '9') || evt.getKeyCode() == KeyEvent.VK_BACK_SPACE || evt.getKeyCode() == KeyEvent.VK_DELETE) {
            maPorsi3.setEditable(true);
            jLabel12.setText("");
        } else {
            maPorsi3.setEditable(false);
            jLabel12.setText("*Hanya masukan angka(0-9)");
        }
    }//GEN-LAST:event_maPorsi3KeyPressed

    private void uBayarKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_uBayarKeyPressed
        // TODO add your handling code here:
        if ((evt.getKeyChar() >= '0' && evt.getKeyChar() <= '9') || evt.getKeyCode() == KeyEvent.VK_BACK_SPACE || evt.getKeyCode() == KeyEvent.VK_DELETE) {
            uBayar.setEditable(true);
            jLabel12.setText("");
        } else if(evt.getKeyCode() == KeyEvent.VK_ENTER) {
            hitungBayar();
        }else {
            uBayar.setEditable(false);
            jLabel12.setText("*Hanya masukan angka(0-9)");
        }
        
    }//GEN-LAST:event_uBayarKeyPressed

    private void uBayarMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_uBayarMouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_uBayarMouseClicked

    private void uBayarPropertyChange(java.beans.PropertyChangeEvent evt) {//GEN-FIRST:event_uBayarPropertyChange
        // TODO add your handling code here:
        
    }//GEN-LAST:event_uBayarPropertyChange

    private void uBayarKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_uBayarKeyReleased
        // TODO add your handling code here:
        String tuBayar = uBayar.getText();
        tuBayar = hanyaAngka(tuBayar);
        uBayar.setText("Rp. " + formatUang(tuBayar));
        if(!"".equals(total.getText()) ){
            int a ,b;
            try{
                a = Integer.parseInt(hanyaAngka(uBayar.getText()));
                b = Integer.parseInt(hanyaAngka(total.getText()));
            }catch(NumberFormatException e){
                a = 0;
                b = 0;
            }
            String x = Integer.toString( a - b );
            uKembali.setText("Rp. " + formatUang(x));
        }else{
            uKembali.setText("");
        }

    }//GEN-LAST:event_uBayarKeyReleased

    private void maPorsi1KeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_maPorsi1KeyReleased
        // TODO add your handling code here:
        totalHarga();
    }//GEN-LAST:event_maPorsi1KeyReleased

    private void ma1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_ma1MouseClicked
        // TODO add your handling code here:
        totalHarga();
    }//GEN-LAST:event_ma1MouseClicked

    private void ma2MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_ma2MouseClicked
        // TODO add your handling code here:
        totalHarga();
    }//GEN-LAST:event_ma2MouseClicked

    private void ma3MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_ma3MouseClicked
        // TODO add your handling code here:
        totalHarga();
    }//GEN-LAST:event_ma3MouseClicked

    private void maPorsi2MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_maPorsi2MouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_maPorsi2MouseClicked

    private void maPorsi2KeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_maPorsi2KeyReleased
        // TODO add your handling code here:
        totalHarga();
    }//GEN-LAST:event_maPorsi2KeyReleased

    private void maPorsi3KeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_maPorsi3KeyReleased
        // TODO add your handling code here:
        totalHarga();
    }//GEN-LAST:event_maPorsi3KeyReleased

    private void miPorsi3KeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_miPorsi3KeyReleased
        // TODO add your handling code here:
        totalHarga();
    }//GEN-LAST:event_miPorsi3KeyReleased

    private void miPorsi3KeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_miPorsi3KeyPressed
        // TODO add your handling code here:
        if ((evt.getKeyChar() >= '0' && evt.getKeyChar() <= '9') || evt.getKeyCode() == KeyEvent.VK_BACK_SPACE || evt.getKeyCode() == KeyEvent.VK_DELETE) {
            miPorsi3.setEditable(true);
            jLabel12.setText("");
        } else {
            miPorsi3.setEditable(false);
            jLabel12.setText("*Hanya masukan angka(0-9)");
        }
    }//GEN-LAST:event_miPorsi3KeyPressed

    private void miPorsi3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_miPorsi3ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_miPorsi3ActionPerformed

    private void miPorsi2KeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_miPorsi2KeyReleased
        // TODO add your handling code here:
        totalHarga();
    }//GEN-LAST:event_miPorsi2KeyReleased

    private void miPorsi2KeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_miPorsi2KeyPressed
        // TODO add your handling code here:
        if ((evt.getKeyChar() >= '0' && evt.getKeyChar() <= '9') || evt.getKeyCode() == KeyEvent.VK_BACK_SPACE || evt.getKeyCode() == KeyEvent.VK_DELETE) {
            miPorsi2.setEditable(true);
            jLabel12.setText("");
        } else {
            miPorsi2.setEditable(false);
            jLabel12.setText("*Hanya masukan angka(0-9)");
        }
    }//GEN-LAST:event_miPorsi2KeyPressed

    private void miPorsi1KeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_miPorsi1KeyReleased
        // TODO add your handling code here:
        totalHarga();
    }//GEN-LAST:event_miPorsi1KeyReleased

    private void miPorsi1KeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_miPorsi1KeyPressed
        // TODO add your handling code here:
        if ((evt.getKeyChar() >= '0' && evt.getKeyChar() <= '9') || evt.getKeyCode() == KeyEvent.VK_BACK_SPACE || evt.getKeyCode() == KeyEvent.VK_DELETE) {
            miPorsi1.setEditable(true);
            jLabel12.setText("");
        } else {
            miPorsi1.setEditable(false);
            jLabel12.setText("*Hanya masukan angka(0-9)");
        }
    }//GEN-LAST:event_miPorsi1KeyPressed

    private void mi1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_mi1MouseClicked
        // TODO add your handling code here:
        totalHarga();
    }//GEN-LAST:event_mi1MouseClicked

    private void mi2MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_mi2MouseClicked
        // TODO add your handling code here:
        totalHarga();
    }//GEN-LAST:event_mi2MouseClicked

    private void mi3MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_mi3MouseClicked
        // TODO add your handling code here:
        totalHarga();
    }//GEN-LAST:event_mi3MouseClicked

    private void maPorsi1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_maPorsi1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_maPorsi1ActionPerformed

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
            java.util.logging.Logger.getLogger(projekJForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(projekJForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(projekJForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(projekJForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new projekJForm().setVisible(true);
            }
        });
        
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton bReset;
    private javax.swing.JButton bTutup;
    private javax.swing.JButton bayar;
    private javax.swing.JTextField harga;
    private javax.swing.JLabel hma1;
    private javax.swing.JLabel hma2;
    private javax.swing.JLabel hma3;
    private javax.swing.JLabel hmi1;
    private javax.swing.JLabel hmi2;
    private javax.swing.JLabel hmi3;
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JCheckBox ma1;
    private javax.swing.JCheckBox ma2;
    private javax.swing.JCheckBox ma3;
    private javax.swing.JTextField maPorsi1;
    private javax.swing.JTextField maPorsi2;
    private javax.swing.JTextField maPorsi3;
    private javax.swing.JCheckBox mi1;
    private javax.swing.JCheckBox mi2;
    private javax.swing.JCheckBox mi3;
    private javax.swing.JTextField miPorsi1;
    private javax.swing.JTextField miPorsi2;
    private javax.swing.JTextField miPorsi3;
    private javax.swing.JTextField ongkir;
    private javax.swing.JLabel pesan;
    private javax.swing.JTextField total;
    private javax.swing.JTextField uBayar;
    private javax.swing.JTextField uKembali;
    // End of variables declaration//GEN-END:variables
}
