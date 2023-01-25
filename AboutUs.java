
package gamecenter;

public class AboutUs {
    private String description;
    private String date;
    private String collage;
    
    public AboutUs(String descrip, String d, String col){
        descrip = description;
        d = date;
        col = collage;
    }
    
    public AboutUs(AboutUs object){
        description = object.description;
        date = object.date;
        collage = object.collage;
    }
    
    public void set(String descrip, String d, String col ){
        description = descrip;
        date = d;
        collage = col;
        
    }
    
    public String printDetails(){
        String output = description + "dfg\n" + date + "\n" + collage + "\n";
        return output;
    }
}

