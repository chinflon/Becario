package becario;

public class General {

    private String tag;
    private String loop;
    private String service;
    private String line;
    private String location;
    private String notes;
    private String type;
    private String atex;

    
    //GETTERS Y SETTERS
    public String getTag() {
        return tag;
    }
    public String getLoop() {
        return loop;
    }
    public String getService() {
        return service;
    }
    public String getLine() {
        return line;
    }
    public String getLocation() {
        return location;
    }
    public String getNotes() {
        return notes;
    }
    public String getType() {
        return type;
    }
    public String getAtex() {
        return atex;
    }
    
    
    public void setTag(String tag){
    this.tag=tag;
    }
    public void setLoop(String loop) {
        this.loop = loop;
    }
    public void setService(String service) {
        this.service = service;
    }
    public void setLine(String line) {
        this.line = line;
    }
    public void setLocation(String location) {
        this.location = location;
    }
    public void setNotes(String notes) {
        this.notes = notes;
    }
    public void setType(String type) {
        this.type = type;
    }
    public void setAtex(String atex) {
        this.atex = atex;
    }
}
