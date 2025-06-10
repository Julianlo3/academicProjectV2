package co.edu.unicauca.academicproject.entities;


/**
 * @author lopez
 * @date 9/06/2025
 */
public class CreateProjectComment {
    private Long coordinatorCode;
    private String comment;

    public CreateProjectComment(Long coordinatorCode, String comment) {
        this.coordinatorCode = coordinatorCode;
        this.comment = comment;
    }

    // Getters y setters
    public Long getCoordinatorCode() {
        return coordinatorCode;
    }

    public void setCoordinatorCode(Long coordinatorCode) {
        this.coordinatorCode = coordinatorCode;
    }

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }
}
