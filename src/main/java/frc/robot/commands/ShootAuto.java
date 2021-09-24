package frc.robot.commands;

import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.Constants;
import frc.robot.Robot;


public class ShootAuto extends CommandBase {

        //move pulley, shooter, transport
        private double pSpeed;
        private double sLeftSpeed;
        private double sRightSpeed;
        private double tSpeed;

        public ShootAuto(double pulleySpeed, double shooterLeftSpeed, double shooterRightSpeed, double transportSpeed) {
            this.pSpeed = pulleySpeed;
            this.sLeftSpeed = shooterLeftSpeed;
            this.sRightSpeed = shooterRightSpeed;
            this.tSpeed = transportSpeed;
        }

        public void initialize() {
            Robot.m_robotContainer.getPulley().movePulley(pSpeed);
            Robot.m_robotContainer.getShooter().moveShooter(sLeftSpeed, sRightSpeed);
            Robot.m_robotContainer.getTransport().moveTransport(tSpeed);
        }

        public void execute() {
            Robot.m_robotContainer.getPulley().movePulley(pSpeed);
            Robot.m_robotContainer.getShooter().moveShooter(sLeftSpeed, sRightSpeed);
            Robot.m_robotContainer.getTransport().moveTransport(tSpeed);

        }

        public boolean isFinished() {
            return Robot.m_robotContainer.getJoystick().getRawButton(Constants.SHOOTER_BUTTON);
        }

        public void end() {
            Robot.m_robotContainer.getPulley().stopPulley();
            Robot.m_robotContainer.getShooter().stopShooter();
            Robot.m_robotContainer.getTransport().stopTransport();
        }

        
}