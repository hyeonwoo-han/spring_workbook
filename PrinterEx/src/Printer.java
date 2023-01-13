public class Printer {
    private static Printer instance;

    // 외부에서 Printer 인스턴스를 만들지 못하게하자!
    // new 키워드를 사용하지 못하게하자!
    // 생성자를 못쓰게만들면 된다
    // public -> private
    private Printer(){

    }

    // 인스턴스를 new로 무한복제하지 못하게하고
    // 생성된 하나의 인스턴스를 리턴하도록한다
    public static Printer getInstance(){
        if(instance == null)
            instance = new Printer();
        return instance;
    }

    public void print(String msg){
        System.out.println("**********************");
        System.out.println(msg);
        System.out.println("**********************");
    }
}
