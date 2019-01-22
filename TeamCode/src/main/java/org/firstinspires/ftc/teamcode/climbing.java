package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.DigitalChannel;

public class climbing {

    private DcMotor climbing;

    public climbing(DcMotor climbing)
    {
        this.climbing=climbing;
    }

    public void climbup() {
            climbing.setPower(-1);
    }
    public void climbdown() {
        climbing.setPower(1);
    }
    public void climbstop() {
        climbing.setPower(0);
    }
}
