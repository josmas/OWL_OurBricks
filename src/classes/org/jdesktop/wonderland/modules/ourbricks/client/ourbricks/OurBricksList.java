package org.jdesktop.wonderland.modules.ourbricks.client.ourbricks;

import java.util.ArrayList;
import java.util.List;

/**
 * Attribute names do not follow Java convention because they are mirroring
 * the output of the http://ourbricks.com API
 * @author jos
 */

// Output example
//    {
//        "prev_start": null,
//        "items": [
//            {   "price": null,
//                "thumbnail_link": "http://vu.ourbricks.com/6e2dd650eaa7832d88f4e8b70e3db611/processed/ourbricksThumb.jpg",
//                "username": "danx0r",
//                "description": "testing navigation",
//                "download_link": "http://vu.ourbricks.com/6e2dd650eaa7832d88f4e8b70e3db611/processed/ourbricks.zip",
//                "title": "kataspace main scene",
//                "viewer_link": "http://ourbricks.com/viewer/6e2dd650eaa7832d88f4e8b70e3db611",
//                "author": "",
//                "license_code": "ccby",
//                "id": "6e2dd650eaa7832d88f4e8b70e3db611"
//            }    ],
//        "next_start": 1
//    }

public class OurBricksList {

    private Integer prev_start;
    private List<OurBrick> items = new ArrayList<OurBrick>();
    private Integer next_start;

    public OurBricksList(){
    }

    public OurBricksList(Integer prev_start, List<OurBrick> items, Integer next_start){
        this.prev_start = prev_start;
        this.items = items;
        this.next_start = next_start;
    }

    public List<OurBrick> getItems() {
        return items;
    }

    public Integer getNext_start() {
        return next_start;
    }

    public Integer getPrev_start() {
        return prev_start;
    }

    public boolean isEmpty(){
        return this.items.isEmpty();
    }

    
}
