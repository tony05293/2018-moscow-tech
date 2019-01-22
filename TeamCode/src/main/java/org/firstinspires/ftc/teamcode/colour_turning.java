package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.hardware.ColorSensor;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.util.Range;

public class colour_turning {

    private ColorSensor color_sensor;
    private DcMotor motor_turn;

    public colour_turning(DcMotor turning) //, ColorSensor colour_sensor)
    {
        //this.color_sensor=colour_sensor;
        this.motor_turn=turning;
    }

    public void check_color() //int
    {
            //int a=color_sensor.argb();
           // return a;
    }
    public void turn_motor(double pos)
    {
        double position =pos;
        motor_turn.setPower(position);
    }
    public double get_position()
    {
        return motor_turn.getCurrentPosition();
    }
}
