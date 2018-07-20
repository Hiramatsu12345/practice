package com.hiramatsu.game.action;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionListener;

public class RacketGameAction extends java.applet.Applet implements Runnable,MouseMotionListener {

	int speed=30;//表示時間
	int num=3;//ボールの残数
	int bx,by;//ボールの位置(x座標、y座標)
	int rx=60,ry=150;//ラケットの位置(x座標、y座標)
	int ballWidth=8,ballHeight=8;//ボールの絵の幅、高さ
	int racketWidth=30,racketHeight=4;//ラケットの絵の幅、高さ
	int margin=8;//端まで行かないよう余裕を取る
	int score;//点数

	boolean loop=true;//繰り返すための変数
	Thread kicker=null;//アニメーションのためのスレッド変数

	Dimension d;//表示領域
	Image offs;//オフスクリーン
	Graphics grf;

	public void init(){
		/*オフスクリーンの設定*/
		d=getSize();//表示領域の取得
		offs=createImage(d.width, d.height);
		grf=offs.getGraphics();

		/*ボールの初期位置の設定*/
		bx=margin+(int)(Math.random()*(float)(d.width-(margin*2+ballWidth+1)));
		by=50;

		/*マウスモーションリスナとして自分自身を登録*/
		addMouseMotionListener(this);
	}
	public void paint(Graphics g){
		update(g);
	}
	public void update(Graphics g){
		/*バックをオレンジで塗る*/
		grf.setColor(Color.orange);
		grf.fillRect(0,0,d.width,d.height);
		grf.setColor(Color.green);
		grf.fillRect(margin, margin, d.width-margin*2, d.height-margin*2);

		/*ラケットを描く*/
		grf.setColor(Color.white);
		grf.fillRect(rx, ry, racketWidth, racketHeight);

		/*ボールを描く*/
		grf.setColor(Color.yellow);
		grf.fillOval(bx, by, ballWidth, ballHeight);
		grf.setColor(Color.black);
		grf.fillOval(bx, by, ballWidth, ballHeight);

		/*点数の表示*/
		grf.setColor(Color.black);
		grf.drawString("Score:"+score,12,12);
		if(num<0){
			grf.setColor(Color.black);
			grf.drawString("GAME OVER !",20,80);
		}
		/*オフスクリーンのイメージを一挙に実際の表示領域に描く*/
		g.drawImage(offs, 0, 0, this);
	}
	public void mouseDragged(MouseEvent e){
		/*マウスが押されてドラッグされた*/
	}
	public void mouseMoved(MouseEvent e){
		/*マウスが移動した*/
		rx=e.getX();//ラケットの位置の更新

		/*ラケットがコートを出ないための処理*/
		if(rx<margin){
			rx=margin;
		}
		if(rx+racketWidth > d.width-margin){
			rx=d.width-margin-racketWidth;
		}
		repaint();
	}
	public void start(){
		if(kicker==null){
			/*スレッドを実行させる*/
			kicker=new Thread(this);
			kicker.start();
		}
	}
	public void stop(){
		/*スレッドを止める*/
		kicker=null;
	}
	public void run(){
		int dx=5,dy=5;//ボールの進む量(x増分、y増分)

		/*実行中のスレッドをチェック*/
		Thread thisThread=Thread.currentThread();

		/*繰り返し*/
		while(loop && kicker==thisThread){
			/*ラケットに当たったときの処理*/
			if(by+ballHeight>=ry && by+ballHeight<=ry+racketHeight && bx+ballWidth>=rx &&
					bx<=rx+racketWidth){
				/*ラケットに当たったら上へ返す*/
				dy=-5;
				if(bx<rx || bx+ballWidth>rx+racketWidth){
					/*ラケットの端に当たった時*/
					if(dx==0){
						/*垂直に来たボール*/
						if(bx<rx){
							/*左端に当たったら左斜め上に返す*/
							dx=-5;//左斜め上に返す
						}
						if(bx+ballWidth>rx+racketWidth){
							/*右端に当たったら右斜め上に返す*/
							dx=+5;
						}
					}
					else{
						/*斜めに来たボールは垂直に返す*/
						dx=0;
					}
				}
				score=score+1;//得点の加算
			}
			/*左端、右端、上端に来たときの処理*/
			if(bx<0+margin){
				/*左端に来たら反転*/
				dx=5;
			}
			if(bx+ballWidth>d.width-margin){
				/*右端に来たら反転*/
				dx=-5;
			}
			if(by<0+margin){
				/*上端に来たら反転*/
				dy=5;
			}
			/*ラケットの下へ行ったときの処理*/
			if(by+ballHeight>d.height-margin){
				/*下端に来たらボールを初期位置へ*/
				bx=margin+(int)(Math.random()*(float)(d.width-(margin*2+ballWidth+1)));
				by=50;
				num=num-1;//ボールの残数を減らす
			}
			/*ゲーム終了の判定*/
			if(num<0){
				loop=false;
			}
			bx=bx+dx;
			by=by+dy;

			repaint();

			try{
				Thread.sleep(speed);
			}
			catch(InterruptedException e){}
		}
	}
}
