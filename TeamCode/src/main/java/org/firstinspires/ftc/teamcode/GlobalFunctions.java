package org.firstinspires.ftc.teamcode;

import android.content.Context;
import android.media.SoundPool;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.DcMotorController;
import com.qualcomm.robotcore.hardware.Servo;
import com.qualcomm.robotcore.util.ElapsedTime;
import com.qualcomm.robotcore.eventloop.opmode.Autonomous;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.eventloop.opmode.OpMode;
import com.qualcomm.robotcore.hardware.DcMotorSimple;
import java.math.*;
import android.app.Activity;
import android.content.Context;
import android.graphics.Color;
import android.view.View;

public class GlobalFunctions{
    Context mContext;

    // constructor
    public GlobalFunctions(Context context){
        this.mContext = context;
    }

    private ElapsedTime runtime = new ElapsedTime();
    public DcMotorController motor_controller_drive;
    public DcMotor motor_drive_left;
    public DcMotor motor_drive_right;
    public DcMotorController motor_controller_shooter;
    public DcMotor shooter_motor_1;
    public DcMotor intake_motor_1;
    public DcMotor intake_motor_2;
    public Servo buttonServo;

    // Initilization of drive train variables:
    //public double power_forward;
    public double power_back;
    //    public double power_RT;
//    public double power_LT;
    public double power_level;

    // Initilization of drive train variables:
    //public double power_forward;
    public double power_shooter;

    // Initialization of joystick buttons:
    public double button_RT;
    public double button_LT;

    public boolean button_RB;
    public boolean button_LB;
/*    public boolean button_a;
    public boolean button_y;
    public boolean button_b;
    public boolean button_x;*/

    //    public double joystick1_right_x;
    public double joystick1_right_y;
    public double joystick1_left_x;
    public double joystick1_left_y;
    public double joystick1_right_x;
    public double joystick2_right_y;

    public double ARM_RETRACTED_POSITION = 0.2;
    public double ARM_EXTENDED_POSITION = 0.8;

    public double left_train_power;
    public double right_train_power;

    public boolean startButton;
    public boolean startPrev;
    public boolean speed;

    // private DcMotor leftMotor = null;
    // private DcMotor rightMotor = null;

    public SoundPool mySound;
    public int beepID;

    double left_trigger;
    double right_trigger;

    double instant;

    public void driveFor(int seconds, double left_power, double right_power) {
        motor_drive_right.setPower(right_power);
        motor_drive_left.setPower(left_power);

        //1 second = 50 inches
        seconds = seconds * 1000;

        instant = runtime.milliseconds();
        while (instant > runtime.milliseconds() - seconds) {
            telemetry.addData("Time Left", (seconds - (runtime.milliseconds() - instant)));
        }

        motor_drive_left.setPower(0);
        motor_drive_right.setPower(0);
    }

    public void driveFor(int seconds, double power) {
        driveFor(seconds, power, power);
    }

    public void driveFor(int seconds) {
        driveFor(seconds, 0.75, 0.75);
    }
}