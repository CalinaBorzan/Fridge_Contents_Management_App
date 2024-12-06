import java.util.ArrayList;
import java.util.List;

public class CourseSection {
    private Course course; // Many-to-one relationship with Course
    private List<Registration> registrationList; // One-to-many relationship with Registration

    private boolean open = false;
    private boolean closedOrCanceled = false;

    public CourseSection(Course course) {
        this.course = course;
        this.registrationList = new ArrayList<>();
    }

    // Get the class size
    private int getClassSize() {
        return registrationList.size();
    }

    // Determine state based on conditions
    public String getState() {
        if (closedOrCanceled) {
            if (getClassSize() == 0) {
                return "Canceled";
            } else {
                return "Closed";
            }
        } else if (open) {
            if (getClassSize() < course.getMinimum()) {
                return "OpenNotEnoughStudents";
            } else {
                return "OpenEnoughStudents";
            }
        } else {
            return "Planned";
        }
    }

    // Transition to 'Open' state
    public void openRegistration() {
        if (!closedOrCanceled) {
            open = true;
        }
    }

    // Transition to 'Closed' state
    public void closeRegistration() {
        if (open) {
            closedOrCanceled = true;
            open = false;
        }
    }

    // Transition to 'Canceled' state
    public void cancel() {
        if (!closedOrCanceled) {
            closedOrCanceled = true;
            registrationList.clear();
        }
    }

    // Handle request to register
    public boolean requestToRegister(Student student) {
        if (open && !closedOrCanceled) {
            // Check if the student meets the prerequisites
            if (student.hasPassedCourse(course.getPrerequisite())) {
                // Add to registration list
                Registration registration = new Registration(this, student);
                registrationList.add(registration);
                return true;
            }
        }
        return false;
    }
}