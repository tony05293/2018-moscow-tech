package org.firstinspires.ftc.teamcode.org;

import android.content.Context;

import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOError;
import java.io.IOException;
import java.util.ArrayList;

public class RecordActions extends LinearOpMode {

    String _convertGampadDataMapToString(GamepadDataMap _map) {

        String _toReturn = "";

        _toReturn += _map.getTimestamp()
                + "*" + _map.isA()
                + "*" + _map.isB()
                + "*" + _map.isBack()
                + "*" + _map.isdPadDown()
                + "*" + _map.isdPadLeft()
                + "*" + _map.isdPadRight()
                + "*" + _map.isdPadUp()
                + "*" + _map.isGuide()
                + "*" + _map.isLeftBumper()
                + "*" + _map.isLeftStickButton()
                + "*" + _map.getLeftStickX()
                + "*" + _map.getLeftStickY()
                + "*" + _map.getLeftTrigger()
                + "*" + _map.isRightBumper()
                + "*" + _map.isRightStickButton()
                + "*" + _map.getRightStickX()
                + "*" + _map.getRightStickY()
                + "*" + _map.getRightTrigger()
                + "*" + _map.isStart()
                + "*" + _map.isX()
                + "*" + _map.isY()
        ;

        return _toReturn;
    }

    @Override
    public void runOpMode() {

        ArrayList<GamepadDataMap> _gamePadData = new ArrayList<>();
        int _time = 0;


        while (opModeIsActive()) {

            GamepadDataMap _newDataMap = new GamepadDataMap(
                    _time,
                    gamepad1.a,
                    gamepad1.b,
                    gamepad1.back,
                    gamepad1.dpad_down,
                    gamepad1.dpad_left,
                    gamepad1.dpad_right,
                    gamepad1.dpad_up,
                    gamepad1.guide,
                    gamepad1.left_bumper,
                    gamepad1.left_stick_button,
                    gamepad1.left_stick_x,
                    gamepad1.left_stick_y,
                    gamepad1.left_trigger,
                    gamepad1.right_bumper,
                    gamepad1.right_stick_button,
                    gamepad1.right_stick_x,
                    gamepad1.right_stick_y,
                    gamepad1.right_trigger,
                    gamepad1.start,
                    gamepad1.x,
                    gamepad1.y
            );

            _gamePadData.add(_newDataMap);

            telemetry.addData("Elapsed Time", _time);
            telemetry.update();

            time += 100;
            sleep(100);
        }

        stop();

        String _gamePadDataString = "";

        for (int i = 0; i < _gamePadData.size(); i++) {
            GamepadDataMap _gamePadInfo = _gamePadData.get(i);

            if (i != 0) {
                _gamePadDataString += ";";
            }

            _gamePadDataString += _convertGampadDataMapToString(_gamePadInfo);

        }

        Context context = hardwareMap.appContext;

        File _path = context.getFilesDir();

        File _file = new File(_path, "actionsLog.txt");

        try (FileOutputStream _stream = new FileOutputStream(_file)) {
            _stream.write(_gamePadDataString.getBytes());
            telemetry.addData("StatusUpdate", "Successfully Logged");
        }
        catch (IOError e) {
            telemetry.addData("IOError", e);
            telemetry.update();
        }
        catch (FileNotFoundException e) {
            e.printStackTrace();
            telemetry.addData("FileException", e);
            telemetry.update();
        }
        catch (IOException e) {
            e.printStackTrace();
            telemetry.addData("IOException", e);
            telemetry.update();
        }

    }
}

class GamepadDataMap {

    private int timestamp;
    private boolean a;
    private boolean b;
    private boolean back;
    private boolean dPadDown;
    private boolean dPadLeft;
    private boolean dPadRight;
    private boolean dPadUp;
    private boolean guide;
    private boolean leftBumper;
    private boolean leftStickButton;
    private double leftStickX;
    private double leftStickY;
    private float leftTrigger;
    private boolean rightBumper;
    private boolean rightStickButton;
    private double rightStickX;
    private double rightStickY;
    private float rightTrigger;
    private boolean start;
    private boolean x;
    private boolean y;

    GamepadDataMap(
            int incomingTimestamp,
            boolean incomingA,
            boolean incomingB,
            boolean incomingBack,
            boolean incomingDPadDown,
            boolean incomingDPadLeft,
            boolean incomingDPadRight,
            boolean incomingDPadUp,
            boolean incomingGuide,
            boolean incomingLeftBumper,
            boolean incomingLeftStickButton,
            double incomingLeftStickX,
            double incomingLeftStickY,
            float incomingLeftTrigger,
            boolean incomingRightBumper,
            boolean incomingRightStickButton,
            double incomingRightStickX,
            double incomingRightStickY,
            float incomingRightTrigger,
            boolean incomingStart,
            boolean incomingX,
            boolean incomingY
    ) {
        timestamp = incomingTimestamp;
        a = incomingA;
        b = incomingB;
        back = incomingBack;
        dPadDown = incomingDPadDown;
        dPadLeft = incomingDPadLeft;
        dPadRight = incomingDPadRight;
        dPadUp = incomingDPadUp;
        guide = incomingGuide;
        leftBumper = incomingLeftBumper;
        leftStickButton = incomingLeftStickButton;
        leftStickX = incomingLeftStickX;
        leftStickY = incomingLeftStickY;
        leftTrigger = incomingLeftTrigger;
        rightBumper = incomingRightBumper;
        rightStickButton = incomingRightStickButton;
        rightStickX = incomingRightStickX;
        rightStickY = incomingRightStickY;
        rightTrigger = incomingRightTrigger;
        start = incomingStart;
        x = incomingX;
        y = incomingY;
    }

    public int getTimestamp() {
        return timestamp;
    }

    public boolean isA() {
        return a;
    }

    public boolean isB() {
        return b;
    }

    public boolean isBack() {
        return back;
    }

    public boolean isdPadDown() {
        return dPadDown;
    }

    public boolean isdPadLeft() {
        return dPadLeft;
    }

    public boolean isdPadRight() {
        return dPadRight;
    }

    public boolean isdPadUp() {
        return dPadUp;
    }

    public boolean isGuide() {
        return guide;
    }

    public boolean isLeftBumper() {
        return leftBumper;
    }

    public boolean isLeftStickButton() {
        return leftStickButton;
    }

    public double getLeftStickX() {
        return leftStickX;
    }

    public double getLeftStickY() {
        return leftStickY;
    }

    public float  getLeftTrigger() {
        return leftTrigger;
    }

    public boolean isRightBumper() {
        return rightBumper;
    }

    public boolean isRightStickButton() {
        return rightStickButton;
    }

    public double getRightStickX() {
        return rightStickX;
    }

    public double getRightStickY() {
        return rightStickY;
    }

    public float getRightTrigger() {
        return rightTrigger;
    }

    public boolean isStart() {
        return start;
    }

    public boolean isX() {
        return x;
    }

    public boolean isY() {
        return y;
    }
}