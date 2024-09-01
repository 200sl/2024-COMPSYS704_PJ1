import java.util.*;
import com.systemj.ClockDomain;
import com.systemj.Signal;
import com.systemj.input_Channel;
import com.systemj.output_Channel;

public class CapperController extends ClockDomain{
  public CapperController(String name){super(name);}
  Vector currsigs = new Vector();
  private boolean df = false;
  private char [] active;
  private char [] paused;
  private char [] suspended;
  public Signal bottleAtPos4 = new Signal("bottleAtPos4", Signal.INPUT);
  public Signal gripperZAxisLowered = new Signal("gripperZAxisLowered", Signal.INPUT);
  public Signal gripperZAxisLifted = new Signal("gripperZAxisLifted", Signal.INPUT);
  public Signal gripperTurnHomePos = new Signal("gripperTurnHomePos", Signal.INPUT);
  public Signal gripperTurnFinalPos = new Signal("gripperTurnFinalPos", Signal.INPUT);
  public Signal capperDoProcess = new Signal("capperDoProcess", Signal.INPUT);
  public Signal cylPos5ZaxisExtend = new Signal("cylPos5ZaxisExtend", Signal.OUTPUT);
  public Signal gripperTurnRetract = new Signal("gripperTurnRetract", Signal.OUTPUT);
  public Signal gripperTurnExtend = new Signal("gripperTurnExtend", Signal.OUTPUT);
  public Signal capGripperPos5Extend = new Signal("capGripperPos5Extend", Signal.OUTPUT);
  public Signal cylClampBottleExtend = new Signal("cylClampBottleExtend", Signal.OUTPUT);
  public Signal capperIdle = new Signal("capperIdle", Signal.OUTPUT);
  private Signal clampBottle_1;
  private Signal unclampBottle_1;
  private Signal raiseGripper_1;
  private Signal lowerGripper_1;
  private Signal gripCap_1;
  private Signal releaseCap_1;
  private int S793 = 1;
  private int S645 = 1;
  private int S573 = 1;
  private int S677 = 1;
  private int S655 = 1;
  private int S709 = 1;
  private int S687 = 1;
  private int S741 = 1;
  private int S719 = 1;
  private int S791 = 1;
  private int S757 = 1;
  
  private int[] ends = new int[12];
  private int[] tdone = new int[12];
  
  public void thread822(int [] tdone, int [] ends){
        if(cylClampBottleExtend.getprestatus()){//sysj/CapperController.sysj line: 98, column: 26
      System.out.print("Bottle Clamped ");//sysj/CapperController.sysj line: 99, column: 21
      active[11]=0;
      ends[11]=0;
      tdone[11]=1;
    }
    else {
      System.out.print("Bottle Unclamped ");//sysj/CapperController.sysj line: 101, column: 21
      active[11]=0;
      ends[11]=0;
      tdone[11]=1;
    }
  }

  public void thread821(int [] tdone, int [] ends){
        if(capGripperPos5Extend.getprestatus()){//sysj/CapperController.sysj line: 90, column: 26
      System.out.print("Grip the Cap ");//sysj/CapperController.sysj line: 91, column: 21
      active[10]=0;
      ends[10]=0;
      tdone[10]=1;
    }
    else {
      System.out.print("Release the Cap ");//sysj/CapperController.sysj line: 93, column: 21
      active[10]=0;
      ends[10]=0;
      tdone[10]=1;
    }
  }

  public void thread820(int [] tdone, int [] ends){
        if(gripperTurnExtend.getprestatus()){//sysj/CapperController.sysj line: 84, column: 26
      System.out.printf("Gripper twisting ");//sysj/CapperController.sysj line: 85, column: 21
      active[9]=0;
      ends[9]=0;
      tdone[9]=1;
    }
    else {
      active[9]=0;
      ends[9]=0;
      tdone[9]=1;
    }
  }

  public void thread819(int [] tdone, int [] ends){
        if(gripperTurnRetract.getprestatus()){//sysj/CapperController.sysj line: 78, column: 26
      System.out.printf("Gripper Untwisting ");//sysj/CapperController.sysj line: 79, column: 21
      active[8]=0;
      ends[8]=0;
      tdone[8]=1;
    }
    else {
      active[8]=0;
      ends[8]=0;
      tdone[8]=1;
    }
  }

  public void thread818(int [] tdone, int [] ends){
        if(cylPos5ZaxisExtend.getprestatus()){//sysj/CapperController.sysj line: 70, column: 26
      System.out.printf("Gripper Lower ");//sysj/CapperController.sysj line: 71, column: 21
      active[7]=0;
      ends[7]=0;
      tdone[7]=1;
    }
    else {
      System.out.printf("Gripper Lift ");//sysj/CapperController.sysj line: 73, column: 21
      active[7]=0;
      ends[7]=0;
      tdone[7]=1;
    }
  }

  public void thread816(int [] tdone, int [] ends){
        active[11]=0;
    ends[11]=0;
    tdone[11]=1;
  }

  public void thread815(int [] tdone, int [] ends){
        active[10]=0;
    ends[10]=0;
    tdone[10]=1;
  }

  public void thread814(int [] tdone, int [] ends){
        active[9]=0;
    ends[9]=0;
    tdone[9]=1;
  }

  public void thread813(int [] tdone, int [] ends){
        active[8]=0;
    ends[8]=0;
    tdone[8]=1;
  }

  public void thread812(int [] tdone, int [] ends){
        active[7]=0;
    ends[7]=0;
    tdone[7]=1;
  }

  public void thread811(int [] tdone, int [] ends){
        switch(S791){
      case 0 : 
        active[6]=0;
        ends[6]=0;
        tdone[6]=1;
        break;
      
      case 1 : 
        switch(S757){
          case 0 : 
            thread812(tdone,ends);
            thread813(tdone,ends);
            thread814(tdone,ends);
            thread815(tdone,ends);
            thread816(tdone,ends);
            int biggest817 = 0;
            if(ends[7]>=biggest817){
              biggest817=ends[7];
            }
            if(ends[8]>=biggest817){
              biggest817=ends[8];
            }
            if(ends[9]>=biggest817){
              biggest817=ends[9];
            }
            if(ends[10]>=biggest817){
              biggest817=ends[10];
            }
            if(ends[11]>=biggest817){
              biggest817=ends[11];
            }
            //FINXME code
            if(biggest817 == 0){
              System.out.println("");//sysj/CapperController.sysj line: 105, column: 13
              S757=1;
              active[6]=1;
              ends[6]=1;
              tdone[6]=1;
            }
            break;
          
          case 1 : 
            S757=1;
            S757=0;
            thread818(tdone,ends);
            thread819(tdone,ends);
            thread820(tdone,ends);
            thread821(tdone,ends);
            thread822(tdone,ends);
            int biggest823 = 0;
            if(ends[7]>=biggest823){
              biggest823=ends[7];
            }
            if(ends[8]>=biggest823){
              biggest823=ends[8];
            }
            if(ends[9]>=biggest823){
              biggest823=ends[9];
            }
            if(ends[10]>=biggest823){
              biggest823=ends[10];
            }
            if(ends[11]>=biggest823){
              biggest823=ends[11];
            }
            //FINXME code
            if(biggest823 == 0){
              System.out.println("");//sysj/CapperController.sysj line: 105, column: 13
              S757=1;
              active[6]=1;
              ends[6]=1;
              tdone[6]=1;
            }
            break;
          
        }
        break;
      
    }
  }

  public void thread810(int [] tdone, int [] ends){
        switch(S741){
      case 0 : 
        active[5]=0;
        ends[5]=0;
        tdone[5]=1;
        break;
      
      case 1 : 
        switch(S719){
          case 0 : 
            if(gripCap_1.getprestatus()){//sysj/CapperController.sysj line: 59, column: 20
              S719=1;
              capGripperPos5Extend.setPresent();//sysj/CapperController.sysj line: 61, column: 34
              currsigs.addElement(capGripperPos5Extend);
              active[5]=1;
              ends[5]=1;
              tdone[5]=1;
            }
            else {
              active[5]=1;
              ends[5]=1;
              tdone[5]=1;
            }
            break;
          
          case 1 : 
            if(releaseCap_1.getprestatus()){//sysj/CapperController.sysj line: 61, column: 20
              S719=2;
              active[5]=1;
              ends[5]=1;
              tdone[5]=1;
            }
            else {
              capGripperPos5Extend.setPresent();//sysj/CapperController.sysj line: 61, column: 34
              currsigs.addElement(capGripperPos5Extend);
              active[5]=1;
              ends[5]=1;
              tdone[5]=1;
            }
            break;
          
          case 2 : 
            S719=2;
            S719=0;
            active[5]=1;
            ends[5]=1;
            tdone[5]=1;
            break;
          
        }
        break;
      
    }
  }

  public void thread809(int [] tdone, int [] ends){
        switch(S709){
      case 0 : 
        active[4]=0;
        ends[4]=0;
        tdone[4]=1;
        break;
      
      case 1 : 
        switch(S687){
          case 0 : 
            if(lowerGripper_1.getprestatus()){//sysj/CapperController.sysj line: 49, column: 20
              S687=1;
              cylPos5ZaxisExtend.setPresent();//sysj/CapperController.sysj line: 51, column: 36
              currsigs.addElement(cylPos5ZaxisExtend);
              active[4]=1;
              ends[4]=1;
              tdone[4]=1;
            }
            else {
              active[4]=1;
              ends[4]=1;
              tdone[4]=1;
            }
            break;
          
          case 1 : 
            if(raiseGripper_1.getprestatus()){//sysj/CapperController.sysj line: 51, column: 20
              S687=2;
              active[4]=1;
              ends[4]=1;
              tdone[4]=1;
            }
            else {
              cylPos5ZaxisExtend.setPresent();//sysj/CapperController.sysj line: 51, column: 36
              currsigs.addElement(cylPos5ZaxisExtend);
              active[4]=1;
              ends[4]=1;
              tdone[4]=1;
            }
            break;
          
          case 2 : 
            S687=2;
            S687=0;
            active[4]=1;
            ends[4]=1;
            tdone[4]=1;
            break;
          
        }
        break;
      
    }
  }

  public void thread808(int [] tdone, int [] ends){
        switch(S677){
      case 0 : 
        active[3]=0;
        ends[3]=0;
        tdone[3]=1;
        break;
      
      case 1 : 
        switch(S655){
          case 0 : 
            if(clampBottle_1.getprestatus()){//sysj/CapperController.sysj line: 39, column: 20
              S655=1;
              cylClampBottleExtend.setPresent();//sysj/CapperController.sysj line: 41, column: 37
              currsigs.addElement(cylClampBottleExtend);
              active[3]=1;
              ends[3]=1;
              tdone[3]=1;
            }
            else {
              active[3]=1;
              ends[3]=1;
              tdone[3]=1;
            }
            break;
          
          case 1 : 
            if(unclampBottle_1.getprestatus()){//sysj/CapperController.sysj line: 41, column: 20
              S655=2;
              active[3]=1;
              ends[3]=1;
              tdone[3]=1;
            }
            else {
              cylClampBottleExtend.setPresent();//sysj/CapperController.sysj line: 41, column: 37
              currsigs.addElement(cylClampBottleExtend);
              active[3]=1;
              ends[3]=1;
              tdone[3]=1;
            }
            break;
          
          case 2 : 
            S655=2;
            S655=0;
            active[3]=1;
            ends[3]=1;
            tdone[3]=1;
            break;
          
        }
        break;
      
    }
  }

  public void thread807(int [] tdone, int [] ends){
        switch(S645){
      case 0 : 
        active[2]=0;
        ends[2]=0;
        tdone[2]=1;
        break;
      
      case 1 : 
        switch(S573){
          case 0 : 
            if(bottleAtPos4.getprestatus() && capperDoProcess.getprestatus()){//sysj/CapperController.sysj line: 12, column: 20
              clampBottle_1.setPresent();//sysj/CapperController.sysj line: 14, column: 13
              currsigs.addElement(clampBottle_1);
              lowerGripper_1.setPresent();//sysj/CapperController.sysj line: 15, column: 13
              currsigs.addElement(lowerGripper_1);
              S573=1;
              active[2]=1;
              ends[2]=1;
              tdone[2]=1;
            }
            else {
              capperIdle.setPresent();//sysj/CapperController.sysj line: 12, column: 55
              currsigs.addElement(capperIdle);
              active[2]=1;
              ends[2]=1;
              tdone[2]=1;
            }
            break;
          
          case 1 : 
            if(gripperZAxisLowered.getprestatus()){//sysj/CapperController.sysj line: 17, column: 20
              gripCap_1.setPresent();//sysj/CapperController.sysj line: 19, column: 13
              currsigs.addElement(gripCap_1);
              S573=2;
              gripperTurnExtend.setPresent();//sysj/CapperController.sysj line: 21, column: 43
              currsigs.addElement(gripperTurnExtend);
              active[2]=1;
              ends[2]=1;
              tdone[2]=1;
            }
            else {
              active[2]=1;
              ends[2]=1;
              tdone[2]=1;
            }
            break;
          
          case 2 : 
            if(gripperTurnFinalPos.getprestatus()){//sysj/CapperController.sysj line: 21, column: 20
              releaseCap_1.setPresent();//sysj/CapperController.sysj line: 23, column: 13
              currsigs.addElement(releaseCap_1);
              S573=3;
              gripperTurnRetract.setPresent();//sysj/CapperController.sysj line: 25, column: 42
              currsigs.addElement(gripperTurnRetract);
              active[2]=1;
              ends[2]=1;
              tdone[2]=1;
            }
            else {
              gripperTurnExtend.setPresent();//sysj/CapperController.sysj line: 21, column: 43
              currsigs.addElement(gripperTurnExtend);
              active[2]=1;
              ends[2]=1;
              tdone[2]=1;
            }
            break;
          
          case 3 : 
            if(gripperTurnHomePos.getprestatus()){//sysj/CapperController.sysj line: 25, column: 20
              raiseGripper_1.setPresent();//sysj/CapperController.sysj line: 27, column: 13
              currsigs.addElement(raiseGripper_1);
              S573=4;
              active[2]=1;
              ends[2]=1;
              tdone[2]=1;
            }
            else {
              gripperTurnRetract.setPresent();//sysj/CapperController.sysj line: 25, column: 42
              currsigs.addElement(gripperTurnRetract);
              active[2]=1;
              ends[2]=1;
              tdone[2]=1;
            }
            break;
          
          case 4 : 
            if(gripperZAxisLifted.getprestatus()){//sysj/CapperController.sysj line: 29, column: 20
              unclampBottle_1.setPresent();//sysj/CapperController.sysj line: 31, column: 13
              currsigs.addElement(unclampBottle_1);
              S573=5;
              active[2]=1;
              ends[2]=1;
              tdone[2]=1;
            }
            else {
              active[2]=1;
              ends[2]=1;
              tdone[2]=1;
            }
            break;
          
          case 5 : 
            S573=5;
            S573=0;
            capperIdle.setPresent();//sysj/CapperController.sysj line: 12, column: 55
            currsigs.addElement(capperIdle);
            active[2]=1;
            ends[2]=1;
            tdone[2]=1;
            break;
          
        }
        break;
      
    }
  }

  public void thread804(int [] tdone, int [] ends){
        if(cylClampBottleExtend.getprestatus()){//sysj/CapperController.sysj line: 98, column: 26
      System.out.print("Bottle Clamped ");//sysj/CapperController.sysj line: 99, column: 21
      active[11]=0;
      ends[11]=0;
      tdone[11]=1;
    }
    else {
      System.out.print("Bottle Unclamped ");//sysj/CapperController.sysj line: 101, column: 21
      active[11]=0;
      ends[11]=0;
      tdone[11]=1;
    }
  }

  public void thread803(int [] tdone, int [] ends){
        if(capGripperPos5Extend.getprestatus()){//sysj/CapperController.sysj line: 90, column: 26
      System.out.print("Grip the Cap ");//sysj/CapperController.sysj line: 91, column: 21
      active[10]=0;
      ends[10]=0;
      tdone[10]=1;
    }
    else {
      System.out.print("Release the Cap ");//sysj/CapperController.sysj line: 93, column: 21
      active[10]=0;
      ends[10]=0;
      tdone[10]=1;
    }
  }

  public void thread802(int [] tdone, int [] ends){
        if(gripperTurnExtend.getprestatus()){//sysj/CapperController.sysj line: 84, column: 26
      System.out.printf("Gripper twisting ");//sysj/CapperController.sysj line: 85, column: 21
      active[9]=0;
      ends[9]=0;
      tdone[9]=1;
    }
    else {
      active[9]=0;
      ends[9]=0;
      tdone[9]=1;
    }
  }

  public void thread801(int [] tdone, int [] ends){
        if(gripperTurnRetract.getprestatus()){//sysj/CapperController.sysj line: 78, column: 26
      System.out.printf("Gripper Untwisting ");//sysj/CapperController.sysj line: 79, column: 21
      active[8]=0;
      ends[8]=0;
      tdone[8]=1;
    }
    else {
      active[8]=0;
      ends[8]=0;
      tdone[8]=1;
    }
  }

  public void thread800(int [] tdone, int [] ends){
        if(cylPos5ZaxisExtend.getprestatus()){//sysj/CapperController.sysj line: 70, column: 26
      System.out.printf("Gripper Lower ");//sysj/CapperController.sysj line: 71, column: 21
      active[7]=0;
      ends[7]=0;
      tdone[7]=1;
    }
    else {
      System.out.printf("Gripper Lift ");//sysj/CapperController.sysj line: 73, column: 21
      active[7]=0;
      ends[7]=0;
      tdone[7]=1;
    }
  }

  public void thread799(int [] tdone, int [] ends){
        S791=1;
    S757=0;
    thread800(tdone,ends);
    thread801(tdone,ends);
    thread802(tdone,ends);
    thread803(tdone,ends);
    thread804(tdone,ends);
    int biggest805 = 0;
    if(ends[7]>=biggest805){
      biggest805=ends[7];
    }
    if(ends[8]>=biggest805){
      biggest805=ends[8];
    }
    if(ends[9]>=biggest805){
      biggest805=ends[9];
    }
    if(ends[10]>=biggest805){
      biggest805=ends[10];
    }
    if(ends[11]>=biggest805){
      biggest805=ends[11];
    }
    //FINXME code
    if(biggest805 == 0){
      System.out.println("");//sysj/CapperController.sysj line: 105, column: 13
      S757=1;
      active[6]=1;
      ends[6]=1;
      tdone[6]=1;
    }
  }

  public void thread798(int [] tdone, int [] ends){
        S741=1;
    S719=0;
    active[5]=1;
    ends[5]=1;
    tdone[5]=1;
  }

  public void thread797(int [] tdone, int [] ends){
        S709=1;
    S687=0;
    active[4]=1;
    ends[4]=1;
    tdone[4]=1;
  }

  public void thread796(int [] tdone, int [] ends){
        S677=1;
    S655=0;
    active[3]=1;
    ends[3]=1;
    tdone[3]=1;
  }

  public void thread795(int [] tdone, int [] ends){
        S645=1;
    S573=0;
    capperIdle.setPresent();//sysj/CapperController.sysj line: 12, column: 55
    currsigs.addElement(capperIdle);
    active[2]=1;
    ends[2]=1;
    tdone[2]=1;
  }

  public void runClockDomain(){
    for(int i=0;i<ends.length;i++){
      ends[i] = 0;
      tdone[i] = 0;
    }
    
    RUN: while(true){
      switch(S793){
        case 0 : 
          S793=0;
          break RUN;
        
        case 1 : 
          S793=2;
          S793=2;
          clampBottle_1.setClear();//sysj/CapperController.sysj line: 6, column: 5
          unclampBottle_1.setClear();//sysj/CapperController.sysj line: 6, column: 5
          raiseGripper_1.setClear();//sysj/CapperController.sysj line: 7, column: 5
          lowerGripper_1.setClear();//sysj/CapperController.sysj line: 7, column: 5
          gripCap_1.setClear();//sysj/CapperController.sysj line: 8, column: 5
          releaseCap_1.setClear();//sysj/CapperController.sysj line: 8, column: 5
          thread795(tdone,ends);
          thread796(tdone,ends);
          thread797(tdone,ends);
          thread798(tdone,ends);
          thread799(tdone,ends);
          int biggest806 = 0;
          if(ends[2]>=biggest806){
            biggest806=ends[2];
          }
          if(ends[3]>=biggest806){
            biggest806=ends[3];
          }
          if(ends[4]>=biggest806){
            biggest806=ends[4];
          }
          if(ends[5]>=biggest806){
            biggest806=ends[5];
          }
          if(ends[6]>=biggest806){
            biggest806=ends[6];
          }
          if(biggest806 == 1){
            active[1]=1;
            ends[1]=1;
            break RUN;
          }
        
        case 2 : 
          clampBottle_1.setClear();//sysj/CapperController.sysj line: 6, column: 5
          unclampBottle_1.setClear();//sysj/CapperController.sysj line: 6, column: 5
          raiseGripper_1.setClear();//sysj/CapperController.sysj line: 7, column: 5
          lowerGripper_1.setClear();//sysj/CapperController.sysj line: 7, column: 5
          gripCap_1.setClear();//sysj/CapperController.sysj line: 8, column: 5
          releaseCap_1.setClear();//sysj/CapperController.sysj line: 8, column: 5
          thread807(tdone,ends);
          thread808(tdone,ends);
          thread809(tdone,ends);
          thread810(tdone,ends);
          thread811(tdone,ends);
          int biggest824 = 0;
          if(ends[2]>=biggest824){
            biggest824=ends[2];
          }
          if(ends[3]>=biggest824){
            biggest824=ends[3];
          }
          if(ends[4]>=biggest824){
            biggest824=ends[4];
          }
          if(ends[5]>=biggest824){
            biggest824=ends[5];
          }
          if(ends[6]>=biggest824){
            biggest824=ends[6];
          }
          if(biggest824 == 1){
            active[1]=1;
            ends[1]=1;
            break RUN;
          }
          //FINXME code
          if(biggest824 == 0){
            S793=0;
            active[1]=0;
            ends[1]=0;
            S793=0;
            break RUN;
          }
        
      }
    }
  }

  public void init(){
    char [] active1 = {1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1};
    char [] paused1 = {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0};
    char [] suspended1 = {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0};
    paused = paused1;
    active = active1;
    suspended = suspended1;
    // Now instantiate all the local signals ONLY
    clampBottle_1 = new Signal();
    unclampBottle_1 = new Signal();
    raiseGripper_1 = new Signal();
    lowerGripper_1 = new Signal();
    gripCap_1 = new Signal();
    releaseCap_1 = new Signal();
    // --------------------------------------------------
  }
  
  public void run(){
    while(active[1] != 0){
      int index = 1;
      if(paused[index]==1 || suspended[index]==1 || active[index] == 0){
        for(int h=1;h<paused.length;++h){
          paused[h]=0;
        }
      }
      if(paused[1]!=0 || suspended[1]!=0 || active[1]!=1);
      else{
        if(!df){
          bottleAtPos4.gethook();
          gripperZAxisLowered.gethook();
          gripperZAxisLifted.gethook();
          gripperTurnHomePos.gethook();
          gripperTurnFinalPos.gethook();
          capperDoProcess.gethook();
          df = true;
        }
        runClockDomain();
      }
      bottleAtPos4.setpreclear();
      gripperZAxisLowered.setpreclear();
      gripperZAxisLifted.setpreclear();
      gripperTurnHomePos.setpreclear();
      gripperTurnFinalPos.setpreclear();
      capperDoProcess.setpreclear();
      cylPos5ZaxisExtend.setpreclear();
      gripperTurnRetract.setpreclear();
      gripperTurnExtend.setpreclear();
      capGripperPos5Extend.setpreclear();
      cylClampBottleExtend.setpreclear();
      capperIdle.setpreclear();
      clampBottle_1.setpreclear();
      unclampBottle_1.setpreclear();
      raiseGripper_1.setpreclear();
      lowerGripper_1.setpreclear();
      gripCap_1.setpreclear();
      releaseCap_1.setpreclear();
      int dummyint = 0;
      for(int qw=0;qw<currsigs.size();++qw){
        dummyint = ((Signal)currsigs.elementAt(qw)).getStatus() ? ((Signal)currsigs.elementAt(qw)).setprepresent() : ((Signal)currsigs.elementAt(qw)).setpreclear();
        ((Signal)currsigs.elementAt(qw)).setpreval(((Signal)currsigs.elementAt(qw)).getValue());
      }
      currsigs.removeAllElements();
      dummyint = bottleAtPos4.getStatus() ? bottleAtPos4.setprepresent() : bottleAtPos4.setpreclear();
      bottleAtPos4.setpreval(bottleAtPos4.getValue());
      bottleAtPos4.setClear();
      dummyint = gripperZAxisLowered.getStatus() ? gripperZAxisLowered.setprepresent() : gripperZAxisLowered.setpreclear();
      gripperZAxisLowered.setpreval(gripperZAxisLowered.getValue());
      gripperZAxisLowered.setClear();
      dummyint = gripperZAxisLifted.getStatus() ? gripperZAxisLifted.setprepresent() : gripperZAxisLifted.setpreclear();
      gripperZAxisLifted.setpreval(gripperZAxisLifted.getValue());
      gripperZAxisLifted.setClear();
      dummyint = gripperTurnHomePos.getStatus() ? gripperTurnHomePos.setprepresent() : gripperTurnHomePos.setpreclear();
      gripperTurnHomePos.setpreval(gripperTurnHomePos.getValue());
      gripperTurnHomePos.setClear();
      dummyint = gripperTurnFinalPos.getStatus() ? gripperTurnFinalPos.setprepresent() : gripperTurnFinalPos.setpreclear();
      gripperTurnFinalPos.setpreval(gripperTurnFinalPos.getValue());
      gripperTurnFinalPos.setClear();
      dummyint = capperDoProcess.getStatus() ? capperDoProcess.setprepresent() : capperDoProcess.setpreclear();
      capperDoProcess.setpreval(capperDoProcess.getValue());
      capperDoProcess.setClear();
      cylPos5ZaxisExtend.sethook();
      cylPos5ZaxisExtend.setClear();
      gripperTurnRetract.sethook();
      gripperTurnRetract.setClear();
      gripperTurnExtend.sethook();
      gripperTurnExtend.setClear();
      capGripperPos5Extend.sethook();
      capGripperPos5Extend.setClear();
      cylClampBottleExtend.sethook();
      cylClampBottleExtend.setClear();
      capperIdle.sethook();
      capperIdle.setClear();
      clampBottle_1.setClear();
      unclampBottle_1.setClear();
      raiseGripper_1.setClear();
      lowerGripper_1.setClear();
      gripCap_1.setClear();
      releaseCap_1.setClear();
      if(paused[1]!=0 || suspended[1]!=0 || active[1]!=1);
      else{
        bottleAtPos4.gethook();
        gripperZAxisLowered.gethook();
        gripperZAxisLifted.gethook();
        gripperTurnHomePos.gethook();
        gripperTurnFinalPos.gethook();
        capperDoProcess.gethook();
      }
      runFinisher();
      if(active[1] == 0){
      	this.terminated = true;
      }
      if(!threaded) break;
    }
  }
}
