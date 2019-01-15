package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.Gamepad;
import com.qualcomm.robotcore.hardware.Servo;

public class Arm_move{

    private DcMotor arm_name;

    public void Arm_move(DcMotor arm_name)
    {
        this.arm_name=arm_name;
    }

    public void down()
    {
        arm_name.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
        arm_name.setMode(DcMotor.RunMode.RUN_USING_ENCODER);
        int Target=0;
        arm_name.setTargetPosition(Target);
        arm_name.setMode(DcMotor.RunMode.RUN_TO_POSITION);
        arm_name.setPower(1);
    }

    public void up()
    {
        arm_name.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
        arm_name.setMode(DcMotor.RunMode.RUN_USING_ENCODER);
        int Target=1120/4;
        arm_name.setTargetPosition(Target);
        arm_name.setMode(DcMotor.RunMode.RUN_TO_POSITION);
        arm_name.setPower(1);
    }
}