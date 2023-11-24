/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package equipo.rosa.crudmongo;


import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;


public class Prb
{

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args)
    {
        Main m = new Main();
        //Constructora constructora = new Constructora();
        m.setVisible(true);
        try
        {
            UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
        } catch (ClassNotFoundException | InstantiationException | IllegalAccessException | UnsupportedLookAndFeelException ex)
        {
            
        }
    }
    
}
