package org.firstinspires.ftc.teamcode.org;

import com.qualcomm.hardware.modernrobotics.ModernRoboticsI2cColorSensor;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.qualcomm.robotcore.hardware.I2cAddr;

@TeleOp(name="ColourDetect", group="Linear Opmode")

public class ColourDetect extends LinearOpMode {

//    private ColorSensor _colorSensor;

    private ModernRoboticsI2cColorSensor _colorSensor;

    @Override
    public void runOpMode() {

        // Confirm that the opMode is running
        telemetry.addData("Status", "Starting");

        _colorSensor = hardwareMap.get(ModernRoboticsI2cColorSensor.class, "ColorSensor");

        // Wait for initialization by the user
        waitForStart();

        // Run until stop

        while (opModeIsActive()) {
            int _timeTillNextScan = 10;

            I2cAddr _colorSensorAddress =  _colorSensor.getI2cAddress();

            telemetry.addData("Colour Sensor Address", _colorSensorAddress);

            sleep(5000);


            // Wait for 10 seconds
            // This allows the program to scan the colour every 10 secs.

            while (_timeTillNextScan > 0) {

                telemetry.addData("Next Scan In", _timeTillNextScan);
                telemetry.update();

                sleep(1000);

                _timeTillNextScan--;

                if(_timeTillNextScan == 9) {
                    _colorSensor.enableLed(false);
                }

                if(_timeTillNextScan == 8) {
                    _colorSensor.enableLed(true);
                }
            }

            // After 10 secs

            // Get the colour and luminosity values

            double _red = _colorSensor.red(),
                    _green = _colorSensor.green(),
                    _blue = _colorSensor.blue(),
                    _alpha = _colorSensor.alpha();

            // Display the values

            telemetry.addData("red", _red);
            telemetry.addData("green", _green);
            telemetry.addData("blue", _blue);
            telemetry.addData("luminosity", _alpha);

            String _colorRGB = "rgb(" + _red + "," + _green + "," + _blue + ")";
            String _colorRGBA = "rgb(" + _red + "," + _green + "," + _blue + "," + _alpha + ")";

            telemetry.addData("RBG", _colorRGB);
            telemetry.addData("RGBA", _colorRGBA);
            telemetry.update();

            sleep(10000);
        }
    }
}
