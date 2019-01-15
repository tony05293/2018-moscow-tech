package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.hardware.Servo;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.util.Range;

public class colour_turning {

    private Servo color_sensor;
    private DcMotor motor_turn;

    public colour_turning(DcMotor turning, Servo colour_sensor)
    {
        this.color_sensor=colour_sensor;
        this.motor_turn=turning;
    }

    public void check_color(double drive, double turn)
    {
        double leftWheel,rightWheel;

        leftWheel    = Range.clip(drive + turn, -1.0, 1.0) ;
        rightWheel   = Range.clip(drive - turn, -1.0, 1.0) ;

    }

    public void resetMotors()
    {
        leftBack.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
        leftFront.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
        rightBack.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
        rightFront.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);

        leftBack.setMode(DcMotor.RunMode.RUN_USING_ENCODER);
        leftFront.setMode(DcMotor.RunMode.RUN_USING_ENCODER);
        rightBack.setMode(DcMotor.RunMode.RUN_USING_ENCODER);
        rightFront.setMode(DcMotor.RunMode.RUN_USING_ENCODER);
    }

//    public void newTartget(double leftInches, double rightInches)
//    {
//        newTartget(leftInches, rightInches, DRIVE_SPEED);
//    }

    public void newTartget(double leftInches, double rightInches)
    {
        resetMotors();
        int leftTarget = (int)(leftInches * COUNTS_PER_INCH);
        int rightTarget = (int)(rightInches * COUNTS_PER_INCH);
        leftBack.setTargetPosition(leftTarget);
        leftFront.setTargetPosition(leftTarget);
        rightBack.setTargetPosition(rightTarget);
        rightFront.setTargetPosition(rightTarget);

        leftBack.setMode(DcMotor.RunMode.RUN_TO_POSITION);
        leftFront.setMode(DcMotor.RunMode.RUN_TO_POSITION);
        rightBack.setMode(DcMotor.RunMode.RUN_TO_POSITION);
        rightFront.setMode(DcMotor.RunMode.RUN_TO_POSITION);

        leftBack.setPower(DRIVE_SPEED);
        leftFront.setPower(DRIVE_SPEED);
        rightBack.setPower(DRIVE_SPEED);
        rightFront.setPower(DRIVE_SPEED)

        resetMotors();
    }

    public void turn()
    {
        newTartget(10,-10);
    }

    public String toString()
    {
        return "Base: leftF: "+leftFront.getPower()+" leftB: "+leftBack.getPower()+" rightF: "+rightFront.getPower()+" rightBack: "+rightBack.getPower();
    }

}