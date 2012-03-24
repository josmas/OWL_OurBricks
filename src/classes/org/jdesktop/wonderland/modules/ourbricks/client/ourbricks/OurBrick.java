package org.jdesktop.wonderland.modules.ourbricks.client.ourbricks;
import java.math.BigDecimal;
import javax.swing.ImageIcon;

/**
 *
 * Attribute names do not follow Java convention because they are mirroring
 * the output of the http://ourbricks.com API
 * @author jos
 */

public class OurBrick {

    public OurBrick() {
    }

    private BigDecimal price;
    private String thumbnail_link;
    private String username;
    private String download_link;
    private String title;
    private String viewer_link;
    private String author;
    private String license_code;
    private TechnicalDetails technical_details;
    private String id;
    private ImageIcon icon; // Not part of the JSON structure but filled in on list rendering

    public ImageIcon getIcon() {
        return icon;
    }

    public void setIcon(ImageIcon icon) {
        this.icon = icon;
    }

    @Override
    public String toString(){
        return title;
    }

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

    public TechnicalDetails getTechnical_details() {
        return technical_details;
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

    public static class TechnicalDetails {

        private String num_normals;
        private String num_triangles;
        private String num_effects;
        private String num_texcoords;
        private String texture_ram;
        private String draw_calls_raw;
        private String num_textures;
        private String draw_calls_with_material_batching;
        private String num_vertices;
        private String draw_calls_with_instance_batching;

        public String getDraw_calls_raw() {
            return draw_calls_raw;
        }

        public String getDraw_calls_with_instance_batching() {
            return draw_calls_with_instance_batching;
        }

        public String getDraw_calls_with_material_batching() {
            return draw_calls_with_material_batching;
        }

        public String getNum_effects() {
            return num_effects;
        }

        public String getNum_normals() {
            return num_normals;
        }

        public String getNum_texcoords() {
            return num_texcoords;
        }

        public String getNum_textures() {
            return num_textures;
        }

        public String getNum_triangles() {
            return num_triangles;
        }

        public String getNum_vertices() {
            return num_vertices;
        }

        public String getTexture_ram() {
            return texture_ram;
        }
    }
}