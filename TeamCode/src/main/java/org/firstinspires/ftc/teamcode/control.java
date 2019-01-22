package org.firstinspires.ftc.teamcode;/* Copyright (c) 2017 FIRST. All rights reserved.
 *
 * Redistribution and use in source and binary forms, with or without modification,
 * are permitted (subject to the limitations in the disclaimer below) provided that
 * the following conditions are met:
 *
 * Redistributions of source code must retain the above copyright notice, this list
 * of conditions and the following disclaimer.
 *
 * Redistributions in binary form must reproduce the above copyright notice, this
 * list of conditions and the following disclaimer in the documentation and/or
 * other materials provided with the distribution.
 *
 * Neither the name of FIRST nor the names of its contributors may be used to endorse or
 * promote products derived from this software without specific prior written permission.
 *
 * NO EXPRESS OR IMPLIED LICENSES TO ANY PARTY'S PATENT RIGHTS ARE GRANTED BY THIS
 * LICENSE. THIS SOFTWARE IS PROVIDED BY THE COPYRIGHT HOLDERS AND CONTRIBUTORS
 * "AS IS" AND ANY EXPRESS OR IMPLIED WARRANTIES, INCLUDING, BUT NOT LIMITED TO,
 * THE IMPLIED WARRANTIES OF MERCHANTABILITY AND FITNESS FOR A PARTICULAR PURPOSE
 * ARE DISCLAIMED. IN NO EVENT SHALL THE COPYRIGHT OWNER OR CONTRIBUTORS BE LIABLE
 * FOR ANY DIRECT, INDIRECT, INCIDENTAL, SPECIAL, EXEMPLARY, OR CONSEQUENTIAL
 * DAMAGES (INCLUDING, BUT NOT LIMITED TO, PROCUREMENT OF SUBSTITUTE GOODS OR
 * SERVICES; LOSS OF USE, DATA, OR PROFITS; OR BUSINESS INTERRUPTION) HOWEVER
 * CAUSED AND ON ANY THEORY OF LIABILITY, WHETHER IN CONTRACT, STRICT LIABILITY,
 * OR TORT (INCLUDING NEGLIGENCE OR OTHERWISE) ARISING IN ANY WAY OUT OF THE USE
 * OF THIS SOFTWARE, EVEN IF ADVISED OF THE POSSIBILITY OF SUCH DAMAGE.
 */

import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.Servo;
import com.qualcomm.robotcore.hardware.ColorSensor;
import com.qualcomm.robotcore.hardware.DcMotorSimple;
import com.qualcomm.robotcore.hardware.DigitalChannel;
import com.qualcomm.robotcore.util.ElapsedTime;
import com.qualcomm.robotcore.util.Range;

@TeleOp(name="control1", group="Linear OpMode")

public class control extends LinearOpMode {

    // Declare OpMode members.
    private ElapsedTime runtime = new ElapsedTime();
    private DcMotor leftDrive_front;
    private DcMotor rightDrive_front;
    private DcMotor leftDrive_back;
    private  DcMotor rightDrive_back;
    //private ColorSensor color_sensor;
    private  DcMotor motor_turn;
    private DcMotor extend_arm;
    private DcMotor climbing;
    //private DigitalChannel touch_sensor;

    @Override
    public void runOpMode() {
        telemetry.addData("Status", "Initialized");
        telemetry.update();

        // Initialize the hardware variables. Note that the strings used here as parameters
        // to 'get' must correspond to the names assigned during the robot configuration
        // step (using the FTC Robot Controller app on the phone).
        leftDrive_front  = hardwareMap.get(DcMotor.class, "leftf_drive");
        rightDrive_front = hardwareMap.get(DcMotor.class, "rightf_drive");
        leftDrive_back  = hardwareMap.get(DcMotor.class, "leftb_drive");
        rightDrive_back = hardwareMap.get(DcMotor.class, "rightb_drive");
        climbing = hardwareMap.get(DcMotor.class, "climbing");

        leftDrive_front.setDirection(DcMotorSimple.Direction.FORWARD);
       // rightDrive_front.setDirection(DcMotorSimple.Direction.REVERSE);
        leftDrive_back.setDirection(DcMotorSimple.Direction.FORWARD);
        //rightDrive_back.setDirection(DcMotorSimple.Direction.REVERSE);
        //color_sensor = hardwareMap.colorSensor.get("color_sensor");
        motor_turn = hardwareMap.get(DcMotor.class, "turn_block");
        extend_arm = hardwareMap.get(DcMotor.class, "extend_arm");
        //touch_sensor = hardwareMap.get(DigitalChannel.class, "touch_sensor");
        //color_sensor = hardwareMap.colorSensor.get("color");
        extend_arm.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
        base base1 = new base(leftDrive_front, rightDrive_front, leftDrive_back, rightDrive_back);
        mouth mouth1=new mouth(telemetry);
        //colour_turning turning1 = new colour_turning(motor_turn,color_sensor);
        colour_turning turning1 = new colour_turning(motor_turn);
        //claw claw1=new claw(extend_arm,touch_sensor);
        claw claw1=new claw(extend_arm);
        climbing climb1=new climbing(climbing);
        String previous_state="down";
        boolean move_mode=false;
        long move_len=0;
        int mode=-256;
        int rgb=0;
        double turn_mode=0;

        waitForStart();
        runtime.reset();
        while (opModeIsActive())
        {
            if (gamepad1.left_bumper)
            {
                base1.turn_left(0.4);
            }
            else if (gamepad1.right_bumper)
            {
                base1.turn_right(0.4);
            }
            else if (gamepad1.left_trigger!=0)
            {
                base1.turn_left(gamepad1.left_trigger);
            }
            else if (gamepad1.right_trigger!=0)
            {
                base1.turn_right(gamepad1.right_trigger);
            }
            else
            {
                float xx=gamepad1.right_stick_x;
                float yy=gamepad1.right_stick_y;
                base1.tankDrive(xx, yy,0.5);
            }
            // if pressed, change direction
           if (gamepad1.b==true)
            {
                if (move_mode==false) {
                    previous_state=claw1.get_previous_state(previous_state);
                    move_mode=true;
                }
            }
            if (gamepad1.left_stick_y>0)//if (gamepad1.dpad_up==true)
            {
                climb1.climbup();
                //mode=-256;//yellow
            }
            else if (gamepad1.left_stick_y<0)//else if(gamepad1.dpad_down==true)
            {
                climb1.climbdown();
                //mode=-1;//yellow
            }
            else
            {
                climb1.climbstop();
            }
            if (gamepad1.a==true)
            {
                turning1.turn_motor(0.8);
                //rgb=turning1.check_color();
                turn_mode=1;
            }
            else if (gamepad1.y==true)
            {
                turning1.turn_motor(-0.8);
                //rgb=turning1.check_color();
                turn_mode=1;
            }
            else
            {
                turning1.turn_motor(0);
            }
            /*
            if (turning1.get_position()==0)
            {
                if (turn_mode==1)
                {
                    if (rgb!=0)
                    {
                        turning1.turn_motor(-1);
                        turn_mode=0;
                    }
                }
            }
            */

            //stop, if
            if (move_mode==true)
            {
                if (/*(touch_sensor.getState()) &&*/ (gamepad1.x) && (previous_state=="up"))
                {
                    move_mode = false;
                }
                else if (previous_state=="down" && move_len==0)
                {
                    move_mode=false;
                }
                else
                {
                    move_len=claw1.get_movelen(move_len,previous_state);
                }
            }
            if (move_mode==true) {
                claw1.move_arm(previous_state);
            }
            telemetry.addData("Move_mode", move_mode);
            telemetry.addData("Move_len", move_len);
            telemetry.addData("color", rgb);
            telemetry.update();
        }
    }
}
