package org.jdesktop.wonderland.modules.ourbricks.common;

import org.jdesktop.wonderland.common.cell.state.CellClientState;

public class OurBricksCellClientState extends CellClientState {
    private String shapeType = null;
    private String textureURI = null;

    public OurBricksCellClientState() {
    }
    
    public String getShapeType() {
        return shapeType;
    }

    public void setShapeType(String shapeType) {
        this.shapeType = shapeType;
    }

    public String getTextureURI() {
        return textureURI;
    }

    public void setTextureURI(String textureURI) {
        this.textureURI = textureURI;
    }
}
