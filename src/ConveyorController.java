import java.util.*;
import com.systemj.ClockDomain;
import com.systemj.Signal;
import com.systemj.input_Channel;
import com.systemj.output_Channel;

public class ConveyorController extends ClockDomain{
  public ConveyorController(String name){super(name);}
  Vector currsigs = new Vector();
  private boolean df = false;
  private char [] active;
  private char [] paused;
  private char [] suspended;
  public Signal bottleAtPos1 = new Signal("bottleAtPos1", Signal.INPUT);
  public Signal bottleLeftPos5 = new Signal("bottleLeftPos5", Signal.INPUT);
  public Signal motConveyorOnOff = new Signal("motConveyorOnOff", Signal.OUTPUT);
  private int S65 = 1;
  private int S55 = 1;
  private int S9 = 1;
  private int S63 = 1;
  
  private int[] ends = new int[4];
  private int[] tdone = new int[4];
  
  public void thread71(int [] tdone, int [] ends){
        switch(S63){
      case 0 : 
        active[3]=0;
        ends[3]=0;
        tdone[3]=1;
        break;
      
      case 1 : 
        if(motConveyorOnOff.getprestatus()){//sysj/ConveyorController.sysj line: 19, column: 26
          System.out.println("motOn");//sysj/ConveyorController.sysj line: 20, column: 21
          active[3]=1;
          ends[3]=1;
          tdone[3]=1;
        }
        else {
          System.out.println("motOff");//sysj/ConveyorController.sysj line: 22, column: 21
          active[3]=1;
          ends[3]=1;
          tdone[3]=1;
        }
        break;
      
    }
  }

  public void thread70(int [] tdone, int [] ends){
        switch(S55){
      case 0 : 
        active[2]=0;
        ends[2]=0;
        tdone[2]=1;
        break;
      
      case 1 : 
        switch(S9){
          case 0 : 
            if(!bottleLeftPos5.getprestatus()){//sysj/ConveyorController.sysj line: 8, column: 20
              S9=1;
              motConveyorOnOff.setPresent();//sysj/ConveyorController.sysj line: 10, column: 36
              currsigs.addElement(motConveyorOnOff);
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
            if(bottleAtPos1.getprestatus()){//sysj/ConveyorController.sysj line: 10, column: 20
              S9=2;
              motConveyorOnOff.setPresent();//sysj/ConveyorController.sysj line: 12, column: 38
              currsigs.addElement(motConveyorOnOff);
              active[2]=1;
              ends[2]=1;
              tdone[2]=1;
            }
            else {
              motConveyorOnOff.setPresent();//sysj/ConveyorController.sysj line: 10, column: 36
              currsigs.addElement(motConveyorOnOff);
              active[2]=1;
              ends[2]=1;
              tdone[2]=1;
            }
            break;
          
          case 2 : 
            if(bottleLeftPos5.getprestatus()){//sysj/ConveyorController.sysj line: 12, column: 20
              S9=3;
              active[2]=1;
              ends[2]=1;
              tdone[2]=1;
            }
            else {
              motConveyorOnOff.setPresent();//sysj/ConveyorController.sysj line: 12, column: 38
              currsigs.addElement(motConveyorOnOff);
              active[2]=1;
              ends[2]=1;
              tdone[2]=1;
            }
            break;
          
          case 3 : 
            S9=3;
            S9=0;
            active[2]=1;
            ends[2]=1;
            tdone[2]=1;
            break;
          
        }
        break;
      
    }
  }

  public void thread68(int [] tdone, int [] ends){
        S63=1;
    if(motConveyorOnOff.getprestatus()){//sysj/ConveyorController.sysj line: 19, column: 26
      System.out.println("motOn");//sysj/ConveyorController.sysj line: 20, column: 21
      active[3]=1;
      ends[3]=1;
      tdone[3]=1;
    }
    else {
      System.out.println("motOff");//sysj/ConveyorController.sysj line: 22, column: 21
      active[3]=1;
      ends[3]=1;
      tdone[3]=1;
    }
  }

  public void thread67(int [] tdone, int [] ends){
        S55=1;
    S9=0;
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
      switch(S65){
        case 0 : 
          S65=0;
          break RUN;
        
        case 1 : 
          S65=2;
          S65=2;
          thread67(tdone,ends);
          thread68(tdone,ends);
          int biggest69 = 0;
          if(ends[2]>=biggest69){
            biggest69=ends[2];
          }
          if(ends[3]>=biggest69){
            biggest69=ends[3];
          }
          if(biggest69 == 1){
            active[1]=1;
            ends[1]=1;
            break RUN;
          }
        
        case 2 : 
          thread70(tdone,ends);
          thread71(tdone,ends);
          int biggest72 = 0;
          if(ends[2]>=biggest72){
            biggest72=ends[2];
          }
          if(ends[3]>=biggest72){
            biggest72=ends[3];
          }
          if(biggest72 == 1){
            active[1]=1;
            ends[1]=1;
            break RUN;
          }
          //FINXME code
          if(biggest72 == 0){
            S65=0;
            active[1]=0;
            ends[1]=0;
            S65=0;
            break RUN;
          }
        
      }
    }
  }

  public void init(){
    char [] active1 = {1, 1, 1, 1};
    char [] paused1 = {0, 0, 0, 0};
    char [] suspended1 = {0, 0, 0, 0};
    paused = paused1;
    active = active1;
    suspended = suspended1;
    // Now instantiate all the local signals ONLY
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
          bottleAtPos1.gethook();
          bottleLeftPos5.gethook();
          df = true;
        }
        runClockDomain();
      }
      bottleAtPos1.setpreclear();
      bottleLeftPos5.setpreclear();
      motConveyorOnOff.setpreclear();
      int dummyint = 0;
      for(int qw=0;qw<currsigs.size();++qw){
        dummyint = ((Signal)currsigs.elementAt(qw)).getStatus() ? ((Signal)currsigs.elementAt(qw)).setprepresent() : ((Signal)currsigs.elementAt(qw)).setpreclear();
        ((Signal)currsigs.elementAt(qw)).setpreval(((Signal)currsigs.elementAt(qw)).getValue());
      }
      currsigs.removeAllElements();
      dummyint = bottleAtPos1.getStatus() ? bottleAtPos1.setprepresent() : bottleAtPos1.setpreclear();
      bottleAtPos1.setpreval(bottleAtPos1.getValue());
      bottleAtPos1.setClear();
      dummyint = bottleLeftPos5.getStatus() ? bottleLeftPos5.setprepresent() : bottleLeftPos5.setpreclear();
      bottleLeftPos5.setpreval(bottleLeftPos5.getValue());
      bottleLeftPos5.setClear();
      motConveyorOnOff.sethook();
      motConveyorOnOff.setClear();
      if(paused[1]!=0 || suspended[1]!=0 || active[1]!=1);
      else{
        bottleAtPos1.gethook();
        bottleLeftPos5.gethook();
      }
      runFinisher();
      if(active[1] == 0){
      	this.terminated = true;
      }
      if(!threaded) break;
    }
  }
}
