/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package cell;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.JButton;
import javax.swing.border.EmptyBorder;

/**
 *
 * @author oscar
 */
public class ActionBtn extends JButton
{
    private boolean mousePress;
    public ActionBtn()
    {
        setContentAreaFilled(false);
        setBorder(new EmptyBorder(0,0,0,0));
    }
}
