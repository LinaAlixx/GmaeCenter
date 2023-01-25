
package gamecenter;

public class Details {
    
    public String projectName = "Game Center";
    private ContactUs contactus;
    private AboutUs aboutus;
    
    public Details(String name, AboutUs about, ContactUs contact ){
        
        projectName = name;   
        aboutus = new AboutUs(about);
        contactus = new ContactUs(contact);
    }
    
    public ContactUs getContactus(){
        return new ContactUs(contactus);
    }
    public AboutUs getAboutus(){
        return new AboutUs(aboutus);
    }
    
    public String getName(){
        return projectName;
    }
    
    public String toString(){
        String output = projectName + "\nAbout As\n\n" + aboutus + "\n Contact As\n\n" + contactus;
        return output;
    }   
    
}
