import com.qualcomm.robotcore.eventloop.opmode.Autonomous;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.DcMotorSimple;
import com.qualcomm.robotcore.util.ElapsedTime;


/**
 * This file contains an minimal example of a Linear "OpMode". An OpMode is a 'program' that runs in either
 * the autonomous or the teleop period of an FTC match. The names of OpModes appear on the menu
 * of the FTC Driver Station. When an selection is made from the menu, the corresponding OpMode
 * class is instantiated on the Robot Controller and executed.
 *
 * This particular OpMode just executes a basic Tank Drive Teleop for a two wheeled robot
 * It includes all the skeletal structure that all linear OpModes contain.
 *
 * Use Android Studios to Copy this Class, and Paste it into your team's code folder with a new name.
 * Remove or comment out the @Disabled line to add this opmode to the Driver Station OpMode list
 */

@Autonomous(name="Juwhan_front_1280", group="Linear Opmode")
//@Disabled
public class Juwhawn_front1280 extends LinearOpMode {

    // Declare OpMode members.
    private ElapsedTime runtime = new ElapsedTime();
    DcMotor leftDrive_front;
    DcMotor rightDrive_front;
    DcMotor leftDrive_back;
    DcMotor rightDrive_back;
    double power=0.5;
    long sec = 1500;
    @Override
    public void runOpMode() {
        telemetry.addData("Status", "Initialized");
        telemetry.update();

        leftDrive_front  = hardwareMap.get(DcMotor.class, "leftf_drive");
        rightDrive_front = hardwareMap.get(DcMotor.class, "rightf_drive");
        leftDrive_back  = hardwareMap.get(DcMotor.class, "leftb_drive");
        rightDrive_back = hardwareMap.get(DcMotor.class, "rightb_drive");

        leftDrive_front.setDirection(DcMotorSimple.Direction.FORWARD);
        rightDrive_front.setDirection(DcMotorSimple.Direction.REVERSE);
        leftDrive_back.setDirection(DcMotorSimple.Direction.FORWARD);
        rightDrive_back.setDirection(DcMotorSimple.Direction.REVERSE);

        // Wait for the game to start (driver presses PLAY)
        waitForStart();
        runtime.reset();

        //go foward
        for(double i=1;i<=3;i++)
        {
            power=1;
            leftDrive_front.setPower(power);
            rightDrive_front.setPower(power);
            leftDrive_back.setPower(power);
            rightDrive_back.setPower(power);
            //leftDrive_back.setPower(power);
            //rightDrive_back.setPower(power);
            sleep(1000); //sleep for 5  milisec
            power=0.5;
            leftDrive_front.setPower(power);
            rightDrive_front.setPower(-1*power);
            leftDrive_back.setPower(power);
            rightDrive_back.setPower(-1*power);
           // leftDrive_back.setPower(power);
           // rightDrive_back.setPower(-1*power);
            sleep(sec); //sleep for 5  milisec
        }
        for(double i=1;i<=4;i++)
        {
            power=-1;
            leftDrive_front.setPower(power);
            rightDrive_front.setPower(power);
            leftDrive_back.setPower(power);
            rightDrive_back.setPower(power);
           //leftDrive_back.setPower(power);
            //rightDrive_back.setPower(power);
            sleep(1000); //sleep for 5  milisec
            power=-0.5;
            leftDrive_front.setPower(power);
            rightDrive_front.setPower(-1*power);
            leftDrive_back.setPower(power);
            rightDrive_back.setPower(-1*power);
           // leftDrive_back.setPower(power);
           // rightDrive_back.setPower(-1*power);
            sleep(sec); //sleep for 5  milisec
        }
        power=1;
        leftDrive_front.setPower(power);
        rightDrive_front.setPower(power);
        leftDrive_back.setPower(power);
        rightDrive_back.setPower(power);
    }
}

