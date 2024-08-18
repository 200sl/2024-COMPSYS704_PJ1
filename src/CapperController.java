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
  public Signal doProcess = new Signal("doProcess", Signal.INPUT);
  public Signal cylPos5ZaxisExtend = new Signal("cylPos5ZaxisExtend", Signal.OUTPUT);
  public Signal gripperTurnRetract = new Signal("gripperTurnRetract", Signal.OUTPUT);
  public Signal gripperTurnExtend = new Signal("gripperTurnExtend", Signal.OUTPUT);
  public Signal capGripperPos5Extend = new Signal("capGripperPos5Extend", Signal.OUTPUT);
  public Signal cylClampBottleExtend = new Signal("cylClampBottleExtend", Signal.OUTPUT);
  private Signal clampBottle_1;
  private Signal unclampBottle_1;
  private Signal raiseGripper_1;
  private Signal lowerGripper_1;
  private Signal gripCap_1;
  private Signal releaseCap_1;
  private int S631 = 1;
  private int S483 = 1;
  private int S417 = 1;
  private int S515 = 1;
  private int S493 = 1;
  private int S547 = 1;
  private int S525 = 1;
  private int S579 = 1;
  private int S557 = 1;
  private int S629 = 1;
  private int S595 = 1;
  
  private int[] ends = new int[12];
  private int[] tdone = new int[12];
  
  public void thread660(int [] tdone, int [] ends){
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

  public void thread659(int [] tdone, int [] ends){
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

  public void thread658(int [] tdone, int [] ends){
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

  public void thread657(int [] tdone, int [] ends){
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

  public void thread656(int [] tdone, int [] ends){
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

  public void thread654(int [] tdone, int [] ends){
        active[11]=0;
    ends[11]=0;
    tdone[11]=1;
  }

  public void thread653(int [] tdone, int [] ends){
        active[10]=0;
    ends[10]=0;
    tdone[10]=1;
  }

  public void thread652(int [] tdone, int [] ends){
        active[9]=0;
    ends[9]=0;
    tdone[9]=1;
  }

  public void thread651(int [] tdone, int [] ends){
        active[8]=0;
    ends[8]=0;
    tdone[8]=1;
  }

  public void thread650(int [] tdone, int [] ends){
        active[7]=0;
    ends[7]=0;
    tdone[7]=1;
  }

  public void thread649(int [] tdone, int [] ends){
        switch(S629){
      case 0 : 
        active[6]=0;
        ends[6]=0;
        tdone[6]=1;
        break;
      
      case 1 : 
        switch(S595){
          case 0 : 
            thread650(tdone,ends);
            thread651(tdone,ends);
            thread652(tdone,ends);
            thread653(tdone,ends);
            thread654(tdone,ends);
            int biggest655 = 0;
            if(ends[7]>=biggest655){
              biggest655=ends[7];
            }
            if(ends[8]>=biggest655){
              biggest655=ends[8];
            }
            if(ends[9]>=biggest655){
              biggest655=ends[9];
            }
            if(ends[10]>=biggest655){
              biggest655=ends[10];
            }
            if(ends[11]>=biggest655){
              biggest655=ends[11];
            }
            //FINXME code
            if(biggest655 == 0){
              System.out.println("");//sysj/CapperController.sysj line: 105, column: 13
              S595=1;
              active[6]=1;
              ends[6]=1;
              tdone[6]=1;
            }
            break;
          
          case 1 : 
            S595=1;
            S595=0;
            thread656(tdone,ends);
            thread657(tdone,ends);
            thread658(tdone,ends);
            thread659(tdone,ends);
            thread660(tdone,ends);
            int biggest661 = 0;
            if(ends[7]>=biggest661){
              biggest661=ends[7];
            }
            if(ends[8]>=biggest661){
              biggest661=ends[8];
            }
            if(ends[9]>=biggest661){
              biggest661=ends[9];
            }
            if(ends[10]>=biggest661){
              biggest661=ends[10];
            }
            if(ends[11]>=biggest661){
              biggest661=ends[11];
            }
            //FINXME code
            if(biggest661 == 0){
              System.out.println("");//sysj/CapperController.sysj line: 105, column: 13
              S595=1;
              active[6]=1;
              ends[6]=1;
              tdone[6]=1;
            }
            break;
          
        }
        break;
      
    }
  }

  public void thread648(int [] tdone, int [] ends){
        switch(S579){
      case 0 : 
        active[5]=0;
        ends[5]=0;
        tdone[5]=1;
        break;
      
      case 1 : 
        switch(S557){
          case 0 : 
            if(gripCap_1.getprestatus()){//sysj/CapperController.sysj line: 59, column: 20
              S557=1;
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
              S557=2;
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
            S557=2;
            S557=0;
            active[5]=1;
            ends[5]=1;
            tdone[5]=1;
            break;
          
        }
        break;
      
    }
  }

  public void thread647(int [] tdone, int [] ends){
        switch(S547){
      case 0 : 
        active[4]=0;
        ends[4]=0;
        tdone[4]=1;
        break;
      
      case 1 : 
        switch(S525){
          case 0 : 
            if(lowerGripper_1.getprestatus()){//sysj/CapperController.sysj line: 49, column: 20
              S525=1;
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
              S525=2;
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
            S525=2;
            S525=0;
            active[4]=1;
            ends[4]=1;
            tdone[4]=1;
            break;
          
        }
        break;
      
    }
  }

  public void thread646(int [] tdone, int [] ends){
        switch(S515){
      case 0 : 
        active[3]=0;
        ends[3]=0;
        tdone[3]=1;
        break;
      
      case 1 : 
        switch(S493){
          case 0 : 
            if(clampBottle_1.getprestatus()){//sysj/CapperController.sysj line: 39, column: 20
              S493=1;
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
              S493=2;
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
            S493=2;
            S493=0;
            active[3]=1;
            ends[3]=1;
            tdone[3]=1;
            break;
          
        }
        break;
      
    }
  }

  public void thread645(int [] tdone, int [] ends){
        switch(S483){
      case 0 : 
        active[2]=0;
        ends[2]=0;
        tdone[2]=1;
        break;
      
      case 1 : 
        switch(S417){
          case 0 : 
            if(bottleAtPos4.getprestatus() && doProcess.getprestatus()){//sysj/CapperController.sysj line: 12, column: 20
              clampBottle_1.setPresent();//sysj/CapperController.sysj line: 14, column: 13
              currsigs.addElement(clampBottle_1);
              lowerGripper_1.setPresent();//sysj/CapperController.sysj line: 15, column: 13
              currsigs.addElement(lowerGripper_1);
              S417=1;
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
          
          case 1 : 
            if(gripperZAxisLowered.getprestatus()){//sysj/CapperController.sysj line: 17, column: 20
              gripCap_1.setPresent();//sysj/CapperController.sysj line: 19, column: 13
              currsigs.addElement(gripCap_1);
              S417=2;
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
              S417=3;
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
              S417=4;
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
              S417=5;
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
            S417=5;
            S417=0;
            active[2]=1;
            ends[2]=1;
            tdone[2]=1;
            break;
          
        }
        break;
      
    }
  }

  public void thread642(int [] tdone, int [] ends){
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

  public void thread641(int [] tdone, int [] ends){
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

  public void thread640(int [] tdone, int [] ends){
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

  public void thread639(int [] tdone, int [] ends){
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

  public void thread638(int [] tdone, int [] ends){
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

  public void thread637(int [] tdone, int [] ends){
        S629=1;
    S595=0;
    thread638(tdone,ends);
    thread639(tdone,ends);
    thread640(tdone,ends);
    thread641(tdone,ends);
    thread642(tdone,ends);
    int biggest643 = 0;
    if(ends[7]>=biggest643){
      biggest643=ends[7];
    }
    if(ends[8]>=biggest643){
      biggest643=ends[8];
    }
    if(ends[9]>=biggest643){
      biggest643=ends[9];
    }
    if(ends[10]>=biggest643){
      biggest643=ends[10];
    }
    if(ends[11]>=biggest643){
      biggest643=ends[11];
    }
    //FINXME code
    if(biggest643 == 0){
      System.out.println("");//sysj/CapperController.sysj line: 105, column: 13
      S595=1;
      active[6]=1;
      ends[6]=1;
      tdone[6]=1;
    }
  }

  public void thread636(int [] tdone, int [] ends){
        S579=1;
    S557=0;
    active[5]=1;
    ends[5]=1;
    tdone[5]=1;
  }

  public void thread635(int [] tdone, int [] ends){
        S547=1;
    S525=0;
    active[4]=1;
    ends[4]=1;
    tdone[4]=1;
  }

  public void thread634(int [] tdone, int [] ends){
        S515=1;
    S493=0;
    active[3]=1;
    ends[3]=1;
    tdone[3]=1;
  }

  public void thread633(int [] tdone, int [] ends){
        S483=1;
    S417=0;
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
      switch(S631){
        case 0 : 
          S631=0;
          break RUN;
        
        case 1 : 
          S631=2;
          S631=2;
          clampBottle_1.setClear();//sysj/CapperController.sysj line: 6, column: 5
          unclampBottle_1.setClear();//sysj/CapperController.sysj line: 6, column: 5
          raiseGripper_1.setClear();//sysj/CapperController.sysj line: 7, column: 5
          lowerGripper_1.setClear();//sysj/CapperController.sysj line: 7, column: 5
          gripCap_1.setClear();//sysj/CapperController.sysj line: 8, column: 5
          releaseCap_1.setClear();//sysj/CapperController.sysj line: 8, column: 5
          thread633(tdone,ends);
          thread634(tdone,ends);
          thread635(tdone,ends);
          thread636(tdone,ends);
          thread637(tdone,ends);
          int biggest644 = 0;
          if(ends[2]>=biggest644){
            biggest644=ends[2];
          }
          if(ends[3]>=biggest644){
            biggest644=ends[3];
          }
          if(ends[4]>=biggest644){
            biggest644=ends[4];
          }
          if(ends[5]>=biggest644){
            biggest644=ends[5];
          }
          if(ends[6]>=biggest644){
            biggest644=ends[6];
          }
          if(biggest644 == 1){
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
          thread645(tdone,ends);
          thread646(tdone,ends);
          thread647(tdone,ends);
          thread648(tdone,ends);
          thread649(tdone,ends);
          int biggest662 = 0;
          if(ends[2]>=biggest662){
            biggest662=ends[2];
          }
          if(ends[3]>=biggest662){
            biggest662=ends[3];
          }
          if(ends[4]>=biggest662){
            biggest662=ends[4];
          }
          if(ends[5]>=biggest662){
            biggest662=ends[5];
          }
          if(ends[6]>=biggest662){
            biggest662=ends[6];
          }
          if(biggest662 == 1){
            active[1]=1;
            ends[1]=1;
            break RUN;
          }
          //FINXME code
          if(biggest662 == 0){
            S631=0;
            active[1]=0;
            ends[1]=0;
            S631=0;
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
          doProcess.gethook();
          df = true;
        }
        runClockDomain();
      }
      bottleAtPos4.setpreclear();
      gripperZAxisLowered.setpreclear();
      gripperZAxisLifted.setpreclear();
      gripperTurnHomePos.setpreclear();
      gripperTurnFinalPos.setpreclear();
      doProcess.setpreclear();
      cylPos5ZaxisExtend.setpreclear();
      gripperTurnRetract.setpreclear();
      gripperTurnExtend.setpreclear();
      capGripperPos5Extend.setpreclear();
      cylClampBottleExtend.setpreclear();
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
      dummyint = doProcess.getStatus() ? doProcess.setprepresent() : doProcess.setpreclear();
      doProcess.setpreval(doProcess.getValue());
      doProcess.setClear();
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
        doProcess.gethook();
      }
      runFinisher();
      if(active[1] == 0){
      	this.terminated = true;
      }
      if(!threaded) break;
    }
  }
}
