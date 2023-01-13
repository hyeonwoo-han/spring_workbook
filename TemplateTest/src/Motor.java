public abstract class Motor { // HyundaiMotor와 LGMotor에 공통적인 기능을 구현하는 클래스
    protected Door door ;
    private MotorStatus motorStatus ;
    public Motor(Door door) {
        this.door = door ;
        motorStatus = MotorStatus.STOPPED ;
    }
    public MotorStatus getMotorStatus() {
        return motorStatus;
    }
    protected void setMotorStatus(MotorStatus motorStatus) {
        this.motorStatus = motorStatus;
    }


    // 템플릿 메소드 move
    public void move(Direction direction) {
        MotorStatus motorStatus = getMotorStatus() ;
        if ( motorStatus == MotorStatus.MOVING ) return ;
        DoorStatus doorStatus = door.getDoorStatus() ;
        if ( doorStatus == DoorStatus.OPENED )
            door.close() ;
        // primitive 혹은 hook 메소드
        moveMotor(direction) ; // 이부분만 각자 다르기때문에 추상메소드로 만들고 각 상속클래스에서 구현
        setMotorStatus(MotorStatus.MOVING) ;
    }

    protected abstract void moveMotor(Direction direction);
}