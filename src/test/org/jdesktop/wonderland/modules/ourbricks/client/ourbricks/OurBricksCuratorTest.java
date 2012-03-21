package org.jdesktop.wonderland.modules.ourbricks.client.ourbricks;

import com.google.gson.Gson;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author jos
 */
public class OurBricksCuratorTest {

    @Before
    public void setUp() {
    }
    
    /**
     * 
     * returns
            {
                prev_start: null,
                items: [
                    {
                        username: "Manfred van der Voort",
                        description: "",
                        price: null,
                        thumbnail_link: "http://vu.ourbricks.com/3939a9dc288effbba7e6dee6df4495ff/processed/ourbricksThumb.jpg?133237015084",
                        viewer_link: "http://ourbricks.com/viewer/3939a9dc288effbba7e6dee6df4495ff",
                        id: "3939a9dc288effbba7e6dee6df4495ff",
                        license_code: "allrightsreserved",
                        technical_details: {
                            num_normals: 4034553,
                            num_triangles: 1344851,
                            num_effects: 28,
                            num_texcoords: 3357930,
                            texture_ram: 4653056,
                            draw_calls_raw: 3529,
                            num_textures: 13,
                            draw_calls_with_material_batching: 28,
                            num_vertices: 4034553,
                            draw_calls_with_instance_batching: 155
                        },
                        title: "Kolosseum",
                        author: "Mario",
                        download_link: null
                    }
                ],
                next_start: 1
                }
    */

    private String JSONReply = 
            "{" +
            "prev_start: null," +
            "items: [{" +
            "username: \"Manfred van der Voort\"," +
            "description: \"\"," +
            "price: null," +
            "thumbnail_link: \"http://vu.ourbricks.com/3939a9dc288effbba7e6dee6df4495ff/processed/ourbricksThumb.jpg?133237015084\"," +
            "viewer_link: \"http://ourbricks.com/viewer/3939a9dc288effbba7e6dee6df4495ff\"," +
            "id: \"3939a9dc288effbba7e6dee6df4495ff\"," +
            "license_code: \"allrightsreserved\"," +
            "technical_details: {" +
                "num_normals: 4034553," +
                "num_triangles: 1344851," +
                "num_effects: 28," +
                "num_texcoords: 3357930," +
                "texture_ram: 4653056," +
                "draw_calls_raw: 3529," +
                "num_textures: 13," +
                "draw_calls_with_material_batching: 28," +
                "num_vertices: 4034553," +
                "draw_calls_with_instance_batching: 155" +
            "}," +
            "title: \"Kolosseum\"," +
            "author: \"Mario\"," +
            "download_link: null" +
            "}]," +
            "next_start: 1" +
            "}";
    private OurBricksList fakeList = (new Gson()).fromJson(JSONReply, OurBricksList.class);


    @Test
    public void testCurateList() {
        OurBricksList curatedList;
        OurBricksCurator curator = new OurBricksCurator();
        curatedList = curator.curateList(fakeList);
        assertNotNull(fakeList.getItems().get(0));
        assertNull(fakeList.getItems().get(0).getPrice());
        assertEquals(true, curatedList.isEmpty());
    }
}
