import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.util.Random;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.Timer;

public class NewJPanel extends javax.swing.JPanel implements ActionListener {

    int ancho = 800, alto = 600, xpelota, ypelota,
        score1 = 0, score2 = 0, xbarra1, xbarra2, ybarra1, ybarra2, ganador, jugar;
    Timer timer;
    JLabel score;
    JLabel lblscore2;
    char direction1 = 's', direction2 = 's'; 
    int random = (int)(Math.random()*4);
    //String direccionesPelota [] = {"r","l","ur","ul","dr","dl"};
    String direccionesPelota [] = {"ur","ul","dr","dl"};        
    String dPelota = direccionesPelota[random];
    
    
    public NewJPanel() {
        initComponents();
        setSize(ancho, alto);
        setBackground(Color.white);
        setFocusable(true);
        requestFocus();
         
        
        xbarra1 = 40; 
        xbarra2 = 740; 
        ybarra1 = 240;
        ybarra2 = 240;

        xpelota = 400;
        ypelota = 300;
        timer = new Timer(20, (ActionListener) this);
        timer.start();
    }

    public void paint(Graphics g) {
        
            super.paint(g);

            g.setColor(Color.black);
            g.fillRect(xbarra1, ybarra1, 20, 120);
            g.fillRect(xbarra2, ybarra2, 20, 120);

            g.setColor(Color.RED);
            g.fillRect(xpelota, ypelota, 20, 20);
             
            Graphics2D g2 = (Graphics2D) g;
            g2.setColor(Color.white);
            g2.setStroke(new BasicStroke (15));
            g2.drawLine(0, 40, 800, 40);
            g2.drawLine(0, 580, 800, 580);
            

    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                formKeyPressed(evt);
            }
            public void keyReleased(java.awt.event.KeyEvent evt) {
                formKeyReleased(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 400, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 300, Short.MAX_VALUE)
        );
    }// </editor-fold>//GEN-END:initComponents

    private void formKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_formKeyPressed
       
        switch (evt.getKeyCode()) {
            case KeyEvent.VK_I:
                    direction2 = 'u';
                break;
                
            case KeyEvent.VK_K:
                    direction2 = 'd';
                break;
                
            case KeyEvent.VK_W:
                    direction1 = 'u';
                break;
                
            case KeyEvent.VK_S:
                    direction1 = 'd';
                break; 
                
        }
    }//GEN-LAST:event_formKeyPressed

    private void formKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_formKeyReleased
    
    }//GEN-LAST:event_formKeyReleased

    @Override
    public void actionPerformed(ActionEvent ae)  {
       
       if (score1 != 5 && score2!= 5){
           
       if (xpelota <= 15){
           
           score2 +=1;
           xpelota = 400;
           ypelota = 300;
           dPelota = direccionesPelota[random];
           
       } else if (xpelota >= 755){
           score1 +=1;
           xpelota = 400;
           ypelota = 300;
           dPelota = direccionesPelota[random];
       }
       
       if(ypelota == 45){
           if(dPelota == "ur"){
               dPelota = "dr";
           } else dPelota = "dl";
       }else if (ypelota == 560){
           if(dPelota == "dr"){
               dPelota = "ur";
           } else dPelota = "ul";
       }
       if (ypelota <= ybarra1+120 && ypelota >= ybarra1){
           if(xpelota >= xbarra1 && xpelota <= xbarra1+10 ){
               if (dPelota == "ul") dPelota = "ur";
               else dPelota = "dr"; 
           }  
       }else if (ypelota <= ybarra2+120 && ypelota >= ybarra2){
           if(xpelota >= xbarra2-10 && xpelota <= xbarra2+10 ){
               if (dPelota == "ur") dPelota = "ul";
               else dPelota = "dl"; 
           }
       }
       if (ybarra1 >= 50 && ybarra1 <= 450){
           if (direction1 == 'd') ybarra1 += 10;
           else if (direction1 == 'u') ybarra1 -=10;
       } else if (ybarra1 <50){
           if (direction1 == 'd') ybarra1 += 10;
       }else if (ybarra1 > 450){
           if (direction1 == 'u') ybarra1 -= 10;
       }
       
       if (ybarra2>=50 && ybarra2 <= 450){
           if (direction2 == 'd') ybarra2 += 10;
           else if (direction2 == 'u') ybarra2 -=10;
       } else if (ybarra2 <50){
           if (direction2 == 'd') ybarra2 += 10;
       }else if (ybarra2 > 450){
           if (direction2 == 'u') ybarra2 -= 10;
       }
       
       switch (dPelota){
           case "r":
               xpelota += 5;
               break;
               
           case "l": 
               xpelota +=5;
               break;
               
           case "ur":
               xpelota +=5;
               ypelota -= 5;
               break;
               
           case "ul":
               xpelota -=5;
               ypelota -= 5;
               break;
               
           case "dr":
               xpelota +=5;
               ypelota += 5;
               break;
               
           case "dl":
               xpelota -=5;
               ypelota += 5;
               break;
       }
       
       
      repaint();
      
       }
       else{
           if (score1 == 5) ganador = 1;
           else ganador = 2;
           
           JOptionPane.showMessageDialog(this, "Fin del partido "+ "\n" +"\n"+ " ganador: " + ganador  + "\n" +score1+" - " + score2 ,null, JOptionPane.PLAIN_MESSAGE);
            jugar = JOptionPane.showConfirmDialog(this, "Volver a jugar", null, JOptionPane.YES_NO_OPTION);
            if (jugar == 1) {
                System.exit(0);
            }
           score1 = 0; 
           score2 = 0;
           xpelota = 400;
           ypelota = 300;
           xbarra1 = 40; 
           xbarra2 = 740; 
           ybarra1 = 240;
           ybarra2 = 240;
           dPelota = direccionesPelota[random];
       }
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    // End of variables declaration//GEN-END:variables
}
