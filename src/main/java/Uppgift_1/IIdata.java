package Uppgift_1;
/**
 *  Interface that defines methods to get the main type of work (MainWork) and the name of the department.
 */
public interface IIdata {

    /**
     * The main type of work
     * @return a value of type MainWork that indicates whether the work is "Paper" or "Digital".
     */
  MainWork getMainwork();

    /**
     * The department name
     * @return a string that indicates the name of the department.
     */
  String GetDepartment();


    /**
     * Enum that defines the main type of work.
     * Paper: indicates that the work is done on paper.
     * Digital: indicates that the work is done digitally.
     */
    enum MainWork {
       Paper,
       Digital,
    }

}
