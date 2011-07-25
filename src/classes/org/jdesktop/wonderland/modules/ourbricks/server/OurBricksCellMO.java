package org.jdesktop.wonderland.modules.ourbricks.server;

import org.jdesktop.wonderland.common.cell.ClientCapabilities;
import org.jdesktop.wonderland.common.cell.state.CellClientState;
import org.jdesktop.wonderland.common.cell.state.CellServerState;
import org.jdesktop.wonderland.modules.ourbricks.common.OurBricksCellClientState;
import org.jdesktop.wonderland.modules.ourbricks.common.OurBricksCellServerState;
import org.jdesktop.wonderland.server.cell.CellMO;
import org.jdesktop.wonderland.server.comms.WonderlandClientID;

/**
 *
 * @author jos
 */
public class OurBricksCellMO extends CellMO {

    private String shapeType = null;
    private String textureURI = null;

    public OurBricksCellMO() {
    }

    @Override
    public String getClientCellClassName(WonderlandClientID clientID, ClientCapabilities capabilities) {
         return "org.jdesktop.wonderland.modules.restsamplemodule.client.OurBricksCell";
    }

    @Override
    public CellClientState getClientState(CellClientState state, WonderlandClientID clientID, ClientCapabilities capabilities) {
        if (state == null) {
            state = new OurBricksCellClientState();
        }
        ((OurBricksCellClientState)state).setShapeType(shapeType);
        ((OurBricksCellClientState)state).setTextureURI(textureURI);
        return super.getClientState(state, clientID, capabilities);
    }

    @Override
    public CellServerState getServerState(CellServerState state) {
        if (state == null) {
            state = new OurBricksCellServerState();
        }
        ((OurBricksCellServerState)state).setShapeType(shapeType);
        ((OurBricksCellServerState)state).setTextureURI(textureURI);
        return super.getServerState(state);
    }

    @Override
    public void setServerState(CellServerState state) {
        super.setServerState(state);
        this.shapeType = ((OurBricksCellServerState)state).getShapeType();
        this.textureURI = ((OurBricksCellServerState)state).getTextureURI();
    }
}
