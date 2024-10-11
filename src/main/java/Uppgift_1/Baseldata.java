package Uppgift_1;

/**
 * This class is an abstract class that implements the IIdata interface
 * and provides a basic structure for classes inheriting from it.
 */
public abstract class Baseldata implements IIdata {

  /**
   * This method is an abstract method that returns the type of work.
   * @return a value of type MainWork indicating whether the work is "Paper" or "Digital".
   */
  public abstract MainWork getMainwork();

  /**
   * This method is an abstract method that returns the name of the department.
   * @return a string that indicates the name of the department.
   */
  public abstract String GetDepartment();
}

/**
 * This subclass inherits from Baseldata and provides the implementation for the getMainwork and GetDepartment methods.
 */
class ProductionIdata extends Baseldata{
  /**
   * ProductionIdata implementation of the getMainwork method.
   * @return a value of type MainWork that indicates whether the work is "Paper" or "Digital".
   */
  @Override
  public MainWork getMainwork() {
    return MainWork.Paper;
  }

  /**
   * ProductionIdata implementation of the GetDepartment method.
   * @return a string that indicates the name of the department.
   */
  @Override
  public String GetDepartment() {
    return "Production";
  }
}


/**
 * This subclass inherits from Baseldata and provides the implementation for the getMainwork and GetDepartment methods.
 */
class DevIdata extends Baseldata{
  /**
   * DevIdata implementation of the getMainwork method.
   * @return a value of type MainWork that indicates whether the work is "Paper" or "Digital".
   */
  @Override
  public MainWork getMainwork() {
    return MainWork.Digital;
  }

  /**
   * DevIdata implementation of the GetDepartment method.
   * @return a string that indicates the name of the department.
   */
  @Override
  public String GetDepartment() {
    return "Development";
  }
}

