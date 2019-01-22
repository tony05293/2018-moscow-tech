package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.util.Range;

public class base {

    private DcMotor leftFront, rightFront, leftBack, rightBack;

    static final double     COUNTS_PER_MOTOR_REV    = 1440 ;    // eg: TETRIX Motor Encoder
    static final double     DRIVE_GEAR_REDUCTION    = 1 ;     // This is < 1.0 if geared UP
    static final double     WHEEL_DIAMETER_INCHES   = 4.0 ;     // For figuring circumference
    static final double     WHEEL_DIAMETER_CM   = 10.0;
    static final double     COUNTS_PER_INCH         = (COUNTS_PER_MOTOR_REV * DRIVE_GEAR_REDUCTION) /
            (WHEEL_DIAMETER_INCHES * 3.1415);
    static final double     COUNTS_PER_CM         = (COUNTS_PER_MOTOR_REV * DRIVE_GEAR_REDUCTION) /
            (WHEEL_DIAMETER_CM * 3.1415);
    static final double     DRIVE_SPEED             = 0.2;
    static final double     TURN_SPEED              = 0.5;

    public base(DcMotor leftFront, DcMotor rightFront, DcMotor leftBack, DcMotor rightBack)
    {
        this.leftFront = leftFront;
        this.leftBack = leftBack;
        this.rightFront = rightFront;
        this.rightBack = rightBack;
//        this.drive = drive;
//        this.strafe = strafe;
//        this.turn = turn;
    }


    public void mecaDrive(double drive, double strafe, double turn)
    {
        double lf, lb, rf, rb;

        lf = drive + turn + strafe;
        lb = drive + turn - strafe;
        rf = drive - turn - strafe;
        rb = drive - turn + strafe;

        leftFront.setPower(Range.clip(lf, -0.5, 0.5));
        leftBack.setPower(Range.clip(lb, -0.5, 0.5));
        rightFront.setPower(Range.clip(rf, -0.5, 0.5));
        rightBack.setPower(Range.clip(rb, -0.5, 0.5));
    }

    public void tankDrive(double yy, double xx, double scale)
    {
        double leftWheel,rightWheel;
        double drive=yy;
        double turn=xx;
        leftWheel    = Range.clip(drive*scale + turn*scale, -1*(scale), 1.0*(scale)) ;
        rightWheel   = Range.clip(drive*scale - turn*scale, -1*(scale), 1.0*(scale)) ;

        leftFront.setPower(leftWheel*0.6);
        leftBack.setPower(leftWheel);
        rightFront.setPower(rightWheel*0.6);
        rightBack.setPower(rightWheel);
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
        rightFront.setPower(DRIVE_SPEED);

        resetMotors();
    }
    public void turn_left(double scale)
    {
        scale=scale*-1;
        leftFront.setPower(0.6*scale);
        leftBack.setPower(scale);
        rightFront.setPower(-1*0.6*scale);
        rightBack.setPower(-1*scale);
        //newTartget(10,-10);
    }
    public void turn_right(double scale)
    {
        leftFront.setPower(scale);
        leftBack.setPower(scale);
        rightFront.setPower(-1*scale);
        rightBack.setPower(-1*scale);
        //newTartget(10,-10);
    }

    public String toString()
    {
        return "Base: leftF: "+leftFront.getPower()+" leftB: "+leftBack.getPower()+" rightF: "+rightFront.getPower()+" rightBack: "+rightBack.getPower();
    }

}
