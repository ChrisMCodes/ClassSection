/**
 * Last Update: 2020-07-04
 * 
 * Purpose: This class allows for the encapsulation of the following attributes to a single object:
 * -Course Registration Number
 * -Department code (like CIS)
 * -Instructional mode (online, on campus, hybrid)
 * -Meeting days (only applicable for on campus and hybrid courses)
 * -Meeting times (only applicable for on campus and hybrid courses)
 * -Capacity (max number of students who can enroll in course)
 * -Enrollment (actual number of students enrolled)
 * -Instructor's ID number
 * 
 */

public class ClassSection {
  
    // default attributes
    protected int regNum = 0;
    protected String deptCode = "";
    protected int courseNum = 0;
    protected String instMode = "";
    protected String meetDays = "";
    protected String meetTimes = ""; // format: 0000-2359 using the 24 hour clock
    protected int classCapacity = 0;
    protected int classEnrollment = 0;
    protected int instID = 0;
    
    // constructor sets attributes to default values
    public ClassSection() {
      
      this.regNum = regNum;
      this.deptCode = deptCode;
      this.courseNum = courseNum;
      this.instMode = instMode;
      this.meetDays = meetDays;
      this.meetTimes = meetTimes;
      this.classCapacity = classCapacity;
      this.classEnrollment = classEnrollment;
      this.instID = instID;
    
  }
    
    // setters (can be called to set values for object)
    // setAttributeName style was used to avoid heavy commenting
    
    int setRegNum(int regNum) {
      return this.regNum = regNum;
    }
    String setDeptCode(String deptCode) {
      return this.deptCode = deptCode;
    }
    int setCourseNum(int courseNum) {
      return this.courseNum = courseNum;
    }
    String setInstMode(String instMode) {
      return this.instMode = instMode;
    }
    String setMeetDays(String meetDays) {
      return this.meetDays = meetDays;
    }
    String setMeetTimes(String meetTimes) {
      return this.meetTimes = meetTimes;
    }
    int setClassCapacity(int classCapacity) {
      return this.classCapacity = classCapacity;
    }
    int setInstID(int instID) {
      return this.instID = instID;
    }
    int setClassEnrollment(int classEnrollment) {
      return this.classEnrollment = classEnrollment;
    }
    
  
    
    // getters (can be called within a print method to display values of object attributes)
    // getAttributeName style was used to avoid heavy commenting.
    // These methods are actually functions for validation purposes.
    
    int getRegNum() {
      return this.regNum;
    }
    String getDeptCode() {
      return this.deptCode;
    }
    int getCourseNum() {
      return this.courseNum;
    }
    String getInstMode() {
      return this.instMode;
    }
    String getMeetDays() {
      return this.meetDays;
    }
    String getMeetTimes() {
      return this.meetTimes;
    }
    int getClassCapacity() {
      return this.classCapacity;
    }
    int getClassEnrollment() {
      return this.classEnrollment;
    }
    int getInstID() {
      return this.instID;
    }
    
    // displays attributes as a single string, as formatted below
    public String toString() {
      
      // toString() already exists, so I'm creating toString() with string output.
      // for that, I need to format a string to print and output
      String output = String.format("CRN                : %d\n" +
                                    "Department         : %s\n" +
                                    "Course number      : %d\n" +
                                    "Instructional mode : %s\n" +
                                    "Meeting days       : %s\n" +
                                    "Meeting times      : %s\n" +
                                    "Capacity           : %d\n" +
                                    "Enrollment         : %s\n" +
                                    "Instructor's ID    : %d\n",
                                    this.regNum, this.deptCode, this.courseNum, 
                                    this.instMode, this.meetDays, displayTime(this.meetTimes), 
                                    this.classCapacity, this.classEnrollment, this.instID);

      // already formatted
      System.out.println(output);
 
      // just a placeholder to sidestep java.lang.Object's toString() method
      return output;
    }
    
    
    
    /**
     * 
     * 
     * mutator to make the time display in toString() more user-friendly
     * 
     * 
     * 
     * */
    
    public String displayTime(String meetTimes) {
      // first converts meetTimes into an array
      String[] timesArray = meetTimes.split("-");
      int start = Integer.parseInt(timesArray[0]);
      int end = Integer.parseInt(timesArray[1]);
      // calls convertToTwelve method to format times
      String startTime = convertToTwelve(start);
      String endTime = convertToTwelve(end);
      return String.format("%s-%s", startTime, endTime);
      }
    
    /**
     * 
     * 
     * mutatorfunction that displayTime() depends on
     * convert start/end time to 12-hour clock
     * 
     * 
     * */
    public static String convertToTwelve(int time) {
      int hours = 0;
      int mins = time % 100;
      String sign = "";
      // getting hours and sign (AM/PM)
      int testCase = time / 100;
      if (testCase == 0) {
          hours = 12;
          sign = "AM";
      } else if (testCase < 12) {
          hours = testCase;
          sign = "AM";
      } else if (testCase == 12) {
          hours = 12;
          sign = "PM";
      } else {
          hours = testCase - 12;
          sign = "PM";
      }
      return String.format("%d:%d%s", hours, mins, sign);
    }
    
}
