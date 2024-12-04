package frc.robot.commands;

import edu.wpi.first.wpilibj2.command.Command;
import frc.robot.Constants;
import frc.robot.subsystems.Drivetrain;
import edu.wpi.first.wpilibj.xrp.XRPReflectanceSensor;


public class pathfindingCmd extends Command{
    private Drivetrain m_drivetrain;
    private XRPReflectanceSensor m_ReflectanceSensor;

    public pathfindingCmd(Drivetrain drive, XRPReflectanceSensor reflectance){
        addRequirements(drive);
        m_ReflectanceSensor=reflectance;
        m_drivetrain=drive;
    }

    @Override
    public void initialize() {

    }
    
    @Override
    public void execute() {
        if ((m_ReflectanceSensor.getLeftReflectanceValue()<=Constants.PathfindingConstants.judgeblackwhite) && (m_ReflectanceSensor.getRightReflectanceValue()>Constants.PathfindingConstants.judgeblackwhite)){
            m_drivetrain.arcadeDrive( 0.5, 0.2);
            //turn left
        }else if((m_ReflectanceSensor.getLeftReflectanceValue()>Constants.PathfindingConstants.judgeblackwhite) && (m_ReflectanceSensor.getRightReflectanceValue()<=Constants.PathfindingConstants.judgeblackwhite)){
            m_drivetrain.arcadeDrive( 0.5, -0.2);
            //turn right
        }else if((m_ReflectanceSensor.getLeftReflectanceValue()>Constants.PathfindingConstants.judgeblackwhite) && (m_ReflectanceSensor.getRightReflectanceValue()>Constants.PathfindingConstants.judgeblackwhite)){
            m_drivetrain.arcadeDrive( 0.5, 0);
            //drive forward
        }
    }

    @Override
    public void end(boolean interrupted) {}

    @Override
    public boolean isFinished() {
        return false;
    }
}
