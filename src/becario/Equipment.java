package becario;

public class Equipment {

    private String tag;
    private String pid;
    private String pipe_spec;
    private String description;
    private String schedule;
    private String material;
    private String fluid;
    private String state;
    private String isolation;
    private String notes;
    private float Tdes;
    private float Pdes;
    private String[] connected_lines;

     //GETTERS Y SETTERS
    public String getTag() {
        return tag;
    }
    public String getPid() {
        return pid;
    }
    public String getDescription() {
        return description;
    }
    public String getPipe_spec() {
        return pipe_spec;
    }
    public String getSchedule() {
        return schedule;
    }
    public String getMaterial() {
        return material;
    }
    public String getFluid() {
        return fluid;
    }
    public String getState() {
        return state;
    }
    public String getIsolation() {
        return isolation;
    }
    public String getNotes() {
        return notes;
    }
    public float getTdes() {
        return Tdes;
    }
    public float getPdes() {
        return Pdes;
    }
    public String[] getConnected_lines() {
        return connected_lines;
    }
    
    
    public void setPid(String pid) {
        this.pid = pid;
    }
    public void setTag(String tag) {
        this.tag = tag;
    }    
    public void setDescription(String description) {
        this.description = description;
    }
    public void setSchedule(String schedule) {
        this.schedule = schedule;
    }
    public void setMaterial(String material) {
        this.material = material;
    }
    public void setFluid(String fluid) {
        this.fluid = fluid;
    }
    public void setState(String state) {
        this.state = state;
    }
    public void setIsolation(String isolation) {
        this.isolation = isolation;
    }
    public void setNotes(String notes) {
        this.notes = notes;
    }
    public void setTdes(Float tdes) {
        this.Tdes = Tdes;
    }
    public void setPdes(Float pdes) {
        this.Pdes = Pdes;
    }
    public void setConnected_lines(String[] connected_lines) {
        this.connected_lines = connected_lines;
    }
    public void setPipe_spec(String pipe_spec) {
        this.pipe_spec = pipe_spec;
    }
}
