package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.DigitalChannel;
import com.qualcomm.robotcore.util.Range;

public class claw {

    private DcMotor extend_arm;
    //private DigitalChannel touchsensor;

    public claw(DcMotor arm)
    {
        this.extend_arm=arm;
        //this.touchsensor=touchsensor;
    }

    public String get_previous_state(String previous_mode)
    {
       String previous_state=previous_mode;

        if (previous_state=="up")
        {
            previous_state="down";
        }
        else
        {
            previous_state="up";
        }

        return previous_state;
    }
    public long get_movelen(long length, String previous_mode)
    {
        String previous_state=previous_mode;
        long move_len=length;
        if (previous_state == "up")
        {
            move_len++;
        }
        else
        {
            move_len--;
        }

        return move_len;
    }
    public void move_arm(String previous_mode) {
        String previous_state = previous_mode;
        if (previous_state == "up") {
            extend_arm.setPower(1);
        } else
            extend_arm.setPower(-1);
    }
}
