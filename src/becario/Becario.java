package becario;

/*TAREAS A REALIZAR
----------------------------------------------------
+ Peinar la base de datos (sin repeticiones, restricciones, mayúsculas, etc).
+ Establecer relaciones en la base de datos.
+ Realizar una ventana principal y un sistema de navegación por botones.
+ Populate database.
+ Insertar registros.
+ Suprimir registros.
 */

 /*BUGS DETECTADOS
----------------------------------------------------
+ Los valores de Tdes y Pdes no se pasan bien como Float, hay algún problema en la conversión a String.
+ Desde general sólo se asocia a líneas, no a equipos. Fácil de corregir, necesitaré un booleano en el formulario para poder diferenciar ambas listas.
+ El ComboBox de la línea no se actualiza
 */
import java.sql.Statement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.DefaultListModel;
import javax.swing.JComboBox;
import javax.swing.JList;
import javax.swing.JOptionPane;

public class Becario {
    static String ruta;

    public static void main(String[] args) {
        // TODO code application logic here
        
        String[] options = {"Desde el curro", "Desde el Mac"};
        
       int x = JOptionPane.showOptionDialog(null, "Desde donde estas trabajando?",
                "Elige",
                JOptionPane.DEFAULT_OPTION, JOptionPane.INFORMATION_MESSAGE, null, options, options[0]);
        if (x==0){
            
        ruta="jdbc:ucanaccess://C:\\Users\\0204687\\Desktop\\Software developers\\CADENAS\\BDprueba.accdb";
        }else if(x==1){
            
        ruta="jdbc:ucanaccess:///Mis Cosas/Becario/Becario/BDprueba.accdb";
        }
        Ventana_linea ventana_linea = new Ventana_linea();
        Ventana_general ventana_general = new Ventana_general();
        Ventana_equipo ventana_equipo = new Ventana_equipo();
        ventana_linea.setVisible(true);
        ventana_general.setVisible(true);
        ventana_equipo.setVisible(true);
    }

    public ResultSet consultameEsto(String consulta) {

        try {
            Connection conn = DriverManager.getConnection(ruta);
            Statement st = conn.createStatement();
            ResultSet rs = st.executeQuery(consulta);
            conn.close();
            return rs;
        } catch (SQLException sqlEx) {
            System.out.println(sqlEx.getMessage());
        }
        return null;
    }

    public void ejecutameEsto(String query) {
        Connection conn;
        try {
             conn = DriverManager.getConnection(ruta);
            
            Statement st = conn.createStatement();
            st.execute(query);
            conn.close();
        } catch (SQLException ex) {
            Logger.getLogger(Becario.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    public void leeLaLinea(Line line, JList lista) {
        try {
            Connection conn = DriverManager.getConnection(ruta);
            Statement st = conn.createStatement();
            ResultSet rs = st.executeQuery("SELECT * FROM Lines WHERE Line = '" + lista.getSelectedValue() + "'");
            conn.close();
            try {
                rs.next();
                line.setLine(rs.getString("Line"));
                line.setPid(rs.getString("PID"));
                line.setNumber(rs.getString("Number"));
                line.setPipe_spec(rs.getString("Pipe_Spec"));
                line.setNom_diam(rs.getString("Nom_Diam"));
                line.setSchedule(rs.getString("Schedule"));
                line.setMaterial(rs.getString("Material"));
                line.setFluid(rs.getString("Fluid"));
                line.setState(rs.getString("State"));
                line.setIsolation(rs.getString("Isolation"));
                line.setNotes(rs.getString("Notes"));
                line.setFrom(rs.getString("From"));
                line.setTo(rs.getString("To"));

            } catch (SQLException ex) {
                Logger.getLogger(Ventana_linea.class.getName()).log(Level.SEVERE, null, ex);
            }
        } catch (SQLException sqlEx) {
            System.out.println(sqlEx.getMessage());
        }

    }

    public void leeElEquipo(Equipment equipment, JList lista) {
        try {
             Connection conn = DriverManager.getConnection(ruta);
            Statement st = conn.createStatement();
            ResultSet rs = st.executeQuery("SELECT * FROM Equipment WHERE Tag = '" + lista.getSelectedValue() + "'");
            conn.close();
            try {
                rs.next();
                equipment.setTag(rs.getString("Tag"));
                equipment.setPid(rs.getString("Pid"));
                equipment.setPipe_spec(rs.getString("Pipe_spec"));
                equipment.setDescription(rs.getString("Description"));
                equipment.setSchedule(rs.getString("Schedule"));
                equipment.setMaterial(rs.getString("Material"));
                equipment.setFluid(rs.getString("Fluid"));
                equipment.setState(rs.getString("State"));
                equipment.setIsolation(rs.getString("Isolation"));
                equipment.setNotes(rs.getString("Notes"));
                equipment.setTdes(rs.getFloat("Tdes"));
                equipment.setPdes(rs.getFloat("Pdes"));

            } catch (SQLException ex) {
                Logger.getLogger(Ventana_linea.class.getName()).log(Level.SEVERE, null, ex);
            }
        } catch (SQLException sqlEx) {
            System.out.println(sqlEx.getMessage());
        }

    }

    public void leeLosRangos(Ranges rangos, JList lista) {
        try {
            Connection conn = DriverManager.getConnection(ruta);
            Statement st = conn.createStatement();
            ResultSet rs = st.executeQuery("SELECT * FROM Ranges WHERE Tag = '" + lista.getSelectedValue() + "'");
            if (!rs.next() && lista.getSelectedValue() != null) {
                st.execute("INSERT INTO Ranges (Tag) VALUES ('" + lista.getSelectedValue() + "')");
            }
            rs = st.executeQuery("SELECT * FROM Process WHERE Tag = '" + lista.getSelectedValue() + "'");
            if (!rs.next() && lista.getSelectedValue() != null) {
                st.execute("INSERT INTO Process (Tag) VALUES ('" + lista.getSelectedValue() + "')");
            }
            rs = st.executeQuery("SELECT * FROM Ranges WHERE Tag = '" + lista.getSelectedValue() + "'");
            conn.close();
            try {
                rs.next();
                rangos.setTag(rs.getString("Tag"));
                rangos.setSystem(rs.getString("System"));
                rangos.setCom_protocol(rs.getString("Com_protocol"));
                rangos.setHHH(rs.getString("HHH"));
                rangos.setHH(rs.getString("HH"));
                rangos.setH(rs.getString("H"));
                rangos.setL(rs.getString("L"));
                rangos.setLL(rs.getString("LL"));
                rangos.setLLL(rs.getString("LLL"));
                rangos.setRange_max(rs.getString("Range_max"));
                rangos.setRange_min(rs.getString("Range_min"));
                rangos.setDisplay(rs.getString("Display"));
                rangos.setRange_units(rs.getString("Range_units"));

            } catch (SQLException ex) {
                Logger.getLogger(Ventana_linea.class.getName()).log(Level.SEVERE, null, ex);
            }
        } catch (SQLException sqlEx) {
            System.out.println(sqlEx.getMessage());
        }

    }

    public void leeElItem(General item, JList lista) {
        try {
            Connection conn = DriverManager.getConnection(ruta);
            Statement st = conn.createStatement();
            ResultSet rs = st.executeQuery("SELECT * FROM General WHERE Tag = '" + lista.getSelectedValue() + "'");
            conn.close();
            try {
                rs.next();
                item.setTag(rs.getString("Tag"));
                item.setType(rs.getString("Instrument_type"));
                item.setLoop(rs.getString("Loop"));
                item.setService(rs.getString("Service"));
                item.setLine(rs.getString("Line"));
                item.setLocation(rs.getString("Location"));
                item.setNotes(rs.getString("Notes"));
                item.setAtex(rs.getString("ATEX"));

            } catch (SQLException ex) {
                Logger.getLogger(Ventana_linea.class.getName()).log(Level.SEVERE, null, ex);
            }
        } catch (SQLException sqlEx) {
            System.out.println(sqlEx.getMessage());
        }

    }

    public void leeElProceso(Process proceso, JList lista) {
        try {
            Connection conn = DriverManager.getConnection(ruta);
            Statement st = conn.createStatement();
            ResultSet rs = st.executeQuery("SELECT * FROM Process WHERE Tag = '" + lista.getSelectedValue() + "'");
            conn.close();
            try {
                rs.next();
                proceso.setTag(rs.getString("Tag"));
                proceso.setTmax(rs.getString("Tmax"));
                proceso.setTnor(rs.getString("Tnor"));
                proceso.setTmin(rs.getString("Tmin"));
                proceso.setPmax(rs.getString("Pmax"));
                proceso.setPnor(rs.getString("Pnor"));
                proceso.setPmin(rs.getString("Pmin"));
                proceso.setQmax(rs.getString("Qmax"));
                proceso.setQnor(rs.getString("Qnor"));
                proceso.setQmin(rs.getString("Qmin"));
                proceso.setTunits(rs.getString("Tunits"));
                proceso.setPunits(rs.getString("Punits"));
                proceso.setQunits(rs.getString("Qunits"));

            } catch (SQLException ex) {
                Logger.getLogger(Ventana_linea.class.getName()).log(Level.SEVERE, null, ex);
            }
        } catch (SQLException sqlEx) {
            System.out.println(sqlEx.getMessage());
        }

    }

    public void modificaLaLinea(Line linea) {
        Connection conn;
        try {
             conn = DriverManager.getConnection(ruta);
            String query;

            //Primero se actualizan en el registro todos los campos de la línea salvo el nombre.
            query = "UPDATE Lines "
                    + "SET [PID] = '" + linea.getPid() + "', "
                    + "[Number] = '" + linea.getNumber() + "', "
                    + "[Pipe_Spec] = '" + linea.getPipe_spec() + "', "
                    + "[Schedule] = '" + linea.getSchedule() + "', "
                    + "[Nom_Diam] = '" + linea.getNom_diam() + "', "
                    + "[Material] = '" + linea.getMaterial() + "', "
                    + "[Fluid] = '" + linea.getFluid() + "', "
                    + "[State] = '" + linea.getState() + "', "
                    + "[Isolation] = '" + linea.getIsolation() + "', "
                    + "[Notes] = '" + linea.getNotes() + "', "
                    + "[From] = '" + linea.getFrom() + "', "
                    + "[To] = '" + linea.getTo() + "'"
                    + "WHERE [Line] = '" + linea.getLine() + "'";
            Statement st = conn.createStatement();
            st.executeUpdate(query);

            //Finalmente se cambia el nombre a partir de los campos actualizados.
            query = "UPDATE Lines "
                    + "SET [line] = '" + linea.getNom_diam() + "\"-" + linea.getFluid() + "-" + linea.getNumber() + "-" + linea.getPipe_spec() + "-" + linea.getIsolation() + "'"
                    + "WHERE [Nom_Diam] = '" + linea.getNom_diam() + "'"
                    + "AND [Fluid] ='" + linea.getFluid() + "'"
                    + "AND [Number] ='" + linea.getNumber() + "'"
                    + "AND [Pipe_Spec] ='" + linea.getPipe_spec() + "'"
                    + "AND [Isolation] ='" + linea.getIsolation() + "'";

            st.executeUpdate(query);

            conn.close();
        } catch (SQLException ex) {
            Logger.getLogger(Becario.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    public void modificaElEquipo(Equipment equipo) {
        Connection conn;
        try {
            
             conn = DriverManager.getConnection(ruta);
             String query;

            //Primero se actualizan en el registro todos los campos de la línea salvo el nombre.
            query = "UPDATE Equipment "
                    + "SET [PID] = '" + equipo.getPid() + "', "
                    + "[Description] = '" + equipo.getDescription() + "', "
                    + "[Pipe_Spec] = '" + equipo.getPipe_spec() + "', "
                    + "[Schedule] = '" + equipo.getSchedule() + "', "
                    + "[Material] = '" + equipo.getMaterial() + "', "
                    + "[Fluid] = '" + equipo.getFluid() + "', "
                    + "[State] = '" + equipo.getState() + "', "
                    + "[Isolation] = '" + equipo.getIsolation() + "', "
                    + "[Notes] = '" + equipo.getNotes() + "', "
                    + "[Tdes] = '" + equipo.getTdes() + "', "
                    + "[Pdes] = '" + equipo.getPdes() + "'"
                    + "WHERE [Tag] = '" + equipo.getTag() + "'";
            Statement st = conn.createStatement();
            st.executeUpdate(query);

            conn.close();
        } catch (SQLException ex) {
            Logger.getLogger(Becario.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    public void modificaElItem(General item) {
        Connection conn;
        try {
            
             conn = DriverManager.getConnection(ruta);
            String query;

            //Primero se actualizan en el registro todos los campos de la línea salvo el nombre.
            query = "UPDATE General "
                    + "SET [Instrument_type] = '" + item.getType() + "', "
                    + "[Loop] = '" + item.getLoop() + "', "
                    + "[Service] = '" + item.getService() + "', "
                    + "[Line] = '" + item.getLine() + "', "
                    + "[Location] = '" + item.getLocation() + "', "
                    + "[Notes] = '" + item.getNotes() + "', "
                    + "[ATEX] = '" + item.getAtex() + "'"
                    + "WHERE [Tag] = '" + item.getTag() + "'";
            Statement st = conn.createStatement();
            st.executeUpdate(query);

            conn.close();
        } catch (SQLException ex) {
            Logger.getLogger(Becario.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    public void modificaElProceso(Process proceso) {
        Connection conn;
        try {
             conn = DriverManager.getConnection(ruta);
            String query;

            //Primero se actualizan en el registro todos los campos de la línea salvo el nombre.
            query = "UPDATE Process "
                    + "SET [Tmax] = '" + proceso.getTmax() + "', "
                    + "[Tnor] = '" + proceso.getTnor() + "', "
                    + "[Tmin] = '" + proceso.getTmin() + "', "
                    + "[Pmax] = '" + proceso.getPmax() + "', "
                    + "[Pnor] = '" + proceso.getPnor() + "', "
                    + "[Pmin] = '" + proceso.getPmin() + "', "
                    + "[Qmax] = '" + proceso.getQmax() + "', "
                    + "[Qnor] = '" + proceso.getQnor() + "', "
                    + "[Qmin] = '" + proceso.getQmin() + "', "
                    + "[Tunits] = '" + proceso.getTunits() + "', "
                    + "[Punits] = '" + proceso.getPunits() + "', "
                    + "[Qunits] = '" + proceso.getQunits() + "'"
                    + "WHERE [Tag] = '" + proceso.getTag() + "'";
            Statement st = conn.createStatement();
            st.executeUpdate(query);

            conn.close();
        } catch (SQLException ex) {
            Logger.getLogger(Becario.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    public void modificaLosRangos(Ranges rangos) {
        Connection conn;
        try {
            
            conn = DriverManager.getConnection(ruta);
             String query;
            Statement st = conn.createStatement();

            //Primero se actualizan en el registro todos los campos de la línea salvo el nombre.
            query = "UPDATE Ranges "
                    + "SET [System] = '" + rangos.getSystem() + "', "
                    + "[Com_protocol] = '" + rangos.getCom_protocol() + "', "
                    + "[HHH] = '" + rangos.getHHH() + "', "
                    + "[HH] = '" + rangos.getHH() + "', "
                    + "[H] = '" + rangos.getH() + "', "
                    + "[L] = '" + rangos.getL() + "', "
                    + "[LL] = '" + rangos.getLL() + "', "
                    + "[LLL] = '" + rangos.getLLL() + "', "
                    + "[Range_max] = '" + rangos.getRange_max() + "', "
                    + "[Range_min] = '" + rangos.getRange_min() + "', "
                    + "[Display] = '" + rangos.getDisplay() + "', "
                    + "[Range_units] = '" + rangos.getRange_units() + "'"
                    + "WHERE [Tag] = '" + rangos.getTag() + "'";

            st.executeUpdate(query);

            conn.close();
        } catch (SQLException ex) {
            Logger.getLogger(Becario.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    //Añade a una lista ofrecida como parámetro un campo concreto de los resultados de una consulta
    public void listameEsto(String campo, String consulta, JList lista) {

        lista.removeAll();
        DefaultListModel listModel = new DefaultListModel();
        ResultSet rs = consultameEsto(consulta);
        try {
            listModel.clear();
            while (rs.next()) {

                listModel.addElement(rs.getString(campo));
            }
            lista.setModel(listModel);
        } catch (SQLException ex) {
            Logger.getLogger(Ventana_linea.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    public void listameEsto(String campo, String consulta, JComboBox combo) {

        combo.removeAllItems();
        ResultSet rs = consultameEsto(consulta);
        try {
            while (rs.next()) {

                combo.addItem(rs.getString(campo));
            }
            rs.close();
        } catch (SQLException ex) {
            Logger.getLogger(Ventana_linea.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

}

