import java.util.*;
import com.systemj.ClockDomain;
import com.systemj.Signal;
import com.systemj.input_Channel;
import com.systemj.output_Channel;

public class RotaryTableController extends ClockDomain{
  public RotaryTableController(String name){super(name);}
  Vector currsigs = new Vector();
  private boolean df = false;
  private char [] active;
  private char [] paused;
  private char [] suspended;
  public Signal tableAlignedWithSensor = new Signal("tableAlignedWithSensor", Signal.INPUT);
  public Signal bottleAtPos5 = new Signal("bottleAtPos5", Signal.INPUT);
  public Signal capOnBottleAtPos1 = new Signal("capOnBottleAtPos1", Signal.INPUT);
  public Signal move2NextPos = new Signal("move2NextPos", Signal.INPUT);
  public Signal rotaryTableTrigger = new Signal("rotaryTableTrigger", Signal.OUTPUT);
  public Signal rotaryIdle = new Signal("rotaryIdle", Signal.OUTPUT);
  private Signal turnOnRotary_1;
  private Signal turnOffRotary_1;
  private long __start_thread_2;//sysj/RotaryTableController.sysj line: 8, column: 5
  private long __start_thread_4;//sysj/RotaryTableController.sysj line: 34, column: 5
  private int S553 = 1;
  private int S367 = 1;
  private int S79 = 1;
  private int S81 = 1;
  private int S112 = 1;
  private int S399 = 1;
  private int S377 = 1;
  private int S551 = 1;
  private int S401 = 1;
  
  private int[] ends = new int[5];
  private int[] tdone = new int[5];
  
  public void thread561(int [] tdone, int [] ends){
        switch(S551){
      case 0 : 
        active[4]=0;
        ends[4]=0;
        tdone[4]=1;
        break;
      
      case 1 : 
        switch(S401){
          case 0 : 
            S401=0;
            S401=1;
            __start_thread_4 = com.systemj.Timer.getMs();//sysj/RotaryTableController.sysj line: 34, column: 5
            if(com.systemj.Timer.getMs() - __start_thread_4 >= 1000){//sysj/RotaryTableController.sysj line: 34, column: 5
              ends[4]=2;
              ;//sysj/RotaryTableController.sysj line: 34, column: 5
              if(rotaryTableTrigger.getprestatus()){//sysj/RotaryTableController.sysj line: 36, column: 22
                System.out.println("rotaryOn");//sysj/RotaryTableController.sysj line: 37, column: 17
                S401=0;
                active[4]=1;
                ends[4]=1;
                tdone[4]=1;
              }
              else {
                System.out.println("rotaryOff");//sysj/RotaryTableController.sysj line: 39, column: 17
                S401=0;
                active[4]=1;
                ends[4]=1;
                tdone[4]=1;
              }
            }
            else {
              active[4]=1;
              ends[4]=1;
              tdone[4]=1;
            }
            break;
          
          case 1 : 
            if(com.systemj.Timer.getMs() - __start_thread_4 >= 1000){//sysj/RotaryTableController.sysj line: 34, column: 5
              ends[4]=2;
              ;//sysj/RotaryTableController.sysj line: 34, column: 5
              if(rotaryTableTrigger.getprestatus()){//sysj/RotaryTableController.sysj line: 36, column: 22
                System.out.println("rotaryOn");//sysj/RotaryTableController.sysj line: 37, column: 17
                S401=0;
                active[4]=1;
                ends[4]=1;
                tdone[4]=1;
              }
              else {
                System.out.println("rotaryOff");//sysj/RotaryTableController.sysj line: 39, column: 17
                S401=0;
                active[4]=1;
                ends[4]=1;
                tdone[4]=1;
              }
            }
            else {
              active[4]=1;
              ends[4]=1;
              tdone[4]=1;
            }
            break;
          
        }
        break;
      
    }
  }

  public void thread560(int [] tdone, int [] ends){
        switch(S399){
      case 0 : 
        active[3]=0;
        ends[3]=0;
        tdone[3]=1;
        break;
      
      case 1 : 
        switch(S377){
          case 0 : 
            if(turnOnRotary_1.getprestatus()){//sysj/RotaryTableController.sysj line: 26, column: 20
              S377=1;
              rotaryTableTrigger.setPresent();//sysj/RotaryTableController.sysj line: 28, column: 37
              currsigs.addElement(rotaryTableTrigger);
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
            if(turnOffRotary_1.getprestatus()){//sysj/RotaryTableController.sysj line: 28, column: 20
              S377=2;
              active[3]=1;
              ends[3]=1;
              tdone[3]=1;
            }
            else {
              rotaryTableTrigger.setPresent();//sysj/RotaryTableController.sysj line: 28, column: 37
              currsigs.addElement(rotaryTableTrigger);
              active[3]=1;
              ends[3]=1;
              tdone[3]=1;
            }
            break;
          
          case 2 : 
            S377=2;
            S377=0;
            active[3]=1;
            ends[3]=1;
            tdone[3]=1;
            break;
          
        }
        break;
      
    }
  }

  public void thread559(int [] tdone, int [] ends){
        switch(S367){
      case 0 : 
        active[2]=0;
        ends[2]=0;
        tdone[2]=1;
        break;
      
      case 1 : 
        switch(S79){
          case 0 : 
            if(move2NextPos.getprestatus() && !bottleAtPos5.getprestatus() && !capOnBottleAtPos1.getprestatus()){//sysj/RotaryTableController.sysj line: 9, column: 16
              turnOnRotary_1.setPresent();//sysj/RotaryTableController.sysj line: 11, column: 9
              currsigs.addElement(turnOnRotary_1);
              S79=1;
              __start_thread_2 = com.systemj.Timer.getMs();//sysj/RotaryTableController.sysj line: 8, column: 5
              S81=0;
              if(com.systemj.Timer.getMs() - __start_thread_2 >= 500){//sysj/RotaryTableController.sysj line: 8, column: 5
                ends[2]=2;
                ;//sysj/RotaryTableController.sysj line: 8, column: 5
                S79=2;
                S112=0;
                if(tableAlignedWithSensor.getprestatus()){//sysj/RotaryTableController.sysj line: 17, column: 26
                  turnOffRotary_1.setPresent();//sysj/RotaryTableController.sysj line: 17, column: 52
                  currsigs.addElement(turnOffRotary_1);
                  active[2]=1;
                  ends[2]=1;
                  tdone[2]=1;
                }
                else {
                  S112=1;
                  active[2]=1;
                  ends[2]=1;
                  tdone[2]=1;
                }
              }
              else {
                S81=1;
                active[2]=1;
                ends[2]=1;
                tdone[2]=1;
              }
            }
            else {
              rotaryIdle.setPresent();//sysj/RotaryTableController.sysj line: 9, column: 83
              currsigs.addElement(rotaryIdle);
              active[2]=1;
              ends[2]=1;
              tdone[2]=1;
            }
            break;
          
          case 1 : 
            switch(S81){
              case 0 : 
                S81=0;
                if(com.systemj.Timer.getMs() - __start_thread_2 >= 500){//sysj/RotaryTableController.sysj line: 8, column: 5
                  ends[2]=2;
                  ;//sysj/RotaryTableController.sysj line: 8, column: 5
                  S79=2;
                  S112=0;
                  if(tableAlignedWithSensor.getprestatus()){//sysj/RotaryTableController.sysj line: 17, column: 26
                    turnOffRotary_1.setPresent();//sysj/RotaryTableController.sysj line: 17, column: 52
                    currsigs.addElement(turnOffRotary_1);
                    active[2]=1;
                    ends[2]=1;
                    tdone[2]=1;
                  }
                  else {
                    S112=1;
                    active[2]=1;
                    ends[2]=1;
                    tdone[2]=1;
                  }
                }
                else {
                  S81=1;
                  active[2]=1;
                  ends[2]=1;
                  tdone[2]=1;
                }
                break;
              
              case 1 : 
                S81=1;
                S81=0;
                if(com.systemj.Timer.getMs() - __start_thread_2 >= 500){//sysj/RotaryTableController.sysj line: 8, column: 5
                  ends[2]=2;
                  ;//sysj/RotaryTableController.sysj line: 8, column: 5
                  S79=2;
                  S112=0;
                  if(tableAlignedWithSensor.getprestatus()){//sysj/RotaryTableController.sysj line: 17, column: 26
                    turnOffRotary_1.setPresent();//sysj/RotaryTableController.sysj line: 17, column: 52
                    currsigs.addElement(turnOffRotary_1);
                    active[2]=1;
                    ends[2]=1;
                    tdone[2]=1;
                  }
                  else {
                    S112=1;
                    active[2]=1;
                    ends[2]=1;
                    tdone[2]=1;
                  }
                }
                else {
                  S81=1;
                  active[2]=1;
                  ends[2]=1;
                  tdone[2]=1;
                }
                break;
              
            }
            break;
          
          case 2 : 
            if(!rotaryTableTrigger.getprestatus()){//sysj/RotaryTableController.sysj line: 15, column: 16
              S79=0;
              rotaryIdle.setPresent();//sysj/RotaryTableController.sysj line: 9, column: 83
              currsigs.addElement(rotaryIdle);
              active[2]=1;
              ends[2]=1;
              tdone[2]=1;
            }
            else {
              switch(S112){
                case 0 : 
                  turnOffRotary_1.setPresent();//sysj/RotaryTableController.sysj line: 17, column: 52
                  currsigs.addElement(turnOffRotary_1);
                  active[2]=1;
                  ends[2]=1;
                  tdone[2]=1;
                  break;
                
                case 1 : 
                  S112=1;
                  S112=0;
                  if(tableAlignedWithSensor.getprestatus()){//sysj/RotaryTableController.sysj line: 17, column: 26
                    turnOffRotary_1.setPresent();//sysj/RotaryTableController.sysj line: 17, column: 52
                    currsigs.addElement(turnOffRotary_1);
                    active[2]=1;
                    ends[2]=1;
                    tdone[2]=1;
                  }
                  else {
                    S112=1;
                    active[2]=1;
                    ends[2]=1;
                    tdone[2]=1;
                  }
                  break;
                
              }
            }
            break;
          
        }
        break;
      
    }
  }

  public void thread557(int [] tdone, int [] ends){
        S551=1;
    if(rotaryTableTrigger.getprestatus()){//sysj/RotaryTableController.sysj line: 36, column: 22
      System.out.println("rotaryOn");//sysj/RotaryTableController.sysj line: 37, column: 17
      S401=0;
      active[4]=1;
      ends[4]=1;
      tdone[4]=1;
    }
    else {
      System.out.println("rotaryOff");//sysj/RotaryTableController.sysj line: 39, column: 17
      S401=0;
      active[4]=1;
      ends[4]=1;
      tdone[4]=1;
    }
  }

  public void thread556(int [] tdone, int [] ends){
        S399=1;
    S377=0;
    active[3]=1;
    ends[3]=1;
    tdone[3]=1;
  }

  public void thread555(int [] tdone, int [] ends){
        S367=1;
    S79=0;
    rotaryIdle.setPresent();//sysj/RotaryTableController.sysj line: 9, column: 83
    currsigs.addElement(rotaryIdle);
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
      switch(S553){
        case 0 : 
          S553=0;
          break RUN;
        
        case 1 : 
          S553=2;
          S553=2;
          turnOnRotary_1.setClear();//sysj/RotaryTableController.sysj line: 6, column: 5
          turnOffRotary_1.setClear();//sysj/RotaryTableController.sysj line: 6, column: 5
          thread555(tdone,ends);
          thread556(tdone,ends);
          thread557(tdone,ends);
          int biggest558 = 0;
          if(ends[2]>=biggest558){
            biggest558=ends[2];
          }
          if(ends[3]>=biggest558){
            biggest558=ends[3];
          }
          if(ends[4]>=biggest558){
            biggest558=ends[4];
          }
          if(biggest558 == 1){
            active[1]=1;
            ends[1]=1;
            break RUN;
          }
        
        case 2 : 
          turnOnRotary_1.setClear();//sysj/RotaryTableController.sysj line: 6, column: 5
          turnOffRotary_1.setClear();//sysj/RotaryTableController.sysj line: 6, column: 5
          thread559(tdone,ends);
          thread560(tdone,ends);
          thread561(tdone,ends);
          int biggest562 = 0;
          if(ends[2]>=biggest562){
            biggest562=ends[2];
          }
          if(ends[3]>=biggest562){
            biggest562=ends[3];
          }
          if(ends[4]>=biggest562){
            biggest562=ends[4];
          }
          if(biggest562 == 1){
            active[1]=1;
            ends[1]=1;
            break RUN;
          }
          //FINXME code
          if(biggest562 == 0){
            S553=0;
            active[1]=0;
            ends[1]=0;
            S553=0;
            break RUN;
          }
        
      }
    }
  }

  public void init(){
    char [] active1 = {1, 1, 1, 1, 1};
    char [] paused1 = {0, 0, 0, 0, 0};
    char [] suspended1 = {0, 0, 0, 0, 0};
    paused = paused1;
    active = active1;
    suspended = suspended1;
    // Now instantiate all the local signals ONLY
    turnOnRotary_1 = new Signal();
    turnOffRotary_1 = new Signal();
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
          tableAlignedWithSensor.gethook();
          bottleAtPos5.gethook();
          capOnBottleAtPos1.gethook();
          move2NextPos.gethook();
          df = true;
        }
        runClockDomain();
      }
      tableAlignedWithSensor.setpreclear();
      bottleAtPos5.setpreclear();
      capOnBottleAtPos1.setpreclear();
      move2NextPos.setpreclear();
      rotaryTableTrigger.setpreclear();
      rotaryIdle.setpreclear();
      turnOnRotary_1.setpreclear();
      turnOffRotary_1.setpreclear();
      int dummyint = 0;
      for(int qw=0;qw<currsigs.size();++qw){
        dummyint = ((Signal)currsigs.elementAt(qw)).getStatus() ? ((Signal)currsigs.elementAt(qw)).setprepresent() : ((Signal)currsigs.elementAt(qw)).setpreclear();
        ((Signal)currsigs.elementAt(qw)).setpreval(((Signal)currsigs.elementAt(qw)).getValue());
      }
      currsigs.removeAllElements();
      dummyint = tableAlignedWithSensor.getStatus() ? tableAlignedWithSensor.setprepresent() : tableAlignedWithSensor.setpreclear();
      tableAlignedWithSensor.setpreval(tableAlignedWithSensor.getValue());
      tableAlignedWithSensor.setClear();
      dummyint = bottleAtPos5.getStatus() ? bottleAtPos5.setprepresent() : bottleAtPos5.setpreclear();
      bottleAtPos5.setpreval(bottleAtPos5.getValue());
      bottleAtPos5.setClear();
      dummyint = capOnBottleAtPos1.getStatus() ? capOnBottleAtPos1.setprepresent() : capOnBottleAtPos1.setpreclear();
      capOnBottleAtPos1.setpreval(capOnBottleAtPos1.getValue());
      capOnBottleAtPos1.setClear();
      dummyint = move2NextPos.getStatus() ? move2NextPos.setprepresent() : move2NextPos.setpreclear();
      move2NextPos.setpreval(move2NextPos.getValue());
      move2NextPos.setClear();
      rotaryTableTrigger.sethook();
      rotaryTableTrigger.setClear();
      rotaryIdle.sethook();
      rotaryIdle.setClear();
      turnOnRotary_1.setClear();
      turnOffRotary_1.setClear();
      if(paused[1]!=0 || suspended[1]!=0 || active[1]!=1);
      else{
        tableAlignedWithSensor.gethook();
        bottleAtPos5.gethook();
        capOnBottleAtPos1.gethook();
        move2NextPos.gethook();
      }
      runFinisher();
      if(active[1] == 0){
      	this.terminated = true;
      }
      if(!threaded) break;
    }
  }
}
