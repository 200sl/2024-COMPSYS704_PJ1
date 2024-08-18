import java.util.*;
import com.systemj.ClockDomain;
import com.systemj.Signal;
import com.systemj.input_Channel;
import com.systemj.output_Channel;

public class FillerController extends ClockDomain{
  public FillerController(String name){super(name);}
  Vector currsigs = new Vector();
  private boolean df = false;
  private char [] active;
  private char [] paused;
  private char [] suspended;
  public Signal bottleAtPos2 = new Signal("bottleAtPos2", Signal.INPUT);
  public Signal dosUnitEvac = new Signal("dosUnitEvac", Signal.INPUT);
  public Signal dosUnitFilled = new Signal("dosUnitFilled", Signal.INPUT);
  public Signal doProcess = new Signal("doProcess", Signal.INPUT);
  public Signal valveInjectorOnOff = new Signal("valveInjectorOnOff", Signal.OUTPUT);
  public Signal valveInletOnOff = new Signal("valveInletOnOff", Signal.OUTPUT);
  public Signal dosUnitValveRetract = new Signal("dosUnitValveRetract", Signal.OUTPUT);
  public Signal dosUnitValveExtend = new Signal("dosUnitValveExtend", Signal.OUTPUT);
  private Signal openInjector_1;
  private Signal closeInjector_1;
  private Signal openInlet_1;
  private Signal closeInlet_1;
  private int S835 = 1;
  private int S728 = 1;
  private int S668 = 1;
  private int S760 = 1;
  private int S738 = 1;
  private int S792 = 1;
  private int S770 = 1;
  private int S833 = 1;
  private int S805 = 1;
  
  private int[] ends = new int[10];
  private int[] tdone = new int[10];
  
  public void thread859(int [] tdone, int [] ends){
        if(dosUnitValveExtend.getprestatus()){//sysj/FillerController.sysj line: 82, column: 26
      System.out.println("Lower Canister");//sysj/FillerController.sysj line: 83, column: 21
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

  public void thread858(int [] tdone, int [] ends){
        if(dosUnitValveRetract.getprestatus()){//sysj/FillerController.sysj line: 76, column: 26
      System.out.println("Raise Canister");//sysj/FillerController.sysj line: 77, column: 21
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

  public void thread857(int [] tdone, int [] ends){
        if(valveInletOnOff.getprestatus()){//sysj/FillerController.sysj line: 68, column: 26
      System.out.println("Inlet On");//sysj/FillerController.sysj line: 69, column: 21
      active[7]=0;
      ends[7]=0;
      tdone[7]=1;
    }
    else {
      System.out.println("Inlet Off");//sysj/FillerController.sysj line: 71, column: 21
      active[7]=0;
      ends[7]=0;
      tdone[7]=1;
    }
  }

  public void thread856(int [] tdone, int [] ends){
        if(valveInjectorOnOff.getprestatus()){//sysj/FillerController.sysj line: 60, column: 26
      System.out.println("Injector On");//sysj/FillerController.sysj line: 61, column: 21
      active[6]=0;
      ends[6]=0;
      tdone[6]=1;
    }
    else {
      System.out.println("Injector Off");//sysj/FillerController.sysj line: 63, column: 21
      active[6]=0;
      ends[6]=0;
      tdone[6]=1;
    }
  }

  public void thread854(int [] tdone, int [] ends){
        active[9]=0;
    ends[9]=0;
    tdone[9]=1;
  }

  public void thread853(int [] tdone, int [] ends){
        active[8]=0;
    ends[8]=0;
    tdone[8]=1;
  }

  public void thread852(int [] tdone, int [] ends){
        active[7]=0;
    ends[7]=0;
    tdone[7]=1;
  }

  public void thread851(int [] tdone, int [] ends){
        active[6]=0;
    ends[6]=0;
    tdone[6]=1;
  }

  public void thread850(int [] tdone, int [] ends){
        switch(S833){
      case 0 : 
        active[5]=0;
        ends[5]=0;
        tdone[5]=1;
        break;
      
      case 1 : 
        switch(S805){
          case 0 : 
            thread851(tdone,ends);
            thread852(tdone,ends);
            thread853(tdone,ends);
            thread854(tdone,ends);
            int biggest855 = 0;
            if(ends[6]>=biggest855){
              biggest855=ends[6];
            }
            if(ends[7]>=biggest855){
              biggest855=ends[7];
            }
            if(ends[8]>=biggest855){
              biggest855=ends[8];
            }
            if(ends[9]>=biggest855){
              biggest855=ends[9];
            }
            //FINXME code
            if(biggest855 == 0){
              S805=1;
              active[5]=1;
              ends[5]=1;
              tdone[5]=1;
            }
            break;
          
          case 1 : 
            S805=1;
            S805=0;
            thread856(tdone,ends);
            thread857(tdone,ends);
            thread858(tdone,ends);
            thread859(tdone,ends);
            int biggest860 = 0;
            if(ends[6]>=biggest860){
              biggest860=ends[6];
            }
            if(ends[7]>=biggest860){
              biggest860=ends[7];
            }
            if(ends[8]>=biggest860){
              biggest860=ends[8];
            }
            if(ends[9]>=biggest860){
              biggest860=ends[9];
            }
            //FINXME code
            if(biggest860 == 0){
              S805=1;
              active[5]=1;
              ends[5]=1;
              tdone[5]=1;
            }
            break;
          
        }
        break;
      
    }
  }

  public void thread849(int [] tdone, int [] ends){
        switch(S792){
      case 0 : 
        active[4]=0;
        ends[4]=0;
        tdone[4]=1;
        break;
      
      case 1 : 
        switch(S770){
          case 0 : 
            if(openInlet_1.getprestatus()){//sysj/FillerController.sysj line: 49, column: 20
              S770=1;
              valveInletOnOff.setPresent();//sysj/FillerController.sysj line: 51, column: 34
              currsigs.addElement(valveInletOnOff);
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
            if(closeInlet_1.getprestatus()){//sysj/FillerController.sysj line: 51, column: 20
              S770=2;
              active[4]=1;
              ends[4]=1;
              tdone[4]=1;
            }
            else {
              valveInletOnOff.setPresent();//sysj/FillerController.sysj line: 51, column: 34
              currsigs.addElement(valveInletOnOff);
              active[4]=1;
              ends[4]=1;
              tdone[4]=1;
            }
            break;
          
          case 2 : 
            S770=2;
            S770=0;
            active[4]=1;
            ends[4]=1;
            tdone[4]=1;
            break;
          
        }
        break;
      
    }
  }

  public void thread848(int [] tdone, int [] ends){
        switch(S760){
      case 0 : 
        active[3]=0;
        ends[3]=0;
        tdone[3]=1;
        break;
      
      case 1 : 
        switch(S738){
          case 0 : 
            if(openInjector_1.getprestatus()){//sysj/FillerController.sysj line: 39, column: 20
              S738=1;
              valveInjectorOnOff.setPresent();//sysj/FillerController.sysj line: 41, column: 37
              currsigs.addElement(valveInjectorOnOff);
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
            if(closeInjector_1.getprestatus()){//sysj/FillerController.sysj line: 41, column: 20
              S738=2;
              active[3]=1;
              ends[3]=1;
              tdone[3]=1;
            }
            else {
              valveInjectorOnOff.setPresent();//sysj/FillerController.sysj line: 41, column: 37
              currsigs.addElement(valveInjectorOnOff);
              active[3]=1;
              ends[3]=1;
              tdone[3]=1;
            }
            break;
          
          case 2 : 
            S738=2;
            S738=0;
            active[3]=1;
            ends[3]=1;
            tdone[3]=1;
            break;
          
        }
        break;
      
    }
  }

  public void thread847(int [] tdone, int [] ends){
        switch(S728){
      case 0 : 
        active[2]=0;
        ends[2]=0;
        tdone[2]=1;
        break;
      
      case 1 : 
        switch(S668){
          case 0 : 
            if(bottleAtPos2.getprestatus() && doProcess.getprestatus()){//sysj/FillerController.sysj line: 11, column: 20
              openInjector_1.setPresent();//sysj/FillerController.sysj line: 13, column: 13
              currsigs.addElement(openInjector_1);
              S668=1;
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
            S668=1;
            S668=2;
            if(dosUnitEvac.getprestatus()){//sysj/FillerController.sysj line: 17, column: 22
              dosUnitValveRetract.setPresent();//sysj/FillerController.sysj line: 18, column: 41
              currsigs.addElement(dosUnitValveRetract);
              active[2]=1;
              ends[2]=1;
              tdone[2]=1;
            }
            else {
              closeInjector_1.setPresent();//sysj/FillerController.sysj line: 21, column: 13
              currsigs.addElement(closeInjector_1);
              S668=3;
              active[2]=1;
              ends[2]=1;
              tdone[2]=1;
            }
            break;
          
          case 2 : 
            if(dosUnitFilled.getprestatus()){//sysj/FillerController.sysj line: 18, column: 24
              closeInjector_1.setPresent();//sysj/FillerController.sysj line: 21, column: 13
              currsigs.addElement(closeInjector_1);
              S668=3;
              active[2]=1;
              ends[2]=1;
              tdone[2]=1;
            }
            else {
              dosUnitValveRetract.setPresent();//sysj/FillerController.sysj line: 18, column: 41
              currsigs.addElement(dosUnitValveRetract);
              active[2]=1;
              ends[2]=1;
              tdone[2]=1;
            }
            break;
          
          case 3 : 
            S668=3;
            openInlet_1.setPresent();//sysj/FillerController.sysj line: 25, column: 13
            currsigs.addElement(openInlet_1);
            S668=4;
            active[2]=1;
            ends[2]=1;
            tdone[2]=1;
            break;
          
          case 4 : 
            S668=4;
            S668=5;
            dosUnitValveExtend.setPresent();//sysj/FillerController.sysj line: 29, column: 35
            currsigs.addElement(dosUnitValveExtend);
            active[2]=1;
            ends[2]=1;
            tdone[2]=1;
            break;
          
          case 5 : 
            if(dosUnitEvac.getprestatus()){//sysj/FillerController.sysj line: 29, column: 20
              closeInlet_1.setPresent();//sysj/FillerController.sysj line: 31, column: 13
              currsigs.addElement(closeInlet_1);
              S668=6;
              active[2]=1;
              ends[2]=1;
              tdone[2]=1;
            }
            else {
              dosUnitValveExtend.setPresent();//sysj/FillerController.sysj line: 29, column: 35
              currsigs.addElement(dosUnitValveExtend);
              active[2]=1;
              ends[2]=1;
              tdone[2]=1;
            }
            break;
          
          case 6 : 
            S668=6;
            S668=0;
            active[2]=1;
            ends[2]=1;
            tdone[2]=1;
            break;
          
        }
        break;
      
    }
  }

  public void thread844(int [] tdone, int [] ends){
        if(dosUnitValveExtend.getprestatus()){//sysj/FillerController.sysj line: 82, column: 26
      System.out.println("Lower Canister");//sysj/FillerController.sysj line: 83, column: 21
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

  public void thread843(int [] tdone, int [] ends){
        if(dosUnitValveRetract.getprestatus()){//sysj/FillerController.sysj line: 76, column: 26
      System.out.println("Raise Canister");//sysj/FillerController.sysj line: 77, column: 21
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

  public void thread842(int [] tdone, int [] ends){
        if(valveInletOnOff.getprestatus()){//sysj/FillerController.sysj line: 68, column: 26
      System.out.println("Inlet On");//sysj/FillerController.sysj line: 69, column: 21
      active[7]=0;
      ends[7]=0;
      tdone[7]=1;
    }
    else {
      System.out.println("Inlet Off");//sysj/FillerController.sysj line: 71, column: 21
      active[7]=0;
      ends[7]=0;
      tdone[7]=1;
    }
  }

  public void thread841(int [] tdone, int [] ends){
        if(valveInjectorOnOff.getprestatus()){//sysj/FillerController.sysj line: 60, column: 26
      System.out.println("Injector On");//sysj/FillerController.sysj line: 61, column: 21
      active[6]=0;
      ends[6]=0;
      tdone[6]=1;
    }
    else {
      System.out.println("Injector Off");//sysj/FillerController.sysj line: 63, column: 21
      active[6]=0;
      ends[6]=0;
      tdone[6]=1;
    }
  }

  public void thread840(int [] tdone, int [] ends){
        S833=1;
    S805=0;
    thread841(tdone,ends);
    thread842(tdone,ends);
    thread843(tdone,ends);
    thread844(tdone,ends);
    int biggest845 = 0;
    if(ends[6]>=biggest845){
      biggest845=ends[6];
    }
    if(ends[7]>=biggest845){
      biggest845=ends[7];
    }
    if(ends[8]>=biggest845){
      biggest845=ends[8];
    }
    if(ends[9]>=biggest845){
      biggest845=ends[9];
    }
    //FINXME code
    if(biggest845 == 0){
      S805=1;
      active[5]=1;
      ends[5]=1;
      tdone[5]=1;
    }
  }

  public void thread839(int [] tdone, int [] ends){
        S792=1;
    S770=0;
    active[4]=1;
    ends[4]=1;
    tdone[4]=1;
  }

  public void thread838(int [] tdone, int [] ends){
        S760=1;
    S738=0;
    active[3]=1;
    ends[3]=1;
    tdone[3]=1;
  }

  public void thread837(int [] tdone, int [] ends){
        S728=1;
    S668=0;
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
      switch(S835){
        case 0 : 
          S835=0;
          break RUN;
        
        case 1 : 
          S835=2;
          S835=2;
          openInjector_1.setClear();//sysj/FillerController.sysj line: 6, column: 5
          closeInjector_1.setClear();//sysj/FillerController.sysj line: 6, column: 5
          openInlet_1.setClear();//sysj/FillerController.sysj line: 7, column: 5
          closeInlet_1.setClear();//sysj/FillerController.sysj line: 7, column: 5
          thread837(tdone,ends);
          thread838(tdone,ends);
          thread839(tdone,ends);
          thread840(tdone,ends);
          int biggest846 = 0;
          if(ends[2]>=biggest846){
            biggest846=ends[2];
          }
          if(ends[3]>=biggest846){
            biggest846=ends[3];
          }
          if(ends[4]>=biggest846){
            biggest846=ends[4];
          }
          if(ends[5]>=biggest846){
            biggest846=ends[5];
          }
          if(biggest846 == 1){
            active[1]=1;
            ends[1]=1;
            break RUN;
          }
        
        case 2 : 
          openInjector_1.setClear();//sysj/FillerController.sysj line: 6, column: 5
          closeInjector_1.setClear();//sysj/FillerController.sysj line: 6, column: 5
          openInlet_1.setClear();//sysj/FillerController.sysj line: 7, column: 5
          closeInlet_1.setClear();//sysj/FillerController.sysj line: 7, column: 5
          thread847(tdone,ends);
          thread848(tdone,ends);
          thread849(tdone,ends);
          thread850(tdone,ends);
          int biggest861 = 0;
          if(ends[2]>=biggest861){
            biggest861=ends[2];
          }
          if(ends[3]>=biggest861){
            biggest861=ends[3];
          }
          if(ends[4]>=biggest861){
            biggest861=ends[4];
          }
          if(ends[5]>=biggest861){
            biggest861=ends[5];
          }
          if(biggest861 == 1){
            active[1]=1;
            ends[1]=1;
            break RUN;
          }
          //FINXME code
          if(biggest861 == 0){
            S835=0;
            active[1]=0;
            ends[1]=0;
            S835=0;
            break RUN;
          }
        
      }
    }
  }

  public void init(){
    char [] active1 = {1, 1, 1, 1, 1, 1, 1, 1, 1, 1};
    char [] paused1 = {0, 0, 0, 0, 0, 0, 0, 0, 0, 0};
    char [] suspended1 = {0, 0, 0, 0, 0, 0, 0, 0, 0, 0};
    paused = paused1;
    active = active1;
    suspended = suspended1;
    // Now instantiate all the local signals ONLY
    openInjector_1 = new Signal();
    closeInjector_1 = new Signal();
    openInlet_1 = new Signal();
    closeInlet_1 = new Signal();
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
          bottleAtPos2.gethook();
          dosUnitEvac.gethook();
          dosUnitFilled.gethook();
          doProcess.gethook();
          df = true;
        }
        runClockDomain();
      }
      bottleAtPos2.setpreclear();
      dosUnitEvac.setpreclear();
      dosUnitFilled.setpreclear();
      doProcess.setpreclear();
      valveInjectorOnOff.setpreclear();
      valveInletOnOff.setpreclear();
      dosUnitValveRetract.setpreclear();
      dosUnitValveExtend.setpreclear();
      openInjector_1.setpreclear();
      closeInjector_1.setpreclear();
      openInlet_1.setpreclear();
      closeInlet_1.setpreclear();
      int dummyint = 0;
      for(int qw=0;qw<currsigs.size();++qw){
        dummyint = ((Signal)currsigs.elementAt(qw)).getStatus() ? ((Signal)currsigs.elementAt(qw)).setprepresent() : ((Signal)currsigs.elementAt(qw)).setpreclear();
        ((Signal)currsigs.elementAt(qw)).setpreval(((Signal)currsigs.elementAt(qw)).getValue());
      }
      currsigs.removeAllElements();
      dummyint = bottleAtPos2.getStatus() ? bottleAtPos2.setprepresent() : bottleAtPos2.setpreclear();
      bottleAtPos2.setpreval(bottleAtPos2.getValue());
      bottleAtPos2.setClear();
      dummyint = dosUnitEvac.getStatus() ? dosUnitEvac.setprepresent() : dosUnitEvac.setpreclear();
      dosUnitEvac.setpreval(dosUnitEvac.getValue());
      dosUnitEvac.setClear();
      dummyint = dosUnitFilled.getStatus() ? dosUnitFilled.setprepresent() : dosUnitFilled.setpreclear();
      dosUnitFilled.setpreval(dosUnitFilled.getValue());
      dosUnitFilled.setClear();
      dummyint = doProcess.getStatus() ? doProcess.setprepresent() : doProcess.setpreclear();
      doProcess.setpreval(doProcess.getValue());
      doProcess.setClear();
      valveInjectorOnOff.sethook();
      valveInjectorOnOff.setClear();
      valveInletOnOff.sethook();
      valveInletOnOff.setClear();
      dosUnitValveRetract.sethook();
      dosUnitValveRetract.setClear();
      dosUnitValveExtend.sethook();
      dosUnitValveExtend.setClear();
      openInjector_1.setClear();
      closeInjector_1.setClear();
      openInlet_1.setClear();
      closeInlet_1.setClear();
      if(paused[1]!=0 || suspended[1]!=0 || active[1]!=1);
      else{
        bottleAtPos2.gethook();
        dosUnitEvac.gethook();
        dosUnitFilled.gethook();
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
