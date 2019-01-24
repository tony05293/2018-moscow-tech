//package org.firstinspires.ftc.teamcode;
//
//import com.qualcomm.robotcore.hardware.DcMotor;
//import com.qualcomm.robotcore.util.Range;
//
//public class claw {
//
//    private DcMotor extend_arm;
//
//    public claw(DcMotor arm)
//    {
//        this.extend_arm=arm;
//    }
//
//    public void check_b(boolean check_b)
//    {
//        double power_b;
//        boolean power_b = gamepad1.b;
//        if (power_b==true)
//        {
//            if (move_mode==false)
//            {
//                if (previous_state=="up") {previous_state="down";}
//                else {previous_state="up";}
//                move_mode=true;
//            }
//        }
//    }
//
//    public void tankDrive(double drive, double turn)
//    {
//        double leftWheel,rightWheel;
//
//        leftWheel    = Range.clip(drive + turn, -1.0, 1.0) ;
//        rightWheel   = Range.clip(drive - turn, -1.0, 1.0) ;
//
//        leftFront.setPower(leftWheel);
//        leftBack.setPower(leftWheel);
//        rightFront.setPower(rightWheel);
//        rightBack.setPower(rightWheel);
//    }
//
//    public void resetMotors()
//    {
//        leftBack.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
//        leftFront.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
//        rightBack.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
//        rightFront.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
//
//        leftBack.setMode(DcMotor.RunMode.RUN_USING_ENCODER);
//        leftFront.setMode(DcMotor.RunMode.RUN_USING_ENCODER);
//        rightBack.setMode(DcMotor.RunMode.RUN_USING_ENCODER);
//        rightFront.setMode(DcMotor.RunMode.RUN_USING_ENCODER);
//    }
//
////    public void newTartget(double leftInches, double rightInches)
////    {
////        newTartget(leftInches, rightInches, DRIVE_SPEED);
////    }
//
//    public void newTartget(double leftInches, double rightInches)
//    {
//        resetMotors();
//        int leftTarget = (int)(leftInches * COUNTS_PER_INCH);
//        int rightTarget = (int)(rightInches * COUNTS_PER_INCH);
//        leftBack.setTargetPosition(leftTarget);
//        leftFront.setTargetPosition(leftTarget);
//        rightBack.setTargetPosition(rightTarget);
//        rightFront.setTargetPosition(rightTarget);
//
//        leftBack.setMode(DcMotor.RunMode.RUN_TO_POSITION);
//        leftFront.setMode(DcMotor.RunMode.RUN_TO_POSITION);
//        rightBack.setMode(DcMotor.RunMode.RUN_TO_POSITION);
//        rightFront.setMode(DcMotor.RunMode.RUN_TO_POSITION);
//
//        leftBack.setPower(DRIVE_SPEED);
//        leftFront.setPower(DRIVE_SPEED);
//        rightBack.setPower(DRIVE_SPEED);
//        rightFront.setPower(DRIVE_SPEED);
//
//        resetMotors();
//    }
//
//    public void turn()
//    {
//        newTartget(10,-10);
//    }
//
//    public String toString()
//    {
//        return "Base: leftF: "+leftFront.getPower()+" leftB: "+leftBack.getPower()+" rightF: "+rightFront.getPower()+" rightBack: "+rightBack.getPower();
//    }
//
//}
