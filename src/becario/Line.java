package becario;

public class Line {

    private String line;
    private String pid;
    private String pipe_spec;
    private String number;
    private String nom_diam;
    private String schedule;
    private String material;
    private String fluid;
    private String state;
    private String isolation;
    private String notes;
    private String from;
    private String to;
    private float Tdes;
    private float Pdes;
 

    public String nombraLinea() {
        String nombre_linea;

            nombre_linea = this.getNom_diam() + "''-" + this.getFluid() + "-" + this.getNumber() + "-" + this.getPipe_spec() + "-" + this.getIsolation();
            return nombre_linea;

    }

     //GETTERS Y SETTERS
    public String getLine() {
        return line;
    } 
    public String getPid() {
        return pid;
    }
    public String getPipe_spec() {
        return pipe_spec;
    }
    public String getNom_diam() {
        return nom_diam;
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
    public String getFrom() {
        return from;
    }
    public String getTo() {
        return to;
    }
    public String getNumber() {
        return number;
    }
    public float getTdes() {
        return Tdes;
    }
    public float getPdes() {
        return Pdes;
    }
    
    
    public void setLine(String line) {
        this.line = line;
    }
    public void setPid(String pid) {
        this.pid = pid;
    }
    public void setPipe_spec(String pipe_spec) {
        this.pipe_spec = pipe_spec;
    }
    public void setNom_diam(String nom_diam) {
        this.nom_diam = nom_diam;
    }
    public void setNumber(String number) {
        this.number = number;
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
    public void setFrom(String from) {
        this.from = from;
    }
    public void setTo(String to) {
        this.to = to;
    }
    public void setTdes(float tdes) {
        this.Tdes = tdes;
    }
    public void setPdes(float pdes) {
        this.Pdes = pdes;
    }
}
