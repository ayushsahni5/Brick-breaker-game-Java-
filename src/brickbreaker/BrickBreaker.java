/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package brickbreaker;

import javax.swing.*;
import java.awt.event.*;
import java.awt.*;


public class BrickBreaker extends JFrame {

    
    int flag=55;
    int count_dots=0;
    boolean gameOver=false;
    boolean upDirection=true;
    boolean rightDirection=true;
    boolean leftDirection=false;
    boolean downDirection=false;
    int ball_x=0;
    int ball_y=640;
    int racket_x,racket_y=660;
    int frameSize_x=966,frameSize_y=710;
    JFrame frame;
    int[][] dots;
    MyDrawPanel drawPanel;
    public void makeFrame()
    {

        frame=new JFrame("BRICK  BREAKER  GAME");
        frame.setSize(frameSize_x,frameSize_y);
        frame.setResizable(false);
        frame.setLocationRelativeTo(null);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        drawPanel=new MyDrawPanel();
        frame.getContentPane().add(drawPanel);
        frame.setVisible(true);
        System.out.println(frame.getInsets());
        drawPanel.getInputMap().put(KeyStroke.getKeyStroke("RIGHT"), "moveRight");
        drawPanel.getActionMap().put("moveRight",new Myaction(2));
        drawPanel.getInputMap().put(KeyStroke.getKeyStroke("LEFT"),"moveLeft");
        drawPanel.getActionMap().put("moveLeft", new Myaction(1));
        while(!gameOver && count_dots!=196){
        try{
          move();
          Thread.sleep(65);
         }catch(Exception ex){}}
            
    }
    private void move()
    {
    
      if(upDirection && rightDirection)
      {
         if(ball_x==940)
           {
             rightDirection=false;
             leftDirection=true;
           }
         if(ball_y==0)
         {
           upDirection=false;
           downDirection=true;
         }
         else{
         if(ball_y<=80)
           {
                  if(dots[ball_y/20-1][ball_x/20]==0)
                  {
                  upDirection=false;
                  downDirection=true;
                  dots[ball_y/20-1][ball_x/20]=1;
                  count_dots++;
                  }
                  else if(dots[ball_y/20-1][ball_x/20+1]==0)
                  {
                   upDirection=false;
                   downDirection=true;
                   rightDirection=false;
                   leftDirection=true;
                   dots[ball_y/20-1][ball_x/20+1]=1;
                   count_dots++;
                  }
                try{if(dots[ball_y/20][(ball_x)/20+1]==0)
                  {
                   rightDirection=false;
                   leftDirection=true;
                   dots[ball_y/20][(ball_x)/20+1]=1;
                   count_dots++;
                  }}catch(Exception ex){}
            }
         }
      }
      if(upDirection && leftDirection)
      {
        if(ball_x==0)
        {
          leftDirection=false;
          rightDirection=true;
        }
         if(ball_y<=80)
           {
                if(ball_y==0)
                  {
                   upDirection=false;
                   downDirection=true;
                  }
                
             try{if(dots[ball_y/20-1][ball_x/20]==0)
             {
                  upDirection=false;
                  downDirection=true;
                  dots[ball_y/20-1][ball_x/20]=1;
                  count_dots++;
              }             }catch(Exception ex){}
              
             try{if(dots[ball_y/20][(ball_x)/20-1]==0 )
                  {
                   rightDirection=true;
                   leftDirection=false;
                   dots[ball_y/20][(ball_x)/20-1]=1;
                   count_dots++;
                  }}catch(Exception ex){}
               
              try{if(dots[ball_y/20-1][ball_x/20-1]==0 && !(downDirection) && !(rightDirection))
                  {
                   upDirection=false;
                   downDirection=true;
                   rightDirection=true;
                   leftDirection=false;
                   dots[ball_y/20-1][ball_x/20-1]=1;
                   count_dots++;
                  }           }catch(Exception ex){}
            
              if(upDirection && rightDirection)
              {
                   try{if(dots[ball_y/20-1][(ball_x)/20+1]==0 )
                   {
                    upDirection=false;
                   downDirection=true;
                   rightDirection=false;
                   leftDirection=true;
                   dots[ball_y/20-1][(ball_x)/20+1]=1;
                   count_dots++;
                   }
                       }catch(Exception ex){}
              }
           }
      }
      if(downDirection && rightDirection)
      {
        if(ball_y==660)
            gameOver=true;
          
        if(ball_x==940)
        {
          rightDirection=false;
          leftDirection=true;
          
        }
        if(ball_y<=60)
        {
        try{if(dots[ball_y/20][(ball_x)/20+1]==0)
                  {
                   rightDirection=false;
                   leftDirection=true;
                   dots[ball_y/20][(ball_x)/20+1]=1;
                   count_dots++;
                  }}catch(Exception ex){}
        try{if(dots[ball_y/20+1][ball_x/20+1]==0 && !leftDirection)
        {
           downDirection=false;
           upDirection=true;
           leftDirection=true;
           rightDirection=false;
           dots[ball_y/20+1][ball_x/20+1]=1;
           count_dots++;
           if(ball_y-20<0)
           {
              upDirection=false;
              downDirection=true;
           }
           if(ball_x-20<0)
           {
              leftDirection=false;
              rightDirection=true;
           }
        }
            }catch(Exception ex){}
        }
        if(ball_y==640 && ball_x>=racket_x && ball_x<=racket_x+100)
        {
          downDirection=false;
          upDirection=true;
        }
      }
      
      if(downDirection && leftDirection)
      {
       if(ball_y==660)
       gameOver=true;
          
       if(ball_y<=60)
       {
       try{if(dots[ball_y/20][(ball_x)/20-1]==0)
        {
                   rightDirection=true;
                   leftDirection=false;
                   dots[ball_y/20][(ball_x)/20-1]=1;
                   count_dots++;
        }              }catch(Exception ex){}
       try{if(dots[ball_y/20+1][ball_x/20]==0)
       {
                   downDirection=false;
                   upDirection=true;
                   dots[ball_y/20+1][ball_x/20]=1;
                   count_dots++;
       }               }catch(Exception ex){}
       try{if(dots[ball_y/20+1][ball_x/20-1]==0)
       {
                   downDirection=false;
                   upDirection=true;
                   leftDirection=false;
                   rightDirection=true;
                   dots[ball_y/20+1][ball_x/20-1]=1;
                   count_dots++;
                   if(ball_y-20<0)
                   {
                      upDirection=false;
                      downDirection=true;
                   }
       }               }catch(Exception ex){}
       }
       
       if(ball_y==640 && ball_x>=racket_x && ball_x<=racket_x+100)
        {
          downDirection=false;
          upDirection=true;
        }
       if(ball_x==0)
       {
          leftDirection=false;
          rightDirection=true;
       }
      }
      if(upDirection==true)
      {ball_y-=20;}
      if(downDirection==true)
      {ball_y+=20;}
      if(rightDirection==true)
      {ball_x+=20;}
      if(leftDirection==true)
      {ball_x-=20;}      
        
     drawPanel.repaint();
    }
    
    
    private class Myaction extends AbstractAction
    {
        int p;
     private Myaction(int p)
     {
      this.p=p;
     }
     @Override
     public void actionPerformed(ActionEvent e)
     {
      if(p==2 && racket_x<=frameSize_x-110)
      {
       racket_x+=30;
       drawPanel.repaint();
      }
      if(p==1 && racket_x>=20)
      {
       racket_x-=30;
       drawPanel.repaint();
      }
     }
    }
    
    public static void main(String[] args) {
    
        BrickBreaker obj=new BrickBreaker();
        obj.dots=new int[4][990];
        obj.makeFrame();
       
    }
    
    
    
    public class MyDrawPanel extends JPanel
    {
        public void paintComponent(Graphics g)
        {
            g.setColor(Color.black);
            g.fillRect(0,0,this.getWidth(), this.getHeight());
            g.setColor(Color.gray.darker());
            g.fillRect(racket_x,racket_y,100,20);
            g.setColor(Color.red.darker());
            
            for(int i=0;i<4;i++)
            {
                for(int j=0;j<48;j++)
                {
                 if(dots[i][j]==0)
                  {
                   g.fillRect(j*20, i*20, 20, 20);
                  }
                }
            }
            
            for(int i=1;i<48;i++)
            {
              g.setColor(Color.black);
              g.fillRect(i*20,0,1,80);
            }
            for(int i=1;i<4;i++)
            {
              g.fillRect(0,i*20,986,1);
            }
            
            if(flag>0){
            g.setColor(Color.white);
            Font small = new Font("Helvetica", Font.PLAIN, 88);
            g.setFont(small);
            g.drawString("B R I C K B R E A K E R",0, 75);flag--;}
            g.setColor(Color.white);
            g.fillOval(ball_x,ball_y,20,20);
            g.setColor(Color.green.darker());
            Font f2=new Font("Helvetica",Font.BOLD,15);
            g.setFont(f2);
            g.drawString("SCORE"+" "+count_dots*10,850,100);
            Font f1=new Font("Helvetica",Font.PLAIN,30);
            g.setColor(Color.white);
            if(gameOver)
             {
               g.setFont(f1);
               g.drawString("GAME OVER",400,300);
             }
            if(count_dots==196)
             {
               g.setFont(f1);
               g.drawString("GAME COMPLETED",350,300);
             }
           
        }
    }
    
}
