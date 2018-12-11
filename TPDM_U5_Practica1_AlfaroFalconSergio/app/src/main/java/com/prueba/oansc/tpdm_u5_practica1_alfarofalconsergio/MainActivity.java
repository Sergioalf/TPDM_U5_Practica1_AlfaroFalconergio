package com.prueba.oansc.tpdm_u5_practica1_alfarofalconsergio;

import android.graphics.Canvas;
import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import android.service.autofill.LuhnChecksumValidator;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    SensorManager sensorManager;
    Sensor gravedad, luz;
    SensorEventListener oyenteGravedad, oyenteLuz;
    Lienzo lienzo;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        lienzo = new Lienzo(this);
        setContentView(lienzo);

        sensorManager = (SensorManager)getSystemService(SENSOR_SERVICE);
        gravedad = sensorManager.getDefaultSensor(Sensor.TYPE_GRAVITY);
        luz = sensorManager.getDefaultSensor(Sensor.TYPE_LIGHT);

        if (luz == null) {
            Toast.makeText(this, "No hay sensor de Luz", Toast.LENGTH_LONG).show();
        } else {
            oyenteLuz = new SensorEventListener() {
                @Override
                public void onSensorChanged(SensorEvent event) {
                    int valor = (int)(event.values[0]);
                    if (valor == 0) {
                        lienzo.hayLuz = false;
                    } else {
                        lienzo.hayLuz =true;
                    }
                    lienzo.invalidate();
                }

                @Override
                public void onAccuracyChanged(Sensor sensor, int accuracy) {

                }
            };
        }

        if (gravedad == null) {
            Toast.makeText(this, "No hay sensor de gravedad", Toast.LENGTH_LONG).show();
        } else {
            oyenteGravedad = new SensorEventListener() {
                @Override
                public void onSensorChanged(SensorEvent event) {
                    lienzo.nuevaX = ((int)event.values[0]) * 10;
                    lienzo.nuevaY = ((int)event.values[1]) * 10;
                    lienzo.invalidate();
                }

                @Override
                public void onAccuracyChanged(Sensor sensor, int accuracy) {

                }
            };
        }
    }

    protected void onResume(){
        super.onResume();
        //Se ejecuta cuando la app se encuentra en pantalla
        if(gravedad != null){
            sensorManager.registerListener(oyenteGravedad,gravedad,SensorManager.SENSOR_DELAY_NORMAL);
        }
        if(luz != null){
            sensorManager.registerListener(oyenteLuz,luz,SensorManager.SENSOR_DELAY_NORMAL);
        }
    }

    protected void onPause(){
        super.onPause();
        //Se ejecuta cuando la app pierde pantalla
        if (gravedad != null){
            sensorManager.unregisterListener(oyenteGravedad);
        }
        if (luz != null){
            sensorManager.unregisterListener(oyenteLuz);
        }
    }

}
