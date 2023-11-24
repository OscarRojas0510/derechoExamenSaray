package equipo.rosa.crudmongo;

import cell.TableActionCellEditor;
import cell.TableActionCellRender;
import cell.TableActionEvent;
import conection.Connection;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import model.Usuario;
import org.bson.types.ObjectId;

/**
 *
 * @author oscar
 */
public class Main extends javax.swing.JFrame
{

    Connection conn;
    ArrayList data;
    TableActionEvent event;
    DefaultTableModel tableModel;

    /**
     * Creates new form Main
     */
    public Main()
    {
        System.out.println(System.getProperty("java.class.path"));
        initComponents();
        setbk();
        connectWithMongo();
        getData();
        setEvents();
        fillTable();
    }

    private void setbk()
    {
        this.setLocationRelativeTo(null);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents()
    {

        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        jButton1 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setBackground(new java.awt.Color(255, 255, 255));

        jScrollPane1.setBackground(new java.awt.Color(255, 255, 255));
        jScrollPane1.setForeground(new java.awt.Color(0, 0, 0));

        jTable1.setBackground(new java.awt.Color(255, 255, 255));
        jTable1.setFont(new java.awt.Font("Cantarell", 0, 18)); // NOI18N
        jTable1.setForeground(new java.awt.Color(0, 0, 0));
        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][]
            {
                {null, null, null, null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null, null, null, null}
            },
            new String []
            {
                "Id", "Nombre", "Apellido paterno", "Apellido materno", "Correo", "Nickname", "Contraseña", "genero", "Localidad", "Profesión", "Fecha de nacimiento", "fecha de registro", "estatus", "Action"
            }
        )
        {
            Class[] types = new Class []
            {
                java.lang.Object.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.Object.class, java.lang.String.class, java.lang.String.class, java.lang.Integer.class, java.lang.Object.class
            };
            boolean[] canEdit = new boolean []
            {
                false, false, false, false, false, false, false, false, false, false, false, false, false, true
            };

            public Class getColumnClass(int columnIndex)
            {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex)
            {
                return canEdit [columnIndex];
            }
        });
        jTable1.setAutoResizeMode(javax.swing.JTable.AUTO_RESIZE_OFF);
        jTable1.setFillsViewportHeight(true);
        jTable1.setFocusable(false);
        jTable1.setGridColor(new java.awt.Color(255, 255, 255));
        jTable1.setRowHeight(40);
        jTable1.setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
        jTable1.setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
        jTable1.setShowGrid(false);
        jTable1.getTableHeader().setReorderingAllowed(false);
        jScrollPane1.setViewportView(jTable1);
        if (jTable1.getColumnModel().getColumnCount() > 0)
        {
            jTable1.getColumnModel().getColumn(1).setMinWidth(100);
            jTable1.getColumnModel().getColumn(1).setMaxWidth(100);
            jTable1.getColumnModel().getColumn(2).setMinWidth(100);
            jTable1.getColumnModel().getColumn(2).setMaxWidth(100);
            jTable1.getColumnModel().getColumn(3).setMinWidth(110);
            jTable1.getColumnModel().getColumn(3).setMaxWidth(110);
            jTable1.getColumnModel().getColumn(4).setMinWidth(180);
            jTable1.getColumnModel().getColumn(4).setMaxWidth(180);
            jTable1.getColumnModel().getColumn(6).setMinWidth(100);
            jTable1.getColumnModel().getColumn(6).setMaxWidth(100);
            jTable1.getColumnModel().getColumn(7).setMinWidth(50);
            jTable1.getColumnModel().getColumn(7).setMaxWidth(50);
            jTable1.getColumnModel().getColumn(8).setMinWidth(150);
            jTable1.getColumnModel().getColumn(8).setMaxWidth(150);
            jTable1.getColumnModel().getColumn(9).setMinWidth(100);
            jTable1.getColumnModel().getColumn(9).setMaxWidth(100);
            jTable1.getColumnModel().getColumn(10).setMinWidth(120);
            jTable1.getColumnModel().getColumn(10).setMaxWidth(120);
            jTable1.getColumnModel().getColumn(11).setMinWidth(120);
            jTable1.getColumnModel().getColumn(11).setMaxWidth(120);
            jTable1.getColumnModel().getColumn(12).setMinWidth(50);
            jTable1.getColumnModel().getColumn(12).setMaxWidth(50);
            jTable1.getColumnModel().getColumn(13).setMinWidth(160);
            jTable1.getColumnModel().getColumn(13).setMaxWidth(160);
        }

        jButton1.setBackground(new java.awt.Color(255, 255, 255));
        jButton1.setForeground(new java.awt.Color(0, 0, 0));
        jButton1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/cell/add.png"))); // NOI18N
        jButton1.setText("Agregar Usuario");
        jButton1.addActionListener(new java.awt.event.ActionListener()
        {
            public void actionPerformed(java.awt.event.ActionEvent evt)
            {
                jButton1ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 800, Short.MAX_VALUE)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jButton1)
                .addGap(19, 19, 19))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap(22, Short.MAX_VALUE)
                .addComponent(jButton1)
                .addGap(18, 18, 18)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 226, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt)//GEN-FIRST:event_jButton1ActionPerformed
    {//GEN-HEADEREND:event_jButton1ActionPerformed
        addDocument();
    }//GEN-LAST:event_jButton1ActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[])
    {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try
        {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels())
            {
                if ("Nimbus".equals(info.getName()))
                {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex)
        {
            java.util.logging.Logger.getLogger(Main.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex)
        {
            java.util.logging.Logger.getLogger(Main.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex)
        {
            java.util.logging.Logger.getLogger(Main.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex)
        {
            java.util.logging.Logger.getLogger(Main.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable()
        {
            public void run()
            {
                new Main().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTable1;
    // End of variables declaration//GEN-END:variables

    private void connectWithMongo()
    {
        conn = new Connection();
        conn.defaultConnection();
    }

    private void getData()
    {
        data = conn.getAllDocuments();
    }

    private void fillTable()
    {
        tableModel = (DefaultTableModel) jTable1.getModel();
        int count = tableModel.getRowCount();
        for (int i = 0; i < count; i++)
        {
            tableModel.removeRow(0);
        }
        for (int i = 0; i < data.size(); i++)
        {
            tableModel.addRow(((Usuario) data.get(i)).toArray());
        }
        jTable1.getColumnModel().getColumn(13).setCellRenderer(new TableActionCellRender());
        jTable1.getColumnModel().getColumn(13).setCellEditor(new TableActionCellEditor(event));

    }

    private void setEvents()
    {
        event = new TableActionEvent()
        {
            @Override
            public void onEdit(int row)
            {
                EditDocument(row);
            }

            @Override
            public void onDelete(int row)
            {
                DeleteDocument(row);
            }
        };
    }

    private void EditDocument(int row)
    {
        String id = tableModel.getValueAt(row, 0).toString();

        String nombre = setDataToModify("MOdificar el nombre:", tableModel.getValueAt(row, 1).toString());
        if (nombre == null)
        {
            mostrarMensaje("Operación cancelada. Adiós.");
            return;
        }
        while (!isValidName(nombre))
        {
            nombre = setDataToModify("El dato \"" + nombre + "\" no es válido, ingrese de nuevo:", tableModel.getValueAt(row, 1).toString());
            if (nombre == null)
            {
                mostrarMensaje("Operación cancelada. Adiós.");
                return;
            }
        }

        // Solicitar el apellido paterno
        String apPaterno = setDataToModify("MOdificar el apellido paterno:", tableModel.getValueAt(row, 2).toString());
        if (apPaterno == null)
        {
            mostrarMensaje("Operación cancelada. Adiós.");
            return;
        }
        while (!isValidName(apPaterno))
        {
            apPaterno = setDataToModify("El dato \"" + apPaterno + "\" no es válido, ingrese de nuevo:", tableModel.getValueAt(row, 2).toString());
            if (apPaterno == null)
            {
                mostrarMensaje("Operación cancelada. Adiós.");
                return;
            }
        }

        // Solicitar el apellido materno
        String apMaterno = setDataToModify("MOdificar el apellido materno:", tableModel.getValueAt(row, 3).toString());
        if (apMaterno == null)
        {
            mostrarMensaje("Operación cancelada. Adiós.");
            return;
        }
        while (!isValidName(apMaterno))
        {
            apMaterno = setDataToModify("El dato \"" + apMaterno + "\" no es válido, ingrese de nuevo:", tableModel.getValueAt(row, 3).toString());
            if (apMaterno == null)
            {
                mostrarMensaje("Operación cancelada. Adiós.");
                return;
            }
        }

        // Solicitar el correo electrónico
        String correo = setDataToModify("MOdificar el correo electrónico:", tableModel.getValueAt(row, 4).toString());
        if (correo == null)
        {
            mostrarMensaje("Operación cancelada. Adiós.");
            return;
        }
        while (!isValidEmail(correo))
        {
            correo = setDataToModify("El dato \"" + correo + "\" no es válido, ingrese de nuevo:", tableModel.getValueAt(row, 4).toString());
            if (correo == null)
            {
                mostrarMensaje("Operación cancelada. Adiós.");
                return;
            }
        }

        // Solicitar el nickname
        String nickname = setDataToModify("Ingrese el nickname:", tableModel.getValueAt(row, 5).toString());
        if (nickname == null)
        {
            mostrarMensaje("Operación cancelada. Adiós.");
            return;
        }

        // Solicitar la contraseña
        String contrasenia = setDataToModify("Ingrese la contraseña:", tableModel.getValueAt(row, 6).toString());
        if (contrasenia == null)
        {
            mostrarMensaje("Operación cancelada. Adiós.");
            return;
        }

        // Solicitar el género
        String genero = setDataToModify("Ingrese el género (H/M):", tableModel.getValueAt(row, 7).toString());
        if (genero == null)
        {
            mostrarMensaje("Operación cancelada. Adiós.");
            return;
        }
        while (!isValidGen(genero))
        {
            genero = setDataToModify("El dato \"" + genero + "\" no es válido, ingrese de nuevo:", tableModel.getValueAt(row, 7).toString());
            if (genero == null)
            {
                mostrarMensaje("Operación cancelada. Adiós.");
                return;
            }
        }
        // Solicitar la localidad
        String localidad = setDataToModify("Ingrese la localidad:", tableModel.getValueAt(row, 8).toString());
        if (localidad == null)
        {
            mostrarMensaje("Operación cancelada. Adiós.");
            return;
        }

        // Solicitar la profesión
        String profesion = setDataToModify("Ingrese la profesión:", tableModel.getValueAt(row, 9).toString());
        if (profesion == null)
        {
            mostrarMensaje("Operación cancelada. Adiós.");
            return;
        }
        // Solicitar la fecha de nacimiento
        String fechaNacimiento = setDataToModify("MOdificar la fecha de nacimiento (YYYY/MM/DD):", tableModel.getValueAt(row, 10).toString());
        if (fechaNacimiento == null)
        {
            mostrarMensaje("Operación cancelada. Adiós.");
            return;
        }
        while (!correctBirthDate(fechaNacimiento))
        {
            fechaNacimiento = setDataToModify("El dato \"" + fechaNacimiento + "\" no es válido, ingrese de nuevo:", tableModel.getValueAt(row, 10).toString());
            if (fechaNacimiento == null)
            {
                mostrarMensaje("Operación cancelada. Adiós.");
                return;
            }
        }

        // Solicitar el estatus
        String estatus = setDataToModify("Ingrese el estatus (1 para activo, 0 para inactivo):", tableModel.getValueAt(row, 12).toString());
        if (estatus == null)
        {
            mostrarMensaje("Operación cancelada. Adiós.");
            return;
        }
        while (!validateStatus(estatus))
        {
            estatus = setDataToModify("El dato \"" + estatus + "\" no es válido, ingrese de nuevo:", tableModel.getValueAt(row, 12).toString());
            if (estatus == null)
            {
                mostrarMensaje("Operación cancelada. Adiós.");
                return;
            }
        }

        if (conn.updateDocument(id, nombre, apPaterno, apMaterno, correo, nickname, contrasenia, genero, localidad, profesion, readDate(fechaNacimiento), estatus) == 200)
        {
            String mensaje = "Resultado:\n"
                    + "Nombre: " + nombre + "\n"
                    + "Apellido Paterno: " + apPaterno + "\n"
                    + "Apellido Materno: " + apMaterno + "\n"
                    + "Fecha de Nacimiento: " + fechaNacimiento + "\n"
                    + "Correo Electrónico: " + correo + "\n"
                    + "Nickname: " + nickname + "\n"
                    + "Contraseña: " + contrasenia + "\n"
                    + "Género: " + genero + "\n"
                    + "Localidad: " + localidad + "\n"
                    + "Profesión: " + profesion + "\n"
                    + "Estatus: " + estatus;
            mostrarMensaje(mensaje);
        } else
        {
            mostrarMensaje("Error, no se pudo modificar el documento");
        }
        getData();
        fillTable();
    }

    private void addDocument()
    {
        String nombre = setData("Ingresa el nombre:");
        if (nombre == null)
        {
            mostrarMensaje("Operación cancelada. Adiós.");
            return;
        }
        while (!isValidName(nombre))
        {
            nombre = setData("El dato \"" + nombre + "\" no es válido, ingrese de nuevo:");
            if (nombre == null)
            {
                mostrarMensaje("Operación cancelada. Adiós.");
                return;
            }
        }

        // Solicitar el apellido paterno
        String apPaterno = setData("Ingresa el apellido paterno:");
        if (apPaterno == null)
        {
            mostrarMensaje("Operación cancelada. Adiós.");
            return;
        }
        while (!isValidName(apPaterno))
        {
            apPaterno = setData("El dato \"" + apPaterno + "\" no es válido, ingrese de nuevo:");
            if (apPaterno == null)
            {
                mostrarMensaje("Operación cancelada. Adiós.");
                return;
            }
        }

        // Solicitar el apellido materno
        String apMaterno = setData("Ingresa el apellido materno:");
        if (apMaterno == null)
        {
            mostrarMensaje("Operación cancelada. Adiós.");
            return;
        }
        while (!isValidName(apMaterno))
        {
            apMaterno = setData("El dato \"" + apMaterno + "\" no es válido, ingrese de nuevo:");
            if (apMaterno == null)
            {
                mostrarMensaje("Operación cancelada. Adiós.");
                return;
            }
        }

        // Solicitar el correo electrónico
        String correo = setData("Ingresa el correo electrónico:");
        if (correo == null)
        {
            mostrarMensaje("Operación cancelada. Adiós.");
            return;
        }
        while (!isValidEmail(correo))
        {
            correo = setData("El dato \"" + correo + "\" no es válido, ingrese de nuevo:");
            if (correo == null)
            {
                mostrarMensaje("Operación cancelada. Adiós.");
                return;
            }
        }

        // Solicitar el nickname
        String nickname = setData("Ingrese el nickname:");
        if (nickname == null)
        {
            mostrarMensaje("Operación cancelada. Adiós.");
            return;
        }

        // Solicitar la contraseña
        String contrasenia = setData("Ingrese la contraseña:");
        if (contrasenia == null)
        {
            mostrarMensaje("Operación cancelada. Adiós.");
            return;
        }

        // Solicitar el género
        String genero = setData("Ingrese el género (H/M):");
        if (genero == null)
        {
            mostrarMensaje("Operación cancelada. Adiós.");
            return;
        }
        while (!isValidGen(genero))
        {
            genero = setData("El dato \"" + genero + "\" no es válido, ingrese de nuevo:");
            if (genero == null)
            {
                mostrarMensaje("Operación cancelada. Adiós.");
                return;
            }
        }
        // Solicitar la localidad
        String localidad = setData("Ingrese la localidad:");
        if (localidad == null)
        {
            mostrarMensaje("Operación cancelada. Adiós.");
            return;
        }

        // Solicitar la profesión
        String profesion = setData("Ingrese la profesión:");
        if (profesion == null)
        {
            mostrarMensaje("Operación cancelada. Adiós.");
            return;
        }
        // Solicitar la fecha de nacimiento
        String fechaNacimiento = setData("Ingrese la fecha de nacimiento (YYYY/MM/DD):");
        if (fechaNacimiento == null)
        {
            mostrarMensaje("Operación cancelada. Adiós.");
            return;
        }
        while (!correctBirthDate(fechaNacimiento))
        {
            fechaNacimiento = setData("El dato \"" + fechaNacimiento + "\" no es válido, ingrese de nuevo:");
            if (fechaNacimiento == null)
            {
                mostrarMensaje("Operación cancelada. Adiós.");
                return;
            }
        }

        if (conn.addDocument(nombre, apPaterno, apMaterno, correo, nickname, contrasenia, genero, localidad, profesion, readDate(fechaNacimiento)) == 200)
        {
            String mensaje = "Documento insertado:\n"
                    + "Nombre: " + nombre + "\n"
                    + "Apellido Paterno: " + apPaterno + "\n"
                    + "Apellido Materno: " + apMaterno + "\n"
                    + "Fecha de Nacimiento: " + fechaNacimiento + "\n"
                    + "Correo Electrónico: " + correo + "\n"
                    + "Nickname: " + nickname + "\n"
                    + "Contraseña: " + contrasenia + "\n"
                    + "Género: " + genero + "\n"
                    + "Localidad: " + localidad + "\n"
                    + "Profesión: " + profesion + "\n";
            mostrarMensaje(mensaje);
        } else
        {
            mostrarMensaje("Error, no se pudo modificar el documento");
        }
        getData();
        fillTable();
    }

    private static boolean validateStatus(String status)
    {
        return status.equals("1") || status.equals("0");
    }

    private boolean correctBirthDate(String date)
    {
        Date temp = readDate(date);
        if (temp != null)
        {
            if (validateAge(temp))
            {
                return true;
            }
        }
        return false;
    }

    private Date readDate(String dateText)
    {
        SimpleDateFormat formatoFecha = new SimpleDateFormat("dd/MM/yyyy");
        formatoFecha.setLenient(false); // Desactivar la flexibilidad en el análisis

        try
        {
            // Intentar analizar la cadena de fecha
            return formatoFecha.parse(dateText);
        } catch (ParseException e)
        {
            // La cadena de fecha no es válida
            return null;
        }
    }

    private boolean validateAge(Date birthdate)
    {
        // Obtener la fecha actual
        Date sysdate = new Date();

        // Crear instancias de Calendar y establecer las fechas
        Calendar calendarBirth = Calendar.getInstance();
        calendarBirth.setTime(birthdate);

        Calendar calendarSysdate = Calendar.getInstance();
        calendarSysdate.setTime(sysdate);

        // Calcular la diferencia en años
        int diffYears = calendarSysdate.get(Calendar.YEAR) - calendarBirth.get(Calendar.YEAR);

        // Comprobar si han pasado más de 6 años
        return diffYears > 6;
    }

    private String setDataToModify(String msj, String oldValue)
    {
        return JOptionPane.showInputDialog(null, msj, oldValue);
    }

    private String setData(String msj)
    {
        return JOptionPane.showInputDialog(msj);
    }

    public boolean isValidName(String nombre)
    {
        // Patrón que permite letras mayúsculas y minúsculas, espacios y apóstrofes
        String patternString = "^[a-zA-Zá-úÁ-Ú]+(\\s[a-zA-Zá-úÁ-Ú]+)*$";

        // Compila el patrón
        Pattern pattern = Pattern.compile(patternString);

        // Crea un objeto Matcher para realizar la comparación
        Matcher matcher = pattern.matcher(nombre);

        // Devuelve true si el nombre coincide con el patrón
        return matcher.matches();
    }

    private boolean isValidGen(String genero)
    {
        return genero.equals("H") || genero.equals("M");
    }

    private boolean isValidEmail(String correo)
    {
        String regExEmail = "^[A-Za-z0-9._%+-]+@[A-Za-z0-9.-]+\\.[A-Z|a-z]{2,}$";

        Pattern pattern = Pattern.compile(regExEmail);
        Matcher matcher = pattern.matcher(correo);

        return matcher.matches();
    }

    private void mostrarMensaje(String mensaje)
    {
        JOptionPane.showMessageDialog(null, mensaje);
    }

    private void DeleteDocument(int row)
    {
        String id = tableModel.getValueAt(row, 0).toString();
        if (conn.deleteDocument(id) == 200)
        {
            String mensaje = "Elemento " + id + ", eliminado";
            mostrarMensaje(mensaje);
        } else
        {
            mostrarMensaje("Error, no se pudo eliminar el documento");
        }
        tableModel.removeRow(row);
    }

}
