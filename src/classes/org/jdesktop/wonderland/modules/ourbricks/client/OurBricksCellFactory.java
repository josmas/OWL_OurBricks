package org.jdesktop.wonderland.modules.ourbricks.client;

import java.awt.Image;
import java.util.Properties;
import org.jdesktop.wonderland.client.cell.registry.annotation.CellFactory;
import org.jdesktop.wonderland.client.cell.registry.spi.CellFactorySPI;
import org.jdesktop.wonderland.common.cell.state.CellServerState;
import org.jdesktop.wonderland.modules.ourbricks.common.OurBricksCellServerState;

@CellFactory
public class OurBricksCellFactory implements CellFactorySPI {

    public String[] getExtensions() {
        return new String[] {};
    }

    public <T extends CellServerState> T getDefaultCellServerState(Properties props) {
        OurBricksCellServerState state = new OurBricksCellServerState();
        //TODO change the texture for something that says 'Register me!'
        state.setTextureURI("wla://rest-sample-module/MountainPicture.png");
        return (T)state;
    }

    public String getDisplayName() {
        return "OurBricks Module";
    }

    public Image getPreviewImage() {
        return null;
   }
}
