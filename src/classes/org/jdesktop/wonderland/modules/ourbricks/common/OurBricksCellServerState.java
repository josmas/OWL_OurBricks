package org.jdesktop.wonderland.modules.ourbricks.common;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;
import org.jdesktop.wonderland.common.cell.state.CellServerState;
import org.jdesktop.wonderland.common.cell.state.annotation.ServerState;

@XmlRootElement(name="shape-cell")
@ServerState
public class OurBricksCellServerState extends CellServerState {

    //TODO this is a copy of the sample module, these attributes will not be needed!
    @XmlElement(name="shape-type")
    private String shapeType = "BOX";

    @XmlElement(name="texture-uri")
    private String textureURI = null;

    public OurBricksCellServerState() {
    }
    
    @XmlTransient public String getShapeType() { return this.shapeType; }
    public void setShapeType(String shapeType) { this.shapeType = shapeType; }
    @XmlTransient public String getTextureURI() { return this.textureURI; }
    public void setTextureURI(String textureURI) { this.textureURI = textureURI; }

    @Override
    public String getServerClassName() {
        return "org.jdesktop.wonderland.modules.restsamplemodule.server.OurBricksCellMO";
    }
}
