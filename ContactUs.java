
package gamecenter;

public class ContactUs {
    private String names;
    private String idNum;
    private String emails;
    
    public ContactUs(String name, String id, String email){
        names =  name;
        idNum = id;
        emails = email;
    }
    
    public ContactUs(ContactUs object){
        names = object.names;
        idNum = object.idNum;
        emails = object.emails;
        
    }
    
    public void set(String name, String id, String email){
        names =  name;
        idNum = id;
        emails = email;
    }
    
    public String printDetails(){
        String output = names + "\n" + idNum + "\n" + emails + "\n";
        return output;
    }
    
}
