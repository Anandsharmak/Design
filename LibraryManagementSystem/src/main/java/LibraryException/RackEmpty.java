package LibraryException;

public class RackEmpty extends  Exception{

    public RackEmpty() {
        super("Rack not available");
    }
}
