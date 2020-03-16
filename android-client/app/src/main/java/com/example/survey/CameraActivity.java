package com.example.survey;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;
//import com.google.android.gms.vision.CameraSource;
import android.Manifest;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.os.Bundle;
import android.util.SparseArray;
import android.view.SurfaceHolder;
import android.view.SurfaceView;
import android.widget.TextView;
;import com.google.android.gms.vision.CameraSource;
import com.google.android.gms.vision.Detector;
import com.google.android.gms.vision.barcode.Barcode;
import com.google.android.gms.vision.barcode.BarcodeDetector;

import java.io.IOException;

public class CameraActivity extends AppCompatActivity {
    private SurfaceView CameraSurface;
    private TextView CameraText;

    private com.google.android.gms.vision.CameraSource CameraSource;
    private com.google.android.gms.vision.barcode.BarcodeDetector BarcodeDetector;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_camera);

        //implement objects:
        CameraSurface=findViewById(R.id.camera_surface);
        CameraText=findViewById(R.id.camera_text);
        BarcodeDetector = new BarcodeDetector.Builder(this)
                .setBarcodeFormats(Barcode.QR_CODE).build();
        CameraSource=new CameraSource.Builder(this,BarcodeDetector)
                .setRequestedPreviewSize(300,300).build();



        CameraSurface.getHolder().addCallback(new SurfaceHolder.Callback(){
            @Override
            public void surfaceCreated(SurfaceHolder holder) {
                if(ActivityCompat.checkSelfPermission(getApplicationContext(), Manifest.permission.CAMERA)
                        != PackageManager.PERMISSION_GRANTED)
                    return;
                try{
                    CameraSource.start(holder);
                }catch (IOException e){
                    e.printStackTrace();
                }
            }

            @Override
            public void surfaceChanged(SurfaceHolder holder, int format, int width, int height) {

            }

            @Override
            public void surfaceDestroyed(SurfaceHolder holder) {
                CameraSource.stop();
            }
        });


        BarcodeDetector.setProcessor(new Detector.Processor<Barcode>(){

            @Override
            public void release() {

            }

            @Override
            public void receiveDetections(Detector.Detections<Barcode> detections) {
                final SparseArray<Barcode> qrCodes=detections.getDetectedItems();
                if(qrCodes.size()!=0){
                    CameraText.post(new Runnable() {
                        @Override
                        public void run() {
                            CameraText.setText(qrCodes.valueAt(0).displayValue);
                        }
                    });
                }
            }
        });
    }
    public void backFromCamera(android.view.View v){
        Intent intent = new Intent(this, MainActivity.class);
        startActivity(intent);
    }
}
