package org.jdesktop.wonderland.modules.ourbricks.client.ourbricks;

import static org.junit.Assert.*;
import com.google.gson.Gson;
import org.junit.Test;

/**
 *
 * @author jos
 */
public class OurBricksTest {

    /**
     * This is what the OurBricks API outputs now: March 2012
     */
    static final String JSONResponse =
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

    static final String JSONResponseTwo =
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
            "}," +
            "{" +
            "username: \"Jos\"," +
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
            "title: \"Kolosseum Two\"," +
            "author: \"Mario Two\"," +
            "download_link: \"http://vu.ourbricks.com/ceefd418de4f285bde61b56aa7535a32/processed/ourbricks.zip\"" +
            "}" +
            "]," +
            "next_start: 1" +
            "}";


    /**
     * This test depends on the Input data
     */
    @Test
    public void createGsonObject(){
        Gson gsonObject = new Gson();
        assertNotNull(gsonObject);

        OurBricksList brickList = gsonObject.fromJson(JSONResponse, OurBricksList.class);
        assertEquals("Kolosseum", brickList.getItems().get(0).getTitle());
        assertEquals("4034553", brickList.getItems().get(0).getTechnical_details().getNum_normals());
    }
}