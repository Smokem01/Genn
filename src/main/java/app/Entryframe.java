package app;

import java.io.File;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.ArrayList;


import org.apache.poi.xwpf.usermodel.ParagraphAlignment;
import org.apache.poi.xwpf.usermodel.TableRowAlign;
import org.apache.poi.xwpf.usermodel.UnderlinePatterns;

import org.apache.poi.xwpf.usermodel.XWPFDocument;
import org.apache.poi.xwpf.usermodel.XWPFParagraph;
import org.apache.poi.xwpf.usermodel.XWPFRun;
import org.apache.poi.xwpf.usermodel.XWPFTable;
import org.apache.poi.xwpf.usermodel.XWPFTableRow;

import javax.swing.ImageIcon;


public class Entryframe extends javax.swing.JFrame {

    private Client cl;
    int curr;
    int max;

    double doubleformat(double number, int precision)
    {
        double prec = Math.pow(10, precision);
        int integerPart = (int) number;
        double fractionalPart = number - integerPart;
        fractionalPart *= prec;
        int fractPart = (int) fractionalPart;
        fractionalPart = (double) (integerPart) + (double) (fractPart)/prec;
        return fractionalPart;
    }


    int max(int a,int b)
    {
        if(a>=b)
            return a;
        else
            return b;
    }

   public static void LinedText(String data, XWPFParagraph P)
    {
        XWPFRun run = P.createRun();
        if (data.contains("\n")) 
        {
            String[] lines = data.split("\n");
            run.setText(lines[0],0);
            for(int i=1;i<lines.length;i++)
            {
                run.addBreak();
                run.setText(lines[i]); 
            }
        } 
        else 
        {
            run.setText(data, 0);
        }
    }
    
    public Entryframe(int a,Client c,int m) 
    {
        initComponents();
        jLabel1.setText("Entré N°"+a);
        if(a==m)
        {
            jButton1.setText("Générer Facture");
        }
        else
        {
            jButton1.setText("Suivant");
        }
        this.cl = c;
        curr = a;
        max = m;
        this.setVisible(true);
    }
                     
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jTextField1 = new javax.swing.JTextField();
        jTextField2 = new javax.swing.JTextField();
        jTextField3 = new javax.swing.JTextField();
        jButton1 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Generateur De Facture");
        setIconImage(new ImageIcon("resources\\icon.png").getImage());

        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("Enrtry Number");

        jLabel2.setText("Désigniation:");

        jLabel3.setText("Quantité:");

        jLabel4.setText("Prix Unitaire HT (DT,MM)");

        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                try {
                    jButton1ActionPerformed(evt);
                } catch (Exception e) {
                    new Invalidframe();
                }
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(0, 0, Short.MAX_VALUE))
                            .addComponent(jLabel4, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 144, Short.MAX_VALUE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, 124, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jTextField2, javax.swing.GroupLayout.PREFERRED_SIZE, 124, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jTextField3, javax.swing.GroupLayout.PREFERRED_SIZE, 124, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(22, 22, 22))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 103, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(100, 100, 100))))
            .addGroup(layout.createSequentialGroup()
                .addGap(102, 102, 102)
                .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(15, 15, 15)
                .addComponent(jLabel1)
                .addGap(44, 44, 44)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(38, 38, 38)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(jTextField2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(38, 38, 38)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(jTextField3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 35, Short.MAX_VALUE)
                .addComponent(jButton1)
                .addGap(18, 18, 18))
        );

        pack();
        setLocationRelativeTo(null);
    }                       

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt)throws IOException
    {                                        
            Record R = new Record();
        R.setDesignation(jTextField1.getText());
        R.setQuantity(Integer.valueOf(jTextField2.getText()));
        R.setUnitP(Double.valueOf(jTextField3.getText()));
        R.setTotal(Double.valueOf(jTextField3.getText())*Integer.valueOf(jTextField2.getText()));
        cl.getDetails().add(R);
        cl.setTotal(cl.getTotal()+R.getTotal());
        if(curr < max)
        {
            new Entryframe(curr+1,cl,max);
            this.setVisible(false);
            dispose();
        }
        else
        {
            //******************************************Fetching ID****************************************

      FileReader fr = new FileReader("resources\\Id.cfg");
      String r = "";
      int temp = fr.read();
      while(temp != -1)
      {
         r += Character.toString((char)temp);
         temp = fr.read();
      }
      int i = Integer.valueOf(r);
      fr.close();

      //*************************************Starting new Document**********************************************
      
      XWPFDocument document = new XWPFDocument();
      int choice=this.max;
      int rows = max(6,choice);
      
      fr = new FileReader("resources\\path.cfg");
      r = "";
      temp=fr.read();
        while(temp != -1)
        {
            r += Character.toString((char)temp);
            temp = fr.read();
        }
      FileOutputStream out = new FileOutputStream(new File(r+"\\FACTURE N°"+i+".docx"));
        
      //******************************************Setting Entete************************************************
      XWPFParagraph Entete = document.createParagraph();
      
      LinedText("PLACEHOLDER\nFOR ENTETE\nTHIS IS MEANT TO DISPLAY\nDETAILS ABOUT THE COMPANY", Entete);

      Entete.getRuns().get(0).setItalic(true);
      Entete.getRuns().get(0).setBold(true);
      Entete.getRuns().get(0).setFontSize(12);
      Entete.getRuns().get(0).setUnderline(UnderlinePatterns.SINGLE);

      XWPFParagraph DateFac = document.createParagraph();
      DateFac.setAlignment(ParagraphAlignment.RIGHT);
      XWPFRun DateFacRun = DateFac.createRun();
      String timeStamp = new SimpleDateFormat("dd/MM/yyyy").format(Calendar.getInstance().getTime());
      DateFacRun.setText("DATE DE FACTURATION: "+timeStamp);
      DateFacRun.setItalic(true);
      DateFacRun.setBold(true);
      DateFacRun.setUnderline(UnderlinePatterns.SINGLE);


      //******************************************Setting Title************************************************

      XWPFTable titleArea = document.createTable(1,1);
      titleArea.setWidth("100%");
      titleArea.getRow(0).getCell(0).setColor("e8e8e8");
      titleArea.getRow(0).getCell(0).setText("FACTURE N°"+i);
      titleArea.getRow(0).getCell(0).getParagraphs().get(0).setAlignment(ParagraphAlignment.CENTER);
      titleArea.getRow(0).getCell(0).getParagraphs().get(0).getRuns().get(0).setBold(true);
      titleArea.getRow(0).getCell(0).getParagraphs().get(0).getRuns().get(0).setFontFamily("Arial");
      titleArea.getRow(0).getCell(0).getParagraphs().get(0).getRuns().get(0).setFontSize(32);

      //*****************************************Client Detail Areaaa********************************************
      
      XWPFParagraph space1 = document.createParagraph();
      XWPFTable Client = document.createTable(1,1);
      Client.getRow(0).getCell(0).setWidth("4000");
      Client.setTableAlignment(TableRowAlign.RIGHT);
      //Client.getRow(0).getCell(0).setText("");
      LinedText("NOM CLIENT: "+cl.getPrenom()+" "+cl.getNom()+"\nADRESSE: "+cl.getAdresse()+"\nMF: "+cl.getMF(), Client.getRow(0).getCell(0).getParagraphs().get(0));
      Client.getRow(0).getCell(0).getParagraphs().get(0).setAlignment(ParagraphAlignment.LEFT);
      Client.getRow(0).getCell(0).getParagraphs().get(0).getRuns().get(0).setItalic(true);
      Client.getRow(0).getCell(0).getParagraphs().get(0).getRuns().get(0).setUnderline(UnderlinePatterns.SINGLE);
      Client.getRow(0).getCell(0).getParagraphs().get(0).getRuns().get(0).setFontSize(16);
      

      //****************************************Receipt Detail Areea********************************************
      XWPFParagraph space2 = document.createParagraph();
      
      XWPFTable table = document.createTable(rows,4);
      
      XWPFTableRow CurrRow = table.getRow(0);
      CurrRow.getCell(0).setWidth("1000");
      CurrRow.getCell(0).setText("Quantité");
      CurrRow.getCell(0).getParagraphs().get(0).setAlignment(ParagraphAlignment.CENTER);

      CurrRow.getCell(1).setWidth("5250");
      CurrRow.getCell(1).setText("Désigniation");
      CurrRow.getCell(1).getParagraphs().get(0).setAlignment(ParagraphAlignment.CENTER);

      CurrRow.getCell(2).setWidth("1750");
      CurrRow.getCell(2).setText("Prix Unitaire HT");
      CurrRow.getCell(2).getParagraphs().get(0).setAlignment(ParagraphAlignment.CENTER);
   
      CurrRow.getCell(3).setWidth("1500");
      CurrRow.getCell(3).setText("Prix Total HT");
      CurrRow.getCell(3).getParagraphs().get(0).setAlignment(ParagraphAlignment.CENTER);
      
      for(int l=0;l<choice;l++)
      {
         CurrRow = table.getRow(l+1);
         CurrRow.getCell(0).setText(Integer.toString(cl.getDetails().get(l).getQuantity()));
         CurrRow.getCell(1).setText(cl.getDetails().get(l).getDesignation());
         CurrRow.getCell(2).setText(Double.toString(doubleformat(cl.getDetails().get(l).getUnitP(), 3))+" DT");
         CurrRow.getCell(3).setText(Double.toString(doubleformat(cl.getDetails().get(l).getTotal(), 3))+" DT");
         for(int k=0;k<4;k++)
         {
            CurrRow.getCell(k).getParagraphs().get(0).setAlignment(ParagraphAlignment.CENTER);
         }
      } 

      //****************************************Total Detail Area********************************************

      XWPFParagraph space3 = document.createParagraph();
      XWPFTable Total = document.createTable(3,2);
      Total.setTableAlignment(TableRowAlign.RIGHT);
      Total.getRow(0).getCell(0).setText("Total HT");
      Total.getRow(0).getCell(0).setWidth("1750");
      Total.getRow(0).getCell(1).setText(Double.toString(cl.getTotal()) +" DT");
      Total.getRow(0).getCell(1).setWidth("1450");
      Total.getRow(1).getCell(0).setText("Timbre");
      Total.getRow(1).getCell(1).setText("1.000 DT");
      Total.getRow(2).getCell(0).setText("Total TTC");
      Total.getRow(2).getCell(1).setText(Double.toString(cl.getTotal()+1)+" DT");
      Total.getRow(2).getCell(0).getParagraphs().get(0).getRuns().get(0).setBold(true);
      Total.getRow(2).getCell(1).getParagraphs().get(0).getRuns().get(0).setBold(true);

      //*************************************************La Signature********************************************

      XWPFParagraph signature = document.createParagraph();
      signature.setAlignment(ParagraphAlignment.RIGHT);
      LinedText("\n\nCachet et Signature", signature);
      signature.getRuns().get(0).setFontSize(16);

      //************************************Closing/Saving Receipt Document***********************************************

      document.write(out);
      document.close();
      out.close();

      //****************************************Updating ID**********************************************

      String newID = Integer.toString(i+1);
      PrintWriter updater = new PrintWriter(new File("resources\\Id.cfg"));
      updater.append(newID);
      updater.flush();
      updater.close();
      new Successframe(i);
      dispose();
   }
        
        
    }                                        

                   
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JTextField jTextField1;
    private javax.swing.JTextField jTextField2;
    private javax.swing.JTextField jTextField3;
    private javax.swing.JButton jButton1;                 
}
