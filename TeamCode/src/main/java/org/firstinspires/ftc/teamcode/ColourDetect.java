package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.hardware.ColorSensor;

public class ColourDetect extends LinearOpMode {

    private ColorSensor _colorSensor;

    @Override
    public void runOpMode() {

        // Confirm that the opMode is running
        telemetry.addData("Status", "Starting");

        _colorSensor = hardwareMap.colorSensor.get("ColorSensor");

        // Wait for initialization by the user
        waitForStart();

        // Run until stop

        while (opModeIsActive()) {
            int _timeTillNextScan = 10;


            // Wait for 10 seconds
            // This allows the program to scan the colour every 10 secs.

            while (_timeTillNextScan > 0) {

                telemetry.addData("Next Scan In", _timeTillNextScan);
                telemetry.update();

                sleep(1000);

                _timeTillNextScan--;
            }

            // After 10 secs

            // Get the colour and luminosity values

            int red = _colorSensor.red(),
                    blue = _colorSensor.blue(),
                    green = _colorSensor.green(),
                    alpha = _colorSensor.alpha();

            // Display the values

            telemetry.addData("red", red);
            telemetry.addData("green", green);
            telemetry.addData("blue", blue);
            telemetry.addData("luminosity", alpha);

            telemetry.update();
        }
    }
}
