package org.jdesktop.wonderland.modules.ourbricks.client.ourbricks;

import java.awt.Color;
import java.awt.Component;
import java.net.MalformedURLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.ListCellRenderer;

/**
 *
 * @author jos
 */
public class OurBricksCellRenderer extends JLabel implements ListCellRenderer {

    private static final Color HIGHLIGHT_COLOR = new Color(0, 0, 208);

    public OurBricksCellRenderer() {
        setOpaque(true);
        setIconTextGap(12);
    }

    public Component getListCellRendererComponent(JList list, Object value,
            int index, boolean isSelected, boolean cellHasFocus) {
        OurBrick brick = (OurBrick) value;
        String warning = calculateWarnings(brick);
        setText("<html>Model: " + brick.getTitle() + "<br> License: " + brick.getLicense_code() + "<br>" + warning + "</html>");
        try {
            setIcon(new javax.swing.ImageIcon(new java.net.URL(brick.getThumbnail_link())));
        } catch (MalformedURLException ex) {
            Logger.getLogger(OurBricksCellRenderer.class.getName()).log(Level.SEVERE, null, ex);
        }
        if (isSelected) {
            setBackground(HIGHLIGHT_COLOR);
            setForeground(Color.white);
        } else {
            setBackground(Color.white);
            setForeground(Color.black);
        }
        if (!warning.equals(""))
            setForeground(Color.red);
        return this;
    }

    private String calculateWarnings(OurBrick brick) {
        if ( brick.getTechnical_details().getNum_triangles() == null ||
             Integer.parseInt(brick.getTechnical_details().getNum_triangles()) > 200000 ||
             Integer.parseInt(brick.getTechnical_details().getTexture_ram()) > 20000 ||
             Integer.parseInt(brick.getTechnical_details().getNum_vertices()) > 200000 )
            return "Model NOT recommended";
        return "";
    }
}