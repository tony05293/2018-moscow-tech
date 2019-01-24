package org.firstinspires.ftc.teamcode.org;

import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.hardware.ColorSensor;

public class CheckWhichBallBasedOnColour extends LinearOpMode {

    private int _referenceSilverRed = 0,
            _referenceSilverGreen = 0,
            _referenceSilverBlue = 0;

    private int _referenceGoldRed = 255,
            _referenceGoldGreen = 255,
            _referenceGoldBlue = 255;

    private ColorSensor _colourSensor;

    @Override
    public void runOpMode() {

        telemetry.addData("Status: ", "Waiting to start scan");

        waitForStart();

        boolean _colourScannedIsSilver = _checkScannedColour();


        // Run final action based on detected colour

        _runActionBasedOnColour(_colourScannedIsSilver);

    }

    private boolean _checkScannedColour() {
        // Map Colour Sensor colorSensor to _colorSensor
        _colourSensor = hardwareMap.colorSensor.get("colorSensor");


        // Get RGB values for object in front of sensor
        int _sensorRed, _sensorGreen, _sensorBlue;

        _sensorRed = _colourSensor.red();
        _sensorGreen = _colourSensor.green();
        _sensorBlue = _colourSensor.blue();


        // Calculate difference between RGB values between scanned colour and reference colours
        int _diffSilverRed, _diffSilverGreen, _diffSilverBlue, _diffGoldRed, _diffGoldGreen, _diffGoldBlue;

        _diffSilverRed = Math.abs((_referenceSilverRed - _sensorRed));
        _diffSilverGreen = Math.abs((_referenceSilverGreen - _sensorGreen));
        _diffSilverBlue = Math.abs((_referenceSilverBlue - _sensorBlue));

        _diffGoldRed = Math.abs((_referenceGoldRed - _sensorRed));
        _diffGoldGreen = Math.abs((_referenceGoldGreen - _sensorGreen));
        _diffGoldBlue = Math.abs((_referenceGoldBlue - _sensorBlue));


        // Calculate difference between scanned colour and reference colours by averaging RGB value differences
        int _diffSilver, _diffGold;

        _diffSilver = _calculateAverage(_diffSilverRed, _diffSilverGreen, _diffSilverBlue);
        _diffGold = _calculateAverage(_diffGoldRed, _diffGoldGreen, _diffGoldBlue);


        // Check which difference is lower and hence which colour is more similar
        return _diffSilver < _diffGold;
    }

    private int _calculateAverage(int _valueOne, int _valueTwo, int _valueThree) {
        int _average = (_valueOne + _valueTwo + _valueThree) / 3;
        return _average;
    }

    private void _runActionBasedOnColour(boolean _isSilver) {

        // TODO: Implement proper action after colour scan

        // Display identified colour through Telemetry

        if (_isSilver) {
            telemetry.addData("Scanned Colour: ", "Silver");
        }
        else {
            telemetry.addData("Scanned Colour", "Gold");
        }

        telemetry.update();
    }
}