/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package vars;

/**
 *
 * @author oscar
 */
public interface NeededVars
{
    public final String CONNECTION_STRING = "mongodb://127.0.0.1:27017/";//la ruta de conexión a mongodb
    public final long CONNECTION_TIMEOUT_MS = 50l; //el tiempo de espera para intentar conexión en milisegundos
    public final String DATABASE_NAME = "EqRosa"; //el nombre de la base de datos
    public final String COLLECTION_NAME = "USUARIOS"; //el nombre de la colección
}
