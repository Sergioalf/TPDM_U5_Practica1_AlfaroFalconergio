package com.prueba.oansc.tpdm_u5_practica1_alfarofalconsergio;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.view.View;

public class Lienzo extends View {

    int x, y, nuevaX, nuevaY;
    boolean primeraVez, hayLuz;

    public Lienzo(Context context) {
        super(context);
        x = nuevaX = 0;
        y = nuevaY = 0;
        primeraVez = true;
        hayLuz = true;
    }

    public void onDraw (Canvas c) {
        Paint p = new Paint();

        if (primeraVez) {
            x = c.getWidth()/2;
            y = c.getHeight()/2;
            primeraVez = false;
        }

        if ((x >= 150 && x <= c.getWidth() - 150) || (x - nuevaX > 150 && x - nuevaX < c.getWidth() - 150)){
            x -= nuevaX;
        }
        if ((y >= 150 && y <= c.getHeight() - 150) || (y + nuevaY > 150 && y + nuevaY < c.getHeight() - 150)) {
            y += nuevaY;
        }

        if (hayLuz) {
            //---------------Fondo-------------
            c.drawColor(Color.argb(255,79, 142, 242));
            //---------------Sol----------------
            p.setStyle(Paint.Style.FILL);
            p.setColor(Color.argb(255, 249, 233, 2));
            c.drawCircle(x, y, 150, p);
            p.setColor(Color.argb(100, 216, 255, 0));
            c.drawCircle(x, y, 300, p);
            p.setStyle(Paint.Style.STROKE);
            p.setStrokeWidth(10f);
            p.setColor(Color.argb(255, 109, 109, 5));
            c.drawCircle(x, y, 150, p);
            p.setColor(Color.argb(255, 216, 255, 0));
            c.drawCircle(x, y, 300, p);
            //---------------Suelo----------------
            p.setStyle(Paint.Style.FILL);
            p.setColor(Color.argb(255, 10, 145, 2));
            c.drawRect(0, c.getHeight()-300, c.getWidth(), c.getHeight(),p);
            p.setStyle(Paint.Style.STROKE);
            p.setStrokeWidth(10f);
            p.setColor(Color.argb(255, 6, 96, 0));
            c.drawLine(0, c.getHeight()-300, c.getWidth(), c.getHeight()-300, p);
            //----------------Tronco--------------
            p.setStyle(Paint.Style.FILL);
            p.setColor(Color.argb(255, 89, 14, 14));
            c.drawRect(c.getWidth()-300, c.getHeight()-450, c.getWidth()-150, c.getHeight()-150,p);
            p.setStyle(Paint.Style.STROKE);
            p.setStrokeWidth(10f);
            p.setColor(Color.argb(255, 61, 0, 0));
            c.drawRect(c.getWidth()-300, c.getHeight()-450, c.getWidth()-150, c.getHeight()-150,p);
            //-----------------Hojas-----------------
            p.setStyle(Paint.Style.FILL);
            p.setColor(Color.argb(255, 10, 145, 2));
            c.drawCircle(c.getWidth()-225, c.getHeight()-700, 300, p);
            p.setStyle(Paint.Style.STROKE);
            p.setStrokeWidth(10f);
            p.setColor(Color.argb(255, 6, 96, 0));
            c.drawCircle(c.getWidth()-225, c.getHeight()-700, 300, p);
            //-----------------Nubes----------------------
            p.setStyle(Paint.Style.FILL);
            p.setColor(Color.argb(255, 236, 242, 205));
            c.drawCircle(80, 500, 250, p);
            c.drawCircle(325, 550, 150, p);
        } else {
            //------------------Fondo--------------------
            c.drawColor(Color.argb(255, 18, 18, 20));
            //------------------Estrellas---------------
            p.setStyle(Paint.Style.FILL);
            p.setColor(Color.WHITE);
            c.drawCircle(100, 100, 5, p);
            c.drawCircle(325, 200, 5, p);
            c.drawCircle(720, 250, 5, p);
            c.drawCircle(375, 50, 5, p);
            c.drawCircle(900, 250, 5, p);
            c.drawCircle(952, 400, 5, p);
            c.drawCircle(156, 200, 5, p);
            c.drawCircle(200, 350, 5, p);
            c.drawCircle(135, 400, 5, p);
            c.drawCircle(158, 200, 5, p);
            c.drawCircle(300, 350, 5, p);
            c.drawCircle(c.getWidth() - 100, 151, 5, p);
            c.drawCircle(c.getWidth() - 450, 200, 5, p);
            c.drawCircle(c.getWidth() - 785, 320, 5, p);
            c.drawCircle(c.getWidth() - 123, 152, 5, p);
            c.drawCircle(c.getWidth() - 200, 265, 5, p);
            c.drawCircle(c.getWidth() - 125, 354, 5, p);
            c.drawCircle(c.getWidth() - 600, 452, 5, p);
            //------------------Luna----------------------
            p.setStyle(Paint.Style.FILL);
            p.setColor(Color.argb(255, 206, 206, 200));
            c.drawCircle(x, y, 150, p);
            p.setColor(Color.argb(200, 255, 255, 255));
            c.drawCircle(x, y, 300, p);
            p.setColor(Color.argb(255, 135, 135, 124));
            c.drawCircle(x+60, y+40, 50, p);
            c.drawCircle(x+95, y-50, 25, p);
            c.drawCircle(x+35, y-40, 15, p);
            p.setStyle(Paint.Style.STROKE);
            p.setStrokeWidth(10f);
            c.drawCircle(x, y, 150, p);
            c.drawCircle(x+60, y+40, 50, p);
            c.drawCircle(x+95, y-50, 25, p);
            c.drawCircle(x+35, y-40, 15, p);
            //---------------Suelo----------------
            p.setStyle(Paint.Style.FILL);
            p.setColor(Color.argb(255, 114, 249, 125));
            c.drawRect(0, c.getHeight()-300, c.getWidth(), c.getHeight(),p);
            p.setStyle(Paint.Style.STROKE);
            p.setStrokeWidth(10f);
            p.setColor(Color.argb(255, 6, 96, 0));
            c.drawLine(0, c.getHeight()-300, c.getWidth(), c.getHeight()-300, p);
            //----------------Tronco--------------
            p.setStyle(Paint.Style.FILL);
            p.setColor(Color.argb(255, 135, 79, 79));
            c.drawRect(c.getWidth()-300, c.getHeight()-450, c.getWidth()-150, c.getHeight()-150,p);
            p.setStyle(Paint.Style.STROKE);
            p.setStrokeWidth(10f);
            p.setColor(Color.argb(255, 61, 0, 0));
            c.drawRect(c.getWidth()-300, c.getHeight()-450, c.getWidth()-150, c.getHeight()-150,p);
            //-----------------Hojas-----------------
            p.setStyle(Paint.Style.FILL);
            p.setColor(Color.argb(255, 114, 249, 125));
            c.drawCircle(c.getWidth()-225, c.getHeight()-700, 300, p);
            p.setStyle(Paint.Style.STROKE);
            p.setStrokeWidth(10f);
            p.setColor(Color.argb(255, 6, 96, 0));
            c.drawCircle(c.getWidth()-225, c.getHeight()-700, 300, p);
        }

    }

}
