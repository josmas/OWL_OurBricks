/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package org.jdesktop.wonderland.modules.ourbricks.client.ourbricks;
import java.math.BigDecimal;

/**
 *
 * @author jos
 */
public class OurBrick {

    public OurBrick() {
    }

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

    //These would be soemthing like an OurBricksLsit!
//    private int prev_start;
//    private List items;
//    private int next_start;

    private BigDecimal price;
    private String thumbnail_link;
    private String username;
    private String download_link;
    private String title;
    private String viewer_link;
    private String author;
    private String license_code;
    private String id;

    public String getAuthor() {
        return author;
    }

    public String getDownload_link() {
        return download_link;
    }

    public String getId() {
        return id;
    }

    public String getLicense_code() {
        return license_code;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public String getThumbnail_link() {
        return thumbnail_link;
    }

    public String getTitle() {
        return title;
    }

    public String getUsername() {
        return username;
    }

    public String getViewer_link() {
        return viewer_link;
    }

}
