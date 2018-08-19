/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI;

import java.awt.Dimension;
import java.awt.Rectangle;
import javax.swing.JPanel;
import javax.swing.Scrollable;

/**
 *
 * @author dimri
 */
public class ScroolPanelCustom extends JPanel implements Scrollable
{
    @Override
    public Dimension getPreferredSize()
    {
        return getPreferredScrollableViewportSize();
    }

    @Override
    public Dimension getPreferredScrollableViewportSize()
    {
        if( getParent() == null )
            return getSize();
        Dimension d = getParent().getSize();
   return  d;
    }
    @Override
    public int getScrollableBlockIncrement(Rectangle visibleRect, int orientation, int direction)
    {
        return 50;
    }
    @Override
    public int getScrollableUnitIncrement(Rectangle visibleRect, int orientation, int direction)
    {
        return 10;
    }
    @Override
    public boolean getScrollableTracksViewportHeight()
    {
        return true;
        //return false;
    }

    @Override
    public boolean getScrollableTracksViewportWidth()
    {
        return true;
       //return getParent() != null ? getParent().getSize().width > getPreferredSize().width : true;
    }
}
