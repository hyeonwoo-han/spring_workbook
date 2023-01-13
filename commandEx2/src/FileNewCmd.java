public class FileNewCmd implements Command{
    private FileNew fn;

    public FileNewCmd(FileNew fn){
        this.fn = fn;
    }
    @Override
    public void execute(){
        fn.newFile();
    }
}
