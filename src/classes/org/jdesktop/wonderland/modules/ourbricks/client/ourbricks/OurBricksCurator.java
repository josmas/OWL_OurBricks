package org.jdesktop.wonderland.modules.ourbricks.client.ourbricks;

import java.util.ArrayList;

/**
 *
 * @author jos
 */
public class OurBricksCurator {

    public OurBricksList curateList(OurBricksList brickList) {
        ArrayList<OurBrick> curatedList = new ArrayList<OurBrick>();
        for (OurBrick brick : brickList.getItems()) {
            if (brick.getPrice() == null)
                if (brick.getDownload_link() != null)
                    curatedList.add(brick);
        }

        return new OurBricksList(brickList.getPrev_start(), curatedList, brickList.getNext_start());
    }
}
