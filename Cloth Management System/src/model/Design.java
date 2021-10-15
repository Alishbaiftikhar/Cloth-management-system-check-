package model;

import java.io.IOException;
import java.io.OutputStream;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class Design extends OutputStream implements Serializable {
    String pattern;
    String design_code;
    List<String> colours=new ArrayList<>();
    public Design(String pattern, String design_code, List<String> colours){
        this.pattern=pattern;
        this.design_code=design_code;
        this.colours=colours;

    }

    public String getPattern() {
        return pattern;
    }

    public String getDesign_code() {
        return design_code;
    }

    public List<String> getColours() {
        return colours;
    }

    public void setPattern(String pattern) {
        this.pattern = pattern;
    }

    public void setDesign_code(String design_code) {
        this.design_code = design_code;
    }

    public void setColours(List<String> colours) {
        this.colours = colours;
    }

    @Override
    public void write(int b) throws IOException {


    }

    @Override
    public String toString() {
        return "Design{" +
                "pattern='" + pattern + '\'' +
                ", design_code='" + design_code + '\'' +
                ", colours=" + colours +
                '}';
    }
}
