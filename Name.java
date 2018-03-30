/*
 * class to model the name of a customer
 * with title, initials, and surname
 */
package sportsequipmentproject;

/**
 *
 * @author Nicole
 */
public class Name {
private String title;
private String initials;
private String surname;
/**
* Creates a new default Name
*/
public Name()
{
    title=" ";
    initials=" ";
    surname=" ";
}
/**
* Creates a new Name with given parameters
*/
public Name( String title,String initials,String surname)
{
    this.title=title;
    this.initials=initials;
    this.surname=surname;
}
/**
* sets title to given value
*/
public void setTitle(String title)
{
    this.title=title;
}
/**
* sets initials to given value
*/
public void setInitials(String initials)
{
    this.initials=initials;
}
/**
* sets surname to given value
*/
public void setSurname(String surname)
{
    this.surname=surname;
}
/**
* returns title
*/
public String getTitle()
{
    return this.title;
}
/**
* returns initials
*/
public String getInitials()
{
    return this.initials;
}
/**
* returns surname 
*/
public String getSurname()
{
    return this.surname;
}
public String toString()
{
    StringBuilder name= new StringBuilder();
    name.append(" Title: ").append(" ").append(this.title).append(" Initials: ").append(" ").append(this.initials).append(" ").append(" Surname: ").append(" ").append(this.surname);
    return name.toString(); 
}
}
