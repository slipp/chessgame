package slipp.web;

import pieces.Position;

public class Result {
    private boolean status;
    private Position source;
    private Position target;

    private Result(boolean status, String source, String target) {
        this.status = status;
        this.source = new Position(source);
        this.target = new Position(target);
    }
    
    public boolean isStatus() {
        return status;
    }

    public Position getSource() {
        return source;
    }
    
    public Position getTarget() {
        return target;
    }
    
    public static Result ok(String source, String target) {
        return new Result(true, source, target);
    }
}
