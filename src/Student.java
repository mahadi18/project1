/*PLEASE DO NOT EDIT THIS CODE*/
/*This code was generated using the UMPLE 1.22.0-${svn.revision} modeling language!*/



// line 18 "model.ump"
public class Student extends Person
{

  //------------------------
  // MEMBER VARIABLES
  //------------------------

  //Student Associations
  private Mentor mentor;

  //------------------------
  // CONSTRUCTOR
  //------------------------

  public Student(String aName)
  {
    super(aName);
  }

  //------------------------
  // INTERFACE
  //------------------------

  public Mentor getMentor()
  {
    return mentor;
  }

  public boolean hasMentor()
  {
    boolean has = mentor != null;
    return has;
  }

  public boolean setMentor(Mentor aMentor)
  {
    boolean wasSet = false;
    if (aMentor != null && aMentor.numberOfStudents() >= Mentor.maximumNumberOfStudents())
    {
      System.out.println("Number of students of the mentor is beyond the limit");
      return wasSet;
    }

    Mentor existingMentor = mentor;
    mentor = aMentor;
    if (existingMentor != null && !existingMentor.equals(aMentor))
    {
      existingMentor.removeStudent(this);
    }
    if (aMentor != null)
    {
      aMentor.addStudent(this);
    }
    wasSet = true;
    return wasSet;
  }

  public void delete()
  {
    if (mentor != null)
    {
      Mentor placeholderMentor = mentor;
      this.mentor = null;
      placeholderMentor.removeStudent(this);
    }
    super.delete();
  }

}