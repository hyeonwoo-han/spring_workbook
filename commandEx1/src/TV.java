public class TV {
    private boolean powerOn = false;
    private boolean muteOn = false;

    public void power(){
        powerOn = !powerOn;

        if(powerOn){
            System.out.println("power on");
        }else{
            System.out.println("poewr off");
        }
    }

    public void mute(){
        muteOn = !muteOn;

        if(muteOn){
            System.out.println("mute on");
        }else{
            System.out.println("mute off");
        }
    }

}
