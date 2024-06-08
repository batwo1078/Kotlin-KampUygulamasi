package com.mrcaracal.havadurumumrc.view

import android.content.Context
import android.hardware.Sensor
import android.hardware.SensorEvent
import android.hardware.SensorEventListener
import android.hardware.SensorManager
import android.os.Bundle
import android.widget.ImageView
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import com.mrcaracal.havadurumumrc.R
import kotlinx.android.synthetic.main.activity_pusula2.*

class Activity_pusula : AppCompatActivity(), SensorEventListener {

    private lateinit var sensorManager: SensorManager
    private var accelerometer: Sensor? = null
    private var magnetometer: Sensor? = null

    private val accelerometerReading = FloatArray(3)
    private val magnetometerReading = FloatArray(3)

    private val rotationMatrix = FloatArray(9)
    private val orientationValues = FloatArray(3)

    private lateinit var compassBackground: ImageView
    private lateinit var compassNeedle: ImageView
    private lateinit var directionMarker: ImageView
    private lateinit var northText: TextView
    private lateinit var eastText: TextView
    private lateinit var southText: TextView
    private lateinit var westText: TextView
    private lateinit var compassText: TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_pusula2)




       // compassBackground = findViewById(R.id.compassBackground)
        //compassNeedle = findViewById(R.id.compassNeedle)
       // directionMarker = findViewById(R.id.directionMarker)

        compassText = findViewById(R.id.compassText)


        sensorManager = getSystemService(Context.SENSOR_SERVICE) as SensorManager
        accelerometer = sensorManager.getDefaultSensor(Sensor.TYPE_ACCELEROMETER)
        magnetometer = sensorManager.getDefaultSensor(Sensor.TYPE_MAGNETIC_FIELD)

        if (accelerometer == null || magnetometer == null) {
            compassText.text = "Cihazınızda ivmeölçer veya manyetometre sensörü bulunmuyor."
            finish()
        }

        geribtn.setOnClickListener{
            finish()
        }


    }

    override fun onResume() {
        super.onResume()
        sensorManager.registerListener(this, accelerometer, SensorManager.SENSOR_DELAY_NORMAL)
        sensorManager.registerListener(this, magnetometer, SensorManager.SENSOR_DELAY_NORMAL)
    }

    override fun onPause() {
        super.onPause()
        sensorManager.unregisterListener(this)
    }

    override fun onSensorChanged(event: SensorEvent) {
        if (event.sensor == accelerometer) {
            System.arraycopy(event.values, 0, accelerometerReading, 0, accelerometerReading.size)
        } else if (event.sensor == magnetometer) {
            System.arraycopy(event.values, 0, magnetometerReading, 0, magnetometerReading.size)
        }

        updateOrientation()
        updateDirectionText()
    }

    override fun onAccuracyChanged(sensor: Sensor?, accuracy: Int) {
        // Do nothing
    }

    private fun updateOrientation() {
        SensorManager.getRotationMatrix(rotationMatrix, null, accelerometerReading, magnetometerReading)
        SensorManager.getOrientation(rotationMatrix, orientationValues)

        val azimuth = Math.toDegrees(orientationValues[0].toDouble()).toFloat()

        compassbg.rotation = -azimuth
        compassText.text = "Pusula Yönü: ${azimuth.toInt()}°"

    }

    private fun updateDirectionText() {
        val azimuth = orientationValues[0]

       /* northText.text = getDirectionText((360 - azimuth) % 360)
        eastText.text = getDirectionText((360 - (azimuth + 90)) % 360)
        southText.text = getDirectionText((360 - (azimuth + 180)) % 360)
        westText.text = getDirectionText((360 - (azimuth + 270)) % 360)*/
    }

   /* private fun getDirectionText(angle: Float): String {
        return when {
            angle in 337.5..360.0 || angle in 0.0..22.5 -> "N"
            angle in 22.5..67.5 -> "N-E"
            angle in 67.5..112.5 -> "W"
            angle in 112.5..157.5 -> "S-E"
            angle in 157.5..202.5 -> "S"
            angle in 202.5..247.5 -> "S-W"
            angle in 247.5..292.5 -> "E"
            angle in 292.5..337.5 -> "N-W"
            else -> ""
        }
    }*/


}


